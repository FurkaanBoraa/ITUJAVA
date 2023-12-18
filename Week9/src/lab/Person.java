package lab;

public class Person {
	private final String fname;
	private  String lname;
	
	public Person(String fname, String lname) {
		super();
		this.fname = fname;
		this.lname = lname;
	}
	
	public String getName() {
		return(fname + lname);
	}
	public void buyCandy() {
		System.out.println("contents of these methods differ for each age group");
	}
	public void buyCigarette() {
		System.out.println("contents of these methods differ for each age group");
	}
	
	
}
