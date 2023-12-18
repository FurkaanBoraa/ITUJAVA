package lab8;

import java.util.Date;

public class Q2Test {

	public static void main(String[] args) {
		Movie movie1 = new Movie("Christmas Express", "123456", MovieType.CHILDREN);
		Movie movie2 = new Movie("Silence of Lambs", "245862", MovieType.REGULAR);
		Movie movie3 = new Movie("100th Year of Turkey", "290923", MovieType.NEWRELEASE);
		Date today = new Date(123,0,1);  // B R U H
		Date tenAfterToday = new Date(123,0,11);
		try {
			Rental rent1 = new Rental(movie1,tenAfterToday,today);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println(movie2.getDailyPrice(30));

	}

}
