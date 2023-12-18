package lab;

public class YoungAdult extends Person{



	public YoungAdult(String fname, String lname) {
		super(fname, lname);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void buyCandy() {
		// TODO Auto-generated method stub
		super.buyCandy();
		System.out.println("Bro aren't you old enough to have childs");
	}

	@Override
	public void buyCigarette() {
		// TODO Auto-generated method stub
		super.buyCigarette();
		System.out.println("Stop smoking if you want to live a long life");
	}

}
