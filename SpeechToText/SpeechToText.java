package speechtotext;

import callenderframing.mypanels.SchedulePanel1;
import static callenderframing.mypanels.SchedulePanel1.jLabel4;
import static callenderframing.mypanels.SchedulePanel1.jLabel6;
import static callenderframing.mypanels.SchedulePanel1.jLabel7;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Port;

import edu.cmu.sphinx.api.Configuration;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.result.WordResult;
import javax.swing.JOptionPane;
import speechrecognition.SpeechRecognizerMain;
import speechschedulerprogram.AllProgramList;
import tts.TextToSpeech;

public class SpeechToText {
	TextToSpeech talk=new TextToSpeech();
	// Necessary
	private LiveSpeechRecognizer recognizer;
	
	// Logger
	private Logger logger = Logger.getLogger(getClass().getName());
	
	/**
	 * This String contains the Result that is coming back from SpeechRecognizer
	 */
	private String speechRecognitionResult;
	
	//-----------------Lock Variables-----------------------------
	
	/**
	 * This variable is used to ignore the results of speech recognition cause actually it can't be stopped...
	 * 
	 * <br>
	 * Check this link for more information: <a href=
	 * "https://sourceforge.net/p/cmusphinx/discussion/sphinx4/thread/3875fc39/">https://sourceforge.net/p/cmusphinx/discussion/sphinx4/thread/3875fc39/</a>
	 */
	private boolean ignoreSpeechRecognitionResults = false;
	
	/**
	 * Checks if the speech recognise is already running
	 */
	private boolean speechRecognizerThreadRunning = false;
	
	/**
	 * Checks if the resources Thread is already running
	 */
	private boolean resourcesThreadRunning;
	
	//---
	
	/**
	 * This executor service is used in order the playerState events to be executed in an order
	 */
	private ExecutorService eventsExecutorService = Executors.newFixedThreadPool(2);
	
	//------------------------------------------------------------------------------------
	
