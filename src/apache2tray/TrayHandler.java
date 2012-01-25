package apache2tray;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.AWTException;

public class TrayHandler {
    private Image[]    statusImages = new Image[2];
    private TrayIcon   trayicon;
    private SystemTray systemtray;
    
    public TrayHandler() {
        this.statusImages[0] = Toolkit.getDefaultToolkit().getImage("src/apache2tray/images/active.png");
        this.statusImages[1] = Toolkit.getDefaultToolkit().getImage("src/apache2tray/images/inactive.png");
        
        this.systemtray      = SystemTray.getSystemTray();
    }
    
    public void setTrayIcon(Boolean state) {
        if (true == state) {
            this.trayicon = new TrayIcon(this.statusImages[0], "Apache is running");
        } else {
            this.trayicon = new TrayIcon(this.statusImages[1], "Apache is not running");
        }
        
        this.trayicon.setImageAutoSize(true);  
        
        try {
            this.systemtray.add(this.trayicon);
        } catch (AWTException e) {
            System.err.println("TrayIcon could not be added.");
        }
    }
    
    public void changeTrayIcon(Boolean state) {
        if (true == state) {
            this.trayicon.setImage(this.statusImages[0]);
        } else {
            this.trayicon.setImage(this.statusImages[1]);
        }
    }

}
