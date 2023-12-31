package lab7;

public enum FuelType {
	DIESEL("Diesel", 40), GASOLINE("Gasoline", 30);
	
	private String fuelName;
	private double priceByLiter;
	
	
	private FuelType(String fuelName, double priceByLiter) {
		this.fuelName = fuelName;
		this.priceByLiter = priceByLiter;
	}

	public String getFuelName() {
		return fuelName;
	}

	public void setFuelName(String fuelName) {
		this.fuelName = fuelName;
	}

	public double getPriceByLiter() {
		return priceByLiter;
	}

	public void setPriceByLiter(double priceByLiter) {
		this.priceByLiter = priceByLiter;
	}
	
	
}
