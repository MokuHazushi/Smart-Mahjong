/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.engine;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moku
 */
public class Hand {
    
    private final Tile hand[];
    private Tile drawnTile;
    private final List<Tile> openedTiles;
    
    public Hand() {
        this.hand = new Tile[13];
        this.openedTiles = new ArrayList<>();
        this.drawnTile = null;
    }

    public Hand(Tile[] hand, Tile drawnTile, List<Tile> openedTiles) {
        this.hand = hand;
        this.drawnTile = drawnTile;
        this.openedTiles = openedTiles;
    }

    public Tile getDrawnTile() {
        return drawnTile;
    }

    public void setDrawnTile(Tile drawnTile) {
        this.drawnTile = drawnTile;
    }

    public Tile[] getHand() {
        return hand;
    }

    public List<Tile> getOpenedTiles() {
        return openedTiles;
    }
    
}
