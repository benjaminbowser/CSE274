import java.util.*;

public class HashDemo {
	public static <K, V> void displayMap(Map<K, V> map) {
		for (K key : map.keySet()) {
			System.out.printf("%10s-->%11s  %d%n", key, map.get(key), key.hashCode());
		}
	}

	public static <T> void displaySet(Set<T> set) {
		for (T item : set) {
			System.out.printf("%10s%n", item.toString());
		}
	}

	public static void demoHashMap() {
		Map<Student, Integer> map = new HashMap<>();

		System.out.printf("Map<Student, Integer> - %s%n", map.getClass().getName());
		Student s1 = new Student("Wiklanski", "555-55-5555");
		Student s2 = new Student("Wiklanski", "999-55-5555");
		Student s3 = new Student("Pierce", "111-11-5555");
		Student s4 = new Student("Pierce", "111-11-5555");
		Student s5 = new Student("Czajka", "888-88-8888");
		Student s6 = new Student("Browne", "999-99-9999");

		map.put(s1, 18);
		map.put(s2, 19);
		map.put(s3, 20);
		map.put(s4, 21);
		map.put(s5, 22);
		map.put(s6, 23);

		displayMap(map);
	}

	public static void demoHashSet() {
		Set<Student> map = new HashSet<>();

		System.out.printf("Map<Student, Integer> - %s%n", map.getClass().getName());
		Student s1 = new Student("Wiklanski", "555-55-5555");
		Student s2 = new Student("Wiklanski", "999-55-5555");
		Student s3 = new Student("Pierce", "111-11-5555");
		Student s4 = new Student("Pierce", "111-22-5555");
		Student s5 = new Student("Czajka", "888-88-8888");
		Student s6 = new Student("Browne", "999-99-9999");

		map.add(s1);
		map.add(s2);
		map.add(s1);
		map.add(s3);
		map.add(s4);
		map.add(s4);
		map.add(s5);
		map.add(s6);

		displaySet(map);
	}

	public static String randomString() {
		String result = "";
		int len = (int) (9 * Math.random()) + 1;
		for (int i = 0; i < len; i++) {
			result += (char) (26 * Math.random() + 'A');
		}
		return result;
	}

	public static void demoStringHashCode() {
		for (int i = 0; i < 50; i++) {
			String s = randomString();
			System.out.printf("%13s %15d%n", s, s.hashCode());
		}
	}

	public static void main(String[] args) {
		demoStringHashCode();
		demoHashMap();
		demoHashSet();
	}
}
