/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logs;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Threadig
 */
public class WriteLogs implements Cloneable{
    private BufferedWriter output;
   public void Write(String DateLog){
        
            try {
                output=new BufferedWriter(new FileWriter("Logs.txt",true));
                output.write(DateLog+"\n");
                output.close();
            } catch (IOException ex) {
                Logger.getLogger(WriteLogs.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(0);
            }
        catch(SecurityException e){
        System.err.println("You haven't Access For File");
       System.exit(0);
    }
    
}
}