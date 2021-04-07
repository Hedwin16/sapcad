package com.hk.controllers;

import com.hk.connection.Conexion;
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class PrincipalController implements ActionListener{
    MenuPrincipal menu;
    IAdmin adao = new AdminDAO();
    Login main;
    RegistroAdminPrincipal vistaRegistroAdmin;
    Admin admin;
   
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
        try {
            Conexion.getInstance().closeConnection();
        } catch (Exception e) {
            System.out.println("Error Cerrar Conexion: "+e);
        }
        this.menu.dispose();
        new Login().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.menu != null && this.menu.capturarBtn == e.getSource()){
            System.out.println("Boton Registro Presionado.... ");
        }
    }
    
    
    
    
    
}
