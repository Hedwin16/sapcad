
package com.hk.views;

import com.hk.models.Empleado;
import com.hk.models.Hora;
import com.hk.models.LogicaPDF;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.table.DefaultTableCellRenderer;

public final class GestionReportes extends javax.swing.JFrame {

    public GestionReportes() {
        initComponents();
        this.setLocationRelativeTo(null);
        desactivarComponentes();
        setHeaderRenderer();
        //this.setExtendedState(MAXIMIZED_BOTH);
        txt_departamento.removeAllItems();
        txt_nomina.removeAllItems();
    }
    
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("com/hk/img/logo.png"));
        return retValue;
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
    
    void desactivarComponentes(){
        TABLE.setEnabled(false);
        txt_departamento.setEnabled(false);
        txt_nomina.setEnabled(false);
        txt_buscar.setEnabled(false);
        btn_buscar.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLE = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txt_buscar = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_activar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_departamento = new rojerusan.RSComboMetro();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nomina = new rojerusan.RSComboMetro();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_desde = new com.toedter.calendar.JDateChooser();
        txt_hasta = new com.toedter.calendar.JDateChooser();
        btn_generar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Reportes");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(900, 680));

        jPanel4.setRequestFocusEnabled(false);
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122, 0, 1), 4));
        jPanel1.setMinimumSize(new java.awt.Dimension(816, 544));
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
        TABLE.setSelectionBackground(new java.awt.Color(240, 240, 240));
        TABLE.setSelectionForeground(new java.awt.Color(51, 51, 51));
        TABLE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TABLEMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TABLE);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 780, 260));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_buscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel3.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 40));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hk/img/buscar_off.png"))); // NOI18N
        btn_buscar.setMnemonic('b');
        btn_buscar.setBorderPainted(false);
        btn_buscar.setContentAreaFilled(false);
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hk/img/buscar_on.png"))); // NOI18N
        jPanel3.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 90, 40));

        btn_activar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hk/img/seleccion_off.png"))); // NOI18N
        btn_activar.setMnemonic('b');
        btn_activar.setBorderPainted(false);
        btn_activar.setContentAreaFilled(false);
        btn_activar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_activar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_activarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_activar, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 30, 250, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 780, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de Reportes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 4, 810, 51));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Empleado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txt_departamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo 1", "Tipo 2", "Tipo 3 " }));
        txt_departamento.setSelectedIndex(-1);
        txt_departamento.setColorArrow(new java.awt.Color(122, 0, 1));
        txt_departamento.setColorBorde(new java.awt.Color(122, 0, 1));
        txt_departamento.setColorFondo(new java.awt.Color(122, 0, 1));
        txt_departamento.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_departamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_departamentoActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Departamento:");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Nómina:");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        txt_nomina.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tipo 1", "Tipo 2", "Tipo 3 " }));
        txt_nomina.setSelectedIndex(-1);
        txt_nomina.setColorArrow(new java.awt.Color(122, 0, 1));
        txt_nomina.setColorBorde(new java.awt.Color(122, 0, 1));
        txt_nomina.setColorFondo(new java.awt.Color(122, 0, 1));
        txt_nomina.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_nomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_nomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 790, 90));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Hasta:");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 490, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Desde:");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, -1, -1));
        jPanel1.add(txt_desde, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 130, 30));
        jPanel1.add(txt_hasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 140, 30));

        btn_generar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hk/img/generar_off.png"))); // NOI18N
        btn_generar.setMnemonic('b');
        btn_generar.setBorderPainted(false);
        btn_generar.setContentAreaFilled(false);
        btn_generar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_generar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hk/img/generar_on.png"))); // NOI18N
        jPanel1.add(btn_generar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 150, 30));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 17;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 3, 0, 0);
        jPanel4.add(jPanel1, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 853, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TABLEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TABLEMouseClicked
        
    }//GEN-LAST:event_TABLEMouseClicked

    private void txt_departamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_departamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_departamentoActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        if (!txt_departamento.isEnabled()) {
            txt_departamento.setEnabled(true);
        } else {
            txt_departamento.setEnabled(false);
        }
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        if (!txt_nomina.isEnabled()) {
            txt_nomina.setEnabled(true);
        } else {
            txt_nomina.setEnabled(false);
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btn_activarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_activarActionPerformed
        if (!TABLE.isEnabled()) {
            TABLE.setEnabled(true);
            txt_buscar.setEnabled(true);
            btn_buscar.setEnabled(true);
            btn_activar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hk/img/des.png")));
        } else {
            TABLE.setEnabled(false);
            txt_buscar.setEnabled(false);
            btn_buscar.setEnabled(false);
            btn_activar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hk/img/seleccion_off.png")));
        }
    }//GEN-LAST:event_btn_activarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TABLE;
    public javax.swing.JButton btn_activar;
    public javax.swing.JButton btn_buscar;
    public javax.swing.JButton btn_generar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField txt_buscar;
    public rojerusan.RSComboMetro txt_departamento;
    public com.toedter.calendar.JDateChooser txt_desde;
    public com.toedter.calendar.JDateChooser txt_hasta;
    public rojerusan.RSComboMetro txt_nomina;
    // End of variables declaration//GEN-END:variables
}
