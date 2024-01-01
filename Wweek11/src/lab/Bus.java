package lab;

public class Bus implements CommercialVehicle {
	private int modelYear;
	private double tonnage;
	
	public Bus(int modelYear, double tonnage) {
		super();
		this.modelYear = modelYear;
		this.tonnage = tonnage;
	}



	public int getModelYear() {
		return modelYear;
	}



	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}



	public double getTonnage() {
		return tonnage;
	}



	public void setTonnage(double tonnage) {
		this.tonnage = tonnage;
	}



	@Override
	public double calculateAmortizedTax(double baseTax, int currentYear) {
		double tonnageRate;
		double ageRate = Math.min(currentYear - modelYear * 0.05, 2);
		if (tonnage < 1) {
			tonnageRate = 1;
		} else if(tonnage >= 1 && tonnage <= 10) {
			tonnageRate = 1.4;
		}else {
			tonnageRate = 1.6;
		}
		return baseTax * tonnageRate * ageRate;
	}

}
