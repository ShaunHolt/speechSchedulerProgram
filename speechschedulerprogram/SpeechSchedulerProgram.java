/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speechschedulerprogram;

import java.io.IOException;
import speechrecognition.SpeechRecognizerMain;
import trayicondisplay.DisplayTrayIcon;
import tts.TextToSpeech;

/**
 *
 * @author Babaoye Ayomide
 */
public class SpeechSchedulerProgram {


    public static void main(String[] args) throws IOException {
       DisplayTrayIcon Dis=new DisplayTrayIcon();
        SplashInterface splash=new SplashInterface();
        splash.setVisible(true);
        
        TextToSpeech speak=new TextToSpeech();
        speak.speak("program initializing", 1.5f, false, true);
         try{
         for(int i=0;i<=100;i++){
             Thread.sleep(80);
         splash.LoadStatus.setText(Integer.toString(i)+"%");
         splash.ProgressBar.setValue(i);
         if(i==100){
             splash.setVisible(false);
            SpeechRecognizerMain recognise=new SpeechRecognizerMain();
             AllProgramList list=new AllProgramList();
             list.setVisible(true);
             speak.speak("\"Note!!! Are you a new user? ,please hit the yes and No option button to make confirmation",1.5f,true,false);
             PopUpFrames.FrameStartUp.getObj().setVisible(true);
         }
         }
         }catch(Exception e){
         
         }
    }
    
}
