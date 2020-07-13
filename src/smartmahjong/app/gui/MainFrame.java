/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import smartmahjong.app.gui.components.BackgroundFilledPan;
import smartmahjong.app.gui.listeners.ResizeWhenVisibleListener;

/**
 *
 * @author moku
 */
public class MainFrame extends JFrame {
    private static final String FRAME_TITLE = "Smart Mahjong";
    private static final Dimension FRAME_DIMENSION = new Dimension(500, 700);
    private final List<JPanel> MAIN_PANELS = new ArrayList<>();
    
    private final JPanel debugModePan, mahjongsoulHelperPan, menuPan;
    private final JButton backBt;
    
    public MainFrame() {
        super(FRAME_TITLE);
        setSize(FRAME_DIMENSION);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Sub-frames
        debugModePan = new DebugModePan();
        mahjongsoulHelperPan = new MahjongSoulHelperPan();
        menuPan = new MenuPan();
        
        // Buttons
        backBt = new JButton("Back");
        
        // Layout
        JPanel contentPane = new JPanel();
        JPanel centerPan = new BackgroundFilledPan();
        JPanel bottomPan = new BackgroundFilledPan();
        contentPane.setLayout(new BorderLayout());
        bottomPan.setLayout(new BorderLayout());
        
        centerPan.add(menuPan);
        centerPan.add(debugModePan);
        centerPan.add(mahjongsoulHelperPan);
        bottomPan.add(backBt, BorderLayout.LINE_START);
        contentPane.add(centerPan, BorderLayout.CENTER);
        contentPane.add(bottomPan, BorderLayout.PAGE_END);
        
        debugModePan.setVisible(false);
        mahjongsoulHelperPan.setVisible(false);
        backBt.setVisible(false);
        setContentPane(contentPane);
        
        // Listeners
        backBt.addActionListener((ActionEvent ae) -> {
            switchMainPanel(menuPan);
        });
        
        // Finalization
        MAIN_PANELS.add(menuPan);
        MAIN_PANELS.add(debugModePan);
        MAIN_PANELS.add(mahjongsoulHelperPan);
        
        setVisible(true);
    }
    
    public void switchMainPanel(JPanel pan) {
        MAIN_PANELS.forEach((f) -> {
            f.setVisible(false);
        });
        pan.setVisible(true);
        
        if (pan != menuPan)
            backBt.setVisible(true);
        else
            backBt.setVisible(false);
    }
    
    private class MenuPan extends JPanel {
        //private final MainFrame mainFrame;
        
        private final JButton debugModeBt, mahjongsoulHelperBt;

        public MenuPan() {
            
            // Buttons
            debugModeBt = new JButton("Debug mode");
            mahjongsoulHelperBt = new JButton("Mahjong Soul Helper");
            
            // Listeners
            debugModeBt.addActionListener(new ButtonListener(debugModePan));
            mahjongsoulHelperBt.addActionListener(new ButtonListener(mahjongsoulHelperPan));
            addComponentListener(new ResizeWhenVisibleListener(FRAME_DIMENSION, this));
            
            // Layout
            setLayout(new GridLayout(2, 1));
            add(debugModeBt);
            add(mahjongsoulHelperBt);
        }
        
        private class ButtonListener implements ActionListener {
            private final JPanel toDisplayPanel;

            public ButtonListener(JPanel toDisplayPanel) {
                this.toDisplayPanel = toDisplayPanel;
            }
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchMainPanel(toDisplayPanel);
            }
        }
    }
    
    public static void main(String args[]) {
        new MainFrame(); 
    }
    
}
