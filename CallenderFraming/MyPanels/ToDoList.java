/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callenderframing.mypanels;

import com.sun.glass.events.KeyEvent;
import javax.swing.JOptionPane;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.DefaultAuthenticator;

/**
 *
 * @author HackerSpliot
 */
public class ToDoList extends javax.swing.JPanel {
    private static ToDoList obj=null;
    /**
     * Creates new form ToDoList
     */
    public ToDoList() {
        initComponents();
       
        checkPanel();
    }
    public static ToDoList getObj(){
        if(obj==null){
            obj=new ToDoList();
        }
        return obj;
    }
   public void checkPanel(){
    box1.setVisible(false);
    box2.setVisible(false);
    box3.setVisible(false);
    box4.setVisible(false);
    box5.setVisible(false);
    box6.setVisible(false);
    box7.setVisible(false);
    box8.setVisible(false);
    box9.setVisible(false);
    box10.setVisible(false);
    box11.setVisible(false);
    box12.setVisible(false);
    box13.setVisible(false);
    box14.setVisible(false);
    box15.setVisible(false);
    box16.setVisible(false);
    box17.setVisible(false);
    box18.setVisible(false);
    box19.setVisible(false);
    box20.setVisible(false);
    box21.setVisible(false);
    box22.setVisible(false);
    box23.setVisible(false);
    box24.setVisible(false);
    box25.setVisible(false);
    box26.setVisible(false);
    box27.setVisible(false);
    box28.setVisible(false);
    box29.setVisible(false);
    box30.setVisible(false);
    
    }
   public void SetSelected(){
    box1.setSelected(false);
    box2.setSelected(false);
    box3.setSelected(false);
    box4.setSelected(false);
    box5.setSelected(false);
    box6.setSelected(false);
    box7.setSelected(false);
    box8.setSelected(false);
    box9.setSelected(false);
    box10.setSelected(false);
    box11.setSelected(false);
    box12.setSelected(false);
    box13.setSelected(false);
    box14.setSelected(false);
    box15.setSelected(false);
    box16.setSelected(false);
    box17.setSelected(false);
    box18.setSelected(false);
    box19.setSelected(false);
    box20.setSelected(false);
    box21.setSelected(false);
    box22.setSelected(false);
    box23.setSelected(false);
    box24.setSelected(false);
    box25.setSelected(false);
    box26.setSelected(false);
    box27.setSelected(false);
    box28.setSelected(false);
    box29.setSelected(false);
    box30.setSelected(false);
    
    }

