
package com.questions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyConnection {
    
    
    private static Connection connection = null;
    
    public static Connection getMyConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if(connection == null){
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/controle", "root", "FranceLondre1.");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }
    
    public static void closeMyConnection(){
        try {
            if(connection != null || !connection.isClosed()){
                connection.close();
                connection = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
