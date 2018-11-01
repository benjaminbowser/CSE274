import java.util.*;

public class MapDemo {
	public static <K, V> void displayMap1(Map<K, V> map) {
		for (K key : map.keySet()) {
			System.out.printf("%10s-->%11s%n", key, map.get(key));
		}
	}

	public static <K, V> void displayMap2(Map<K, V> map) {
		for (Map.Entry<K, V> item : map.entrySet()) {
			System.out.printf("%10s-->%11s%n", item.getKey(), item.getValue());
		}
	}

	public static void demoStringKeys() {
		TreeMap<String, Integer> ages = new TreeMap<>();

		System.out.printf("Map<Student, Integer> - %s%n", ages.getClass().getName());
		ages.put("Hannah", 16);
		ages.put("Abby", 13);
		ages.put("Mitch", 14);
		ages.put("Matt", 20);
		displayMap2(ages);
	}

	public static void demoStudentKeys() {
		Map<Student, Integer> map = new TreeMap<>();

		System.out.printf("Map<Student, Integer> - %s%n", map.getClass().getName());
		Student s1 = new Student("Valentini", "555-55-5555");
		Student s2 = new Student("Wiklanski", "222-22-2222");
		Student s3 = new Student("Pierce", "111-11-1111");
		Student s4 = new Student("Hinojosa", "666-66-6666");
		Student s5 = new Student("Czajka", "888-88-8888");
		Student s6 = new Student("Browne", "999-99-9999");

		map.put(s1, 18);
		map.put(s2, 19);
		map.put(s3, 20);
		map.put(s4, 21);
		map.put(s5, 22);
		map.put(s6, 23);

		map.put(s4, map.get(s4) + 1);
		map.put(s4, 25);
		map.remove(s3);

		displayMap1(map);
	}

	public static void demoCourseKeys() {
		Map<Course, TreeSet<Student>> map = new TreeMap<>();

		System.out.printf("Map<Course, TreeSet<Student>> - %s%n", map.getClass().getName());

		Course c174 = new Course("CSE174");
		Course c101 = new Course("CEC101");
		Course c111 = new Course("ENG111");

		Student s1 = new Student("Valentini", "555-55-5555");
		Student s2 = new Student("Wiklanski", "222-22-2222");
		Student s3 = new Student("Pierce", "111-11-1111");
		Student s4 = new Student("Hinojosa", "666-66-6666");
		Student s5 = new Student("Czajka", "888-88-8888");
		Student s6 = new Student("Browne", "999-99-9999");

		map.put(c174, new TreeSet<>());
		map.put(c101, new TreeSet<>());
		map.put(c111, new TreeSet<>());

		map.get(c174).add(s1);
		map.get(c174).add(s5);
		map.get(c174).add(s6);

		map.get(c101).add(s4);
		map.get(c101).add(s5);
		map.get(c101).add(s5);
		map.get(c101).add(s6);

		map.get(c111).add(s1);
		map.get(c111).add(s3);
		map.get(c111).add(s4);

		displayMap1(map);
	}

	public static void main(String[] args) {
		demoStringKeys();
		demoStudentKeys();
		demoCourseKeys();
	}
}
