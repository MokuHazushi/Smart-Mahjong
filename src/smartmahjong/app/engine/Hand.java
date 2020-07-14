/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author moku
 */
public class Hand {
    
    private final Tile hand[];
    private Tile drawnTile;
    private final List<Meld> openedMelds;
    
    public Hand() {
        this.hand = new Tile[13];
        this.openedMelds = new ArrayList<>();
        this.drawnTile = null;
    }

    public Hand(Tile[] hand, Tile drawnTile, List<Meld> openedMelds) {
        this.hand = hand;
        this.drawnTile = drawnTile;
        this.openedMelds = openedMelds;
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

    public List<Meld> getOpenedMelds() {
        return openedMelds;
    }
    
    public int numberOfClosedTile() {
        int res = hand.length;
        for (Meld m : openedMelds)
            res -= m.getMeld().size();
        
        return res;
    }
    
    public List<Tile> getClosedTiles() {
        List<Tile> res = new ArrayList(Arrays.asList(hand));
        
        openedMelds.forEach(meld -> {
           for (Tile tile : meld.getMeld()) {
               int toRemoveIndex = -1;
               for (int i=0; i<res.size(); i++) {
                   if (res.get(i).compareTo(tile) == 0) {
                       toRemoveIndex = i;
                       break;
                   }
               }
               res.remove(toRemoveIndex);
           }
        });
        return res;
    }
    
    // Engine functions
    public void sort() {
        /* Sorting rules:
        - Type: Characters -> Circles -> Bamboos -> Honors
        - For non-honor type, increasing order
        - For honors type East -> North -> West -> South -> Red dr. -> White dr. -> Green dr.
        */
        Arrays.sort(hand, (Tile t1, Tile t2) -> {
            return t1.compareTo(t2);
        });
    }
    
}
