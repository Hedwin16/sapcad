package com.hk.dao;

import com.hk.connection.Conexion;
import com.hk.interfaces.CRUD;
import com.hk.models.TipoReporte;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoReporteDAO implements CRUD<TipoReporte>{
    String sql = "";
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public boolean insertar(TipoReporte t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoReporte> mostrar() {
        List<TipoReporte> lista = new ArrayList<>();
        sql = "SELECT id_tipo_reporte, nombre FROM tipo_reporte ORDER BY id_tipo_reporte";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(new TipoReporte(rs.getInt(1), rs.getString(2)));
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Exception mostrar Nómina: "+e);
        }
        return lista;
    }

    @Override
    public boolean actualizar(TipoReporte t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<TipoReporte> buscarEmpleado(int id){
        sql = "SELECT id_tipo_reporte, nombre FROM tipo_reporte WHERE id_tipo_reporte = ?";
        List<TipoReporte> lista = new ArrayList<>();
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(new TipoReporte(rs.getInt(1), 
                                        rs.getString(2)
                                        ));
            }
            return lista;
        } catch (Exception e) {
            System.out.println("buscarReportes exception: "+e);
        }
        return lista;
    }
}
