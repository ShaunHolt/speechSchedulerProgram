/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speechschedulerprogram;

import callenderframing.SchedulerCalPage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import notemakemenu.NoteMaker;
import sendsms.NewJFrame;
import javaclasses.SettingWallPaper;
import javaclasses.WallValidity;
import javax.swing.ImageIcon;
import pcactivitiesturnup.PcMonitorsAndControls;
import socialmedia.SocialMediasFrame;
import speechrecognition.SpeechRecognizerMain;
import static speechschedulerprogram.ChangeWallpaper.jLabel1;
import speechtotext.SpeechToText;
import tts.TextToSpeech;


public class LoginPage extends javax.swing.JFrame {
int xx;
int xy;
 TextToSpeech talk=new TextToSpeech();
 SettingWallPaper s;
 private static LoginPage obj=null;
  
    public LoginPage() {
        initComponents();
        
    }
    public static LoginPage getObj(){
    if(obj==null){
        obj=new LoginPage();
    }
    return obj;
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 500));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("x");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel6);
        jLabel6.setBounds(860, 0, 30, 34);

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel120.setText("-");
        jLabel120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel120MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel120);
        jLabel120.setBounds(820, 0, 40, 30);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picturesdownloaded/edit-8-120.png"))); // NOI18N
        jLabel3.setText("schedule activity");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel3);
        jLabel3.setBounds(130, 70, 120, 150);

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 20, 200, 40);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picturesdownloaded/window-add-120.png"))); // NOI18N
        jLabel4.setText("change wall paper");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel4);
        jLabel4.setBounds(480, 250, 130, 140);

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picturesdownloaded/worldwide-location-120.png"))); // NOI18N
        jLabel5.setText("browse the internet");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel5);
        jLabel5.setBounds(630, 60, 140, 138);

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picturesdownloaded/report-3-120.png"))); // NOI18N
        jLabel7.setText("memo");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel7);
        jLabel7.setBounds(470, 50, 110, 160);

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picturesdownloaded/settings-5-120.png"))); // NOI18N
        jLabel8.setText("settings");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabel8);
        jLabel8.setBounds(130, 240, 120, 150);

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picturesdownloaded/website-design-120.png"))); // NOI18N
        jLabel9.setText("walk around the pc");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel9);
        jLabel9.setBounds(290, 240, 130, 150);

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picturesdownloaded/sms-3-120.png"))); // NOI18N
        jLabel10.setText("send sms");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel10);
        jLabel10.setBounds(280, 60, 130, 150);

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picturesdownloaded/at-120.png"))); // NOI18N
        jLabel11.setText("social media");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel11);
        jLabel11.setBounds(650, 240, 130, 150);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picturesdownloaded/light-bulb-2-32.png"))); // NOI18N
        jLabel12.setToolTipText("Tap to start speech recognizer");
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel12);
        jLabel12.setBounds(820, 440, 32, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picturesdownloaded/NewLayer.jpg"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 900, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
      xx=evt.getX();
      xy=evt.getY();
       
    }//GEN-LAST:event_jLabel1MousePressed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
       int x=evt.getXOnScreen();
       int y=evt.getYOnScreen();
       
        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel120MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel120MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel120MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        new DateAndTime();
    }//GEN-LAST:event_formWindowOpened

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
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
        
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       ChangeWallpaper.getObj().setVisible(true);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
       talk.speak("Browsers engine are starting", 1.5f, false, true);
        try{
 		        Process p;//	resultText="";
 		        p = Runtime.getRuntime().exec("cmd /c start chrome.exe");
 		       // System.out.println("inside");
 		        }catch(Exception ae){ae.printStackTrace(); }
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
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
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
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
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
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
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
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
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
         SpeechRecognizerMain recognise=new SpeechRecognizerMain();
         AllProgramList.getObj().setVisible(true);
         SpeechToText speech=new SpeechToText();
        AllProgramList.getObj().setVisible(true);
    }//GEN-LAST:event_jLabel12MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginPage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    protected static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
