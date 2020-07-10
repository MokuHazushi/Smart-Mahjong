/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
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
    private final JButton generateHandBt, sortHandBt;
    
    public DebugModePan() {
        super();
        
        // Data initialization 
        ghand = new GHand();
        ghand.setAndDrawHand(DebugHelper.createPinfuHand());
        
        // Buttons
        generateHandBt = new JButton("Generate random hand");
        sortHandBt = new JButton("Sort hand");
        
        // Layout
        setLayout(new BorderLayout());
        JPanel topPan = new JPanel();
        
        topPan.add(generateHandBt);
        topPan.add(sortHandBt);
        add(topPan, BorderLayout.PAGE_START);
        add(ghand, BorderLayout.CENTER);
        
        // Listeners
        addComponentListener(new ResizeWhenVisibleListener(PANEL_DIMENSION, this));
        generateHandBt.addActionListener((ActionEvent ae) -> {
            ghand.setAndDrawHand(DebugHelper.createRandomHand());
        });
        sortHandBt.addActionListener((ActionEvent ae) -> {
            ghand.getHand().sort();
            ghand.redrawHand();
        });
    }
    
}
