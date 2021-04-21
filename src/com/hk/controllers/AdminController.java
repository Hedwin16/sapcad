package com.hk.controllers;

import com.hk.dao.AdminDAO;
import com.hk.interfaces.IAdmin;
import com.hk.models.Admin;
import com.hk.views.Login;
import com.hk.views.MenuPrincipal;
import com.hk.views.RegistroAdminPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class AdminController implements ActionListener{
    IAdmin adao = new AdminDAO();
    Login main;
    RegistroAdminPrincipal vistaRegistroAdmin;
    Admin admin;
    Validaciones val = new Validaciones();
    
    public AdminController(Login main) {
        this.main = main;
        this.main.btn_ingresar.addActionListener(this);
    }

    public AdminController() {
        this.main = null;
        this.vistaRegistroAdmin = null;
    }
    
    public AdminController(RegistroAdminPrincipal vista){
        this.vistaRegistroAdmin = vista;
        this.vistaRegistroAdmin.btn_registrar.addActionListener(this);
        this.main = null;
        this.admin = new Admin();
    }
    
    public void verificarAdmin(){
        
        if(adao.existeAdministrador()){
            new Login().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No se ha detectado administrador, se procede a registrar");
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
        String usuario = main.txt_usuario.getText();
        String contras = main.txt_clave.getText();
        
        val.contieneEspaciosOCaracteresEspeciales(usuario);
        val.contieneEspaciosOCaracteresEspeciales(contras);
        return main.txt_usuario.getText().equals("") || main.txt_clave.getText().equals("");
    }
    
    public boolean validarCamposRegistro(){
        return vistaRegistroAdmin.txt_usuario.getText().equals("") || 
                vistaRegistroAdmin.txt_clave.getText().equals("") ||
                vistaRegistroAdmin.txt_clave_confirmar.getText().equals("");
    }
    
    public void registrarAdministradorPrincipal(){
        String usuario = vistaRegistroAdmin.txt_usuario.getText();
        String clave = vistaRegistroAdmin.txt_clave.getText();
        
        admin.setUsuario(usuario);
        admin.setClave(clave);
        admin.setTipo(4);     
        if(adao.insertar(this.admin)){
            JOptionPane.showMessageDialog(vistaRegistroAdmin, "Registrado con Éxito");
            MenuPrincipal m = new MenuPrincipal(4);
            m.setVisible(true);
            vistaRegistroAdmin.dispose();
        }else{
            JOptionPane.showMessageDialog(vistaRegistroAdmin, "No se ha podido registrar");
        }
        
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.main != null && this.main.btn_ingresar == e.getSource()){
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
                    int tipo = adao.getTipoAdmin();
                    MenuPrincipal menu = new MenuPrincipal(tipo);
                    menu.setVisible(true);
                    this.main.dispose();
                }
            }
        }
        
        if(this.vistaRegistroAdmin != null && this.vistaRegistroAdmin.btn_registrar == e.getSource()){
            if(validarCamposRegistro()){
                JOptionPane.showMessageDialog(main, "LLene todos los campos");
            }else{
                JOptionPane.showMessageDialog(main, "Ok los campos están llenos :O");
                registrarAdministradorPrincipal();
            }
        }
    }
    
    
}
