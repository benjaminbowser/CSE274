// Benjamin Bowser
// CSE274 UA
import java.util.Arrays;

/**
 * A test of the methods add, toArray, isEmpty, and getCurrentSize, as defined
 * in the first draft of the class LinkedBag.
 * 
 * @author Frank M. Carrano
 * @version 4.0
 */
public class LinkedBagDemo1 {
	public static void main(String[] args) {
		
		BagInterface<String> aBag = new LinkedBag1<>();
		BagInterface<String> aBag2 = new LinkedBag1<>();
		LinkedBag1<String> aBag3 = new LinkedBag1<>();
		LinkedBag1<String> aBag4 = new LinkedBag1<>(); // 3 and 4 are the same as the first and second
														// but needed to use intersection

		testIsEmpty(aBag, true);
		displayBag(aBag);
		String[] contentsOfBag = {"A", "D", "B", "A", "C", "A", "D"};
		String[] secondList = {"C", "B", "E", "A", "D", "M", "H", "A"};
		
 		testAdd(aBag, contentsOfBag);
 		testAdd(aBag2, secondList);
 		testAdd(aBag3, contentsOfBag);
 		testAdd(aBag4, secondList);
		testIsEmpty(aBag, false);
		testIsEmpty(aBag2, false);
		
		System.out.println("Size of first bag: " + aBag.getCurrentSize());
		System.out.println("Size of second bag: " + aBag2.getCurrentSize());
		System.out.println();
		System.out.println("Adding entry X to first bag worked:" + aBag.add("X"));
		displayBag(aBag);
		System.out.println();
		System.out.println("Removing entry M from second bag worked: " + aBag2.remove("M"));
		displayBag(aBag2);
		System.out.println();
		System.out.println("The letter A occurs how many times in the first bag? " + aBag.getFrequencyOf("A"));
		System.out.println("The letter K occurs how many times in the second bag? " + aBag2.getFrequencyOf("K"));
		System.out.println();
		
		System.out.println();
		
		System.out.println("The first bag contains the letter P? " +aBag.contains("P"));
		System.out.println("The second bag contains the letter E? " +aBag2.contains("E"));
		
		System.out.println();
		
		System.out.println("An array of the first bag looks like: "+Arrays.deepToString(aBag.toArray()));
		System.out.println("An array of the second bag looks like: "+Arrays.deepToString(aBag2.toArray()));

		System.out.println("The intersection of the two bags is: " +Arrays.deepToString(aBag3.intersection(aBag4).toArray()));
		System.out.println();
		System.out.println("The first and first bag are the same? " +aBag.equals(aBag));
		System.out.println("The first and second bag are the same? " +aBag.equals(aBag2));
		System.out.println();
		System.out.println("Adding Z to the rear of the first bag worked? " +aBag.addRear("Z"));
		displayBag(aBag);
		
		System.out.println("The second bag will now be cleared.");
		aBag2.clear();
		displayBag(aBag2);
		
	} // end main

	// Tests the method isEmpty.
	// Precondition: If the bag is empty, the parameter empty should be true;
	// otherwise, it should be false.
	private static void testIsEmpty(BagInterface<String> bag, boolean empty) {
		System.out.print("\nTesting isEmpty with ");
		if (empty)
			System.out.println("an empty bag:");
		else
			System.out.println("a bag that is not empty:");

		System.out.print("isEmpty finds the bag ");
		if (empty && bag.isEmpty())
			System.out.println("empty: OK.");
		else if (empty)
			System.out.println("not empty, but it is: ERROR.");
		else if (!empty && bag.isEmpty())
			System.out.println("empty, but it is not empty: ERROR.");
		else
			System.out.println("not empty: OK.");
	} // end testIsEmpty

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
} // end LinkedBagDemo1