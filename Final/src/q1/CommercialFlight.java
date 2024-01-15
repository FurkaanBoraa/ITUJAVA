package q1;

import java.util.Date;

public class CommercialFlight extends Flight implements AdditionalFlightOperation {

	public CommercialFlight(int flightNumber, String destination, Date flightDate) {
		super(flightNumber, destination, flightDate);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cancelFlight() throws Exception {
		if (this.getFlightDate().before(new Date())) {
			throw new Exception("Expired flight! \nFlight with number: "+this.getFlightNumber()+" cannot be cancelled");
		} else {
			this.setStatus("Cancelled");
		}
	}

	@Override
	public boolean delayFlight(Date date) {
		Date monthAfter = new Date(this.getFlightDate().getYear(), this.getFlightDate().getMonth() + 1,
				this.getFlightDate().getDate());
		if (date.after(monthAfter)) {
			this.setFlightDate(date);
			this.setStatus("Delayed");
			return true;
		}
		return false;
	}

}
