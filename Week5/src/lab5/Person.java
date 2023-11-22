package lab5;

public class Person {
	private String name;
	private String tcNo;
	private Aquarium aquarium;
	private Cat cat;

	public Person(String name, String tcNo) {
		this.name = name;
		this.tcNo = tcNo;
	}
	
	public void introduceYourself() {
		if(this.aquarium !=null) {
			if(this.cat !=null) {
				System.out.println("Hello there, my name is " + this.name + " I have an aquarium with " +  this.aquarium.getNumberFish() + " fish and a cat named " + this.cat.getName());
			}else {
				System.out.println("Hello there, my name is " + this.name + " I have an aquarium with " +  this.aquarium.getNumberFish() + " fish");
			}
		}else if(this.cat != null) {
			System.out.println("Hello there, my name is " + this.name + " I have a cat named " +  this.cat.getName());
		}else {
			System.out.println("Hello there, my name is " + this.name + " and I have no pets");
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTcNo() {
		return tcNo;
	}

	public void setTcNo(String tcNo) {
		this.tcNo = tcNo;
	}

	public Aquarium getAquarium() {
		return aquarium;
	}

	public void setAquarium(Aquarium aquarium) {
		this.aquarium = aquarium;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}
	
	



}
