/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teammanagement;

import database.connection;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Threading
 */
public class tester extends javax.swing.JFrame {

    ArrayList<String> name=new ArrayList<>();
    ArrayList<Integer> id=new ArrayList<>();
   final  private   ArrayList<JButton> buttons=new ArrayList<>();
    public tester() {
        JPanel p1=new JPanel();
        //initComponents();
        javax.swing.JButton b1=new javax.swing.JButton("555");
        get();
       int c = 0,i=name.size()-1;
        while( i>0)
        {c++;
        setLayout(new GridLayout(1,0));
            p1.setLayout(new GridLayout(c,0));
            
       
        buttons.add(new JButton(name.get(c)));
        
       
        i--; 
        
        }
       
       // c = 0;i=name.size()-1; 
        //buttons.ensureCapacity(i);
        for(int k=0;k<buttons.size();k++)
        {
        int ids=id.get(k)+1;
            JButton temp=buttons.get(k);
          temp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 if(ae.getSource()== temp){
                     JOptionPane.showMessageDialog(p1,"ID"+ids);
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
    
        try {
            co=con.getConnection();
            stmp=co.prepareStatement("select * from programmer");
            rs=stmp.executeQuery();
            int count=0;
            while(rs.next())
            {
                int ids=rs.getInt("id");
            String names=rs.getString("filename");
            
            name.add(names);
            id.add(ids);
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
}
