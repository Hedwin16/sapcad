package com.hk.controllers;

import com.hk.dao.DepartamentoDAO;
import com.hk.dao.EmpleadoDAO;
import com.hk.interfaces.IEmpleado;
import com.hk.models.Departamento;
import com.hk.models.Empleado;
import com.hk.views.RegistrarHoraVista;
import com.hk.views.componentes.panel.GestionEmpleados;
import com.hk.views.componentes.panel.RegistrarEmpleado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class EmpleadoController implements ActionListener{
    IEmpleado edao = new EmpleadoDAO();
    Empleado empleado = new Empleado();
    List<Empleado> empleados;
    RegistrarHoraVista vistaRegistroHora;
    RegistrarEmpleado panelRegistro;
    GestionEmpleados empleadosPanel;
    Validaciones val = new Validaciones();
    DepartamentoController dController = new DepartamentoController();
    List<Departamento> departamentos = new ArrayList<>();
    DepartamentoDAO depDao = new DepartamentoDAO();
    
    public EmpleadoController(RegistrarEmpleado panelRegistro){
        this.panelRegistro = panelRegistro;
    }
    
    public EmpleadoController(RegistrarHoraVista vistaRegistroHora){
        this.vistaRegistroHora = vistaRegistroHora;
    }
    
    public EmpleadoController(GestionEmpleados empleadosPanel){
        this.empleadosPanel = empleadosPanel;
        this.empleadosPanel.btn_buscar.addActionListener(this);
        this.empleadosPanel.btn_editar.addActionListener(this);
        this.empleadosPanel.btn_eliminar.addActionListener(this);
        this.empleadosPanel.btn_guardar.addActionListener(this);
        this.cargarListaEmpleados();
        this.cargarListaDepartamentos(empleadosPanel);
        System.out.println("No entra aquí");
        
    }
    
    public boolean insertarNuevoEmpleado(){
        if(!estaValidado()){
            JOptionPane.showMessageDialog(panelRegistro, "Los datos introducidos no son correctos");
        }else if(existeCedula()){
            JOptionPane.showMessageDialog(panelRegistro, "Ya existe un empleado con la cédula introducida");
        }else{
            return agregarEmpleado();
        }
        return false;
    }
    public boolean agregarEmpleado(){
        String nombres = panelRegistro.txt_nombres.getText();
        String apellidos = panelRegistro.txt_apellidos.getText();
        int cedula = Integer.parseInt(panelRegistro.txt_cedula.getText());
        int index = panelRegistro.txt_departamento.getSelectedIndex();
        departamentos = depDao.mostrar();
        System.out.println("Index : "+index);
        int depart = departamentos.get(index).getId_departamento();
        System.out.println("Id departamento: "+depart);
        String cargo = panelRegistro.txt_cargo.getText();
        
        empleado.setNombres(nombres);
        empleado.setApellidos(apellidos);
        empleado.setCi(cedula);
        empleado.setId_departamento(depart);
        empleado.setCargo(cargo);
        if(edao.insertar(this.empleado)){
            JOptionPane.showMessageDialog(panelRegistro, "Registrado con Éxito...Activando Cámara para guardar fotos....");
            bloquearCampos();
            return true;
        }else{
            JOptionPane.showMessageDialog(panelRegistro, "No se ha podido registrar");
            return false;
        }
    }
    
    boolean existeCedula(){
        int cedula = Integer.parseInt(panelRegistro.txt_cedula.getText());
        return edao.existeCedula(cedula);
    }
    
    public int getIdEmpleado(){
       return edao.getIdNuevoEmpleado();
    }
    void bloquearCampos(){
        panelRegistro.txt_nombres.setEnabled(false);
        panelRegistro.txt_apellidos.setEnabled(false);
        panelRegistro.txt_cedula.setEnabled(false);
        panelRegistro.txt_cargo.setEnabled(false);
        panelRegistro.txt_departamento.setEnabled(false);
    }
    public void vaciarCampos(){
        panelRegistro.txt_nombres.setText("");
        panelRegistro.txt_apellidos.setText("");
        panelRegistro.txt_cedula.setText("");
        panelRegistro.txt_departamento.setSelectedIndex(-1);
        panelRegistro.txt_cargo.setText("");
        
        panelRegistro.txt_nombres.requestFocus();
    }
    
    public boolean estaValidado(){
        return true;
    }
    
    public Empleado getEmpleadoPorId(int id){
        this.empleado = edao.getEmpleadoPorId(id);
        if(empleado.getNombres() == null){
            return null;
        }else{
            return empleado;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Panel Gestión de Empleados
        //Editar
        if(empleadosPanel != null && this.empleadosPanel.btn_editar == e.getSource()){
            int fila_seleccionada = empleadosPanel.TABLE.getSelectedRow();
            if(fila_seleccionada >= 0){
                empleadosPanel.habilitarCampos();
                this.empleado = this.empleados.get(fila_seleccionada);
                empleadosPanel.txt_nombres.setText(empleado.getNombres());
                empleadosPanel.txt_apellidos.setText(empleado.getApellidos());
                empleadosPanel.txt_cedula.setText(empleado.getCi()+"");
                empleadosPanel.txt_cargo.setText(empleado.getCargo());
                int index = 0;
                for (int i = 0; i < departamentos.size(); i++) {
                    if(departamentos.get(i).getId_departamento() == empleado.getId_departamento()){
                        index = i;
                    }
                }
                empleadosPanel.txt_departamento.setSelectedIndex(index);
            }else{
                JOptionPane.showMessageDialog(empleadosPanel, "Por favor seleccione una fila.");
            }
        }
        //Eliminar
        if(empleadosPanel != null && this.empleadosPanel.btn_eliminar == e.getSource()){
            int fila_seleccionada = empleadosPanel.TABLE.getSelectedRow();
            if(fila_seleccionada >= 0){
                this.empleado = this.empleados.get(fila_seleccionada);
                int decision = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar este empleado?", "Confirmación", JOptionPane.YES_NO_OPTION);            
                if(decision == 0){
                    if(edao.eliminar(empleado.getId_empleado())){
                        empleadosPanel.desabilitarYVaciarCampos();
                        JOptionPane.showMessageDialog(empleadosPanel, "Eliminado con éxito");
                        cargarListaEmpleados();
                    }
                    
                }

            }else{
                JOptionPane.showMessageDialog(empleadosPanel, "Por favor seleccione una fila.");
            }
        }
        //Guardar
        if(empleadosPanel != null && this.empleadosPanel.btn_guardar == e.getSource()){
            String nombres,apellidos,cedula,cargo;
            int id_departamento = empleadosPanel.txt_departamento.getSelectedIndex();
            
            nombres = empleadosPanel.txt_nombres.getText();
            apellidos = empleadosPanel.txt_apellidos.getText();
            cedula = empleadosPanel.txt_cedula.getText();
            cargo = empleadosPanel.txt_cargo.getText();
            if(validarCamposGE(nombres,apellidos,cedula,cargo,id_departamento)){
                empleado.setNombres(nombres);
                empleado.setApellidos(apellidos);
                empleado.setCi(Integer.parseInt(cedula));
                int index = empleadosPanel.txt_departamento.getSelectedIndex();
                departamentos = depDao.mostrar();
                System.out.println("Index : "+index);
                int depart = departamentos.get(index).getId_departamento();
                empleado.setId_departamento(depart);
                empleado.setCargo(cargo);
                if(edao.actualizar(empleado)){
                    JOptionPane.showMessageDialog(empleadosPanel, "Registrado con éxito");
                    this.empleadosPanel.desabilitarYVaciarCampos();
                    this.cargarListaEmpleados();
                }
            }
        }
        //Buscar
        if(empleadosPanel != null && this.empleadosPanel.btn_buscar == e.getSource()){
            String busqueda = empleadosPanel.txt_buscar.getText();
            if(busqueda.isEmpty()){
                cargarListaEmpleados();
            }else{
                if(busqueda.equals("ejee")){
                    JOptionPane.showMessageDialog(panelRegistro, "Ingrese valores adecuados en el campo de búsqueda");
                }else{
                    this.empleados = new ArrayList<>();
                    this.empleados = edao.buscarEmpleados(busqueda);
                    if(empleados == null || empleados.isEmpty()){
                        JOptionPane.showMessageDialog(panelRegistro, "No se han encontrado coincidencias");
                    }else{
                        DefaultTableModel dtm = (DefaultTableModel) this.empleadosPanel.TABLE.getModel();
                        dtm.setRowCount(0);

                        empleados.forEach(emp ->
                            dtm.addRow(new Object[]{
                                emp.getNombres(),
                                emp.getApellidos(),
                                emp.getCi(),
                                emp.getId_departamento(),
                                emp.getCargo()
                            })        
                        );
                       
                    }    
                }
                
            }
            
        }
    }

    private void cargarListaEmpleados() {
       empleados = edao.mostrar();
        if(empleados == null || empleados.isEmpty()){
            System.out.println("No hay empleados registrados");
            DefaultTableModel dtm = (DefaultTableModel) this.empleadosPanel.TABLE.getModel();
            dtm.setRowCount(0);
        }else{
            DefaultTableModel dtm = (DefaultTableModel) this.empleadosPanel.TABLE.getModel();
            dtm.setRowCount(0);
            
            empleados.forEach(emp ->
                dtm.addRow(new Object[]{
                    emp.getNombres(),
                    emp.getApellidos(),
                    emp.getCi(),
                    emp.getId_departamento(),
                    emp.getCargo()
                })        
            );
        }
    }

    private boolean validarCamposGE(String nombres, String apellidos, String cedula, String cargo, int id_departamento) {
        if(nombres.isEmpty()){
            JOptionPane.showMessageDialog(empleadosPanel, "Ingrese los nombres correctamente. (Sin caracteres especiales)");
            return false;
        }
        if(apellidos.isEmpty()){
            JOptionPane.showMessageDialog(empleadosPanel, "Ingrese los apellidos correctamente. (Sin caracteres especiales)");
            return false;
        }
        if(cedula.isEmpty() || !val.isNumeric()){
            JOptionPane.showMessageDialog(empleadosPanel, "Ingrese la cédula correctamente. (Sin caracteres especiales, solo numéricos)");
            return false;
        }
        if(cargo.isEmpty()){
            JOptionPane.showMessageDialog(empleadosPanel, "Ingrese el cargo correctamente. (Sin caracteres especiales diferentes a: .'_-)");
            return false;
        }
        if(id_departamento < 0){
            JOptionPane.showMessageDialog(empleadosPanel, "Seleccione un departamento..");
            return false;
        }
        return true;
    }

    private Empleado buscarEmpleado(String busqueda) {
        Empleado resultado = null;
            for(Empleado emp: empleados){
                if(emp.getNombres().equalsIgnoreCase(busqueda)
                 ||emp.getApellidos().equalsIgnoreCase(busqueda)
                 ||String.valueOf(emp.getCi()).equals(busqueda)){
                    resultado = emp;
                    break;
                }
            }
       return resultado;
    }

    private void cargarListaDepartamentos(GestionEmpleados empleadosPanel) {
        departamentos = depDao.mostrar();
        if(departamentos == null ||departamentos.isEmpty()){
            System.out.println("No hay departamentos registrados");
        }else{
            for (int i = 0; i < departamentos.size(); i++) {
                empleadosPanel.txt_departamento.addItem(departamentos.get(i).getNombre_departamento());
            }
        }
    }
    public void cargarListaDepartamentos(RegistrarEmpleado empleadosPanel) {
        departamentos = depDao.mostrar();
        if(departamentos == null ||departamentos.isEmpty()){
            System.out.println("No hay departamentos registrados");
        }else{
            for (int i = 0; i < departamentos.size(); i++) {
                empleadosPanel.txt_departamento.addItem(departamentos.get(i).getNombre_departamento());
            }
        }
    }

    
}
