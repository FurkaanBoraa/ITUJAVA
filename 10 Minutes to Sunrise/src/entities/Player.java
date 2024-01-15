package entities;

import static utils.Constants.Directions.*;
import static utils.Constants.PlayerConstants.GetSpriteAmount;
import static utils.Constants.PlayerConstants.*;
import static utils.HelpMethods.CanMoveHere;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import main.Game;
import utils.LoadSave;

public class Player extends Entity {
	private BufferedImage[][] animations;
	private BufferedImage[] gunAnimations;
	private BufferedImage halo, shadow;
	private int animationTick, animationIndex, animationSpeed = 15;
	private int playerAction = IDLE;
	private boolean isMoving = false, isAttacking = false;
	private float playerSpeed = 1f;
	private boolean left, up, right, down;
	private float xDrawOffset = 16 * Game.SCALE;
	private float yDrawOffset = 7* Game.SCALE;

	public Player(float x, float y, int width, int height) {
		super(x, y, width, height , 4);
		loadAnimations();
		initHitbox(x, y, 10 * Game.SCALE, 30 * Game.SCALE);
		// TODO Auto-generated constructor stub
	}

	public void update() {
		updatePosition();
		updateAnimationTick();
		setAnimation();

	}

	public void render(Graphics g) {
		g.drawImage(shadow, (int)(hitbox.x - xDrawOffset+24), (int)(hitbox.y - yDrawOffset + 65), 30, 15, null);
		g.drawImage(animations[playerAction][animationIndex], (int)(hitbox.x - xDrawOffset), (int)(hitbox.y - yDrawOffset), width, height, null);
		g.drawImage(halo, (int)(hitbox.x - xDrawOffset +24), (int)(hitbox.y - yDrawOffset- 3), null);
		g.drawImage(gunAnimations[0], (int)(hitbox.x - xDrawOffset+48), (int)(hitbox.y - yDrawOffset + 35),25,20, null);
		//drawHitbox(g);

	}

	private void updateAnimationTick() {
		animationTick++;
		if (animationTick >= animationSpeed) {
			animationTick = 0;
			animationIndex++;
			if (animationIndex >= GetSpriteAmount(playerAction)) {
				animationIndex = 0;
			}
		}

	}

	private void setAnimation() {
		int startAnimation = playerAction;
		if (isMoving) {
			playerAction = RUNNING;
		} else {
			playerAction = IDLE;
		}
		if (isAttacking && isMoving) {
			playerAction = SHOOTING_RUNNING;

		}
		if (startAnimation != playerAction) {
			resetAnimationTick();
		}
	}

	private void resetAnimationTick() {
		animationTick = 0;
		animationIndex = 0;

	}

	private void updatePosition() {
		float currentSpeed = playerSpeed;
		float xSpeed = 0, ySpeed = 0;
		isMoving = false;
		if ((left ^ right) && (up ^ down)) {
			currentSpeed /= Math.sqrt(2); // 45 degree walking,
		}
		if (playerAction == SHOOTING_RUNNING) {
			currentSpeed *= 0.1f;
		}
		if (!left && !down && !right && !up)
			return;
		if (left && !right)
			xSpeed = -currentSpeed;
		else if (right && !left)
			xSpeed = currentSpeed;
		if (up && !down)
			ySpeed = -currentSpeed;
		if (down && !up)
			ySpeed = currentSpeed;
		if (CanMoveHere(hitbox.x + xSpeed, hitbox.y + ySpeed, hitbox.width, hitbox.height)) {
			hitbox.x += xSpeed;
			hitbox.y += ySpeed;
			isMoving = true;
		}
	}

	private void loadAnimations() {
		BufferedImage player = LoadSave.GetSpriteAtlas(LoadSave.PLAYER_ATLAS);
		halo = LoadSave.GetSpriteAtlas(LoadSave.HALO);
		shadow = LoadSave.GetSpriteAtlas(LoadSave.SHADOW);
		BufferedImage gun = LoadSave.GetSpriteAtlas(LoadSave.GUN);
		gunAnimations = new BufferedImage[5];
		animations = new BufferedImage[3][8];
		for (int j = 0; j < animations.length; j++) {
			for (int i = 0; i < animations[j].length; i++) {
				animations[j][i] = player.getSubimage(i * 32, j * 32, 32, 32);
			}
		}
		for (int i = 0; i < gunAnimations.length; i++) {
			gunAnimations[i]=gun.getSubimage(i*16, 0, 16, 14);
		}
	}

	public boolean isAttacking() {
		return isAttacking;
	}

	public void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
	}

	public float getSpeed() {
		return playerSpeed;
	}

	public void setSpeed(int playerSpeed) {
		this.playerSpeed = playerSpeed;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public void resetDirBooleans() {
		left = false;
		right = false;
		up = false;
		down = false;
	}

}
