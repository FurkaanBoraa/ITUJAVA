package main;

import javax.swing.JFrame;

public class GameWindow {
	private JFrame jframe;
	public GameWindow(GamePanel gamePanel) {
		
		jframe = new JFrame();
		jframe.setSize(600,900);
		
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.add(gamePanel);
		jframe.setLocationRelativeTo(null);		// Starts game in center of screen
		
		
		jframe.setVisible(true); 	// Should be on bottom to draw when everything is ready
	}
}
