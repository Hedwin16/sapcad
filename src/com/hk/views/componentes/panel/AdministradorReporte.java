
package com.hk.views.componentes.panel;

import com.hk.controllers.AdminPDFVistaController;
import com.hk.models.LogicaPDF;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class AdministradorReporte extends javax.swing.JPanel {
    AdminPDFVistaController adminPDFController;
    LogicaPDF logica;
    public AdministradorReporte() {
        initComponents();
        setHeaderRenderer();
        logica = new LogicaPDF();
        adminPDFController = new AdminPDFVistaController(this, logica);
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
        TABLE.getColumnModel().getColumn(0).setPreferredWidth(20);
        TABLE.getColumnModel().getColumn(1).setPreferredWidth(30);
        TABLE.getColumnModel().getColumn(2).setPreferredWidth(10);
        TABLE.getColumnModel().getColumn(3).setPreferredWidth(50);
        TABLE.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLE = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btn_buscar = new rojerusan.RSButtonMetro();
        jLabel4 = new javax.swing.JLabel();
        txt_tipo_reporte = new rojerusan.RSComboMetro();
        jLabel1 = new javax.swing.JLabel();
        btn_eliminar = new rojerusan.RSButtonMetro();
        btn_abrir = new rojerusan.RSButtonMetro();

        setLayout(new java.awt.GridBagLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122, 0, 1), 4));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lista de Reporte", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        TABLE.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Registro", "Tipo de Reporte", "Fecha de Creación"
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
        if (TABLE.getColumnModel().getColumnCount() > 0) {
            TABLE.getColumnModel().getColumn(0).setResizable(false);
        }

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
        jPanel3.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 90, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Tipo de Reporte:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 150, 50));

        txt_tipo_reporte.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos" }));
        txt_tipo_reporte.setColorArrow(new java.awt.Color(122, 0, 1));
        txt_tipo_reporte.setColorBorde(new java.awt.Color(122, 0, 1));
        txt_tipo_reporte.setColorFondo(new java.awt.Color(122, 0, 1));
        txt_tipo_reporte.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_tipo_reporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_tipo_reporteActionPerformed(evt);
            }
        });
        jPanel3.add(txt_tipo_reporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 780, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reportes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 4, 805, 51));

        btn_eliminar.setBackground(new java.awt.Color(122, 0, 1));
        btn_eliminar.setText("Eliminar");
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 390, 100, 30));

        btn_abrir.setBackground(new java.awt.Color(122, 0, 1));
        btn_abrir.setText("Abrir");
        btn_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_abrirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_abrir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 100, 30));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 4;
        gridBagConstraints.ipady = 48;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        add(jPanel1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_abrirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_abrirActionPerformed

    private void txt_tipo_reporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tipo_reporteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_tipo_reporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TABLE;
    public rojerusan.RSButtonMetro btn_abrir;
    public rojerusan.RSButtonMetro btn_buscar;
    public rojerusan.RSButtonMetro btn_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public rojerusan.RSComboMetro txt_tipo_reporte;
    // End of variables declaration//GEN-END:variables
}
