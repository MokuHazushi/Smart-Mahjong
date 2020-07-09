/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.listeners;

import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;

/**
 *
 * @author moku
 */
public class ResizeWhenVisibleListener implements ComponentListener {
    
    private final Dimension newDimensions;
    private final JComponent component;

    public ResizeWhenVisibleListener(Dimension newDimensions, JComponent component) {
        this.newDimensions = newDimensions;
        this.component = component;
    }

    @Override
    public void componentResized(ComponentEvent ce) {}

    @Override
    public void componentMoved(ComponentEvent ce) {}

    @Override
    public void componentShown(ComponentEvent ce) {
        SwingUtilities.getRoot(component).setSize(newDimensions);
    }

    @Override
    public void componentHidden(ComponentEvent ce) {}
    
}
