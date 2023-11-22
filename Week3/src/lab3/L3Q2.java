package lab3;

import java.util.Scanner;

public class L3Q2 {
	public static int findDigit(int k, int d){
		int position = -1;	//-1 because if digit is not in number, we will return -1
		String ktemp = Integer.toString(k);	//Cast to string 

		for (int i = 0; i < ktemp.length(); i++) {
			int check = Character.getNumericValue(ktemp.charAt(i));
			if (check == d) {
				position = ktemp.length()-1-i;
				break;
			}
		}
		return position;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your number");
		int k = scanner.nextInt();  //Get integer from input
		System.out.println("Enter digit you want to know");
		int d = scanner.nextInt();	//Get wanted digit from input
		if(k > 0 && d<10 && d>=0) {	//Check conditions
			System.out.println(findDigit(k, d));
		}else {
			System.err.println("Invalid inputs!");
		}
		scanner.close();
	}

}
