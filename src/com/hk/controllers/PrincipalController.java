package com.hk.controllers;

import com.hk.dao.AdminDAO;
import com.hk.interfaces.IAdmin;
import com.hk.models.Admin;
import com.hk.models.LogicaPDF;
import com.hk.models.RegistroPorCILogica;
import com.hk.views.GestionReportes;
import com.hk.views.RegistrarHoraVista;
import com.hk.views.Login;
import com.hk.views.MenuPrincipal;
import com.hk.views.RegistroAdminPrincipal;
import com.hk.views.RegistroPorCI;
import com.hk.views.SelectorPDF;
import com.hk.views.componentes.menu.MenuAdministrador1;
import com.hk.views.componentes.menu.MenuAdministrador2;
import com.hk.views.componentes.menu.MenuAdministrador3;
import com.hk.views.componentes.menu.MenuAdministradorPrincipal;
import com.hk.views.componentes.panel.DefaultPanel;
import com.hk.views.componentes.panel.GestionAdmin;
import com.hk.views.componentes.panel.GestionDepartamentos;
import com.hk.views.componentes.panel.GestionEmpleados;
import com.hk.views.componentes.panel.GestionTipoNomina;
import com.hk.views.componentes.panel.RegistrarEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class PrincipalController implements ActionListener{
    MenuPrincipal menu;
    IAdmin adao = new AdminDAO();
    Login main;
    RegistroAdminPrincipal vistaRegistroAdmin;
    Admin admin;
    PdfController pdfController = new PdfController();
    LogicaPDF logicaPDF;
    
    //Components
    DefaultPanel defaultPanel = new DefaultPanel();
    GestionAdmin adminPanel;
    GestionEmpleados empleadosPanel;
    RegistrarHoraVista vistaRegistroHora;
    RegistrarEmpleado regEmpleados;
    ReconocimientoController rcController;
    GestionDepartamentos gestionDepartamentos;
    GestionTipoNomina gestionTipoNomina;
    GestionReportes gestionReportes;
    SelectorPDF selectorPDF;
    RegistroPorCI vistaBackdoor;
    RegistroPorCIController registroPorCiController;
    RegistroPorCILogica registroPorCILogica;
   
    public PrincipalController() {
    }

    public PrincipalController(MenuPrincipal menu) {
        this.menu = menu;
        this.menu.capturarBtn.addActionListener(this);
    }
    
    public void confirmarSalir(){
        int dialogue = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?", "Confirmación", dialogue);
        if(result == 0){
            System.exit(1);
        }
    }
    
    public void setMenuBar(int tipo){
        if(tipo==1){
            this.menu.setJMenuBar(new MenuAdministrador1(this));
        }else if(tipo==2){
            this.menu.setJMenuBar(new MenuAdministrador2(this));
        }else if(tipo==3){
            this.menu.setJMenuBar(new MenuAdministrador3(this));
        }else if(tipo==4){
            this.menu.setJMenuBar(new MenuAdministradorPrincipal(this));
        }
    }
    
    public void cerrarSesion(){
        this.menu.dispose();
        new Login().setVisible(true);
    }
    
    public void setRegistrarEmpleado(){
        regEmpleados = new RegistrarEmpleado();
        rcController = new ReconocimientoController(regEmpleados, this);
        SwingUtilities.updateComponentTreeUI(regEmpleados.Panel_foto2);
        this.menu.contenedor.setViewportView(regEmpleados);
    }
    
    public void setDefaultPanel(){
        this.menu.contenedor.setViewportView(defaultPanel);
    }
    
    public void showRegistrarYCapturarVista(){
        if(vistaRegistroHora != null){
            vistaRegistroHora.dispose();
        }
        
        vistaRegistroHora = new RegistrarHoraVista();
        rcController = new ReconocimientoController(vistaRegistroHora, this);
        this.vistaRegistroHora.setVisible(true);
    }
    
    public void setGestionAdmin(){
        adminPanel = new GestionAdmin();
        this.menu.contenedor.setViewportView(adminPanel);
    }
    
    public void setGestionEmpleados(){
        empleadosPanel = new GestionEmpleados();
        this.menu.contenedor.setViewportView(empleadosPanel);
    }
    
    public void setGestionDepartamentos() {
        gestionDepartamentos = new GestionDepartamentos();
        this.menu.contenedor.setViewportView(gestionDepartamentos);
    }
    
    public void setGestionTipoNomina(){
        gestionTipoNomina = new GestionTipoNomina();
        this.menu.contenedor.setViewportView(gestionTipoNomina);
    }
    
    public void crearRegistroDiario(){
        pdfController.crearPdfDiario();
    }
    
    public void setVentanaGestionReportes(){
        gestionReportes = new GestionReportes();
        logicaPDF = new LogicaPDF();
        pdfController = new PdfController(gestionReportes,logicaPDF);
    }
    public void setVentanaSelectorPDF(){
        selectorPDF = new SelectorPDF();
        selectorPDF.setVisible(true);
    }
    
    public void setRegistroPorCI(){
        vistaBackdoor = new RegistroPorCI();
        registroPorCILogica = new RegistroPorCILogica();
        registroPorCiController = new RegistroPorCIController(vistaBackdoor, registroPorCILogica);
        System.out.println("setRegistroPorCI");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.menu != null && this.menu.capturarBtn == e.getSource()){
            showRegistrarYCapturarVista();
        }
    }
    
}
