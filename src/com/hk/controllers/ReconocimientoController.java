package com.hk.controllers;

import com.hk.dao.DepartamentoDAO;
import com.hk.dao.HoraDAO;
import com.hk.dao.TipoNominaDAO;
import com.hk.interfaces.IHora;
import com.hk.models.Departamento;
import com.hk.models.Empleado;
import com.hk.models.EntrenamientoLBPH;
import com.hk.models.Hora;
import com.hk.models.TipoNomina;
import com.hk.views.RegistrarHoraVista;
import com.hk.views.RegistroPorCI;
import com.hk.views.componentes.panel.RegistrarEmpleado;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import org.bytedeco.javacpp.BytePointer;
import org.bytedeco.javacpp.DoublePointer;
import org.bytedeco.javacpp.IntPointer;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imencode;
import static org.bytedeco.opencv.global.opencv_imgcodecs.imwrite;
import org.bytedeco.opencv.global.opencv_imgproc;
import static org.bytedeco.opencv.global.opencv_imgproc.COLOR_BGRA2GRAY;
import static org.bytedeco.opencv.global.opencv_imgproc.cvtColor;
import static org.bytedeco.opencv.global.opencv_imgproc.rectangle;
import org.bytedeco.opencv.opencv_core.Mat;
import org.bytedeco.opencv.opencv_core.Rect;
import org.bytedeco.opencv.opencv_core.RectVector;
import org.bytedeco.opencv.opencv_core.Scalar;
import org.bytedeco.opencv.opencv_core.Size;
import org.bytedeco.opencv.opencv_face.LBPHFaceRecognizer;
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;

public class ReconocimientoController implements ActionListener{
    private RegistrarEmpleado panelRegistrar;
    private ReconocimientoController.DaemonThread myThread = null;
    private EmpleadoController eController;
    private PrincipalController pController;
    private RegistrarHoraVista vistaRegistroHora;
    
    CascadeClassifier cascade = new CascadeClassifier("recursos/fotos/haarcascade_frontalface_alt.xml");
    VideoCapture cam = null;
    Mat cameraImage = new Mat();
    BytePointer mem = new BytePointer();
    RectVector detectedFaces = new RectVector();
    int numSamples = 200, sample = 1, idPerson;
    boolean cap = false;
    boolean activo = false;
    LBPHFaceRecognizer recognizer = LBPHFaceRecognizer.create();
    
    private Hora hora;
    private Empleado empleado;
    public int ci_identificada = 0;
    int cont_ = 0;
    int idUltimoEmpleado = 0;
    int captureId = 0;
    int counter = 0;
    
    List<Departamento> departamentos;
    List<TipoNomina> nominas;
    DepartamentoDAO depDao = new DepartamentoDAO();
    TipoNominaDAO nomDao = new TipoNominaDAO();
    
    public ReconocimientoController(RegistrarEmpleado panelRegistrar, PrincipalController pController) {
        this.eController = new EmpleadoController(panelRegistrar);
        this.panelRegistrar = panelRegistrar;
        this.eController = new EmpleadoController(panelRegistrar);
        this.pController = pController;
        this.panelRegistrar.btn_activarYregistrar.addActionListener(this);
        cargarListaDepartamentos(panelRegistrar);
        cargarListaNominas(panelRegistrar);
    }
    public ReconocimientoController(RegistrarHoraVista vistaRegistroHora,PrincipalController pController) {
        this.eController = new EmpleadoController(vistaRegistroHora);
        this.vistaRegistroHora = vistaRegistroHora;
        this.pController = pController;
        this.vistaRegistroHora.btn_activarCamara.addActionListener(this);
        this.vistaRegistroHora.btn_desactivarCamara.addActionListener(this);
        this.vistaRegistroHora.btn_backdoor.addActionListener(this);
        vistaRegistroHora.addWindowListener(new WindowAdapter() {
        @Override
        public void windowClosing(WindowEvent e) {
            System.out.println("Estoy cerrando ventana de captura de rostro");
            if(activo){
                stopCamera();
            }
            
        }
 });
    }

    public ReconocimientoController(RegistroPorCI vista) {
        
    }
    
    public void cargarListaDepartamentos(RegistrarEmpleado empleadosPanel) {
        departamentos = depDao.mostrar();
        if(departamentos == null ||departamentos.isEmpty()){
            System.out.println("No hay departamentos registrados");
        }else{
            for (int i = 0; i < departamentos.size(); i++) {
                empleadosPanel.txt_departamento.addItem(departamentos.get(i).getNombre_departamento());
            }
        }
    }
    
    private void cargarListaNominas(RegistrarEmpleado empleadosPanel) {
        nominas = nomDao.mostrar();
        if(nominas == null ||nominas.isEmpty()){
            System.out.println("No hay tipos de nomina registrados");
        }else{
            for (int i = 0; i < nominas.size(); i++) {
                empleadosPanel.txt_nomina.addItem(nominas.get(i).getNombre_nomina());
            }
        }
    }
    
