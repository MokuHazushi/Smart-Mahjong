/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
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
public class GHand extends BorderedPan {
    
    private final JPanel mainPan;
    private final JPanel closedHandPan; // Include last drawn tile
    private final JPanel openedMeldsPan;
    
    
    public GHand() {
        super();
        
        // Graphic initialization
        mainPan = new BackgroundFilledPan();
        closedHandPan = new BackgroundFilledPan();
        openedMeldsPan = new BackgroundFilledPan();
        
        setPreferredSize(new Dimension(
                (int)(0.75*15*GUIConstants.TILE_DIMENSION.width), 
                (int)(0.75*GUIConstants.TILE_DIMENSION.height)));
        
        // Layout
        setLayout(new GridLayout(1, 1, 5, 5));
        
        add(mainPan);
    }
    
    public void drawHand(Hand hand) { 
        closedHandPan.removeAll();
        openedMeldsPan.removeAll();
        mainPan.removeAll();
        
        List<Tile> closedTiles = hand.getClosedTiles();
        List<Meld> openedMelds = hand.getOpenedMelds();
        
        // Layout
        closedHandPan.setLayout(new GridLayout(1, closedTiles.size()+2, 2, 1));
        openedMeldsPan.setLayout(new GridLayout(1, openedMelds.size()));
        
        // Drawing
        closedTiles.forEach((tile) -> {
            closedHandPan.add(new GTile(GUIFactory.getTileGraphic(tile)));
        });
        closedHandPan.add(new GTile(null));
        closedHandPan.add(new GTile(GUIFactory.getTileGraphic(hand.getDrawnTile())));
        openedMelds.forEach((meld) -> {
            openedMeldsPan.add(new GMeld(meld));
        });
        
        if (openedMelds.isEmpty()) {
            mainPan.setLayout(new GridLayout(1, 1, 10, 10));
            mainPan.add(closedHandPan);
        }
        else {
            mainPan.setLayout(new GridLayout(1, 2, 10, 10));
            mainPan.add(closedHandPan);
            mainPan.add(openedMeldsPan);
        }
        
        validate();
    }
    
}
