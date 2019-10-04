/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package callenderframing;

import javaclasses.SettingWallPaper;
import callenderframing.mypanels.ScheduleInternal;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
/**
 *
 * @author babaoye ayomide
 */
public class SchedulerCalPage extends javax.swing.JFrame {
int xx;
int xy;
SettingWallPaper s;
     public static int realYear, realMonth, realDay, currentYear, currentMonth;
    public static int selectedDate, selectedMonth, selectedYear;
    public static SchedulerCalPage obj=null;
    public  SchedulerCalPage() {
        initComponents();
     jDesktopPane1.setVisible(false);
     GregorianCalendar gregCal = new GregorianCalendar();
            SchedulerCalPage.selectedDate=gregCal.get(GregorianCalendar.DAY_OF_MONTH);
            SchedulerCalPage.selectedMonth=gregCal.get(GregorianCalendar.MONTH)+1;
            SchedulerCalPage.selectedYear=gregCal.get(GregorianCalendar.YEAR);
            
            jLabel5.setText(SchedulerCalPage.selectedDate+"-"+SchedulerCalPage.selectedMonth+"-"+SchedulerCalPage.selectedYear);
    }
    public static SchedulerCalPage getObj(){
        if(obj==null){
            obj=new SchedulerCalPage();
                   }
        return obj;
    }
  void refreshCal(int month, int year)
        {
            String[] months =  {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
            
            int numOfDays;
            int startOfMonth;
            
            lblMonth.setText(months[month]);
            cmbYear.setSelectedItem(String.valueOf(year));
            
            btnNextMonth.setEnabled(true);
            btnNextYear.setEnabled(true);
            btnPrevMonth.setEnabled(true);
            btnPrevYear.setEnabled(true);
            if(month==11)
            {
                btnNextMonth.setEnabled(false);
            }
            if(month==0)
            {
                btnPrevMonth.setEnabled(false);
            }
            if(year==realYear-10)
            {
                btnPrevYear.setEnabled(false);
            }
            if(year==realYear+100)
            {
                btnNextYear.setEnabled(false);
            }
            
            //Clearing the previous values in calendar
            for(int i=0;i<6;i++)
            {
                for(int j=0;j<7;j++)
                {
                    calTable.setValueAt(null, i, j);    //Setting null value to every cell 
                }
            }
            
            GregorianCalendar calendar = new GregorianCalendar(year, month, 1); //Gives first day of the month
            numOfDays = calendar.getActualMaximum(GregorianCalendar.DAY_OF_MONTH); //Gives total Number of days
            startOfMonth=calendar.get(GregorianCalendar.DAY_OF_WEEK); // Gives the starting day
            System.out.println("startOfMonth = "+startOfMonth);
            System.out.println("numOfDays = "+numOfDays);
            
            
            // Making the new calendar
            
            for(int i=1;i<=numOfDays;i++)
            {
                int row = (i+startOfMonth-2)/7;
                
                int column  =  ((i+startOfMonth)%7-2%7 + 7)%7;
                
                calTable.setValueAt(i, row, column);
                
                calTable.setDefaultRenderer(calTable.getColumnClass(0), new TableCellRender());
            }
    
            
        }
        
        protected int getMonth(String month){
            int monthNumber=-1;
            if(month=="January")
            {
                monthNumber=1;
            }
            else if(month=="February")
            {
                monthNumber=2;
            }
            else if(month=="March")
            {
                monthNumber=3;
            }
            else if(month=="April")
            {
                monthNumber=4;
            }
            else if(month=="May")
            {
                monthNumber=5;
            }
            else if(month=="June")
            {
                monthNumber=6;
            }
            else if(month=="July")
            {
                monthNumber=7;
            }
            else if(month=="August")
            {
                monthNumber=8;
            }
            else if(month=="September")
            {
                monthNumber=9;
            }
            else if(month=="October")
            {
                monthNumber=10;
            }
            else if(month=="November")
            {
                monthNumber=11;
            }
            else if(month=="December")
            {
                monthNumber=12;
            }
            return monthNumber;
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnPrevMonth = new javax.swing.JButton();
        btnPrevYear = new javax.swing.JButton();
        lblMonth = new javax.swing.JLabel();
        btnNextMonth = new javax.swing.JButton();
        btnNextYear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        calTable = new javax.swing.JTable();
        cmbYear = new javax.swing.JComboBox<>();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 500));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 51));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Calender Menu");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 110, 350, 40);

        jLabel122.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel122.setText("-");
        jLabel122.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel122MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel122);
        jLabel122.setBounds(820, 0, 40, 30);

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

        btnPrevMonth.setText("<");
        btnPrevMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevMonthActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrevMonth);
        btnPrevMonth.setBounds(80, 170, 48, 23);

        btnPrevYear.setText("<<");
        btnPrevYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevYearActionPerformed(evt);
            }
        });
        getContentPane().add(btnPrevYear);
        btnPrevYear.setBounds(10, 170, 60, 23);

        lblMonth.setForeground(new java.awt.Color(255, 51, 51));
        lblMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMonth.setText("Month");
        getContentPane().add(lblMonth);
        lblMonth.setBounds(130, 160, 141, 30);

        btnNextMonth.setText(">");
        btnNextMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextMonthActionPerformed(evt);
            }
        });
        getContentPane().add(btnNextMonth);
        btnNextMonth.setBounds(280, 170, 45, 23);

        btnNextYear.setText(">>");
        btnNextYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextYearActionPerformed(evt);
            }
        });
        getContentPane().add(btnNextYear);
        btnNextYear.setBounds(330, 170, 57, 23);

        calTable.setModel(new DefaultTableModel());
        calTable.setEnabled(false);
        calTable.setSelectionForeground(new java.awt.Color(0, 102, 255));
        calTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calTablecalMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(calTable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 200, 375, 261);

        cmbYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbYearActionPerformed(evt);
            }
        });
        getContentPane().add(cmbYear);
        cmbYear.setBounds(120, 470, 147, 20);

        jDesktopPane1.setBackground(new java.awt.Color(240, 240, 240));
        jDesktopPane1.setForeground(new java.awt.Color(240, 240, 240));
        jDesktopPane1.setMinimumSize(new java.awt.Dimension(480, 420));
        jDesktopPane1.setVerifyInputWhenFocusTarget(false);
        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(400, 50, 480, 440);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(0, 102, 204));
        jButton1.setText("Schedule Event");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(250, 30, 120, 30);

        jLabel3.setText("Selected Date:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 10, 90, 30);

        jLabel4.setText("Present Date:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 60, 80, 30);
        getContentPane().add(jLabel7);
        jLabel7.setBounds(100, 10, 110, 30);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(100, 60, 110, 30);

        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Picturesdownloaded/NewLayer.jpg"))); // NOI18N
        jLabel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel1MouseDragged(evt);
            }
        });
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel1MousePressed(evt);
            }
        });
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 910, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrevMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevMonthActionPerformed
        if(currentMonth==0)
        {
            currentMonth=11;
            currentYear-=1;
        }
        else
        {
            currentMonth-=1;
        }
        refreshCal(currentMonth, currentYear);
    }//GEN-LAST:event_btnPrevMonthActionPerformed

    private void btnPrevYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevYearActionPerformed
        if(currentYear==realYear-100)
        {
            btnPrevYear.setEnabled(false);
        }
        else
        currentYear-=1;
        refreshCal(currentMonth,currentYear);
    }//GEN-LAST:event_btnPrevYearActionPerformed

    private void btnNextMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextMonthActionPerformed
        if(currentMonth==11)
        {
            currentMonth=0;
            currentYear+=1;
        }
        else
        {
            currentMonth+=1;
        }
        refreshCal(currentMonth, currentYear);
    }//GEN-LAST:event_btnNextMonthActionPerformed

    private void btnNextYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextYearActionPerformed
        if(currentYear==realYear+100)
        {
            btnNextYear.setEnabled(false);
        }
        else
        currentYear+=1;
        refreshCal(currentMonth,currentYear);
    }//GEN-LAST:event_btnNextYearActionPerformed

    private void calTablecalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calTablecalMouseClicked
        int row=calTable.rowAtPoint(evt.getPoint());          // Gets the row where the mouse is pointing
        int col= calTable.columnAtPoint(evt.getPoint());      // Gets the col where the mouse is pointing
        
        try
        {
            selectedDate=Integer.parseInt(calTable.getValueAt(row, col).toString());
        }
        catch(Exception e)
        {
            selectedDate=0;
            //e.printStackTrace();
        }
        System.out.println("Date: "+selectedDate);
        selectedMonth=getMonth(lblMonth.getText());
        System.out.println("Month: "+selectedMonth);
        try
        {
            selectedYear=Integer.parseInt(cmbYear.getSelectedItem().toString());
        }
        catch(Exception ex)
        {
            selectedYear=realYear;
        }
        System.out.println("Year: "+selectedYear);
        if(selectedDate>=1 && selectedDate<=31 && selectedMonth>=1 && selectedMonth<=12)
        {
            setBackground(Color.BLUE);
           jLabel7.setText(SchedulerCalPage.selectedDate+" / "+SchedulerCalPage.selectedMonth+" / "+SchedulerCalPage.selectedYear);
           
        }
        else if(evt.getClickCount()==2){
            setBackground(new Color(220,220,255));
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Invalid Date");
        }

    }//GEN-LAST:event_calTablecalMouseClicked

    private void cmbYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbYearActionPerformed
        currentYear=Integer.parseInt(cmbYear.getSelectedItem().toString());
        refreshCal(currentMonth, currentYear);
    }//GEN-LAST:event_cmbYearActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        GregorianCalendar gregCal = new GregorianCalendar();
        realDay = gregCal.get(GregorianCalendar.DAY_OF_MONTH);
        realMonth = gregCal.get(GregorianCalendar.MONTH);
        realYear = gregCal.get(GregorianCalendar.YEAR);
        currentMonth = realMonth;
        currentYear = realYear;
        
        System.out.println("realYear="+realYear);
        System.out.println("realMonth="+realMonth);
        
        
        DefaultTableModel tableModel=(DefaultTableModel)calTable.getModel();
        String[] headers = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers

        for (int i=0; i<7; i++)
        {
            tableModel.addColumn(headers[i]);
        }
        
        calTable.setColumnSelectionAllowed(true);
        calTable.setRowSelectionAllowed(true);
        calTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        calTable.setRowHeight(38);
        tableModel.setRowCount(6);
        tableModel.setColumnCount(7);
        
        for (int i=realYear-100; i<=realYear+100; i++)
        {
            cmbYear.addItem(String.valueOf(i));
        }


        
        refreshCal(realMonth, realYear);
    }//GEN-LAST:event_formWindowOpened

    private void jLabel122MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel122MouseClicked
        this.setState(ICONIFIED);
    }//GEN-LAST:event_jLabel122MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        setVisible(false);
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jDesktopPane1.setVisible(true);
          ScheduleInternal intern=new ScheduleInternal();
          jDesktopPane1.add(intern);
          intern.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseDragged
      int x=evt.getXOnScreen();
        int y=evt.getYOnScreen();
        this.setLocation(x-xx, y-xy);
    }//GEN-LAST:event_jLabel1MouseDragged

    private void jLabel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MousePressed
         xx=evt.getX();
        xy=evt.getY();
    }//GEN-LAST:event_jLabel1MousePressed

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
            java.util.logging.Logger.getLogger(SchedulerCalPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchedulerCalPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchedulerCalPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchedulerCalPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchedulerCalPage().setVisible(true);
            }
        });
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNextMonth;
    private javax.swing.JButton btnNextYear;
    private javax.swing.JButton btnPrevMonth;
    private javax.swing.JButton btnPrevYear;
    private javax.swing.JTable calTable;
    private javax.swing.JComboBox<String> cmbYear;
    private javax.swing.JButton jButton1;
    public static javax.swing.JDesktopPane jDesktopPane1;
    public static javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblMonth;
    // End of variables declaration//GEN-END:variables
}

