/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.components;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.Box;
import javax.swing.BoxLayout;
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
    
    private final Dimension TILE_DIMENSION = GUIConstants.TILE_DIMENSION;
    
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
                17*TILE_DIMENSION.width+4*TILE_DIMENSION.width,
                (int)(1.25*TILE_DIMENSION.height)));
        mainPan.setPreferredSize(getPreferredSize());
        
        // Layout
        add(mainPan);
    }
    
    public void drawHand(Hand hand) { 
        closedHandPan.removeAll();
        openedMeldsPan.removeAll();
        mainPan.removeAll();
        
        List<Tile> closedTiles = hand.getClosedTiles();
        List<Meld> openedMelds = hand.getOpenedMelds();
        
        // Sizing
        /*
        closedHandPan.setPreferredSize(new Dimension(
                closedTiles.size()*TILE_DIMENSION.width,
                TILE_DIMENSION.height
        ));
        openedMeldsPan.setPreferredSize(new Dimension(
                getPreferredSize().width-closedHandPan.getPreferredSize().width,
                TILE_DIMENSION.height
        ));
*/
        
        // Layout
        closedHandPan.setLayout(new FlowLayout());
        openedMeldsPan.setLayout(new FlowLayout());
        
        // Drawing
        closedTiles.forEach((tile) -> {
            closedHandPan.add(GUIFactory.createGTile(tile, TILE_DIMENSION));
        });
        closedHandPan.add(Box.createRigidArea(new Dimension(
                (int)(TILE_DIMENSION.width*0.5), 
                TILE_DIMENSION.height)));
        closedHandPan.add(GUIFactory.createGTile(hand.getDrawnTile(), TILE_DIMENSION));
        
        openedMelds.forEach((meld) -> {
            openedMeldsPan.add(new GMeld(meld, TILE_DIMENSION));
        });
        
        mainPan.setLayout(new FlowLayout(FlowLayout.CENTER, TILE_DIMENSION.width, 0));
        mainPan.add(closedHandPan);
        mainPan.add(openedMeldsPan);
        
        validate();
    }
    
}
