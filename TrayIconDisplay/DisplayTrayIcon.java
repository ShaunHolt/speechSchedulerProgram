package trayicondisplay;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DisplayTrayIcon{
         static TrayIcon trayIcon;
    public DisplayTrayIcon() throws IOException{
    ShowTrayIcon();
    }
    
    public void ErrorMessages(){
    DisplayTrayIcon.trayIcon.displayMessage("System Error", "The system has encontered a vital error", TrayIcon.MessageType.ERROR);
    DisplayTrayIcon.trayIcon.displayMessage("System Error", "The system has encontered a vital error", TrayIcon.MessageType.INFO);
    DisplayTrayIcon.trayIcon.displayMessage("System Error", "The system has encontered a vital error", TrayIcon.MessageType.WARNING);
    DisplayTrayIcon.trayIcon.displayMessage("System Error", "The system has encontered a vital error", TrayIcon.MessageType.NONE);
    
    }
public static void ShowTrayIcon() throws IOException{
if(!SystemTray.isSupported()){
    JOptionPane.showMessageDialog(null,"Your System does not support Tray Icons");
    System.exit(0);
}
//URL filePath=getClass().getResource("/sound/railroad_crossing_bell-Brylon_Terry.wav");
final PopupMenu pop=new PopupMenu();
trayIcon=new TrayIcon(CreateIcon("/TrayImage.jpg","TrayIcon"));
final SystemTray st=SystemTray.getSystemTray();
trayIcon.setToolTip("Version 1.1.21/SpeechControlledScheduler");

Menu menu=new Menu("menu");

//Add Component/menu items
MenuItem AboutItem=new MenuItem("About");
MenuItem exitItem=new MenuItem("Exit");
MenuItem errorItem=new MenuItem("About");
MenuItem WarninigItem=new MenuItem("Exit");
MenuItem NormalItem=new MenuItem("About");
MenuItem InfoItem=new MenuItem("Exit");

pop.add(AboutItem);
pop.addSeparator(); 
pop.add(exitItem);

//populate the message display menu
menu.add(errorItem);

trayIcon.setPopupMenu(pop);

AboutItem.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
       JOptionPane.showMessageDialog(null, "created by Babaoye Ayomide");
    }
});

exitItem.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        st.remove(trayIcon);
        System.exit(0);
    }
});


try{ 
    st.add(trayIcon);
    
}
catch(AWTException e){

}
 
}
public static Image CreateIcon(String path,String desc) throws IOException{
   
            
                 File f=new File("picturesdownloaded/TrayImage.jpg");
                 System.out.println(f.getCanonicalPath()+" "+f.exists());
                 URL url;
                 url = Class.class.getResource(path);
                
//URL imageUrl=Class.class.getResource(path);
//return (new ImageIcon(imageUrl,desc)).getImage();
             
             return (new ImageIcon(url,desc)).getImage();
}
}