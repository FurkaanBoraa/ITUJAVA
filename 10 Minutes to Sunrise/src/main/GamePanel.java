package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private int xDelta = 100, yDelta = 100;
	private int xDir = 10, yDir = 10;

	private Color color = Color.red;
	private Random random;
	
	public GamePanel() {
		random = new Random();
		mouseInputs = new MouseInputs(this);
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}

	public void changeXDelta(int value) {
		this.xDelta += value;
		
	}

	public void changeyYDelta(int value) {
		this.yDelta += value;
		
	}

	public void setRectPos(int x, int y) {
		this.xDelta = x;
		this.yDelta = y;
	
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		updateRectangle();
		
		g.setColor(color);
		g.fillRect(xDelta, yDelta, 200, 50);
		
		
		
	}

	private void updateRectangle() {
		xDelta+=xDir;
		yDelta+=yDir;
		if (xDelta + 200 > Toolkit.getDefaultToolkit().getScreenSize().width || xDelta <0) {
			xDir *= -1;
			color = getRandomColor();
		}
		if (yDelta +50 > Toolkit.getDefaultToolkit().getScreenSize().height || yDelta <0) {
			yDir *= -1;
			color = getRandomColor();
		}
		
	}

	private Color getRandomColor() {
		int R = random.nextInt(255);
		int G = random.nextInt(255);
		int B = random.nextInt(255);
		return new Color(R,G,B);
	}
}
