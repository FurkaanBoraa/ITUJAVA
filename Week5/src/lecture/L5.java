package lecture;

import java.util.Scanner;

public class L5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int total =0;
		int counter = 1;
		
		while (counter <=3){
			System.out.println("Enter grade");
			total += scanner.nextInt();
			counter++;
		}

		double average = (double)total/(double)(counter-1);
		System.out.println("Class average is: " + average);
		scanner.close();
	}

}
