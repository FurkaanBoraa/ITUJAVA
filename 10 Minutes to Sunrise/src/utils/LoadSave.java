package utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class LoadSave {
	public static final String PLAYER_ATLAS = "T_Lilith.png";
	public static final String SHADOW = "T_CharacterShadow.png";
	public static final String GUN= "T_Revolver_SS.png";
	public static final String MAP_ATLAS = "T_TileGrass.png";
	public static final String HALO = "T_ShanaHalo.png";
	public static final String MENU_BUTTONS = "button_atlas.png";
	public static final String MENU_BACKGROUND = "menu_background.png";
	public static final String ENEMY_BRAIN = "brainMonster.png";
	
	
	public static BufferedImage GetSpriteAtlas(String fileName) {
		BufferedImage img = null;
		InputStream character = LoadSave.class.getResourceAsStream("/" + fileName );
		try {
			img = ImageIO.read(character);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				character.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return img;
	}

}
