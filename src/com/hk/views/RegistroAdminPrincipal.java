/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.views;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author pc
 */
public class RegistroAdminPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form RegistroAdministrador
     */
    public RegistroAdminPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
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
        txt_usuario = new rscomponentshade.RSTextFieldShade();
        txt_clave = new rscomponentshade.RSPassFieldShade();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_ingresar = new rojerusan.RSButtonMetro();
        txt_clave_confirmar = new rscomponentshade.RSPassFieldShade();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro de Administrador Principal");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(600, 630));

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setLayout(new java.awt.GridBagLayout());

        Formulario.setBackground(new java.awt.Color(255, 255, 255));
        Formulario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 0, 0), 4));
        Formulario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("       Confirmar Contraseña: ");
        Formulario.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 420, 39));

        txt_usuario.setBgShadeHover(new java.awt.Color(153, 0, 0));
        txt_usuario.setPlaceholder("   Nombre: ");
        txt_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usuarioActionPerformed(evt);
            }
        });
        Formulario.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 340, -1));

        txt_clave.setBgShadeHover(new java.awt.Color(153, 0, 0));
        txt_clave.setPlaceholder("   *****");
        Formulario.add(txt_clave, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 340, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("REGISTRO");
        Formulario.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 14, 413, 70));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("       Usuario: ");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Formulario.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 420, 39));

        btn_ingresar.setBackground(new java.awt.Color(153, 0, 0));
        btn_ingresar.setText("INGRESAR");
        Formulario.add(btn_ingresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 339, 53));

        txt_clave_confirmar.setBgShadeHover(new java.awt.Color(153, 0, 0));
        txt_clave_confirmar.setPlaceholder("   *****");
        Formulario.add(txt_clave_confirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 340, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("       Contraseña: ");
        Formulario.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 420, 39));

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
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RegistroAdminPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroAdminPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroAdminPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroAdminPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroAdminPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel Formulario;
    public rojerusan.RSButtonMetro btn_ingresar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public rscomponentshade.RSPassFieldShade txt_clave;
    public rscomponentshade.RSPassFieldShade txt_clave_confirmar;
    public rscomponentshade.RSTextFieldShade txt_usuario;
    // End of variables declaration//GEN-END:variables
}
