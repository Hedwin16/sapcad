package com.hk.dao;

import com.hk.connection.Conexion;
import com.hk.interfaces.IEmpleado;
import com.hk.models.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpleadoDAO implements IEmpleado{
    String sql = "";
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public boolean insertar(Empleado t) {
        sql = "INSERT INTO empleados(nombres,apellidos,ci_empleado,id_departamento,cargo,estado) VALUES(?,?,?,?,?,1)";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApellidos());
            ps.setInt(3, t.getCi());
            ps.setInt(4, t.getId_departamento());
            ps.setString(5, t.getCargo());
            
            if(ps.executeUpdate() == 1){
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar administrador: "+ e);
        }
        return false;
    }

    @Override
    public List<Empleado> mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Empleado t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIdNuevoEmpleado() {
        int id= 0;
        sql = "SELECT * FROM empleados ORDER BY id_empleado DESC LIMIT 1";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
        while(rs.next()){
            id = rs.getInt("id_empleado");
            System.out.println("id: "+id);
        }
        } catch (Exception e) {
            System.out.println("Exception: "+e);
        }
        return id;
    }
    
}
