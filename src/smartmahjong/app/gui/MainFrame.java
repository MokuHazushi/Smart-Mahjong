/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartmahjong.app.gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author moku
 */
public class MainFrame extends JFrame {
    private static final String FRAME_TITLE = "Smart Mahjong";
    private static final Dimension FRAME_DIMENSION = new Dimension(500, 700);
    private final List<JFrame> ALL_FRAMES = new ArrayList<>();
    
    private final JFrame debugModeFrame, mahjongsoulHelperFrame;
    
    public MainFrame() {
        super(FRAME_TITLE);
        setSize(FRAME_DIMENSION);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Sub-frames
        debugModeFrame = new DebugModeFrame();
        mahjongsoulHelperFrame = new MahjongSoulHelperFrame();
        
        // Layout
        setContentPane(new ButtonPan());
        
        // Finalization
        ALL_FRAMES.add(this);
        ALL_FRAMES.add(debugModeFrame);
        ALL_FRAMES.add(mahjongsoulHelperFrame);
        
        setVisible(true);
    }
    
    public void switchVisibleFrame(JFrame frame) {
        ALL_FRAMES.forEach((f) -> {
            f.setVisible(false);
        });
        frame.setVisible(true);
    }
    
    private class ButtonPan extends JPanel {
        //private final MainFrame mainFrame;
        
        private final JButton debugModeBt, mahjongsoulHelperBt;

        public ButtonPan() {
            
            // Buttons
            debugModeBt = new JButton("Debug mode");
            mahjongsoulHelperBt = new JButton("Mahjong Soul Helper");
            
            // Listeners
            debugModeBt.addActionListener(new ButtonListener(debugModeFrame));
            mahjongsoulHelperBt.addActionListener(new ButtonListener(mahjongsoulHelperFrame));
            
            // Layout
            setLayout(new GridLayout(2, 1));
            add(debugModeBt);
            add(mahjongsoulHelperBt);
        }
        
        private class ButtonListener implements ActionListener {
            private final JFrame toDisplayFrame;

            public ButtonListener(JFrame toDisplayFrame) {
                this.toDisplayFrame = toDisplayFrame;
            }
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                switchVisibleFrame(toDisplayFrame);
            }
        }
    }
    
    public static void main(String args[]) {
        new MainFrame(); 
    }
    
}
