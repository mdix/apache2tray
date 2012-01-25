package apache2tray;

import java.io.*;

public class ConsoleHandler {
    private String[] command = { "/bin/sh", "-c", "ps -eaf | grep httpd | grep -v grep | wc -l" };
    private Runtime  shell;
    
    public ConsoleHandler() {
        this.shell = Runtime.getRuntime();
    }
    
    public Boolean getApacheStatus() {
        try {
            Process pr = this.shell.exec(this.command);
            pr.waitFor();
            BufferedReader buf = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            return this.apacheIsRunning(Integer.parseInt(buf.readLine()));
        } catch (IOException e) {
            System.err.println("IOException in ConsoleHandler" + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("InterruptedException in ConsoleHandler: " + e.getMessage());
        }
        
        return false;
    }
    
    public Boolean apacheIsRunning(Integer numberOfProcesses) {
        if (numberOfProcesses > 0) {
            return true;
        }
        return false;
    }
    
}
