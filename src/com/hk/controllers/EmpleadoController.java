package com.hk.controllers;

import com.hk.dao.EmpleadoDAO;
import com.hk.interfaces.IEmpleado;
import com.hk.models.Empleado;
import com.hk.views.componentes.panel.RegistrarEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EmpleadoController implements ActionListener{
    IEmpleado edao = new EmpleadoDAO();
    Empleado empleado = new Empleado();
    RegistrarEmpleado panelRegistro;
    Validaciones val = new Validaciones();
    
    public EmpleadoController(RegistrarEmpleado panelRegistro){
        this.panelRegistro = panelRegistro;
        
    }
    public void insertarNuevoEmpleado(){
        if(!estaValidado()){
            JOptionPane.showMessageDialog(panelRegistro, "Los datos introducidos no son correctos");
        }else{
            agregarEmpleado();
        }
    }
    public void agregarEmpleado(){
        String nombres = panelRegistro.txt_nombres.getText();
        String apellidos = panelRegistro.txt_apellidos.getText();
        int cedula = Integer.parseInt(panelRegistro.txt_cedula.getText());
        int departamento = panelRegistro.txt_departamento.getSelectedIndex();
        String cargo = panelRegistro.txt_cargo.getText();
        
        empleado.setNombres(nombres);
        empleado.setApellidos(apellidos);
        empleado.setCi(cedula);
        empleado.setId_departamento(departamento);
        empleado.setCargo(cargo);
        if(edao.insertar(this.empleado)){
            JOptionPane.showMessageDialog(panelRegistro, "Registrado con Éxito");
            vaciarCampos();
        }else{
            JOptionPane.showMessageDialog(panelRegistro, "No se ha podido registrar");
        }
    }
    
    public int getIdEmpleado(){
       return edao.getIdNuevoEmpleado()+1;
    }
    
    void vaciarCampos(){
        panelRegistro.txt_nombres.setText("");
        panelRegistro.txt_apellidos.setText("");
        panelRegistro.txt_cedula.setText("");
        panelRegistro.txt_departamento.setSelectedIndex(-1);
        panelRegistro.txt_cargo.setText("");
        
        panelRegistro.txt_nombres.requestFocus();
    }
    
    public boolean estaValidado(){
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
