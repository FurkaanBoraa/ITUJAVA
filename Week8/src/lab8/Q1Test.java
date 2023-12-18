package lab8;

public class Q1Test {

	public static void main(String[] args) {
		/*try {
			DrivingSchool school = new DrivingSchool("İTÜ", -5);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		} */
		try {
			DrivingSchool school = new DrivingSchool("İTÜ", 100);
			//school.Register(-5);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		/*
		System.out.println("Object school with price: " + school.getPrice());
		school.setPrice(10);
		System.out.println("Changed price to : "+school.getPrice());
		System.out.println("!!Trying to change price to a negative value!!");
		try {
			school.setPrice(-20);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Current price is : "+school.getPrice());
		System.out.println();
		System.out.println("Trying to register a 18- person");
		try {
			school.Register(16);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}*/
	
	}
	

}
