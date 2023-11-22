package main;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

	//Screen Settings
	final int originalTileSize = 16; //16x16 tile
	final int scale = 3;
	
	final int tileSize = originalTileSize * scale;
	final int maxScreenCol = 10;
	final int maxScreenRow = 20;
	final int screenWidth = tileSize*maxScreenCol;
	final int screenHeight = tileSize*maxScreenRow;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.blue);
		this.setDoubleBuffered(true);
	}
}
