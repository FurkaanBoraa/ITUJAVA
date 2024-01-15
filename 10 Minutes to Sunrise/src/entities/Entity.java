package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
	protected float x, y;
	protected int width, height, health;
	protected Rectangle2D.Float hitbox;

	public Entity(float x, float y, int width, int height, int health ) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height= height;
		this.health= health;
	}
	protected void drawHitbox(Graphics g) {
		// For debugging
		g.setColor(Color.magenta);
		g.drawRect((int)hitbox.x, (int)hitbox.y, (int)hitbox.width, (int)hitbox.height);
	}
	protected void initHitbox(float x, float y, float width, float height) {
		// TODO Auto-generated method stub
		hitbox = new Rectangle2D.Float(x, y, width,height);
	}
	/*protected void updateHitbox() {
		hitbox.x = (int)x;
		hitbox.y = (int)y;
	}*/

	public Rectangle2D.Float getHitbox() {
		return hitbox;
	}

	public void setHitbox(Rectangle2D.Float hitbox) {
		this.hitbox = hitbox;
	}
}
