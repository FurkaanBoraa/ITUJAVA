package gameStates;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import entities.EnemyManager;
import entities.Player;
import main.Game;
import map.MapManager;

public class Playing extends State implements StateMethods{
	private Player player;
	private MapManager mapManager;
	private EnemyManager enemyManager;
	private boolean paused = false;
	public Playing(Game game) {
		super(game);
		initClasses();
		
	}


	
	private void initClasses() {
		player = new Player(Game.GAME_WIDTH/2, Game.GAME_HEIGHT/2, 80,80);
		mapManager = new MapManager(game);
		enemyManager = new EnemyManager(this);
	}
	
	@Override
	public void update() {
		if (!paused) {
			player.update();
			enemyManager.update();
		}
	}
	@Override
	public void draw(Graphics g) {
		mapManager.draw(g);
		player.render(g);
		enemyManager.draw(g);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.setUp(true);
			break;
		case KeyEvent.VK_A:
			player.setLeft(true);
			break;
		case KeyEvent.VK_S:
			player.setDown(true);
			break;
		case KeyEvent.VK_D:
			player.setRight(true);
			break;
		case KeyEvent.VK_SPACE:
			player.setAttacking(true);
			break;
		case KeyEvent.VK_ESCAPE:
			GameStates.state = GameStates.MENU;
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			player.setUp(false);
			break;
		case KeyEvent.VK_A:
			player.setLeft(false);
			break;
		case KeyEvent.VK_S:
			player.setDown(false);
			break;
		case KeyEvent.VK_D:
			player.setRight(false);
			break;
		case KeyEvent.VK_SPACE:
			player.setAttacking(false);
			break;
		}
	}
	
	public Player getPlayer() {
		return player;
	}

	public void windowFocusLost() {
		player.resetDirBooleans();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
