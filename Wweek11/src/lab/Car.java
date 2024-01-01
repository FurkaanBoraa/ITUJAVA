package lab;

public class Car implements CommercialVehicle, PersonalVehicle {
	private int modelYear;
	private double engineVolume;
	
	
	public Car(int modelYear, double engineVolume) {
		this.modelYear = modelYear;
		this.engineVolume = engineVolume;
	}

	public int getModelYear() {
		return modelYear;
	}

	public void setModelYear(int modelYear) {
		this.modelYear = modelYear;
	}

	public double getEngineVolume() {
		return engineVolume;
	}

	public void setEngineVolume(double engineVolume) {
		this.engineVolume = engineVolume;
	}

	@Override
	public double calculateTax(double baseTax) {
		// TODO Auto-generated method stub
		return baseTax * engineVolume;
	}

	@Override
	public double calculateAmortizedTax(double baseTax, int currentYear) {
		return calculateTax(baseTax)*(1 - 0.1 * Math.min(currentYear-modelYear, 9));
	}

}
