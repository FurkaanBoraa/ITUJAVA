package lab;

public class LabTest {

	public static void main(String[] args) {
	Kid kid = new Kid("Kid", "Kiddings");
	YoungAdult ya = new YoungAdult("Youngbut", "Adult");
	Adult adult = new Adult("Adult", "Nokids");
	kid.buyCandy();
	kid.buyCigarette();
	System.out.println();
	ya.buyCandy();
	ya.buyCigarette();
	System.out.println();
	adult.buyCandy();
	adult.buyCigarette();
	
	
	
	}

}
