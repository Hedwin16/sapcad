package com.hk.dao;

import com.hk.connection.Conexion;
import com.hk.interfaces.IHora;
import com.hk.models.Hora;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.JOptionPane;

public class HoraDAO implements IHora{
    String sql = "";
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Hora> recuperarHorasEmpleado(int ced, String desde, String hasta) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Hora> recuperarHorasMensuales(int mes, int anio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Hora> recuperarHorasDiarias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public int[] contarHoras(String start, String finish) {
        int[] startHour = {0,0,0};
        int[] finishHour = {0,0,0};
        
        startHour = separarValores(startHour, start);
        finishHour = separarValores(finishHour, finish);
        
        for(int elemento:startHour){
            System.out.print(elemento);
            
        }
        System.out.println(" ");
        for(int elemento:finishHour){
            System.out.print(elemento);
            
        }
        System.out.println(" ");
        
        int total_h = finishHour[0] - startHour[0];
        int total_m = finishHour[1] - startHour[1];
        int total_s = finishHour[2] - startHour[2];
        
        if(total_s < 0){
            total_m--;
            total_s = total_s + 60;
        }
        
        if(total_m < 0){
            total_h--;
            total_m = total_m + 60;
        }
        
        int[] h = {total_h, total_m};
        
        return h;
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
    public boolean insertarHoras(Hora hora, int cedula) {
        sql = "INSERT INTO horas(hora_entrada, hora_salida, fecha, t_horas, t_minutos) VALUES(?, ?, CURRENT_DATE, 0, 0)";
        try {
            if(hora.getId_hora() == null){
                ps = Conexion.getInstance().getConnection().prepareStatement(sql);
                ps.setString(1, hora.getHora_entrada());
                ps.setString(2, "no");
                if(ps.executeUpdate() > 0){
                    if(insertarEmpleadoHora(cedula)){
                        JOptionPane.showMessageDialog(null, "Registrada Hora de Entrada");
                        return true;
                    }
                }
                
            }else{
                if(setTotalHorasDiarias(hora, cedula)){ //Insertaron total de horas
                    // Insertar Hora de Salida en la BD
                    System.out.println("Condicion 2.1 - Fecha = null -> Insertando Hora de Salida");
                    
                    ps = Conexion.getInstance().getConnection().prepareStatement("UPDATE horas SET hora_salida= ? WHERE id_hora = ?");
                    ps.setString(1, hora.getHora_salida());
                    ps.setInt(2, hora.getId_hora());
                    JOptionPane.showMessageDialog(null, "Registrada Hora de Salida");
                    return ps.executeUpdate() > 0;
                    
                }
            }
            
        } catch (Exception e) {
            System.out.println("Exception insertando hora: "+e);
        }
        return false;
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
                return ps.executeUpdate() > 0;
            }
            
        } catch (Exception e) {
            System.out.println("Exception: iEmpleadoHora "+e);
        }
        return false;
    }
    
    boolean setTotalHorasDiarias(Hora hora, int ced){
        //Captura de hora para calcular el total
        String entrada = "1";
        String salida = "1";
        
        salida = salida+"hola";
        
        System.out.println(salida);
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement("SELECT * FROM horas WHERE id_hour = ?");
            ps.setInt(1, ced);
            ps.setInt(2, hora.getId_hora());
            rs = ps.executeQuery();
            while(rs.next()){
                entrada  = rs.getString("hora_entrada");
                System.out.println("Entradaaa: "+entrada);
                System.out.println("SAlidaaaa : "+salida);
            }
            
            int[] horas = contarHoras(entrada, hora.getHora_salida());
            for(int hor:horas){
                System.out.println("hora: "+hor);
            }

            ps = Conexion.getInstance().getConnection().prepareStatement("UPDATE horas SET t_horas=? , t_minutos=? WHERE id_hour = ?");
            ps.setInt(1, horas[0]);
            ps.setInt(2, horas[1]);
            ps.setInt(3, hora.getId_hora());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
                System.out.println("setTotalHoraDiarias: "+e);
            }
        return false;
        
    }
    
    public int[] separarValores(int[] array, String entrada){
        int a = -3;
        int b = -1;
        for (int i = 0; i < 3; i++) {
            array[i] = Integer.parseInt(entrada.substring(a+=3, b+=3));
        }
        return array;
    }
    
    @Override
    public boolean insertar(Hora t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String obtenerHora() {
        int hr, min, sg; 
        String a,b,c;
        a=""; b=""; c="";
        Calendar calendario = new GregorianCalendar();
        
        hr = calendario.get(Calendar.HOUR_OF_DAY); 
        min = calendario.get(Calendar.MINUTE);
        sg = calendario.get(Calendar.SECOND);
        
        a = String.valueOf(hr);
        b = String.valueOf(min);
        c = String.valueOf(sg);
        
        if(hr < 10){
            a = "0"+String.valueOf(hr);
        }
        if(min < 10){
            b = "0"+String.valueOf(min);
        }
        if(sg < 10){
            c = "0"+String.valueOf(sg);
        }
        String hour = a+":"+b+":"+c;
        System.out.println("hora: "+hour);
        return hour;
    }

}
