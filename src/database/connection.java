/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 *
 * @author Threats
 */
public class connection {
    int port;
    String name,password,DB,server;
    public connection()
    {
        this.name="root";
        this.password="Kampo";
        this.server="localhost";
        this.DB="team";
        this.port=3307;
    }
    public Connection getConnection ()throws SQLException{
        Properties connection_info=new Properties();
        connection_info.put("user",name);
        connection_info.put("password",password);
        return DriverManager.getConnection("jdbc:mysql://"+server+":"+port+"/"+DB,connection_info);
    
    }
}
