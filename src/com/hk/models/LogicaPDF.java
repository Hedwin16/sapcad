package com.hk.models;

import com.hk.connection.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

public class LogicaPDF {
    String sql = "";
    PreparedStatement ps;
    ResultSet rs;
    
    public void crearPDFDiario(){
        try {
            Calendar fecha = Calendar.getInstance();
            String formato_fecha = ""+fecha.get(Calendar.DAY_OF_MONTH)+"-"+fecha.get(Calendar.MONTH)+"-"+fecha.get(Calendar.YEAR);
            Document documento = new Document();
            
            //System.out.println(lista.get(0).getFecha());
            FileOutputStream ficheroPDF = new FileOutputStream("recursos\\reportes\\Registro_" + formato_fecha + "_.pdf");
            PdfWriter.getInstance(documento, ficheroPDF);

            documento.open();
            Paragraph line = new Paragraph("____________________________________________________________________________\n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );

            documento.add(line);

            Paragraph titulo = new Paragraph("                                                    CONTROL DE ASISTENCIA \n                              REPORTE DIARIO DE ASISTENCIA DEL PERSONAL \n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );

            documento.add(titulo);

            Paragraph datos = new Paragraph("Registro Correspondiente a la fecha: " + formato_fecha,
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );

            documento.add(datos);

            Paragraph line2 = new Paragraph("____________________________________________________________________________\n\n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );
            documento.add(line2);
            HashMap<Empleado,List<Hora>> hashDatos = this.obtenerHashDiario();
            Iterator<Empleado> iterador = hashDatos.keySet().iterator();
            while(iterador.hasNext()){
                Empleado key = iterador.next();
                Paragraph parrafoPorEmpleado = new Paragraph("Nombres: "+key.getNombres()+ " " +key.getApellidos()+"\n",
                        FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    ));
                documento.add(parrafoPorEmpleado);
                for (int i = 0; i < hashDatos.get(key).size(); i++) {
                    Paragraph parrafoPorEmpleadoDatos = new Paragraph("Hora de Entrada: "+hashDatos.get(key).get(i).getHora_entrada() 
                            + " Hora de Salida: "+hashDatos.get(key).get(i).getHora_salida()+" "
                            + " Total de Horas: "+hashDatos.get(key).get(i).getHora_salida()
                            ,
                        FontFactory.getFont("Montserrat",
                            12,
                            Font.PLAIN,
                            BaseColor.BLACK
                    ));
                    documento.add(parrafoPorEmpleadoDatos);
                }
                Paragraph parrafoSeparador = new Paragraph("\n",
                        FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    ));
                documento.add(parrafoSeparador);
            }
 
            /*PdfPTable tabla = new PdfPTable(6);
            tabla.addCell("Cédula ");
            tabla.addCell("Nombres");
            tabla.addCell("Apellidos");
            tabla.addCell("Hora de Entrada ");
            tabla.addCell("Hora de Salida ");
            tabla.addCell("Total de Horas");

            for (int i = 0; i < lista.size(); i++) {
                int c = 0;
                tabla.addCell(lista.get(i).getId_hora().toString());
                for (Empleado empleado : empleados) {
                    c = lista.get(i).getId_hora();
                    if (empleado.getCi() == c) {
                        tabla.addCell(empleado.getNombres());
                        tabla.addCell(empleado.getApellidos());

                    }
                }
                tabla.addCell(lista.get(i).getHora_entrada());
                tabla.addCell(lista.get(i).getHora_salida());
                tabla.addCell(lista.get(i).getT_horas());
            }
            documento.add(tabla);*/
            documento.close();
        } catch (FileNotFoundException | DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error en la creación del PDF: (LógicaPDF) "+e);
        }
        
    }    
    
    public HashMap<Empleado, List<Hora>> obtenerHashDiario(){
        HashMap<Empleado,List<Hora>> hash = new HashMap<>();
        //int cedula = 1;
        sql = "SELECT e.id_empleado, e.nombres, e.apellidos, e.ci_empleado FROM empleados AS e";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                //cedula = rs.getInt(4); 
                Empleado emp = new Empleado(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                List<Hora> listaHoras = new ArrayList<>();
                sql = "SELECT h.id_hora, h.hora_entrada, h.hora_salida, h.fecha, h.t_horas, eh.ci_empleado FROM horas AS h, empleados_horas AS eh WHERE h.fecha=CURRENT_DATE AND eh.id_hora = h.id_hora AND eh.ci_empleado = ?";
                ps = Conexion.getInstance().getConnection().prepareStatement(sql);
                ps.setInt(1, emp.getCi());
                ResultSet rss = ps.executeQuery();
                while(rss.next()){
                  //hash.put(null, null)
                    listaHoras.add(new Hora(
                            rss.getInt(1),
                            rss.getString(2),
                            rss.getString(3),
                            rss.getString(4),
                            rss.getString(5)
                    )
                    );
                }
                if(!listaHoras.isEmpty()){
                    hash.put(emp, listaHoras);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error intentando guardar HashMap Diario: "+e);
        }
        
        
        return hash;
    }
    
    public boolean existeRegistro(){
        return true;
    }
}
