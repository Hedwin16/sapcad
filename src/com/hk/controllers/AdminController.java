package com.hk.controllers;

import com.hk.dao.AdminDAO;
import com.hk.interfaces.IAdmin;
import com.hk.views.Main;
import com.hk.views.RegistroAdminPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class AdminController implements ActionListener{
    IAdmin adao = new AdminDAO();
    Main main;
    
    public AdminController(Main main) {
        this.main = main;
        this.main.btn_ingresar.addActionListener(this);
    }

    public AdminController() {
    }
    
    public void verificarAdmin(){
        
        if(adao.existeAdministrador()){
            new Main().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No existe admin, hay que registrar");
            new RegistroAdminPrincipal().setVisible(true);
        }
    }
    
    
    
    public boolean verificarRegex(String campo){
        Pattern regex = Pattern.compile("[a-zA-Z]+");
        Matcher res = regex.matcher(campo);
        System.out.println(res.matches());
        
        
        return regex.matcher(campo).find();
    }
            
    
    public boolean validarCamposs(){
        String user = main.txt_usuario.getText();
        String pass = main.txt_usuario.getText();
        
        if(pass.equals("") || user.equals("")){
            System.out.println("uno");
            JOptionPane.showMessageDialog(main, "LLene todos los campos");
            return false;
        }else{
            System.out.println("dos");
            if(verificarRegex(user) || verificarRegex(pass)){
                return true;
            }
            return false;
        }
 
    }
    
    public boolean validarCampos(){
        return main.txt_usuario.getText().equals("") || main.txt_clave.getText().equals("");
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.main.btn_ingresar == e.getSource()){
            boolean rs = false;
            if(validarCampos()){
                JOptionPane.showMessageDialog(main, "LLene todos los campos");
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
