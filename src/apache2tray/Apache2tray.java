package apache2tray;

import java.util.*;

public class Apache2tray {
    public static void main(String[] args) {
        final TrayHandler trayhandler       = new TrayHandler();
        final ConsoleHandler consolehandler = new ConsoleHandler();
        Timer timer = new Timer();
                
        Boolean apacheStatus = consolehandler.getApacheStatus();
        trayhandler.setTrayIcon(apacheStatus);
        
        timer.scheduleAtFixedRate(new TimerTask() {            
            public void run() {
                Boolean apacheStatus = consolehandler.getApacheStatus();
                trayhandler.changeTrayIcon(apacheStatus);
            }
        }, 0, 5000);
    }
}























/*
public class Apache2tray {
    public static void main(String[] args) {
        SystemTray tray = SystemTray.getSystemTray();
        Image image  = Toolkit.getDefaultToolkit().getImage("src/apache2tray/images/tray.gif");
        Image image2 = Toolkit.getDefaultToolkit().getImage("src/apache2tray/images/tray2.gif");
        
        TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
        trayIcon.setImageAutoSize(true);  
        
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.err.println("TrayIcon could not be added.");
        }

        int delay = 5000;   // delay for 5 sec.
        int period = 1000;  // repeat every sec.
        Timer timer = new Timer();

        timer.scheduleAtFixedRate(new TimerTask() {
            String[] cmd = { "/bin/sh", "-c", "ps -eaf | grep httpd | grep -v grep | wc -l" };
            Runtime  run = Runtime.getRuntime() ;
            
            public void run() {
                try {
                    Process pr = run.exec(cmd) ;
                    pr.waitFor();
                    BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

                    int numberProcesses = Integer.parseInt(buf.readLine());
                    if (numberProcesses > 0) {
                        //trayIcon.setImage(image2);
                        System.out.println("running");
                    } else {
                        //trayIcon.setImage(image);
                        System.out.println("not running");
                    }
 
                } catch (IOException e) {

                } catch (InterruptedException e) {

                }

            }
        }, delay, period);

    }
}
*/