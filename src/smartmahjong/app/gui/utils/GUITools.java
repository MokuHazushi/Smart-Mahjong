/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.utils;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author moku
 */
public class GUITools {
    
    public static BufferedImage rotateImage(BufferedImage img, int deg) {
        double rads = Math.toRadians(deg);
        double sin = Math.abs(Math.sin(rads));
        double cos = Math.abs(Math.cos(rads));
        
        int newWidth = (int)Math.floor(img.getWidth()*cos + img.getHeight()*sin);
        int newHeight = (int)Math.floor(img.getHeight()*cos + img.getWidth()*sin);
        
        BufferedImage rotatedImg = new BufferedImage(
                newWidth, 
                newHeight, 
                img.getType());
        Graphics2D g2d = rotatedImg.createGraphics();
        AffineTransform at = new AffineTransform();
        at.translate((newWidth - img.getWidth())/2, (newHeight - img.getHeight())/2);
        
        int x = img.getWidth()/2;
        int y = img.getHeight()/2;
        
        at.rotate(rads, x, y);
        g2d.setTransform(at);
        g2d.drawImage(img, 0, 0, null);
        g2d.dispose();
        return rotatedImg;
    }
    
}
