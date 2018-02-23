/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.rubictron.posfinal.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rubictron
 */
public class ConnectionFactory {
    private static ConnectionFactory dbConnection;
    private Connection connection;
    
    
    private ConnectionFactory() throws ClassNotFoundException, SQLException{
            Class.forName("com.mysql.jdbc.Driver");
            connection=DriverManager.getConnection("jdbc:mysql://localhost/posf","root","1212");
    }


    public Connection getConnection() {
        return connection;
    }

    public static ConnectionFactory getInstance() {
        if(dbConnection==null){
            try {
                dbConnection=new ConnectionFactory();
                
            } catch (ClassNotFoundException | SQLException ex) {
                
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return dbConnection;
    }
    
}
