/**
 * A test of the constructors and the methods add and toArray, as defined in the
 * first draft of the class ArrayBag.
 * 
 * @author Frank M. Carrano
 * @version 4.0
 */
public class ArrayBagDemo1 {
	public static void main(String[] args) {
		// Adding to an initially empty bag with sufficient capacity
		System.out.println("Testing an initially empty bag with " + " the capacity to hold at least 6 strings:");
		BagInterface<String> aBag = new ArrayBag1<>();
		String[] contentsOfBag1 = { "A", "A", "B", "A", "C", "A", "H" };
		testAdd(aBag, contentsOfBag1);

		System.out.println("Bag is empty: " + aBag.isEmpty());
		System.out.println("Current bag size: " + aBag.getCurrentSize());

		System.out.println("B was removed from the bag: " + aBag.remove("B"));
		System.out.println("Z was removed from the bag: " + aBag.remove("Z"));

		displayBag(aBag);

		System.out.println("Removing an entry : " + aBag.remove());

		displayBag(aBag);
		
		System.out.println("The letter A occurs in the string " + aBag.getFrequencyOf("A") + " times.");
		System.out.println("The letter M occurs in the string " + aBag.getFrequencyOf("M") + " times.");
		
		
		System.out.println("The bag contains the letter A: " + aBag.contains("A"));
		System.out.println("The bag contains the letter M: " + aBag.contains("M"));
		
		System.out.println("The bag will now be cleared.");
		aBag.clear();
		
		
		// Filling an initially empty bag to capacity
		System.out.println("\nTesting an initially empty bag that " + " will be filled to capacity:");
		aBag = new ArrayBag1<>(7);
		String[] contentsOfBag2 = { "A", "B", "A", "C", "B", "C", "D", "another string" };
		testAdd(aBag, contentsOfBag2);
		
		System.out.println("Bag is empty: " + aBag.isEmpty());
		System.out.println("Current bag size: " + aBag.getCurrentSize());

		System.out.println("C was removed from the bag: " + aBag.remove("C"));
		System.out.println("Z was removed from the bag: " + aBag.remove("Z"));

		displayBag(aBag);

		System.out.println("Removing an entry : " + aBag.remove());

		displayBag(aBag);
		
		System.out.println("The letter A occurs in the string " + aBag.getFrequencyOf("A") + " times.");
		System.out.println("The letter S occurs in the string " + aBag.getFrequencyOf("S") + " times.");
		
		System.out.println("The bag contains the letter A: " + aBag.contains("A"));
		System.out.println("The bag contains the letter S: " + aBag.contains("S"));
		
		System.out.println("The bag will now be cleared.");
		aBag.clear();

	} // end main

	// Tests the method add.
	private static void testAdd(BagInterface<String> aBag, String[] content) {
		System.out.print("Adding the following " + content.length + " strings to the bag: ");
		for (int index = 0; index < content.length; index++) {
			if (aBag.add(content[index]))
				System.out.print(content[index] + " ");
			else
				System.out.print("\nUnable to add " + content[index] + " to the bag.");
		} // end for
		System.out.println();

		displayBag(aBag);
	} // end testAdd

	// Tests the method toArray while displaying the bag.
	private static void displayBag(BagInterface<String> aBag) {
		System.out.println("The bag contains the following string(s):");
		Object[] bagArray = aBag.toArray();
		for (int index = 0; index < bagArray.length; index++) {
			System.out.print(bagArray[index] + " ");
		} // end for

		System.out.println();
	} // end displayBag
} // end ArrayBagDemo1
/*
 * Testing an initially empty bag with sufficient capacity: Adding the following
 * 6 strings to the bag: A A B A C A The bag contains the following string(s): A
 * A B A C A
 * 
 * Testing an initially empty bag that will be filled to capacity: Adding the
 * following 8 strings to the bag: A B A C B C D Unable to add another string to
 * the bag. The bag contains the following string(s): A B A C B C D
 */