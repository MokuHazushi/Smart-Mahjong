/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.components;

import javax.swing.JPanel;
import smartmahjong.app.engine.Meld;

/**
 *
 * @author moku
 */
public class GMeld extends JPanel {
    
    // Data
    private final Meld meld;
    
    public GMeld(Meld meld) {
        super();
        
        // Data initialization
        this.meld = meld;
        
        // Layout
        
    }
    
}
