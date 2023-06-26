/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.bandup.visionhelper;

import static com.bandup.visionhelper.Test.setScaledImage;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Ygnacio
 */
public class Resultados extends javax.swing.JFrame {

    private String[] resultados;
    private double vPromedio;
    private double vProtanopia;
    private double vDeuteranopia;
    private double vTritanopia;
    private double vTotal;

    private static String condicion;
    private static double promPorc;

    String[] llenado;
    Filtros filtro;

    /**
     * Creates new form Resultados
     */
    public Resultados() {
        iniciar();

        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("../resources/icon/icon.png")));
    }

    public void iniciar() {
        initComponents();

        GradienteAnimado gradiente = new GradienteAnimado();
        gradiente.setBounds(0, 0, jPanel4.getWidth(), jPanel4.getHeight());
        jPanel4.add(gradiente);

        String imagePath = "src\\com\\bandup\\resources\\logo.png";

        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (image != null) {
            setScaledImage(lblLogo2, image);
        }

        Contenedor contenedor2 = new Contenedor();
        contenedor2.setBounds(0, 0, pnlContenido.getWidth(), pnlContenido.getHeight());
        pnlContenido.add(contenedor2);

        ContenedorInterno interno = new ContenedorInterno();
        interno.setBounds(0, 0, pnlContenidoIn.getWidth(), pnlContenidoIn.getHeight());
        pnlContenidoIn.add(interno);

        Linea linea = new Linea();
        linea.setBounds(0, 0, jLabel9.getWidth(), jLabel9.getHeight());
        jLabel9.add(linea);

        Linea linea2 = new Linea();
        linea2.setBounds(0, 0, jLabel17.getWidth(), jLabel17.getHeight());
        jLabel17.add(linea2);

        Linea linea3 = new Linea();
        linea3.setBounds(0, 0, jLabel11.getWidth(), jLabel11.getHeight());
        jLabel11.add(linea3);

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
            setUIFont(new FontUIResource(fuente), pnlContenidoIn);

            JTableHeader header = tblResultados.getTableHeader();

            header.setFont(fuente2);

            tblResultados.setShowGrid(true);

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

    Main main;

    public void recibirValores(String[] resultados, double vPromedio, double vProtanopia, double vDeuteranopia, double vTritanopia, double vTotal) {
        String[] respuestasCorrectasA = {"", "29", "5", "15", "6", "45", "74", "3", "57", "Sí", "83", "Amarillo", "Amarillo", "8"};
        String[] respuestasCorrectasB = {"", "29", "5", "15", "6", "45", "74", "3", "57", "si", "83", "amarillo", "amarillo", "8"};
        String[] respuestasCorrectasC = {"", "29", "5", "15", "6", "45", "74", "3", "57", "s", "83", "amarillo", "amarillo", "8"};
        String[] respuestasCorrectasD = {"", "29", "5", "15", "6", "45", "74", "3", "57", "SI", "83", "AMARILLO", "AMARILLO", "8"};

        llenado = resultados;
        //System.out.println(Arrays.toString(llenado));

        DefaultTableModel model = (DefaultTableModel) tblResultados.getModel();

        model.setRowCount(0);

        for (int i = 1; i < resultados.length; i++) {
            model.addRow(new Object[]{i, resultados[i], respuestasCorrectasA[i]});
        }

        main = new Main();

        if (Arrays.equals(respuestasCorrectasA, resultados) || Arrays.equals(respuestasCorrectasB, resultados) || Arrays.equals(respuestasCorrectasC, resultados) || Arrays.equals(respuestasCorrectasD, resultados)) {
            condicion = "Normal";
            main.setMatrizSeleccionada(condicion);
            lblDiagnostico1.setText("<html><i>Visión promedio </i></html>");
        } else {
            lblProta.setText(String.valueOf(formato3.format(vProtanopia)));
            lblDelta.setText(String.valueOf(formato3.format(vDeuteranopia)));
            lblTrita.setText(String.valueOf(formato3.format(vTritanopia)));
            lblTotal.setText(String.valueOf(formato3.format(vTotal)));

            if (vProtanopia > vDeuteranopia && vProtanopia > vTritanopia && vProtanopia > vTotal) {
                condicion = "Protanopía";
                main.setMatrizSeleccionada(condicion);
                promPorc = (vProtanopia / 13.0) * 100;
                main.setPorcentaje((int) promPorc);
                lblDiagnostico1.setText("<html><i>Protanopía (" + formato2.format(promPorc) + "%)</i></html>");
            } else if (vDeuteranopia > vProtanopia && vDeuteranopia > vTritanopia && vDeuteranopia > vTotal) {
                condicion = "Deuteranopía";
                main.setMatrizSeleccionada(condicion);
                promPorc = (vDeuteranopia / 13.0) * 100;
                main.setPorcentaje((int) promPorc);
                lblDiagnostico1.setText("<html><i>Deuteranopía (" + formato2.format(promPorc) + "%)</i></html>");
            } else if (vTritanopia > vProtanopia && vTritanopia > vDeuteranopia && vTritanopia > vTotal) {
                condicion = "Tritanopía";
                main.setMatrizSeleccionada(condicion);
                promPorc = (vTritanopia / 13.0) * 100;
                main.setPorcentaje((int) promPorc);
                lblDiagnostico1.setText("<html><i>Tritanopía (" + formato2.format(promPorc) + "%)</i></html>");
            } else if (vTotal > vProtanopia && vTotal > vTritanopia && vTotal > vDeuteranopia) {
                condicion = "Escala de grises";
                main.setMatrizSeleccionada(condicion);
                promPorc = (vTotal / 13.0) * 100;
                main.setPorcentaje((int) promPorc);
                lblDiagnostico1.setText("<html><i>Acromatopsia (" + formato2.format(promPorc) + "%)</i></html>");
            }

            try {
                String rutaArchivo = "src\\com\\bandup\\resources\\saves\\config.buvh";
                FileWriter writer = new FileWriter(rutaArchivo);
                writer.write("Condición: " + condicion + "\n");
                writer.write("Porcentaje: " + formato.format(promPorc) + "\n");
                writer.write("Resultados: " + Arrays.toString(llenado) + "\n");
                writer.write("Protanopía: " + vProtanopia + "\n");
                writer.write("Deuteranopía: " + vDeuteranopia + "\n");
                writer.write("Tritanopía: " + vTritanopia + "\n");
                writer.write("Acromatopsia: " + vTotal + "\n");
                writer.close();
            } catch (IOException ex) {
            }
        }

        //System.out.println(Arrays.toString(respuestasCorrectasA));
        //System.out.println(Arrays.toString(resultados));
    }

    DecimalFormat formato = new DecimalFormat("###");
    DecimalFormat formato2 = new DecimalFormat("###.##");
    DecimalFormat formato3 = new DecimalFormat("##.##");

    public void getPromPorc(double promPorc) {
        Resultados.promPorc = promPorc;
    }

    public static double getPromPorc() {
        return promPorc;
    }

    public static String getCondicion() {
        return condicion;
    }

    public static void setCondicion(String condicion) {
        Resultados.condicion = condicion;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContenido = new javax.swing.JPanel();
        pnlContenidoIn = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResultados = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        pnlNavegacion = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblLogo2 = new javax.swing.JLabel();
        lblDescubre = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblAcercaDe = new javax.swing.JLabel();
        lblDiagnostico = new javax.swing.JLabel();
        lblTrita = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblProta = new javax.swing.JLabel();
        lblDelta = new javax.swing.JLabel();
        lblDiagnostico1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BandUp Vision Helper");

        pnlContenidoIn.setBackground(new java.awt.Color(255, 255, 255));

        tblResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Disco", "Tus respuestas", "Respuestas"
            }
        ));
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        tblResultados.setDefaultRenderer(Object.class, centerRenderer);
        jScrollPane1.setViewportView(tblResultados);

        javax.swing.GroupLayout pnlContenidoInLayout = new javax.swing.GroupLayout(pnlContenidoIn);
        pnlContenidoIn.setLayout(pnlContenidoInLayout);
        pnlContenidoInLayout.setHorizontalGroup(
            pnlContenidoInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoInLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        pnlContenidoInLayout.setVerticalGroup(
            pnlContenidoInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoInLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(56, 56, 56));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitulo.setText("Respuestas del test");

        javax.swing.GroupLayout pnlContenidoLayout = new javax.swing.GroupLayout(pnlContenido);
        pnlContenido.setLayout(pnlContenidoLayout);
        pnlContenidoLayout.setHorizontalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlContenidoLayout.createSequentialGroup()
                        .addComponent(pnlContenidoIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(20, Short.MAX_VALUE))))
        );
        pnlContenidoLayout.setVerticalGroup(
            pnlContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlContenidoLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(pnlContenidoIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setPreferredSize(new java.awt.Dimension(159, 48));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblLogo2, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lblLogo2, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(8, 8, 8))
        );

        lblDescubre.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblDescubre.setForeground(new java.awt.Color(56, 56, 56));
        lblDescubre.setText("Resultados");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel7.setText("<html> <b>></b> Protanopía: </html>");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel8.setText("<html> <b>></b> Deuteranopía: </html>");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel10.setText("<html> <b>></b> Tritanopía: </html>");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        jLabel14.setText("<html> <b>></b> Acromatopsia: </html>");

        lblAcercaDe.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        lblAcercaDe.setForeground(new java.awt.Color(56, 56, 56));
        lblAcercaDe.setText("Diagnóstico");

        lblDiagnostico.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        lblDiagnostico.setText("<html> <b>></b> Tendencia a</html>");
        lblDiagnostico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblDiagnosticoMousePressed(evt);
            }
        });

        lblTrita.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTrita.setText("-");

        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTotal.setText("-");

        lblProta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblProta.setText("-");

        lblDelta.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDelta.setText("-");

        lblDiagnostico1.setFont(new java.awt.Font("Segoe UI", 2, 13)); // NOI18N
        lblDiagnostico1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDiagnostico1.setText("<html> <i>-</i></html>");
        lblDiagnostico1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblDiagnostico1MousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlNavegacionLayout = new javax.swing.GroupLayout(pnlNavegacion);
        pnlNavegacion.setLayout(pnlNavegacionLayout);
        pnlNavegacionLayout.setHorizontalGroup(
            pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavegacionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlNavegacionLayout.createSequentialGroup()
                        .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDiagnostico)
                            .addGroup(pnlNavegacionLayout.createSequentialGroup()
                                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTrita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlNavegacionLayout.createSequentialGroup()
                                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDelta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblProta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlNavegacionLayout.createSequentialGroup()
                                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDescubre, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblAcercaDe, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNavegacionLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lblDiagnostico1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        pnlNavegacionLayout.setVerticalGroup(
            pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNavegacionLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(lblDescubre)
                .addGap(3, 3, 3)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblProta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDelta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTrita))
                .addGap(6, 6, 6)
                .addGroup(pnlNavegacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTotal))
                .addGap(50, 50, 50)
                .addComponent(lblAcercaDe)
                .addGap(3, 3, 3)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDiagnostico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDiagnostico1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jButton1.setText("Aplicar filtro");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(pnlNavegacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addComponent(jButton1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlContenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlNavegacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        main.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblDiagnosticoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDiagnosticoMousePressed
        //System.out.println("V1.2");
    }//GEN-LAST:event_lblDiagnosticoMousePressed

    private void lblDiagnostico1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDiagnostico1MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lblDiagnostico1MousePressed

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
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Resultados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAcercaDe;
    private javax.swing.JLabel lblDelta;
    private javax.swing.JLabel lblDescubre;
    private javax.swing.JLabel lblDiagnostico;
    private javax.swing.JLabel lblDiagnostico1;
    private javax.swing.JLabel lblLogo2;
    private javax.swing.JLabel lblProta;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTrita;
    private javax.swing.JPanel pnlContenido;
    private javax.swing.JPanel pnlContenidoIn;
    private javax.swing.JPanel pnlNavegacion;
    private javax.swing.JTable tblResultados;
    // End of variables declaration//GEN-END:variables
}
