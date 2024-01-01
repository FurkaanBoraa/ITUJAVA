package main;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JFrame;

public class GameWindow {
	private JFrame jframe;

	public GameWindow(GamePanel gamePanel) {

		jframe = new JFrame();
		// jframe.setSize(Toolkit.getDefaultToolkit().getScreenSize());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel);
		jframe.setLocationRelativeTo(null); // Starts game in center of screen
		
		jframe.setResizable(false);
		jframe.pack();
		jframe.setExtendedState(JFrame.MAXIMIZED_BOTH); // FullScreen
		
		jframe.setVisible(true); // Should be on bottom to draw when everything is ready
		jframe.addWindowFocusListener(new WindowFocusListener() {
			
			@Override
			public void windowLostFocus(WindowEvent e) {
				gamePanel.getGame().windowFocusLost();
				
			}
			
			@Override
			public void windowGainedFocus(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	
	}
}
