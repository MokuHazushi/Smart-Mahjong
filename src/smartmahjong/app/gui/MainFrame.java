/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import smartmahjong.app.gui.components.BackgroundFilledPan;
import smartmahjong.app.gui.listeners.SwitchPanelListener;
import smartmahjong.app.gui.utils.GUIConstants;

/**
 *
 * @author moku
 */
public class MainFrame extends JFrame implements SwitchPanelListener {
    private static final String FRAME_TITLE = "Smart Mahjong";
    private final List<JPanel> MAIN_PANELS = new ArrayList<>();
    
    
    public static JPanel debugModePan, mahjongsoulHelperPan;
    private final JPanel menuPan, centerPan;
    
    public MainFrame() {
        super(FRAME_TITLE);
        setSize(GUIConstants.APP_DIMENSION);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Sub-frames
        debugModePan = new SandboxModePan();
        mahjongsoulHelperPan = new MahjongSoulHelperPan();
        menuPan = new MenuPan(this);
        centerPan = new BackgroundFilledPan();
        
        // Layout
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        
        centerPan.add(debugModePan);
        centerPan.add(mahjongsoulHelperPan);
        contentPane.add(menuPan, BorderLayout.PAGE_START);
        contentPane.add(centerPan, BorderLayout.CENTER);
        
        debugModePan.setVisible(false);
        mahjongsoulHelperPan.setVisible(false);
        setContentPane(contentPane);
        
        
        // Finalization
        MAIN_PANELS.add(debugModePan);
        MAIN_PANELS.add(mahjongsoulHelperPan);
        
        setVisible(true);
    }

    @Override
    public void switchPanel(JPanel pan) {
        MAIN_PANELS.forEach((f) -> {
            f.setVisible(false);
        });
        pan.setVisible(true);
    }
    
    public static void main(String args[]) {
        new MainFrame(); 
    }
    
}
