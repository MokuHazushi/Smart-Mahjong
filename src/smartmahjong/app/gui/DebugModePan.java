/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui;

import java.awt.Dimension;
import javax.swing.JPanel;
import smartmahjong.app.engine.utils.DebugHelper;
import smartmahjong.app.gui.components.GHand;
import smartmahjong.app.gui.listeners.ResizeWhenVisibleListener;

/**
 *
 * @author moku
 */
public class DebugModePan extends JPanel {
    private static final Dimension PANEL_DIMENSION = new Dimension(1400, 300);
    
    private final GHand ghand;
    
    public DebugModePan() {
        super();
        
        // Data initialization 
        ghand = new GHand();
        ghand.drawHand(DebugHelper.createPinfuHand());
        
        // Graphic initialization
        
        // Layout
        add(ghand);
        
        // Listeners
        addComponentListener(new ResizeWhenVisibleListener(PANEL_DIMENSION, this));
    }
    
}
