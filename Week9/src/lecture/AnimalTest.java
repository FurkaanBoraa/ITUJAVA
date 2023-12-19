package lecture;

public class AnimalTest {
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		Animal h1 = new Animal(7, "Jerry");
		Cat c1 = new Cat(10, "Tom", "scot");
		Dog d1 = new Dog(8, "Köfte", 2458);
		
		/*	
		float result = c1.sum1(a, b);
		System.out.println("cat sum method: "+c1.sum(a, b));
		System.out.println("animal sum method: "+h1.sum(a, b));
		System.out.println("cat sum1 method: "+result);
		}
		*/
		System.out.println("Dog greets: ");
		d1.greet();
		System.out.println("Cat greets: ");
		c1.greet();
		System.out.println("Animal greets: ");
		h1.greet();

	}
}
