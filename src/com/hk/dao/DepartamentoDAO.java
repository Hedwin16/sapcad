package com.hk.dao;

import com.hk.connection.Conexion;
import com.hk.interfaces.CRUD;
import com.hk.models.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO implements CRUD<Departamento>{
    String sql;
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public boolean insertar(Departamento t) {
        sql = "INSERT INTO departamentos(nombre) VALUES(?)";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, t.getNombre_departamento());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println("Exception insert dep: "+e);
        }
        return false;
    }

    @Override
    public List<Departamento> mostrar() {
        List<Departamento> lista = new ArrayList<>();
        sql = "SELECT * FROM departamentos ORDER BY id_departamento";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(new Departamento(rs.getInt(1), rs.getString(2)));
            }
            return lista;
        } catch (Exception e) {
            System.out.println("Exception mostrar dep: "+e);
        }
        return lista;
    }

    @Override
    public boolean actualizar(Departamento t) {
        sql = "UPDATE departamentos SET nombre=? WHERE id_departamento=?";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, t.getNombre_departamento());
            ps.setInt(2, t.getId_departamento());
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println("Exception en actualizar dep: "+e);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        sql = "DELETE FROM departamentos WHERE id_departamento=?";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate()>0;
        } catch (Exception e) {
            System.out.println("Exception en eliminar dep: "+e);
        }
        return false;
    }
    
}
