package obj;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class Effect {
	private final double x;
	private final double y;
	private final double MAX_DISTANCE;
	private final int MAX_SIZE;
	private final Color color;
	private final int totalEffect;
	private final float SPEED;
	private double currentDistance;
	private ModelBoom booms[];
	private float alpha = 1f;

	public Effect(double x, double y, int totalEffect, int max_size, double max_distance, float speed, Color color) {
		this.x = x;
		this.y = y;
		this.totalEffect = totalEffect;
		this.MAX_SIZE = max_size;
		this.MAX_DISTANCE = max_distance;
		this.SPEED = speed;
		this.color = color;
		createRandom();
	}

	private void createRandom() {
		booms = new ModelBoom[totalEffect];
		float per = 360f / totalEffect;
		Random ran = new Random();
		for (int i = 1; i <= totalEffect; i++) {
			int r = ran.nextInt((int) per) + 1;
			int boomSize = ran.nextInt(MAX_SIZE) + 1;
			float angle = i * per + r;
			booms[i - 1] = new ModelBoom(boomSize, angle);
		}
	}

	public void draw(Graphics2D g2) {
		AffineTransform oldTransform = g2.getTransform();
		Composite oldComposite = g2.getComposite();
		g2.setColor(color);
		g2.translate(x, y);
		for (ModelBoom b : booms) {
			double bx = Math.cos(Math.toRadians(b.getAngle())) * currentDistance;
			double by = Math.sin(Math.toRadians(b.getAngle())) * currentDistance;
			double boomSize = b.getSize();
			double space = boomSize / 2;
			if (currentDistance >= MAX_DISTANCE - (MAX_DISTANCE * 0.75f)) {
				alpha = (float) ((MAX_DISTANCE - currentDistance) / (MAX_DISTANCE * 0.7f));
			}
			if (alpha > 1) {
				alpha = 1;
			} else if (alpha < 0) {
				alpha = 0;
			}
			g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
			g2.fill(new Rectangle2D.Double(bx - space, by - space, boomSize, boomSize));
		}
		g2.setComposite(oldComposite);
		g2.setTransform(oldTransform);
	}

	public void update() {
		currentDistance += SPEED;
	}

	public boolean check() {
		return currentDistance < MAX_DISTANCE;
	}
}