   public void check(){
  //     if(!box1.isVisible()){
//       if(box2.getText().equals(box2.getText())){
//                    box1.setVisible(true);
//                    String get=box2.getText();
//                    box1.setText(get);
//                   box2.setText("");
//                   //box2.setVisible(false);
//                   box1.setText("");
//                   checkPanel();
//               }
        if(box1.isSelected()&& box2.isVisible()){
           box1.setText(box2.getText());
           box1.setVisible(true);
            box1.setSelected(false);
           box2.setVisible(false);
           box2.setText("");
       }
       if(box1.getText().equals("")&& box2.isVisible()){
           box1.setText(box2.getText());
           box1.setVisible(true);
           box1.setSelected(false);
           box2.setVisible(false);
           box2.setText("");
       }
      // }
        if(box2.isSelected()&& box3.isVisible()){
           box2.setVisible(true);
           box2.setText(box3.getText());
           box2.setSelected(false);
           box3.setText("");
           box3.setVisible(false);
       }
        if(box2.getText().equals("")&& box3.isVisible()){
           box2.setVisible(true);
           box2.setText(box3.getText());
           box2.setSelected(false);
           box3.setText("");
           box3.setVisible(false);
       }  if(box3.isSelected()&& box4.isVisible()){
           String collectText=box4.getText();
            box3.setVisible(true);
            box3.setText(collectText);
            box3.setSelected(false);
            box4.setText("");
             box4.setVisible(false);
       } if(box3.getText().equals("")&& box4.isVisible()){
            String collectText=box4.getText();
            box3.setVisible(true);
            box3.setText(collectText);
            box3.setSelected(false);
            box4.setText("");
             box4.setVisible(false);
       }  if(box4.isSelected()&& box5.isVisible()){
           String collectText=box5.getText();
            box4.setVisible(true);
            box4.setText(collectText);
            box4.setSelected(false);
            box5.setText("");
            box5.setVisible(false);
       } if(box4.getText().equals("")&& box5.isVisible()){
            String collectText=box5.getText();
            box4.setVisible(true);
            box4.setText(collectText);
            box4.setSelected(false);
            box5.setText("");
            box5.setVisible(false);
       }  if(box5.isSelected()&& box6.isVisible()){
           String collectText=box6.getText();
            box5.setVisible(true);
            box5.setText(collectText);
            box5.setSelected(false);
            box6.setText("");
            box6.setVisible(false);
       }
       if(box5.getText().equals("")&& box6.isVisible()){
            String collectText=box6.getText();
            box5.setVisible(true);
            box5.setText(collectText);
            box5.setSelected(false);
            box6.setText("");
            box6.setVisible(false);
       } if(box6.isSelected()&& box7.isVisible()){
          String collectText=box7.getText();
             box6.setVisible(true);
            box6.setText(collectText);
            box6.setSelected(false);
            box7.setText("");
            box7.setVisible(false);
       }if(box6.getText().equals("")&& box7.isVisible()){
            String collectText=box7.getText();
             box6.setVisible(true);
            box6.setText(collectText);
            box6.setSelected(false);
            box7.setText("");
            box7.setVisible(false);
       }if(box7.isSelected()&& box8.isVisible()){
          String collectText=box8.getText();
             box7.setVisible(true);
            box7.setText(collectText);
            box7.setSelected(false);
            box8.setText("");
            box8.setVisible(false);
       } if(box7.getText().equals("")&& box8.isVisible()){
            String collectText=box8.getText();
             box7.setVisible(true);
            box7.setText(collectText);
            box7.setSelected(false);
            box8.setText("");
            box8.setVisible(false);
       }if(box8.isSelected()&& box9.isVisible()){
         String collectText=box9.getText();
             box8.setVisible(true);
            box8.setText(collectText);
            box8.setSelected(false);
            box9.setText("");
            box9.setVisible(false);
       } if(box8.getText().equals("")&& box9.isVisible()){
            String collectText=box9.getText();
             box8.setVisible(true);
            box8.setText(collectText);
            box8.setSelected(false);
            box9.setText("");
            box9.setVisible(false);
       }if(box9.isSelected()&& box10.isVisible()){
          String collectText=box10.getText();
             box9.setVisible(true);
            box9.setText(collectText);
            box9.setSelected(false);
            box10.setText("");
            box10.setVisible(false);
       } if(box9.getText().equals("")&& box10.isVisible()){
            String collectText=box10.getText();
             box9.setVisible(true);
            box9.setText(collectText);
            box9.setSelected(false);
            box10.setText("");
            box10.setVisible(false);
       }if(box10.isSelected()&& box11.isVisible()){
         String collectText=box11.getText();
             box10.setVisible(true);
            box10.setText(collectText);
            box10.setSelected(false);
            box11.setText("");
            box11.setVisible(false);
       } if(box10.getText().equals("")&& box11.isVisible()){
            String collectText=box11.getText();
             box10.setVisible(true);
            box10.setText(collectText);
            box10.setSelected(false);
            box11.setText("");
            box11.setVisible(false);
       }if(box11.isSelected()&& box12.isVisible()){
          String collectText=box12.getText();
             box11.setVisible(true);
            box11.setText(collectText);
            box11.setSelected(false);
            box12.setText("");
            box12.setVisible(false);
       } if(box11.getText().equals("")&& box12.isVisible()){
            String collectText=box12.getText();
             box11.setVisible(true);
            box11.setText(collectText);
            box11.setSelected(false);
            box12.setText("");
            box12.setVisible(false);
       }if(box12.isSelected()&& box13.isVisible()){
         String collectText=box13.getText();
             box12.setVisible(true);
            box12.setText(collectText);
            box12.setSelected(false);
            box13.setText("");
            box13.setVisible(false);
       } if(box12.getText().equals("")&& box13.isVisible()){
            String collectText=box13.getText();
             box12.setVisible(true);
            box12.setText(collectText);
            box12.setSelected(false);
            box13.setText("");
            box13.setVisible(false);
       }if(box13.isSelected()&& box14.isVisible()){
           String collectText=box14.getText();
             box13.setVisible(true);
            box13.setText(collectText);
            box13.setSelected(false);
            box14.setText("");
            box14.setVisible(false);
       } if(box13.getText().equals("")&& box14.isVisible()){
            String collectText=box14.getText();
             box13.setVisible(true);
            box13.setText(collectText);
            box13.setSelected(false);
            box14.setText("");
            box14.setVisible(false);
       }if(box14.isSelected()&& box15.isVisible()){
          String collectText=box15.getText();
            box14.setVisible(true);
            box14.setText(collectText);
            box14.setSelected(false);
            box15.setText("");
            box15.setVisible(false);
       } if(box14.getText().equals("")&& box15.isVisible()){
            String collectText=box15.getText();
            box14.setVisible(true);
            box14.setText(collectText);
            box14.setSelected(false);
            box15.setText("");
            box15.setVisible(false);
       }if(box15.isSelected()&& box16.isVisible()){
         String collectText=box16.getText();
            box15.setVisible(true);
            box15.setText(collectText);
            box15.setSelected(false);
            box16.setText("");
            box16.setVisible(false);
       } if(box15.getText().equals("")&& box16.isVisible()){
            String collectText=box16.getText();
            box15.setVisible(true);
            box15.setText(collectText);
            box15.setSelected(false);
            box16.setText("");
            box16.setVisible(false);
       }if(box16.isSelected()&& box17.isVisible()){
          String collectText=box17.getText();
            box16.setVisible(true);
            box16.setText(collectText);
            box16.setSelected(false);
            box17.setText("");
            box17.setVisible(false);
       } if(box16.getText().equals("")&& box17.isVisible()){
            String collectText=box17.getText();
            box16.setVisible(true);
            box16.setText(collectText);
            box16.setSelected(false);
            box17.setText("");
            box17.setVisible(false);
       }if(box17.getText().equals("")&& box18.isVisible()){
          String collectText=box18.getText();
             box17.setVisible(true);
            box17.setText(collectText);
            box17.setSelected(false);
            box18.setText("");
            box18.setVisible(false);
       } if(box17.getText().equals("")&& box18.isVisible()){
            String collectText=box18.getText();
             box17.setVisible(true);
            box17.setText(collectText);
            box17.setSelected(false);
            box18.setText("");
            box18.setVisible(false);
       }if(box18.isSelected()&& box19.isVisible()){
         String collectText=box19.getText();
             box18.setVisible(true);
            box18.setText(collectText);
            box18.setSelected(false);
            box19.setText("");
            box19.setVisible(false);
       } if(box18.getText().equals("")&& box19.isVisible()){
            String collectText=box19.getText();
             box18.setVisible(true);
            box18.setText(collectText);
            box18.setSelected(false);
            box19.setText("");
            box19.setVisible(false);
       }if(box19.getText().equals("")&& box20.isVisible()){
           String collectText=box20.getText();
             box19.setVisible(true);
            box19.setText(collectText);
            box19.setSelected(false);
            box20.setText("");
            box20.setVisible(false);
       } if(box19.getText().equals("")&& box20.isVisible()){
            String collectText=box20.getText();
             box19.setVisible(true);
            box19.setText(collectText);
            box19.setSelected(false);
            box20.setText("");
            box20.setVisible(false);
       }if(box20.isSelected()&& box21.isVisible()){
          String collectText=box21.getText();
             box20.setVisible(true);
            box20.setText(collectText);
            box20.setSelected(false);
            box21.setText("");
            box21.setVisible(false);
       } if(box20.getText().equals("")&& box21.isVisible()){
            String collectText=box21.getText();
             box20.setVisible(true);
            box20.setText(collectText);
            box20.setSelected(false);
            box21.setText("");
            box21.setVisible(false);
       }if(box21.isSelected()&& box22.isVisible()){
          String collectText=box22.getText();
             box21.setVisible(true);
            box21.setText(collectText);
            box21.setSelected(false);
            box22.setText("");
            box22.setVisible(false);
       } if(box21.getText().equals("")&& box22.isVisible()){
            String collectText=box22.getText();
             box21.setVisible(true);
            box21.setText(collectText);
            box21.setSelected(false);
            box22.setText("");
            box22.setVisible(false);
       }if(box22.isSelected()&& box23.isVisible()){
           String collectText=box23.getText();
             box22.setVisible(true);
            box22.setText(collectText);
            box22.setSelected(false);
            box23.setText("");
            box23.setVisible(false);
       } if(box22.getText().equals("")&& box23.isVisible()){
            String collectText=box23.getText();
             box22.setVisible(true);
            box22.setText(collectText);
            box22.setSelected(false);
            box23.setText("");
            box23.setVisible(false);
       }if(box23.isSelected()&& box24.isVisible()){
          String collectText=box24.getText();
             box23.setVisible(true);
            box23.setText(collectText);
            box23.setSelected(false);
            box24.setText(collectText);
            box24.setVisible(false);
       } if(box23.getText().equals("")&& box24.isVisible()){
            String collectText=box24.getText();
             box23.setVisible(true);
            box23.setText(collectText);
            box23.setSelected(false);
            box24.setText(collectText);
            box24.setVisible(false);
       }if(box24.isSelected()&& box25.isVisible()){
         String collectText=box25.getText();
             box24.setVisible(true);
            box24.setText(collectText);
            box24.setSelected(false);
            box25.setText("");
            box25.setVisible(false);
       } if(box24.getText().equals("")&& box25.isVisible()){
            String collectText=box25.getText();
             box24.setVisible(true);
            box24.setText(collectText);
            box24.setSelected(false);
            box25.setText("");
            box25.setVisible(false);
       }if(box25.isSelected()&& box26.isVisible()){
           String collectText=box26.getText();
            box25.setVisible(true);
            box25.setText(collectText);
            box25.setSelected(false);
            box26.setText("");
            box26.setVisible(false);
       } if(box25.getText().equals("")&& box26.isVisible()){
            String collectText=box26.getText();
            box25.setVisible(true);
            box25.setText(collectText);
            box25.setSelected(false);
            box26.setText("");
            box26.setVisible(false);
       }if(box26.isSelected()&& box27.isVisible()){
          String collectText=box27.getText();
             box26.setVisible(true);
            box26.setText(collectText);
            box26.setSelected(false);
            box27.setText("");
            box27.setVisible(false);
       } if(box26.getText().equals("")&& box27.isVisible()){
            String collectText=box27.getText();
             box26.setVisible(true);
            box26.setText(collectText);
            box26.setSelected(false);
            box27.setText("");
            box27.setVisible(false);
       }if(box27.isSelected()&& box28.isVisible()){
          String collectText=box28.getText();
            box27.setVisible(true);
            box27.setText(collectText);
            box27.setSelected(false);
            box28.setText("");
            box28.setVisible(false);
       } if(box27.getText().equals("")&& box28.isVisible()){
            String collectText=box28.getText();
            box27.setVisible(true);
            box27.setText(collectText);
            box27.setSelected(false);
            box28.setText("");
            box28.setVisible(false);
       }if(box28.isSelected()&& box29.isVisible()){
          String collectText=box29.getText();
            box28.setVisible(true);
            box28.setText(collectText);
            box28.setSelected(false);
            box29.setText("");
            box29.setVisible(false);
       } if(box28.getText().equals("")&& box29.isVisible()){
            String collectText=box29.getText();
            box28.setVisible(true);
            box28.setText(collectText);
            box28.setSelected(false);
            box29.setText("");
            box29.setVisible(false);
       }if(box29.isSelected()&& box30.isVisible()){
           String collectText=box30.getText();
            box29.setVisible(true);
            box29.setText(collectText);
            box29.setSelected(false);
            box30.setText("");
            box30.setVisible(false);
       } if(box29.getText().equals("")&& box30.isVisible()){
            String collectText=box30.getText();
            box29.setVisible(true);
            box29.setText(collectText);
            box29.setSelected(false);
            box30.setText("");
            box30.setVisible(false);
       }
   }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        box1 = new javax.swing.JCheckBox();
        box2 = new javax.swing.JCheckBox();
        box3 = new javax.swing.JCheckBox();
        box4 = new javax.swing.JCheckBox();
        box23 = new javax.swing.JCheckBox();
        box21 = new javax.swing.JCheckBox();
        box5 = new javax.swing.JCheckBox();
        box14 = new javax.swing.JCheckBox();
        box6 = new javax.swing.JCheckBox();
        box12 = new javax.swing.JCheckBox();
        box8 = new javax.swing.JCheckBox();
        box22 = new javax.swing.JCheckBox();
        box13 = new javax.swing.JCheckBox();
        box7 = new javax.swing.JCheckBox();
        box10 = new javax.swing.JCheckBox();
        box15 = new javax.swing.JCheckBox();
        box20 = new javax.swing.JCheckBox();
        box16 = new javax.swing.JCheckBox();
        box17 = new javax.swing.JCheckBox();
        box19 = new javax.swing.JCheckBox();
        box9 = new javax.swing.JCheckBox();
        box11 = new javax.swing.JCheckBox();
        box18 = new javax.swing.JCheckBox();
        box24 = new javax.swing.JCheckBox();
        box25 = new javax.swing.JCheckBox();
        box26 = new javax.swing.JCheckBox();
        box27 = new javax.swing.JCheckBox();
        box28 = new javax.swing.JCheckBox();
        box29 = new javax.swing.JCheckBox();
        box30 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setMaximumSize(new java.awt.Dimension(370, 399));
        setMinimumSize(new java.awt.Dimension(370, 399));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(370, 399));

        jScrollPane2.setBorder(null);
        jScrollPane2.setPreferredSize(new java.awt.Dimension(380, 612));

        jPanel3.setPreferredSize(new java.awt.Dimension(380, 612));

        jPanel2.setMinimumSize(new java.awt.Dimension(388, 612));
        jPanel2.setPreferredSize(new java.awt.Dimension(388, 612));

        box1.setBackground(new java.awt.Color(204, 204, 204));
        box1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box1ActionPerformed(evt);
            }
        });

        box2.setBackground(new java.awt.Color(255, 255, 255));
        box2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box2ActionPerformed(evt);
            }
        });

        box3.setBackground(new java.awt.Color(204, 204, 204));
        box3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box3ActionPerformed(evt);
            }
        });

        box4.setBackground(new java.awt.Color(255, 255, 255));
        box4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box4ActionPerformed(evt);
            }
        });

        box23.setBackground(new java.awt.Color(204, 204, 204));
        box23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box23ActionPerformed(evt);
            }
        });

        box21.setBackground(new java.awt.Color(204, 204, 204));
        box21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box21ActionPerformed(evt);
            }
        });

        box5.setBackground(new java.awt.Color(204, 204, 204));
        box5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box5ActionPerformed(evt);
            }
        });

        box14.setBackground(new java.awt.Color(255, 255, 255));
        box14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box14ActionPerformed(evt);
            }
        });

        box6.setBackground(new java.awt.Color(255, 255, 255));
        box6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box6ActionPerformed(evt);
            }
        });

        box12.setBackground(new java.awt.Color(255, 255, 255));
        box12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box12ActionPerformed(evt);
            }
        });

        box8.setBackground(new java.awt.Color(255, 255, 255));
        box8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box8ActionPerformed(evt);
            }
        });

        box22.setBackground(new java.awt.Color(255, 255, 255));
        box22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box22ActionPerformed(evt);
            }
        });

        box13.setBackground(new java.awt.Color(204, 204, 204));
        box13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box13ActionPerformed(evt);
            }
        });

        box7.setBackground(new java.awt.Color(204, 204, 204));
        box7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box7ActionPerformed(evt);
            }
        });

        box10.setBackground(new java.awt.Color(255, 255, 255));
        box10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box10ActionPerformed(evt);
            }
        });

        box15.setBackground(new java.awt.Color(204, 204, 204));
        box15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box15ActionPerformed(evt);
            }
        });

        box20.setBackground(new java.awt.Color(255, 255, 255));
        box20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box20ActionPerformed(evt);
            }
        });

        box16.setBackground(new java.awt.Color(255, 255, 255));
        box16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box16ActionPerformed(evt);
            }
        });

        box17.setBackground(new java.awt.Color(204, 204, 204));
        box17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box17ActionPerformed(evt);
            }
        });

        box19.setBackground(new java.awt.Color(204, 204, 204));
        box19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box19ActionPerformed(evt);
            }
        });

        box9.setBackground(new java.awt.Color(204, 204, 204));
        box9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box9ActionPerformed(evt);
            }
        });

        box11.setBackground(new java.awt.Color(204, 204, 204));
        box11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box11ActionPerformed(evt);
            }
        });

        box18.setBackground(new java.awt.Color(255, 255, 255));
        box18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box18ActionPerformed(evt);
            }
        });

        box24.setBackground(new java.awt.Color(255, 255, 255));
        box24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box24ActionPerformed(evt);
            }
        });

        box25.setBackground(new java.awt.Color(204, 204, 204));
        box25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box25ActionPerformed(evt);
            }
        });

        box26.setBackground(new java.awt.Color(255, 255, 255));
        box26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box26ActionPerformed(evt);
            }
        });

        box27.setBackground(new java.awt.Color(204, 204, 204));
        box27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box27ActionPerformed(evt);
            }
        });

        box28.setBackground(new java.awt.Color(255, 255, 255));
        box28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box28ActionPerformed(evt);
            }
        });

        box29.setBackground(new java.awt.Color(204, 204, 204));
        box29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box29ActionPerformed(evt);
            }
        });

        box30.setBackground(new java.awt.Color(255, 255, 255));
        box30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                box30ActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picturesdownloaded/TodoList.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(box6)
                    .addComponent(box4)
                    .addComponent(box3)
                    .addComponent(box7)
                    .addComponent(box5)
                    .addComponent(box10)
                    .addComponent(box12)
                    .addComponent(box11)
                    .addComponent(box14)
                    .addComponent(box13)
                    .addComponent(box9)
                    .addComponent(box15)
                    .addComponent(box24)
                    .addComponent(box26)
                    .addComponent(box28)
                    .addComponent(box29)
                    .addComponent(box22)
                    .addComponent(box30)
                    .addComponent(box2)
                    .addComponent(box25)
                    .addComponent(box16)
                    .addComponent(box21)
                    .addComponent(box20)
                    .addComponent(box19)
                    .addComponent(box23)
                    .addComponent(box1)
                    .addComponent(box17)
                    .addComponent(box27)
                    .addComponent(box18)
                    .addComponent(box8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(box6))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(box4))
                    .addComponent(box3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(box7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(box5)))
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(box10))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(box12))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(box11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(box14))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(box13))
                    .addComponent(box9))
                .addComponent(box15, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169)
                .addComponent(box24)
                .addGap(19, 19, 19)
                .addComponent(box26)
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(box28)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(box29))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(430, 430, 430)
                .addComponent(box22))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(590, 590, 590)
                .addComponent(box30))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(box2))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(490, 490, 490)
                .addComponent(box25))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(box16))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(410, 410, 410)
                .addComponent(box21))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(box20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(370, 370, 370)
                .addComponent(box19))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(450, 450, 450)
                .addComponent(box23))
            .addComponent(box1)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(330, 330, 330)
                .addComponent(box17))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(530, 530, 530)
                .addComponent(box27))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(350, 350, 350)
                .addComponent(box18))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addComponent(box8))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel3);

        jButton2.setText("AddToDoList");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
          jPanel3.setVisible(true);
             SetSelected();
        String set=jTextField1.getText();
        
        jTextField1.setText("");
        try{
            if(box1.getText().equals("")){
                box1.setVisible(true);
               box1.setText(set); 
               jTextField1.setText("");
            }
            else if(box2.getText().equals("")){
                 box2.setVisible(true);
                box2.setText(set);
                 jTextField1.setText("");
            }
            else if(box3.getText().equals("")){
                 box3.setVisible(true);
                box3.setText(set);
                 jTextField1.setText("");
            }
            else if(box4.getText().equals("")){
                 box4.setVisible(true);
                box4.setText(set);
                 jTextField1.setText("");
            }
            else if(box5.getText().equals("")){
                 box5.setVisible(true);
                box5.setText(set);
                 jTextField1.setText("");
            }
            else if(box6.getText().equals("")){
                 box6.setVisible(true);
                box6.setText(set);
                 jTextField1.setText("");
            }else if(box7.getText().equals("")){
                 box7.setVisible(true);
                box7.setText(set);
                 jTextField1.setText("");
            }else if(box8.getText().equals("")){
                 box8.setVisible(true);
                box8.setText(set);
                 jTextField1.setText("");
            }else if(box9.getText().equals("")){
                 box9.setVisible(true);
                box9.setText(set);
                 jTextField1.setText("");
            }
            else if(box10.getText().equals("")){
                 box10.setVisible(true);
                box10.setText(set);
                jTextField1.setText("");
            }
            else if(box11.getText().equals("")){
                 box11.setVisible(true);
                box11.setText(set);
                 jTextField1.setText("");
            } else if(box12.getText().equals("")){
                 box12.setVisible(true);
                box12.setText(set);
                 jTextField1.setText("");
            } else if(box13.getText().equals("")){
                 box13.setVisible(true);
                box13.setText(set);
                 jTextField1.setText("");
            } else if(box14.getText().equals("")){
                 box14.setVisible(true);
                box14.setText(set);
                 jTextField1.setText("");
            }else if(box15.getText().equals("")){
                 box15.setVisible(true);
                box15.setText(set);
                 jTextField1.setText("");
            }  else if(box16.getText().equals("")){
                 box16.setVisible(true);
                box16.setText(set);
                 jTextField1.setText("");
            } else if(box17.getText().equals("")){
                 box17.setVisible(true);
                box17.setText(set);
                 jTextField1.setText("");
                 
            } else if(box18.getText().equals("")){
                box18.setVisible(true);
                box18.setText(set);
                 jTextField1.setText("");
            } else if(box19.getText().equals("")){
                box19.setVisible(true);
                box19.setText(set);
                 jTextField1.setText("");
            } else if(box20.getText().equals("")){
                box20.setVisible(true);
                box20.setText(set);
                 jTextField1.setText("");
            } else if(box21.getText().equals("")){
                box21.setVisible(true);
                box21.setText(set);
                 jTextField1.setText("");
            } else if(box22.getText().equals("")){
                box22.setVisible(true);
                box22.setText(set);
                 jTextField1.setText("");
            } else if(box23.getText().equals("")){
                box23.setVisible(true);
                box23.setText(set);
                 jTextField1.setText("");
            } else if(box24.getText().equals("")){
                box24.setVisible(true);
                box24.setText(set);
                 jTextField1.setText("");
            } else if(box25.getText().equals("")){
                box25.setVisible(true);
                box25.setText(set);
                 jTextField1.setText("");
            } else if(box26.getText().equals("")){
                box26.setVisible(true);
                box26.setText(set);
                 jTextField1.setText("");
            } else if(box27.getText().equals("")){
                box27.setVisible(true);
                box27.setText(set);
                 jTextField1.setText("");
            }else if(box28.getText().equals("")){
                box28.setVisible(true);
                box28.setText(set);
                 jTextField1.setText("");
            }else if(box29.getText().equals("")){
                box29.setVisible(true);
                box29.setText(set);
                 jTextField1.setText("");
            }else if(box30.getText().equals("")){
                box30.setVisible(true);
                box30.setText(set);
                 jTextField1.setText("");
                 
               }else if(box30.getText()!=null){
                   JOptionPane.showMessageDialog(null,"you cant add to the todo list again please "
                           + "check for already finished task to add newer ones");
                 }
        }
        catch(Exception ex){
       
           
        }
            
            
            
    }//GEN-LAST:event_jButton2ActionPerformed

    private void box30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box30ActionPerformed
        if(box30.isSelected()){
            box30.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box30.setText("");
                box30.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your thirteith to do daily task "+box30.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box30.setSelected(false);
            }

        }
    }//GEN-LAST:event_box30ActionPerformed

    private void box29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box29ActionPerformed
        if(box29.isSelected()){
            box29.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box29.setText("");
                box29.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your twentynineth to do daily task "+box29.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box29.setSelected(false);
            }

        }
    }//GEN-LAST:event_box29ActionPerformed

    private void box28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box28ActionPerformed
        if(box28.isSelected()){
            box28.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box28.setText("");
                box28.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your twentyeighth to do daily task "+box28.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box28.setSelected(false);
            }

        }
    }//GEN-LAST:event_box28ActionPerformed

    private void box27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box27ActionPerformed
        if(box27.isSelected()){
            box27.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box27.setText("");
                box27.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your twenty seventh to do daily task "+box27.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box27.setSelected(false);
            }

        }
    }//GEN-LAST:event_box27ActionPerformed

    private void box26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box26ActionPerformed
        if(box26.isSelected()){
            box26.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box26.setText("");
                box26.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your twenty sixth to do daily task "+box26.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
            }

        }
    }//GEN-LAST:event_box26ActionPerformed

    private void box25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box25ActionPerformed
        if(box25.isSelected()){
            box25.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box25.setText("");
                box25.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your twenty fifth to do daily task "+box25.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box25.setSelected(false);
            }

        }
    }//GEN-LAST:event_box25ActionPerformed

    private void box24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box24ActionPerformed
        if(box24.isSelected()){
            box24.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box24.setText("");
                box24.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your twenty fourth to do daily task "+box24.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box24.setSelected(false);
            }

        }
    }//GEN-LAST:event_box24ActionPerformed

    private void box18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box18ActionPerformed
        if(box18.isSelected()){
            box18.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box18.setText("");
                box18.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your eighteenth to do daily task "+box18.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box18.setSelected(false);
            }

        }
    }//GEN-LAST:event_box18ActionPerformed

    private void box11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box11ActionPerformed
        if(box11.isSelected()){
            box11.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box11.setText("");
                box11.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your eleventh to do daily task "+box11.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box11.setSelected(false);
            }

        }
    }//GEN-LAST:event_box11ActionPerformed

    private void box9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box9ActionPerformed
        if(box9.isSelected()){
            box9.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box9.setText("");
                box9.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your nineth to do daily task "+box9.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box9.setSelected(false);
            }

        }
    }//GEN-LAST:event_box9ActionPerformed

    private void box19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box19ActionPerformed
        if(box19.isSelected()){
            box19.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box19.setText("");
                box19.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your nineteenth to do daily task "+box19.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box19.setSelected(false);
            }

        }
    }//GEN-LAST:event_box19ActionPerformed

    private void box17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box17ActionPerformed
        if(box17.isSelected()){
            box17.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box17.setText("");
                box17.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your seventeenth to do daily task "+box17.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box17.setSelected(false);
            }

        }
    }//GEN-LAST:event_box17ActionPerformed

    private void box16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box16ActionPerformed
        if(box16.isSelected()){
            box16.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
                box16.setText("");
                box16.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your sixteenth to do daily task "+box16.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box16.setSelected(false);
            }

        }
    }//GEN-LAST:event_box16ActionPerformed

    private void box20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box20ActionPerformed
        if(box20.isSelected()){
            box20.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box20.setText("");
                box20.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your twenteith to do daily task "+box20.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box20.setSelected(false);
            }

        }
    }//GEN-LAST:event_box20ActionPerformed

    private void box15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box15ActionPerformed
        if(box15.isSelected()){
            box15.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box15.setText("");
                box15.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your fifteenth to do daily task "+box15.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box15.setSelected(false);
            }

        }
    }//GEN-LAST:event_box15ActionPerformed

    private void box10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box10ActionPerformed
        if(box10.isSelected()){
            box10.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box10.setText("");
                box10.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your tenth to do daily task "+box10.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box10.setSelected(false);
            }

        }
    }//GEN-LAST:event_box10ActionPerformed

    private void box7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box7ActionPerformed
        if(box7.isSelected()){
            box7.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box7.setText("");
                box7.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your seventh to do daily task "+box7.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box7.setSelected(false);
            }

        }
    }//GEN-LAST:event_box7ActionPerformed

    private void box13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box13ActionPerformed
        if(box13.isSelected()){
            box13.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box13.setText("");
                box13.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your thirteeth to do daily task "+box13.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box13.setSelected(false);
            }

        }

    }//GEN-LAST:event_box13ActionPerformed

    private void box22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box22ActionPerformed
        if(box22.isSelected()){
            box22.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box22.setText("");
                box22.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your twenty second to do daily task "+box22.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box22.setSelected(false);
            }

        }
    }//GEN-LAST:event_box22ActionPerformed

    private void box8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box8ActionPerformed
        if(box8.isSelected()){
            box8.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box8.setText("");
                box8.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your eighth to do daily task "+box8.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box8.setSelected(false);
            }

        }
    }//GEN-LAST:event_box8ActionPerformed

    private void box12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box12ActionPerformed
        if(box12.isSelected()){
            box12.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box12.setText("");
                box12.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your twelveth to do daily task "+box12.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       
                
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box12.setSelected(false);
            }

        }

    }//GEN-LAST:event_box12ActionPerformed

    private void box6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box6ActionPerformed
        if(box6.isSelected()){
            box6.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box6.setText("");
                box6.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your sixth to do daily task "+box6.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box6.setSelected(false);
            }

        }
    }//GEN-LAST:event_box6ActionPerformed

    private void box14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box14ActionPerformed
        if(box14.isSelected()){
            box14.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box14.setText("");
                box14.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your fourteeth to do daily task "+box14.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box14.setSelected(false);
            }

        }
    }//GEN-LAST:event_box14ActionPerformed

    private void box5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box5ActionPerformed
        if(box5.isSelected()){
            box5.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
                box5.setText("");
                box5.setVisible(false);
                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your fifth to do daily task "+box5.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box5.setSelected(false);
            }

        }
    }//GEN-LAST:event_box5ActionPerformed

    private void box21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box21ActionPerformed
        if(box21.isSelected()){
            box21.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box21.setText("");
                box21.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your twenty first to do daily task "+box21.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box21.setSelected(false);
            }

        }
    }//GEN-LAST:event_box21ActionPerformed

    private void box23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box23ActionPerformed
        if(box23.isSelected()){
            box23.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box23.setText("");
                box23.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your twenty third to do daily task "+box23.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box23.setSelected(false);
            }

        }
    }//GEN-LAST:event_box23ActionPerformed

    private void box4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box4ActionPerformed
        if(box4.isSelected()){
            box4.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box4.setText("");
                box4.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your fourth to do daily task "+box4.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box4.setSelected(false);
            }

        }
    }//GEN-LAST:event_box4ActionPerformed

    private void box3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box3ActionPerformed
        if(box3.isSelected()){
            box3.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box3.setText("");
                box3.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your third to do daily task "+box3.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
       

            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box3.setSelected(false);
            }

        }
    }//GEN-LAST:event_box3ActionPerformed

    private void box2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box2ActionPerformed
        if(box2.isSelected()){
            box2.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
 
box2.setText("");
                box2.setVisible(false);
                                
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your second to do daily task "+box2.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
        
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box2.setSelected(false);
            }

        }
    }//GEN-LAST:event_box2ActionPerformed

    private void box1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_box1ActionPerformed
        if(box1.isSelected()){
            box1.setSelected(true);
            int show=JOptionPane.showConfirmDialog(null,"Are you sure you have completed this task?","Completion notice"
                + "",JOptionPane.YES_NO_OPTION);
            if(show==0){
                box1.setText("");
                box1.setVisible(false);
                
                 

                     
                check();
                try{
                            Email email = new SimpleEmail();
                            email.setHostName("smtp.googlemail.com");
                            email.setSmtpPort(465);
                            email.setAuthenticator(new DefaultAuthenticator("babaoyeoladele@gmail.com", "08029816042"));
                            email.setSSLOnConnect(true);
                            email.setFrom("babaoyeoladele@gmail.com");
                            email.setSubject("Notice Mail For Job Completion");
                            email.setMsg("Please take note that you have just marked finished your first to do daily task "+box1.getText());
                            email.addTo("babaoyeoladele@gmail.com");
                            email.send();
                            JOptionPane.showMessageDialog(null,"You have just been sent a to do completion mail");
                          }
                        catch(Exception ex){
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                           JOptionPane.showMessageDialog(null,"please check your internet connection error connecting with server");
                        }
                
            }else if(show==1){
                JOptionPane.showMessageDialog(null,"your to do action is restored and left for completion");
                box1.setSelected(false);
            }

        }
    }//GEN-LAST:event_box1ActionPerformed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
     if(evt.getKeyCode()==KeyEvent.VK_ENTER){
             jPanel3.setVisible(true);
             SetSelected();
        String set=jTextField1.getText();
        
        jTextField1.setText("");
        try{
            if(box1.getText().equals("")){
                box1.setVisible(true);
               box1.setText(set); 
               jTextField1.setText("");
            }
            else if(box2.getText().equals("")){
                 box2.setVisible(true);
                box2.setText(set);
                 jTextField1.setText("");
            }
            else if(box3.getText().equals("")){
                 box3.setVisible(true);
                box3.setText(set);
                 jTextField1.setText("");
            }
            else if(box4.getText().equals("")){
                 box4.setVisible(true);
                box4.setText(set);
                 jTextField1.setText("");
            }
            else if(box5.getText().equals("")){
                 box5.setVisible(true);
                box5.setText(set);
                 jTextField1.setText("");
            }
            else if(box6.getText().equals("")){
                 box6.setVisible(true);
                box6.setText(set);
                 jTextField1.setText("");
            }else if(box7.getText().equals("")){
                 box7.setVisible(true);
                box7.setText(set);
                 jTextField1.setText("");
            }else if(box8.getText().equals("")){
                 box8.setVisible(true);
                box8.setText(set);
                 jTextField1.setText("");
            }else if(box9.getText().equals("")){
                 box9.setVisible(true);
                box9.setText(set);
                 jTextField1.setText("");
            }
            else if(box10.getText().equals("")){
                 box10.setVisible(true);
                box10.setText(set);
                jTextField1.setText("");
            }
            else if(box11.getText().equals("")){
                 box11.setVisible(true);
                box11.setText(set);
                 jTextField1.setText("");
            } else if(box12.getText().equals("")){
                 box12.setVisible(true);
                box12.setText(set);
                 jTextField1.setText("");
            } else if(box13.getText().equals("")){
                 box13.setVisible(true);
                box13.setText(set);
                 jTextField1.setText("");
            } else if(box14.getText().equals("")){
                 box14.setVisible(true);
                box14.setText(set);
                 jTextField1.setText("");
            }else if(box15.getText().equals("")){
                 box15.setVisible(true);
                box15.setText(set);
                 jTextField1.setText("");
            }  else if(box16.getText().equals("")){
                 box16.setVisible(true);
                box16.setText(set);
                 jTextField1.setText("");
            } else if(box17.getText().equals("")){
                 box17.setVisible(true);
                box17.setText(set);
                 jTextField1.setText("");
                 
            } else if(box18.getText().equals("")){
                box18.setVisible(true);
                box18.setText(set);
                 jTextField1.setText("");
            } else if(box19.getText().equals("")){
                box19.setVisible(true);
                box19.setText(set);
                 jTextField1.setText("");
            } else if(box20.getText().equals("")){
                box20.setVisible(true);
                box20.setText(set);
                 jTextField1.setText("");
            } else if(box21.getText().equals("")){
                box21.setVisible(true);
                box21.setText(set);
                 jTextField1.setText("");
            } else if(box22.getText().equals("")){
                box22.setVisible(true);
                box22.setText(set);
                 jTextField1.setText("");
            } else if(box23.getText().equals("")){
                box23.setVisible(true);
                box23.setText(set);
                 jTextField1.setText("");
            } else if(box24.getText().equals("")){
                box24.setVisible(true);
                box24.setText(set);
                 jTextField1.setText("");
            } else if(box25.getText().equals("")){
                box25.setVisible(true);
                box25.setText(set);
                 jTextField1.setText("");
            } else if(box26.getText().equals("")){
                box26.setVisible(true);
                box26.setText(set);
                 jTextField1.setText("");
            } else if(box27.getText().equals("")){
                box27.setVisible(true);
                box27.setText(set);
                 jTextField1.setText("");
            }else if(box28.getText().equals("")){
                box28.setVisible(true);
                box28.setText(set);
                 jTextField1.setText("");
            }else if(box29.getText().equals("")){
                box29.setVisible(true);
                box29.setText(set);
                 jTextField1.setText("");
            }else if(box30.getText().equals("")){
                box30.setVisible(true);
                box30.setText(set);
                 jTextField1.setText("");
                 
               }else if(box30.getText()!=null){
                   JOptionPane.showMessageDialog(null,"you cant add to the todo list again please "
                           + "check for already finished task to add newer ones");
                 }
        }
        catch(Exception ex){
       
           
        }
     }
    }//GEN-LAST:event_jTextField1KeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox box1;
    private javax.swing.JCheckBox box10;
    private javax.swing.JCheckBox box11;
    private javax.swing.JCheckBox box12;
    private javax.swing.JCheckBox box13;
    private javax.swing.JCheckBox box14;
    private javax.swing.JCheckBox box15;
    private javax.swing.JCheckBox box16;
    private javax.swing.JCheckBox box17;
    private javax.swing.JCheckBox box18;
    private javax.swing.JCheckBox box19;
    private javax.swing.JCheckBox box2;
    private javax.swing.JCheckBox box20;
    private javax.swing.JCheckBox box21;
    private javax.swing.JCheckBox box22;
    private javax.swing.JCheckBox box23;
    private javax.swing.JCheckBox box24;
    private javax.swing.JCheckBox box25;
    private javax.swing.JCheckBox box26;
    private javax.swing.JCheckBox box27;
    private javax.swing.JCheckBox box28;
    private javax.swing.JCheckBox box29;
    private javax.swing.JCheckBox box3;
    private javax.swing.JCheckBox box30;
    private javax.swing.JCheckBox box4;
    private javax.swing.JCheckBox box5;
    private javax.swing.JCheckBox box6;
    private javax.swing.JCheckBox box7;
    private javax.swing.JCheckBox box8;
    private javax.swing.JCheckBox box9;
    public static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
