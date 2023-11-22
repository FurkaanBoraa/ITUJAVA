package lab2;

import java.util.Scanner;

public class L2Q3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		double cost = 0;
		double labor = 25.4;
		double typeA = 42.5;
		double typeB = 28.5;
		double typeC = 19;
		
		System.out.println("Enter your surface area in square-meters:");
		double area = scanner.nextDouble();
		System.out.println("Enter which type of parquet you want (A - B - C):");
		char ptype = scanner.next().charAt(0);
		switch (ptype) {
		case 'A': {
			cost = (typeA + labor)*area;	
			break;
		}
		case 'B': {
			cost = (typeB + labor)*area;				
			break;
		}
		case 'C': {
			cost = (typeC + labor)*area;				
			break;
		}
		default:
			System.out.println("You entered an undeclared parque type");
		}
		if (cost >= 1000) {
			cost = cost*0.9;
		}
		System.out.printf("Your total cost for %.2f square meter and Type-%c parquet is: %.2f",area, ptype, cost);
		scanner.close();
	}

}
