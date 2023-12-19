package lecture;
public class Cat extends Animal{ 
	String type;
	float c=7;
	
	public Cat(int age, String name, String type) {
		super(age, name);
		this.type = type;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("type is: "+type);
	}

	@Override
	public void greet() {
		
		System.out.println("Meoow");
	}

	@Override
	public int sum(int a, int b) {
		// TODO Auto-generated method stub
		int ab = super.sum(a, b);
		return (int)(ab+c);
	}
	
	public float sum1(int a, int b) {
		return(c+super.sum(a, b));
	}
	

}