package com.hk.controllers;

import com.hk.dao.AdminDAO;
import com.hk.interfaces.IAdmin;
import com.hk.models.Admin;
import com.hk.views.Login;
import com.hk.views.MenuPrincipal;
import com.hk.views.RegistroAdminPrincipal;
import com.hk.views.componentes.panel.GestionAdmin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminController implements ActionListener{
    IAdmin adao = new AdminDAO();
    Login main;
    RegistroAdminPrincipal vistaRegistroAdmin;
    Admin admin;
    GestionAdmin gestionAdmin;
    Validaciones val = new Validaciones();
    List<Admin> administradores;
    
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
    
    public AdminController(GestionAdmin gestionAdmin){
        this.gestionAdmin = gestionAdmin;
        this.gestionAdmin.btn_nuevo.addActionListener(this);
        this.gestionAdmin.btn_editar.addActionListener(this);
        this.gestionAdmin.btn_eliminar.addActionListener(this);
        this.gestionAdmin.btn_guardar.addActionListener(this);
        this.main = null;
        this.vistaRegistroAdmin = null;
        this.admin = new Admin();
        cargarListaAdministradores();
        
    }
    
    public void verificarAdmin(){
        
        if(adao.existeAdministrador()){
            new Login().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "No se ha detectado administrador, se procede a registrar");
            new RegistroAdminPrincipal().setVisible(true);
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
    
    public void cargarListaAdministradores(){
        administradores = adao.mostrar();
        if(administradores == null || administradores.isEmpty()){
            System.out.println("No hay administradores secundarios registrados");
        }else{
            DefaultTableModel dtm = (DefaultTableModel) this.gestionAdmin.TABLE.getModel();
            dtm.setRowCount(0);
            
            administradores.forEach(administrador ->
                dtm.addRow(new Object[]{
                    administrador.getId_admin(),
                    administrador.getUsuario(),
                    administrador.getClave(),
                    administrador.getTipo()
                })        
            );
        }
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
        //Login
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
        //Registro Admin
        if(this.vistaRegistroAdmin != null && this.vistaRegistroAdmin.btn_registrar == e.getSource()){
            if(validarCamposRegistro()){
                JOptionPane.showMessageDialog(main, "LLene todos los campos");
            }else{
                JOptionPane.showMessageDialog(main, "Ok los campos están llenos :O");
                registrarAdministradorPrincipal();
            }
        }
        
        //Gestión de Administradores
        if(this.gestionAdmin != null && this.gestionAdmin.btn_nuevo == e.getSource()){
            gestionAdmin.habilitarCampos();
            gestionAdmin.txt_usuario.requestFocus();
            this.admin = new Admin();
        }
        
        if(this.gestionAdmin != null && this.gestionAdmin.btn_guardar == e.getSource() && this.gestionAdmin.txt_usuario.isEnabled()){
            System.out.println("click en el boton guardar");
            if(this.admin.getId_admin() == null){
                System.out.println("Id es nulo por lo tanto es nuevo");
                agregarAdmin();
            }else{
                actualizarAdmin();
            }
        }
        
        if(this.gestionAdmin != null && this.gestionAdmin.btn_editar == e.getSource()){
            
            int fila_seleccionada = gestionAdmin.TABLE.getSelectedRow();
            if(fila_seleccionada >= 0){
                gestionAdmin.habilitarCampos();
                this.admin = this.administradores.get(fila_seleccionada);
                gestionAdmin.txt_usuario.setText(admin.getUsuario());
                gestionAdmin.txt_clave.setText(admin.getClave());
                gestionAdmin.txt_privilegios.setSelectedIndex(admin.getTipo()-1);
            }else{
                JOptionPane.showMessageDialog(gestionAdmin, "Por favor seleccione una fila.");
            }

        }
        
        if(this.gestionAdmin != null && this.gestionAdmin.btn_eliminar == e.getSource()){
            int fila_seleccionada = gestionAdmin.TABLE.getSelectedRow();
            if(fila_seleccionada >= 0){
                this.admin = this.administradores.get(fila_seleccionada);
                int decision = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar este administrador?", "Confirmación", JOptionPane.YES_NO_OPTION);            
                if(decision == 0){
                    if(adao.eliminar(admin.getId_admin())){
                        gestionAdmin.desabilitarYVaciarCampos();
                        JOptionPane.showMessageDialog(gestionAdmin, "Eliminado con éxito");
                        cargarListaAdministradores();
                    }
                    
                }
            }else{
                JOptionPane.showMessageDialog(gestionAdmin, "Por favor seleccione una fila.");
            }

        }

    }

    private void agregarAdmin() {
        String usuario, clave;
        usuario = this.gestionAdmin.txt_usuario.getText();
        clave = this.gestionAdmin.txt_clave.getText();
        int tipo = this.gestionAdmin.txt_privilegios.getSelectedIndex()+1;
        if(validarCamposGA(usuario,clave,tipo)){
            System.out.println("validarCampos es true");
            admin.setUsuario(usuario);
            admin.setClave(clave);
            admin.setTipo(tipo);
            if(adao.insertar(admin)){
                JOptionPane.showMessageDialog(gestionAdmin, "Registrado con éxito");
                this.gestionAdmin.desabilitarYVaciarCampos();
                this.cargarListaAdministradores();
            }
        }
        
    }

    private void actualizarAdmin() {
        System.out.println("actualizando...");
        String usuario, clave;
        usuario = this.gestionAdmin.txt_usuario.getText();
        clave = this.gestionAdmin.txt_clave.getText();
        int tipo = this.gestionAdmin.txt_privilegios.getSelectedIndex()+1;
        if(validarCamposGA(usuario,clave,tipo)){
            System.out.println("validarCampos es true");
            admin.setUsuario(usuario);
            admin.setClave(clave);
            admin.setTipo(tipo);
            if(adao.actualizar(admin)){
                JOptionPane.showMessageDialog(gestionAdmin, "Registrado con éxito");
                this.gestionAdmin.desabilitarYVaciarCampos();
                this.cargarListaAdministradores();
            }
        }
    }

    private boolean validarCamposGA(String usuario, String clave, int tipo) {
        if(usuario.isEmpty() || val.contieneEspaciosOCaracteresEspeciales(usuario)){
            JOptionPane.showMessageDialog(gestionAdmin, "Ingrese el usuario correctamente. (Sin espacios ni caracteres especiales diferentes a: .'_-)");
            return false;
        }
        if(clave.isEmpty() || val.contieneEspaciosOCaracteresEspeciales(clave)){
            JOptionPane.showMessageDialog(gestionAdmin, "Ingrese la clave correctamente. (Sin espacios ni caracteres especiales diferentes a: .'_-)");
            return false;
        }
        if(tipo <= 0){
            JOptionPane.showMessageDialog(gestionAdmin, "Seleccione los privilegios del Administrador");
            return false;
        }
        
        return true;
    }
    
    
}
