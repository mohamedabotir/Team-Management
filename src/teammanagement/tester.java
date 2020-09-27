/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teammanagement;

import database.connection;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
/**
 *
 * @author Threading
 */
public class tester extends javax.swing.JFrame {

    ArrayList<String> name=new ArrayList<>();
    ArrayList<ProgrammerData> id=new ArrayList<>();
    
   final  private   ArrayList<JButton> buttons=new ArrayList<>();
    public tester() {
        JPanel p1=new JPanel();
        //initComponents();
        
        this.get();
       int c = 0,i=name.size()-1; 
        while( i>=0)
        {
        //setLayout(new GridLayout(1,0));
        p1.setLayout(new GridLayout(c+1,0));    
       
        buttons.add(new JButton(name.get(c)));
       c++;
        i--; 
        
        }
       
       // c = 0;i=name.size()-1; 
        //buttons.ensureCapacity(i);
       
        for(int k=0;k<buttons.size();k++)
        {
            int ids=id.get(k).getId();
            String file=id.get(k).getFileName();
            Date filedate=id.get(k).getTime();
            JButton temp=buttons.get(k);
            ProgrammerData data=id.get(k);
          temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 if(ae.getSource()== temp){
                   //  JOptionPane.showMessageDialog(p1,"ID"+ids+" File Name:"+file+"\nSubmissionDate:"+filedate);
                    TesterAction s=new TesterAction(data);
                     s.setVisible(true);
                 }
            }
        });
        p1. add(buttons.get(k));
       
        }
       
        add(p1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    void get(){
        Connection co=null;
        ResultSet  rs=null;
        PreparedStatement stmp=null;
    connection con=new connection();
    ProgrammerData data;
        try {
            co=con.getConnection();
            stmp=co.prepareStatement("select * from programmer");
            rs=stmp.executeQuery();
            int count=0;
            while(rs.next())
            {
                int ids=rs.getInt("id");
            String names=rs.getString("filename");
            String comment=rs.getString("comment");
            Date time=rs.getDate("SubmissionDate");
            data=new ProgrammerData();
            data.setComment(comment);
            data.setFileName(names);
            data.setId(ids);
            data.setTime(time);
            name.add(names);
            id.add(data);
            System.out.println(id.get(count));
            count++;                    
            }
        } catch (SQLException ex) {
            Logger.getLogger(tester.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        if(con!=null)
        {
            try {
                stmp.close();
                rs.close();
                co.close();
            } catch (SQLException ex) {
                Logger.getLogger(tester.class.getName()).log(Level.SEVERE, null, ex);
            }
       ;
        }
        }
    
    }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tester.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tester().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
class info_File extends JFrame{
JLabel ID_Project;
JLabel File_name;
JLabel name=new JLabel("Name");
JLabel ID=new JLabel("ID");
String []status={"Approve","Not Approve"};
JButton submit=new JButton("Submit");
JComboBox cstatus=new JComboBox(status);    
JPanel p1=new JPanel();
JPanel p2=new JPanel();
JPanel p3=new JPanel();
        
public void  set_ID_Project(int id){
    ID_Project=new JLabel(String.valueOf(id));
}
public void  set_File_name(String name){
    File_name=new JLabel(name);
}
void run(){
name.setLabelFor(File_name);
ID.setLabelFor(ID_Project);
p1.setLayout(new GridLayout(2,2));
p1.add(name);
p1.add(File_name);p1.add(ID);
p1.add(ID_Project);
p2.setLayout(new GridLayout(1,0));
cstatus.setBounds(50, 50,90,20);
p3.setLayout(new GridLayout(1,0));
p3.add(cstatus);
p2.add(submit);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
add(p1,BorderLayout.NORTH);
add(p2,BorderLayout.SOUTH);
add(p3,BorderLayout.CENTER);
    pack();
    submit.addActionListener(new ActionListener() {
        
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object selected=cstatus.getSelectedItem();
        if(ae.getSource()==submit)
            JOptionPane.showMessageDialog(p2, selected);
    }
});
}
}
}
