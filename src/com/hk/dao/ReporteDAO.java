package com.hk.dao;

import com.hk.connection.Conexion;
import com.hk.interfaces.IReporte;
import com.hk.models.Reporte;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReporteDAO implements IReporte {

    String sql = "";
    PreparedStatement ps;
    ResultSet rs;
    InputStream input;

    @Override
    public boolean insertar(Reporte t) {
        if (t.getTipo() == 1) {
            int id = idExisteReporteHoy();
            if (id <= 0) {
                sql = "INSERT INTO reportes(nombre, reporte, id_tipo_reporte, fecha) VALUES(?, ?, ?, CURRENT_DATE)";
                try {
                    ps = Conexion.getInstance().getConnection().prepareCall(sql);
                    input = new FileInputStream(new File("tmp_archivo.pdf"));
                    ps.setString(1, t.getNombre());
                    ps.setBinaryStream(2, input);
                    ps.setInt(3, t.getTipo());
                    return ps.executeUpdate() > 0;
                } catch (SQLException | FileNotFoundException e) {
                    System.out.println("Error insertando Reporte: " + e);
                } finally {
                    try {
                        if (input != null) {
                            input.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (IOException | SQLException e) {
                        System.out.println("Error cerrando el documento.. " + e);
                    }
                }

            } else {
                try {
                    sql = "UPDATE reportes SET reporte = ? WHERE id_reporte = ?";
                    input = new FileInputStream(new File("tmp_archivo.pdf"));
                    ps = Conexion.getInstance().getConnection().prepareCall(sql);
                    ps.setBinaryStream(1, input);
                    ps.setInt(2, id);
                    return ps.executeUpdate() == 1;
                } catch (FileNotFoundException | SQLException e) {
                    System.out.println("Error insertarReporte(): " + e);
                }

            }

        } else {
            sql = "INSERT INTO reportes(nombre, reporte, id_tipo_reporte, fecha) VALUES(?, ?, ?, CURRENT_DATE)";
            try {
                ps = Conexion.getInstance().getConnection().prepareCall(sql);
                input = new FileInputStream(new File("tmp_archivo.pdf"));
                ps.setString(1, t.getNombre());
                ps.setBinaryStream(2, input);
                ps.setInt(3, t.getTipo());
                return ps.executeUpdate() > 0;
            } catch (SQLException | FileNotFoundException e) {
                System.out.println("Error insertando Reportee: " + e);
            } finally {
                try {
                    if (input != null) {
                        input.close();
                    }
                    if (ps != null) {
                        ps.close();
                    }
                } catch (IOException | SQLException e) {
                    System.out.println("Error cerrando el documento.. " + e);
                }
            }
        }

        return false;
    }

    @Override
    public List<Reporte> mostrar() {
        List<Reporte> lista = new ArrayList<>();
        sql = "SELECT r.id_reporte, r.nombre, r.reporte, r.id_tipo_reporte FROM reportes AS r ORDER BY r.id_tipo_reporte";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Reporte(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)
                ));
            }
        } catch (Exception e) {
            System.out.println("mostrar() Reportes Error: " + e);
        }
        return lista;
    }

    @Override
    public boolean actualizar(Reporte t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean eliminar(int id) {
        sql = "DELETE FROM reportes WHERE id_reporte=?";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Error Eliminar Reporte: " + e);
        }
        return false;
    }

    @Override
    public void leerReporte(Reporte reporte) {
        sql = "SELECT reporte FROM reportes WHERE id_reporte = ? ";
        FileOutputStream output = null;
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, reporte.getId_reporte());
            rs = ps.executeQuery();
            System.out.println("nombre: " + reporte.getNombre());
            File archivo = new File("tmp_archivo.pdf");
            output = new FileOutputStream(archivo);
            while (rs.next()) {
                System.out.println("Extracción de Archivo...");
                input = rs.getBinaryStream("reporte");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
                System.out.println("Archivo Guardado....");
            }
        } catch (SQLException | IOException e) {
            System.out.println("Error leerReporte(): " + e);
        } finally {
            try {
                if (input != null) {
                    input.close();
                }
                if (output != null) {
                    output.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (IOException | SQLException e) {
                System.out.println("Error cerrando archivos o conexiones leerReporte... : " + e);
            }
        }
    }

    @Override
    public int getIdUltimoReporte() {
        sql = "SELECT id_reporte FROM reportes ORDER BY id_reporte DESC LIMIT 1";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Error obteniendo último reporte: " + e);
        }
        return 0;
    }

    @Override
    public int idExisteReporteHoy() {
        try {
            sql = "SELECT r.id_reporte FROM reportes AS r WHERE id_tipo_reporte=1 AND fecha=CURRENT_DATE";
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("ExisteReporteHoy(): " + e);
        }
        return 0;
    }
}
