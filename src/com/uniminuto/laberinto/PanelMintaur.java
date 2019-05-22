/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uniminuto.laberinto;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author joncasasq
 */
public class PanelMintaur extends JPanel {

    @Override
    public void paint(Graphics graphic) {
        Dimension dimension = getSize();
        ImageIcon img = new ImageIcon(getClass().getResource("minotauro.jpeg"));
        graphic.drawImage(img.getImage(), 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
        super.paintComponent(graphic);
    }

}
