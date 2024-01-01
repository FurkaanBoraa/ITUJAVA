package main;

import java.awt.Toolkit;

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
	}
}
