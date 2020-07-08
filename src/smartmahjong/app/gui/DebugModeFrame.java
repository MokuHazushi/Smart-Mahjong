/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author moku
 */
public class DebugModeFrame extends JFrame {
    private static final String FRAME_TITLE = "Smart Mahjong - Debug mode";
    private static final Dimension FRAME_DIMENSION = new Dimension(900, 500);
    
    public DebugModeFrame() {
        super(FRAME_TITLE);
        setSize(FRAME_DIMENSION);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
}
