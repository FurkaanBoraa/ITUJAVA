package lab6;

public class ComplexNumber {
	private double real;
	private double imag;

	ComplexNumber(double real, double imag) {
		this.real = real;
		this.imag = imag;
	}
	
	public static ComplexNumber multiply(ComplexNumber z1, ComplexNumber z2) {
		double resultReal = z1.getReal()*z2.getReal()-z1.getImag()*z2.getImag();
		double resultImag = z1.getReal()*z2.getImag()+z2.getReal()*z1.getImag();
		return new ComplexNumber(resultReal, resultImag);
	}
	
	public static ComplexNumber conjugate(ComplexNumber z) {
		//z.setImag(-z.getImag());
		//return z;
		return new ComplexNumber(z.getReal(),-z.getImag());
	}
	
	public static double absValue(ComplexNumber z) {
		return Math.sqrt(multiply(z, ComplexNumber.conjugate(z)).getReal());
	}
	
	public static ComplexNumber add(ComplexNumber z1,ComplexNumber z2) {
		double resultReal = z1.getReal()+z2.getReal();
		double resultImag= z1.getImag()+z2.getImag();
		return new ComplexNumber(resultReal,resultImag);
	}
	
	public void print() {
		System.out.println(this.getReal()+" + ("+this.getImag()+")i");
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}
	
	
}
