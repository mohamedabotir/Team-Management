/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teammanagement;

import database.connection;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Threats
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        
         jButton1.setBackground(new Color(255, 255, 255));
         Footer.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                Footer.setBackground(new Color(51, 51, 0));
                Copy.setForeground(new Color(255, 255, 255));
            }

            @Override
            public void mouseExited(MouseEvent me) {
                
                Footer.setBackground(new Color(127, 127, 127));
                Copy.setForeground(Color.black);
            }
        });
         
        jButton1.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
                jButton1.setBackground(new Color(129, 152, 48));
               
               
            }

            @Override
            public void mouseExited(MouseEvent me) {
               // jButton1.setBackground(new Color(21,25,25));
               jButton1.setBackground(new Color(255, 255, 255));
                
            }
        });
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               if(ae.getSource()==jButton1)
                try {
                    login();
               } catch (SQLException ex) {
                   Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
               }
            }
        });
    }
void login() throws SQLException
{
    String nam=TName.getText() ;
    String pass=String.valueOf(TPassword.getPassword());
Statement st=null;
    Connection co=null;
    ResultSet rs=null;
    connection con=new connection();
        try {
            co= con.getConnection();
            st=co.createStatement();
            rs=st.executeQuery("select * from user where name='"+nam+"' and password='"+pass+"'");
            
           while(rs.next()){
               String name=rs.getString("name");
               String password=rs.getString("password");
               
                   System.out.println(Name());
                   JOptionPane.showMessageDialog(this,"Succesfull Done");
                  dispose();
               
           }
        } catch (SQLException ex) {
            Logger.getLogger(GetLogin.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            co.close();
        st.close();
        }
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        LPassword = new javax.swing.JLabel();
        TName = new javax.swing.JTextField();
        TPassword = new javax.swing.JPasswordField();
        SloganP = new javax.swing.JPanel();
        Slogan = new javax.swing.JLabel();
        LName = new javax.swing.JLabel();
        Footer = new javax.swing.JPanel();
        Copy = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MangamentSystme vr1.0");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(getIconImages());
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(125, 147, 46));

        jButton1.setText("Login");

        LPassword.setForeground(new java.awt.Color(255, 255, 255));
        LPassword.setText("Password");

        TName.setToolTipText("user Name");
        TName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TNameActionPerformed(evt);
            }
        });

        TPassword.setToolTipText("Password");
        TPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TPasswordActionPerformed(evt);
            }
        });

        SloganP.setBackground(new java.awt.Color(125, 147, 46));

        Slogan.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        Slogan.setForeground(new java.awt.Color(204, 204, 255));
        Slogan.setText("THF");

        LName.setForeground(new java.awt.Color(255, 255, 255));
        LName.setText("Name");

        javax.swing.GroupLayout SloganPLayout = new javax.swing.GroupLayout(SloganP);
        SloganP.setLayout(SloganPLayout);
        SloganPLayout.setHorizontalGroup(
            SloganPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SloganPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Slogan, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SloganPLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LName))
        );
        SloganPLayout.setVerticalGroup(
            SloganPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SloganPLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Slogan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LName)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SloganP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(LPassword)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(TName))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(TName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(SloganP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LPassword)
                    .addComponent(TPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        Footer.setBackground(new java.awt.Color(127, 127, 127));

        Copy.setText("All Work © Copy Rights TheHightFuture");

        javax.swing.GroupLayout FooterLayout = new javax.swing.GroupLayout(Footer);
        Footer.setLayout(FooterLayout);
        FooterLayout.setHorizontalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FooterLayout.createSequentialGroup()
                .addComponent(Copy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        FooterLayout.setVerticalGroup(
            FooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Copy, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Footer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Footer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TNameActionPerformed

    private void TPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TPasswordActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    public  String Name() {
        return TName.getText();
    }

    public char[] Password() {
        return TPassword.getPassword();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Copy;
    private javax.swing.JPanel Footer;
    private javax.swing.JLabel LName;
    private javax.swing.JLabel LPassword;
    private javax.swing.JLabel Slogan;
    private javax.swing.JPanel SloganP;
    private javax.swing.JTextField TName;
    private javax.swing.JPasswordField TPassword;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
