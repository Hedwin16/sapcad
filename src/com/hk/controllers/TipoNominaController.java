package com.hk.controllers;

import com.hk.dao.TipoNominaDAO;
import com.hk.interfaces.CRUD;
import com.hk.models.TipoNomina;
import com.hk.views.componentes.panel.GestionTipoNomina;
import com.hk.views.componentes.panel.RegistrarEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TipoNominaController implements ActionListener{
    CRUD nomdao = new TipoNominaDAO();
    TipoNomina tipo = new TipoNomina();
    List<TipoNomina> nominas = new ArrayList<>();
    GestionTipoNomina vistaNominas;
    Validaciones val = new Validaciones();
    
    public TipoNominaController(GestionTipoNomina vistaNominas) {
        this.vistaNominas = vistaNominas;
        this.vistaNominas.btn_nuevo.addActionListener(this);
        this.vistaNominas.btn_editar.addActionListener(this);
        this.vistaNominas.btn_guardar.addActionListener(this);
        this.vistaNominas.btn_eliminar.addActionListener(this);
        this.cargarListaNominas();
    }
    
    public void cargarListaNominas(){
        nominas = nomdao.mostrar();
        if(nominas == null || nominas.isEmpty()){
            System.out.println("No hay tipos de nóminas registradas");
        }else{
            DefaultTableModel dtm = (DefaultTableModel) this.vistaNominas.TABLE.getModel();
            dtm.setRowCount(0);
            
            nominas.forEach(nom ->
                dtm.addRow(new Object[]{
                    nom.getId_nomina(),
                    nom.getNombre_nomina()
                })        
            );
        }
    }
    
    private void agregarNomina() {
        String nombre = this.vistaNominas.txt_nomina.getText();
        if(nombre.isEmpty()){
            JOptionPane.showMessageDialog(vistaNominas, "Ingrese un Nombre Válido");
        }else{
            tipo.setNombre_nomina(nombre);

            if(nomdao.insertar(tipo)){
                JOptionPane.showMessageDialog(vistaNominas, "Registrado con éxito");
                this.vistaNominas.desabilitarYVaciarCampos();
                this.cargarListaNominas();
            }
        }
        
    }
    
    private void actualizarNomina() {
        System.out.println("actualizando...");
        String nombre = this.vistaNominas.txt_nomina.getText();
        if(nombre.isEmpty() || val.contieneCaracteresEspeciales(nombre)){
            JOptionPane.showMessageDialog(vistaNominas, "Debe ingresar un Nombre Válido");
        }else{
            tipo.setNombre_nomina(nombre);
            if(nomdao.actualizar(tipo)){
                JOptionPane.showMessageDialog(vistaNominas, "Registrado con éxito");
                this.vistaNominas.desabilitarYVaciarCampos();
                this.cargarListaNominas();
            }
        }
    }
    
    public void eliminarNomina(){
        int fila_seleccionada = vistaNominas.TABLE.getSelectedRow();
            if(fila_seleccionada >= 0){
                this.tipo = this.nominas.get(fila_seleccionada);
                int decision = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar este departamento?", "Confirmación", JOptionPane.YES_NO_OPTION);            
                if(decision == 0){
                    if(nomdao.eliminar(tipo.getId_nomina())){
                        vistaNominas.desabilitarYVaciarCampos();
                        JOptionPane.showMessageDialog(vistaNominas, "Eliminado con éxito");
                        cargarListaNominas();
                    }
                    
                }
            }else{
                JOptionPane.showMessageDialog(vistaNominas, "Por favor seleccione una fila.");
            }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.vistaNominas != null && this.vistaNominas.btn_nuevo == e.getSource()){
            vistaNominas.habilitarCampos();
            vistaNominas.txt_nomina.requestFocus();
            this.tipo = new TipoNomina();
        }
        
        if(this.vistaNominas != null && this.vistaNominas.btn_guardar == e.getSource() && this.vistaNominas.txt_nomina.isEnabled()){
            if(this.tipo.getId_nomina()== null){
                System.out.println("Id es nulo por lo tanto es nuevo");
                agregarNomina();
            }else{
                actualizarNomina();
            }
        }
        
        if(this.vistaNominas != null && this.vistaNominas.btn_editar == e.getSource()){
            
            int fila_seleccionada = vistaNominas.TABLE.getSelectedRow();
            if(fila_seleccionada >= 0){
                vistaNominas.habilitarCampos();
                this.tipo = this.nominas.get(fila_seleccionada);
                vistaNominas.txt_nomina.setText(tipo.getNombre_nomina());
            }else{
                JOptionPane.showMessageDialog(vistaNominas, "Por favor seleccione una fila.");
            }

        }
        
        if(this.vistaNominas != null && this.vistaNominas.btn_eliminar == e.getSource()){
           this.eliminarNomina();

        }
    }
    
}
