/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package popupframe;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 *
 * @author babaoye ayomide
 */
public class Mymusic {
     public void playMusic(String musicLocation){
    try{
        File musicPath=new File(musicLocation);
        
        if(musicPath.exists()){
            AudioInputStream audioInput=AudioSystem.getAudioInputStream(musicPath);
            Clip clip=AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            JOptionPane.showMessageDialog(null,"hit ok to Stop Alert");
            long clipTimePostion=clip.getMicrosecondPosition();
            clip.stop();
        }
        
        else{
        System.out.println("cant find file");
        }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
}
}
