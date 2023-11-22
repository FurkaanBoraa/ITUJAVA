package lab4;

public class Clip {
	private int clipSize;
	private int currentBullet;
	
	public Clip(int clipSize, int currentBullet) {
		this.clipSize = clipSize;
		this.currentBullet = currentBullet;
	}
	public void fire() {
		if (currentBullet > 0) {
			currentBullet--;
			System.out.println("💀💀 You have fired a bullet, now you have " + currentBullet + " bullet");
			}else {
				System.out.println("You don't have any bullets, please reload your gun!");
			}
	}
	public void reload() {
		currentBullet = clipSize;
		System.out.println("You have refilled your mag, they are not clips! Current bullets: "+currentBullet);
	}
	public int getCurrentBullet() {
		return currentBullet;
	}
	public void setCurrentBullet(int currentBullet) {
		this.currentBullet = currentBullet;
	}	
	
}
