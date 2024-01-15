package q1;

import java.util.Date;

public class Q1Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		CommercialFlight com1 = new CommercialFlight(1230, "İstanbul", new Date(2024 - 1900, 1, 19));
		CommercialFlight com2 = new CommercialFlight(7855, "New York", new Date(2024 - 1900, 5, 3));
		CargoFlight car1 = new CargoFlight(5246, "Paris", new Date(2024 - 1900, 2, 29));
		Flight car2 = new CargoFlight(7592, "Ankara", new Date(2024 - 1900, 7, 2));
		Flight car3 = new CargoFlight(4528, "Rome", new Date(2024 - 1900, 5, 29));
		CommercialFlight com3 = new CommercialFlight(4538, "Schoul", new Date(2023-1900,11,30));

		System.out.println("Today's date: " + new Date());
		System.out.println();
		System.out.println("-----------------------------------------------------------------------");

		System.out.println("Commercial 1 flight date: " + com1.getFlightDate() + " Status: " + car1.getStatus());

		System.out.println("Trying to add 4 days to Commercial1");
		com1.delayFlight(new Date(2024 - 1900, 1, 23)); // 4 Day Later
		System.out.println("Commercial 1 flight date after trying to add 4 days: " + com1.getFlightDate() + " Status: "
				+ car1.getStatus() + " doesnt work");

		System.out.println("Trying to add 1 month 4 days to Commercial1");
		com1.delayFlight(new Date(2024 - 1900, 2, 23)); // 1 Month 4 Day Later
		System.out.println("Commercial 1 flight date after trying to add 1 month 4 days: " + com1.getFlightDate()
				+ " Status: " + car1.getStatus() + " did work");

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("-----------------------------------------------------------------------");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println("Cargo 1 flight date: " + car1.getFlightDate() + " Status: " + car1.getStatus());

		System.out.println("Trying to add 4 days to Cargo 1");
		car1.delayFlight(new Date(2024 - 1900, 3, 4)); // 4 Day Later
		System.out.println("Cargo 1 flight date after trying to add 4 days: " + car1.getFlightDate() + " Status: "
				+ car1.getStatus() + " doesnt work");

		System.out.println("Trying to add 19 days to Cargo 1");
		car1.delayFlight(new Date(2024 - 1900, 3, 19)); // 19 Day Later
		System.out.println("Cargo 1 flight date after trying to add 1 month 4 days: " + car1.getFlightDate()
				+ " Status: " + car1.getStatus() + " did work");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("-----------------------------------------------------------------------\nPolymorhed cargo\n");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		System.out.println("Cargo 2 flight date: " + car2.getFlightDate() + " Status: " + car2.getStatus());
		
		System.out.println("Trying to add 4 days to Cargo 1");
		car1.delayFlight(new Date(2024 - 1900, 7, 6)); // 4 Day Later
		System.out.println("Cargo 2 flight date after trying to add 4 days: " + car2.getFlightDate() + " Status: "
				+ car2.getStatus() + " doesnt work");
		
		System.out.println("Trying to add 19 days to Cargo 2");
		car2.delayFlight(new Date(2024 - 1900, 7, 25)); // 19 Day Later
		System.out.println("Cargo 2 flight date after trying to add 1 month 4 days: " + car2.getFlightDate()
		+ " Status: " + car2.getStatus() + " did work");

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("-----------------------------------------------------------------------");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Commercial 2 flight date: " + com2.getFlightDate() + " Status: " + com2.getStatus());
		System.out.println("Trying to cancel Commercial 2");
		try {
			com2.cancelFlight();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		System.out.println("Commercial 2 flight date: " + com2.getFlightDate() + " Status: " + com2.getStatus());
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("-----------------------------------------------------------------------");
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		System.out.println("Commercial 3 flight date: " + com3.getFlightDate() + " Status: " + com3.getStatus());
		System.out.println("Trying to cancel Commercial 3");
		try {
			com3.cancelFlight();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

}
