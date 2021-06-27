package com.hk.dao;

import com.hk.connection.Conexion;
import com.hk.interfaces.IHora;
import com.hk.models.Hora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class HoraDAO implements IHora{
    String sql = "";
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Hora> recuperarHorasEmpleado(int ced, String desde, String hasta) {
        List<Hora> listaHoras = new ArrayList<>();
        sql = "SELECT h.id_hora, h.hora_entrada, h.hora_salida, h.fecha, h.t_horas FROM horas AS h, empleados_horas as eh "
                + "WHERE eh.ci_empleado = ? AND eh.id_hora = h.id_hora AND h.fecha BETWEEN ? AND ?";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, ced);
            ps.setString(2, desde);
            ps.setString(3, hasta);
            rs = ps.executeQuery();
            while(rs.next()){
                listaHoras.add(new Hora(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5)
                ));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error recuperando Horas de Empleado: "+e);
        }
        return listaHoras;
    }

    @Override
    public List<Hora> recuperarHorasMensuales(int mes, int anio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Hora> recuperarHorasDiarias() {
        List<Hora> listaHoras = new ArrayList<>();
        sql = "SELECT * FROM horas WHERE date=CURRENT_DATE";
        try{
            PreparedStatement consulta = Conexion.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                listaHoras.add(new Hora(resultado.getInt("id_hora"),
                                        resultado.getString("hora_entrada"), 
                                        resultado.getString("hora_salida"), 
                                        resultado.getString("fecha"),   
                                        resultado.getString("total_horas")));
            }
            return listaHoras;

        }catch(SQLException ex){
            System.out.println("Horas diarias error: "+ex);
        }
        
        return null;
    }

    @Override
    public boolean existeRegistro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void totalHorasDiarias(Hora hora, int ced) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Hora> mostrar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Hora t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int insertarHoras(Hora hora, int cedula) {
        sql = "INSERT INTO horas(hora_entrada, fecha) VALUES(CURRENT_TIME,CURRENT_DATE)";
        System.out.println("Id de la hora que entra en insertarHoras: "+hora.getId_hora());
        try {
            if(hora.getId_hora() == null){
                ps = Conexion.getInstance().getConnection().prepareStatement(sql);
                if(ps.executeUpdate() > 0){
                    if(insertarEmpleadoHora(cedula)){
                        return 1;
                    }
                }
                
            }else{
                // Insertar Hora de Salida en la BD
                System.out.println("Condicion 2.1 - Fecha = null -> Insertando Hora de Salida");
                sql= "UPDATE horas SET hora_salida=CURRENT_TIME, t_horas=TIMEDIFF(CURRENT_TIME, hora_entrada) WHERE id_hora = ?";
                ps = Conexion.getInstance().getConnection().prepareStatement(sql);
                System.out.println("sql: "+sql);
                ps.setInt(1, hora.getId_hora());
                //JOptionPane.showMessageDialog(null, "Registrada Hora de Salida");
                if(ps.executeUpdate() > 0){
                    //JOptionPane.showMessageDialog(null, "Registrada Hora de Salida");
                    return 2;
                }
            }
            
        } catch (Exception e) {
            System.out.println("Exception insertando hora: "+e);
        }
        return 0;
    }
    
    boolean insertarEmpleadoHora(int ced){
        sql = "SELECT * FROM horas WHERE fecha=CURRENT_DATE ORDER BY id_hora DESC LIMIT 1";
        int id = 0;
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
               id = rs.getInt("id_hora");
            }
            if(id > 0){
                sql = "INSERT INTO empleados_horas(id_hora,ci_empleado) VALUES(?,?)";
                ps = Conexion.getInstance().getConnection().prepareStatement(sql);
                ps.setInt(1, id);
                ps.setInt(2, ced);
                System.out.println("insertando en la tabla empleados_horas");
                return ps.executeUpdate() > 0;
            }
            
        } catch (Exception e) {
            System.out.println("Exception: iEmpleadoHora "+e);
        }
        return false;
    }
    
    @Override
    public boolean insertar(Hora t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int idHoraRegistrada(int ced) {
            int id=0;
            String hora_salida = "";
            System.out.println("Buscando si hay una hora registrada...");
            sql = "SELECT horas.id_hora, horas.hora_salida FROM horas,empleados_horas WHERE empleados_horas.ci_empleado=? AND empleados_horas.id_hora=horas.id_hora ORDER BY horas.id_hora DESC LIMIT 1";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, ced);
            rs = ps.executeQuery();
            while(rs.next()){
                hora_salida = rs.getString("hora_salida");
                id = rs.getInt("id_hora");
                System.out.println("hora de salida: "+hora_salida);
                System.out.println("id: "+id);
            }
        } catch (Exception e) {
            System.out.println("Exception ExisteHoraRegistrada(): "+e);
        }
        
        if(hora_salida != null){//aquí es donde está fallando
            id = 0;
            System.out.println("Entro en salida != null");
            System.out.println("Es una hora nueva");
        }
        return id;
    }

    @Override
    public String obtenerHora() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean existeRegitroHoy() {
        sql = "SELECT id_hora FROM horas WHERE fecha=CURRENT_DATE";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error function existeRegistroHoy(): "+e);
        }
        return false;
    }

}
