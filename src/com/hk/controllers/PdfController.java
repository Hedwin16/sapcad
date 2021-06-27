package com.hk.controllers;

import com.hk.dao.DepartamentoDAO;
import com.hk.dao.EmpleadoDAO;
import com.hk.dao.HoraDAO;
import com.hk.dao.TipoNominaDAO;
import com.hk.interfaces.CRUD;
import com.hk.interfaces.IEmpleado;
import com.hk.interfaces.IHora;
import com.hk.models.Departamento;
import com.hk.models.Empleado;
import com.hk.models.Hora;
import com.hk.models.LogicaPDF;
import com.hk.models.TipoNomina;
import com.hk.views.GestionReportes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

    public void crearPdfDiario() {
        if (!horaDao.existeRegitroHoy()) {
            JOptionPane.showMessageDialog(null, "No existen registros del día de hoy");
        } else {
            JOptionPane.showMessageDialog(null, "Si ya existe un registro hoy, será reemplazado");
            pdf.crearPDFDiario();
            System.out.println("Creando PDF....");
            System.out.println("PDF Creado");
            //Abri pdf en el visor interno
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
            if(this.horasBD == null || this.horasBD.isEmpty()){
                JOptionPane.showMessageDialog(null, "No se han encontrado registros en la fecha especificada");
            }else{
                pdf.crearPDFIndividual(empleado, horasBD);
                //Abrir en el visor interno
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
        HashMap<Empleado,List<Hora>> hash = pdf.listarPorNomina(id_nomina, desde, hasta);
        if(hash == null || hash.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se han encontrado registros en la fecha especificada");
        }else{
            pdf.crearPDFporNomina(nomina_nombre, hash, desde, hasta);
            //Abrir en el visor interno
        }
        
    }

    private void generarReportePorDepartamento() {
        
        String desde = getDesde().toString();
        String hasta = getHasta().toString();
        int index_departamento = gestionReportes.txt_departamento.getSelectedIndex();
        int id_departamento = departamentos.get(index_departamento).getId_departamento();
        String departamento_nombre = departamentos.get(index_departamento).getNombre_departamento();
        HashMap<Empleado,List<Hora>> hash = pdf.listarPorDepartamento(id_departamento, desde, hasta, 0);
        if(hash == null || hash.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se han encontrado registros en la fecha especificada");
        }else{
            pdf.crearPDFporDepartamento(departamento_nombre, hash, desde, hasta);
            //Abrir en el visor interno
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
        HashMap<Empleado,List<Hora>> hash = pdf.listarPorDepartamento(id_departamento, desde, hasta, id_nomina);
        if(hash == null || hash.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se han encontrado registros en la fecha especificada");
        }else{
            pdf.crearPDFporDepartamentoYNomina(departamento_nombre, nomina_nombre, hash, desde, hasta);
            //Abrir en el visor interno
        }
    }
    
    private void generarReporteDeTodoslosEmpleados(){
        String desde = getDesde().toString();
        String hasta = getHasta().toString();
        HashMap<Empleado,List<Hora>> hash = pdf.listarTodos(desde, hasta);
        if(hash == null || hash.isEmpty()){
            JOptionPane.showMessageDialog(null, "No se han encontrado registros en la fecha especificada");
        }else{
            pdf.crearPDFporCadaEmpleado(hash, desde, hasta);
            //Abrir en el visor interno
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
}
