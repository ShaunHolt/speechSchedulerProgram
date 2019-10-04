/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaclasses;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import static speechschedulerprogram.ChangeWallpaper.jLabel1;

/**
 *
 * @author babaoye ayomide
 */
public class WallValidity {
        
        public void SetWallPaper(){
        SettingWallPaper s=new SettingWallPaper();
        if(s.Readwallpaper().equals("wall1")){
            try {
                File f=new File("picturesdownloaded/background3.jpg");
                System.out.println(f.getCanonicalPath()+" "+f.exists());
                URL url;
                url = getClass().getResource("/background3.jpg");
                ImageIcon i=new ImageIcon(url);
                jLabel1.setIcon(i);
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
                jLabel1.setIcon(i);
                
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
                jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall4")){
            try {
                File f=new File("picturesdownloaded/background2.jpeg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                ImageIcon i=new ImageIcon(getClass().getResource("/picturesdownloaded/background2.jpeg"));
                jLabel1.setIcon(i);
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
                jLabel1.setIcon(i);
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
                jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    
}
