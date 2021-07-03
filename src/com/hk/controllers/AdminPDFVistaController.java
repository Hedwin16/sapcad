package com.hk.controllers;

import com.hk.dao.ReporteDAO;
import com.hk.dao.TipoReporteDAO;
import com.hk.interfaces.CRUD;
import com.hk.interfaces.IReporte;
import com.hk.models.LogicaPDF;
import com.hk.models.Reporte;
import com.hk.models.TipoReporte;
import com.hk.views.VisorPDF;
import com.hk.views.componentes.panel.AdministradorReporte;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminPDFVistaController implements ActionListener {

    AdministradorReporte vista;
    LogicaPDF logica;
    List<Reporte> reportes;
    List<TipoReporte> tipo_reportes;
    IReporte rdao = new ReporteDAO();
    CRUD trDao = new TipoReporteDAO();
    Reporte reporte = new Reporte();
    VisorPDF visorPDF = new VisorPDF();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vista.btn_buscar == e.getSource()) {
            if (vista.txt_tipo_reporte.getSelectedIndex() == 0) {
                cargarListaReportes();
                System.out.println("es igual a 0");
            } else {
                buscarReporte();
            }

        }
        if (vista.btn_abrir == e.getSource()) {
            int fila_seleccionada = vista.TABLE.getSelectedRow();
            if (fila_seleccionada >= 0) {
                abrirReporte(fila_seleccionada);
            } else {
                JOptionPane.showMessageDialog(vista, "Por favor seleccione una fila.");
            }
        }
        if (vista.btn_eliminar == e.getSource()) {
            int fila_seleccionada = vista.TABLE.getSelectedRow();
            if (fila_seleccionada >= 0) {
                eliminarReporte(fila_seleccionada);
            } else {
                JOptionPane.showMessageDialog(vista, "Por favor seleccione una fila.");
            }
        }
    }

    public AdminPDFVistaController() {
    }

    public AdminPDFVistaController(AdministradorReporte vista, LogicaPDF logica) {
        this.vista = vista;
        this.logica = logica;
        this.vista.btn_abrir.addActionListener(this);
        this.vista.btn_buscar.addActionListener(this);
        this.vista.btn_eliminar.addActionListener(this);
        cargarListaTipoReporte();
        cargarListaReportes();
    }

    private void cargarListaTipoReporte() {
        tipo_reportes = trDao.mostrar();
        if (tipo_reportes == null || tipo_reportes.isEmpty()) {
            System.out.println("No hay tipos de reporte registrados");
        } else {
            for (int i = 0; i < tipo_reportes.size(); i++) {
                vista.txt_tipo_reporte.addItem(tipo_reportes.get(i).getNombre());
            }
        }
    }

    private void cargarListaReportes() {
        reportes = rdao.mostrar();
        if (reportes == null || reportes.isEmpty()) {
            System.out.println("No hay empleados registrados");
            DefaultTableModel dtm = (DefaultTableModel) this.vista.TABLE.getModel();
            dtm.setRowCount(0);
        } else {
            DefaultTableModel dtm = (DefaultTableModel) this.vista.TABLE.getModel();
            dtm.setRowCount(0);

            reportes.forEach(reporte
                    -> dtm.addRow(new Object[]{
                        reporte.getId_reporte(),
                        reporte.getNombre(),
                        tipo_reportes.get(reporte.getTipo() - 1).getNombre(),
                        reporte.getFecha()
                    })
            );
        }
    }

    private void buscarReporte() {
        int index = vista.txt_tipo_reporte.getSelectedIndex();
        int busqueda = tipo_reportes.get(index - 1).getId_tipo_reporte();
        this.reportes = new ArrayList<>();
        this.reportes = rdao.buscarReporte(busqueda);
        if (reportes == null || reportes.isEmpty()) {
            System.out.println("No se han encontrado coincidencias");
            JOptionPane.showMessageDialog(vista, "No se han encontrado coincidencias");
        } else {
            DefaultTableModel dtm = (DefaultTableModel) this.vista.TABLE.getModel();
            dtm.setRowCount(0);

            reportes.forEach(reporte
                    -> dtm.addRow(new Object[]{
                        reporte.getId_reporte(),
                        reporte.getNombre(),
                        tipo_reportes.get(reporte.getTipo() - 1).getNombre(),
                        reporte.getFecha()
                    })
            );

        }

    }

    private void abrirReporte(int fila_seleccionada) {
        //leer
        reporte = reportes.get(fila_seleccionada);
        rdao.leerReporte(reporte);
        
        //Abri pdf en el visor interno
        visorPDF.abrirReporte("tmp_archivo.pdf");
        visorPDF.setTitle(reporte.getNombre() + " - SAPCAD Reporte");
        visorPDF.setVisible(true);
    }

    private void eliminarReporte(int fila_seleccionada) {
        int decision = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (decision == 0) {
            if (rdao.eliminar(reportes.get(fila_seleccionada).getId_reporte())) {
                JOptionPane.showMessageDialog(vista, "Eliminado con éxito");
                cargarListaReportes();
            }

        }
    }

}
