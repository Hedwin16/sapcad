
package com.hk.views.componentes.panel;

//Importando I.A
import com.hk.controllers.PrincipalController;
import com.hk.controllers.ReconocimientoController;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;
/**
 *
 * @author pc
 */
public final class RegistrarEmpleado extends javax.swing.JPanel {
       
    public RegistrarEmpleado() {
        initComponents();
        if(txt_departamento != null){
            txt_departamento.removeAllItems();
        }
        if(txt_nomina != null){
            txt_nomina.removeAllItems();
        }
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Panel_foto2 = new javax.swing.JPanel();
        recuadro_cam = new javax.swing.JLabel();
        btn_activarYregistrar = new rojerusan.RSButtonMetro();
        counterLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_departamento = new rojerusan.RSComboMetro();
        txt_nomina = new rojerusan.RSComboMetro();
        jLabel12 = new javax.swing.JLabel();
        txt_nombres = new javax.swing.JTextField();
        txt_apellidos = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        txt_cargo = new javax.swing.JTextField();

        setMinimumSize(new java.awt.Dimension(520, 560));

        jPanel2.setMinimumSize(new java.awt.Dimension(350, 100));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122, 0, 1), 4));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Nuevo Empleado");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 4, 780, 90));

        Panel_foto2.setBackground(new java.awt.Color(122, 0, 1));
        Panel_foto2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        recuadro_cam.setBackground(new java.awt.Color(255, 255, 255));
        recuadro_cam.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 4, true));
        Panel_foto2.add(recuadro_cam, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 270));

        jPanel3.add(Panel_foto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 320, 290));

        btn_activarYregistrar.setBackground(new java.awt.Color(122, 0, 1));
        btn_activarYregistrar.setText("Activar Cámara y Guardar Datos");
        btn_activarYregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_activarYregistrarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_activarYregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 320, 40));

        counterLabel1.setBackground(new java.awt.Color(255, 255, 255));
        counterLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        counterLabel1.setForeground(new java.awt.Color(121, 6, 6));
        counterLabel1.setText("00/200");
        counterLabel1.setOpaque(true);
        jPanel3.add(counterLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 50, 30));

        jScrollPane1.setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText(" Apellidos: ");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 333, 50));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText(" Cédula: ");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 328, 51));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText(" Nombres: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 328, 51));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText(" Cargo: ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 480, 328, 50));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText(" Nómina: ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 328, 51));

        txt_departamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Departamentos...", "Departamento 1", "Departamento 2", "Departamento 3" }));
        txt_departamento.setColorArrow(new java.awt.Color(122, 0, 1));
        txt_departamento.setColorBorde(new java.awt.Color(122, 0, 1));
        txt_departamento.setColorFondo(new java.awt.Color(122, 0, 1));
        txt_departamento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_departamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 330, 40));

        txt_nomina.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar Tipo Nómina..." }));
        txt_nomina.setColorArrow(new java.awt.Color(122, 0, 1));
        txt_nomina.setColorBorde(new java.awt.Color(122, 0, 1));
        txt_nomina.setColorFondo(new java.awt.Color(122, 0, 1));
        txt_nomina.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel1.add(txt_nomina, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 330, 40));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText(" Departamento: ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 328, 51));

        txt_nombres.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(txt_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 330, 40));

        txt_apellidos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(txt_apellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 330, 40));

        txt_cedula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 330, 40));

        txt_cargo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(txt_cargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 330, 40));

        jScrollPane1.setViewportView(jPanel1);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 390, 410));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 13;
        gridBagConstraints.ipady = 62;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 11, 10);
        jPanel2.add(jPanel3, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_activarYregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_activarYregistrarActionPerformed
        //startCamera();
    }//GEN-LAST:event_btn_activarYregistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel Panel_foto2;
    public rojerusan.RSButtonMetro btn_activarYregistrar;
    public javax.swing.JLabel counterLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel recuadro_cam;
    public javax.swing.JTextField txt_apellidos;
    public javax.swing.JTextField txt_cargo;
    public javax.swing.JTextField txt_cedula;
    public rojerusan.RSComboMetro txt_departamento;
    public javax.swing.JTextField txt_nombres;
    public rojerusan.RSComboMetro txt_nomina;
    // End of variables declaration//GEN-END:variables
}
