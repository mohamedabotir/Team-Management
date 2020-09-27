/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teammanagement;

import database.connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Threading
 */
public class TesterAction extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form TesterAction
     * @param data
     */
    ProgrammerData FileData;
    public TesterAction(ProgrammerData data) {
        initComponents();
        this.FileData=data;
        ProgrammerID.setText(String.valueOf(data.getId()));
        ProgrammerFile.setText(data.getFileName());
        AreaComment.setText(data.getComment());
        SubmissionDate.setText(String.valueOf(data.getTime()));
        Status.addItem("Approve");
        Status.addItem("Not Approve");
        submit.addActionListener(this);
        DownloadButton.addActionListener(this);
       
            
        pack();
        
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
     void DownlaodFile(ProgrammerData data) throws IOException, ClassNotFoundException{
     String SQL = "SELECT Filename,file FROM programmer WHERE id=?";

        Connection conn = null;
        java.sql.PreparedStatement smt = null;
        InputStream input = null;
        FileOutputStream output = null;
        ResultSet rs = null;
        connection DBConnection=new connection();
        try {

            Class.forName("com.mysql.jdbc.Driver");
          //  System.out.println("Connecting...");

          //  System.out.println("Connection successful..\nNow creating query...");
           conn=DBConnection.getConnection();
            smt = conn.prepareStatement(SQL);
            smt.setInt(1, data.getId());  //in this row we have a png picture
            rs = smt.executeQuery();
            File directory=new File(data.getFullname());
            output = new FileOutputStream(directory);

            while (rs.next()) {

                input = rs.getBinaryStream("Filename"); //get it from col name
                int r = 0;

    
   // there I've tried with array but nothing changed..Like this :
     byte[] buffer = new byte[2048];
     while((r = input.read(buffer)) != -1){
           output.write(buffer,0,r);}
    

              //  while ((r = input.read()) != -1) {
                //    output.write(r);

               // }
            }
JOptionPane.showMessageDialog(this, "DownloadedSucessfully:","'"+directory.getPath()+"'",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.err.println("Connection failed!");   
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.err.println("File not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("File writing error..!");
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    input.close();
                    output.flush();
                    output.close();
                    smt.close();
                    conn.close();
                }catch (SQLException e) {
                    System.err.println("Connot close connecton!");
                }
                // TODO Auto-generated catch block
                

            }
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

        jPanel1 = new javax.swing.JPanel();
        ProgrammerID = new javax.swing.JLabel();
        IDLabel = new javax.swing.JLabel();
        FileLabel = new javax.swing.JLabel();
        ProgrammerFile = new javax.swing.JLabel();
        LComment = new javax.swing.JLabel();
        DateLabel = new javax.swing.JLabel();
        SubmissionDate = new javax.swing.JLabel();
        Status = new javax.swing.JComboBox<>();
        LStatus = new javax.swing.JLabel();
        DownloadButton = new javax.swing.JButton();
        submit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        AreaComment = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ProgrammerID.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ProgrammerID.setText("ID");

        IDLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        IDLabel.setText("ID");

        FileLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        FileLabel.setText("FileName");

        ProgrammerFile.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ProgrammerFile.setText("File");

        LComment.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LComment.setText("comment");

        DateLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        DateLabel.setText("SubmissionDate");

        SubmissionDate.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        SubmissionDate.setText("SubmissionDate");

        Status.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Status.setMaximumRowCount(2);

        LStatus.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        LStatus.setText("Status");

        DownloadButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        DownloadButton.setText("DownloadFile");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(FileLabel)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(IDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(DateLabel))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ProgrammerID, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ProgrammerFile)
                                    .addComponent(SubmissionDate)))
                            .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LStatus)
                            .addComponent(DownloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LComment, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProgrammerID)
                    .addComponent(IDLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(FileLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DateLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ProgrammerFile)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SubmissionDate)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LStatus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(DownloadButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LComment)
                .addGap(38, 38, 38))
        );

        submit.setText("Submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        AreaComment.setColumns(20);
        AreaComment.setRows(5);
        jScrollPane1.setViewportView(AreaComment);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 13, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submit)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_submitActionPerformed

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
            java.util.logging.Logger.getLogger(TesterAction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TesterAction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TesterAction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TesterAction.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea AreaComment;
    private javax.swing.JLabel DateLabel;
    private javax.swing.JButton DownloadButton;
    private javax.swing.JLabel FileLabel;
    private javax.swing.JLabel IDLabel;
    private javax.swing.JLabel LComment;
    private javax.swing.JLabel LStatus;
    private javax.swing.JLabel ProgrammerFile;
    private javax.swing.JLabel ProgrammerID;
    private javax.swing.JComboBox<String> Status;
    private javax.swing.JLabel SubmissionDate;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==submit){
String StatusValue=(String)Status.getSelectedItem();
        if(StatusValue.equals("Approve"))
            JOptionPane.showMessageDialog(null, "SucessFull Coding...");
        else
                        JOptionPane.showMessageDialog(null, "Faild Coding...");

        }
        if(ae.getSource()==DownloadButton){
            try {
                DownlaodFile(FileData);
            } catch (IOException ex) {
JOptionPane.showMessageDialog(this, "Can't Downlaod File","'"+FileData.getFileName()+"'",JOptionPane.ERROR_MESSAGE);            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TesterAction.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
