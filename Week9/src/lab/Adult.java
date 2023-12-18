package lab;

public class Adult extends Person{


	public Adult(String fname, String lname) {
		super(fname, lname);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void buyCandy() {
		// TODO Auto-generated method stub
		super.buyCandy();
		System.out.println("You must be careful about getting fat");
	}

	@Override
	public void buyCigarette() {
		// TODO Auto-generated method stub
		super.buyCigarette();
		System.out.println("You can buy cigarettes");
	}
	

}
