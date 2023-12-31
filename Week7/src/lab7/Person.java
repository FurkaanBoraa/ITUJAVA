package lab7;

public class Person {
	private String name;
	private Car car;
	private Gallery gallery;

	Person(String name) {
		this.name = name;
	}
	
	public String introduceSelf() {
		String string = "";
		if(gallery == null) {
			if(car == null) {
				string = "A person without a car nor a gallery";
			}
		}
		return string;
	}
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
