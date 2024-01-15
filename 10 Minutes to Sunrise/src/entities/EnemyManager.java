package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.security.SecureRandom;
import java.util.ArrayList;

import gameStates.Playing;
import main.Game;
import utils.LoadSave;
import static utils.Constants.EnemyConstants.*;

public class EnemyManager {
	private Playing playing;

	private BufferedImage brain;
	private ArrayList<BrainMonster> brains = new ArrayList<>();

	public EnemyManager(Playing playing) {
		this.playing = playing;
		brain = LoadSave.GetSpriteAtlas(LoadSave.ENEMY_BRAIN);
		addEnemies();
	}

	private void addEnemies() {
		SecureRandom random = new SecureRandom();
		float x = random.nextFloat(Game.GAME_WIDTH);
		float y = random.nextFloat(Game.GAME_HEIGHT);
		brains.add(new BrainMonster(x,y));
	}

	public void update() {
		if (brains.size()<100) {
			addEnemies();
			
		}
		
		for (BrainMonster brainy : brains) {
			brainy.update();
		}
	}

	public void draw(Graphics g) {
		drawBrains(g);
	}

	public void drawBrains(Graphics g) {
		for (BrainMonster brainy : brains) {
			g.drawImage(brain, (int) brainy.getHitbox().x, (int) brainy.getHitbox().y, null);
		}
		System.out.println("trying");
	}

}
