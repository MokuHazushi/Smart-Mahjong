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
    
    private final GTile hand[];
    private final GTile drawnTile;
    
    public GHand() {
        super();
        
        // Data initialization
        hand = new GTile[13];
        Arrays.setAll(hand, i -> new GTile(null));
        drawnTile = new GTile(null);
        
        // Graphic initialization
        setPreferredSize(new Dimension(
                15*GUIConstants.TILE_DIMENSION.width, 
                GUIConstants.TILE_DIMENSION.height));
        
        // Layout
        setLayout(new GridLayout(1, 15));
        for (int i=0; i<13; i++)
            add(hand[i]);
        add(new GTile(null));
        add(drawnTile);
    }
    
    public void drawHand(Hand hand) {
        for (int i=0; i<13; i++) {
            this.hand[i].setTileImage(
                    GUIFactory.getTileGraphic(hand.getHand()[i]));
        }
        drawnTile.setTileImage(GUIFactory.getTileGraphic(hand.getDrawnTile()));
    }
    
    
    
}