	/**
	 * Constructor
	 */
	public SpeechToText() {
		
		// Loading Message
		logger.log(Level.INFO, "Loading Speech Recognizer...\n");
		
		// Configuration
		Configuration configuration = new Configuration();
		
		// Load model from the jar
		configuration.setAcousticModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us");
		configuration.setDictionaryPath("resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict");
		
		//====================================================================================
		//=====================READ THIS!!!===============================================
		//Uncomment this line of code if you want the recognizer to recognize every word of the language 
		//you are using , here it is English for example	
		//====================================================================================
		//configuration.setLanguageModelPath("resource:/edu/cmu/sphinx/models/en-us/en-us.lm.bin");
		
		//====================================================================================
		//=====================READ THIS!!!===============================================
		//If you don't want to use a grammar file comment below 3 lines and uncomment the above line for language model	
		//====================================================================================
		
		// Grammar
		configuration.setGrammarPath("resource:/grammars");
		configuration.setGrammarName("SpeechToText");
		configuration.setUseGrammar(true);
		
		try {
			recognizer = new LiveSpeechRecognizer(configuration);
		} catch (IOException ex) {
			logger.log(Level.SEVERE, null, ex);
		}
		
		// Start recognition process pruning previously cached data.
		// recognizer.startRecognition(true);
		
		//Check if needed resources are available
		startResourcesThread();
		//Start speech recognition thread
		startSpeechRecognition();
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Starts the Speech Recognition Thread
	 */
	public synchronized void startSpeechRecognition() {
		
		//Check lock
		if (speechRecognizerThreadRunning)
			logger.log(Level.INFO, "Speech Recognition Thread already running...\n");
		else
			//Submit to ExecutorService
			eventsExecutorService.submit(() -> {
				
				//locks
				speechRecognizerThreadRunning = true;
				ignoreSpeechRecognitionResults = false;
				
				//Start Recognition
				recognizer.startRecognition(true);
				
				//Information			
				logger.log(Level.INFO, "You can start to speak...\n");
				
				try {
					while (speechRecognizerThreadRunning) {
						/*
						 * This method will return when the end of speech is reached. Note that the end pointer will determine the end of speech.
						 */
						SpeechResult speechResult = recognizer.getResult();
						
						//Check if we ignore the speech recognition results
						if (!ignoreSpeechRecognitionResults) {
							
							//Check the result
							if (speechResult == null)
								logger.log(Level.INFO, "I can't understand what you said.\n");
							else {
								
								//Get the hypothesis
								speechRecognitionResult = speechResult.getHypothesis();
								
								//You said?
								System.out.println("You said: [" + speechRecognitionResult + "]\n");
								
								//Call the appropriate method 
								makeDecision(speechRecognitionResult, speechResult.getWords());
								
							}
						} else
							logger.log(Level.INFO, "Ingoring Speech Recognition Results...");
						
					}
				} catch (Exception ex) {
					logger.log(Level.WARNING, null, ex);
					speechRecognizerThreadRunning = false;
				}
				
				logger.log(Level.INFO, "SpeechThread has exited...");
				
			});
	}
	
	/**
	 * Stops ignoring the results of SpeechRecognition
	 */
	public synchronized void stopIgnoreSpeechRecognitionResults() {
		
		//Stop ignoring speech recognition results
		ignoreSpeechRecognitionResults = false;
	}
	
	/**
	 * Ignores the results of SpeechRecognition
	 */
	public synchronized void ignoreSpeechRecognitionResults() {
		
		//Instead of stopping the speech recognition we are ignoring it's results
		ignoreSpeechRecognitionResults = true;
		
	}
	
	//-----------------------------------------------------------------------------------------------
	
	/**
	 * Starting a Thread that checks if the resources needed to the SpeechRecognition library are available
	 */
	public void startResourcesThread() {
		
		//Check lock
		if (resourcesThreadRunning)
			logger.log(Level.INFO, "Resources Thread already running...\n");
		else
			//Submit to ExecutorService
			eventsExecutorService.submit(() -> {
				try {
					
					//Lock
					resourcesThreadRunning = true;
					
					// Detect if the microphone is available
					while (true) {
						
						//Is the Microphone Available
						if (!AudioSystem.isLineSupported(Port.Info.MICROPHONE))
							logger.log(Level.INFO, "Microphone is not available.\n");
						
						// Sleep some period
						Thread.sleep(350);
					}
					
				} catch (InterruptedException ex) {
					logger.log(Level.WARNING, null, ex);
					resourcesThreadRunning = false;
				}
			});
	}
	
	/**
	 * Takes a decision based on the given result
	 * 
	 * @param speechWords
	 */
	public void makeDecision(String speech , List<WordResult> speechWords) {
		String zero=String.valueOf(0);
            if(speech.equalsIgnoreCase("set hours to zero")){
                SchedulePanel1.jLabel4.setText(zero);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }
            else if(speech.equalsIgnoreCase("set hours to one")){
                SchedulePanel1.jLabel4.setText(""+1);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
                
            }
            else if(speech.equalsIgnoreCase("set hours to two ")){
                SchedulePanel1.jLabel4.setText(""+2);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }
            else if(speech.equalsIgnoreCase("set hours to three ")){
                SchedulePanel1.jLabel4.setText(""+3);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }
            else if(speech.equalsIgnoreCase("set hours to four ")){
                SchedulePanel1.jLabel4.setText(""+4);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }
            else if(speech.equalsIgnoreCase("set hours to five ")){
                SchedulePanel1.jLabel4.setText(""+5);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to six ")){
                SchedulePanel1.jLabel4.setText(""+6);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to seven ")){
                SchedulePanel1.jLabel4.setText(""+7);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to eight ")){
                SchedulePanel1.jLabel4.setText(""+8);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }
            else if(speech.equalsIgnoreCase("set hours to nine ")){
                SchedulePanel1.jLabel4.setText(""+9);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to ten ")){
                SchedulePanel1.jLabel4.setText(""+10);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to eleven ")){
                SchedulePanel1.jLabel4.setText(""+11);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to twelve ")){
                SchedulePanel1.jLabel4.setText(""+12);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to thirteen ")){
                SchedulePanel1.jLabel4.setText(""+13);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }
            else if(speech.equalsIgnoreCase("set hours to fourteen ")){
                SchedulePanel1.jLabel4.setText(""+14);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }
            else if (speech.equalsIgnoreCase("set hours to fifteen ")) {
                SchedulePanel1.jLabel4.setText("" +15);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }
            else if(speech.equalsIgnoreCase("set hours to sixteen ")){
                SchedulePanel1.jLabel4.setText(""+16);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to seventeen ")){
                SchedulePanel1.jLabel4.setText(""+17);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to eighteen ")){
                SchedulePanel1.jLabel4.setText(""+18);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            } else if(speech.equalsIgnoreCase("set hours to nineteen ")){
                SchedulePanel1.jLabel4.setText(""+19);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to twenty ")){
                SchedulePanel1.jLabel4.setText(""+20);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to twenty one ")){
                SchedulePanel1.jLabel4.setText(""+21);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to twenty two ")){
                SchedulePanel1.jLabel4.setText(""+22);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to twenty three ")){
                SchedulePanel1.jLabel4.setText(""+23);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set hours to twenty four ")){
                SchedulePanel1.jLabel4.setText(""+24);
                SchedulePanel1. hrs=Integer.parseInt(jLabel4.getText());
            }else if(speech.equalsIgnoreCase("set minute to zero ")){
                SchedulePanel1.jLabel6.setText(""+0);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to one ")){
                SchedulePanel1.jLabel6.setText(""+1);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to two ")){
                SchedulePanel1.jLabel6.setText(""+2);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to three ")){
                SchedulePanel1.jLabel6.setText(""+3);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to four ")){
                SchedulePanel1.jLabel6.setText(""+4);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to five ")){
                SchedulePanel1.jLabel6.setText(""+5);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to six ")){
                SchedulePanel1.jLabel6.setText(""+6);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to seven ")){
                SchedulePanel1.jLabel6.setText(""+7);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to eight ")){
                SchedulePanel1.jLabel6.setText(""+8);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to nine ")){
                SchedulePanel1.jLabel6.setText(""+9);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to ten ")){
                SchedulePanel1.jLabel6.setText(""+10);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to eleven ")){
                SchedulePanel1.jLabel6.setText(""+11);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to twelve ")){
                SchedulePanel1.jLabel6.setText(""+12);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to thirteen ")){
                SchedulePanel1.jLabel6.setText(""+13);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fourteen ")){
                SchedulePanel1.jLabel6.setText(""+14);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fifteen ")){
                SchedulePanel1.jLabel6.setText(""+15);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to sixteen ")){
                SchedulePanel1.jLabel6.setText(""+16);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to seventeen ")){
                SchedulePanel1.jLabel6.setText(""+17);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to eighteen ")){
                SchedulePanel1.jLabel6.setText(""+18);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute tonineteen ")){
                SchedulePanel1.jLabel6.setText(""+19);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute totwenty ")){
                SchedulePanel1.jLabel6.setText(""+20);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to twenty one ")){
                SchedulePanel1.jLabel6.setText(""+21);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to twenty two ")){
                SchedulePanel1.jLabel6.setText(""+22);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to twenty three ")){
                SchedulePanel1.jLabel6.setText(""+23);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to twenty four ")){              
                SchedulePanel1.jLabel6.setText(""+24);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to twenty five ")){
                SchedulePanel1.jLabel6.setText(""+25);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to twenty six ")){
                SchedulePanel1.jLabel6.setText(""+26);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to twenty seven ")){
                SchedulePanel1.jLabel6.setText(""+27);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to twenty eight ")){
                SchedulePanel1.jLabel6.setText(""+28); 
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
                
            }else if(speech.equalsIgnoreCase("set minute to twenty nine ")){
                SchedulePanel1.jLabel6.setText(""+29);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to thirty ")){
                SchedulePanel1.jLabel6.setText(""+30);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to thirty one ")){
                SchedulePanel1.jLabel6.setText(""+31);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to thirty two ")){
                SchedulePanel1.jLabel6.setText(""+32);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to thirty three ")){
                SchedulePanel1.jLabel6.setText(""+33);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to thirty four ")){
                SchedulePanel1.jLabel6.setText(""+34);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to thirty five ")){
                SchedulePanel1.jLabel6.setText(""+35);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to thirty six ")){
                SchedulePanel1.jLabel6.setText(""+36);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to thirty seven ")){
                SchedulePanel1.jLabel6.setText(""+37);
                SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to thirty eight ")){
                SchedulePanel1.jLabel6.setText(""+38);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to thirty nine ")){
                SchedulePanel1.jLabel6.setText(""+39);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fourty ")){
                SchedulePanel1.jLabel6.setText(""+40);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fourty one ")){
                SchedulePanel1.jLabel6.setText(""+41);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fourty two ")){
                SchedulePanel1.jLabel6.setText(""+42);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fourty three ")){
                SchedulePanel1.jLabel6.setText(""+43);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fourty four ")){
                SchedulePanel1.jLabel6.setText(""+44);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fourty five ")){
                SchedulePanel1.jLabel6.setText(""+45);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fourty six ")){
                SchedulePanel1.jLabel6.setText(""+46);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fourty seven ")){
                SchedulePanel1.jLabel6.setText(""+47);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fourty eight ")){
                SchedulePanel1.jLabel6.setText(""+48);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fourty nine ")){
                SchedulePanel1.jLabel6.setText(""+49);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fifty ")){
                SchedulePanel1.jLabel6.setText(""+50);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fifty one ")){
                SchedulePanel1.jLabel6.setText(""+51);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fifty two ")){
                SchedulePanel1.jLabel6.setText(""+52);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fifty three ")){
                SchedulePanel1.jLabel6.setText(""+53);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fifty four ")){
                SchedulePanel1.jLabel6.setText(""+54);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fifty five ")){
                SchedulePanel1.jLabel6.setText(""+55);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fifty six ")){
                SchedulePanel1.jLabel6.setText(""+56);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fifty seven ")){
                SchedulePanel1.jLabel6.setText(""+57);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fifty eight ")){
                SchedulePanel1.jLabel6.setText(""+58);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to fifty nine ")){
                SchedulePanel1.jLabel6.setText(""+59);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set minute to sixty ")){
                SchedulePanel1.jLabel6.setText(""+60);
                 SchedulePanel1.min=Integer.parseInt(jLabel6.getText());
            }else if(speech.equalsIgnoreCase("set seconds to zero")){
                SchedulePanel1.jLabel7.setText(""+0);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText()); 
            }else if(speech.equalsIgnoreCase("set seconds to one")){
                SchedulePanel1.jLabel7.setText(""+1);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText()); 
            }else if(speech.equalsIgnoreCase("set seconds to two")){
                SchedulePanel1.jLabel7.setText(""+2);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to three")){
                SchedulePanel1.jLabel7.setText(""+3);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to four")){
                SchedulePanel1.jLabel7.setText(""+4);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to five")){
                SchedulePanel1.jLabel7.setText(""+5);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to six ")){
                SchedulePanel1.jLabel7.setText(""+6);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to seven ")){
                SchedulePanel1.jLabel7.setText(""+7);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to eight ")){
                SchedulePanel1.jLabel7.setText(""+8);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to nine ")){
                SchedulePanel1.jLabel7.setText(""+9);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to ten ")){
                SchedulePanel1.jLabel7.setText(""+10);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to eleven ")){
                SchedulePanel1.jLabel7.setText(""+11);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to twelve ")){
                SchedulePanel1.jLabel7.setText(""+12);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to thirteen ")){
                SchedulePanel1.jLabel7.setText(""+13);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fourteen ")){
                SchedulePanel1.jLabel7.setText(""+14);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fifteen ")){
                SchedulePanel1.jLabel7.setText(""+15);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to sixteen ")){
                SchedulePanel1.jLabel7.setText(""+16);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to seventeen ")){
                SchedulePanel1.jLabel7.setText(""+17);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to eighteen ")){
                SchedulePanel1.jLabel7.setText(""+18);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to nineteen ")){
                SchedulePanel1.jLabel7.setText(""+19);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to twenty ")){
                SchedulePanel1.jLabel7.setText(""+20);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to twenty one ")){
                SchedulePanel1.jLabel7.setText(""+21);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to twenty two ")){
                SchedulePanel1.jLabel7.setText(""+22);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to twenty three ")){
                SchedulePanel1.jLabel7.setText(""+23);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to twenty four ")){
                SchedulePanel1.jLabel7.setText(""+24);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to twenty five ")){
                SchedulePanel1.jLabel7.setText(""+25);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to twenty six ")){
                SchedulePanel1.jLabel7.setText(""+26);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to twenty seven ")){
                SchedulePanel1.jLabel7.setText(""+27);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to twenty eight ")){
                SchedulePanel1.jLabel7.setText(""+28);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to twenty nine")){
                SchedulePanel1.jLabel7.setText(""+29);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to thirty ")){
                SchedulePanel1.jLabel7.setText(""+30);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to thirty one ")){
                SchedulePanel1.jLabel7.setText(""+31);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to thirty two ")){
                SchedulePanel1.jLabel7.setText(""+32);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to thirty three ")){
                SchedulePanel1.jLabel7.setText(""+33);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to thirty four ")){
                SchedulePanel1.jLabel7.setText(""+34);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to thirty five ")){
                SchedulePanel1.jLabel7.setText(""+35);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to thirty six ")){
                SchedulePanel1.jLabel7.setText(""+36);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to thirty seven ")){
                SchedulePanel1.jLabel7.setText(""+37);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to thirty eight ")){
                SchedulePanel1.jLabel7.setText(""+38);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to thirty nine ")){
                SchedulePanel1.jLabel7.setText(""+39);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fourty ")){
                SchedulePanel1.jLabel7.setText(""+40);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fourty one ")){
                SchedulePanel1.jLabel7.setText(""+41);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fourty two ")){
                SchedulePanel1.jLabel7.setText(""+42);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fourty three ")){
                SchedulePanel1.jLabel7.setText(""+43);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fourty four ")){
                SchedulePanel1.jLabel7.setText(""+44);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fourty five ")){
                SchedulePanel1.jLabel7.setText(""+45);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fourty six ")){
                SchedulePanel1.jLabel7.setText(""+46);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fourty seven ")){
                SchedulePanel1.jLabel7.setText(""+47);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fourty eight ")){
                SchedulePanel1.jLabel7.setText(""+48);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fourty nine ")){
                SchedulePanel1.jLabel7.setText(""+49);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fifty ")){
                SchedulePanel1.jLabel7.setText(""+50);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fifty one ")){
                SchedulePanel1.jLabel7.setText(""+51);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fifty two ")){
                SchedulePanel1.jLabel7.setText(""+52);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fifty three ")){
                SchedulePanel1.jLabel7.setText(""+53);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fifty four ")){
                SchedulePanel1.jLabel7.setText(""+54);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fifty five ")){
                SchedulePanel1.jLabel7.setText(""+55);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fifty six ")){
                SchedulePanel1.jLabel7.setText(""+56);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fifty seven ")){
                SchedulePanel1.jLabel7.setText(""+57);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fifty eight")){
                SchedulePanel1.jLabel7.setText(""+58);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to fifty nine ")){
                SchedulePanel1.jLabel7.setText(""+59);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set seconds to sixty ")){
                SchedulePanel1.jLabel7.setText(""+60);
                SchedulePanel1.sec=Integer.parseInt(jLabel7.getText());
            }else if(speech.equalsIgnoreCase("set")){
                SchedulePanel1.jButton1.doClick();
            }
            else if(speech.equalsIgnoreCase("speech recognise complete"))
 		    {
 				try{
                                   talk.speak("thank you for using the speech recognizer program",1.5f,false,true);
 					JOptionPane.showMessageDialog(null,"Thanks for using this Program!!!");
 					 AllProgramList.getObj().setVisible(false);
                                        System.exit(0);
                                                    }
 				catch(Exception ecomp ){}
 		    } else if(speech.equalsIgnoreCase("activate recognise one"))
 		    {
 				try{
                                   talk.speak("Activating recognition one",1.5f,false,true);
 					//JOptionPane.showMessageDialog(null,"Thanks for using this Program!!!");
 					recognizer.stopRecognition();
                                        SpeechRecognizerMain show=new SpeechRecognizerMain();
                                                    }
 				catch(Exception ecomp ){}
 		    }
 			else if(speech.equalsIgnoreCase("speech recognise start"))
 		    {
 				try{
 					talk.speak("Program is opening again",1.5f,true,false);
 					recognizer.notify();
 					
 					System.exit(0);}
 				catch(Exception estart ){}
 		    }
 			else if(speech.equalsIgnoreCase("stop recognise"))
 		    {
 				try{
 					
 					recognizer.wait();
 					talk.speak("We wait for more of you",1.5f,true,false);
 					System.exit(0);}
 				catch(Exception estop ){}
 		    }else if(speech.equalsIgnoreCase("clear timer")){
                        String number=String.valueOf(00);
                            SchedulePanel1.timer.stop();
                            SchedulePanel1.jLabel4.setText(number);
                              SchedulePanel1.jLabel6.setText(number);
                              SchedulePanel1.jLabel7.setText(number);
                    }else if (speech.contains("change to voice one")) {
			talk.setVoice("cmu-slt-hsmm");
			talk.speak("Done", 1.5f, false, true);
			return;
		} else if (speech.contains("change to voice two")) {
			talk.setVoice("dfki-poppy-hsmm");
			talk.speak("Done", 1.5f, false, true);
		} else if (speech.contains("change to voice three")) {
			talk.setVoice("cmu-rms-hsmm");
			talk.speak("Done", 1.5f, false, true);
		}
                    
            
	}
	
	public boolean getIgnoreSpeechRecognitionResults() {
		return ignoreSpeechRecognitionResults;
	}
	
	public boolean getSpeechRecognizerThreadRunning() {
		return speechRecognizerThreadRunning;
	}
	
	/**
	 * Main Method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new SpeechToText();
	}
}
