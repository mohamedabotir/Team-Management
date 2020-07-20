/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threading;

import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import teammanagement.Loading;
import teammanagement.MainFrame;

/**
 *
 * @author Threadig
 */
public class Task implements Runnable{
volatile boolean Start=false;
Thread T;
Loading s;
MainFrame m;
LinkedList <String> l=new LinkedList<>();
public Task(Loading s,MainFrame m){
    this.s=s;
    this.m=m;
T=new Thread(this,"Task");
T.start();
}
    @Override
    public void run() {
        synchronized(s){
       try { 
           
           while(Start==true){
            
                Thread.sleep(12);
                m.fetch();
                if(m.getFinish()==true)
                    break;
                wait();
            }} catch (InterruptedException ex) {
                Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
            }
            
                
            
        }
        }
    
  public synchronized  void Start(){
    Start=true;
    notify();
    }
 public void setStart(boolean flag){Start=flag;}
   public void Stop(){
    Start=false;
    }
    
}
