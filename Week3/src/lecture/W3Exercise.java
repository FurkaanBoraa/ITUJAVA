package lecture;

import java.util.Scanner;

public class W3Exercise {
	public static void func(int a, int b) {
		char letter;
		double middle = (double)(a+b)/2;	
		if (middle <= 33) {
			letter = 'A';
		} else if (middle<=66) {
			letter = 'B';
		} else{
			letter = 'C';
		}
		System.out.println("Average of " + a + " and " + b+ " is : " + middle + " and your Letter is: " + letter);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter two number which are less than or equal to 100");
		System.out.println("Number a");
		int a = scanner.nextInt();
		System.out.println("Number b");
		int b = scanner.nextInt();
		if (a < 0 || a > 100 || b < 0 || b > 100) {
			System.err.println("Your numbers must be between 0-100!");
		}else {
			func(a,b);
		}
		scanner.close();
	}

}
