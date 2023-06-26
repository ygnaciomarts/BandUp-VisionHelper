/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bandup.visionhelper;

import static com.bandup.visionhelper.Test.setScaledImage;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Ygnacio
 */
public class Carga extends javax.swing.JFrame {
    
    private Timer timer;
    private int progreso;

    /**
     * Creates new form Carga
     */
    public Carga() {
        initComponents();
        
        Gradiente gradiente = new Gradiente();
        gradiente.setBounds(0, 0, jPanel2.getWidth(), jPanel2.getHeight());
        jPanel2.add(gradiente);
        
        String imagePath = "src\\com\\bandup\\resources\\logo.png";

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
        }
        
        if (image != null) {
            setScaledImage(lblLogo, image);
        }
        
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../resources/icon/icon.png")));
        
        timer = new Timer(20, (ActionEvent e) -> {
            progreso++;
            pgbrProgreso.setValue(progreso);
            
            if (progreso >= pgbrProgreso.getMaximum()) {
                timer.stop();
                abrirFramesSegunArchivo();
            } else {
                if (progreso == 15) {
                    lblProgreso.setText("Cargando configuración...");
                } else if (progreso == 35) {
                    lblProgreso.setText("Iniciando app...");
                }
            }
        });
        
        try {
            Font fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\bandup\\resources\\fonts\\Winston-Medium.ttf"));
            Font fuente2 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\bandup\\resources\\fonts\\Winston-SemiBold.ttf"));
            Font fuente3 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\bandup\\resources\\fonts\\Winston-SemiBold.ttf"));
            Font fuente4 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\bandup\\resources\\fonts\\Winston-SemiBold.ttf"));
            Font fuente5 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\bandup\\resources\\fonts\\Winston-Medium.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fuente);

            fuente = fuente.deriveFont(Font.PLAIN, 13);
            fuente2 = fuente2.deriveFont(Font.PLAIN, 12);
            fuente3 = fuente3.deriveFont(Font.PLAIN, 17);
            fuente4 = fuente4.deriveFont(Font.PLAIN, 12);
            fuente5 = fuente5.deriveFont(Font.BOLD, 14);

            RenderingHints hints = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            lblProgreso.setFont(fuente2);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }
    
    private void abrirFramesSegunArchivo() {
        String filePath = "src\\com\\bandup\\resources\\saves\\config.buvh";
        File file = new File(filePath);
        if (file.exists()) {
            try {
                // Leer el contenido del archivo
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String linea;
                String matrizSeleccionada = null;
                int porcentaje = 0;

                // Recorrer el archivo línea por línea
                while ((linea = reader.readLine()) != null) {
                    // Obtener la matriz seleccionada del archivo
                    if (linea.startsWith("Condición:")) {
                        matrizSeleccionada = linea.substring(linea.indexOf(":") + 1).trim();
                    } else if (linea.startsWith("Porcentaje:")) {
                        porcentaje = Integer.parseInt(linea.substring(linea.indexOf(":") + 1).trim());
                    }
                }

                reader.close();

                if (matrizSeleccionada != null && porcentaje != 0) {
                    Main app = new Main();
                    app.setMatrizSeleccionada(matrizSeleccionada);
                    app.setPorcentaje(porcentaje);
                    app.setVisible(true);
                }
            } catch (IOException ex) {
                System.out.println("Error al leer el archivo de configuración.");
            }
        } else {
            Inicio noFile = new Inicio();
            noFile.setVisible(true);
        }
        this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        pgbrProgreso = new javax.swing.JProgressBar();
        lblProgreso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BandUp Vision Helper");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(159, 48));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                .addContainerGap())
        );

        pgbrProgreso.setValue(50);

        lblProgreso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblProgreso.setText("Cargando...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pgbrProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                    .addComponent(lblProgreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(pgbrProgreso, javax.swing.GroupLayout.PREFERRED_SIZE, 6, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblProgreso)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        progreso = 0;
        timer.start();
    }//GEN-LAST:event_formWindowOpened

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
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Carga().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblProgreso;
    private javax.swing.JProgressBar pgbrProgreso;
    // End of variables declaration//GEN-END:variables
}
