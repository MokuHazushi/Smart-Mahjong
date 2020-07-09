/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui;

import java.awt.Dimension;
import javax.swing.JPanel;
import smartmahjong.app.gui.listeners.ResizeWhenVisibleListener;

/**
 *
 * @author moku
 */
public class DebugModePan extends JPanel {
    private static final Dimension PANEL_DIMENSION = new Dimension(900, 500);
    
    public DebugModePan() {
        super();
        addComponentListener(new ResizeWhenVisibleListener(PANEL_DIMENSION, this));
    }
    
}
