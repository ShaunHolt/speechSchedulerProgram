package speechrecognition;

import callenderframing.mypanels.ScheduleInternal;
import callenderframing.SchedulerCalPage;
import callenderframing.mypanels.ToDoList;
import javaclasses.SettingWallPaper;
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
import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javaclasses.WallValidity;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import notemakemenu.NoteMaker;
import pcactivitiesturnup.PcMonitorsAndControls;
import sendsms.NewJFrame;
import socialmedia.SocialMediasFrame;
import speechschedulerprogram.AllProgramList;
import speechschedulerprogram.ChangeWallpaper;
import static speechschedulerprogram.ChangeWallpaper.jLabel1;
import speechschedulerprogram.LoginForm;
import speechschedulerprogram.LoginPage;
import speechschedulerprogram.SignUpPage;
import speechtotext.SpeechToText;
import tts.TextToSpeech;

public class SpeechRecognizerMain {
	TextToSpeech speech=new TextToSpeech();
        
         SettingWallPaper s=new SettingWallPaper();
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
	public SpeechRecognizerMain() {
		
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
		configuration.setGrammarName("grammar");
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
                                JOptionPane.showMessageDialog(null,"all Libraries have finshed loading you can start to speak now");
				
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
							logger.log(Level.INFO, "Ingoing Speech Recognition Results...");
						
					}
				} catch (Exception ex) {
					logger.log(Level.WARNING, null, ex);
					speechRecognizerThreadRunning = false;
				}
				
				logger.log(Level.INFO, "SpeechThread has exited...");
                                JOptionPane.showMessageDialog(null,"SpeechThread has exited and please restart the application to run the program again");
				
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
//                                                JOptionPane.showMessageDialog(null,"Note!!!,Your system either doesnt support the use of microphone of it is not available\n"
//                                                        + "please upgrade your system specifications and rerun the application");
//						
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
	public void makeDecision(String resultText , List<WordResult> speechWords) {
           
	 if(resultText.equalsIgnoreCase("command"))
 			{
 				try{
 				Process p;
 				//resultText="";
 				p = Runtime.getRuntime().exec("cmd /c start cmd");
 				//System.out.println("You said");
 				
 				 //resultText = result.getBestFinalResultNoFiller();
 				//System.out.println("You said: " + resultText + "\n");
 				
 				}catch(Exception er)
 				{}
 			}if (resultText.equalsIgnoreCase("close command"))
 		    {
 		        try{
                            
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im cmd.exe /f");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("open Power Options"))
 		    {
 		        try{
                            speech.speak("Power options is starting",1.5f,true,false);
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c powercfg.cpl");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("Blue"))
 		    {
 		        try{
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c fsquirt");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("start photo shop"))
 		    {
 		        try{
                            speech.speak("photo shop is starting",1.5f,true,false);
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start photoshop");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("open calculator"))
 		    {
                        speech.speak("Calculator is starting",1.5f,true,false);
 		        try{
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start calc");
 		     
 		        }catch(Exception ae){}
 		    }
 			if (resultText.equalsIgnoreCase("open Windows Security Center"))
 		    {
 		        try{
                            speech.speak("windows security is starting",1.5f,true,false);
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c wscui.cpl");
 		     
 		        }catch(Exception ae){}
 		    }
 			else if (resultText.equalsIgnoreCase("open Player"))
 		    {
 		        try{
                            speech.speak("player is starting",1.5f,true,false);
 		        Process p;
 		    	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start wmplayer");
 		        }catch(Exception ae){}
 		    }
 			else  if (resultText.equalsIgnoreCase("open Program"))
 		    {
 		        try{
                            speech.speak("Program is starting",1.5f,true,false);
 		        Process p;
 		    	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start appwiz.cpl");
 		        }catch(Exception ae){}
 		    }
 			 else if (resultText.equalsIgnoreCase("open Control"))
 			    {
 			        try{
                                    speech.speak("control options is starting",1.5f,true,false);
 			        Process p;
 			    //	resultText="";
 			        p = Runtime.getRuntime().exec("cmd /c control");
 			        }catch(Exception ae){}
 			    }
 			else if(resultText.equalsIgnoreCase("open paint"))
 			{	 try{
                            speech.speak("paint is starting",1.5f,true,false);
 				        Process p;
 				    	//resultText="";
 				        p = Runtime.getRuntime().exec("cmd /c start mspaint");
 				       // System.out.println("inside");
 				        }catch(Exception ae){}
 			}
 			else if(resultText.equalsIgnoreCase("close paint"))
 			{	 try{
 		        Process p;
 		    	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im mspaint.exe /f");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 			}
 			else if(resultText.equalsIgnoreCase("close calculator"))
 			{	 try{
 		        Process p;
 		    	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im calc.exe /f");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 	}
 			else if (resultText.equalsIgnoreCase("open browser"))
 		    {
 		        try{
                            speech.speak("browser is starting",1.5f,true,false);
 		        Process p;//	resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start chrome.exe");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
                        
 		     }else if (resultText.equalsIgnoreCase("close Browser"))
 			    {
 			        try{
 			        Process p;//	resultText="";
 			        p = Runtime.getRuntime().exec("cmd /c start taskkill /im chrome.exe /f");
 			       // System.out.println("inside");
 			        }catch(Exception ae){}
 			     }
 			
 			else if(resultText.equalsIgnoreCase("open task manager"))
 				{	 try{
                                    speech.speak("task manager is starting",1.5f,true,false);
 			        Process p;
 			    	//resultText="";
 			        p = Runtime.getRuntime().exec("cmd /c start taskmgr.exe");
 			       // System.out.println("inside");
 			        }catch(Exception ae){}
 				}
 			else if(resultText.equalsIgnoreCase("open Adobe"))
 			{	 try{
                            speech.speak("adobe is starting",1.5f,true,false);
 		        Process p;
 		    	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start acrord32.exe");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 			}
 			else if(resultText.equalsIgnoreCase("open face book"))
 			{	 try{
                            speech.speak("face book is opening",1.5f,true,false);
 		        Process p;
 		    	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start chrome www.facebook.com");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 			}
 			else if(resultText.equalsIgnoreCase("open search site"))
 			{	 try{
                            speech.speak("program is starting browser to search to google",1.5f,true,false);
 		        Process p;
 		    	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start chrome www.google.com");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 			}
 			else if(resultText.equalsIgnoreCase("open mail"))
 			{	 try{
                            speech.speak("your google mail is opening",1.5f,true,false);
 		        Process p;
 		    	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start chrome https://mail.google.com");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 			}
 		     else if(resultText.equalsIgnoreCase("close task manager"))
 				{	 try{
 			        Process p;
 			    	//resultText="";
 			        p = Runtime.getRuntime().exec("cmd /c start taskkill /im taskmgr.exe /f");
 			       // System.out.println("inside");
 			        }catch(Exception ae){}
 		}
 			else if (resultText.equalsIgnoreCase("open note pad"))
 		    {
 		        try{
                            speech.speak("note pad is starting",1.5f,true,false);
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start notepad");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("close note pad"))
 		    {
 		        try{
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im notepad.exe /f");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("open word"))
 		    {
 		        try{
                            speech.speak("word is starting",1.5f,true,false);
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start winword");
 		       // System.out.println("inside");
                       speech.speak("word already open",1.5f,true,false);
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("close word"))
 		    {
 		        try{
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im winword.exe /f");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("open word pad"))
 		    {
 		        try{
                            speech.speak("word pad is opening",1.5f,true,false);
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c  write");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("close word pad"))
 		    {
 		        try{
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c  start taskkill /im wordpad.exe /f");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 		     }
 			
 			else if (resultText.equalsIgnoreCase("start Excel"))
 		    {
 		        try{
                            speech.speak("excel is starting",1.5f,true,false);
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start excel");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 		     }else if (resultText.equalsIgnoreCase("stop Excel"))
 			    {
 			        try{
 			        Process p;	//resultText="";
 			        p = Runtime.getRuntime().exec("cmd /c start taskkill /im excel.exe /f");
 			       // System.out.println("inside");
 			        }catch(Exception ae){}
 			     }
 			else if (resultText.equalsIgnoreCase("start firewall"))
 		    {
 		        try{
                            speech.speak("firewall is starting",1.5f,true,false);
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start firewall.cpl");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("close firewall"))
 		    {
 		        try{
 		        Process p;	//resultText="";
 		        String status = "status eq Windows Firewall";
 		        p = Runtime.getRuntime().exec("cmd /c taskkill /f /fi " +status );
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("start nero"))
 		    {
 		        try{
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start nero");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("open Access"))
 		    {
 		        try{
                            speech.speak("Access is opening",1.5f,true,false);
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start msaccess");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 		     }
 			else if (resultText.equalsIgnoreCase("close access"))
 		    {
 		        try{
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start taskkill /im msaccess.exe /f");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
 		     }
 			else if(resultText.equalsIgnoreCase("speech recognise complete"))
 		    {
 				try{
                                   speech.speak("thank you for using the speech recognizer program",1.5f,false,true);
 					JOptionPane.showMessageDialog(null,"Thanks for using this Program!!!");
 					AllProgramList.getObj().setVisible(false);
 					System.exit(0);}
 				catch(Exception ecomp ){}
 		    }
 			else if(resultText.equalsIgnoreCase("speech recognise start"))
 		    {
 				try{
 					speech.speak("Program is opening again",1.5f,true,false);
 					recognizer.notify();
 					
 					System.exit(0);}
 				catch(Exception estart ){}
 		    }
 			else if(resultText.equalsIgnoreCase("stop recognise"))
 		    {
 				try{
 					
 					recognizer.wait();
 					speech.speak("We wait for more of you",1.5f,true,false);
 					System.exit(0);}
 				catch(Exception estop ){}
 		    }
                        else if(resultText.equalsIgnoreCase("cane")){
                            speech.speak("yes what can i do for you",1.5f,true,false);
                        }
 			else if (resultText.equalsIgnoreCase("Device Manager"))
 			    {
                                speech.speak("device manager is starting",1.5f,true,false);
 			        try{
 			        Process p;	//resultText="";
 			        p = Runtime.getRuntime().exec("cmd /c start devmgmt.msc");
 			       // System.out.println("inside");
 			        }catch(Exception ae){}
 			     }
                        else if(resultText.equalsIgnoreCase("restart system")){
                         try{
                             speech.speak("computer will restart now",1.5f,true,false);
            Process p;
                    p=Runtime.getRuntime().exec("shutdown -r");

            }catch(Exception ex){

            }
                        }else if(resultText.equalsIgnoreCase("Activate recogniser two"))
 		    {
 				try{
                                   speech.speak("Activating recogniser two",1.5f,false,true);
 					//JOptionPane.showMessageDialog(null,"Thanks for using this Program!!!");
 					recognizer.stopRecognition();
                                        SpeechToText show=new SpeechToText();
                                                    }
 				catch(Exception ecomp ){}
 		    }
                        else if(resultText.equalsIgnoreCase("hibernate system")){
                         try{
                             speech.speak("system is hibernating",1.5f,true,false);
            Process p;
                    p=Runtime.getRuntime().exec("shutdown -h");

            }catch(Exception ex){

            }
                        }else if (resultText.contains("change to voice one")) {
			speech.setVoice("cmu-slt-hsmm");
			speech.speak("Done", 1.5f, false, true);
			return;
		} else if (resultText.contains("change to voice two")) {
			speech.setVoice("dfki-poppy-hsmm");
			speech.speak("Done", 1.5f, false, true);
		} else if (resultText.contains("change to voice three")) {
			speech.setVoice("cmu-rms-hsmm");
			speech.speak("Done", 1.5f, false, true);
		}
                        else if(resultText.equalsIgnoreCase("shutdown system")){
                         try{
                             speech.speak("computer will shut down now",1.5f,true,false);
            Process p;
                    p=Runtime.getRuntime().exec("shutdown -s");

            }catch(Exception ex){

            }
                        }
                        else if(resultText.equalsIgnoreCase("change user")){
                         try{
                             speech.speak("system will log off now",1.5f,true,false);
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("command /c start logoff");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}

            }
                        
                        else if(resultText.equalsIgnoreCase("open power options")){
                        try{
                            speech.speak("power options is starting",1.5f,true,false);
                            Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec(" shutdown -i");
 		       // System.out.println("inside");
                        
 		        }catch(Exception ae){}
        }
                         else if(resultText.equalsIgnoreCase("open control desktop options")){
                        try{
                            speech.speak("control desktop options is starting",1.5f,true,false);
                            
 		        Process p;	//resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start control desktop");
 		       // System.out.println("inside");
 		        }catch(Exception ae){}
                        
                         }
                         else if(resultText.equalsIgnoreCase("open Date settings")){
                         try{
                             speech.speak("date settings is opening",1.5f,true,false);
 		        Process p = null;	//resultText="";
                       
 		        p = Runtime.getRuntime().exec("cmd /c start timedate.cpl");
 		       // System.out.println("inside");
 		       
                                speech.speak("Date settings is already open",1.5f,true,false);
                           
                         }catch(Exception ae){}
                         }
                         else if(resultText.equalsIgnoreCase("open activity schedule")){
                             if(LoginForm.getObj().isVisible()){
                                 speech.speak("please login to make this command effective",1.5f,true,false);
                             }
                             else if(!LoginPage.getObj().isVisible()){
                             
                             try{
                           if( SchedulerCalPage.getObj().isVisible()){
                           speech.speak("Daily scheduler is already opened",1.5f,false,true);
                           }else{
                             speech.speak("Scheduler menu is opening",1.5f,true,false);
                           SchedulerCalPage.getObj().setVisible(true); 
                           SettingWallPaper s=new SettingWallPaper();
                                if(s.Readwallpaper().equals("wall1")){
            try {
                File f=new File("picturesdownloaded/background3.jpg");
                System.out.println(f.getCanonicalPath()+" "+f.exists());
                URL url;
                url = getClass().getResource("/background3.jpg");
                ImageIcon i=new ImageIcon(url);
                SchedulerCalPage.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(s.Readwallpaper().equals("wall2")){
            try {
                File f=new File("picturesdownloaded/background4.jpg");
                System.out.println(f.getCanonicalPath()+" "+f.exists());
                URL url=getClass().getResource("/background4.jpg");
                ImageIcon i=new ImageIcon(url);
                SchedulerCalPage.jLabel1.setIcon(i);
                
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall3")){
            try {
                File f=new File("picturesdownloaded/background.jpeg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=getClass().getResource("/background.jpeg");
                ImageIcon i=new ImageIcon(url);
                SchedulerCalPage.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall4")){
            try {
                File f=new File("picturesdownloaded/background2.jpeg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                ImageIcon i=new ImageIcon(getClass().getResource("/picturesdownloaded/background2.jpeg"));
                SchedulerCalPage.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall5")){
            try {
                File f=new File("picturesdownloaded/background5.jpg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=Class.class.getResource("/background5.jpg");
                ImageIcon i=new ImageIcon(url);
                SchedulerCalPage.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        }
         else if(s.Readwallpaper().equals("wall6")){
            try {
                File f=new File("picturesdownloaded/NewLayer.jpg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=Class.class.getResource("/NewLayer.jpg");
                ImageIcon i=new ImageIcon(url);
                SchedulerCalPage.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                         }
                             }catch(Exception ex){}
                         }
                         }
                             
                         else if(resultText.equalsIgnoreCase("close activity schedule")){
                             if(LoginForm.getObj().isVisible()){
                              speech.speak("please login to make this command effective",1.5f,true,false);
                             }
                             else if(!LoginForm.getObj().isVisible()){
                           if( SchedulerCalPage.getObj().isVisible()){
                               SchedulerCalPage.getObj().setVisible(false);
                           }else{
                             speech.speak("Scheduler menu is not opened do you want the me to open this menu for you??",1.5f,true,false);
                             int response = JOptionPane.showConfirmDialog(null,"Do you really want to open the scheduler menu?","Open scheduler menu", JOptionPane.YES_NO_OPTION);
                                
                                if(response==0)
                                {
                                    // Do Nothing...t
                                     SchedulerCalPage.getObj().setVisible(true);
                                }
                                else if(response== 1)
                                {
                                }    
                                }
                                               
                         }
                         }
                         else if (resultText.equalsIgnoreCase("open events")){
                             if(!(SchedulerCalPage.getObj().isVisible())){
                           speech.speak("Scheduler menu is not opened sorry you cannot perform this action.",1.5f,true,false);
                             }else if(SchedulerCalPage.getObj().isVisible()){
                              ScheduleInternal.panel1.setVisible(true);
                          ScheduleInternal.panel2.setVisible(false);
                           ScheduleInternal.panel3.setVisible(false);
                             }
                            
                         }
                         else if(resultText.equalsIgnoreCase("open birthday reminder")){
                              if(!(SchedulerCalPage.getObj().isVisible())){
                          speech.speak("Scheduler menu is not opened sorry you cannot perform this action.",1.5f,true,false);
                              }else if(SchedulerCalPage.getObj().isVisible()){
                            ScheduleInternal.panel1.setVisible(false);
                          ScheduleInternal.panel2.setVisible(true);
                           ScheduleInternal.panel3.setVisible(false);
                              }
                         }
                         else if(resultText.equalsIgnoreCase("open to do list")){
                             if(!(SchedulerCalPage.getObj().isVisible())){
                             speech.speak("Scheduler menu is not opened sorry you cannot perform this action.",1.5f,true,false);
                             }else if(SchedulerCalPage.getObj().isVisible()){
                            ScheduleInternal.panel1.setVisible(false);
                          ScheduleInternal.panel2.setVisible(false);
                           ScheduleInternal.panel3.setVisible(true);
                             }
                         }
                         
                         else if(resultText.equalsIgnoreCase("change wallpaper")){
                             if(LoginForm.getObj().isVisible()){
                              speech.speak("please login to make this command effective",1.5f,true,false);
                             }
                             if(ChangeWallpaper.getObj().isVisible()){
                                speech.speak("Wallpaper is already opened",1.5f,false,true);
                            }
                            else{ 
                             speech.speak("Wall paper is opening",1.5f,true,false);
                             ChangeWallpaper.getObj().setVisible(true);
                            }
                         }
                         
                         else if(resultText.equalsIgnoreCase("open memo")){ 
                             if(LoginForm.getObj().isVisible()){
                              speech.speak("please login to make this command effective",1.5f,true,false);
                             }
                             if(NoteMaker.getObj().isVisible()){
                                 speech.speak("memo is already opened",1.5f,false,true);
                             }
                             else{
                                 speech.speak("memo is opening",1.5f,true,false);
                                 NoteMaker.getObj().setVisible(true);
                                  SettingWallPaper s=new SettingWallPaper();
                                    if(s.Readwallpaper().equals("wall1")){
            try {
                File f=new File("picturesdownloaded/background3.jpg");
                System.out.println(f.getCanonicalPath()+" "+f.exists());
                URL url;
                url = getClass().getResource("/background3.jpg");
                ImageIcon i=new ImageIcon(url);
                NoteMaker.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(s.Readwallpaper().equals("wall2")){
            try {
                File f=new File("picturesdownloaded/background4.jpg");
                System.out.println(f.getCanonicalPath()+" "+f.exists());
                URL url=getClass().getResource("/background4.jpg");
                ImageIcon i=new ImageIcon(url);
                NoteMaker.jLabel1.setIcon(i);
                
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall3")){
            try {
                File f=new File("picturesdownloaded/background.jpeg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=getClass().getResource("/background.jpeg");
                ImageIcon i=new ImageIcon(url);
                NoteMaker.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall4")){
            try {
                File f=new File("picturesdownloaded/background2.jpeg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                ImageIcon i=new ImageIcon(getClass().getResource("/picturesdownloaded/background2.jpeg"));
                NoteMaker.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall5")){
            try {
                File f=new File("picturesdownloaded/background5.jpg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=Class.class.getResource("/background5.jpg");
                ImageIcon i=new ImageIcon(url);
                NoteMaker.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        }
         else if(s.Readwallpaper().equals("wall6")){
            try {
                File f=new File("picturesdownloaded/NewLayer.jpg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=Class.class.getResource("/NewLayer.jpg");
                ImageIcon i=new ImageIcon(url);
                NoteMaker.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                             }
                         }
                         else if(resultText.equalsIgnoreCase("open computer functionality")){
                             if(LoginForm.getObj().isVisible()){
                              speech.speak("please login to make this command effective",1.5f,true,false);
                             }
                            if(PcMonitorsAndControls.getObj().isVisible()){
                            speech.speak("computer functionality is already opened",1.5f,false,true);
                            }
                            else{
                             speech.speak("computer functionality is starting",1.5f,true,false);
                             PcMonitorsAndControls.getObj().setVisible(true);
                               SettingWallPaper s=new SettingWallPaper();
                                if(s.Readwallpaper().equals("wall1")){
            try {
                File f=new File("picturesdownloaded/background3.jpg");
                System.out.println(f.getCanonicalPath()+" "+f.exists());
                URL url;
                url = getClass().getResource("/background3.jpg");
                ImageIcon i=new ImageIcon(url);
                PcMonitorsAndControls.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(s.Readwallpaper().equals("wall2")){
            try {
                File f=new File("picturesdownloaded/background4.jpg");
                System.out.println(f.getCanonicalPath()+" "+f.exists());
                URL url=getClass().getResource("/background4.jpg");
                ImageIcon i=new ImageIcon(url);
                PcMonitorsAndControls.jLabel1.setIcon(i);
                
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall3")){
            try {
                File f=new File("picturesdownloaded/background.jpeg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=getClass().getResource("/background.jpeg");
                ImageIcon i=new ImageIcon(url);
                PcMonitorsAndControls.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall4")){
            try {
                File f=new File("picturesdownloaded/background2.jpeg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                ImageIcon i=new ImageIcon(getClass().getResource("/picturesdownloaded/background2.jpeg"));
                PcMonitorsAndControls.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall5")){
            try {
                File f=new File("picturesdownloaded/background5.jpg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=Class.class.getResource("/background5.jpg");
                ImageIcon i=new ImageIcon(url);
                PcMonitorsAndControls.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        }
         else if(s.Readwallpaper().equals("wall6")){
            try {
                File f=new File("picturesdownloaded/NewLayer.jpg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=Class.class.getResource("/NewLayer.jpg");
                ImageIcon i=new ImageIcon(url);
                PcMonitorsAndControls.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                         }
                         }
                         else if(resultText.equalsIgnoreCase("send message")){
                             if(LoginForm.getObj().isVisible()){
                              speech.speak("please login to make this command effective",1.5f,true,false);
                             }
                             if(NewJFrame.getObj().isVisible()){
                             speech.speak("send message menu is already opened",1.5f,false,true);
                             }
                             else{
                             speech.speak("message menu is starting",1.5f,true,false);
                             NewJFrame.getObj().setVisible(true);
                              SettingWallPaper s=new SettingWallPaper();
                               if(s.Readwallpaper().equals("wall1")){
            try {
                File f=new File("picturesdownloaded/background3.jpg");
                System.out.println(f.getCanonicalPath()+" "+f.exists());
                URL url;
                url = getClass().getResource("/background3.jpg");
                ImageIcon i=new ImageIcon(url);
                NewJFrame.jLabel5.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(s.Readwallpaper().equals("wall2")){
            try {
                File f=new File("picturesdownloaded/background4.jpg");
                System.out.println(f.getCanonicalPath()+" "+f.exists());
                URL url=getClass().getResource("/background4.jpg");
                ImageIcon i=new ImageIcon(url);
                NewJFrame.jLabel5.setIcon(i);
                
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall3")){
            try {
                File f=new File("picturesdownloaded/background.jpeg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=getClass().getResource("/background.jpeg");
                ImageIcon i=new ImageIcon(url);
                NewJFrame.jLabel5.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall4")){
            try {
                File f=new File("picturesdownloaded/background2.jpeg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                ImageIcon i=new ImageIcon(getClass().getResource("/picturesdownloaded/background2.jpeg"));
                NewJFrame.jLabel5.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall5")){
            try {
                File f=new File("picturesdownloaded/background5.jpg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=Class.class.getResource("/background5.jpg");
                ImageIcon i=new ImageIcon(url);
                NewJFrame.jLabel5.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        }
         else if(s.Readwallpaper().equals("wall6")){
            try {
                File f=new File("picturesdownloaded/NewLayer.jpg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=Class.class.getResource("/NewLayer.jpg");
                ImageIcon i=new ImageIcon(url);
                NewJFrame.jLabel5.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                         }
                         }
                         else if(resultText.equalsIgnoreCase("browse the web")){
                             try{
                                 speech.speak("browser is starting",1.5f,true,false);
 		        Process p;//	resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start chrome.exe");
 		       // System.out.println("inside");
 		        }catch(Exception ae){ae.printStackTrace(); }
                         }
                         else if(resultText.equalsIgnoreCase("open social media")){
                             if(LoginForm.getObj().isVisible()){
                              speech.speak("please login to make this command effective",1.5f,true,false);
                             }
                            if( SocialMediasFrame.getObj().isVisible()){
                            speech.speak("social media is already open",1.5f,true,false);
                            }else{
                             speech.speak("social media is starting",1.5f,true,false);
                                SocialMediasFrame.getObj().setVisible(true);
                                SettingWallPaper s=new SettingWallPaper();
                                   if(s.Readwallpaper().equals("wall1")){
            try {
                File f=new File("picturesdownloaded/background3.jpg");
                System.out.println(f.getCanonicalPath()+" "+f.exists());
                URL url;
                url = getClass().getResource("/background3.jpg");
                ImageIcon i=new ImageIcon(url);
                SocialMediasFrame.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(s.Readwallpaper().equals("wall2")){
            try {
                File f=new File("picturesdownloaded/background4.jpg");
                System.out.println(f.getCanonicalPath()+" "+f.exists());
                URL url=getClass().getResource("/background4.jpg");
                ImageIcon i=new ImageIcon(url);
                SocialMediasFrame.jLabel1.setIcon(i);
                
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall3")){
            try {
                File f=new File("picturesdownloaded/background.jpeg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=getClass().getResource("/background.jpeg");
                ImageIcon i=new ImageIcon(url);
                SocialMediasFrame.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall4")){
            try {
                File f=new File("picturesdownloaded/background2.jpeg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                ImageIcon i=new ImageIcon(getClass().getResource("/picturesdownloaded/background2.jpeg"));
                SocialMediasFrame.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall5")){
            try {
                File f=new File("picturesdownloaded/background5.jpg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=Class.class.getResource("/background5.jpg");
                ImageIcon i=new ImageIcon(url);
                SocialMediasFrame.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
      
        }
         else if(s.Readwallpaper().equals("wall6")){
            try {
                File f=new File("picturesdownloaded/NewLayer.jpg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                URL url=Class.class.getResource("/NewLayer.jpg");
                ImageIcon i=new ImageIcon(url);
                SocialMediasFrame.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                            } 
                         }
                         else if(resultText.equalsIgnoreCase("schedule event")){
                             if(!(SchedulerCalPage.getObj().isVisible())){
                            
                              speech.speak("you cannot make this command now make sure the activity scheduler is open",1.5f,true,false);
                             
                             }
                             else if(SchedulerCalPage.getObj().isVisible()){
                             SchedulerCalPage.jDesktopPane1.setVisible(true);
                                ScheduleInternal intern=new ScheduleInternal();
                                SchedulerCalPage.jDesktopPane1.add(intern);
                                intern.setVisible(true);
                                     }
                         }else if(resultText.equalsIgnoreCase("select wall one")){
                             if(LoginForm.getObj().isVisible()){
                              speech.speak("please login to make this command effective",1.5f,true,false);
                             }
                             if(ChangeWallpaper.getObj().isVisible()){
                              try {
                                    File f=new File("picturesdownloaded/background3.jpg");
                                    System.out.println(f.getCanonicalPath()+" "+f.exists());
                                    URL url;
                                    url = getClass().getResource("/background3.jpg");
                                    ImageIcon i=new ImageIcon(url);
                                    jLabel1.setIcon(i);
                                    s.WriteWallPaper("wall1");
                                } catch (IOException ex) {
                                    Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
                                }
                             }else{
                                 speech.speak("wall paper menu is not opened.please open and give the command again", 1.5f, false, true);
                             }
                         }else if(resultText.equalsIgnoreCase("select wall two")){
                              if(ChangeWallpaper.getObj().isVisible()){
                         try {
                                File f=new File("picturesdownloaded/background4.jpg");
                                System.out.println(f.getCanonicalPath()+" "+f.exists());
                                URL url=getClass().getResource("/background4.jpg");
                                ImageIcon i=new ImageIcon(url);
                                jLabel1.setIcon(i);
                                s.WriteWallPaper("wall2");
                            } catch (IOException ex) {
                                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
                            }
                              }else{
                                 speech.speak("wall paper menu is not opened.please open and give the command again", 1.5f, false, true);
                             }
                         }else if(resultText.equalsIgnoreCase("select wall three")){
                             if(ChangeWallpaper.getObj().isVisible()){
                             try {
                                    File f=new File("picturesdownloaded/background.jpeg");
                                    System.out.println(f.getCanonicalPath()+""+f.exists());
                                    URL url=getClass().getResource("/background.jpeg");
                                    ImageIcon i=new ImageIcon(url);
                                    jLabel1.setIcon(i);
                                    s.WriteWallPaper("wall3");
                                } catch (IOException ex) {
                                    Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
                                }
                             }else{
                                 speech.speak("wall paper menu is not opened.please open and give the command again", 1.5f, false, true);
                             }
                         }else if(resultText.equalsIgnoreCase("select wall four")){
                             if(ChangeWallpaper.getObj().isVisible()){
                             try {
                                File f=new File("picturesdownloaded/background2.jpeg");
                                System.out.println(f.getCanonicalPath()+""+f.exists());
                                ImageIcon i=new ImageIcon(getClass().getResource("/picturesdownloaded/background2.jpeg"));
                                jLabel1.setIcon(i);
                                s.WriteWallPaper("wall4");
                            } catch (IOException ex) {
                                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
                            }
                             }else{
                                 speech.speak("wall paper menu is not opened.please open and give the command again", 1.5f, false, true);
                             }
                                     
                         }else if(resultText.equalsIgnoreCase("select wall five")){
                             if(ChangeWallpaper.getObj().isVisible()){
                              try {
                                File f=new File("picturesdownloaded/background5.jpg");
                                System.out.println(f.getCanonicalPath()+""+f.exists());
                                URL url=Class.class.getResource("/background5.jpg");
                                ImageIcon i=new ImageIcon(url);
                                jLabel1.setIcon(i);
                                s.WriteWallPaper("wall5");
                            } catch (IOException ex) {
                                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
                            }
                             }else{
                                 speech.speak("wall paper menu is not opened.please open and give the command again", 1.5f, false, true);
                             }
                                     
                         }else if(resultText.equalsIgnoreCase("select wall six")){
                             if(ChangeWallpaper.getObj().isVisible()){
                             try {
                                File f=new File("picturesdownloaded/NewLayer.jpg");
                                System.out.println(f.getCanonicalPath()+""+f.exists());
                                URL url=Class.class.getResource("/NewLayer.jpg");
                                ImageIcon i=new ImageIcon(url);
                                jLabel1.setIcon(i);
                                s.WriteWallPaper("wall6");
                            } catch (IOException ex) {
                                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
                            }
                          
                             }else{
                                 speech.speak("wall paper menu is not opened.please open and give the command again", 1.5f, false, true);
                             }
                                     
                         }else if(resultText.equalsIgnoreCase("close social media")){
                                if( SocialMediasFrame.getObj().isVisible()){
                             SocialMediasFrame.getObj().setVisible(false);
                         }else{
                                    speech.speak("social media is not open. Do you want me to start the social media frame for you",1.5f,false,true);
                                    int showMessage=JOptionPane.showConfirmDialog(null,"Do you really want to open the social medias menu?","Open social media menu", JOptionPane.YES_NO_OPTION);
                                    if(showMessage==0){
                                    SocialMediasFrame.getObj().setVisible(true);
                                    }else if(showMessage==1){
                                        
                                    }
                                }
                         }else if(resultText.equalsIgnoreCase("close memo")){
                             if(LoginForm.getObj().isVisible()){
                              speech.speak("please login to make this command effective",1.5f,true,false);
                             }
                                if( NoteMaker.getObj().isVisible()){
                             NoteMaker.getObj().setVisible(false);
                         }else{
                                    speech.speak("memo is not open. Do you want me to start the memo frame for you",1.5f,false,true);
                                    int showMessage=JOptionPane.showConfirmDialog(null,"Do you really want to open the NoteMaker menu?","Open NoteMaker menu", JOptionPane.YES_NO_OPTION);
                                    if(showMessage==0){
                                    SocialMediasFrame.getObj().setVisible(true);
                                    }else if(showMessage==1){
                                        
                                    }
                                }
                         }else if(resultText.equalsIgnoreCase("close message")){
                             if(LoginForm.getObj().isVisible()){
                              speech.speak("please login to make this command effective",1.5f,true,false);
                             }
                                if( NoteMaker.getObj().isVisible()){
                             NewJFrame.getObj().setVisible(false);
                         }else{
                                    speech.speak("message is not open. Do you want me to start the message dialog menu",1.5f,false,true);
                                    int showMessage=JOptionPane.showConfirmDialog(null,"Do you really want to open the NoteMaker menu?","Open NoteMaker menu", JOptionPane.YES_NO_OPTION);
                                    if(showMessage==0){
                                    NewJFrame.getObj().setVisible(true);
                                    }else if(showMessage==1){
                                        
                                    }
                                }
                         }else if(resultText.equalsIgnoreCase("close computer functionality")){
                             if(LoginForm.getObj().isVisible()){
                              speech.speak("please login to make this command effective",1.5f,true,false);
                             }
                                if( PcMonitorsAndControls.getObj().isVisible()){
                             PcMonitorsAndControls.getObj().setVisible(false);
                         }else{
                                    speech.speak("computer functionality is not open.do you want me to open the memo frame for you",1.5f,false,true);
                                    int showMessage=JOptionPane.showConfirmDialog(null,"Do you really want to open the NoteMaker menu?","Open NoteMaker menu", JOptionPane.YES_NO_OPTION);
                                    if(showMessage==0){
                                    PcMonitorsAndControls.getObj().setVisible(true);
                                    }else if(showMessage==1){
                                        
                                    }
                                }
                         }
                         
                        else if (resultText.equalsIgnoreCase("add to do ")){  
                            if(LoginForm.getObj().isVisible()){
                              speech.speak("please login to make this command effective",1.5f,true,false);
                             }
                           if(!SchedulerCalPage.getObj().isVisible()){
                               
                              speech.speak("you cannot make this command now as activity scheduler is not open",1.5f,true,false);
                             
                           } else if(SchedulerCalPage.getObj().isVisible()){
                                ToDoList.jButton2.doClick();  
                           }
                                
                        }
                        else if(resultText.equalsIgnoreCase("yes")){
                            
                            if (!PopUpFrames.FrameStartUp.getObj().isVisible()){
                                  speech.speak("Your choose pane dialog box is closed you cant make further selections",1.5f,false,true);
                              }
                            else if(LoginForm.getObj().isVisible()){
                                speech.speak("Your Login form is opened please login",1.5f,false,true);
                            }
                            else{
                                SignUpPage.getObj().setVisible(true);
                                PopUpFrames.FrameStartUp.getObj().setVisible(false);
                        }
                        }
                        else if(resultText.equalsIgnoreCase("no")){
                             if (!PopUpFrames.FrameStartUp.getObj().isVisible()){
                                  speech.speak("Your choose pane dialog box is closed you cant make further selections",1.5f,false,true);
                              }
                              else if(SignUpPage.getObj().isVisible()){
                                  speech.speak("Your sign up page is opened please signup as a new user to continue",1.5f,false,true);
                            }
                               
                            else{
                               LoginForm.getObj().setVisible(true);
                             speech.speak("You are Welcome to the daily scheduler Program Interface designed by cletus, please navigate to sechedule your "
                     + "daily activities after login. sections are active, thank you",1.5f,true,false);
                           PopUpFrames.FrameStartUp.getObj().setVisible(false);
                        }
                        }
                          if(resultText.equalsIgnoreCase("File"))
 			{
                             NoteMaker maker=new NoteMaker();
                            maker.fileMenu.add("");
 			} 
                          else if (resultText.equalsIgnoreCase("what day is today")){
                              Date day=new Date();
                             SimpleDateFormat s=new SimpleDateFormat("dd-mm-yy");
                              speech.speak("todays date is"+s.format(day),1.5f,true,false);
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
		new SpeechRecognizerMain();   
	}
}
