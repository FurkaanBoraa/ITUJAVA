package lab2;

import java.util.Scanner;

public class L2Q1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number to be tested: ");
		int number = scanner.nextInt();
		if (number < 0) {
			System.out.println("!!! Number must be a non-negative integer\n");
			// L2Q1.main(args);
		}
		else if (number%4 == 1 ) {
			System.out.println(number + " is a Hilbert number");
		} else {
			System.out.println(number + " is NOT a Hilbert number");
		}
		scanner.close();
	}

}
