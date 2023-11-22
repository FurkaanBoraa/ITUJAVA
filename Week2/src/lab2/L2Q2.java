package lab2;

import java.util.Scanner;

public class L2Q2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter first character");
		char letter1 = scanner.next().charAt(0);

		System.out.println("Please enter second character");
		char letter2 = scanner.next().charAt(0);
		
		System.out.println("Please enter third character");
		char letter3 = scanner.next().charAt(0);
		
		if (2 * letter2 == letter1 + letter3) {
			System.out.println(letter2 + " is exactly middle character of letters " + letter1 + " and " + letter3);
		}else {
			System.out.println(letter2 + " is NOT exactly middle character of letters " + letter1 + " and " + letter3);
		}
		scanner.close();

	}

}
