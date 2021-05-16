package com.hk.dao;

import com.hk.connection.Conexion;
import com.hk.interfaces.IEmpleado;
import com.hk.models.Empleado;
import com.hk.models.EntrenamientoLBPH;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EmpleadoDAO implements IEmpleado{
    String sql = "";
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public boolean insertar(Empleado t) {
        sql = "INSERT INTO empleados(nombres,apellidos,ci_empleado,id_departamento,cargo) VALUES(?,?,?,?,?)";
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
        List<Empleado> list = new ArrayList<>();
        
        sql = "SELECT * FROM empleados ORDER BY id_empleado";
        
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Empleado(  rs.getInt(1), 
                                        rs.getString(2), 
                                        rs.getString(3),
                                        rs.getInt(4),
                                        rs.getInt(5),
                                        rs.getString(6)));
            }
            
            return list;
        } catch (SQLException e) {
            System.out.println("Lista de Empleados: "+e);
        }
        
        return list;
    }

    @Override
    public boolean actualizar(Empleado t) {
        sql ="UPDATE empleados SET nombres=?, apellidos=?, ci_empleado=?, id_departamento=?, cargo=? WHERE id_empleado=?";
        try {
            ps = Conexion.getInstance().getConnection().prepareCall(sql);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApellidos());
            ps.setInt(3, t.getCi());
            ps.setInt(4, t.getId_departamento());
            ps.setString(5, t.getCargo());
            ps.setInt(6, t.getId_empleado());
            return ps.executeUpdate()>0;
            
        } catch (Exception e) {
            System.out.println("Update empleado: "+e);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        sql = "DELETE FROM empleados WHERE id_empleado=?";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            if(ps.executeUpdate()>0){
                System.out.println("Borrando Fotos");
                int cont = 1;
                for (int i = 0; i < 200; i++) {
                    File photo = new File("recursos/fotos/persona."+id+"."+cont+".jpg");
                    System.out.println(photo.toString());
                    photo.delete();
                    cont++;
                }
                //Entrenamiento
                File clasificador = new File("recursos/fotos/clasificador.yml");
                clasificador.delete();
                sql = "SELECT * FROM empleados";
                ps = Conexion.getInstance().getConnection().prepareStatement(sql);
                rs = ps.executeQuery();
                if(rs.next()){
                    System.out.println("Reentrenando");
                    new EntrenamientoLBPH().trainPhotos();
                    return true;
                }else{
                    System.out.println("Último empleado eliminado..");
                    return true;
                }
                
            }
        } catch (Exception e) {
            System.out.println("Eliminar Empleado exception: "+e);
        }
        return false;
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
    
    @Override
    public Empleado getEmpleadoPorId(int id){
        sql = "SELECT * FROM empleados WHERE id_empleado=?";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                return new Empleado(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6)
                );
            }
        } catch (Exception e) {
            System.out.println("Exception in getEmpleadoReconocido: "+e);
        }
        return new Empleado();
    }

    @Override
    public List<Empleado> buscarEmpleados(String busqueda) {
        sql = "SELECT * FROM `empleados` WHERE nombres LIKE ? OR apellidos LIKE ? OR ci_empleado LIKE ?";
        List<Empleado> empleadosEncontrados = new ArrayList<>();
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, "%"+busqueda+"%");
            ps.setString(2, "%"+busqueda+"%");
            ps.setString(3, "%"+busqueda+"%");
            rs = ps.executeQuery();
            while(rs.next()){
                empleadosEncontrados.add(new Empleado(  rs.getInt(1), 
                                        rs.getString(2), 
                                        rs.getString(3),
                                        rs.getInt(4),
                                        rs.getInt(5),
                                        rs.getString(6)));
            }
            return empleadosEncontrados;
        } catch (Exception e) {
            System.out.println("buscarEmpleados exception: "+e);
        }
        return empleadosEncontrados;
    }

    @Override
    public boolean existeCedula(int cedula) {
        sql ="SELECT * FROM empleados WHERE ci_empleado=?";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, cedula);
            rs = ps.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error buscando cedula: "+e);
        }
        return false;
    }
    
}
