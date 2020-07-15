/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.components;

import java.awt.Dimension;
import java.awt.FlowLayout;
import smartmahjong.app.engine.Meld;
import smartmahjong.app.gui.utils.GUIFactory;

/**
 *
 * @author moku
 */
public class GMeld extends BackgroundFilledPan {
    
    // Data
    private final Meld meld;
    
    public GMeld(Meld meld, Dimension tileDim) {
        super();
        
        // Data initialization
        this.meld = meld;
           
        // Layout
        setLayout(new FlowLayout());
        for (int i=0; i<meld.getMeld().size(); i++) {
            GTile gtile = GUIFactory.createGTile(meld.getMeld().get(i), tileDim);
            if (i == meld.getCalledTileIndex())
                gtile.setCalled();
            
            add(gtile);
        }
    }
    
}
