/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.components;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import smartmahjong.app.engine.Hand;
import smartmahjong.app.engine.Meld;
import smartmahjong.app.engine.Tile;
import smartmahjong.app.gui.utils.GUIConstants;
import smartmahjong.app.gui.utils.GUIFactory;

/**
 *
 * @author moku
 */
public class GHand extends JPanel {
    
    private final JPanel closedHandPan; // Include last drawn tile
    private final JPanel openedMeldsPan;
    
    public GHand() {
        super();
        
        // Graphic initialization
        JPanel mainPan = new JPanel();
        closedHandPan = new JPanel();
        openedMeldsPan = new JPanel();
        
        mainPan.setPreferredSize(new Dimension(
                20*GUIConstants.TILE_DIMENSION.width, 
                GUIConstants.TILE_DIMENSION.height));
        
        // Layout
        mainPan.setLayout(new GridLayout(1, 2, 10, 10));
        mainPan.add(closedHandPan);
        mainPan.add(openedMeldsPan);
        add(mainPan);
    }
    
    public void drawHand(Hand hand) {
        
        closedHandPan.removeAll();
        openedMeldsPan.removeAll();
        
        List<Tile> closedTiles = hand.getClosedTiles();
        List<Meld> openedMelds = hand.getOpenedMelds();
        
        // Layout
        closedHandPan.setLayout(new GridLayout(1, closedTiles.size()+2));
        openedMeldsPan.setLayout(new GridLayout(1, openedMelds.size()));
        
        // Drawing
        closedTiles.forEach((tile) -> {
            closedHandPan.add(new GTile(GUIFactory.getTileGraphic(tile)));
        });
        openedMelds.forEach((meld) -> {
            openedMeldsPan.add(new GMeld(meld));
        });
        
        validate();
    }
    
}
