
public class Course implements Comparable<Course> {
	private String name;

	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name;
	}

	public int compareTo(Course other) {
		return name.compareTo(other.name);
	}
}
