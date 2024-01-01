package lab;

public class Q2Test {

	public static void main(String[] args) {
		Car car = new Car(2021, 100);
		Bus bus = new Bus(2015,10);
		System.out.println("Cars normal tax is: " + car.calculateTax(10));
		System.out.println("Cars amortized rate is: " + car.calculateAmortizedTax(10, 2023));
		
		System.out.println("Bus amortized task is: "+bus.calculateAmortizedTax(100, 2023));

	}

}
