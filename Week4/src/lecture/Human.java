package lecture;

public class Human {
	private int age;
	private String name;

	public Human(){
		this.setAge(-1);
		this.setName("noname");
	}	
	
	public Human(int age, String name) {
		this.setAge(age);
		this.setName(name);
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	

	
}
