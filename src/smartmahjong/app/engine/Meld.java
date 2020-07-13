/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.engine;

import java.util.List;

/**
 *
 * @author moku
 */
public class Meld {
    
    private final List<Tile> meld;
    private boolean opened;
    private int calledTileIndex; // Between 0 and 2 for CHI, 0 for PON and KAN

    public Meld(List<Tile> meld, boolean openned, int calledTileIndex) {
        this.meld = meld;
        this.opened = openned;
        this.calledTileIndex = calledTileIndex;
    }

    public boolean isOpened() {
        return opened;
    }

    public int getCalledTileIndex() {
        return calledTileIndex;
    }

    public List<Tile> getMeld() {
        return meld;
    }

    public void setOpenned(boolean openned, int calledTileIndex) {
        this.opened = openned;
        this.calledTileIndex = calledTileIndex;
    }
    
    public void addTile(Tile tile) {
        meld.add(tile);
    }
    
    public Type getType() {
        if (meld.size() == 4)
            return Type.KAN;
        
        if (meld.get(0).compareTo(meld.get(1)) != 0)
            return Type.CHI;
        
        return Type.PON;
    }
    
    public enum Type {
        CHI,
        PON,
        KAN     
    }
    
}
