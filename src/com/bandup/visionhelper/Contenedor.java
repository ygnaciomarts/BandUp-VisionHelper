/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bandup.visionhelper;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author Ygnacio
 */
public class Contenedor extends JPanel {

    public Contenedor() {
        setLayout(new FlowLayout()); // Configurar un gestor de diseño

        Color transparente = new Color(0, 0, 0, 0); // Color transparente (alfa = 0)
        setBackground(transparente); // Establecer el fondo como transparente
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        int borderRadius = 20;
        int width = getWidth();
        int height = getHeight();

        Color color = Color.decode("#ffffff");

        g2d.setPaint(color);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillRoundRect(0, 0, width, height, borderRadius, borderRadius);

        g2d.dispose();
    }
}
