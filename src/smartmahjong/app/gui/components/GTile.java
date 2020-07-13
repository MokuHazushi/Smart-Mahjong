/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;

/**
 *
 * @author moku
 */
public class GTile extends JPanel {
    
    private Image tileImage;
    private boolean hovered;
    private boolean called;

    public GTile(Image tileImage) {
        this.tileImage = tileImage;
        this.hovered = false;
        this.called = false;
        
        // Listeners
        addMouseListener(new GTileHoverListener(this));
    }

    public void setCalled(boolean called) {
        this.called = called;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (tileImage == null)
            return;
        
        if (called) {
            Graphics2D imGraphics = (Graphics2D)tileImage.getGraphics();
            imGraphics.rotate(Math.toRadians(90), getWidth()/2, getHeight()/2);
            imGraphics.dispose();
        }
        g.drawImage(tileImage, 0, 0, getWidth(), getHeight(), null);
        
        if (hovered) {
            g.setColor(new Color(50, 50, 50, 50));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    public void setTileImage(Image tileImage) {
        this.tileImage = tileImage;
        repaint();
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
