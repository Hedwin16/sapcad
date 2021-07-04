/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hk.views;

import com.hk.controllers.AdminController;
import com.hk.controllers.PdfController;
import com.hk.controllers.ReconocimientoController;
import com.hk.views.componentes.panel.DefaultPanel;
import com.hk.views.componentes.panel.GestionUsuarios;
import com.hk.views.componentes.panel.GestionDepartamentos;
import com.hk.views.componentes.panel.GestionEmpleados;
import com.hk.views.componentes.panel.RegistrarEmpleado;
import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author HJDS
 */
public class Splash extends javax.swing.JFrame implements Runnable {

    private Thread tiempo = null; 
    
    public Splash() {
        initComponents();
        this.setLocationRelativeTo(null);
        AWTUtilities.setWindowOpaque(this, false);
        tiempo = new Thread(this);
        tiempo.start();  
        this.inicio();
    }
    
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("com/hk/img/logo.png"));
        return retValue;
    }

    public void verificarAdmin(){
        AdminController acontroller = new AdminController();
        acontroller.verificarAdmin();
    }
    
    void initWeightComponents(){
        //Components
        DefaultPanel defaultPanel = new DefaultPanel();
        GestionUsuarios adminPanel = new GestionUsuarios();
        GestionEmpleados empleadosPanel = new GestionEmpleados();
        RegistrarHoraVista vistaRegistroHora = new RegistrarHoraVista();
        RegistrarEmpleado regEmpleados = new RegistrarEmpleado();
        ReconocimientoController rcController = new ReconocimientoController();
        GestionDepartamentos gestionDepartamentos = new GestionDepartamentos();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registro De Entrada y Salida");
        setIconImage(getIconImage());
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 0, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/hk/img/SplashImg.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Splash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
            }
        });
    }
    
    public void run(){
        while(tiempo != null){
            try {
                Thread.sleep(5000);
                this.dispose();
                verificarAdmin();
                //initWeightComponents();
                Thread.sleep(3000);
                break;
            } catch (InterruptedException ex) {
                Logger.getLogger(Splash.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tiempo = null;
    }
    
    
    private void inicio() {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
