package lecture;
public class Animal {
	
	int age; 
	String name;
	
	public Animal(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	public void run() {
		
		System.out.println(name +" ran");
	}
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	public void greet() {
		System.out.println("I am an animal");
	}

}