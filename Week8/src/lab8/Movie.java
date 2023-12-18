package lab8;

public class Movie {
	private String title, barcode;
	private MovieType type;
	
	public Movie(String title, String barcode, MovieType type) {
		this.title = title;
		this.barcode = barcode;
		this.type = type;
	}

	public MovieType getType() {
		return type;
	}
	
	public double getDailyPrice(double exchangeRate) {
		return this.type.getRentalPrice()*exchangeRate;
	}
	
}
