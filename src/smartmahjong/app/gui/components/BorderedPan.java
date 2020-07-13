/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui.components;

import javax.swing.BorderFactory;
import smartmahjong.app.gui.utils.GUIConstants;

/**
 *
 * @author moku
 */
public class BorderedPan extends BackgroundFilledPan {

    public BorderedPan() {
        super();
        setBorder(BorderFactory.createLineBorder(GUIConstants.GREEN_MINT_COLOR, 3));
    }
    
    
    
}
