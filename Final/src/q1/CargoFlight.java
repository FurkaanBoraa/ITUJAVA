package q1;

import java.util.Date;

public class CargoFlight extends Flight {

	public CargoFlight(int flightNumber, String destination, Date flightDate) {
		super(flightNumber, destination, flightDate);
	}

	@Override
	public boolean delayFlight(Date date) {
		Date fifteenAfter = new Date(this.getFlightDate().getYear(), this.getFlightDate().getMonth(),
				this.getFlightDate().getDate() + 15);
		if (date.after(fifteenAfter)) {
			this.setFlightDate(date);
			this.setStatus("Delayed");
			return true;
		}
		return false;
	}

}
