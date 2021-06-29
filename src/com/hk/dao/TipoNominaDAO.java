package com.hk.dao;

import com.hk.connection.Conexion;
import com.hk.interfaces.CRUD;
import com.hk.models.TipoNomina;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoNominaDAO implements CRUD<TipoNomina>{
    String sql;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public boolean insertar(TipoNomina t) {
        sql = "INSERT INTO tipo_nomina(nombre) VALUES(?)";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, t.getNombre_nomina());
            return ps.executeUpdate()>0;
            
        } catch (Exception e) {
            System.out.println("Exception insert nomina: "+e);
        }
        return false;
    }

    @Override
    public List<TipoNomina> mostrar() {
        List<TipoNomina> lista = new ArrayList<>();
        sql = "SELECT * FROM tipo_nomina ORDER BY id_nomina";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(new TipoNomina(rs.getInt(1), rs.getString(2)));
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Exception mostrar Nómina: "+e);
        }
        return lista;
    }

    @Override
    public boolean actualizar(TipoNomina t) {
        sql = "UPDATE tipo_nomina SET nombre=? WHERE id_nomina=?";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, t.getNombre_nomina());
            ps.setInt(2, t.getId_nomina());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println("Exception en actualizar nomina: "+e);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        sql = "DELETE FROM tipo_nomina WHERE id_nomina=?";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println("Exception en eliminar nomina: "+e);
        }
        return false;
    }
    
}
