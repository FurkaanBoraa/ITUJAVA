package lab7;

public class Gallery {
	private String galleryName;
	private Car[] cars;
	private int carCount;
	private int capacity;
	private Person galleryOwner;
	
	public Gallery(String galleryName, int capacity, Person galleryOwner) {
		this.galleryName = galleryName;
		this.capacity = capacity;
		this.galleryOwner = galleryOwner;
	}
	
	public boolean addCar(Car car) {
		if (capacity < carCount) {
			this.cars[carCount] = car;
			carCount++;
			return true;
		}
		return false;
	}
	public boolean searchCar(Car car) {
		for (int i = 0; i < cars.length; i++) {
			if(cars[i] == car)
				return true;
		}
		return false;
	}

	public Car searchCar(String plate) {
		for (int i = 0; i < cars.length; i++) {
			if(cars[i].getPlate() == plate)
				return cars[i];
		}
		return null;
	}
	
	public String introduceSelf() {
		return (galleryName + " is a gallery of "+galleryOwner+" with car number/capacity of " + carCount + "/"+capacity);
	}
	
	
	public String getGalleryName() {
		return galleryName;
	}

	public void setGalleryName(String galleryName) {
		this.galleryName = galleryName;
	}

	public Car[] getCars() {
		return cars;
	}

	public void setCars(Car[] cars) {
		this.cars = cars;
	}

	public int getCarCount() {
		return carCount;
	}

	public void setCarCount(int carCount) {
		this.carCount = carCount;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Person getGalleryOwner() {
		return galleryOwner;
	}

	public void setGalleryOwner(Person galleryOwner) {
		this.galleryOwner = galleryOwner;
	}
	
	
	
	
}
