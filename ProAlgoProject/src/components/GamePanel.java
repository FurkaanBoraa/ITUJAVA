package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JComponent;

import obj.Bullet;
import obj.Effect;
import obj.Enemy;
import obj.Player;
import sound.Sound;

public class GamePanel extends JComponent {

	private Graphics2D g2;
	private BufferedImage image;
	private int width, height;
	private Thread thread;
	private boolean start = true;
	private Key key;
	private int shotTime;
	private int spawnSleepTime = 3000;
	// FPS
	private final int FPS = 60;
	private final int SECONDS_PER_FRAME = 1000000000 / FPS;

	// Game Object
	private Sound sound;
	private Player player;
	private List<Bullet> bullets;
	private List<Enemy> enemies;
	private List<Effect> boomEffects;

	private int score = 0;

	public void start() {
		width = getWidth();
		height = getHeight();
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		g2 = image.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (start) {
					long startTime = System.nanoTime();
					drawBackground();
					drawGame();
					render();
					long time = System.nanoTime() - startTime;
					if (time < SECONDS_PER_FRAME) {
						long sleep = (SECONDS_PER_FRAME - time) / 1000000;
						sleep(sleep);
					}
				}

			}

		});
		initGameObject();
		initKeyboard();
		initBullets();
		thread.start();
	}

	private void addEnemies() {
		Random random = new Random();
		int locationY = random.nextInt(height - 50) + 25;
		Enemy enemy = new Enemy();
		enemy.changeLocation(0, locationY);
		enemy.changeAngle(0);
		enemies.add(enemy);
		int locationY2 = random.nextInt(height - 50) + 25;
		Enemy enemy2 = new Enemy();
		enemy2.changeLocation(width, locationY2);
		enemy2.changeAngle(180);
		enemies.add(enemy2);
	}

	private void initGameObject() {
		sound = new Sound();
		player = new Player();
		player.changeLocation(150, 150);
		enemies = new ArrayList<>();
		boomEffects = new ArrayList<>();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (start) {
					addEnemies();
					sleep(spawnSleepTime);
				}
			}

		}).start();
	}

	private void resetGame() {
		enemies.clear();
		bullets.clear();
		player.changeLocation(150, 150);
		player.reset();
		score = 0;
	}

	private void initKeyboard() {
		key = new Key();
		requestFocus();
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_A) {
					key.setLeft(true);
				} else if (e.getKeyCode() == KeyEvent.VK_D) {
					key.setRight(true);
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					key.setSpace(true);
				} else if (e.getKeyCode() == KeyEvent.VK_J) {
					key.setKey_j(true);
				} else if (e.getKeyCode() == KeyEvent.VK_K) {
					key.setKey_k(true);
				} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					key.setKey_enter(true);
				}
			};

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_A) {
					key.setLeft(false);
				} else if (e.getKeyCode() == KeyEvent.VK_D) {
					key.setRight(false);
				} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					key.setSpace(false);
				} else if (e.getKeyCode() == KeyEvent.VK_J) {
					key.setKey_j(false);
				} else if (e.getKeyCode() == KeyEvent.VK_K) {
					key.setKey_k(false);
				} else if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					key.setKey_enter(false);
				}
			}
		});
		new Thread(new Runnable() {

			@Override
			public void run() {
				float s = 0.5f;
				while (start) {
					if (player.isAlive()) {
						float angle = player.getAngle();
						if (key.isLeft()) {
							angle -= s;
						}
						if (key.isRight()) {
							angle += s;
						}
						if (key.isKey_j() || key.isKey_k()) {
							if (shotTime == 0) {
								if (key.isKey_j()) {
									bullets.add(0, new Bullet(player.getX(), player.getY(), player.getAngle(), 5, 3f));
								} else {
									bullets.add(0, new Bullet(player.getX(), player.getY(), player.getAngle(), 20, 3f));
								}
								sound.soundShoot();
							}
							shotTime++;
							if (shotTime == 60) {
								shotTime = 0;
							}
						} else {
							shotTime = 0;
						}
						if (key.isSpace()) {
							player.speedUp();
						} else {
							player.speedDown();
						}
						player.update();
						player.changeAngle(angle);
					} else {
						if (key.isKey_enter()) {
							resetGame();
						}
					}
					for (int i = 0; i < enemies.size(); i++) {
						Enemy enemy = enemies.get(i);
						if (enemy != null) {
							enemy.update();
							if (!enemy.check(width, height)) {
								enemies.remove(enemy);
							} else {
								if (player.isAlive()) {
									checkPlayer(enemy);
								}
							}
						}
					}
					sleep(5);
				}

			}
		}).start();
	}

	private void initBullets() {
		bullets = new ArrayList<>();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (start) {
					for (int i = 0; i < bullets.size(); i++) {
						Bullet bullet = bullets.get(i);
						if (bullet != null) {
							bullet.update();
							checkBullets(bullet);
							if (!bullet.check(width, height)) {
								bullets.remove(bullet);
							}
						} else {
							bullets.remove(bullet);
						}
					}
					for (int i = 0; i < boomEffects.size(); i++) {
						Effect boomEffect = boomEffects.get(i);
						if (boomEffect != null) {
							boomEffect.update();
							if (!boomEffect.check()) {
								boomEffects.remove(boomEffect);
							}
						} else {
							boomEffects.remove(boomEffect);
						}
					}
					sleep(1);
				}
			}
		}).start();
	}

	private void checkBullets(Bullet bullet) {
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if (enemy != null) {
				Area area = new Area(bullet.getShape());
				area.intersect(enemy.getShape());
				if (!area.isEmpty()) {
					boomEffects.add(new Effect(bullet.getCenterX(), bullet.getCenterY(), 3, 5, 60, 0.5f,
							new Color(230, 207, 105)));
					if (!enemy.updateHP(bullet.getSize())) {
						score++;
						if (spawnSleepTime <= 300) {
							spawnSleepTime = 374;
						} else {
							spawnSleepTime -= 75;
						}
						enemies.remove(enemy);
						sound.soundDestroy();
						double x = enemy.getX() + enemy.ENEMY_SIZE / 2;
						double y = enemy.getY() + enemy.ENEMY_SIZE / 2;
						boomEffects.add(new Effect(x, y, 5, 5, 75, 0.05f, new Color(32, 78, 169)));
						boomEffects.add(new Effect(x, y, 5, 5, 75, 0.1f, new Color(32, 78, 169)));
						boomEffects.add(new Effect(x, y, 10, 10, 100, 0.3f, new Color(230, 207, 105)));
						boomEffects.add(new Effect(x, y, 10, 5, 100, 0.5f, new Color(255, 70, 69)));
						boomEffects.add(new Effect(x, y, 10, 5, 100, 0.2f, new Color(255, 172, 31)));
						boomEffects.add(new Effect(x, y, 5, 5, 75, 0.05f, new Color(255, 255, 255)));
					}else {
						sound.soundDamage();
					}
					bullets.remove(bullet);
				}
			}
		}
	}

	private void checkPlayer(Enemy enemy) {
		if (enemy != null) {
			Area area = new Area(player.getShape());
			area.intersect(enemy.getShape());
			if (!area.isEmpty()) {
				double enemyHP = enemy.getHP();
				if (!enemy.updateHP(player.getHP())) {
					enemies.remove(enemy);
					sound.soundDestroy();
					double x = enemy.getX() + enemy.ENEMY_SIZE / 2;
					double y = enemy.getY() + enemy.ENEMY_SIZE / 2;
					boomEffects.add(new Effect(x, y, 5, 5, 75, 0.05f, new Color(32, 78, 169)));
					boomEffects.add(new Effect(x, y, 5, 5, 75, 0.1f, new Color(32, 78, 169)));
					boomEffects.add(new Effect(x, y, 10, 10, 100, 0.3f, new Color(230, 207, 105)));
					boomEffects.add(new Effect(x, y, 10, 5, 100, 0.5f, new Color(255, 70, 69)));
					boomEffects.add(new Effect(x, y, 10, 5, 100, 0.2f, new Color(255, 172, 31)));
					boomEffects.add(new Effect(x, y, 5, 5, 75, 0.05f, new Color(255, 255, 255)));
				}
				if (!player.updateHP(enemyHP)) {
					player.setAlive(false);
					sound.soundDestroy();
					double x = player.getX() + player.PLAYER_SIZE / 2;
					double y = player.getY() + player.PLAYER_SIZE / 2;
					boomEffects.add(new Effect(x, y, 5, 5, 75, 0.05f, new Color(32, 78, 169)));
					boomEffects.add(new Effect(x, y, 5, 5, 75, 0.1f, new Color(32, 78, 169)));
					boomEffects.add(new Effect(x, y, 10, 10, 100, 0.3f, new Color(230, 207, 105)));
					boomEffects.add(new Effect(x, y, 10, 5, 100, 0.5f, new Color(255, 70, 69)));
					boomEffects.add(new Effect(x, y, 10, 5, 100, 0.2f, new Color(255, 172, 31)));
					boomEffects.add(new Effect(x, y, 5, 5, 75, 0.05f, new Color(255, 255, 255)));
				}
			}
		}
	}

	private void drawBackground() {
		g2.setColor(new Color(30, 30, 30));
		g2.fillRect(0, 0, width, height);
	}

	private void drawGame() {
		if (player.isAlive()) {
			player.draw(g2);
		}
		for (int i = 0; i < bullets.size(); i++) {
			Bullet bullet = bullets.get(i);
			if (bullet != null) {
				bullet.draw(g2);
			}
		}
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			if (enemy != null) {
				enemy.draw(g2);
			}
		}
		for (int i = 0; i < boomEffects.size(); i++) {
			Effect boomEffect = boomEffects.get(i);
			if (boomEffect != null) {
				boomEffect.draw(g2);
			}
		}
		g2.setColor(Color.white);
		g2.setFont(getFont().deriveFont(Font.BOLD, 15f));
		g2.drawString("SCORE : " + score, 10, 20);
		if (!player.isAlive()) {
			String text = "GAME OVER";
			String textKey = "Press key ENTER to continue...";
			g2.setFont(getFont().deriveFont(Font.BOLD, 50f));
			FontMetrics fm = g2.getFontMetrics();
			Rectangle2D r2 = fm.getStringBounds(text, g2);
			double textWidth = r2.getWidth();
			double textHeight = r2.getHeight();
			double x = (width - textWidth) / 2;
			double y = (height - textHeight) / 2;
			g2.drawString(text, (int) x, (int) y + fm.getAscent());
			g2.setFont(getFont().deriveFont(Font.BOLD, 15f));
			fm = g2.getFontMetrics();
			r2 = fm.getStringBounds(textKey, g2);
			textWidth = r2.getWidth();
			textHeight = r2.getHeight();
			x = (width - textWidth) / 2;
			y = (height - textHeight) / 2;
			g2.drawString(textKey, (int) x, (int) y + fm.getAscent() + 50);

		}
	}

	private void render() {
		Graphics g = getGraphics();
		g.drawImage(image, 0, 0, null);
		g.dispose();
	}

	private void sleep(long sleep) {
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e) {
			System.err.println(e);
		}
	}

}