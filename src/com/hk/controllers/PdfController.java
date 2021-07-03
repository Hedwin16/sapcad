package com.hk.controllers;

import com.hk.dao.DepartamentoDAO;
import com.hk.dao.EmpleadoDAO;
import com.hk.dao.HoraDAO;
import com.hk.dao.ReporteDAO;
import com.hk.dao.TipoNominaDAO;
import com.hk.interfaces.CRUD;
import com.hk.interfaces.IEmpleado;
import com.hk.interfaces.IHora;
import com.hk.interfaces.IReporte;
import com.hk.models.Departamento;
import com.hk.models.Empleado;
import com.hk.models.Hora;
import com.hk.models.LogicaPDF;
import com.hk.models.Reporte;
import com.hk.models.TipoNomina;
import com.hk.views.GestionReportes;
import com.hk.views.VisorPDF;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PdfController implements ActionListener {

    LogicaPDF pdf = new LogicaPDF();
    IHora horaDao = new HoraDAO();
    IEmpleado edao = new EmpleadoDAO();
    CRUD depDao = new DepartamentoDAO();
    CRUD nomDao = new TipoNominaDAO();
    Empleado empleado = new Empleado();
    List<Empleado> empleados;
    List<TipoNomina> nominas;
    List<Departamento> departamentos;
    List<Hora> horasBD;
    GestionReportes gestionReportes = new GestionReportes();
    VisorPDF visorPDF = new VisorPDF();
    IReporte rDAO = new ReporteDAO();
    Reporte reporte = new Reporte();
    String n_repo = "";

    public PdfController(GestionReportes gestionReportes, LogicaPDF logica) {
        this.pdf = logica; //Puede que me de un null exception
        this.gestionReportes = gestionReportes;
        cargarListaEmpleados();
        cargarListaDepartamentos();
        cargarListaNominas();
        this.gestionReportes.setVisible(true);
        this.gestionReportes.btn_buscar.addActionListener(this);
        this.gestionReportes.btn_generar.addActionListener(this);

    }

    public PdfController() {
    }

    public void eliminarPorExtension() {
        try {
            File archivo = new File("\\" + "Registro_30-6-2021_");
            System.out.println("Nombre Archivo: " + this.n_repo);
            archivo.delete();
        } catch (Exception e) {
            System.out.println("Exception File: " + e);
        }
    }

    public void crearPdfDiario() {
        if (!horaDao.existeRegitroHoy()) {
            JOptionPane.showMessageDialog(null, "No existen registros del día de hoy");
        } else {
            JOptionPane.showMessageDialog(null, "Si ya existe un registro hoy, será reemplazado");
            String[] infoArchivo = pdf.crearPDFDiario();
            System.out.println("Creando PDF....");
            System.out.println("PDF Creado");
            extraerArchivoTemporal(infoArchivo);

        }

    }

    private void cargarListaEmpleados() {
        empleados = edao.mostrar();
        if (empleados == null || empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            DefaultTableModel dtm = (DefaultTableModel) this.gestionReportes.TABLE.getModel();
            dtm.setRowCount(0);
        } else {
            DefaultTableModel dtm = (DefaultTableModel) this.gestionReportes.TABLE.getModel();
            dtm.setRowCount(0);

            empleados.forEach(emp
                    -> dtm.addRow(new Object[]{
                        emp.getNombres(),
                        emp.getApellidos(),
                        emp.getCi(),
                        emp.getId_departamento(),
                        emp.getCargo(),
                        emp.getId_nomina()
                    })
            );
        }
    }

    private void cargarListaDepartamentos() {
        departamentos = depDao.mostrar();
        if (departamentos == null || departamentos.isEmpty()) {
            System.out.println("No hay departamentos registrados");
        } else {
            departamentos.stream().forEach((departamento) -> {
                gestionReportes.txt_departamento.addItem(departamento.getNombre_departamento());
            });
        }
    }

    private void cargarListaNominas() {
        nominas = nomDao.mostrar();
        if (nominas == null || nominas.isEmpty()) {
            System.out.println("No hay tipos de nomina registrados");
        } else {
            nominas.stream().forEach((nomina) -> {
                gestionReportes.txt_nomina.addItem(nomina.getNombre_nomina());
            });
        }
    }

    private void buscarEmpleado() {
        String busqueda = gestionReportes.txt_buscar.getText();
        if (busqueda.isEmpty()) {
            cargarListaEmpleados();
        } else {
            if (busqueda.equals("ejee")) {
                JOptionPane.showMessageDialog(null, "Ingrese valores adecuados en el campo de búsqueda");
            } else {
                this.empleados = new ArrayList<>();
                this.empleados = edao.buscarEmpleados(busqueda);
                if (empleados == null || empleados.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No se han encontrado coincidencias");
                } else {
                    DefaultTableModel dtm = (DefaultTableModel) this.gestionReportes.TABLE.getModel();
                    dtm.setRowCount(0);

                    empleados.forEach(emp
                            -> dtm.addRow(new Object[]{
                                emp.getNombres(),
                                emp.getApellidos(),
                                emp.getCi(),
                                emp.getId_departamento(),
                                emp.getCargo(),
                                emp.getId_nomina()
                            })
                    );

                }
            }

        }
    }

    private java.sql.Date getDesde() {
        Date inicializador = new Date();
        Date desde = gestionReportes.txt_desde.getDate();
        java.sql.Date fecha_desde;
        fecha_desde = new java.sql.Date(inicializador.getTime());
        if (desde == null) {
            //JOptionPane.showMessageDialog(gestionReportes, "Seleccione una fecha válida (Desde)");
        } else {
            long d = desde.getTime();
            fecha_desde = new java.sql.Date(d);
        }

        return fecha_desde;
    }

    private java.sql.Date getHasta() {
        Date inicializador = new Date();
        Date hasta = gestionReportes.txt_hasta.getDate();
        java.sql.Date fecha_hasta;
        fecha_hasta = new java.sql.Date(inicializador.getTime());
        if (hasta == null) {
            //JOptionPane.showMessageDialog(gestionReportes, "Seleccione una fecha válida (Hasta)");
            System.out.println("getHasta = Null");
        } else {
            long h = hasta.getTime();
            fecha_hasta = new java.sql.Date(h);
        }

        return fecha_hasta;
    }

    private void generarReporteIndividual() {
        int fila_seleccionada = gestionReportes.TABLE.getSelectedRow();
        String desde = getDesde().toString();
        String hasta = getHasta().toString();

        if (fila_seleccionada >= 0) {
            this.empleado = this.empleados.get(fila_seleccionada);
            this.horasBD = horaDao.recuperarHorasEmpleado(this.empleado.getCi(), desde, hasta);
            if (this.horasBD == null || this.horasBD.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se han encontrado registros en la fecha especificada");
            } else {
                String[] infoArchivo = pdf.crearPDFIndividual(empleado, horasBD);
                System.out.println("Creando PDF....");
                System.out.println("PDF Creado");
                extraerArchivoTemporal(infoArchivo);

            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor seleccione una fila.");
        }
    }

    private void generarReportePorNomina() {
        String desde = getDesde().toString();
        String hasta = getHasta().toString();
        int index_nomina = gestionReportes.txt_nomina.getSelectedIndex();
        int id_nomina = nominas.get(index_nomina).getId_nomina();
        String nomina_nombre = nominas.get(index_nomina).getNombre_nomina();
        //this.horasBD = horaDao.
        HashMap<Empleado, List<Hora>> hash = pdf.listarPorNomina(id_nomina, desde, hasta);
        if (hash == null || hash.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se han encontrado registros en la fecha especificada");
        } else {
            String[] infoArchivo = pdf.crearPDFporNomina(nomina_nombre, hash, desde, hasta);
            extraerArchivoTemporal(infoArchivo);

        }

    }

    private void generarReportePorDepartamento() {

        String desde = getDesde().toString();
        String hasta = getHasta().toString();
        int index_departamento = gestionReportes.txt_departamento.getSelectedIndex();
        int id_departamento = departamentos.get(index_departamento).getId_departamento();
        String departamento_nombre = departamentos.get(index_departamento).getNombre_departamento();
        HashMap<Empleado, List<Hora>> hash = pdf.listarPorDepartamento(id_departamento, desde, hasta, 0);
        if (hash == null || hash.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se han encontrado registros en la fecha especificada");
        } else {
            String[] infoArchivo = pdf.crearPDFporDepartamento(departamento_nombre, hash, desde, hasta);
            extraerArchivoTemporal(infoArchivo);
        }
    }

    private void generarReporteNominaDepartamento() {
        String desde = getDesde().toString();
        String hasta = getHasta().toString();
        //Departamentos
        int index_departamento = gestionReportes.txt_departamento.getSelectedIndex();
        int id_departamento = departamentos.get(index_departamento).getId_departamento();
        String departamento_nombre = departamentos.get(index_departamento).getNombre_departamento();
        //Nominas
        int index_nomina = gestionReportes.txt_nomina.getSelectedIndex();
        int id_nomina = nominas.get(index_nomina).getId_nomina();
        String nomina_nombre = nominas.get(index_nomina).getNombre_nomina();
        HashMap<Empleado, List<Hora>> hash = pdf.listarPorDepartamento(id_departamento, desde, hasta, id_nomina);
        if (hash == null || hash.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se han encontrado registros en la fecha especificada");
        } else {
            //Abrir en el visor interno
            String[] infoArchivo = pdf.crearPDFporDepartamentoYNomina(departamento_nombre, nomina_nombre, hash, desde, hasta);
            System.out.println("Creando PDF....");
            System.out.println("PDF Creado");
            extraerArchivoTemporal(infoArchivo);
        }
    }

    private void generarReporteDeTodoslosEmpleados() {
        String desde = getDesde().toString();
        String hasta = getHasta().toString();
        HashMap<Empleado, List<Hora>> hash = pdf.listarTodos(desde, hasta);
        if (hash == null || hash.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se han encontrado registros en la fecha especificada");
        } else {
            //Abrir en el visor interno
            String[] infoArchivo = pdf.crearPDFporCadaEmpleado(hash, desde, hasta);
            System.out.println("Creando PDF....");
            System.out.println("PDF Creado");
            extraerArchivoTemporal(infoArchivo);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gestionReportes.btn_buscar == e.getSource()) { //Buscar
            buscarEmpleado();
        }

        if (gestionReportes.btn_generar == e.getSource()) {
            System.out.println("Click....");
            if (gestionReportes.txt_desde.getDate() == null || gestionReportes.txt_hasta.getDate() == null) {
                JOptionPane.showMessageDialog(gestionReportes, "Seleccione una fecha válida");
            } else {
                if (gestionReportes.TABLE.isEnabled()) {
                    generarReporteIndividual();
                } else if (gestionReportes.txt_nomina.isEnabled() && !gestionReportes.txt_departamento.isEnabled()) {
                    generarReportePorNomina();
                } else if (!gestionReportes.txt_nomina.isEnabled() && gestionReportes.txt_departamento.isEnabled()) {
                    generarReportePorDepartamento();
                } else if (gestionReportes.txt_nomina.isEnabled() && gestionReportes.txt_departamento.isEnabled()) {
                    generarReporteNominaDepartamento();
                } else {
                    int dialogue = JOptionPane.YES_NO_OPTION;
                    int result = JOptionPane.showConfirmDialog(null, "¿Desea generar el reporte de todos los empleados?", "Confirmación", dialogue);
                    if (result == 0) {
                        generarReporteDeTodoslosEmpleados();
                    }
                }
            }

        }
    }

    private void extraerArchivoTemporal(String[] infoArchivo) {
        //Extrayendo PDF Temporal
        int id_reporte = rDAO.getIdUltimoReporte();
        System.out.println("id reporte: " + id_reporte);
        if (id_reporte <= 0) {
            JOptionPane.showMessageDialog(null, "El id del reporte obtenido no es válido");

        } else {
            reporte.setId_reporte(id_reporte);
            reporte.setNombre(infoArchivo[1]);
            reporte.setTipo(4);
            rDAO.leerReporte(reporte);
            this.n_repo = infoArchivo[1];
            //Abri pdf en el visor interno
            visorPDF.abrirReporte("tmp_archivo.pdf");
            visorPDF.setTitle(infoArchivo[1] + " - SAPCAD Reporte");
            visorPDF.setVisible(true);
        }
    }
}
