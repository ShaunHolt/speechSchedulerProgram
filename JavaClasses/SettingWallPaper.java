/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author babaoye ayomide
 */
public class SettingWallPaper {
    public static Properties prop=new Properties();
   public String savePath=System.getProperty("user.home")+"/Documents/SpeechRecognizer details/";
    public void WriteWallPaper(String WallID){
        try{
        prop.setProperty("WallPaper", WallID);
        prop.store(new FileOutputStream(savePath+"config.saved"), null);
        } 
        catch(IOException e){
        
        }      
    }
    
    public String Readwallpaper(){
        String line="";
        try {
            prop.load(new FileInputStream(savePath+"config.saved"));
             line=prop.getProperty("WallPaper");
        
   
        } catch (IOException ex) {
           
        }
            return line;
    }
    
}
