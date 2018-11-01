
public class Student implements Comparable<Student> {
	private String lastName;
	private String ssn;

	public Student(String lastName, String ssn) {
		this.ssn = ssn;
		this.lastName = lastName;
	}

	public Student(Student other) {
		this(other.lastName, other.ssn);
	}

	public String getSSN() {
		return ssn;
	}

	public String getName() {
		return lastName;
	}

	public String toString() {
		return String.format("%10s %10s", lastName, ssn);
	}

	public int compareTo(Student other) {
		int nameComp = lastName.compareTo(other.lastName);
		if (nameComp != 0) {
			return nameComp;
		} else {
			return ssn.compareTo(other.ssn);
		}
	}
}
