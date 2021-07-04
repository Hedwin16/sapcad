package com.hk.models;

import com.hk.connection.Conexion;
import com.hk.dao.DepartamentoDAO;
import com.hk.dao.ReporteDAO;
import com.hk.interfaces.CRUD;
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

    String archivo = "Error";
    String nombre = "Archivo 1";
    String[] infoArchivo = {archivo, nombre};
    String sql = "";
    PreparedStatement ps;
    ResultSet rs;
    Calendar fecha = Calendar.getInstance();
    int mes = fecha.get(Calendar.MONTH) + 1;
    String formato_fecha = "" + fecha.get(Calendar.DAY_OF_MONTH) + "-" + mes + "-" + fecha.get(Calendar.YEAR);
    Reporte reporte = new Reporte();
    CRUD rDAO = new ReporteDAO();
    List<Departamento> departamentos;
    CRUD dDao = new DepartamentoDAO();

    public LogicaPDF() {
        departamentos = dDao.mostrar();
    }

    public void crearPDFDiario() {
        try {
            Document documento = new Document();
            nombre = "Registro_" + formato_fecha + "_.pdf";
            archivo = "recursos\\reportes\\Diario\\" + nombre;
            reporte.setNombre(nombre);
            reporte.setTipo(1);
            FileOutputStream ficheroPDF = new FileOutputStream("tmp_archivo.pdf");
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

            Paragraph titulo = new Paragraph("CONTROL DE ASISTENCIA \nREPORTE DIARIO DE ASISTENCIA DEL PERSONAL \n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );
            titulo.setAlignment(Element.ALIGN_CENTER);
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
            Iterator<Empleado> iterador = hashDatos.keySet().iterator();
            while (iterador.hasNext()) {
                Empleado key = iterador.next();
                String horaDefault = "00:00:00";
                // System.out.println("key.getIDDepartameto(): "+key.getId_departamento());
                //System.out.println("departamentos.get(): "+departamentos.get(1).getSalidaDefault());
                horaDefault = departamentos.get(key.getId_departamento() - 1).getSalidaDefault();
                System.out.println("Hora default para este departamento: " + horaDefault);
                Paragraph parrafoPorEmpleado = new Paragraph("Nombres: " + key.getNombres() + " " + key.getApellidos() + "\nCédula: " + key.getCi() + "\n",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.BOLD,
                                BaseColor.BLACK
                        ));
                documento.add(parrafoPorEmpleado);
                int horas_en_segundos = 0;
                for (int i = 0; i < hashDatos.get(key).size(); i++) {
                    String hora_salida;
                    String total_ = null;
                    if (hashDatos.get(key).get(i).getHora_salida() == null || hashDatos.get(key).get(i).getHora_salida().isEmpty()) {
                        hora_salida = horaDefault + "*";
                    } else {
                        hora_salida = hashDatos.get(key).get(i).getHora_salida();
                    }
                    if (hashDatos.get(key).get(i).getT_horas() == null) {
                        //total_ = "Default";
                        //Calcular total de horas trabajadas
                        total_ = obtenerTotal(hashDatos, key, i, horaDefault) + "*";
                    } else {
                        total_ = hashDatos.get(key).get(i).getT_horas();
                    }
                    Paragraph parrafoPorEmpleadoDatos = new Paragraph("Hora de Entrada: " + hashDatos.get(key).get(i).getHora_entrada()
                            + " Hora de Salida: " + hora_salida + " "
                            + " Total de Horas: " + total_,
                            FontFactory.getFont("Montserrat",
                                    12,
                                    Font.PLAIN,
                                    BaseColor.BLACK
                            ));
                    String total_horas = hashDatos.get(key).get(i).getT_horas();
                    if (total_horas == null || total_horas.isEmpty()) {

                    } else {
                        int[] t_horas = separarValores(total_horas);
                        horas_en_segundos = horas_en_segundos + sumarEnSegundos(t_horas);
                    }

                    parrafoPorEmpleadoDatos.setAlignment(Element.ALIGN_CENTER);
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

            //Insertando Reporte en la Base de Datos
            if (rDAO.insertar(reporte)) {
                JOptionPane.showMessageDialog(null, "Reporte Agregado a la Base de Datos");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido agregar a la Base de Datos");
            }
        } catch (FileNotFoundException | DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error en la creación del PDF: (LógicaPDF) " + e);
        }

    }

    public HashMap<Empleado, List<Hora>> obtenerHashDiario() {
        HashMap<Empleado, List<Hora>> hash = new HashMap<>();
        //int cedula = 1;
        sql = "SELECT e.id_empleado, e.nombres, e.apellidos, e.ci_empleado, e.id_departamento FROM empleados AS e";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //cedula = rs.getInt(4); 
                String hora_entrada, hora_salida;
                if (rs.getString(2) != null || !rs.getString(2).isEmpty()) {
                    hora_entrada = rs.getString(2);
                } else {
                    hora_entrada = "0";
                }
                if (rs.getString(3) != null || !rs.getString(3).isEmpty()) {
                    hora_salida = rs.getString(3);
                } else {
                    hora_salida = "0";
                }
                Empleado emp = new Empleado(
                        rs.getInt(1),
                        hora_entrada,
                        hora_salida,
                        rs.getInt(4),
                        rs.getInt(5)
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
            nombre = "_" + empleado.getNombres() + " " + empleado.getApellidos() + "_.pdf";
            archivo = "recursos\\reportes\\Individual\\" + nombre;
            reporte.setNombre(nombre);
            reporte.setTipo(3);
            FileOutputStream ficheroPDF = new FileOutputStream("tmp_archivo.pdf");
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
            String horaDefault = "00:00:00";
            // System.out.println("key.getIDDepartameto(): "+key.getId_departamento());
            //System.out.println("departamentos.get(): "+departamentos.get(1).getSalidaDefault());
            horaDefault = departamentos.get(empleado.getId_departamento() - 1).getSalidaDefault();
            System.out.println("Hora default para este departamento: " + horaDefault);

            int horas_en_segundos = 0;
            for (Hora hora : horas) {
                String hora_salida = "00";
                String total_ = "00";
                boolean vacia = true;
                String total_horas;
                hora_salida = hora.getHora_salida();
                if (hora_salida == null || hora_salida.isEmpty()) {
                    hora_salida = horaDefault + "*";
                }
                if (hora.getT_horas() == null || hora.getT_horas().equals(nombre)) {
                    total_ = obtenerTotalIndividual(hora, horaDefault);
                    total_horas = total_;
                } else {
                    total_ = hora.getT_horas();
                    total_horas = hora.getT_horas();
                    vacia = false;
                }
                total_ = obtenerTotalIndividual(hora, horaDefault);
                tabla.addCell(hora.getFecha());
                tabla.addCell(hora.getHora_entrada());
                tabla.addCell(hora_salida);
                if (vacia) {
                    total_ = total_ + "*";
                }
                tabla.addCell(total_);

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
            Paragraph totalAsistencia = new Paragraph("Asistencias: " + horas.size() + " ",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.PLAIN,
                            BaseColor.BLACK
                    )
            );
            documento.add(totalAsistencia);
            Paragraph pie = new Paragraph("(*) Hora Autogenerada por el sistema\n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.ITALIC,
                            BaseColor.GRAY
                    )
            );
            pie.setAlignment(Element.ALIGN_RIGHT);
            documento.add(pie);

            Paragraph fechaPie = new Paragraph("Reporte generado a los " + fecha.get(Calendar.DAY_OF_MONTH) + " días del mes "
                    + mes + " de " + fecha.get(Calendar.YEAR),
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.PLAIN,
                            BaseColor.BLACK
                    )
            );

            documento.add(fechaPie);

            documento.close();
            //Insertando Reporte en la Base de Datos
            if (rDAO.insertar(reporte)) {
                JOptionPane.showMessageDialog(null, "Reporte Agregado a la Base de Datos");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido agregar a la Base de Datos");
            }
        } catch (FileNotFoundException | DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error CrearPDFIndividual: " + e);
        }

    }

    public String[] crearPDFporNomina(String nomina, HashMap<Empleado, List<Hora>> hashDatos, String desde, String hasta) {
        try {
            //Calendar fecha = Calendar.getInstance();
            Document documento = new Document();

            //System.out.println(lista.get(0).getFecha());
            nombre = "Tipo_Nomina_" + nomina + "_.pdf";
            archivo = "recursos\\reportes\\Por_Nomina\\" + nombre;
            reporte.setNombre(nombre);
            reporte.setTipo(5);
            FileOutputStream ficheroPDF = new FileOutputStream("tmp_archivo.pdf");
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

            Paragraph titulo = new Paragraph("                                                    CONTROL DE ASISTENCIA \n                                     REPORTE DE ASISTENCIA DEL PERSONAL \n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );

            documento.add(titulo);

            Paragraph datos = new Paragraph("Registro Correspondiente a la fechas: " + desde + " - " + hasta,
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
                Empleado key = iterador.next();
                String horaDefault = "00:00:00";
                // System.out.println("key.getIDDepartameto(): "+key.getId_departamento());
                //System.out.println("departamentos.get(): "+departamentos.get(1).getSalidaDefault());
                horaDefault = departamentos.get(key.getId_departamento() - 1).getSalidaDefault();
                System.out.println("Hora default para este departamento: " + horaDefault);

                Paragraph parrafoPorEmpleado = new Paragraph("Nombres: " + key.getNombres() + " " + key.getApellidos() + "\nCédula: " + key.getCi() + "\n\n",
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
                    String hora_salida;
                    String total_ = "00";
                    boolean vacia = true;
                    if (hashDatos.get(key).get(i).getHora_salida() == null || hashDatos.get(key).get(i).getHora_salida().isEmpty()) {
                        hora_salida = horaDefault + "*";
                    } else {
                        hora_salida = hashDatos.get(key).get(i).getHora_salida();
                    }
                    if (hashDatos.get(key).get(i).getT_horas() == null) {
                        //total_ = "Default";
                        //Calcular total de horas trabajadas
                        total_ = obtenerTotalTabla(hashDatos, key, i, horaDefault);
                    } else {
                        total_ = hashDatos.get(key).get(i).getT_horas();
                        vacia = false;
                    }
                    String total_horas = hashDatos.get(key).get(i).getT_horas();
                    if (total_horas == null || total_horas.isEmpty()) {
                        total_horas = total_;
                    } else {
                        int[] t_horas = separarValores(total_horas);
                        horas_en_segundos = horas_en_segundos + sumarEnSegundos(t_horas);
                    }
                    tabla.addCell(hashDatos.get(key).get(i).getFecha());
                    tabla.addCell(hashDatos.get(key).get(i).getHora_entrada());
                    tabla.addCell(hora_salida);
                    if (vacia) {
                        total_ = total_ + "*";
                    }
                    tabla.addCell(total_);

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
                Paragraph totalAsistencia = new Paragraph("Asistencias: " + hashDatos.get(key).size() + " ",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.PLAIN,
                                BaseColor.BLACK
                        )
                );
                documento.add(totalAsistencia);
                Paragraph parrafoSeparador = new Paragraph("\n",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.BOLD,
                                BaseColor.BLACK
                        ));
                documento.add(parrafoSeparador);
            }
            Paragraph pie = new Paragraph("(*) Hora Autogenerada por el sistema\n",
                    FontFactory.getFont("Montserrat",
                            10,
                            Font.ITALIC,
                            BaseColor.GRAY
                    )
            );
            pie.setAlignment(Element.ALIGN_RIGHT);
            documento.add(pie);
            documento.close();
            //Insertando Reporte en la Base de Datos
            if (rDAO.insertar(reporte)) {
                JOptionPane.showMessageDialog(null, "Reporte Agregado a la Base de Datos");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido agregar a la Base de Datos");
            }
        } catch (FileNotFoundException | DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error en la creación del PDF: (LógicaPDF, Nómina) " + e);
        }

        return infoArchivo;
    }

    public void crearPDFporDepartamento(String departamento, HashMap<Empleado, List<Hora>> hashDatos, String desde, String hasta) {
        try {
            //Calendar fecha = Calendar.getInstance();
            Document documento = new Document();
            //System.out.println(lista.get(0).getFecha());
            nombre = "Departamento_" + departamento + "_.pdf";
            archivo = "recursos\\reportes\\Por_Departamento\\" + nombre;
            reporte.setNombre(nombre);
            reporte.setTipo(4);
            FileOutputStream ficheroPDF = new FileOutputStream("tmp_archivo.pdf");
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

            Paragraph titulo = new Paragraph("CONTROL DE ASISTENCIA\nREPORTE DE ASISTENCIA DEL PERSONAL\n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            Paragraph datos = new Paragraph("Registro Correspondiente a la fechas: " + desde + " - " + hasta,
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
            Paragraph parrafoNomina = new Paragraph("Departamento: " + departamento,
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
                String horaDefault = "00:00:00";
                // System.out.println("key.getIDDepartameto(): "+key.getId_departamento());
                //System.out.println("departamentos.get(): "+departamentos.get(1).getSalidaDefault());
                horaDefault = departamentos.get(key.getId_departamento() - 1).getSalidaDefault();
                System.out.println("Hora default para este departamento: " + horaDefault);

                Paragraph parrafoPorEmpleado = new Paragraph("Nombres: " + key.getNombres() + " " + key.getApellidos() + "\nCédula: " + key.getCi() + "\n\n",
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
                    String hora_salida;
                    String total_ = "00";
                    boolean vacia = true;
                    if (hashDatos.get(key).get(i).getHora_salida() == null || hashDatos.get(key).get(i).getHora_salida().isEmpty()) {
                        hora_salida = horaDefault + "*";
                    } else {
                        hora_salida = hashDatos.get(key).get(i).getHora_salida();
                    }
                    if (hashDatos.get(key).get(i).getT_horas() == null) {
                        //total_ = "Default";
                        //Calcular total de horas trabajadas
                        total_ = obtenerTotalTabla(hashDatos, key, i, horaDefault);
                    } else {
                        total_ = hashDatos.get(key).get(i).getT_horas();
                        vacia = false;
                    }
                    String total_horas = hashDatos.get(key).get(i).getT_horas();
                    if (total_horas == null || total_horas.isEmpty()) {
                        total_horas = total_;
                    } else {
                        int[] t_horas = separarValores(total_horas);
                        horas_en_segundos = horas_en_segundos + sumarEnSegundos(t_horas);
                    }
                    tabla.addCell(hashDatos.get(key).get(i).getFecha());
                    tabla.addCell(hashDatos.get(key).get(i).getHora_entrada());
                    tabla.addCell(hora_salida);
                    if (vacia) {
                        total_ = total_ + "*";
                    }
                    tabla.addCell(total_);

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
                Paragraph totalAsistencia = new Paragraph("Asistencias: " + hashDatos.get(key).size() + " ",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.PLAIN,
                                BaseColor.BLACK
                        )
                );
                documento.add(totalAsistencia);
                Paragraph parrafoSeparador = new Paragraph("\n",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.BOLD,
                                BaseColor.BLACK
                        ));
                documento.add(parrafoSeparador);
            }
            Paragraph pie = new Paragraph("(*) Hora Autogenerada por el sistema\n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.ITALIC,
                            BaseColor.GRAY
                    )
            );
            pie.setAlignment(Element.ALIGN_RIGHT);
            documento.add(pie);
            documento.close();
            //Insertando Reporte en la Base de Datos
            if (rDAO.insertar(reporte)) {
                JOptionPane.showMessageDialog(null, "Reporte Agregado a la Base de Datos");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido agregar a la Base de Datos");
            }
        } catch (FileNotFoundException | DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error en la creación del PDF: (LógicaPDF, Departamentos) " + e);
        }

    }

    public void crearPDFporDepartamentoYNomina(String departamento, String nomina, HashMap<Empleado, List<Hora>> hashDatos, String desde, String hasta) {
        try {
            //Calendar fecha = Calendar.getInstance();
            Document documento = new Document();

            nombre = "Departamento_" + departamento + "_" + nomina + "_.pdf";
            archivo = "recursos\\reportes\\Departamento_Y_Nomina\\" + nombre;
            reporte.setNombre(nombre);
            reporte.setTipo(6);
            FileOutputStream ficheroPDF = new FileOutputStream("tmp_archivo.pdf");
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

            Paragraph titulo = new Paragraph("                                                    CONTROL DE ASISTENCIA \n                                     REPORTE DE ASISTENCIA DEL PERSONAL \n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );

            documento.add(titulo);

            Paragraph datos = new Paragraph("Registro Correspondiente a la fechas: " + desde + " - " + hasta,
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
            Paragraph parrafoNomina = new Paragraph("Departamento: " + departamento,
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
                String horaDefault = "00:00:00";
                // System.out.println("key.getIDDepartameto(): "+key.getId_departamento());
                //System.out.println("departamentos.get(): "+departamentos.get(1).getSalidaDefault());
                horaDefault = departamentos.get(key.getId_departamento() - 1).getSalidaDefault();
                System.out.println("Hora default para este departamento: " + horaDefault);

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
                    String hora_salida;
                    String total_ = "00";
                    boolean vacia = true;
                    if (hashDatos.get(key).get(i).getHora_salida() == null || hashDatos.get(key).get(i).getHora_salida().isEmpty()) {
                        hora_salida = horaDefault + "*";
                    } else {
                        hora_salida = hashDatos.get(key).get(i).getHora_salida();
                    }
                    if (hashDatos.get(key).get(i).getT_horas() == null) {
                        //total_ = "Default";
                        //Calcular total de horas trabajadas
                        total_ = obtenerTotalTabla(hashDatos, key, i, horaDefault);
                    } else {
                        total_ = hashDatos.get(key).get(i).getT_horas();
                        vacia = false;
                    }
                    String total_horas = hashDatos.get(key).get(i).getT_horas();
                    if (total_horas == null || total_horas.isEmpty()) {
                        total_horas = total_;
                    } else {
                        int[] t_horas = separarValores(total_horas);
                        horas_en_segundos = horas_en_segundos + sumarEnSegundos(t_horas);
                    }
                    tabla.addCell(hashDatos.get(key).get(i).getFecha());
                    tabla.addCell(hashDatos.get(key).get(i).getHora_entrada());
                    tabla.addCell(hora_salida);
                    if (vacia) {
                        total_ = total_ + "*";
                    }
                    tabla.addCell(total_);

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
                Paragraph totalAsistencia = new Paragraph("Asistencias: " + hashDatos.get(key).size() + " ",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.PLAIN,
                                BaseColor.BLACK
                        )
                );
                documento.add(totalAsistencia);
                Paragraph parrafoSeparador = new Paragraph("\n",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.BOLD,
                                BaseColor.BLACK
                        ));
                documento.add(parrafoSeparador);
            }
            Paragraph pie = new Paragraph("(*) Hora Autogenerada por el sistema\n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.ITALIC,
                            BaseColor.GRAY
                    )
            );
            pie.setAlignment(Element.ALIGN_RIGHT);
            documento.add(pie);
            documento.close();
            //Insertando Reporte en la Base de Datos
            if (rDAO.insertar(reporte)) {
                JOptionPane.showMessageDialog(null, "Reporte Agregado a la Base de Datos");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido agregar a la Base de Datos");
            }
        } catch (FileNotFoundException | DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error en la creación del PDF: (LógicaPDF, Departamentos) " + e);
        }
    }

    public void crearPDFporCadaEmpleado(HashMap<Empleado, List<Hora>> hashDatos, String desde, String hasta) {
        try {
            //Calendar fecha = Calendar.getInstance();
            Document documento = new Document();

            nombre = desde + " " + hasta + "_.pdf";
            archivo = "recursos\\reportes\\General\\" + nombre;
            infoArchivo[0] = archivo;
            infoArchivo[1] = nombre;
            reporte.setNombre(nombre);
            reporte.setTipo(2);
            FileOutputStream ficheroPDF = new FileOutputStream("tmp_archivo.pdf");
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

            Paragraph titulo = new Paragraph("                                                    CONTROL DE ASISTENCIA \n                                     REPORTE DE ASISTENCIA DEL PERSONAL \n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.BOLD,
                            BaseColor.BLACK
                    )
            );

            documento.add(titulo);

            Paragraph datos = new Paragraph("Registro Correspondiente a la fechas: " + desde + " - " + hasta,
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
            documento.add(line2);
            //HashMap<Empleado, HashMap<List<Hora>,String>> hashDatoss;
            Iterator<Empleado> iterador = hashDatos.keySet().iterator();
            while (iterador.hasNext()) {
                Empleado key = iterador.next();
                String horaDefault = "00:00:00";
                // System.out.println("key.getIDDepartameto(): "+key.getId_departamento());
                //System.out.println("departamentos.get(): "+departamentos.get(1).getSalidaDefault());
                horaDefault = departamentos.get(key.getId_departamento() - 1).getSalidaDefault();
                System.out.println("Hora default para este departamento: " + horaDefault);

                Paragraph parrafoPorEmpleado = new Paragraph("Nombres: " + key.getNombres() + " " + key.getApellidos() + "",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.BOLD,
                                BaseColor.BLACK
                        ));
                documento.add(parrafoPorEmpleado);
                Paragraph parrafoPorCedula = new Paragraph("Cédula: " + key.getCi() + "\n\n",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.BOLD,
                                BaseColor.BLACK
                        ));
                documento.add(parrafoPorCedula);
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
                    String hora_salida;
                    String total_ = "00";
                    boolean vacia = true;
                    if (hashDatos.get(key).get(i).getHora_salida() == null || hashDatos.get(key).get(i).getHora_salida().isEmpty()) {
                        hora_salida = horaDefault + "*";
                    } else {
                        hora_salida = hashDatos.get(key).get(i).getHora_salida();
                    }
                    if (hashDatos.get(key).get(i).getT_horas() == null) {
                        //total_ = "Default";
                        //Calcular total de horas trabajadas
                        total_ = obtenerTotalTabla(hashDatos, key, i, horaDefault);
                    } else {
                        total_ = hashDatos.get(key).get(i).getT_horas();
                        vacia = false;
                    }
                    String total_horas = hashDatos.get(key).get(i).getT_horas();
                    if (total_horas == null || total_horas.isEmpty()) {
                        total_horas = total_;
                    } else {
                        int[] t_horas = separarValores(total_horas);
                        horas_en_segundos = horas_en_segundos + sumarEnSegundos(t_horas);
                    }
                    tabla.addCell(hashDatos.get(key).get(i).getFecha());
                    tabla.addCell(hashDatos.get(key).get(i).getHora_entrada());
                    tabla.addCell(hora_salida);
                    if (vacia) {
                        total_ = total_ + "*";
                    }
                    tabla.addCell(total_);

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
                Paragraph totalAsistencia = new Paragraph("Asistencias: " + hashDatos.get(key).size() + " ",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.PLAIN,
                                BaseColor.BLACK
                        )
                );
                documento.add(totalAsistencia);
                Paragraph parrafoSeparador = new Paragraph("\n",
                        FontFactory.getFont("Montserrat",
                                12,
                                Font.BOLD,
                                BaseColor.BLACK
                        ));
                documento.add(parrafoSeparador);
            }
            Paragraph pie = new Paragraph("(*) Hora Autogenerada por el sistema\n",
                    FontFactory.getFont("Montserrat",
                            12,
                            Font.ITALIC,
                            BaseColor.GRAY
                    )
            );
            pie.setAlignment(Element.ALIGN_RIGHT);
            documento.add(pie);
            documento.close();
            //Insertando Reporte en la Base de Datos
            if (rDAO.insertar(reporte)) {
                JOptionPane.showMessageDialog(null, "Reporte Agregado a la Base de Datos");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido agregar a la Base de Datos");
            }
        } catch (FileNotFoundException | DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error en la creación del PDF: (LógicaPDF, PorTodosLosEmpleados) " + e);
        }
    }

    public String generarTotalHoras(int s) {
        int h, m;
        h = s / 3600;
        m = s / 60 - h * 60;
        s = s - m * 60 - h * 3600;
        return h + " h " + m + " min " + s + " s";
    }

    public String convertirHoras(int s) {
        int h, m;
        String hora = "00", min = "00", seg = "00";
        h = s / 3600;
        m = s / 60 - h * 60;
        s = s - m * 60 - h * 3600;
        if (h < 10) {
            hora = "0" + h;
        } else {
            hora = h + "";
        }
        if (m < 10) {
            min = "0" + m;
        } else {
            min = m + "";
        }
        if (s < 10) {
            seg = "0" + s;
        } else {
            seg = s + "";
        }
        return hora + ":" + min + ":" + seg;
    }

    public int[] separarValores(String entrada) {
        int[] array = {0, 0, 0};
        if (entrada == null || entrada.isEmpty()) {
            for (int i = 0; i < 3; i++) {
                array[i] = 0;
            }
        } else {
            int a = -3;
            int b = -1;
            for (int i = 0; i < 3; i++) {
                array[i] = Integer.parseInt(entrada.substring(a += 3, b += 3));
            }
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

    public HashMap<Empleado, List<Hora>> listarPorNomina(int id_nomina, String desde, String hasta) {
        HashMap<Empleado, List<Hora>> hash = new HashMap<>();
        sql = "SELECT e.id_empleado, e.nombres, e.apellidos, e.ci_empleado, e.id_departamento FROM empleados AS e WHERE e.id_nomina=?";
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
                        rs.getInt(4),
                        rs.getInt(5)
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

    public HashMap<Empleado, List<Hora>> listarPorDepartamento(int id_departamento, String desde, String hasta, int id_nomina) {
        HashMap<Empleado, List<Hora>> hash = new HashMap<>();
        sql = "SELECT e.id_empleado, e.nombres, e.apellidos, e.ci_empleado, e.id_departamento FROM empleados AS e WHERE e.id_departamento=? ";
        if (id_nomina != 0) {
            sql = sql + " AND e.id_nomina=?";
        }

        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            ps.setInt(1, id_departamento);
            if (id_nomina != 0) {
                ps.setInt(2, id_nomina);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                //cedula = rs.getInt(4); 
                Empleado emp = new Empleado(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)
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
            JOptionPane.showMessageDialog(null, "Error intentando guardar HashMap Por Departamento: " + e);
        }

        return hash;
    }

    public HashMap<Empleado, List<Hora>> listarTodos(String desde, String hasta) {
        HashMap<Empleado, List<Hora>> hash = new HashMap<>();
        sql = "SELECT e.id_empleado, e.nombres, e.apellidos, e.ci_empleado, e.id_departamento FROM empleados AS e ";
        try {
            ps = Conexion.getInstance().getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //cedula = rs.getInt(4); 
                Empleado emp = new Empleado(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5)
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

    private String obtenerTotal(HashMap<Empleado, List<Hora>> hashDatos, Empleado key, int i, String horaDefault) {
        String entrada = hashDatos.get(key).get(i).getHora_entrada();
        int[] ent = separarValores(entrada);
        int[] sal = separarValores(horaDefault);
        int entSeg = sumarEnSegundos(ent);
        int salSeg = sumarEnSegundos(sal);
        int res = salSeg - entSeg;
        String horaa = generarTotalHoras(res);
        return horaa;
    }

    private String obtenerTotalTabla(HashMap<Empleado, List<Hora>> hashDatos, Empleado key, int i, String horaDefault) {
        String entrada = hashDatos.get(key).get(i).getHora_entrada();
        int[] ent = separarValores(entrada);
        int[] sal = separarValores(horaDefault);
        int entSeg = sumarEnSegundos(ent);
        int salSeg = sumarEnSegundos(sal);
        int res = salSeg - entSeg;
        String horaa = convertirHoras(res);
        return horaa;
    }

    private String obtenerTotalIndividual(Hora hora, String horaDefault) {
        String entrada = hora.getHora_entrada();
        int[] ent = separarValores(entrada);
        int[] sal = separarValores(horaDefault);
        int entSeg = sumarEnSegundos(ent);
        int salSeg = sumarEnSegundos(sal);
        int res = salSeg - entSeg;
        String horaa = convertirHoras(res);
        return horaa;
    }
}
