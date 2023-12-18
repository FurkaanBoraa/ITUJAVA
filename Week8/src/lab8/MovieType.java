package lab8;

public enum MovieType {
	REGULAR(1.5), NEWRELEASE(2), CHILDREN(1);
	private double rentalPrice;

	private MovieType(double rentalPrice) {
		this.rentalPrice = rentalPrice;
	}
	
	public double getRentalPrice() {
		return rentalPrice;
	}
}
