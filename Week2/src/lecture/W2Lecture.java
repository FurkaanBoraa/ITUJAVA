package lecture;

import java.util.Iterator;
import java.util.Scanner;

public class W2Lecture {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		/*
		int b = scanner.nextInt();
		int a = scanner.nextInt();
		int result = a + b;
		System.out.println("The addition is " + result);
		*/
		
		/*
		int oddornot = scanner.nextInt();
		if (oddornot%2 == 0) {
			System.out.println("The number " + oddornot + " is even");
		}else {
			System.out.println("The number " + oddornot + " is odd");
		}
		*/
		
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		
		int max = a;
		if (b >=max) {
			max = b;
		} else {
			max = c;
		}
		
		/*
		if (a>=b && a>=c) {
			System.out.println("Max number is " + a);
		}else if (b >= c && b>=a) {
			System.out.println("Max number is " + b);
		}else {
			System.out.println("Max number is " + c);
		}
		
		*/
		
		
		}

}
