package com.hk.views;

import com.hk.controllers.PrincipalController;
import java.awt.Image;
import java.awt.Toolkit;

public class RegistrarHoraVista extends javax.swing.JFrame {
    private PrincipalController pController;
    
    public RegistrarHoraVista() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setResizable(false);
        this.label_nombreEmpleado.setText("Empleado");
    }
    
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("com/hk/img/logo.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        label_nombreEmpleado = new javax.swing.JLabel();
        btn_desactivarCamara = new rojerusan.RSButtonMetro();
        btn_activarCamara = new rojerusan.RSButtonMetro();
        btn_backdoor = new rojerusan.RSButtonMetro();
        Panel_foto2 = new javax.swing.JPanel();
        recuadro_cam = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar Asistencia - SAPCAD");
        setIconImage(getIconImage());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(350, 100));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122, 0, 1), 4));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        label_nombreEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        label_nombreEmpleado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label_nombreEmpleado.setText("Empleado");
        jPanel3.add(label_nombreEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 4, 780, 90));

        btn_desactivarCamara.setBackground(new java.awt.Color(122, 0, 1));
        btn_desactivarCamara.setText("Desactivar Cámara");
        btn_desactivarCamara.setPreferredSize(new java.awt.Dimension(150, 40));
        btn_desactivarCamara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_desactivarCamaraActionPerformed(evt);
            }
        });
        jPanel3.add(btn_desactivarCamara, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, 160, 40));

        btn_activarCamara.setBackground(new java.awt.Color(122, 0, 1));
        btn_activarCamara.setText("Activar Cámara");
        btn_activarCamara.setPreferredSize(new java.awt.Dimension(150, 40));
        btn_activarCamara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_activarCamaraActionPerformed(evt);
            }
        });
        jPanel3.add(btn_activarCamara, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, -1, 40));

        btn_backdoor.setBackground(new java.awt.Color(122, 0, 1));
        btn_backdoor.setText("CI");
        jPanel3.add(btn_backdoor, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 410, 40, 40));

        Panel_foto2.setBackground(new java.awt.Color(122, 0, 1));

        recuadro_cam.setBackground(new java.awt.Color(255, 255, 255));
        recuadro_cam.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));

        javax.swing.GroupLayout Panel_foto2Layout = new javax.swing.GroupLayout(Panel_foto2);
        Panel_foto2.setLayout(Panel_foto2Layout);
        Panel_foto2Layout.setHorizontalGroup(
            Panel_foto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_foto2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(recuadro_cam, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Panel_foto2Layout.setVerticalGroup(
            Panel_foto2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_foto2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(recuadro_cam, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(Panel_foto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 320, 270));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 62;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 10);
        jPanel2.add(jPanel3, gridBagConstraints);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_desactivarCamaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_desactivarCamaraActionPerformed
        //startCamera();
    }//GEN-LAST:event_btn_desactivarCamaraActionPerformed

    private void btn_activarCamaraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_activarCamaraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_activarCamaraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Panel_foto2;
    public rojerusan.RSButtonMetro btn_activarCamara;
    public rojerusan.RSButtonMetro btn_backdoor;
    public rojerusan.RSButtonMetro btn_desactivarCamara;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public javax.swing.JLabel label_nombreEmpleado;
    public javax.swing.JLabel recuadro_cam;
    // End of variables declaration//GEN-END:variables
}
