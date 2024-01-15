package obj;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Path2D;

import javax.swing.ImageIcon;

public class Enemy extends HPRender {
	public static final double ENEMY_SIZE = 50;
	private double x, y;
	private final float speed = 0.3f;
	private float angle = 0;
	private final Image image;
	private final Area enemyShape;

	public Enemy() {
		super(new HP(20, 20));
		this.image = new ImageIcon(getClass().getResource("/images/rocket.png")).getImage();
		Path2D p = new Path2D.Double();
		p.moveTo(0, ENEMY_SIZE / 2);
		p.lineTo(15, 10);
		p.lineTo(ENEMY_SIZE - 5, 13);
		p.lineTo(ENEMY_SIZE + 10, ENEMY_SIZE / 2);
		p.lineTo(ENEMY_SIZE - 5, ENEMY_SIZE - 13);
		p.lineTo(15, ENEMY_SIZE - 10);
		enemyShape = new Area(p);

	}

	public void changeLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void update() {
		x += Math.cos(Math.toRadians(angle)) * speed;
		y += Math.sin(Math.toRadians(angle)) * speed;
	}

	public void changeAngle(float angle) {
		if (angle < 0) {
			angle = 359;
		} else if (angle > 359) {
			angle = 0;
		}
		this.angle = angle;
	}

	public void draw(Graphics2D g2) {
		AffineTransform oldTransform = g2.getTransform();
		g2.translate(x, y);
		AffineTransform tran = new AffineTransform();
		tran.rotate(Math.toRadians(angle + 45), ENEMY_SIZE / 2, ENEMY_SIZE / 2);
		g2.drawImage(image, tran, null);
		// hitbox
		Shape shap = getShape();
		hpRender(g2, shap, y);
		g2.setTransform(oldTransform);

		// TEST
		// g2.setColor(Color.red);
		// g2.draw(shap.getBounds2D());

	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public float getAngle() {
		return angle;
	}

	public Area getShape() {
		AffineTransform afx = new AffineTransform();
		afx.translate(x, y);
		afx.rotate(Math.toRadians(angle), ENEMY_SIZE / 2, ENEMY_SIZE / 2);
		return new Area(afx.createTransformedShape(enemyShape));
	}

	// To check if enemies are outside the screen
	public boolean check(int width, int height) {
		Rectangle size = getShape().getBounds();
		if (x <= -size.getWidth() || y < -size.getHeight() || x > width || y > height) {
			return false;
		} else {
			return true;
		}

	}

}
