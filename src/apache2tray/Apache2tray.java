package apache2tray;

import java.util.Timer;
import java.util.TimerTask;

public class Apache2tray {
    public static void main(String[] args) {
        final TrayHandler    trayhandler    = new TrayHandler();
        final ConsoleHandler consolehandler = new ConsoleHandler();
        Timer timer = new Timer();
                
        Boolean apacheStatus = consolehandler.getApacheStatus();
        trayhandler.setTrayIcon(apacheStatus);
        
        timer.scheduleAtFixedRate(new TimerTask() {   
            @Override
            public void run() {
                Boolean apacheStatus = consolehandler.getApacheStatus();
                trayhandler.updateTrayIcon(apacheStatus);
            }
        }, 0, 5000);
    }
}