package lab8;

import java.util.Date;

public class Rental {
	private Movie movie;
	private Date dueDate, rentalDate;
	
	public Rental(Movie movie, Date rentalDate, Date dueDate) throws Exception{
		this.movie = movie;
		if (rentalDate.after(dueDate)) {
			throw new Exception("Due date is before rental date!");
		}
		this.rentalDate = rentalDate;
		this.dueDate = dueDate;
	}
}
