package obj;

public class HP {
	double MAX_HP;
	double currentHealth;

	public HP(double mAX_HP, double currentHealth) {
		MAX_HP = mAX_HP;
		this.currentHealth = currentHealth;
	}

	public double getMAX_HP() {
		return MAX_HP;
	}

	public void setMAX_HP(double mAX_HP) {
		MAX_HP = mAX_HP;
	}

	public double getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(double currentHealth) {
		this.currentHealth = currentHealth;
	}
}
