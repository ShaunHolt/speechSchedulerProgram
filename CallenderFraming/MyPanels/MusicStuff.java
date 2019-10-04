/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callenderframing.mypanels;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

/**
 *
 * @author babaoye ayomide
 */
public class MusicStuff {
  public void playMusic(URL musicLocation){
        try{
        //File musicPath=new File(musicLocation);
        
        if(musicLocation.sameFile(musicLocation)){
            AudioInputStream audioInput=AudioSystem.getAudioInputStream(musicLocation);
            Clip clip=AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
          
           JOptionPane.showMessageDialog(null,"hit ok to pause");
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
