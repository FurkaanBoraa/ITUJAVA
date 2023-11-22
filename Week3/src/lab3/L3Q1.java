package lab3;

import java.util.Scanner;

public class L3Q1 {

	public static double simpleCalculator(double num1, double num2, char operand) {
		double result = 0;
		switch (operand) {
			case '+':
				result = (num1 + num2);
				break;
			case '-':
				result =(num1-num2);			
				break;
			case '*':
				result =(num1*num2);
				break;
			case '/':
				if (num2 != 0) {
					result =(num1/num2);
				} else {
					result = Double.NaN;
				}
				break;
			default:
				result = Double.NaN;
				break;
			}	
		return result;
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter first number");
		double num1 = scanner.nextDouble();
		System.out.println("Enter second number");
		double num2 = scanner.nextDouble();
		System.out.println("Enter operand you want to use");
		char operand = scanner.next().charAt(0);
		
		double result = simpleCalculator(num1, num2, operand);
		if (!Double.isNaN(result)) {
			System.out.printf("%.2f %c %.2f = %.2f",num1,operand, num2, result);	
		} else {
			System.err.println("nvalid input(s)");
		}
		scanner.close();
	}

}
