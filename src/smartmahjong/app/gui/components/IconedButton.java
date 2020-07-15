/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.components;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import smartmahjong.app.gui.utils.GUIFactory;

/**
 *
 * @author moku
 */
public class IconedButton extends JButton {
    
    private static final Dimension BUTTON_DIMENSION = new Dimension(200, 40);
    private static final Dimension ICON_DIMENSION = new Dimension(30, 30);
    
    public IconedButton(String title, Type type) {
        
        // Graphics initialization
        JLabel iconLabel = new JLabel(loadIcon(type));
        JLabel actionLabel = new JLabel(title, SwingConstants.CENTER);
        iconLabel.setPreferredSize(ICON_DIMENSION);
        setPreferredSize(BUTTON_DIMENSION);
        
        // Layout
        setLayout(new BorderLayout());
        add(iconLabel, BorderLayout.LINE_START);
        add(actionLabel, BorderLayout.CENTER);
        
    }
    
    private static ImageIcon loadIcon(Type type) {
        String fileName = "";
        Image img;
        
        switch (type) {
            case IDEA:
                fileName = "idea_icon.png";
                break;
            case AI:
                fileName = "ai_icon.png";
                break;
            default:
                return null;
        }
        
        img = GUIFactory.loadImage(fileName)
                .getScaledInstance(ICON_DIMENSION.width, ICON_DIMENSION.height, Image.SCALE_SMOOTH);
        return new ImageIcon(img);
    }
    
    public enum Type {
        IDEA,
        AI
    }
    
}
