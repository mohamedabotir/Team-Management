/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teammanagement;
import Annotation.Login;
import database.connection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author Threats
 */
@Login(Decription="")
public class GetLogin {
    MainFrame LogFrame=new MainFrame();
     GetLogin(){
         LogFrame.setVisible(true);
    Statement st;
    Connection co;
    ResultSet rs;
    connection con=new connection();
        try {
            co= con.getConnection();
            st=co.createStatement();
            rs=st.executeQuery("select name,password from user");
            
           while(rs.next()){
               String name=rs.getString("name");
               String password=rs.getString("password");
               System.out.println(name+":"+password);
               if(LogFrame.Name()==name)
                   System.out.println("asdadsd");
                   
               {
                   System.out.println(LogFrame.Name());
                   LogFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
               }
           }
        } catch (SQLException ex) {
            Logger.getLogger(GetLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
