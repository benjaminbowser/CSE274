// Benjamin Bowser
// CSE274 UA
public class LinkedSetTester {

	public static void main(String[] args) {
		LinkedSet<String> tester = new LinkedSet<>();
		System.out.println("Adding to linked set...");
		tester.add("One");
		tester.add("two");
		tester.add("three");
		tester.add("four");
		tester.add("five");
		printer(tester);
		
		System.out.println("Current set capacity: "+tester.getCapacity());
		System.out.println("Trying to remove value called One: " +tester.remove("One"));
		System.out.println("Trying to remove value called eighty: " + tester.remove("eighty"));
		
		System.out.println();
		System.out.println("Current List:");
		printer(tester);
		System.out.println();
		
		System.out.println("Does the set contain a value called two? " + tester.contains("two"));
		System.out.println("Does the set contain a value called forty? " + tester.contains("forty"));
		System.out.println("Does the set contain a value called One? " + tester.contains("One"));
		
		System.out.println("Trying to remove value called three: " + tester.remove("three"));
		System.out.println();
		System.out.println("Current List:");
		printer(tester);
		System.out.println();

		System.out.println("Is the set empty? " +tester.isEmpty());
		System.out.println("Current set size: "+tester.getCurrentSize());
		
		System.out.println("Clearing the set"); 
		tester.clear();
		System.out.println("Is the set empty? " +tester.isEmpty());
		System.out.println("Current set size: "+tester.getCurrentSize());
		
		printer(tester);
	}
	public static <T> void printer(LinkedSet<T> item) { // Loop to print our results
		Object[] printer = item.toArray();

		for (int i = 0; i < printer.length; i++) {
			System.out.println(printer[i]);
		}
	}
}