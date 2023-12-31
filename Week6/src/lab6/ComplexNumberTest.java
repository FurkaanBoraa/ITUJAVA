package lab6;


public class ComplexNumberTest {

	public static void main(String[] args) {
		//  Generate complex number objects
		ComplexNumber z0 = new ComplexNumber(7,24);
		ComplexNumber z1 = new ComplexNumber(-1,7);
		ComplexNumber z2 = new ComplexNumber(4,-1);
		ComplexNumber z3 = new ComplexNumber(-6,-3);
		ComplexNumber z[] = {z0,z1,z2,z3};
		
		System.out.println("Welcome to Complex Space\n------------------------------");
		for (int i = 0; i < z.length; i++) {
			System.out.printf("z"+i+" = ");
			z[i].print();
		}
		
		System.out.println("\nConjugates:\n------------------------------");
		for (int i = 0; i < z.length; i++) {
			ComplexNumber conjugate = ComplexNumber.conjugate(z[i]);
			System.out.printf("Conjugate of z"+i+" = ");
			conjugate.print();
		}
		
		System.out.println("\nAbsolute Values:\n------------------------------");
		for (int i = 0; i < z.length; i++) {
			double abs = ComplexNumber.absValue(z[i]);
			System.out.println("Absolute value of z"+i+" = "+abs);
		}
		
		System.out.println("\nAddition:\n------------------------------");
		ComplexNumber addz0z2 = ComplexNumber.add(z0, z2);
		ComplexNumber addz1z3 = ComplexNumber.add(z1, z3);
		System.out.printf("Result of z0 + z2 = ");
		addz0z2.print();
		System.out.printf("Result of z1 + z3 = ");
		addz1z3.print();
		
		System.out.println("\nMultiplication:\n------------------------------");
		ComplexNumber z0z2 = ComplexNumber.multiply(z0, z2);
		ComplexNumber z1z3 = ComplexNumber.multiply(z1, z3);
		System.out.printf("Result of z0 * z2 = ");
		z0z2.print();
		System.out.printf("Result of z1 * z3 = ");
		z1z3.print();

		
		
		

	
	
	}

}
