package lecture;
public class Dog extends Animal {
	
	int tasmano;
	
	
	public Dog(int age, String name,int tasmano) {
		super(age, name);
		this.tasmano=tasmano;
		// TODO Auto-generated constructor stub
	}


	@Override
	public void greet() {
		// TODO Auto-generated method stub
		super.greet();
		System.out.println("Hav hav");
	}

}