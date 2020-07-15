/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPanel;
import smartmahjong.app.engine.Hand;
import smartmahjong.app.engine.utils.DebugHelper;
import smartmahjong.app.gui.components.BackgroundFilledPan;
import smartmahjong.app.gui.components.GHand;

/**
 *
 * @author moku
 */
public class SandboxModePan extends JPanel {
    
    private final GHand ghand;
    private final JButton generateHandBt, sortHandBt;
    
    // Data
    private Hand hand;
    
    public SandboxModePan() {
        super();
        
        // Data initialization 
        ghand = new GHand();
        hand = DebugHelper.createOpenedHand();
        ghand.drawHand(hand);
        
        // Buttons
        generateHandBt = new JButton("Generate random hand");
        sortHandBt = new JButton("Sort hand");
        
        // Layout
        setLayout(new BorderLayout());
        JPanel topPan = new BackgroundFilledPan();
        
        topPan.add(generateHandBt);
        topPan.add(sortHandBt);
        add(topPan, BorderLayout.PAGE_START);
        add(ghand, BorderLayout.CENTER);
        
        // Listeners
        generateHandBt.addActionListener((ActionEvent ae) -> {
            hand = DebugHelper.createRandomHand();
            ghand.drawHand(hand);
        });
        sortHandBt.addActionListener((ActionEvent ae) -> {
            hand.sort();
            ghand.drawHand(hand);
        });
    }
    
}
