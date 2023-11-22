package lab4;

public class TestClip {

	public static void main(String[] args) {

		Clip mag = new Clip(12,1);
		mag.fire();
		mag.fire();
		mag.reload();
		System.out.println(mag.getCurrentBullet());
	}

}
