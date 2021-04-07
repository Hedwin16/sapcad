package com.hk.controllers;

import com.hk.dao.AdminDAO;
import com.hk.interfaces.IAdmin;
import com.hk.models.Admin;
import com.hk.views.Login;
import com.hk.views.MenuPrincipal;
import com.hk.views.RegistroAdminPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.menu.reportes_btn.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.menu != null && this.menu.reportes_btn == e.getSource()){
            System.out.println("Boton Reportes Presionado.... ");
        }
    }
    
    
    
    
    
}
