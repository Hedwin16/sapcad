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
    int tipoAdmin = 0;

    @Override
    public Admin buscar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean insertar(Admin t) {
        sql = "INSERT INTO administradores(usuario,clave,tipo,estado) VALUES(?,?,?,1)";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, t.getUsuario());
            ps.setString(2, t.getClave());
            ps.setInt(3, t.getTipo());
            
            System.out.println(ps.executeUpdate()); 
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar administrador: "+ e);
        }
        return false;
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
                this.tipoAdmin = rs.getInt("tipo");
                return true;
                
            }
        } catch (Exception e) {
            System.out.println("error: "+e);
            JOptionPane.showMessageDialog(null, e);
        }
        
        return false;
    }

    @Override
    public boolean existeAdministrador() {
        sql = "SELECT * FROM administradores";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }  
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Verificar Administradores: "+e);
        }
        return false;
    }
    
    @Override
    public int getTipoAdmin(){
        return this.tipoAdmin;
    }
}
