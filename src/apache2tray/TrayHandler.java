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
    /**
     * The state of apache when last calling updateTrayIcon(). Used to 
     * prevent a periodical update of the tray icon with the same image.
     */
    private Boolean    lastState;
    
    /**
     * Adds the status Images to the statusImages array and gets the system tray.
     */
    public TrayHandler() {
        this.statusImages[0] = Toolkit.getDefaultToolkit().getImage("src/apache2tray/images/active.png");
        this.statusImages[1] = Toolkit.getDefaultToolkit().getImage("src/apache2tray/images/inactive.png");
        
        this.systemtray      = SystemTray.getSystemTray();
    }
    
    /**
     * Checks if Apache is running or not and sets the adequate icon. Only used on
     * Application startup.
     * @param state Weather Apache is running (true) or not (false) 
     */
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
    
    /**
     * Checks if the state of Apache has changed since the last time this function
     * was called and if so updates the Apache icon. 
     * @param state Weather Apache is running (true) or not (false) 
     */
    public void updateTrayIcon(Boolean state) {
        if (lastState == state) {
            return;
        }
        
        if (true == state) {
            this.trayicon.setImage(this.statusImages[0]);
        } else {
            this.trayicon.setImage(this.statusImages[1]);
        }
        
        this.lastState = state;
    }

}
