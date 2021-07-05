/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.views;

import com.hk.controllers.AdminController;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author pc
 */
public class RegistroAdminPrincipal extends javax.swing.JFrame {
    AdminController acontroller;
    
    public RegistroAdminPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        acontroller = new AdminController(this);
    }

    public RegistroAdminPrincipal(boolean editar) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        acontroller = new AdminController(this);
        acontroller.setEditable(editar);
    }
    
    

    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("com/hk/img/logo.png"));
        return retValue;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        Background = new javax.swing.JPanel();
        Formulario = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        txt_clave = new javax.swing.JPasswordField();
        txt_clave_confirmar = new javax.swing.JPasswordField();
        btn_registrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Administrador Principal");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(600, 630));

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setLayout(new java.awt.GridBagLayout());

        Formulario.setBackground(new java.awt.Color(255, 255, 255));
        Formulario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122, 0, 1), 4));
        Formulario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("       Confirmar Contraseña: ");
        Formulario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 420, 39));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REGISTRO");
        Formulario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 14, 413, 70));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("       Usuario: ");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Formulario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 420, 39));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("       Contraseña: ");
        Formulario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 420, 39));

        txt_usuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuarioActionPerformed(evt);
            }
        });
        Formulario.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 340, 40));

        txt_clave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Formulario.add(txt_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 340, 40));

        txt_clave_confirmar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Formulario.add(txt_clave_confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 340, 40));

        btn_registrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hk/img/registrar_off.png"))); // NOI18N
        btn_registrar.setMnemonic('b');
        btn_registrar.setBorderPainted(false);
        btn_registrar.setContentAreaFilled(false);
        btn_registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_registrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hk/img/registrar_on.png"))); // NOI18N
        Formulario.add(btn_registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 340, 50));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipady = 34;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(81, 79, 67, 93);
        Background.add(Formulario, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usuarioActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel Formulario;
    public javax.swing.JButton btn_registrar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JPasswordField txt_clave;
    public javax.swing.JPasswordField txt_clave_confirmar;
    public javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
