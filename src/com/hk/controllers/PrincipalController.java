package com.hk.controllers;

import com.hk.dao.AdminDAO;
import com.hk.interfaces.IAdmin;
import com.hk.models.Admin;
import com.hk.views.Login;
import com.hk.views.MenuPrincipal;
import com.hk.views.RegistroAdminPrincipal;
import com.hk.views.componentes.menu.MenuAdministrador1;
import com.hk.views.componentes.menu.MenuAdministrador2;
import com.hk.views.componentes.menu.MenuAdministrador3;
import com.hk.views.componentes.menu.MenuAdministradorPrincipal;
import com.hk.views.componentes.panel.DefaultPanel;
import com.hk.views.componentes.panel.RegistrarAdministrador;
import com.hk.views.componentes.panel.RegistrarEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PrincipalController implements ActionListener{
    MenuPrincipal menu;
    IAdmin adao = new AdminDAO();
    Login main;
    RegistroAdminPrincipal vistaRegistroAdmin;
    Admin admin;
    
    //Components
    RegistrarAdministrador regAdmin = new RegistrarAdministrador();
    DefaultPanel defaultPanel = new DefaultPanel();
    RegistrarEmpleado regEmpleados;
   
    public PrincipalController() {
    }

    public PrincipalController(MenuPrincipal menu) {
        this.menu = menu;
        this.menu.capturarBtn.addActionListener(this);
        
        
        
        /*
        this.menu.addComponentListener(new java.awt.event.ComponentAdapter(){
            @Override
            public void componentResized(java.awt.event.ComponentEvent evt){
                if(menu.getSize().width <= 950){
                    System.out.println("Cambio a una columna");
                    
                }
                if(menu.getSize().width >= 951){
                    System.out.println("cambio a dos columnas");
                }
            }
        });*/
    }
    
    public PrincipalController(MenuPrincipal menu, DefaultPanel p) {
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
        this.menu.contenedorPanel.add(regEmpleados);
        
        regEmpleados.setVisible(true);
        regAdmin.setVisible(false);
        defaultPanel.setVisible(false);
    }
    
    public void setRegistrarAdministrador(){
  
        this.menu.contenedorPanel.add(regAdmin);
        regAdmin.setVisible(true);
        if(regEmpleados != null){
            regEmpleados.setVisible(false);
        }
        defaultPanel.setVisible(false);
    }
    
    public void setDefaultPanel(){
        defaultPanel.setVisible(true);
        menu.contenedorPanel.add(defaultPanel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.menu != null && this.menu.capturarBtn == e.getSource()){
            System.out.println("Boton Registro Presionado.... ");
        }
    }
    
    
    
    
    
}
