/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.views.componentes.panel;

import com.hk.controllers.EmpleadoController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pc
 */
public final class GestionEmpleados extends javax.swing.JPanel {
    EmpleadoController eController;
    
    public GestionEmpleados() {
        initComponents();
        setHeaderRenderer();
        desabilitarYVaciarCampos();
        txt_departamento.removeAllItems();
        txt_nomina.removeAllItems();
        eController = new EmpleadoController(this);
        
    }

    void setHeaderRenderer(){
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(122,0,1));
        headerRenderer.setForeground(new Color(255,255,255));
        headerRenderer.setFont(new Font("Segoe UI", Font.BOLD, 18));
        
        TABLE.setRowHeight(40);
        
        for (int i = 0; i < TABLE.getModel().getColumnCount(); i++) {
            TABLE.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }
    
    public void desabilitarYVaciarCampos(){
        vaciarCampos();
        this.txt_nombres.setEnabled(false);
        this.txt_apellidos.setEnabled(false);
        this.txt_cedula.setEnabled(false);
        this.txt_cargo.setEnabled(false);
        this.txt_departamento.setEnabled(false);
        this.txt_nomina.setEnabled(false);
        
    }
    
    public void habilitarCampos(){
        vaciarCampos();
        this.txt_nombres.setEnabled(true);
        this.txt_apellidos.setEnabled(true);
        this.txt_cedula.setEnabled(true);
        this.txt_cargo.setEnabled(true);
        this.txt_departamento.setEnabled(true);
        this.txt_nomina.setEnabled(true);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLE = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_buscar = new rojerusan.RSButtonMetro();
        txt_buscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_guardar = new rojerusan.RSButtonMetro();
        jPanel2 = new javax.swing.JPanel();
        txt_departamento = new rojerusan.RSComboMetro();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nomina = new rojerusan.RSComboMetro();
        txt_apellidos = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        txt_cargo = new javax.swing.JTextField();
        txt_nombres = new javax.swing.JTextField();
        btn_eliminar = new rojerusan.RSButtonMetro();
        btn_editar = new rojerusan.RSButtonMetro();

        jMenuItem1.setText("Reentrenar Rostro");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122, 0, 1), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        TABLE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombres", "Apellidos", "Ci", "Departamento", "Cargo", "Tipo Nómina"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLE.setComponentPopupMenu(jPopupMenu1);
        TABLE.setSelectionBackground(new java.awt.Color(240, 240, 240));
        TABLE.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(TABLE);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 780, 260));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_buscar.setBackground(new java.awt.Color(122, 0, 1));
        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 90, 40));

        txt_buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 780, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de Empleados");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 805, 51));

        btn_guardar.setBackground(new java.awt.Color(122, 0, 1));
        btn_guardar.setText("Guardar Cambios");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 620, 140, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_departamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo 1", "Tipo 2", "Tipo 3 " }));
        txt_departamento.setSelectedIndex(-1);
        txt_departamento.setColorArrow(new java.awt.Color(122, 0, 1));
        txt_departamento.setColorBorde(new java.awt.Color(122, 0, 1));
        txt_departamento.setColorFondo(new java.awt.Color(122, 0, 1));
        txt_departamento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 96, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombres: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 35, 112, 36));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Apellidos:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 35, 112, 36));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Departamento:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(391, 91, 150, 36));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Cédula:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 91, 112, 36));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Cargo:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 148, 112, 36));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Nómina:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(388, 148, 153, 36));

        txt_nomina.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo 1", "Tipo 2", "Tipo 3 " }));
        txt_nomina.setSelectedIndex(-1);
        txt_nomina.setColorArrow(new java.awt.Color(122, 0, 1));
        txt_nomina.setColorBorde(new java.awt.Color(122, 0, 1));
        txt_nomina.setColorFondo(new java.awt.Color(122, 0, 1));
        txt_nomina.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_nomina, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 153, -1, -1));

        txt_apellidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(546, 37, 200, 30));

        txt_cedula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 94, 200, 30));

        txt_cargo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 152, 200, 30));

        txt_nombres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 200, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 790, 220));

        btn_eliminar.setBackground(new java.awt.Color(122, 0, 1));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 620, 100, 30));

        btn_editar.setBackground(new java.awt.Color(122, 0, 1));
        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 100, 30));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 20;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 4, 3);
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        //startCamera();
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editarActionPerformed

    private void txt_usuario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuario2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuario2ActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TABLE;
    public rojerusan.RSButtonMetro btn_buscar;
    public rojerusan.RSButtonMetro btn_editar;
    public rojerusan.RSButtonMetro btn_eliminar;
    public rojerusan.RSButtonMetro btn_guardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txt_apellidos;
    public javax.swing.JTextField txt_buscar;
    public javax.swing.JTextField txt_cargo;
    public javax.swing.JTextField txt_cedula;
    public rojerusan.RSComboMetro txt_departamento;
    public javax.swing.JTextField txt_nombres;
    public rojerusan.RSComboMetro txt_nomina;
    // End of variables declaration//GEN-END:variables

    private void vaciarCampos() {
        this.txt_nombres.setText("");
        this.txt_apellidos.setText("");
        this.txt_buscar.setText("");
        this.txt_cedula.setText("");
        this.txt_cargo.setText("");
        this.txt_departamento.setSelectedIndex(-1);
    }
}
