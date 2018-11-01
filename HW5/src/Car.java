// Benjamin Bowser
// CSE 274 UA
public class Car implements Comparable<Object> {

	private int year;
	private String make;
	private String model;
	private String color;

	public Car(int year, String make, String model, String color) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.color = color;
	}

	public int getYear() {
		return year;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public boolean equals(Object o) {
		boolean reply = false;
		if ((o == null) || (getClass() != o.getClass())) {
			reply = false;
		}
		else {
			Car second = (Car) o;
			reply = year == second.year && make.equals(second.make) && model.equals(second.model) && color.equals(second.color);
		}
		return reply;
	}

	public int hashCode() // For testing--causes collisions ***************
	{
		int stringHash = make.hashCode() * model.hashCode() * color.hashCode();
		int yearHash = year * 13;
		int reply = Math.abs(stringHash + yearHash); 
		return reply;
	}

	@Override
	public int compareTo(Object o) {
		Car data = (Car) o;
		
		if (this.year != data.year) {
			return this.year - data.year;
		}
		if (this.make != data.make) {
			return this.make.compareTo(data.make);
		}
		if (this.model != data.model) {
			return this.model.compareTo(data.model);
		}
		return 0;
	}
	
	public String toString() {
		return year + " " + make + " " + model + " " + color;
	}
	
}
