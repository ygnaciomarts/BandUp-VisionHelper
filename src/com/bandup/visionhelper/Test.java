/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bandup.visionhelper;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Ygnacio
 */
public class Test extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    private Timer timer;

    Font winstonFont = new Font("Winston", Font.PLAIN, 12);

    public Test() {
        iniciarComponentes();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../resources/icon/icon.png")));

        Gradiente gradiente = new Gradiente();
        gradiente.setBounds(0, 0, jPanel2.getWidth(), jPanel2.getHeight());
        jPanel2.add(gradiente);

        Contenedor contenedor1 = new Contenedor();
        contenedor1.setBounds(0, 0, pnlNavegacion.getWidth(), pnlNavegacion.getHeight());

        Contenedor contenedor2 = new Contenedor();
        contenedor2.setBounds(0, 0, pnlContenido.getWidth(), pnlContenido.getHeight());
        pnlContenido.add(contenedor2);

        ContenedorInterno interno = new ContenedorInterno();
        interno.setBounds(0, 0, pnlContenidoIn.getWidth(), pnlContenidoIn.getHeight());
        pnlContenidoIn.add(interno);

        Linea linea = new Linea();
        linea.setBounds(0, 0, jLabel6.getWidth(), jLabel6.getHeight());
        jLabel6.add(linea);

        Linea linea2 = new Linea();
        linea2.setBounds(0, 0, jLabel8.getWidth(), jLabel8.getHeight());
        jLabel8.add(linea2);

        Linea linea3 = new Linea();
        linea3.setBounds(0, 0, jLabel17.getWidth(), jLabel17.getHeight());
        jLabel17.add(linea3);

        String imagePath = "src\\com\\bandup\\resources\\logo.png";
        String plateDemo = "src\\com\\bandup\\resources\\plates\\demo.jpg";

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (image != null) {
            setScaledImage(lblLogo, image);
        }

        BufferedImage demo = null;
        try {
            demo = ImageIO.read(new File(plateDemo));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (demo != null) {
            setScaledImage(lblDiscos, demo);
            txtRespuesta.setEnabled(false);
        }

        try {
            Font fuente = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\bandup\\resources\\fonts\\Winston-Medium.ttf"));
            Font fuente2 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\bandup\\resources\\fonts\\Winston-SemiBold.ttf"));
            Font fuente3 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\bandup\\resources\\fonts\\Winston-SemiBold.ttf"));
            Font fuente4 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\bandup\\resources\\fonts\\Winston-SemiBold.ttf"));
            Font fuente5 = Font.createFont(Font.TRUETYPE_FONT, new File("src\\com\\bandup\\resources\\fonts\\Winston-Medium.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(fuente);

            fuente = fuente.deriveFont(Font.PLAIN, 13);
            fuente2 = fuente2.deriveFont(Font.BOLD, 12);
            fuente3 = fuente3.deriveFont(Font.PLAIN, 17);
            fuente4 = fuente4.deriveFont(Font.PLAIN, 12);
            fuente5 = fuente5.deriveFont(Font.BOLD, 14);

            RenderingHints hints = new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            setUIFont(new FontUIResource(fuente), pnlNavegacion);

            lblDescubre.setFont(fuente2);
            lblIndicacion.setFont(fuente);
            lblPregunta.setFont(fuente5);
            lblAcercaDe.setFont(fuente2);
            lblRespuesta.setFont(fuente4);
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

    private void establecerDisco(String ruta, int numeroImagen) {
        int posX = lblDiscos.getX();
        int posY = lblDiscos.getY();

        String platePath = "src\\com\\bandup\\resources\\plates\\" + ruta + "\\" + numeroImagen + ".jpg";

        BufferedImage imagePlate = null;
        try {
            imagePlate = ImageIO.read(new File(platePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (imagePlate != null) {
            lblDiscos.setSize(243, 243);
            setScaledImage(lblDiscos, imagePlate);
        }

        lblDiscos.setLocation(posX, posY);
    }

    private void establecerInicio(String ruta) {
        int posX = lblDiscos.getX();
        int posY = lblDiscos.getY();

        String platePath = "src\\com\\bandup\\resources\\plates\\" + ruta + ".jpg";

        BufferedImage imagePlate = null;
        try {
            imagePlate = ImageIO.read(new File(platePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (imagePlate != null) {
            lblDiscos.setSize(243, 243);
            setScaledImage(lblDiscos, imagePlate);
        }
        lblDiscos.setLocation(posX, posY);
    }

    private void iniciarComponentes() {
        initComponents();
        btnAnterior.setVisible(false);

        resultados = new String[14];
        contador = 0;
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
        jPanel2 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lblDescubre = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblAcercaDe = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        pnlContenido = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        pnlContenidoIn = new javax.swing.JPanel();
        lblDiscos = new javax.swing.JLabel();
        txtRespuesta = new javax.swing.JTextField();
        lblRespuesta = new javax.swing.JLabel();
        pnlPreguntas = new javax.swing.JPanel();
        lblPregunta = new javax.swing.JLabel();
        lblIndicacion = new javax.swing.JLabel();
        btnSiguiente = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BandUp Vision Helper");

        jPanel2.setPreferredSize(new java.awt.Dimension(159, 48));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        lblDescubre.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblDescubre.setForeground(new java.awt.Color(56, 56, 56));
        lblDescubre.setText("Descubre más sobre...");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel3.setText("<html> <b>></b> ¿Qué es el daltonismo? </html>");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel3MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel3MousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel4.setText("<html> <b>></b> Causas del daltonismo </html>");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel4MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel9.setText("<html> <b>></b> Tipos de daltonismo </html>");
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel9MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel9MousePressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel14.setText("<html> <b>></b> Recursos visuales </html>");
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel14MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel14MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel14MousePressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel15.setText("<html> <b>></b> Impacto en la vida diaria </html>");
        jLabel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel15MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel15MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel15MousePressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel16.setText("<html> <b>></b> Test de Ishihara </html>");
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel16MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel16MousePressed(evt);
            }
        });

        lblAcercaDe.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblAcercaDe.setForeground(new java.awt.Color(56, 56, 56));
        lblAcercaDe.setText("Opciones");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel19.setText("<html> <b>></b> Reiniciar test</html>");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel19MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel19MousePressed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel20.setText("<html> <b>></b> Volver al inicio</html>");
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel20MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel20MouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel20MousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlNavegacionLayout = new javax.swing.GroupLayout(pnlNavegacion);
        pnlNavegacion.setLayout(pnlNavegacionLayout);
        pnlNavegacionLayout.setHorizontalGroup(
            pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavegacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNavegacionLayout.createSequentialGroup()
                        .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlNavegacionLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlNavegacionLayout.createSequentialGroup()
                        .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDescubre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlNavegacionLayout.setVerticalGroup(
            pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavegacionLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblDescubre)
                .addGap(3, 3, 3)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(lblAcercaDe)
                .addGap(3, 3, 3)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(56, 56, 56));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitulo.setText("Test de daltonismo");

        pnlContenidoIn.setBackground(new java.awt.Color(255, 255, 255));

        lblDiscos.setBackground(new java.awt.Color(204, 204, 204));
        lblDiscos.setOpaque(true);

        txtRespuesta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRespuestaKeyPressed(evt);
            }
        });

        lblRespuesta.setText("Respuesta:");

        pnlPreguntas.setBackground(new java.awt.Color(255, 255, 255));

        lblPregunta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPregunta.setText("<html><center>Esta prueba se basa en el test de Ishihara.</html>");

        lblIndicacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIndicacion.setText("<html><center>Si estás listo, haz click en el botón siguiente para empezar.</center><html>");

        javax.swing.GroupLayout pnlPreguntasLayout = new javax.swing.GroupLayout(pnlPreguntas);
        pnlPreguntas.setLayout(pnlPreguntasLayout);
        pnlPreguntasLayout.setHorizontalGroup(
            pnlPreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPreguntasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblPregunta, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
                    .addComponent(lblIndicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlPreguntasLayout.setVerticalGroup(
            pnlPreguntasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPreguntasLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(lblPregunta, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblIndicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContenidoInLayout = new javax.swing.GroupLayout(pnlContenidoIn);
        pnlContenidoIn.setLayout(pnlContenidoInLayout);
        pnlContenidoInLayout.setHorizontalGroup(
            pnlContenidoInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContenidoInLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(lblDiscos, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                .addGroup(pnlContenidoInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlContenidoInLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(lblRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRespuesta, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlContenidoInLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(pnlPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        pnlContenidoInLayout.setVerticalGroup(
            pnlContenidoInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoInLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(pnlContenidoInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiscos, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlContenidoInLayout.createSequentialGroup()
                        .addComponent(pnlPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlContenidoInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtRespuesta)
                            .addComponent(lblRespuesta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlContenidoLayout = new javax.swing.GroupLayout(pnlContenido);
        pnlContenido.setLayout(pnlContenidoLayout);
        pnlContenidoLayout.setHorizontalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoLayout.createSequentialGroup()
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlContenidoIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        pnlContenidoLayout.setVerticalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(pnlContenidoIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(pnlNavegacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAnterior)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSiguiente))
                    .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(343, 343, 343)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                    .addGap(343, 343, 343)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnlNavegacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSiguiente)
                            .addComponent(btnAnterior))))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(252, 252, 252)
                    .addComponent(jLabel7)
                    .addContainerGap(216, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private String[] resultados;
    private int contador;

    private double vPromedio;
    private double vProtanopia;
    private double vDeuteranopia;
    private double vTritanopia;
    private double vTotal;
    ArrayList<String> respuestas = new ArrayList<>();

    private void actualizarPanel() {
        pnlPreguntas.revalidate();
        pnlPreguntas.repaint();

        if (contador <= 0) {
            btnAnterior.setVisible(false);
        }
    }

    private void reiniciarTest() {
        lblTitulo.setText("Test de daltonismo");
        lblPregunta.setText("<html><center>Esta prueba se basa en el test de Ishihara.</html>");
        lblIndicacion.setText("<html><center>Si estás listo, haz click en el botón siguiente para empezar.</center><html>");
        contador = 0;
        resultados = new String[resultados.length];
        txtRespuesta.setText("");
        establecerInicio("demo");
        actualizarPanel();
        btnAnterior.setVisible(false);
        txtRespuesta.setEnabled(false);
    }

    private void recopilarResultado() {
        lblTitulo.setText("Disco " + (contador + 1) + " de 13");
        lblPregunta.setText("<html><center>¿Qué número ves a la izquierda?</html>");
        lblIndicacion.setText("<html><center>Si no logras apreciar nada, deja tu respuesta en blanco.</center><html>");

        String resultado = txtRespuesta.getText();
        respuestas.add(resultado);
        int respuesta;

        if (contador < resultados.length) {
            resultados[contador] = resultado;
            txtRespuesta.setText("");
            contador++;
            //System.out.println(contador);

            if (contador == 1) {
                establecerDisco("protanopia", 1);
                actualizarPanel();

            } else if (contador == 2) {
                establecerDisco("protanopia", 2);
                actualizarPanel();
                btnAnterior.setVisible(true);

            } else if (contador == 3) {
                establecerDisco("protanopia", 3);
                actualizarPanel();

            } else if (contador == 4) {
                establecerDisco("protanopia", 4);
                actualizarPanel();

            } else if (contador == 5) {
                establecerDisco("deuteranopia", 5);
                actualizarPanel();

            } else if (contador == 6) {
                establecerDisco("deuteranopia", 6);
                actualizarPanel();

            } else if (contador == 7) {
                establecerDisco("deuteranopia", 7);
                actualizarPanel();

            } else if (contador == 8) {
                establecerDisco("deuteranopia", 8);
                actualizarPanel();

            } else if (contador == 9) {
                lblPregunta.setText("<html><center>¿Distingues más de un color a la izquierda?</html>");
                lblIndicacion.setText("<html><center>Si solo aprecias un color, deja tu respuesta en blanco.</center><html>");
                establecerDisco("tritanopia", 9);
                actualizarPanel();

            } else if (contador == 10) {
                if (resultados[1].isEmpty() && resultados[4].isEmpty() && resultados[9].isEmpty()) {
                    respuesta = JOptionPane.showOptionDialog(
                            null,
                            "Se detectaron múltiples entradas vacías.\n"
                            + "<html><b>¿Deseas continuar con el test?</b></html>",
                            "Confirmación",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new Object[]{"Sí", "No"},
                            null
                    );

                    if (respuesta == JOptionPane.NO_OPTION) {
                        vTotal = 13.0;
                        dispose();
                    } else {
                        vTotal = 13.0;
                    }
                }

                establecerDisco("tritanopia", 10);
                actualizarPanel();

            } else if (contador == 11) {
                lblPregunta.setText("<html><center>¿De qué color aprecias las letras de la izquierda?</html>");
                lblIndicacion.setText("<html><center>Si no logras apreciar nada, deja tu respuesta en blanco.</center><html>");
                establecerDisco("tritanopia", 11);
                actualizarPanel();

            } else if (contador == 12) {
                lblPregunta.setText("<html><center>¿De qué color aprecias los círculos de la izquierda?</html>");
                lblIndicacion.setText("<html><center>Si no logras apreciar nada, deja tu respuesta en blanco.</center><html>");
                establecerDisco("tritanopia", 12);
                actualizarPanel();

            } else if (contador >= 13) {
                establecerDisco("tritanopia", 13);
                actualizarPanel();
            }

            if (contador == resultados.length) {
                actualizarResultados();
            }
        }
    }

    private void posicionAnterior() {
        lblPregunta.setText("<html><center>¿Qué número ves a la izquierda?</html>");
        lblIndicacion.setText("<html><center>Si no logras apreciar nada, deja tu respuesta en blanco.</center><html>");

        if (contador > 0) {
            contador--;
            lblTitulo.setText("Disco " + (contador) + " de 13");
            //System.out.println(contador);
            switch (contador) {
                case 0:
                    btnAnterior.setVisible(false);
                    break;
                case 1:
                    establecerDisco("protanopia", 1);
                    actualizarPanel();
                    btnAnterior.setVisible(false);
                    break;
                case 2:
                    establecerDisco("protanopia", 2);
                    actualizarPanel();
                    break;
                case 3:
                    establecerDisco("protanopia", 3);
                    actualizarPanel();
                    break;
                case 4:
                    establecerDisco("protanopia", 4);
                    actualizarPanel();
                    break;
                case 5:
                    establecerDisco("deuteranopia", 5);
                    actualizarPanel();
                    break;
                case 6:
                    establecerDisco("deuteranopia", 6);
                    actualizarPanel();
                    break;
                case 7:
                    establecerDisco("deuteranopia", 7);
                    actualizarPanel();
                    break;
                case 8:
                    establecerDisco("deuteranopia", 8);
                    actualizarPanel();
                    break;
                case 9:
                    lblPregunta.setText("<html><center>¿Distingues más de un color a la izquierda?</html>");
                    lblIndicacion.setText("<html><center>Si solo aprecias un color, deja tu respuesta en blanco.</center><html>");
                    establecerDisco("tritanopia", 9);
                    actualizarPanel();
                    break;
                case 10:
                    establecerDisco("tritanopia", 10);
                    actualizarPanel();
                    break;
                case 11:
                    lblPregunta.setText("<html><center>¿De qué color aprecias las letras de la izquierda?</html>");
                    lblIndicacion.setText("<html><center>Si no logras apreciar nada, deja tu respuesta en blanco.</center><html>");
                    establecerDisco("tritanopia", 11);
                    actualizarPanel();
                    break;
                case 12:
                    lblPregunta.setText("<html><center>¿De qué color aprecias los círculos de la izquierda?</html>");
                    lblIndicacion.setText("<html><center>Si no logras apreciar nada, deja tu respuesta en blanco.</center><html>");
                    establecerDisco("tritanopia", 12);
                    actualizarPanel();
                    break;
                case 13:
                    establecerDisco("tritanopia", 13);
                    actualizarPanel();
                    break;
                default:
                    break;
            }
        }
    }

    private void actualizarResultados() {
        switch (resultados[0]) {
            default:
                break;
        }

        switch (resultados[1]) {
            case "29":
                vPromedio += 1;
                break;
            case "":
                vProtanopia += 1;
                vDeuteranopia += 0.5;
                break;
            default:
                break;
        }

        switch (resultados[2]) {
            case "5":
                vPromedio += 1;
                break;
            case "6":
                vDeuteranopia += 1;
                break;
            case "":
                vProtanopia += 1;
                break;
            default:
                break;
        }

        switch (resultados[3]) {
            case "15":
                vPromedio += 1;
                break;
            case "13":
                vProtanopia += 1;
                break;
            case "17":
                vProtanopia += 1;
                break;
            default:
                break;
        }

        switch (resultados[4]) {
            case "6":
                vPromedio += 1;
                break;
            case "":
                vProtanopia += 1;
                vDeuteranopia += 0.5;
                break;
            default:
                break;
        }

        switch (resultados[5]) {
            case "45":
                vPromedio += 1;
                break;
            case "":
                vProtanopia += 0.3;
                vDeuteranopia += 1;
                break;
            default:
                break;
        }

        switch (resultados[6]) {
            case "74":
                vPromedio += 1;
                break;
            case "21":
                vProtanopia += 0.3;
                break;
            case "91":
                vProtanopia += 0.3;
                break;
            case "71":
                vDeuteranopia += 1;
                break;
            default:
                break;
        }

        switch (resultados[7]) {
            case "3":
                vPromedio += 1;
                break;
            case "5":
                vProtanopia += 0.3;
                vDeuteranopia += 1;
                break;
            default:
                break;
        }

        switch (resultados[8]) {
            case "57":
                vPromedio += 0.5;
                vDeuteranopia += 1.5;
                break;
            case "":
                vProtanopia += 1;
                break;
            default:
                break;
        }

        switch (resultados[9]) {
            case "Si":
                vPromedio += 0.5;
                break;
            case "Sí":
                vPromedio += 0.5;
                break;
            case "S":
                vPromedio += 0.5;
                break;
            case "si":
                vPromedio += 0.5;
                break;
            case "sí":
                vPromedio += 0.5;
                break;
            case "s":
                vPromedio += 0.5;
                break;
            case "":
                vTritanopia += 1;
                break;
            default:
                break;
        }

        switch (resultados[10]) {
            case "83":
                vPromedio += 0.5;
                break;
            case "":
                vTritanopia += 1;
                break;
            default:
                break;
        }

        switch (resultados[11]) {
            case "Amarillo":
                vPromedio += 0.5;
                break;
            case "amarillo":
                vPromedio += 0.5;
                break;
            case "":
                vTritanopia += 1;
                break;
            default:
                break;
        }

        switch (resultados[12]) {
            case "Amarillo":
                vPromedio += 0.5;
                break;
            case "amarillo":
                vPromedio += 0.5;
                break;
            case "Verde":
                vProtanopia += 1;
                vDeuteranopia += 1;
                break;
            case "verde":
                vProtanopia += 1;
                vDeuteranopia += 1;
                break;
            case "Rosa":
                vTritanopia += 1;
                break;
            case "rosa":
                vTritanopia += 1;
                break;
            case "Rojo":
                vTritanopia += 1;
                break;
            case "rojo":
                vTritanopia += 1;
                break;
            default:
                break;
        }

        switch (resultados[13]) {
            case "8":
                vPromedio += 0.5;
                vProtanopia += 0.2;
                vDeuteranopia += 0.2;
                break;
            case "":
                vTritanopia += 7;
                break;
            default:
                break;
        }

//        System.out.println(vPromedio);
//        System.out.println(vProtanopia);
//        System.out.println(vDeuteranopia);
//        System.out.println(vTritanopia);
//        System.out.println(vTotal);
//        System.out.println("res" + Arrays.toString(resultados));
        Resultados frmResultados = new Resultados();
        frmResultados.recibirValores(resultados, vPromedio, vProtanopia, vDeuteranopia, vTritanopia, vTotal);
        frmResultados.setVisible(true);
        dispose();
    }

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        txtRespuesta.setEnabled(true);
        txtRespuesta.requestFocus();
        recopilarResultado();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        posicionAnterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void jLabel19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MousePressed
        //System.out.println("V1.2");
        int respuesta;

        if (contador > 0) {
            respuesta = JOptionPane.showOptionDialog(
                    null,
                    "<html><b>¿Deseas reiniciar el test?</b></html>",
                    "Confirmación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Sí", "No"},
                    null
            );

            if (respuesta == JOptionPane.YES_OPTION) {
                reiniciarTest();
            }
        }
        //reiniciarTest();
    }//GEN-LAST:event_jLabel19MousePressed

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        jLabel16.setText("<html>\n"
                + "<u><b>></b> Test de Ishihara</u>\n"
                + "</html>");
    }//GEN-LAST:event_jLabel16MouseEntered

    private void jLabel16MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseExited
        jLabel16.setText("<html>\n"
                + "<b>></b> Test de Ishihara\n"
                + "</html>");
    }//GEN-LAST:event_jLabel16MouseExited

    private void jLabel20MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MousePressed
        int respuesta;

        respuesta = JOptionPane.showOptionDialog(
                null,
                "<html><b>¿Deseas regresar al inicio?</b></html>",
                "Confirmación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                new Object[]{"Sí", "No"},
                null
        );

        if (respuesta == JOptionPane.YES_OPTION) {
            dispose();
            Inicio ini = new Inicio();
            ini.setVisible(true);
        }

//        dispose();
//        Inicio ini = new Inicio();
//        ini.setVisible(true);
    }//GEN-LAST:event_jLabel20MousePressed

    private void txtRespuestaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRespuestaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            recopilarResultado();
        }
    }//GEN-LAST:event_txtRespuestaKeyPressed

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        jLabel19.setText("<html>\n"
                + "<u><b>></b> Reiniciar test</u>\n"
                + "</html>");
    }//GEN-LAST:event_jLabel19MouseEntered

    private void jLabel19MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseExited
        jLabel19.setText("<html>\n"
                + "<b>></b> Reiniciar test\n"
                + "</html>");
    }//GEN-LAST:event_jLabel19MouseExited

    private void jLabel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseEntered
        jLabel20.setText("<html>\n"
                + "<u><b>></b> Volver al inicio</u>\n"
                + "</html>");
    }//GEN-LAST:event_jLabel20MouseEntered

    private void jLabel20MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseExited
        jLabel20.setText("<html>\n"
                + "<b>></b> Volver al inicio\n"
                + "</html>");
    }//GEN-LAST:event_jLabel20MouseExited

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        jLabel3.setText("<html>\n"
                + "<u><b>></b> ¿Qué es el daltonismo?</u>\n"
                + "</html>");
    }//GEN-LAST:event_jLabel3MouseEntered

    private void jLabel3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseExited
        jLabel3.setText("<html> <b>></b> ¿Qué es el daltonismo? </html>");
    }//GEN-LAST:event_jLabel3MouseExited

    Informacion info;

    private void jLabel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseClicked
//        info = new Informacion();
//        
//        info.setLblTitulo("Test de Ishihara");
//        info.setVisible(true);
    }//GEN-LAST:event_jLabel16MouseClicked

    private void jLabel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MousePressed
        info = new Informacion();
        info.setLblTitulo("Test de Ishihara ");
        info.setTxtaInfo("El test de Ishihara es una de las pruebas más utilizadas para diagnosticar y clasificar las alteraciones de la visión del color (discromatopsias), comúnmente conocidas como daltonismo.\n"
                + "\n"
                + "Este test fue inventado en la Universidad de Tokio por el doctor Shinobu Ishihara en 1917. Consta de 38 tarjetas compuestas por círculos con puntos de colores de tamaños aleatorios en su interior, estos puntos suelen formar números o laberintos.\n\n"
                + "El test de Ishihara, además de diagnosticar y clasificar el daltonismo, también se utiliza para conocer el estado del nervio óptico y sus fibras. Es importante en patologías inflamatorias o compresión del nervio en procesos tumorales.");

        info.setVisible(true);
    }//GEN-LAST:event_jLabel16MousePressed

    private void jLabel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MousePressed
        info = new Informacion();

        info.setLblTitulo("Daltonismo ");
        info.setTxtaInfo("El daltonismo es una afección en la cual no se pueden ver los colores de manera normal. También se conoce como deficiencia de color. En el daltonismo generalmente la persona no puede distinguir entre ciertos colores. Con frecuencia no distinguen los verdes de los rojos y, a veces, los azules.\n" + "\n" + "En la retina hay dos tipos de células que detectan la luz. Esas células se llaman bastoncillos y conos. Los bastoncillos solo detectan la luz y la oscuridad y son muy sensibles a los niveles bajos de luz. Los conos detectan los colores y están concentrados cerca del centro de la visión. Hay tres tipos de conos: unos detectan el rojo, otros el verde y otros el azul. El cerebro usa la información que envían los conos para determinar el color que percibimos.");
        info.setVisible(true);
    }//GEN-LAST:event_jLabel3MousePressed

    private void jLabel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseEntered
        jLabel4.setText("<html>\n"
                + "<u><b>></b> Causas del daltonismo</u>\n"
                + "</html>");
    }//GEN-LAST:event_jLabel4MouseEntered

    private void jLabel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseExited
        jLabel4.setText("<html> <b>></b> Causas del daltonismo </html>");
    }//GEN-LAST:event_jLabel4MouseExited

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        info = new Informacion();

        info.setLblTitulo("Causas ");
        info.setTxtaInfo("La mayoría de las personas que tienen daltonismo nacen con la afección. (Esto es lo que se llama una afección congénita). Los defectos congénitos de la visión de color suelen pasar de la madre al hijo varón.\n"
                + "\n"
                + "Estos defectos se deben a una ausencia parcial o total de los conos en la retina. Los conos ayudan a distinguir los colores rojo, verde y azul.\n"
                + "\n"
                + "La mayoría de los problemas de la visión de color que aparecen más adelante en la vida son resultado de:\n"
                + "> Una enfermedad\n"
                + "> Un traumatismo\n"
                + "> Los efectos tóxicos de algunos medicamentos\n"
                + "> Una enfermedad metabólica o\n"
                + "> Una enfermedad vascular\n\n"
                + "Los defectos de la visión de color causados por una enfermedad no se entienden tan bien como los defectos congénitos. El daltonismo debido a una enfermedad específica a menudo afecta cada ojo de manera diferente, y suele empeorar con el tiempo. La pérdida de la visión de color adquirida puede ser el resultado de daño a la retina o al nervio óptico.");
        info.setVisible(true);
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseEntered
        jLabel9.setText("<html>\n"
                + "<u><b>></b> Tipos de daltonismo</u>\n"
                + "</html>");
    }//GEN-LAST:event_jLabel9MouseEntered

    private void jLabel9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseExited
        jLabel9.setText("<html> <b>></b> Tipos de daltonismo </html>");
    }//GEN-LAST:event_jLabel9MouseExited

    private void jLabel9MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MousePressed
        info = new Informacion();

        info.setLblTitulo("Tipos ");
        info.setTxtaInfo("Hay distintos grados de daltonismo. Algunas personas con deficiencias leves para ver los colores detectan los colores normalmente cuando hay buena luz pero tienen dificultad en la luz tenue. Otras no pueden distinguir ciertos colores en ningún tipo de luz. La forma más grave de daltonismo, en la cual todo se ve en distintos tonos de gris, es poco común. El daltonismo suele afectar ambos ojos por igual y se mantiene estable a lo largo de toda la vida.\n\n"
                + "> Deuteranopía: Alteración de la visión al color rojo. Puede ser total o parcial.\n"
                + "> Protanopía: Alteración de la visión al color verde. Puede ser total o parcial.\n"
                + "> Tritanopía: Alteración de la visión al color azul. Puede ser total o parcial.\n"
                + "> Acromatopsia: Ceguera al color.");
        info.setVisible(true);
    }//GEN-LAST:event_jLabel9MousePressed

    private void jLabel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseEntered
        jLabel14.setText("<html>\n"
                + "<u><b>></b> Recursos visuales</u>\n"
                + "</html>");
    }//GEN-LAST:event_jLabel14MouseEntered

    private void jLabel14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseExited
        jLabel14.setText("<html> <b>></b> Recursos visuales </html>");
    }//GEN-LAST:event_jLabel14MouseExited

    private void jLabel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MousePressed
        info = new Informacion();

        info.setLblTitulo("Recursos ");
        info.setTxtaInfo("No hay una cura para el daltonismo transmitido de padres a hijos, pero la mayoría de las personas encuentra formas de adaptarse. Los niños daltónicos podrían necesitar ayuda con algunas actividades en el aula, y es posible que los adultos daltónicos no puedan realizar ciertos trabajos, como ser piloto o diseñador gráfico. Tenga en cuenta que la mayoría de las veces, el daltonismo no causa problemas graves.\n"
                + "\n"
                + "Si su daltonismo se debe a otro problema de salud, su médico tratará la afección que está causando el problema. Si está tomando un medicamento que causa daltonismo, el médico podría ajustarle la dosis o sugerirle que cambie a otro medicamento.\n"
                + "\n"
                + "Si el daltonismo está causando problemas con las tareas diarias, existen algunos dispositivos y tecnologías que pueden ayudar, incluyendo:\n"
                + "\n"
                + "> Anteojos y lentes de contacto. Los lentes de contacto y los anteojos especiales podrían ayudar a las personas daltónicas a diferenciar los colores.\n"
                + "> Ayudas visuales. Puede usar ayudas visuales, aplicaciones digitales y otro tipo de tecnología que le ayudarán a vivir con daltonismo. Por ejemplo, puede usar una aplicación digital para tomar una foto con su teléfono o tableta y luego tocar una parte de la foto para saber el color de esa área.");
        info.setVisible(true);
    }//GEN-LAST:event_jLabel14MousePressed

    private void jLabel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseEntered
        jLabel15.setText("<html>\n"
                + "<u><b>></b> Impacto en la vida diaria</u>\n"
                + "</html>");
    }//GEN-LAST:event_jLabel15MouseEntered

    private void jLabel15MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MouseExited
        jLabel15.setText("<html> <b>></b> Impacto en la vida diaria </html>");
    }//GEN-LAST:event_jLabel15MouseExited

    private void jLabel15MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel15MousePressed
        info = new Informacion();

        info.setLblTitulo("Impacto ");
        info.setTxtaInfo("La mayoría de los daltónicos llevan una vida completamente normal y muchos son diagnosticados de forma muy tardía sin que suponga ningún problema. “En la infancia, padres y profesores pueden sospechar de la existencia de este defecto durante el aprendizaje de los colores, con determinados juegos o el típico dibujo en el que el niño colorea la copa del árbol marrón y el tronco verde”, describe Capote.\n"
                + "\n"
                + "En lo que se refiere a los síntomas, Dorronzoro apunta que solo en casos graves el problema se acompaña de otras manifestaciones, como “movimientos rápidos de los ojos de un lado a otro (nistagmo)”.\n"
                + "\n"
                + "El experto puntualiza que ser daltónico “no es ningún impedimento para la obtención del carnet de conducir para un particular”, aunque hay algunas profesiones prohibidas, como piloto de aviación, controlador de tráfico aéreo, mecánicos y conductores de tren, etc.\n"
                + "\n"
                + "Si el daltonismo es secundario a otra enfermedad, prevenir o tratar esa patología podría solucionar el problema. No obstante, Dorronzoro precisa que “los defectos de visión de color causados por una enfermedad no se entienden tan bien como los defectos congénitos. El daltonismo debido a una enfermedad específica a menudo afecta a cada ojo de manera diferente y suele empeorar con el tiempo”.\n"
                + "\n"
                + "En el caso de que esté producido por fármacos, el especialista comenta que se realizan “chequeos oftalmológicos con test de visión de colores y análisis de la función macular”, con el fin de identificar el problema cuanto antes y ajustar el tratamiento.\n"
                + "\n"
                + "Pero en la gran mayoría de los casos, es decir, cuando se trata de la patología de origen genético, no se puede curar. Existen unas gafas con filtros adaptados que, según detalla Capote, “permiten modificar la longitud de onda -que es como se transmite la información del color- media de los colores rojo y verde en ondas que sí son detectadas porque son como el color azul”. Por lo tanto, producen un estímulo parecido a un ojo no daltónico.\n"
                + "\n"
                + "Sin embargo, la oftalmóloga subraya que esas gafas “no corrigen el daltonismo ni ofrecen una visión normal de los colores; posibilitan una visión distinta de la realidad, favoreciendo la identificación del color al mejorar también el contraste”. Añade que no hay “contraindicación médica para usarlas, pero tampoco gran evidencia científica”. Solo funcionan para un tipo específico de daltonismo, el más común, y no son eficientes para el uso de pantallas electrónicas porque “destacan más los píxeles negros”.");
        info.setVisible(true);
    }//GEN-LAST:event_jLabel15MousePressed

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
                new Test().setVisible(true);

            }
        });
    }

    public static void setScaledImage(JLabel label, BufferedImage image) {
        int labelWidth = label.getWidth();
        int labelHeight = label.getHeight();

        int imageWidth = image.getWidth();
        int imageHeight = image.getHeight();

        double scaleFactor = Math.min((double) labelWidth / imageWidth, (double) labelHeight / imageHeight);

        int scaledWidth = (int) (imageWidth * scaleFactor);
        int scaledHeight = (int) (imageHeight * scaleFactor);

        int x = (labelWidth - scaledWidth) / 2;
        int y = (labelHeight - scaledHeight) / 2;

        BufferedImage scaledImage = new BufferedImage(scaledWidth, scaledHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = scaledImage.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(image.getScaledInstance(scaledWidth, scaledHeight, Image.SCALE_SMOOTH), 0, 0, null);
        g2d.dispose();

        label.setIcon(new ImageIcon(scaledImage));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setBounds(x, y, scaledWidth, scaledHeight);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAcercaDe;
    private javax.swing.JLabel lblDescubre;
    private javax.swing.JLabel lblDiscos;
    private javax.swing.JLabel lblIndicacion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblPregunta;
    private javax.swing.JLabel lblRespuesta;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JPanel pnlContenidoIn;
    private javax.swing.JPanel pnlNavegacion;
    private javax.swing.JPanel pnlPreguntas;
    private javax.swing.JTextField txtRespuesta;
    // End of variables declaration//GEN-END:variables
}
