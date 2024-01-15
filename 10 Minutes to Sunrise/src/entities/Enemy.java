package entities;
import static utils.Constants.EnemyConstants.*;
public abstract class Enemy extends Entity{
	
	public Enemy(float x, float y, int width, int height, int health) {
		super(x, y, width, height, health);
		initHitbox(x, y, width, height);
	}

	public void update() {};
}
