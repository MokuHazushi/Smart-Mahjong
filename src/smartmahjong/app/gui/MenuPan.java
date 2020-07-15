/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import smartmahjong.app.gui.components.IconedButton;
import smartmahjong.app.gui.listeners.SwitchPanelListener;
import smartmahjong.app.gui.utils.GUIConstants;

/**
 *
 * @author moku
 */
public class MenuPan extends JPanel {
    
    private final SwitchPanelListener switchPanelListener;
    
    private final JButton debugModeBt, mahjongsoulHelperBt;

    public MenuPan(SwitchPanelListener switchPanelListener) {
        
        // Data initialization
        this.switchPanelListener = switchPanelListener;
        
        // Graphic initialization
        setBackground(GUIConstants.BRIGHT_YELLOW_COLOR);
        debugModeBt = new MenuButton("Sand-box mode", IconedButton.Type.IDEA);
        mahjongsoulHelperBt = new MenuButton("Mahjong-soul helper", IconedButton.Type.AI);
        
        // Layout
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(debugModeBt);
        add(mahjongsoulHelperBt);
        
        // Listeners
        debugModeBt.addActionListener((ActionEvent ae) -> {
            switchPanelListener.switchPanel(MainFrame.debugModePan);
        });
        mahjongsoulHelperBt.addActionListener((ActionEvent ae) -> {
            switchPanelListener.switchPanel(MainFrame.mahjongsoulHelperPan);
        });
    }
    
    private class MenuButton extends IconedButton {
        
        public MenuButton(String title, IconedButton.Type type) {
            super(title, type);
            
            // Graphics initialization
            setBackground(new Color(255, 255, 255, 0));
            setFocusPainted(false);
            setRolloverEnabled(false);
            
            // Listeners
            addMouseListener(new MouseListener(){
                @Override
                public void mouseClicked(MouseEvent me) {}

                @Override
                public void mousePressed(MouseEvent me) {}

                @Override
                public void mouseReleased(MouseEvent me) {}

                @Override
                public void mouseEntered(MouseEvent me) {
                    setOpaque(true);
                    new Thread(){
                        @Override
                        public void run() {
                            int animation_duration = 200; // in ms
                            int animation_rate = 10; // in ms
                            int progression = 0;
                            int transparency = 0;
                            int transparency_step = 255/((500/10));
                            
                            while (progression < animation_duration) {
                                setBackground(new Color(255, 255, 255, transparency));
                                progression += animation_rate;
                                transparency += transparency_step;
                                repaint();
                                
                                try {
                                    Thread.sleep(animation_rate);
                                }
                                catch (Exception e) {}
                            }
                            
                        }
                    }.start();
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent me) {
                    setOpaque(false);
                    repaint();
                }
            });
        }
    }
    
    
    
    
}
