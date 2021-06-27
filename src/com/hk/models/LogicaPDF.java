package com.hk.models;

import com.hk.connection.Conexion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
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

    public void crearPDFDiario() {
        try {
            Calendar fecha = Calendar.getInstance();
            String formato_fecha = "" + fecha.get(Calendar.DAY_OF_MONTH) + "-" + fecha.get(Calendar.MONTH) + "-" + fecha.get(Calendar.YEAR);
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

            HashMap<Empleado, List<Hora>> hashDatos = this.obtenerHashDiario();
            //HashMap<Empleado, HashMap<List<Hora>,String>> hashDatoss;
            Iterator<Empleado> iterador = hashDatos.keySet().iterator();
            while (iterador.hasNext()) {
                //String total_horas = "00:00:00";
                Empleado key = iterador.next();
                Paragraph parrafoPorEmpleado = new Paragraph("Nombres: " + key.getNombres() + " " + key.getApellidos() + "\n",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.BOLD,
                                BaseColor.BLACK
                        ));
                documento.add(parrafoPorEmpleado);
                int horas_en_segundos = 0;
                for (int i = 0; i < hashDatos.get(key).size(); i++) {
                    Paragraph parrafoPorEmpleadoDatos = new Paragraph("Hora de Entrada: " + hashDatos.get(key).get(i).getHora_entrada()
                            + " Hora de Salida: " + hashDatos.get(key).get(i).getHora_salida() + " "
                            + " Total de Horas: " + hashDatos.get(key).get(i).getT_horas(),
                            FontFactory.getFont("Montserrat",
                                    12,
                                    Font.PLAIN,
                                    BaseColor.BLACK
                            ));
                    String total_horas = hashDatos.get(key).get(i).getT_horas();
                    int[] t_horas = separarValores(total_horas);
                    horas_en_segundos = horas_en_segundos + sumarEnSegundos(t_horas);

                    documento.add(parrafoPorEmpleadoDatos);
                }
                String resultado_total = generarTotalHoras(horas_en_segundos);
                /*
                 Paragraph totalParrafo = new Paragraph("\nTotal de horas: " + resultado_total + " ",
                 FontFactory.getFont("Montserrat",
                 12,
                 Font.PLAIN,
                 BaseColor.BLACK
                 )
                 );
                 documento.add(totalParrafo);*/
                Paragraph parrafoSeparador = new Paragraph("\n",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.BOLD,
                                BaseColor.BLACK
                        ));
                documento.add(parrafoSeparador);
            }

            documento.close();
        } catch (FileNotFoundException | DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error en la creación del PDF: (LógicaPDF) " + e);
        }

    }

    public HashMap<Empleado, List<Hora>> obtenerHashDiario() {
        HashMap<Empleado, List<Hora>> hash = new HashMap<>();
        //int cedula = 1;
        sql = "SELECT e.id_empleado, e.nombres, e.apellidos, e.ci_empleado FROM empleados AS e";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
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
                while (rss.next()) {
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
                if (!listaHoras.isEmpty()) {
                    hash.put(emp, listaHoras);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error intentando guardar HashMap Diario: " + e);
        }

        return hash;
    }

    public void crearPDFIndividual(Empleado empleado, List<Hora> horas) {
        try {
            Calendar fecha = Calendar.getInstance();
            Document documento = new Document();
            FileOutputStream ficheroPDF = new FileOutputStream("recursos\\reportes\\Individual\\_" + empleado.getNombres() + " " + empleado.getApellidos() + "_.pdf");
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

            Paragraph titulo = new Paragraph("                                                    CONTROL DE ASISTENCIA \n                                       REPORTE DE ASISTENCIA DEL PERSONAL \n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );

            documento.add(titulo);

            Paragraph datos = new Paragraph("Nombre: " + empleado.getNombres() + " " + empleado.getApellidos() + "\nCédula: " + empleado.getCi(),
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

            PdfPTable tabla = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase("Fecha"));
            PdfPCell c2 = new PdfPCell(new Phrase("Hora de Entrada"));
            PdfPCell c3 = new PdfPCell(new Phrase("Hora de Salida"));
            PdfPCell c4 = new PdfPCell(new Phrase("Total de Horas Trabajadas"));
            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
            c2.setHorizontalAlignment(Element.ALIGN_CENTER);
            c3.setHorizontalAlignment(Element.ALIGN_CENTER);
            c4.setHorizontalAlignment(Element.ALIGN_CENTER);
            tabla.addCell(c1);
            tabla.addCell(c2);
            tabla.addCell(c3);
            tabla.addCell(c4);

            int horas_en_segundos = 0;
            for (Hora hora : horas) {
                tabla.addCell(hora.getFecha());
                tabla.addCell(hora.getHora_entrada());
                tabla.addCell(hora.getHora_salida());
                tabla.addCell(hora.getT_horas());
                String total_horas = hora.getT_horas();
                int[] t_horas = separarValores(total_horas);
                horas_en_segundos = horas_en_segundos + sumarEnSegundos(t_horas);
            }
            String resultado_total = generarTotalHoras(horas_en_segundos);
            documento.add(tabla);
            Paragraph totalParrafo = new Paragraph("\nTotal de horas: " + resultado_total + " ",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.PLAIN,
                            BaseColor.BLACK
                    )
            );
            documento.add(totalParrafo);

            Paragraph fechaPie = new Paragraph("Reporte generado a los " + fecha.get(Calendar.DAY_OF_MONTH) + " días del mes "
                    + fecha.get(Calendar.MONTH) + " de " + fecha.get(Calendar.YEAR),
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.PLAIN,
                            BaseColor.BLACK
                    )
            );

            documento.add(fechaPie);

            documento.close();
        } catch (FileNotFoundException | DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error CrearPDFIndividual: " + e);
        }

    }
    
    public void crearPDFporNomina(String nomina, HashMap<Empleado, List<Hora>> hashDatos, String desde, String hasta) {
        try {
            Calendar fecha = Calendar.getInstance();
            Document documento = new Document();

            //System.out.println(lista.get(0).getFecha());
            FileOutputStream ficheroPDF = new FileOutputStream("recursos\\reportes\\Por_Nomina\\Tipo_Nomina_" + nomina + "_.pdf");
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

            Paragraph datos = new Paragraph("Registro Correspondiente a la fechas: " + desde + " - "+ hasta,
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );

            documento.add(datos);

            Paragraph line2 = new Paragraph("____________________________________________________________________________\n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );
            Paragraph parrafoNomina = new Paragraph("Tipo de Nómina: " + nomina,
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.BOLD,
                                BaseColor.BLACK
                        ));
                documento.add(parrafoNomina);
            documento.add(line2);
            //HashMap<Empleado, HashMap<List<Hora>,String>> hashDatoss;
            Iterator<Empleado> iterador = hashDatos.keySet().iterator();
            while (iterador.hasNext()) {
                //String total_horas = "00:00:00";
                Empleado key = iterador.next();
                Paragraph parrafoPorEmpleado = new Paragraph("Nombres: " + key.getNombres() + " " + key.getApellidos() + "\n\n",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.BOLD,
                                BaseColor.BLACK
                        ));
                documento.add(parrafoPorEmpleado);
                PdfPTable tabla = new PdfPTable(4);
                PdfPCell c1 = new PdfPCell(new Phrase("Fecha"));
                PdfPCell c2 = new PdfPCell(new Phrase("Hora de Entrada"));
                PdfPCell c3 = new PdfPCell(new Phrase("Hora de Salida"));
                PdfPCell c4 = new PdfPCell(new Phrase("Total de Horas Trabajadas"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c2.setHorizontalAlignment(Element.ALIGN_CENTER);
                c3.setHorizontalAlignment(Element.ALIGN_CENTER);
                c4.setHorizontalAlignment(Element.ALIGN_CENTER);
                tabla.addCell(c1);
                tabla.addCell(c2);
                tabla.addCell(c3);
                tabla.addCell(c4);
                //Acumulador de Horas
                int horas_en_segundos = 0;
                for (int i = 0; i < hashDatos.get(key).size(); i++) {
                    tabla.addCell(hashDatos.get(key).get(i).getFecha());
                    tabla.addCell(hashDatos.get(key).get(i).getHora_entrada());
                    tabla.addCell(hashDatos.get(key).get(i).getHora_salida());
                    tabla.addCell(hashDatos.get(key).get(i).getT_horas());
                    String total_horas = hashDatos.get(key).get(i).getT_horas();
                    int[] t_horas = separarValores(total_horas);
                    horas_en_segundos = horas_en_segundos + sumarEnSegundos(t_horas);
                }
                String resultado_total = generarTotalHoras(horas_en_segundos);
                documento.add(tabla);
                Paragraph totalParrafo = new Paragraph("Total de horas: " + resultado_total + " ",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.PLAIN,
                                BaseColor.BLACK
                        )
                );
                documento.add(totalParrafo);
                Paragraph parrafoSeparador = new Paragraph("\n",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.BOLD,
                                BaseColor.BLACK
                        ));
                documento.add(parrafoSeparador);
            }

            documento.close();
        } catch (FileNotFoundException | DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error en la creación del PDF: (LógicaPDF) " + e);
        }
    }

    public String generarTotalHoras(int s) {
        int h, m;
        h = s / 3600;
        m = s / 60 - h * 60;
        s = s - m * 60 - h * 3600;
        return h + " h " + m + " min " + s + " s";
    }

    public int[] separarValores(String entrada) {
        int[] array = {0, 0, 0};
        int a = -3;
        int b = -1;
        for (int i = 0; i < 3; i++) {
            array[i] = Integer.parseInt(entrada.substring(a += 3, b += 3));
        }

        return array;
    }

    public int sumarEnSegundos(int[] t_horas) {
        int r = 0;
        r = t_horas[0] * 3600;
        r = r + t_horas[1] * 60;
        r = r + t_horas[2];
        return r;
    }
    
    public HashMap<Empleado,List<Hora>> listarPorNomina(int id_nomina,String desde, String hasta){
        HashMap<Empleado, List<Hora>> hash = new HashMap<>();
        sql = "SELECT e.id_empleado, e.nombres, e.apellidos, e.ci_empleado FROM empleados AS e WHERE e.id_nomina=?";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id_nomina);
            rs = ps.executeQuery();
            while (rs.next()) {
                //cedula = rs.getInt(4); 
                Empleado emp = new Empleado(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                );
                List<Hora> listaHoras = new ArrayList<>();
                sql = "SELECT h.id_hora, h.hora_entrada, h.hora_salida, h.fecha, h.t_horas, eh.ci_empleado FROM horas AS h, empleados_horas AS eh WHERE h.fecha BETWEEN ? AND ? AND eh.id_hora = h.id_hora AND eh.ci_empleado = ?";
                ps = Conexion.getInstance().getConnection().prepareStatement(sql);
                ps.setString(1, desde);
                ps.setString(2, hasta);
                ps.setInt(3, emp.getCi());
                ResultSet rss = ps.executeQuery();
                while (rss.next()) {
                    listaHoras.add(new Hora(
                            rss.getInt(1),
                            rss.getString(2),
                            rss.getString(3),
                            rss.getString(4),
                            rss.getString(5)
                    )
                    );
                }
                if (!listaHoras.isEmpty()) {
                    hash.put(emp, listaHoras);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error intentando guardar HashMap Por Nómina o Departamento: " + e);
        }

        return hash;
    }
}
