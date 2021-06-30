package com.hk.controllers;

import com.hk.models.RegistroPorCILogica;
import com.hk.views.RegistroPorCI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class RegistroPorCIController implements ActionListener{
    RegistroPorCI vista;
    RegistroPorCILogica logica;
    Validaciones val;
    int ci = 0;
    
    public RegistroPorCIController(RegistroPorCI vista, RegistroPorCILogica logica) {
        this.logica = logica;
        this.vista = vista;
        this.vista.setVisible(true);
        val = new Validaciones();
        System.out.println("Constructor Por CI");
        this.vista.btn_registrarPorCedula.addActionListener(this);
    }
    
    public void registrar(){
        boolean datosSonValidos = this.obtenerDatos();;
        System.out.println("registrar()");
        if(datosSonValidos){
            System.out.println("datosSonValidos");
            logica.registarPorCedula(ci);
        }
        
    }
    
    public boolean obtenerDatos(){
        String campo_cedula = vista.txt_ced.getText();
        if(campo_cedula.isEmpty()
          || !val.isNumeric(campo_cedula)
          || val.contieneEspaciosOCaracteresEspeciales(campo_cedula)){
            JOptionPane.showMessageDialog(vista, "Error en la cedula introducida");
            return false;
        }else{
            ci = Integer.parseInt(campo_cedula);
            return true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(vista.btn_registrarPorCedula == e.getSource()){
            System.out.println("Click en el registro");
            this.registrar();
            vista.txt_ced.setText("");
            vista.txt_ced.requestFocus();
        }
    }
    
}
