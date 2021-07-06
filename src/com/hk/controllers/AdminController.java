package com.hk.controllers;

import com.hk.dao.AdminDAO;
import com.hk.dao.UsuarioDAO;
import com.hk.interfaces.IAdmin;
import com.hk.interfaces.IUsuario;
import com.hk.models.Admin;
import com.hk.models.Usuario;
import com.hk.views.Login;
import com.hk.views.MenuPrincipal;
import com.hk.views.RegistroAdminPrincipal;
import com.hk.views.componentes.panel.GestionUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AdminController implements ActionListener {

    IAdmin adao = new AdminDAO();
    IUsuario udao = new UsuarioDAO();
    Login main;
    RegistroAdminPrincipal vistaRegistroAdmin;
    Admin admin;
    Usuario usuario;
    GestionUsuarios gestionUsuario;
    Validaciones val = new Validaciones();
    List<Usuario> usuarios;
    boolean editable;

    public AdminController(Login main) {
        this.main = main;
        this.main.btn_ingresar.addActionListener(this);
    }

    public AdminController() {
        this.main = null;
        this.vistaRegistroAdmin = null;
    }

    public AdminController(RegistroAdminPrincipal vista) {
        this.vistaRegistroAdmin = vista;
        this.vistaRegistroAdmin.btn_registrar.addActionListener(this);
        this.main = null;
        this.admin = new Admin();

    }

    public AdminController(GestionUsuarios gestionAdmin) {
        this.gestionUsuario = gestionAdmin;
        this.gestionUsuario.btn_nuevo.addActionListener(this);
        this.gestionUsuario.btn_editar.addActionListener(this);
        this.gestionUsuario.btn_eliminar.addActionListener(this);
        this.gestionUsuario.btn_guardar.addActionListener(this);
        this.main = null;
        this.vistaRegistroAdmin = null;
        this.admin = new Admin();
        cargarListaUsuarios();

    }

    public void verificarAdmin() {
        if (adao.existeAdministrador()) {
            new Login().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha detectado administrador, se procede a registrar");
            new RegistroAdminPrincipal().setVisible(true);
        }
    }

    public boolean validarCampos() {
        String usuario = main.txt_usuario.getText();
        String contras = main.txt_clave.getText();

        val.contieneEspaciosOCaracteresEspeciales(usuario);
        val.contieneEspaciosOCaracteresEspeciales(contras);
        return main.txt_usuario.getText().equals("") || main.txt_clave.getText().equals("");
    }

    public boolean validarCamposRegistro() {
        return vistaRegistroAdmin.txt_usuario.getText().equals("")
                || vistaRegistroAdmin.txt_clave.getText().equals("")
                || vistaRegistroAdmin.txt_clave_confirmar.getText().equals("");
    }

    public void registrarAdministradorPrincipal() {
        String usuario = vistaRegistroAdmin.txt_usuario.getText();
        String clave = vistaRegistroAdmin.txt_clave.getText();
        if (clave.equals(vistaRegistroAdmin.txt_clave_confirmar.getText())) {
            admin.setUsuario(usuario);
            admin.setClave(clave);
            admin.setTipo(3);
            if (adao.insertar(this.admin)) {
                JOptionPane.showMessageDialog(vistaRegistroAdmin, "Registrado con Éxito");
                vistaRegistroAdmin.dispose();
                new Login().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(vistaRegistroAdmin, "No se ha podido registrar");
            }
        }else{
            JOptionPane.showMessageDialog(vistaRegistroAdmin, "Las contraseñas introducidas no coinciden");
        }


    }

    public void cargarListaUsuarios() {
        usuarios = udao.mostrar();
        if (usuarios == null || usuarios.isEmpty()) {
            System.out.println("No hay administradores secundarios registrados");
        } else {
            DefaultTableModel dtm = (DefaultTableModel) this.gestionUsuario.TABLE.getModel();
            dtm.setRowCount(0);

            usuarios.forEach(administrador
                    -> dtm.addRow(new Object[]{
                        administrador.getId_usuario(),
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
        if (this.main != null && this.main.btn_ingresar == e.getSource()) {
            boolean rs = false;
            boolean rsUsuario = false;
            if (validarCampos()) {
                JOptionPane.showMessageDialog(main, "LLene todos los campos");
            } else {
                rs = adao.validarSesion(main.txt_usuario.getText(), main.txt_clave.getText());
                rsUsuario = udao.validarSesion(main.txt_usuario.getText(), main.txt_clave.getText());

                if (!rs) {
                    if (!rsUsuario) {
                        JOptionPane.showMessageDialog(main, "Combinación Usuario/Contraseña iválida.");
                    } else {
                        iniciarSesion();
                    }
                } else {
                    iniciarSesion();
                }
            }
        }
        //Registro Usuario
        if (this.vistaRegistroAdmin != null && this.vistaRegistroAdmin.btn_registrar == e.getSource()) {
            if (validarCamposRegistro()) {
                JOptionPane.showMessageDialog(main, "LLene todos los campos");
            } else {
                //JOptionPane.showMessageDialog(main, "Ok los campos están llenos :O");
                if (this.editable) {
                    actualizarAdministradorPrincipal();
                } else {
                    registrarAdministradorPrincipal();
                }

            }
        }

        //Gestión de Usuarios
        if (this.gestionUsuario != null && this.gestionUsuario.btn_nuevo == e.getSource()) {
            gestionUsuario.habilitarCampos();
            gestionUsuario.txt_usuario.requestFocus();
            this.usuario = new Usuario();
        }

        if (this.gestionUsuario != null && this.gestionUsuario.btn_guardar == e.getSource() && this.gestionUsuario.txt_usuario.isEnabled()) {
            System.out.println("click en el boton guardar");
            if (this.usuario.getId_usuario() == null) {
                System.out.println("Id es nulo por lo tanto es nuevo");
                agregarUsuario();
            } else {
                actualizarUsuario();
            }
        }

        if (this.gestionUsuario != null && this.gestionUsuario.btn_editar == e.getSource()) {

            int fila_seleccionada = gestionUsuario.TABLE.getSelectedRow();
            if (fila_seleccionada >= 0) {
                gestionUsuario.habilitarCampos();
                this.usuario = this.usuarios.get(fila_seleccionada);
                gestionUsuario.txt_usuario.setText(usuario.getUsuario());
                gestionUsuario.txt_clave.setText(usuario.getClave());
                gestionUsuario.txt_privilegios.setSelectedIndex(usuario.getTipo() - 1);
            } else {
                JOptionPane.showMessageDialog(gestionUsuario, "Por favor seleccione una fila.");
            }

        }

        if (this.gestionUsuario != null && this.gestionUsuario.btn_eliminar == e.getSource()) {
            int fila_seleccionada = gestionUsuario.TABLE.getSelectedRow();
            if (fila_seleccionada >= 0) {
                this.usuario = this.usuarios.get(fila_seleccionada);
                int decision = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar este usuario?", "Confirmación", JOptionPane.YES_NO_OPTION);
                if (decision == 0) {
                    if (udao.eliminar(usuario.getId_usuario())) {
                        gestionUsuario.desabilitarYVaciarCampos();
                        JOptionPane.showMessageDialog(gestionUsuario, "Eliminado con éxito");
                        cargarListaUsuarios();
                    }

                }
            } else {
                JOptionPane.showMessageDialog(gestionUsuario, "Por favor seleccione una fila.");
            }

        }

    }

    private void agregarUsuario() {
        String user, clave;
        user = this.gestionUsuario.txt_usuario.getText();
        clave = this.gestionUsuario.txt_clave.getText();
        int tipo = this.gestionUsuario.txt_privilegios.getSelectedIndex() + 1;
        if (validarCamposGA(user, clave, tipo)) {
            usuario.setUsuario(user);
            usuario.setClave(clave);
            usuario.setTipo(tipo);
            if (udao.insertar(usuario)) {
                JOptionPane.showMessageDialog(gestionUsuario, "Registrado con éxito");
                this.gestionUsuario.desabilitarYVaciarCampos();
                this.cargarListaUsuarios();
            }
        }

    }

    private void actualizarUsuario() {
        //System.out.println("actualizando...");
        String user, clave;
        user = this.gestionUsuario.txt_usuario.getText();
        clave = this.gestionUsuario.txt_clave.getText();
        int tipo = this.gestionUsuario.txt_privilegios.getSelectedIndex() + 1;
        if (validarCamposGA(user, clave, tipo)) {
            System.out.println("validarCampos es true");
            usuario.setUsuario(user);
            usuario.setClave(clave);
            usuario.setTipo(tipo);
            if (udao.actualizar(usuario)) {
                JOptionPane.showMessageDialog(gestionUsuario, "Registrado con éxito");
                this.gestionUsuario.desabilitarYVaciarCampos();
                this.cargarListaUsuarios();
            }
        }
    }

    private boolean validarCamposGA(String usuario, String clave, int tipo) {
        if (usuario.isEmpty() || val.contieneEspaciosOCaracteresEspeciales(usuario)) {
            JOptionPane.showMessageDialog(gestionUsuario, "Ingrese el usuario correctamente. (Sin espacios ni caracteres especiales diferentes a: .'_-)");
            return false;
        }
        if (clave.isEmpty() || val.contieneEspaciosOCaracteresEspeciales(clave)) {
            JOptionPane.showMessageDialog(gestionUsuario, "Ingrese la clave correctamente. (Sin espacios ni caracteres especiales diferentes a: .'_-)");
            return false;
        }
        if (tipo <= 0) {
            JOptionPane.showMessageDialog(gestionUsuario, "Seleccione los privilegios del Administrador");
            return false;
        }

        return true;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    private void actualizarAdministradorPrincipal() {
        String usuario = vistaRegistroAdmin.txt_usuario.getText();
        String clave = vistaRegistroAdmin.txt_clave.getText();
        if (clave.equals(vistaRegistroAdmin.txt_clave_confirmar.getText())) {
            admin.setUsuario(usuario);
            admin.setClave(clave);
            admin.setTipo(3);
            if (adao.actualizar(this.admin)) {
                JOptionPane.showMessageDialog(vistaRegistroAdmin, "Registrado con Éxito");
                vistaRegistroAdmin.dispose();
                new Login().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(vistaRegistroAdmin, "No se ha podido registrar");
            }
        } else {
            JOptionPane.showMessageDialog(vistaRegistroAdmin, "Las contraseñas introducidas no coinciden");
        }

    }

    private void iniciarSesion() {
        JOptionPane.showMessageDialog(main, "Correcto!");
        int tipo = 0;
        if (adao.getTipoAdmin() != 0) {
            tipo = adao.getTipoAdmin();
        } else {
            tipo = udao.getTipoUsuario();
        }
        MenuPrincipal menu = new MenuPrincipal(tipo);
        menu.setVisible(true);
        this.main.dispose();
    }

}
