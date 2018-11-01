public class Person implements Comparable<Person> {
	private String lastName, firstName;
	private int age;

	public Person(String firstName, String lastName, int age) {
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int compareTo(Person p) {
		int code;
		int nameComparison = lastName.compareTo(p.lastName);
		if (nameComparison != 0) {
			code = nameComparison;
		} else {
			code = age - p.age;
		}
		return code;
	}

	@Override
	public String toString() {
		return String.format("%s, %s (%d)", lastName, firstName, age);
	}
}
