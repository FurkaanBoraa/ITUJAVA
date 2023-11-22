package lecture;

import java.util.Scanner;

public class W3Lecture {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter integer you want to check if it is a perfect number");
		int number = scanner.nextInt();
		System.out.println(checkPerfect(number) == true ? "Perfect" : "Not-Perfect");
		scanner.close();
	}

	public static boolean checkPerfect(int a) {
		int sum = 0;
		for (int i = 1; i < a; i++) {
			if (a%i == 0) {
				sum += i;
			}
		}
		if(a == sum)
			return true;
		else
			return false;
		
	}

}
