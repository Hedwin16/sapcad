package com.hk.views;

import java.awt.Image;
import java.awt.Toolkit;

public class RegistroPorCI extends javax.swing.JFrame {

    public RegistroPorCI() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("com/hk/img/logo.png"));
        return retValue;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_ced = new javax.swing.JTextField();
        btn_registrarPorCedula = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(404, 325));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 0, 1), 4, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Registro de Hora");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 14, 384, 60));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Cédula:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 80, 396, 39));

        txt_ced.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(txt_ced, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 132, 200, 40));

        btn_registrarPorCedula.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hk/img/registrar_off.png"))); // NOI18N
        btn_registrarPorCedula.setMnemonic('b');
        btn_registrarPorCedula.setBorderPainted(false);
        btn_registrarPorCedula.setContentAreaFilled(false);
        btn_registrarPorCedula.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_registrarPorCedula.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hk/img/registrar_on.png"))); // NOI18N
        jPanel3.add(btn_registrarPorCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 200, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 320));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_registrarPorCedula;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JTextField txt_ced;
    // End of variables declaration//GEN-END:variables
}
