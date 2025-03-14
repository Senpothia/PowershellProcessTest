/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package powershellprocesstest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michel
 */
public class PowershellProcessTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Getting the version
        //String command = "powershell.exe  Get-PnPDevice | Where-Object{$_.PNPClass -in 'Ports'} | Out-File -FilePath C:\\Users\\Michel\\Desktop\\ports.txt";
        String command = "powershell.exe  Get-Process -ProcessName java | Out-File -FilePath C:\\Users\\Michel\\Desktop\\process.txt";
        // Executing the command
        Process powerShellProcess;
        try {
            powerShellProcess = Runtime.getRuntime().exec(command);
            powerShellProcess.getOutputStream().close();
            String line;
            System.out.println("Standard Output:");
            BufferedReader stdout = new BufferedReader(new InputStreamReader(
                    powerShellProcess.getInputStream()));
            while ((line = stdout.readLine()) != null) {
                System.out.println(line);
            }
            stdout.close();
            System.out.println("Standard Error:");
            BufferedReader stderr = new BufferedReader(new InputStreamReader(
                    powerShellProcess.getErrorStream()));
            while ((line = stderr.readLine()) != null) {
                System.out.println(line);
            }
            stderr.close();
            System.out.println("Done");
        } catch (IOException ex) {
            Logger.getLogger(PowershellProcessTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Getting the results

    }

}
