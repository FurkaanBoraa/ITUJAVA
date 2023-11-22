package lab7;

public class Car {
	private String plate;
	private FuelType fuelType;
	private Person carOwner;
	
	
	public Car(String plate, FuelType fuelType) {
		this.plate = plate;
		this.fuelType = fuelType;
	}

	public double calculateFuelCost(double liter) {
		return liter*fuelType.getPriceByLiter();
	}
	
	public String introduceSelf() {
		String string;
		if (carOwner !=null) {
			string = ("A car owned by "+carOwner.getName()+" with plate: " + this.plate + " which is using " + fuelType.getFuelName());
		} else {
			string = ("A car without an owner with plate: " + this.plate + " which is using " + fuelType.getFuelName());
		}
		return string;
	}

	public String getPlate() {
		return plate;
	}


	public void setPlate(String plate) {
		this.plate = plate;
	}


	public FuelType getFuelType() {
		return fuelType;
	}


	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	
	

	
	
}
