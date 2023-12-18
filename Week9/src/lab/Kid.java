package lab;

public class Kid extends Person{

	public Kid(String fname,String lname) {
		super(fname,lname);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buyCandy() {
		// TODO Auto-generated method stub
		super.buyCandy();
		System.out.println("Here is your candy sweetie");
	}

	@Override
	public void buyCigarette() {
		// TODO Auto-generated method stub
		super.buyCigarette();
		System.out.println("Can you show me ID, I guess so...");
	}

}
