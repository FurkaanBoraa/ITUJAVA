package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import static utils.Constants.PlayerConstants.*;
import static utils.Constants.Directions.*;

public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private int width = Toolkit.getDefaultToolkit().getScreenSize().width;
	private int height = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int xDelta = width / 2, yDelta = height / 2;
	private BufferedImage img, halo;
	private BufferedImage[][] animations;
	private int animationTick, animationIndex, animationSpeed = 15;
	private int playerAction = IDLE;
	private int playerDirection = -1;
	private boolean isMoving = false;
	private int speed  = 1;
	
	
	public GamePanel() {
		mouseInputs = new MouseInputs(this);
		importImg();
		loadAnimations();
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}

	private void loadAnimations() {
		animations = new BufferedImage[3][8];
		
		for(int j = 0 ; j < animations.length; j++) {
			for (int i = 0; i < animations[j].length; i++) {
				animations[j][i] = img.getSubimage(i * 32, j*32, 32, 32);
			}
		}
	}

	private void importImg() {
		InputStream character = getClass().getResourceAsStream("/T_Lilith.png");
		InputStream halostream = getClass().getResourceAsStream("/T_ShanaHalo.png");

		try {
			img = ImageIO.read(character);
			halo = ImageIO.read(halostream);
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				character.close();
				halostream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void setPanelSize() {
		Dimension size = new Dimension(width, height);
		setPreferredSize(size);

	}

	public void setDireciton(int direction) {
		this.playerDirection = direction;
		isMoving = true;
	}
	
	public void setMoving(boolean moving) {
		this.isMoving = moving;
	}
	
	private void updateAnimationTick() {
		animationTick++;
		if (animationTick >= animationSpeed) {
			animationTick = 0;
			animationIndex++;
			if (animationIndex >= GetSpriteAmoount(playerAction) ) {
				animationIndex = 0;
			}
		}
		
	}
	
	private void setAnimation() {
		if (isMoving) {
			playerAction = RUNNING;
		}else {
			playerAction = IDLE;
		}
		
	}
	
	private void updatePosition() {
		if (isMoving) {
			switch (playerDirection) {
				case LEFT: {
					xDelta-=speed;
					break;
				}
				case UP: {
					yDelta-=speed;
					break;
				}
				case RIGHT: {
					xDelta+=speed;
					break;
				}
				case DOWN: {
					yDelta+=speed;
					break;
				}			
			}
		}
		
	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		updateAnimationTick();
		
		setAnimation();
		updatePosition();
		
		g.drawImage(animations[playerAction][animationIndex], xDelta , yDelta, 80, 80, null);
		g.drawImage(halo, xDelta + 22, yDelta -5, null);
	}


	

	

}
