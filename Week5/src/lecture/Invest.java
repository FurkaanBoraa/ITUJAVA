package lecture;

import java.util.Scanner;

public class Invest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		//p ve n
		System.out.println("Enter how much money you wanted to invest:");
		double p = scanner.nextDouble();
		System.out.println("How many years will you hold?");
		int n = scanner.nextInt();
		double a = p*(Math.pow(1.05,n));
		System.out.println("You will have "+a+" $");
		scanner.close();
	}

}
