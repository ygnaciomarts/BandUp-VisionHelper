/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bandup.visionhelper;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.awt.geom.Point2D;
import javax.swing.JPanel;

/**
 *
 * @author Ygnacio
 */
public class Gradiente extends JPanel {

    private float gradientPosition = 0.0f; // Posición inicial del gradiente en el lado derecho
    private Color[] circleColors = {Color.decode("#f11d1c"), Color.decode("#fe7c1e")};
    private Color startColor = circleColors[0];
    private Color endColor = circleColors[1];

    public Gradiente() {
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
