package main;

import java.awt.Graphics;

import entities.Player;
import map.MapManager;

public class Game implements Runnable {

	private GameWindow gameWindow;
	private GamePanel gamePanel;
	private Thread gameThread;
	private final int FPS_SET = 120;
	private final int UPS_SET = 200;
	private Player player;
	private MapManager mapManager;
	public final static int TILES_DEFAULT_SIZE = 32;
	public final static float SCALE = 1.875f;
	public final static int TILES_IN_WIDTH= 32;
	public final static int TILES_IN_HEIGHT= 18;
	public final static int TILES_SIZE= (int)(TILES_DEFAULT_SIZE*SCALE);
	public final static int GAME_WIDTH= TILES_SIZE*TILES_IN_WIDTH;
	public final static int GAME_HEIGHT = TILES_SIZE*TILES_IN_HEIGHT;
	
	public Game() {
		initClasses();
		gamePanel = new GamePanel(this);
		gameWindow = new GameWindow(gamePanel);
		gamePanel.requestFocus();

		startGameLoop();
	}

	private void initClasses() {
		player = new Player(GAME_WIDTH/2, GAME_HEIGHT/2, 80,80);
		mapManager = new MapManager(this);
	}

	private void startGameLoop() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	public void update() {
		player.update();
	}

	public void render(Graphics g) {
		mapManager.draw(g);
		player.render(g);
		
	}

	@Override
	public void run() {

		double timePerFrame = 1000000000.0 / FPS_SET; // in nanoseconds
		double timePerUpdate = 1000000000.0 / UPS_SET; // in nanoseconds

		long previousTime = System.nanoTime();

		int frames = 0;
		int updates = 0;
		long lastCheck = System.currentTimeMillis();

		double deltaU = 0;
		double deltaF = 0;

		while (true) {
			long currentTime = System.nanoTime();

			deltaU += (currentTime - previousTime) / timePerUpdate;
			deltaF += (currentTime - previousTime) / timePerFrame;
			previousTime = currentTime;

			if (deltaU >= 1) {
				update();
				updates++;
				deltaU--;
			}

			if (deltaF >= 1) {
				gamePanel.repaint();
				frames++;
				deltaF--;
			}

			if (System.currentTimeMillis() - lastCheck >= 1000) {
				lastCheck = System.currentTimeMillis();
				System.out.println("FPS: " + frames + " | UPS: " + updates);
				frames = 0;
				updates = 0;
			}
		}

	}

	public Player getPlayer() {
		return player;
	}

	public void windowFocusLost() {
		player.resetDirBooleans();

	}
}
