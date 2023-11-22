package lab4;

public class Employee {
	private String essn;
	private double pricebyHour;
	private int workingYear;
	private boolean isRetired;
	

	public Employee(String essn, double pricebyHour, int workingYear, boolean isRetired) {
		this.essn = essn;
		this.pricebyHour = pricebyHour;
		this.workingYear = workingYear;
		this.isRetired = isRetired;
	}
	
	public boolean deserveBonus() {
		if(!getIsRetired()) {
			return workingYear>=10 ? true : false;
		}else {
			return false;
		}
	}
	
	public double calculateSalary(int workingHour, int workingDays) {
		return pricebyHour*workingHour*workingDays;
		
	}
	public void retiring() {
		if (workingYear>=20)
			setIsRetired(true);
	}

	public String getEssn() {
		return essn;
	}

	public void setEssn(String essn) {
		this.essn = essn;
	}

	public double getPricebyHour() {
		return pricebyHour;
	}

	public void setPricebyHour(double pricebyHour) {
		this.pricebyHour = pricebyHour;
	}

	public int getWorkingYear() {
		return workingYear;
	}

	public void setWorkingYear(int workingYear) {
		this.workingYear = workingYear;
		retiring();
	}

	public boolean getIsRetired() {
		return isRetired;
	}

	public void setIsRetired(boolean isRetired) {
		this.isRetired = isRetired;
	}
	
	
}
