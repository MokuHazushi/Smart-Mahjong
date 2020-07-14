/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import smartmahjong.app.gui.utils.GUITools;

/**
 *
 * @author moku
 */
public class GTile extends BackgroundFilledPan {
    
    private BufferedImage tileImage;
    private boolean hovered;
    private boolean called;
    
    private Dimension prefDim;

    private GTile(BufferedImage tileImage) {
        this.tileImage = tileImage;
        this.hovered = false;
        this.called = false;
        
        // Listeners
        addMouseListener(new GTileHoverListener(this));
    }
    
    public GTile(BufferedImage tileImage, Dimension prefDim) {
        this(tileImage);
        
        this.prefDim = prefDim;
        setPreferredSize(prefDim);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
              
        if (tileImage == null)
            return;
        
        int width = called ? prefDim.height : prefDim.width;
        int height = called ? prefDim.width : prefDim.height;
        int originX = 0;
        int originY = called ? prefDim.height - prefDim.width : 0;
        

        g.drawImage(tileImage, originX, originY, width, height, null);
        
        if (hovered) {
            g.setColor(new Color(50, 50, 50, 50));
            g.fillRect(originX, originY, width, height);
        }
    }

    public void setTileImage(BufferedImage tileImage) {
        this.tileImage = tileImage;
        repaint();
    }
    
    public void setCalled() {
        if (this.tileImage == null)
            return;
        
        this.called = true;
        setPreferredSize(new Dimension(
                prefDim.height, 
                prefDim.height));
        setTileImage(GUITools.rotateImage(tileImage, -90));
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
