package com.hk.dao;

import com.hk.connection.Conexion;
import com.hk.interfaces.IUsuario;
import com.hk.models.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class UsuarioDAO implements IUsuario {

    String sql = "";
    PreparedStatement ps;
    ResultSet rs;
    int tipoUsuario = 0;

    @Override
    public boolean insertar(Usuario t) {
        if (!existeUsuario(t.getUsuario())) {
            sql = "INSERT INTO usuarios(usuario,clave,tipo) VALUES(?,?,?)";
            try {
                ps = Conexion.getInstance().getConnection().prepareStatement(sql);
                ps.setString(1, t.getUsuario());
                ps.setString(2, t.getClave());
                ps.setInt(3, t.getTipo());

                System.out.println(ps.executeUpdate());
                return true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al insertar usuario: " + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ya existe un usuario registrado con ese nombre");
        }
        return false;
    }

    @Override
    public List<Usuario> mostrar() {
        List<Usuario> list = new ArrayList<>();

        sql = "SELECT * FROM usuarios ORDER BY id_usuario";

        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }

            return list;
        } catch (SQLException e) {
            System.out.println("Lista de Usuarios: " + e);
        }

        return list;
    }

    @Override
    public boolean actualizar(Usuario t) {

        sql = "UPDATE usuarios SET usuario=?, clave=?, tipo=? WHERE id_usuario = ?";
        try {
            ps = Conexion.getInstance().getConnection().prepareCall(sql);
            ps.setString(1, t.getUsuario());
            ps.setString(2, t.getClave());
            ps.setInt(3, t.getTipo());
            ps.setInt(4, t.getId_usuario());
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Update usuario: " + e);
        }

        return false;
    }

    @Override
    public boolean eliminar(int id) {
        sql = "DELETE FROM usuarios WHERE id_usuario=?";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Eliminar Usuario exception: " + e);
        }
        return false;
    }

    @Override
    public boolean validarSesion(String usuario, String clave) {
        sql = "SELECT * FROM usuarios WHERE usuario=? AND clave=? ";

        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);

            rs = ps.executeQuery();
            if (rs.next()) {
                //Conexion.getInstance().closeConnection();
                this.tipoUsuario = rs.getInt("tipo");
                return true;

            }
        } catch (Exception e) {
            System.out.println("error: " + e);
            JOptionPane.showMessageDialog(null, e);
        }

        return false;
    }

    @Override
    public int getTipoUsuario() {
        return this.tipoUsuario;
    }

    @Override
    public boolean existeUsuario(String user) {
        sql = "SELECT id_usuario FROM usuarios WHERE usuario=?";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Error verificando existencia de usuario: " + e);
        }
        return false;
    }
}
