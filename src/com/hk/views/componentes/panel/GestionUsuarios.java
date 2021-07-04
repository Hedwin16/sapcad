
package com.hk.views.componentes.panel;

import com.hk.controllers.AdminController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.table.DefaultTableCellRenderer;

public class GestionUsuarios extends javax.swing.JPanel {
    AdminController aController;
    
    public GestionUsuarios() {
        initComponents();
        setHeaderRenderer();
        desabilitarYVaciarCampos();
        aController = new AdminController(this);
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_guardar = new rojerusan.RSButtonMetro();
        jPanel2 = new javax.swing.JPanel();
        txt_privilegios = new rojerusan.RSComboMetro();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_clave = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLE = new javax.swing.JTable();
        btn_eliminar = new rojerusan.RSButtonMetro();
        btn_editar = new rojerusan.RSButtonMetro();
        btn_nuevo = new rojerusan.RSButtonMetro();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122, 0, 1), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de Usuarios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 805, 51));

        btn_guardar.setBackground(new java.awt.Color(122, 0, 1));
        btn_guardar.setText("Guardar Cambios");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 590, 140, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Administrador", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_privilegios.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo 1", "Tipo 2" }));
        txt_privilegios.setColorArrow(new java.awt.Color(122, 0, 1));
        txt_privilegios.setColorBorde(new java.awt.Color(122, 0, 1));
        txt_privilegios.setColorFondo(new java.awt.Color(122, 0, 1));
        txt_privilegios.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(txt_privilegios, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 107, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Usuario: ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 52, 112, 36));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Clave:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 52, 112, 36));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Privilegios: ");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 102, 112, 36));

        txt_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(148, 50, 200, 45));

        txt_clave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel2.add(txt_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 50, 180, 45));

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Privilegios Tipo 1: El Usuario solo tendrá acceso a la visualización");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 390, -1));

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText(" de Reportes");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, 180, 10));

        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("  modificación de Administrador.  ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 210, 20));

        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Privilegios Tipo 2: El Usuario tendrá acceso a todas las funciones ");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, 400, -1));

        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("del sistema, exceptuando el registro de empleados, horas y ");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 150, 350, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 61, 790, 200));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Administradores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        TABLE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#Id", "Usuario", "Clave", "Privilegios"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TABLE.setSelectionBackground(new java.awt.Color(240, 240, 240));
        TABLE.setSelectionForeground(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(TABLE);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 780, 310));

        btn_eliminar.setBackground(new java.awt.Color(122, 0, 1));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 590, 100, 30));

        btn_editar.setBackground(new java.awt.Color(122, 0, 1));
        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 590, 100, 30));

        btn_nuevo.setBackground(new java.awt.Color(122, 0, 1));
        btn_nuevo.setMnemonic('n');
        btn_nuevo.setText("Nuevo");
        btn_nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(btn_nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 110, 30));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 22;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 0);
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

    private void btn_nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nuevoActionPerformed
    
    public void desabilitarYVaciarCampos(){
        vaciarCampos();
        this.txt_usuario.setEnabled(false);
        this.txt_clave.setEnabled(false);
        this.txt_privilegios.setEnabled(false);
    }
    
    public void habilitarCampos(){
        vaciarCampos();
        this.txt_usuario.setEnabled(true);
        this.txt_clave.setEnabled(true);
        this.txt_privilegios.setEnabled(true);
    }
    
    void vaciarCampos(){
        this.txt_usuario.setText("");
        this.txt_clave.setText("");
        this.txt_privilegios.setSelectedIndex(-1);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TABLE;
    public rojerusan.RSButtonMetro btn_editar;
    public rojerusan.RSButtonMetro btn_eliminar;
    public rojerusan.RSButtonMetro btn_guardar;
    public rojerusan.RSButtonMetro btn_nuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txt_clave;
    public rojerusan.RSComboMetro txt_privilegios;
    public javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
