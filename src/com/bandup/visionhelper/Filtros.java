package com.bandup.visionhelper;

import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;

import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;

public class Filtros extends JPanel implements ActionListener {

    private static final long serialVersionUID = 1L;

    private int ANCHO_LENTE = 800;
    private int ALTO_LENTE = 400;
    private final int RETARDO_ACTUALIZACION = 0;
    private JComboBox<String> comboBox;
    double promPorc = Resultados.getPromPorc();
    public static BufferedImage imagenEscalada;
    public static BufferedImage imagenPantalla;
    public static int intensidad;

    private Robot robot;
    private BufferedImage imagenLupa;
    private Point posicionLupa;
    private Rectangle areaLupa;
    private Timer timer;
    float[][] matriz;
    JSlider slider;

    public Filtros() {
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        imagenLupa = new BufferedImage(ANCHO_LENTE, ALTO_LENTE, BufferedImage.TYPE_INT_ARGB);

        setPreferredSize(new Dimension(ANCHO_LENTE, ALTO_LENTE));
        posicionLupa = new Point(0, 0);
        areaLupa = new Rectangle(ANCHO_LENTE, ALTO_LENTE);

        timer = new Timer(RETARDO_ACTUALIZACION, this);
        timer.start();

        JPanel panel = new JPanel();
        panel.setBackground(Color.BLACK);
        setLayout(new BorderLayout());
    }

    public void setComboBox(JComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }

    public void setSlider(JSlider slider) {
        this.slider = slider;
    }

    public void setAnchoLente(int ANCHO_LENTE) {
        this.ANCHO_LENTE = ANCHO_LENTE;
    }

    public void setAltoLente(int ALTO_LENTE) {
        this.ALTO_LENTE = ALTO_LENTE;
    }

    public static BufferedImage simularColor(BufferedImage imagen, float[][] matriz, int opacidad) {
        int width = imagen.getWidth();
        int height = imagen.getHeight();
        BufferedImage nuevaImagen = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                Color colorOriginal = new Color(imagen.getRGB(x, y));
                int r = colorOriginal.getRed();
                int g = colorOriginal.getGreen();
                int b = colorOriginal.getBlue();

                float cantidadFiltro = (float) opacidad / 100f;
                float nuevoR = r + cantidadFiltro * (matriz[0][0] * r + matriz[0][1] * g + matriz[0][2] * b - r);
                float nuevoG = g + cantidadFiltro * (matriz[1][0] * r + matriz[1][1] * g + matriz[1][2] * b - g);
                float nuevoB = b + cantidadFiltro * (matriz[2][0] * r + matriz[2][1] * g + matriz[2][2] * b - b);

                nuevoR = Math.min(Math.max(nuevoR, 0), 255);
                nuevoG = Math.min(Math.max(nuevoG, 0), 255);
                nuevoB = Math.min(Math.max(nuevoB, 0), 255);

                Color nuevoColor = new Color((int) nuevoR, (int) nuevoG, (int) nuevoB);
                nuevaImagen.setRGB(x, y, nuevoColor.getRGB());
            }
        }
        return nuevaImagen;
    }
    
    public void setMatrizSeleccionada(String matrizSeleccionada) {
        comboBox.setSelectedItem(matrizSeleccionada);
    }

    private float[][] obtenerMatrizSeleccionadaDelCombobox() {
        String matrizSeleccionada = (String) comboBox.getSelectedItem();
        switch (matrizSeleccionada) {
            case "Protanopía":
                slider.setEnabled(true);
                return new float[][]{{0.567f, 0.433f, 0}, {0.558f, 0.442f, 0}, {0, 0.242f, 0.758f}};
            case "Deuteranopía":
                slider.setEnabled(true);
                return new float[][]{{0.625f, 0.375f, 0}, {0.7f, 0.3f, 0}, {0, 0.3f, 0.7f}};
            case "Tritanopía":
                slider.setEnabled(true);
                return new float[][]{{0.95f, 0.05f, 0}, {0, 0.433f, 0.567f}, {0, 0.475f, 0.525f}};
            case "Escala de grises":
                slider.setEnabled(true);
                return new float[][]{{0.2126f, 0.7152f, 0.0722f}, {0.2126f, 0.7152f, 0.0722f}, {0.2126f, 0.7152f, 0.0722f}};
            default:
                slider.setEnabled(false);
                return new float[][]{{1f, 0f, 0f}, {0f, 1f, 0f}, {0f, 0f, 1f}};
        }
    }

    private float[][] obtenerCondicion() {
        String matrizSeleccionada = (String) comboBox.getSelectedItem();
        switch (matrizSeleccionada) {
            case "Protanopía":
                slider.setEnabled(true);
                return new float[][]{{0.567f, 0.433f, 0}, {0.558f, 0.442f, 0}, {0, 0.242f, 0.758f}};
            case "Deuteranopía":
                slider.setEnabled(true);
                return new float[][]{{0.625f, 0.375f, 0}, {0.7f, 0.3f, 0}, {0, 0.3f, 0.7f}};
            case "Tritanopía":
                slider.setEnabled(true);
                return new float[][]{{0.95f, 0.05f, 0}, {0, 0.433f, 0.567f}, {0, 0.475f, 0.525f}};
            case "Escala de grises":
                slider.setEnabled(true);
                return new float[][]{{0.2126f, 0.7152f, 0.0722f}, {0.2126f, 0.7152f, 0.0722f}, {0.2126f, 0.7152f, 0.0722f}};
            default:
                slider.setEnabled(false);
                return new float[][]{{1f, 0f, 0f}, {0f, 1f, 0f}, {0f, 0f, 1f}};
        }
    }

    private float[][] matrizSeleccionada;

    public float[][] getMatrizSeleccionada() {
        return matrizSeleccionada;
    }

    public void setMatrizSeleccionada(float[][] matrizSeleccionada) {
        this.matrizSeleccionada = matrizSeleccionada;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Point posicionCursor = MouseInfo.getPointerInfo().getLocation();

            imagenPantalla = new Robot().createScreenCapture(new Rectangle(posicionCursor.x - ANCHO_LENTE / 3, posicionCursor.y - ALTO_LENTE / 3, ANCHO_LENTE, ALTO_LENTE));
            imagenEscalada = new BufferedImage(ANCHO_LENTE, ALTO_LENTE, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = imagenEscalada.createGraphics();
            g2d.drawImage(imagenPantalla, 0, 0, ANCHO_LENTE, ALTO_LENTE, null);
            g2d.dispose();

            float[][] matrizSeleccionada = obtenerMatrizSeleccionadaDelCombobox();

            intensidad = Math.min(Math.max(slider.getValue(), 0), 100);

            BufferedImage imagenProtanopia = simularColor(imagenEscalada, obtenerCondicion(), intensidad);

            g2d = imagenLupa.createGraphics();
            g2d.drawImage(imagenProtanopia, 0, 0, null);
            g2d.dispose();

            posicionLupa.setLocation(posicionCursor.x - ANCHO_LENTE / 2, posicionCursor.y - ALTO_LENTE / 2);

            repaint();
        } catch (AWTException ex) {
            Logger.getLogger(Filtros.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imagenLupa, 0, 0, null);

        g2d.setColor(Color.BLACK);
        g2d.draw(areaLupa);
    }
}
