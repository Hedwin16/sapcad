
package com.hk.views;

import com.hk.models.Empleado;
import com.hk.models.Hora;
import com.hk.models.LogicaPDF;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GestionReportes extends javax.swing.JFrame {

    public GestionReportes() {
        initComponents();
        this.setLocationRelativeTo(null);
        desactivarComponentes();
        this.setExtendedState(MAXIMIZED_BOTH);
    }
    
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("com/hk/img/logo.png"));
        return retValue;
    }
    
    void desactivarComponentes(){
        TABLE.setEnabled(false);
        txt_departamento.setEnabled(false);
        txt_nomina.setEnabled(false);
        txt_buscar.setEnabled(false);
        btn_buscar.setEnabled(false);
        test();
    }
    void test(){
        List<HashMap<Integer, String>> arreglo = new ArrayList<HashMap<Integer, String>>();
        HashMap<Integer,String> mapa = new HashMap<>();
        HashMap<Integer,String> mapa2 = new HashMap<>();
        List<String> datoss = new ArrayList<>();
        datoss.add("Hora de Entrada 1");
        datoss.add("Hora de Entrada 2");
        datoss.add("Hora de Entrada 3");
        datoss.add("Hora de Entrada 4");
        
        List<String> datosss = new ArrayList<>();
        datosss.add("Hora de Entrada");
        datosss.add("Hora de Entrada");
        datosss.add("Hora de Entrada");
        datosss.add("Hora de Entrada");
        
        List<String> datossss = new ArrayList<>();
        datossss.add("Hora de Entrada");
        //Asi si puede ser
        HashMap<Integer,List<String>> arregloloco = new HashMap<>();
        arregloloco.put(123, datoss);
        arregloloco.put(124, datosss);
        arregloloco.put(125, datossss);
        
        mapa.put(1, "valor de uno");
        mapa.put(2, "valor de dos");
        mapa2.put(1, "valor de uno pero con dos");
        
        arreglo.add(mapa);
        arreglo.add(mapa2);
        
        System.out.println(arreglo);
        System.out.println(mapa);
        System.out.println(arregloloco);
        System.out.println("SI: "+arregloloco.get(123).get(0));
        
        
        System.out.println("-----------------------");
        LogicaPDF logicaPDF = new LogicaPDF();
        HashMap<Empleado, List<Hora>> hashDatos = logicaPDF.obtenerHashDiario();
        Iterator<Empleado> iterador = hashDatos.keySet().iterator();
        while (iterador.hasNext()) {
            Empleado key = iterador.next();
            
            System.out.println("Lista");
            System.out.println("" + key.getNombres());
            System.out.println(hashDatos);
        }
        System.out.println("-------------------");
        
        
        System.out.println("-------------------");
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
        btn_buscar = new rojerusan.RSButtonMetro();
        txt_buscar = new javax.swing.JTextField();
        btn_buscar1 = new rojerusan.RSButtonMetro();
        jLabel1 = new javax.swing.JLabel();
        btn_guardar = new rojerusan.RSButtonMetro();
        jPanel2 = new javax.swing.JPanel();
        txt_departamento = new rojerusan.RSComboMetro();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_nomina = new rojerusan.RSComboMetro();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestión de Reportes");
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(900, 680));
        setPreferredSize(new java.awt.Dimension(823, 568));

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

        btn_buscar1.setBackground(new java.awt.Color(122, 0, 1));
        btn_buscar1.setText("Activar");
        btn_buscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscar1ActionPerformed(evt);
            }
        });
        jPanel3.add(btn_buscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 90, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 780, 80));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestión de Reportes");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 4, 810, 51));

        btn_guardar.setBackground(new java.awt.Color(122, 0, 1));
        btn_guardar.setText("Generar Reporte");
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 490, 140, 30));

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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_departamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_nomina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
        jPanel1.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 490, 130, 30));
        jPanel1.add(jDateChooser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 490, 140, 30));

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

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        //startCamera();
    }//GEN-LAST:event_btn_guardarActionPerformed

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

    private void btn_buscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscar1ActionPerformed
        if (!TABLE.isEnabled()){
            TABLE.setEnabled(true);
            txt_buscar.setEnabled(true);
            btn_buscar.setEnabled(true);
        }else{
            TABLE.setEnabled(false);
            txt_buscar.setEnabled(false);
            btn_buscar.setEnabled(false);
        }
    }//GEN-LAST:event_btn_buscar1ActionPerformed

    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TABLE;
    public rojerusan.RSButtonMetro btn_buscar;
    public rojerusan.RSButtonMetro btn_buscar1;
    public rojerusan.RSButtonMetro btn_guardar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
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
    public rojerusan.RSComboMetro txt_nomina;
    // End of variables declaration//GEN-END:variables
}
