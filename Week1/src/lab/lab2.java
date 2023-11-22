package lab;

public class lab2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int water = 100;
		int cyl[] = {10,2}; 		// height, radius
		double brad = 1.5;
		double pi = 3.14;
		double voc = pi*cyl[1]*cyl[1]*cyl[0];
		double vos = 4*pi*brad*brad*brad/3;
		double overflow = water + vos * 3 - voc;
		System.out.println("Overflow is: " + overflow);
	}

}