    public ReconocimientoController(){
        this.cap = true;
        this.panelRegistrar = null;
        this.eController = new EmpleadoController(panelRegistrar);
    }
    
    
    void actualizarVista() {
            panelRegistrar.recuadro_cam.setBackground(Color.red);
            SwingUtilities.updateComponentTreeUI(panelRegistrar);
            this.numSamples = 200;
            sample = 1;
        }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.panelRegistrar != null && this.panelRegistrar.btn_activarYregistrar == e.getSource()){
            System.out.println("Click");
            if(eController.insertarNuevoEmpleado()){
                this.idUltimoEmpleado = eController.getIdEmpleado();
                this.startCamera();
            }else{
                System.out.println("No se va a registrar");
            }
        }
        if(this.vistaRegistroHora != null && this.vistaRegistroHora.btn_activarCamara == e.getSource()){
            File clasificador = new File("recursos/fotos/clasificador.yml");
            if(!clasificador.exists()){
                JOptionPane.showMessageDialog(vistaRegistroHora, "No hay empleados registrados para el reconocimiento");
            }else{
                recognizer.read("recursos/fotos/clasificador.yml");
                recognizer.setThreshold(80);
                this.startCamera();
            }
            
        }
        if(this.vistaRegistroHora != null && this.vistaRegistroHora.btn_desactivarCamara == e.getSource()){
            if(activo){
                this.stopCamera();
            }
            
        }
        if(this.vistaRegistroHora != null && this.vistaRegistroHora.btn_backdoor == e.getSource()){
            vistaRegistroHora.dispose();
            pController.setRegistroPorCI();
        }
    }
    
    public void registrarHora(){
        int TIME_VISIBLE = 4000;
        String message = "";
        int resultado;
        IHora hdao = new HoraDAO();
        this.hora = new Hora();
        int id_hora = 0;
        id_hora = hdao.idHoraRegistrada(ci_identificada);
        if(id_hora > 0){
            this.hora.setId_hora(id_hora);
        }
        
        resultado = hdao.insertarHoras(this.hora, ci_identificada);
        switch(resultado){
            case 0: message = "Error al registrar";
                break;
            case 1: message = "Registrada Hora de Entrada";
                break;
            case 2: message = "Registrada Hora de Salida";
                break;
            case 3: message = "Ya existe una hora de salida registrada por el empleado hoy";
                break;
                    
        }
        JOptionPane pane = new JOptionPane(message,JOptionPane.INFORMATION_MESSAGE);
        JDialog dialog = pane.createDialog(null, "Registro de Hora");
        dialog.setModal(false);
        dialog.setVisible(true);
        new Timer(TIME_VISIBLE, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            dialog.setVisible(false);
        }
        }).start();
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println("Error Thread");
        }
    }
    
    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                    while (runnable) {
                        try {
                            if(vistaRegistroHora == null){//vista registro
                               if (cam.grab()) {
                                activo = true;
                                cam.retrieve(cameraImage);
                                Graphics g = panelRegistrar.recuadro_cam.getGraphics(); 
                                Mat imageColor = new Mat(); 
                                Mat imageGray = new Mat(); 
                                RectVector detectedFaces = new RectVector(); 
                                imageColor = cameraImage;
                                cvtColor(imageColor, imageGray, COLOR_BGRA2GRAY);
                                Size tamanio = new Size(150,150);
                                cascade.detectMultiScale(imageColor, detectedFaces, 1.1, 1, 1, tamanio, new Size(500,500));

                                for (int i = 0; i < detectedFaces.size(); i++) { 
                                    Rect dadosFace = detectedFaces.get(0);

                                    rectangle(imageColor, dadosFace, new Scalar(255, 153, 0, 2), 3, 0, 0);

                                    Mat face = new Mat(imageGray, dadosFace);
                                    opencv_imgproc.resize(face, face, new Size(160, 160));
                                            if (sample <= numSamples) {
                                                System.out.println("El id del último empleado: "+idUltimoEmpleado);
                                                String cropped = "recursos/fotos/persona." + idUltimoEmpleado + "." + sample + ".jpg";
                                                imwrite(cropped, face);
                                                panelRegistrar.counterLabel1.setText(String.valueOf(sample) + "/200");
                                                sample++;
                                                //Thread.sleep(500);
                                            }
                                            if (sample > 200) {
                                                new EntrenamientoLBPH().trainPhotos();
                                                System.out.println("File Generated");
                                                //guardar();
                                                JOptionPane.showMessageDialog(panelRegistrar, "Registrado con Éxito");
                                                stopCamera();
                                                panelRegistrar.recuadro_cam.setIcon(null);
                                                pController.setRegistrarEmpleado();
                                            }                                
                                }

                                imencode(".bmp", cameraImage, mem);
                                Image im = ImageIO.read(new ByteArrayInputStream(mem.getStringBytes()));
                                BufferedImage buff = (BufferedImage) im;
                                try {
                                    if (g.drawImage(buff, 0, 0, 300, 270, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                        if (runnable == false) {
                                            System.out.println("Foto Guardada");
                                            this.wait();
                                        }
                                    }
                                } catch (Exception e) {
                                    System.out.println("Exception: "+e);
                                }
                            } 
                            }else{//Vista Reconocimiento
                                if (cam.grab()) {
                                    activo = true;
                                    cam.retrieve(cameraImage);
                                    Graphics g = vistaRegistroHora.recuadro_cam.getGraphics();

                                    Mat imageGray = new Mat();
                                    cvtColor(cameraImage, imageGray, COLOR_BGRA2GRAY);

                                    RectVector detectedFace = new RectVector();
                                    cascade.detectMultiScale(imageGray, detectedFace, 1.1, 2, 0, new Size(150, 150), new Size(500, 500));

                                    for (int i = 0; i < detectedFace.size(); i++) {
                                        Rect dadosFace = detectedFace.get(i);
                                        rectangle(cameraImage, dadosFace, new Scalar(0, 255, 0, 3), 3, 0, 0);
                                        Mat faceCapturada = new Mat(imageGray, dadosFace);
                                        opencv_imgproc.resize(faceCapturada, faceCapturada, new Size(160, 160));

                                        IntPointer rotulo = new IntPointer(1);
                                        DoublePointer confidence = new DoublePointer(1);
                                        recognizer.predict(faceCapturada, rotulo, confidence);
                                        int prediction = rotulo.get(0);

                                        if (prediction == -1) {
                                            if(confidence.get(0)>75){
                                                rectangle(cameraImage, dadosFace, new Scalar(0, 0, 255, 3), 3, 0, 0);
                                                idPerson = 0;
                                                vistaRegistroHora.label_nombreEmpleado.setText("No Identificado");
                                            }

                                        } else {
                                            if(confidence.get(0)>65){
                                                rectangle(cameraImage, dadosFace, new Scalar(0, 0, 255, 3), 3, 0, 0);
                                                idPerson = 0;
                                                vistaRegistroHora.label_nombreEmpleado.setText("No Identificado");

                                            }else{
                                                if(captureId > 0 && captureId == idPerson){
                                                    counter++;
                                                    System.out.println("counter: "+counter);
                                                }else{
                                                    counter = 0;
                                                    captureId = idPerson;
                                                }
                                                rectangle(cameraImage, dadosFace, new Scalar(0, 255, 0, 3), 3, 0, 0);
                                                System.out.println(confidence.get(0));
                                                idPerson = prediction;
                                                System.out.println("Persona Reconocida como: " + idPerson);
                                                captureId = idPerson;
                                                rec();
                                            }
                                        }
                                    }

                            imencode(".bmp", cameraImage, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.getStringBytes()));
                            BufferedImage buff = (BufferedImage) im;

                            try {
                                if (g.drawImage(buff, 0, 0, 340, 250, 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                    if (runnable == false) {
                                        this.wait();
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println("reconociendo: "+e);
                            }
                        }
                            }
                            

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
            }
        }

        
    }
    
    private void rec() {
        new Thread() {
            @Override
            public void run() {
                empleado = eController.getEmpleadoPorId(idPerson);
                if(idPerson != 0){
                    ci_identificada = empleado.getCi();
                    vistaRegistroHora.label_nombreEmpleado.setText(empleado.getNombres());
                    if(counter > 50){
                        System.out.println("I can capture the hour");
                        counter = 0;
                        //Registro de Hora
                        if(vistaRegistroHora.label_nombreEmpleado.getText().equals("No Identificado") || 
                        vistaRegistroHora.label_nombreEmpleado.getText().equalsIgnoreCase("Empleado")){
                        System.out.println("No puedo registrar");
                        }else{
                            System.out.println("Si puedo registrar");
                            stopCamera();
                            registrarHora();
                            startCamera();
                            
                            
                        }
                    }
                }else{
                    ci_identificada = 0;
                }
                
            }
        }.start();
    }
    
    public void stopCamera() {
        myThread.runnable = false;
        cam.release();
        activo = false;
    }
    
    
    public void startCamera() {
        new Thread() {
            @Override
            public void run() {
                cam = new VideoCapture(0);
                myThread = new ReconocimientoController.DaemonThread();
                Thread t = new Thread(myThread);
                t.setDaemon(true);
                myThread.runnable = true;
                t.start();
            }
        }.start();
    }
    
    
}
