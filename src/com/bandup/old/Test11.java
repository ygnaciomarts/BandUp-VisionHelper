/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bandup.old;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.Taskbar;
import java.awt.Toolkit;
import java.awt.font.TextAttribute;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Ygnacio
 */
public class Test11 extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    private Timer timer;

    Font winstonFont = new Font("Winston", Font.PLAIN, 12);

    public Test11() {
        //iniciar();

        initComponents();
        //setUndecorated(true);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../resources/icon.png")));
        //ImageIcon icon = new ImageIcon(Test.class.getResource("../resources/icon.png"));

        // Establecer el ícono de la aplicación en el JFrame
        //this.setIconImage(icon.getImage());
        RoundedPanel roundedPanel = new RoundedPanel();
        roundedPanel.setBounds(0, 0, jPanel2.getWidth(), jPanel2.getHeight()); // Ajustar el tamaño según el panel jPanel2
        jPanel2.add(roundedPanel);

        Contenedor contenedor1 = new Contenedor();
        contenedor1.setBounds(0, 0, pnlNavegacion.getWidth(), pnlNavegacion.getHeight()); // Ajustar el tamaño según el panel jPanel2
        //jPanel1.add(contenedor1);

        Contenedor contenedor2 = new Contenedor();
        contenedor2.setBounds(0, 0, jPanel3.getWidth(), jPanel3.getHeight()); // Ajustar el tamaño según el panel jPanel2
        jPanel3.add(contenedor2);

        RoundPanel roundPanel = new RoundPanel();
        roundPanel.setBounds(0, 0, pnlContenidoIn.getWidth(), pnlContenidoIn.getHeight()); // Ajustar el tamaño según el panel jPanel2
        pnlContenidoIn.add(roundPanel);

        Linea linea = new Linea();
        linea.setBounds(0, 0, jLabel6.getWidth(), jLabel6.getHeight()); // Ajustar el tamaño según el panel jPanel2
        jLabel6.add(linea);

        Linea linea2 = new Linea();
        linea2.setBounds(0, 0, jLabel8.getWidth(), jLabel8.getHeight()); // Ajustar el tamaño según el panel jPanel2
        jLabel8.add(linea2);
        
        Linea linea3 = new Linea();
        linea3.setBounds(0, 0, jLabel17.getWidth(), jLabel17.getHeight()); // Ajustar el tamaño según el panel jPanel2
        jLabel17.add(linea3);

        // Iniciar la animación del panel
        timer = new Timer(30, (e) -> {
            roundedPanel.animateGradient();
            jPanel2.repaint();
        });
        timer.setRepeats(true);
        timer.start();

        String imagePath = "C:\\Users\\ygnac\\Documents\\NetBeansProjects\\VisionHelper\\src\\com\\bandup\\resources\\logo.png"; // Ruta de la imagen

// Cargar la imagen desde la ruta de archivo
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

// Verificar si la imagen se cargó correctamente
        if (image != null) {
            // Llamar al método setScaledImage pasando el JLabel y la imagen
            setScaledImage(jLabel1, image);
        }

        try {
            Font fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\bandup\\resources\\fonts\\Winston-Medium.ttf"));
            Font fuente2 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\bandup\\resources\\fonts\\Winston-SemiBold.ttf"));
            Font fuente3 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\bandup\\resources\\fonts\\Winston-SemiBold.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fuente);

            fuente = fuente.deriveFont(Font.PLAIN, 13);
            fuente2 = fuente2.deriveFont(Font.BOLD, 12);
            fuente3 = fuente3.deriveFont(Font.PLAIN, 17);

            RenderingHints hints = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Establecer la fuente en el JFrame y todos sus componentes
            setUIFont(new FontUIResource(fuente), pnlNavegacion);

            lblDescubre.setFont(fuente2);
            lblAcercaDe.setFont(fuente2);
            lblTitulo.setFont(fuente3);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

    }

    private void setUIFont(FontUIResource f, Container container) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof Container) {
                setUIFont(f, (Container) comp);
            }
            comp.setFont(f);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNavegacion = new javax.swing.JPanel();
        lblDescubre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblAcercaDe = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        pnlContenidoIn = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BandUp Vision Helper");

        lblDescubre.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblDescubre.setForeground(new java.awt.Color(56, 56, 56));
        lblDescubre.setText("Descubre más sobre...");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel3.setText("> ¿Qué es el daltonismo?");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel4.setText("> Causas del daltonismo");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel9.setText("> Tipos de daltonismo");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel10.setText("> Protanopía");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel11.setText("> Deuteranopía");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel12.setText("> Tritanopía");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel13.setText("> Acromatopsia");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel14.setText("> Ayudas visuales");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel15.setText("> Impacto en la vida diaria");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel16.setText("<html>\n<b>></b> Mitos y realidades\n</html>");

        lblAcercaDe.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblAcercaDe.setForeground(new java.awt.Color(56, 56, 56));
        lblAcercaDe.setText("Acerca de...");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel19.setText("<html> <b>></b> BandUp Vision Helper </html>");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel19MousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlNavegacionLayout = new javax.swing.GroupLayout(pnlNavegacion);
        pnlNavegacion.setLayout(pnlNavegacionLayout);
        pnlNavegacionLayout.setHorizontalGroup(
            pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavegacionLayout.createSequentialGroup()
                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNavegacionLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)))
                    .addGroup(pnlNavegacionLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDescubre, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        pnlNavegacionLayout.setVerticalGroup(
            pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavegacionLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblDescubre)
                .addGap(3, 3, 3)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addGap(3, 3, 3)
                .addComponent(jLabel10)
                .addGap(2, 2, 2)
                .addComponent(jLabel11)
                .addGap(2, 2, 2)
                .addComponent(jLabel12)
                .addGap(2, 2, 2)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(lblAcercaDe)
                .addGap(3, 3, 3)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pnlContenidoIn.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout pnlContenidoInLayout = new javax.swing.GroupLayout(pnlContenidoIn);
        pnlContenidoIn.setLayout(pnlContenidoInLayout);
        pnlContenidoInLayout.setHorizontalGroup(
            pnlContenidoInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenidoInLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        pnlContenidoInLayout.setVerticalGroup(
            pnlContenidoInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoInLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlContenidoInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlContenidoIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(pnlContenidoIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jButton1.setText("Siguiente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Anterior");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setPreferredSize(new java.awt.Dimension(159, 48));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo.setText("Test de daltonismo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlNavegacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(343, 343, 343)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(343, 343, 343)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlNavegacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(12, 12, 12))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(252, 252, 252)
                    .addComponent(jLabel7)
                    .addContainerGap(298, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MousePressed
        System.out.println("V1.2");
    }//GEN-LAST:event_jLabel19MousePressed

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
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test11().setVisible(true);

            }
        });
    }

    public static void setScaledImage(JLabel label, BufferedImage image) {
        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();

        // Calcular el nuevo tamaño de la imagen manteniendo las proporciones
        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();

        double scaleFactor = Math.min((double) labelWidth / imageWidth, (double) labelHeight / imageHeight);

        int scaledWidth = (int) (imageWidth * scaleFactor);
        int scaledHeight = (int) (imageHeight * scaleFactor);

        // Calcular la posición para centrar la imagen dentro del JLabel
        int x = (labelWidth - scaledWidth) / 2;
        int y = (labelHeight - scaledHeight) / 2;

        // Crear un BufferedImage escalado con antialiasing
        BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(image.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH), 0, 0, null);
        g2d.dispose();

        // Establecer la imagen escalada y centrada en el JLabel
        label.setIcon(new ImageIcon(scaledImage));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBounds(x, y, scaledWidth, scaledHeight);
    }

    public class RoundedPanel extends JPanel {

        private float gradientPosition = 0.0f; // Posición inicial del gradiente en el lado derecho
        private Color[] circleColors = {Color.decode("#f11d1c"), Color.decode("#fe7c1e")};
        private Color startColor = circleColors[0];
        private Color endColor = circleColors[1];

        public RoundedPanel() {
            //setBackground(Color.white);
            setOpaque(false);
        }

        public void animateGradient() {
            gradientPosition += 0.01f; // Ajusta la velocidad de animación según tus preferencias
            if (gradientPosition >= 2.0f) {
                gradientPosition = 0.0f; // Reinicia la posición del gradiente cuando llega al final
            }

            repaint(); // Vuelve a pintar el componente para reflejar el nuevo estado del gradiente
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int borderRadius = 20;
            int width = getWidth();
            int height = getHeight();

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Crear un gradiente radial
            Point2D center = new Point2D.Float(width / 2.0f, height / 2.0f);
            float radius = Math.max(width, height) * 0.5f;
            float[] fractions = {0.0f, 0.5f, 1.0f};
            Color[] colors = {startColor, startColor, endColor};
            RadialGradientPaint gradient = new RadialGradientPaint(center, radius, fractions, colors);

            // Rellenar el panel con el gradiente
            g2d.setPaint(gradient);
            g2d.fillRoundRect(0, 0, width, height, borderRadius, borderRadius);

            g2d.dispose();
        }
    }

    public class RoundPanel extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int borderRadius = 20;
            int width = getWidth();
            int height = getHeight();
            setOpaque(false);

            Color color = Color.decode("#def0fa");

            g2d.setPaint(color);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.fillRoundRect(0, 0, width, height, borderRadius, borderRadius);

            g2d.dispose();
        }
    }

    public class Contenedor extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int borderRadius = 20;
            int width = getWidth();
            int height = getHeight();
            setOpaque(false);

            Color color = Color.decode("#ffffff");

            g2d.setPaint(color);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.fillRoundRect(0, 0, width, height, borderRadius, borderRadius);

            g2d.dispose();
        }
    }

    public class Linea extends JLabel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            int borderRadius = 20;
            int width = getWidth();
            int height = getHeight();
            setOpaque(false);

            Color color = Color.decode("#e8e8e8");

            g2d.setPaint(color);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.fillRect(0, 0, width, height);

            g2d.dispose();
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblAcercaDe;
    private javax.swing.JLabel lblDescubre;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlContenidoIn;
    private javax.swing.JPanel pnlNavegacion;
    // End of variables declaration//GEN-END:variables
}
