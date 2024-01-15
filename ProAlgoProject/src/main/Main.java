package main;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import components.GamePanel;

public class Main extends JFrame {

	public Main() {
		init();
	}

	private void init() {
		setTitle("Programming Algorithm Project");
		setSize(1400, 800);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		GamePanel gamePanel = new GamePanel();
		add(gamePanel);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				gamePanel.start();
			}
		});
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.setVisible(true);

	}
}
