package obj;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class HPRender {
	private final HP hp;

	public HPRender(HP hp) {
		this.hp = hp;
	}

	protected void hpRender(Graphics2D g2, Shape shape, double y) {
		if (hp.getCurrentHealth() != hp.getMAX_HP()) {
			double hpY = shape.getBounds().getY() - y - 10;
			g2.setColor(Color.gray);
			g2.fill(new Rectangle2D.Double(0, hpY, Player.PLAYER_SIZE, 2));
			g2.setColor(Color.red);
			double hpSize = hp.getCurrentHealth() / hp.getMAX_HP() * Player.PLAYER_SIZE;
			g2.fill(new Rectangle2D.Double(0, hpY, hpSize, 2));
		}
	}

	public boolean updateHP(double cutHP) {
		hp.setCurrentHealth(hp.getCurrentHealth() - cutHP);
		return hp.getCurrentHealth() > 0;
	}

	public double getHP() {
		return hp.getCurrentHealth();
	}

	public void resetHP() {
		hp.setCurrentHealth(hp.getMAX_HP());
	}
}
