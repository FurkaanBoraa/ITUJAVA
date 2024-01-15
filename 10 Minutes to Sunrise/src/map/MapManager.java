package map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import static main.Game.*;
import utils.LoadSave;

public class MapManager {
	private Game game;
	private BufferedImage mapSprite;

	public MapManager(Game game) {
		this.game = game;
		mapSprite = LoadSave.GetSpriteAtlas(LoadSave.MAP_ATLAS);
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < TILES_IN_WIDTH ; i++) {
			for (int j = 0; j < TILES_IN_HEIGHT; j++) {
				g.drawImage(mapSprite, i*TILES_SIZE,j*TILES_SIZE,TILES_SIZE, TILES_SIZE, null);
			}
		}
		
	}
	public void update() {
		
	}
}
