package com.hk.controllers;

import com.hk.models.EntrenamientoLBPH;
import com.hk.views.componentes.panel.RegistrarEmpleado;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import org.bytedeco.javacpp.BytePointer;
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
import org.bytedeco.opencv.opencv_objdetect.CascadeClassifier;
import org.bytedeco.opencv.opencv_videoio.VideoCapture;

public class ReconocimientoController {
    private final RegistrarEmpleado panelRegistrar;
    private ReconocimientoController.DaemonThread myThread = null;
    private EmpleadoController eController;
    private PrincipalController pController = new PrincipalController();
    
    CascadeClassifier cascade = new CascadeClassifier("recursos/fotos/haarcascade_frontalface_alt.xml");
    VideoCapture cam = null;
    Mat cameraImage = new Mat();
    BytePointer mem = new BytePointer();
    RectVector detectedFaces = new RectVector();
    int numSamples = 200, sample = 1, idPerson;
    boolean cap = false;
    
    public ReconocimientoController(RegistrarEmpleado panelRegistrar) {
        this.eController = new EmpleadoController(panelRegistrar);
        this.panelRegistrar = panelRegistrar;
        this.eController = new EmpleadoController(panelRegistrar);
        setUltimoIdEmpleado();
    }
    
    public ReconocimientoController(){
        this.cap = true;
        this.panelRegistrar = null;
        this.eController = new EmpleadoController(panelRegistrar);
    }
    
    public void setUltimoIdEmpleado(){
        this.panelRegistrar.txt_id_label.setText(""+this.eController.getIdEmpleado());
    }
    
    void actualizarVista() {
            panelRegistrar.recuadro_cam.setBackground(Color.red);
            setUltimoIdEmpleado();
            SwingUtilities.updateComponentTreeUI(panelRegistrar);
            this.numSamples = 200;
            sample = 1;
        }
    
    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {
                    while (runnable) {
                        try {
                            if (cam.grab()) {
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
                                                String cropped = "recursos/fotos/persona." + panelRegistrar.txt_id_label.getText() + "." + sample + ".jpg";
                                                imwrite(cropped, face);
                                                panelRegistrar.counterLabel1.setText(String.valueOf(sample) + "/200");
                                                sample++;
                                                //Thread.sleep(500);
                                            }
                                            if (sample > 200) {
                                                new EntrenamientoLBPH().trainPhotos();
                                                System.out.println("File Generated");
                                                //guardar();
                                                eController.insertarNuevoEmpleado();
                                                stopCamera();
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

                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
            }
        }

        
    }
    /*
    private void rec() {
        new Thread() {
            @Override
            public void run() {
                
                try {
                    System.out.println("Ahora aqui");
                    Connection cnx =  Conexiones.obtener();
                    PreparedStatement consulta;
                    consulta = cnx.prepareStatement("SELECT * FROM person WHERE id = " + String.valueOf(idPerson));
                    ResultSet r = consulta.executeQuery();
                    while (r.next()) {
                        System.out.println("Estoy Aqui");
                        firstNamePerson = r.getString("first_name");
                        
                        label_name.setText(r.getString("first_name") + " " + r.getString("last_name"));
                        ci_identificada = Integer.parseInt(r.getString("ci"));


                        Array ident = r.getArray("first_name");
                        String[] person = (String[]) ident.getArray();

                        for (String person1 : person) {
                            System.out.println(person1+"eeee");
                        }

                    }
                    //cnx.close();
                } catch (Exception e) {
                }
                
            }
        }.start();
    }
    */
    public void stopCamera() {
        myThread.runnable = false;
        cam.release();
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
