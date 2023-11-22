package lab4;



public class TestEmployee {
	public static void main(String[] args) {
		Employee employee1 = new Employee("5412648", 12, 14, false);
		
		System.out.println("Does employee with essn:" + employee1.getEssn() +" deserving a bonus? " + employee1.deserveBonus());
		employee1.calculateSalary(8, 4);
		employee1.setWorkingYear(21);
		System.out.println("Does employee with essn:" + employee1.getEssn() +" meet criteria for retirement? " +employee1.getIsRetired());
		
	}
}
