/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.components;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Arrays;
import javax.swing.JPanel;
import smartmahjong.app.engine.Hand;
import smartmahjong.app.gui.utils.GUIConstants;
import smartmahjong.app.gui.utils.GUIFactory;

/**
 *
 * @author moku
 */
public class GHand extends JPanel {
    
    private final GTile[] gHand;
    private final GTile drawnTile;
    
    // Data
    private Hand hand;
    
    public GHand() {
        super();
        
        // Data initialization
        gHand = new GTile[13];
        Arrays.setAll(gHand, i -> new GTile(null));
        drawnTile = new GTile(null);
        
        // Graphic initialization
        setPreferredSize(new Dimension(
                15*GUIConstants.TILE_DIMENSION.width, 
                GUIConstants.TILE_DIMENSION.height));
        
        // Layout
        setLayout(new GridLayout(1, 15));
        for (int i=0; i<13; i++)
            add(gHand[i]);
        add(new GTile(null));
        add(drawnTile);
    }
    
    public void setAndDrawHand(Hand hand) {
        this.hand = hand;
        drawHand();
    }
    
    public void redrawHand() {
        if (hand == null)
            return;
        drawHand();
    }
    
    private void drawHand() {
        if (this.hand == null)
            return;
        for (int i=0; i<13; i++) {
            this.gHand[i].setTileImage(
                    GUIFactory.getTileGraphic(hand.getHand()[i]));
        }
        drawnTile.setTileImage(GUIFactory.getTileGraphic(hand.getDrawnTile()));
    }

    public Hand getHand() {
        return hand;
    }
    
}
