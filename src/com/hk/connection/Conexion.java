
package com.hk.connection;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.hk.models.AjusteBD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static Conexion handler = null;
    
    private static String DB_URL = "";
    private static String USER = "root";
    private static String PASS = "";
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
            setAjustes();
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
    
    private static void setAjustes(){
        try {
            String json = "";
            BufferedReader br = new BufferedReader(new FileReader("config.json"));
            String linea = "";
            while((linea = br.readLine()) != null){
                json += linea;
            }
            Gson gson = new Gson();
            AjusteBD config = gson.fromJson(json, AjusteBD.class);
            
            USER = config.getUsuario();
            PASS = config.getClave();
            DB_URL = "jdbc:mysql://"+config.getHost()+":"+config.getPuerto()+"/bd_sapcad";
            System.out.println("Usuario BD Logeado: "+config.getUsuario());
            System.out.println("Dirección de Base de Datos: "+DB_URL);
        } catch (IOException | JsonSyntaxException e) {
            System.out.println("Error obteniendo los ajustes: "+e);
        }
    }
}
