/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speechschedulerprogram;


import javaclasses.SettingWallPaper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaclasses.WallValidity;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import sendsms.NewJFrame;
import tts.TextToSpeech;

/**
 *
 * @author Babaoye Ayomide
 */
public class LoginForm extends javax.swing.JFrame {
int xx;
int xy;
 TextToSpeech speak=new TextToSpeech();
 public static int realYear, realMonth, realDay, currentYear, currentMonth;
 private static LoginForm obj=null;
 public String savePath=System.getProperty("user.home")+"/Documents/SpeechRecognizer details/";
 private static Scanner x;
 String filePath=savePath+".Birthdate.saved";
 
    /**
     * Creates new form LoginForm
     */
    public LoginForm() {
        initComponents();
    }
    public static LoginForm getObj(){
        if(obj==null){
            obj=new LoginForm();
        }
        return obj;
    }
    public void ReadFile(String filePath){
     boolean found=false;
     String name="";
     String date="";
     try{
         x=new Scanner(new File (filePath));
            x.useDelimiter("[,\n]");
            while(x.hasNext()&&!found){
                name=x.next();
                date=x.next();
                
                if(date.equals(jLabel4.getText())){
                    found=true;
                }
            }           
            if(found){
                JOptionPane.showMessageDialog(null,"Today is "+name+" Birthday Please wish him or her a happy birthday");
              int sendMessage=  JOptionPane.showConfirmDialog(null, "do you want to send an SMS to "+name+" ","Send Message Notice",JOptionPane.YES_NO_OPTION);
              if(sendMessage==0){
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
              }else if(sendMessage==1){
              
              }
              
            }
            else{
                JOptionPane.showMessageDialog(null, "You dont hava a birthday reminder for today");
            }
     }catch(Exception ex){
         JOptionPane.showMessageDialog(null, "Not FOund Exception");
     }
     
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(311, 359));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(311, 359));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Password");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("x");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel120.setText("-");
        jLabel120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel120MouseClicked(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setText("Note:\nPlease ensure you use \na username that can be easily\n remembered. \nclick the forgotten text to \nretrive forgotten passwords.");
        jTextArea1.setBorder(null);

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Forgotten Password ?");

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Are you a new user? click here!!");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextArea1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(jPasswordField1)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(210, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel120, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPasswordField1)
                        .addGap(4, 4, 4)))
                .addGap(8, 8, 8)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextArea1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(246, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 311, 359);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
      System.exit(0);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel120MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel120MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel120MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        
    }//GEN-LAST:event_jPanel1MouseReleased

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
      int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try
       {
           String name=jTextField1.getText();
           String pass=new String(jPasswordField1.getPassword());
           BufferedReader br=new BufferedReader(new FileReader(savePath+".authen.dat"));
           if((name.equals(br.readLine())) && (pass.equals(br.readLine())))
           {    speak.speak("Hello, " + name
              + " my name is cane and i will be your guide. pleaseProceed to schedule your daily task",1.5f,false,true);
              ReadFile(filePath);
             LoginPage.getObj().setVisible(true);
            SettingWallPaper s=new SettingWallPaper();
        if(s.Readwallpaper().equals("wall1")){
            try {
                File f=new File("picturesdownloaded/background3.jpg");
                System.out.println(f.getCanonicalPath()+" "+f.exists());
                URL url;
                url = getClass().getResource("/background3.jpg");
                ImageIcon i=new ImageIcon(url);
                LoginPage.jLabel1.setIcon(i);
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
                LoginPage.jLabel1.setIcon(i);
                
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
                LoginPage.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         else if(s.Readwallpaper().equals("wall4")){
            try {
                File f=new File("picturesdownloaded/background2.jpeg");
                System.out.println(f.getCanonicalPath()+""+f.exists());
                ImageIcon i=new ImageIcon(getClass().getResource("/picturesdownloaded/background2.jpeg"));
                LoginPage.jLabel1.setIcon(i);
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
                LoginPage.jLabel1.setIcon(i);
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
                LoginPage.jLabel1.setIcon(i);
            } catch (IOException ex) {
                Logger.getLogger(WallValidity.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
             this.dispose();
           }
           else
           {
                jLabel3.setText("Please Check your login details");
               //JOptionPane.showMessageDialog(null, "Invalid Credentials");
           }
       }
       catch(Exception e)
       {
           e.printStackTrace();
       }    
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        this.dispose();
        SignUpPage.getObj().setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
 
            String month=null;
        GregorianCalendar gregCal = new GregorianCalendar();
        realDay = gregCal.get(GregorianCalendar.DAY_OF_MONTH);
        realMonth = gregCal.get(GregorianCalendar.MONTH)+1;
        realYear = gregCal.get(GregorianCalendar.YEAR);
        currentMonth = realMonth;
        currentYear = realYear;
        if(realMonth==1){
        month="jan";
        }
        else if(realMonth==2){
             month="Feb";
        }
        else if(realMonth==3){
             month="Mar";
        }
        else if(realMonth==4){
             month="Apr";
        }
        else if(realMonth==5){
             month="May";
        }
        else if(realMonth==6){
             month="Jun";
        }else if(realMonth==7){
             month="Jul";
        }
        else if(realMonth==8){
             month="Aug";
        }
        else if(realMonth==9){
             month="Sep";
        }
        else if(realMonth==10){
             month="Oct";
        }
        else if(realMonth==11){
             month="Nov";
        }
        else if(realMonth==12){
             month="Dec";
        }
       String day=String.valueOf(realDay);
       String year=String.valueOf(realYear);
        String dateFormat=day+"-"+month+"-"+realYear;
        jLabel4.setText(dateFormat);
           
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
