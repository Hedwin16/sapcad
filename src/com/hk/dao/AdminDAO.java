package com.hk.dao;

import com.hk.connection.Conexion;
import com.hk.interfaces.IAdmin;
import com.hk.models.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;

public class AdminDAO implements IAdmin{    
    String sql = "";
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public Admin buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(Admin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Admin> mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Admin t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validarSesion(String usuario, String clave) {
        sql = "SELECT * FROM administradores WHERE usuario=? AND clave=? AND estado=1";
        
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
        
            rs = ps.executeQuery();
            if(rs.next()){
                //Conexion.getInstance().closeConnection();
                return true;
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
            JOptionPane.showMessageDialog(null, e);
        }
        
        return false;
    }
    
}
