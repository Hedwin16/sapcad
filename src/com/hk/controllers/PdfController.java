
package com.hk.controllers;

import com.hk.dao.HoraDAO;
import com.hk.interfaces.IHora;
import com.hk.models.LogicaPDF;
import javax.swing.JOptionPane;


public class PdfController {
    LogicaPDF pdf = new LogicaPDF();
    IHora horaDao = new HoraDAO();
    
    public void crearPdfDiario(){
        if(!horaDao.existeRegitroHoy()){
            JOptionPane.showMessageDialog(null, "No existen registros del día de hoy");
        }else{
            JOptionPane.showMessageDialog(null, "Si ya existe un registro hoy, será reemplazado");
            pdf.crearPDFDiario();
            System.out.println("Creando PDF....");
            System.out.println("PDF Creado");
            //Abri pdf en el visor interno
        }
        
    }
}
