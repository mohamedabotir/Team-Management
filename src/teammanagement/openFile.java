/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teammanagement;

import java.awt.BorderLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Threading
 */
public class openFile extends JFrame{
    JTextArea file;
    JScrollPane scpane;
    Scanner input;
    openFile(){
        super("OpenFile");
        file=new JTextArea();
        scpane=new JScrollPane(file);
        add(scpane,BorderLayout.CENTER);
        this.setSize(300, 400);
    getFile();
    
    }
    File getPath(){
    JFileChooser f=new JFileChooser();
    f.setFileSelectionMode(JFileChooser.FILES_ONLY);
   int result= f.showOpenDialog(this);
   if(result==JFileChooser.CANCEL_OPTION)
       System.exit(0);
    File name=f.getSelectedFile();
    return name;
    }
    void getFile(){
    File name=getPath();
        try {
            input=new Scanner(new File(name.getAbsolutePath()));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(this,"Error:","NotFoundFile",JOptionPane.ERROR_MESSAGE);
        }
        while(input.hasNext()){
            file.append(input.next()+"\n");
            
        
        }
    }
     public static  void main(String args[]){
         openFile s=new openFile();
         s.setVisible(true);
         s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }

    
}
