package lab8;

public class DrivingSchool {
	private String name;
	private double price;
	
	public DrivingSchool(String name, double price) throws Exception {
		
		if (price < 0) {
			throw new Exception("Price must be nonnegative.");
		}
		this.name = name;
		this.price = price;
	}
	
	public boolean Register(int age) throws MyException {
		if (age < 18) {
			throw new MyException("Age must be 18 or older");	
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		if (price < 0) {
			throw new IllegalArgumentException("Price must be nonnegative! Price is unchanged");
		}
		this.price = price;
	}	
}
	

