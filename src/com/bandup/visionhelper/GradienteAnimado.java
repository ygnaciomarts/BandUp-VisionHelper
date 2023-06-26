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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Ygnacio
 */
public class GradienteAnimado extends JPanel {
    private float gradientPosition = 0.47f;
    private Color[] circleColors = {Color.decode("#f11d1c"), Color.decode("#fe7c1e")};
    private Color startColor = circleColors[0];
    private Color endColor = circleColors[1];
    private float animationSpeed = 0.0009f;

    public GradienteAnimado() {
        setOpaque(false);
        startGradientAnimation();
    }

    public void startGradientAnimation() {
        int animationDelay = 10;
        Timer timer = new Timer(animationDelay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                animateGradient();
            }
        });
        timer.start();
    }

    public void animateGradient() {
        gradientPosition += animationSpeed;

        if (gradientPosition >= 0.75f || gradientPosition <= 0.47f) {
            animationSpeed *= -1;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int borderRadius = 20;
        int width = getWidth();
        int height = getHeight();

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        float radius = Math.max(width, height) * gradientPosition;
        radius = Math.max(radius, 1.0f);

        Point2D center = new Point2D.Float(width / 2.0f, height / 2.0f);
        float[] fractions = {0.0f, 0.5f, 1.0f};
        Color[] colors = {startColor, startColor, endColor};
        RadialGradientPaint gradient = new RadialGradientPaint(center, radius, fractions, colors);

        g2d.setPaint(gradient);
        g2d.fillRoundRect(0, 0, width, height, borderRadius, borderRadius);

        g2d.dispose();
    }
}
