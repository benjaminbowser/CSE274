// hashCode should [ideally] return integers spread across the range of integer values
// hashCode should return the same hashCode for objects that are considered equal
// hashCode should return the same value for the same object, if called twice in the same execution.
// hashCode should return the same value for objects that are considered equals (via equals()).
// if you override equals, you should 
// When defining your custom class, you should define both hashCode and equals (if you do at all).
// hashCode should be fast to compute
public class Student {
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

	/**/
	public boolean equals(Object other) {
		if (!(other instanceof Student)) {
			return false;
		} else {
			Student otherStudent = (Student) other;
			return ssn.equals(otherStudent.ssn) && lastName.equals(otherStudent.lastName);
		}
	}

	public int hashCode() {
		return lastName.hashCode() >> 8 ^ ssn.hashCode();
	}
	/**/
	/*
	 * public boolean equals(Object other) { if (other instanceof Student) {
	 * return false; } else { Student otherStudent = (Student)other; return
	 * ssn.equals(otherStudent.ssn) && lastName.equals(otherStudent.lastName); }
	 * } public int hashCode() { return ssn.substring(7).hashCode(); }
	 */
	/*
	 * Wonky stuff here public boolean equals(Object other) { return false; }
	 * public int hashCode() { return ssn.substring(7).hashCode(); }
	 */
}
