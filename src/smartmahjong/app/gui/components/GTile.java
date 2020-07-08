/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author moku
 */
public class GTile extends JPanel {
    
    private final Image tileImage;
    private boolean hovered;

    public GTile(Image tileImage) {
        this.tileImage = tileImage;
        this.hovered = false;
        
        // Listeners
        addMouseListener(new GTileHoverListener(this));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(tileImage, 0, 0, getWidth(), getHeight(), null);
        
        if (hovered) {
            g.setColor(new Color(50, 50, 50, 50));
            g.drawRect(0, 0, getWidth(), getHeight());
        }
    }
    
    private class GTileHoverListener implements MouseListener {
        
        private final GTile gtile;

        public GTileHoverListener(GTile gtile) {
            this.gtile = gtile;
        }

        @Override
        public void mouseClicked(MouseEvent me) {}

        @Override
        public void mousePressed(MouseEvent me) {}

        @Override
        public void mouseReleased(MouseEvent me) {}

        @Override
        public void mouseEntered(MouseEvent me) {
            gtile.hovered = true;
            gtile.repaint();
        }

        @Override
        public void mouseExited(MouseEvent me) {
            gtile.hovered = false;
            gtile.repaint();
        }
    }
    
    
}
