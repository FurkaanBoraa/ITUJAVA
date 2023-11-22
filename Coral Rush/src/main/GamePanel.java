package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

	//Screen Settings
	final int originalTileSize = 16; //16x16 tile
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 9;
	final int maxScreenRow = 18;
	final int screenWidth = tileSize*maxScreenCol;
	final int screenHeight = tileSize*maxScreenRow;
	
	//FPS
	int FPS = 60;
	
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	
	//Set Player's default position
	int playerX = 0;
	int playerY =0;
	int playerSpeed = 48;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.blue);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}

	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		//Game Loop
		double drawInterval = 1000000000/FPS;	// 0.01666 seconds
		double nextDrawTime = System.nanoTime() + drawInterval;
		while(gameThread != null) {
			//System.out.println("Game Loop is running");
			
			//1. Update information	such as positions
			update();
			//2. Draw the screen
			repaint();
			
			try {				
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				if (remainingTime < 0) {
					remainingTime = 0;
				}
				Thread.sleep((long) remainingTime);
				
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public void update() {
		
		if (keyH.forwardPressed) {
			playerY -= playerSpeed;
		}else if(keyH.backPressed) {
			playerY += playerSpeed;
		}else if(keyH.leftPressed) {
			playerX -= playerSpeed;
		}else if(keyH.rightPressed) {
			playerX += playerSpeed;
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	
		Graphics2D g2 = (Graphics2D)g;
		
		g2.setColor(Color.white);
		g2.fillRect(playerX, playerY, tileSize, tileSize);
		g2.dispose();
	
	}
	
	
}
