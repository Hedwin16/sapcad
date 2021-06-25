package com.hk.controllers;

import com.hk.dao.DepartamentoDAO;
import com.hk.interfaces.CRUD;
import com.hk.models.Departamento;
import com.hk.views.componentes.panel.GestionDepartamentos;
import com.hk.views.componentes.panel.RegistrarEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DepartamentoController implements ActionListener{
    CRUD depDao = new DepartamentoDAO();
    Departamento departamento = new Departamento();
    List<Departamento> departamentos = new ArrayList<>();
    GestionDepartamentos gestionDepartamentos;
    Validaciones val = new Validaciones();
    public DepartamentoController() {
    }
    
    public DepartamentoController(GestionDepartamentos gestionDepartamentos) {
        this.gestionDepartamentos = gestionDepartamentos;
        this.gestionDepartamentos.btn_nuevo.addActionListener(this);
        this.gestionDepartamentos.btn_editar.addActionListener(this);
        this.gestionDepartamentos.btn_guardar.addActionListener(this);
        this.gestionDepartamentos.btn_eliminar.addActionListener(this);
        this.cargarListaDepartamentos();
    }
    
    public void cargarListaDepartamentos(){
        departamentos = depDao.mostrar();
        if(departamentos == null || departamentos.isEmpty()){
            System.out.println("No hay departamentos registrados");
        }else{
            DefaultTableModel dtm = (DefaultTableModel) this.gestionDepartamentos.TABLE.getModel();
            dtm.setRowCount(0);
            
            departamentos.forEach(dep ->
                dtm.addRow(new Object[]{
                    dep.getId_departamento(),
                    dep.getNombre_departamento()
                })        
            );
        }
    }


    private void agregarDepartamento() {
        String nombre = this.gestionDepartamentos.txt_departamento.getText();
        if(nombre.isEmpty()){
            JOptionPane.showMessageDialog(gestionDepartamentos, "Ingrese un Nombre Válido");
        }else{
            departamento.setNombre_departamento(nombre);

            if(depDao.insertar(departamento)){
                JOptionPane.showMessageDialog(gestionDepartamentos, "Registrado con éxito");
                this.gestionDepartamentos.desabilitarYVaciarCampos();
                this.cargarListaDepartamentos();
            }
        }
        
    }

    private void actualizarDepartamento() {
        System.out.println("actualizando...");
        String nombre = this.gestionDepartamentos.txt_departamento.getText();
        if(nombre.isEmpty() || val.contieneCaracteresEspeciales(nombre)){
            JOptionPane.showMessageDialog(gestionDepartamentos, "Debe ingresar un Nombre Válido");
        }else{
            departamento.setNombre_departamento(nombre);
            if(depDao.actualizar(departamento)){
                JOptionPane.showMessageDialog(gestionDepartamentos, "Registrado con éxito");
                this.gestionDepartamentos.desabilitarYVaciarCampos();
                this.cargarListaDepartamentos();
            }
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.gestionDepartamentos != null && this.gestionDepartamentos.btn_nuevo == e.getSource()){
            gestionDepartamentos.habilitarCampos();
            gestionDepartamentos.txt_departamento.requestFocus();
            this.departamento = new Departamento();
        }
        
        if(this.gestionDepartamentos != null && this.gestionDepartamentos.btn_guardar == e.getSource() && this.gestionDepartamentos.txt_departamento.isEnabled()){
            if(this.departamento.getId_departamento()== null){
                System.out.println("Id es nulo por lo tanto es nuevo");
                agregarDepartamento();
            }else{
                actualizarDepartamento();
            }
        }
        
        if(this.gestionDepartamentos != null && this.gestionDepartamentos.btn_editar == e.getSource()){
            
            int fila_seleccionada = gestionDepartamentos.TABLE.getSelectedRow();
            if(fila_seleccionada >= 0){
                gestionDepartamentos.habilitarCampos();
                this.departamento = this.departamentos.get(fila_seleccionada);
                gestionDepartamentos.txt_departamento.setText(departamento.getNombre_departamento());
            }else{
                JOptionPane.showMessageDialog(gestionDepartamentos, "Por favor seleccione una fila.");
            }

        }
        
        if(this.gestionDepartamentos != null && this.gestionDepartamentos.btn_eliminar == e.getSource()){
            int fila_seleccionada = gestionDepartamentos.TABLE.getSelectedRow();
            if(fila_seleccionada >= 0){
                this.departamento = this.departamentos.get(fila_seleccionada);
                int decision = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar este departamento?", "Confirmación", JOptionPane.YES_NO_OPTION);            
                if(decision == 0){
                    if(depDao.eliminar(departamento.getId_departamento())){
                        gestionDepartamentos.desabilitarYVaciarCampos();
                        JOptionPane.showMessageDialog(gestionDepartamentos, "Eliminado con éxito");
                        cargarListaDepartamentos();
                    }
                    
                }
            }else{
                JOptionPane.showMessageDialog(gestionDepartamentos, "Por favor seleccione una fila.");
            }

        }
    }
    
}
