package com.hk.controllers;

import com.hk.dao.AdminDAO;
import com.hk.interfaces.IAdmin;
import com.hk.views.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class AdminController implements ActionListener{
    IAdmin adao = new AdminDAO();
    Main main;
    
    public AdminController(Main main) {
        this.main = main;
        this.main.btn_ingresar.addActionListener(this);
    }
    
    boolean validarCampos(){
        return main.txt_usuario.getText().equals("") || main.txt_clave.getText().equals("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.main.btn_ingresar == e.getSource()){
            boolean rs = false;
            if(validarCampos()){
                JOptionPane.showMessageDialog(main, "Llene todos los campos.");
            }else{
                JOptionPane.showMessageDialog(main, "Ok los campos están llenos :O");
                rs = adao.validarSesion(main.txt_usuario.getText(), main.txt_clave.getText());
                if(!rs){
                    JOptionPane.showMessageDialog(main, "Combinación Usuario/Contraseña iválida.");
                }else{
                    JOptionPane.showMessageDialog(main, "Correcto!");
                }
            }
        }
    }
    
    
}
