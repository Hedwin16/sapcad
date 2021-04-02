
package com.hk.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static Conexion handler = null;
    
    private static String DB_URL = "jdbc:mysql://localhost:3306/bd_sapcad";
    private static String USER = "root";
    private static String PASS = "1234";
    private static Connection cnx = null;
    
    private Conexion(){
        
    }
    
    static{
        createConnection();
    }
    
    public static Conexion getInstance() {
        if (handler == null) {
            handler = new Conexion();
        }
        return handler;
    }
    
    private static void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(DB_URL, USER, PASS);
        }
        catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Cant load database", "Database Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    public Connection getConnection() {
        return cnx;
    }
    
    public void closeConnection(){
        try {
            cnx.close();
        } catch (Exception e) {
            System.out.println("error de cierre de conexion: "+e);
        }
    }
}
