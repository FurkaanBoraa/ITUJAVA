package lab3;

import java.util.Arrays;
import java.util.Scanner;

public class L3Q3 {
	public static String TriangleType(double side1,double side2,double side3) {
		//Triangle check
		if (side1 <= 0 || side2 <= 0 || side3 <= 0) {
			return "There are no triangles with a sidelength 0!";
		}
		
		//Make an array and sort it for easy condition check
		double[] sides = {side1,side2,side3};
		Arrays.sort(sides);
		
		if (sides[0] == sides[2]) {
			//Since array is sorted, if first and last are equal, middle value must be equal as well
			return "equilateral triangle";
		} else if (sides[1] == sides[0] || sides[1] == sides[2]) {
			//We checked all equals so any pair of equality gives isosceles 
			return "isosceles triangle";
		}else{
			return "scalene triangle";
		}
		
	}
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double side1 = scanner.nextDouble();
		double side2 = scanner.nextDouble();
		double side3 = scanner.nextDouble();
		System.out.println(TriangleType(side1, side2, side3));
		scanner.close();
	}

}
