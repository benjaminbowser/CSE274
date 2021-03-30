// Benjamin Bowser
// CSE274 UA

/**
 * A class of bags whose entries are stored in a chain of linked nodes. The bag
 * is never full.
 * 
 * @author Frank M. Carrano
 * @version 4.0
 */
/*
 * Question #1: 
 * BagInterface<String> myBag = new LinkedBag1<>();
	myBag.add("30");
	myBag.add("40");
	myBag.add("10");
	myBag.add("20");
	Object[] entries = myBag.toArray();
	for (int index = 0; index < entries.length; index++)
		System.out.print(entries[index] + " ");

 *     OUTPUT: 20 10 40 30
 *      
 *  Question #3:
 *  
 *  public void add(T newEntry) {
 *  Node newNode = new Node(newEntry, null, firstNode);
 *  if (numberOfEntries = 0) {
 *  previousNode = newNode;
 *  }
 *  else {
 *  	firstNode.prev = newNode
 *  firstNode = newNode;
 *  }
 *   numberOfEntries++;
 *  }
 *  
 *  
 *  public boolean remove() {
 *  if (firstNode.next == null) {
 *  	return false;
 *  }
 *  else {
 *  firstNode.prev = null;
 * return true;
 *  }
 *  }
 *  
 */
public final class LinkedBag1<T> implements BagInterface<T> {
	private class Node {
		private T data; // Entry in bag
		private Node next; // Link to next node

		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor
	} // end Node

	private Node firstNode; // Reference to first node
	private int numberOfEntries;

	public LinkedBag1() {
		firstNode = null;
		numberOfEntries = 0;
	} // end default constructor

	/**
	 * Adds a new entry to this bag.
	 * 
	 * @param newEntry
	 *            The object to be added as a new entry.
	 * @return True.
	 */
	public boolean add(T newEntry) // OutOfMemoryError possible
	{
		// Add to beginning of chain:
		Node newNode = new Node(newEntry);
		newNode.next = firstNode; // Make new node reference rest of chain. 
		// (firstNode is null if chain is empty)
		firstNode = newNode; // New node is at beginning of chain!!!!!!!
		numberOfEntries++;

		return true;
	} // end add

	/**
	 * Retrieves all entries that are in this bag.
	 * 
	 * @return A newly allocated array of all the entries in this bag.
	 */
	public T[] toArray() {
		// The cast is safe because the new array contains null entries.
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast

		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		} // end while

		return result;
		// Note: The body of this method could consist of one return statement,
		// if you call Arrays.copyOf
	} // end toArray

	/**
	 * Sees whether this bag is empty.
	 * 
	 * @return True if the bag is empty, or false if not.
	 */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty

	/**
	 * Gets the number of entries currently in this bag.
	 * 
	 * @return The integer number of entries currently in the bag.
	 */
	public int getCurrentSize() {
		return numberOfEntries;
	} // end getCurrentSize

	/**
	 * Removes one unspecified entry from this bag, if possible.
	 * 
	 * @return Either the removed entry, if the removal was successful, or null.
	 */
	
	public T remove() {
		T result = null; // in case of 0, gives a return
		if (numberOfEntries > 0) { // Empty bag avoidance. If this is 1, final result points to null
			numberOfEntries--; // Drop our entry count
			result = firstNode.data; // Point to the first node removed for return
			firstNode = firstNode.next; // Set first node to the second node
		}
		return result;
	} // end remove

	/**
	 * Removes one occurrence of a given entry from this bag.
	 * 
	 * @param anEntry
	 *            The entry to be removed.
	 * @return True if the removal was successful, or false otherwise.
	 */
	public boolean remove(T anEntry) {
		boolean worked = false;
		Node currentNode = find(anEntry); // remove one
		
		if (currentNode != null) { // avoid nullpointer
			currentNode.data = firstNode.data;
			firstNode = firstNode.next;
			worked = true;
			
			numberOfEntries--;
			return worked; // stop when found
		}
		return worked;
	} // end remove

	/** Removes all entries from this bag. */
	public void clear() {
		numberOfEntries = 0;
		firstNode = null;
		// The rest of the elements are still there, but they're garbage
		// OR you can do this to actually remove all of them:

		// for (int i = 0; i < numberOfEntries; i++) {
		//	remove();
		//}

	} // end clear

	/**
	 * Counts the number of times a given entry appears in this bag.
	 * 
	 * @param anEntry
	 *            The entry to be counted.
	 * @return The number of times anEntry appears in the bag.
	 */
	public int getFrequencyOf(T anEntry) { // MEMORIZE THIS CONCEPT
		int cnt = 0;
		Node curr = firstNode;
		while (curr != null) {
			if (curr.data.equals(anEntry)){ 
				cnt++;
				curr = curr.next;
			}
			else {
				curr = curr.next;
			}
		}
		return cnt;
	} // end getFrequencyOf

	/**
	 * Tests whether this bag contains a given entry.
	 * 
	 * @param anEntry
	 *            The entry to locate.
	 * @return True if the bag contains anEntry, or false otherwise.
	 */
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		}
		return found;
	} // end contains

	private Node find(T anEntry) {
		Node currentNode = firstNode;

		while (currentNode != null) {
			if (anEntry.equals(currentNode.data)) {
				return currentNode;
			}
			else {
				currentNode = currentNode.next;
			}
		}
		return null; // not found
		// While loop like above
	}

	/**
	 * Adds an element to the rear
	 * @param anEntry An entry to add
	 * @return True if adding was successful
	 */
	public boolean addRear(T anEntry) {
		boolean worked = false;
		Node currentNode = firstNode; 

		if (currentNode == null) { // If empty
			currentNode = new Node(anEntry);
			worked = true; //Add in front due to empty
		}
		while (currentNode.next != null) {
			currentNode = currentNode.next; // iterate thru
		} // breaks when null

		currentNode.next = new Node(anEntry);
		worked = true; // added to the end
		numberOfEntries++;
		
		return worked; 
	}
	/**
	 * Checks if both bags have the same elements
	 * @param other LinkedBag1<T>
	 * @return True if both bags contain the same elements
	 */
	public boolean equals(LinkedBag1<T> other) {
		boolean equal = false;
		int firstCount = 0, secondCount = 0;

		T[] original = this.toArray();
		T[] compare = other.toArray();

		if (original.length != compare.length) { // Different lengths
			return equal;
		}
		// Go through both elements separately 
		for (int i = 0; i < original.length; i++) {
			for (int j = 0; j < compare.length; j++) {
				if (original[i].equals(compare[j])) {
					firstCount++;
				}
			}
		}
		for (int i = 0; i < compare.length; i++) {
			for (int j = 0; i < original.length; j++) {
				if (compare[i].equals(original[j])) {
					secondCount++;
				}
			}
		}
		if (original.length == firstCount) { // if counts equal length
			if (compare.length == secondCount) { // all elements found in both
				equal = true;
			}
		}
		return equal;
	}
	/**
	 * Returns the intersection of two LinkedBag's
	 * @param other LinkedBag1<T>
	 * @return LinkedBag1<T> 
	 */
	public LinkedBag1<T> intersection(LinkedBag1<T> other) {
		LinkedBag1<T> updated = new LinkedBag1<>();
		T[] original = this.toArray();
		T[] compare = other.toArray();
		int count = 0;

		// Similar loop as equals had
		for (int i = 0; i < original.length; i++) {
			count = 0; // reset for each letter
			for (int j = 0; j < compare.length; j++) {
				if (original[i].equals(compare[j])) {
					count++;
				}
			}
			if (count > 0) { // Do not add duplicates
				if (updated.contains(original[i]) == false) { 
					updated.add(original[i]);
				}
			}
		}
		return updated;
	}
	/**
	 * Removes all elements from bag
	 * @param anEntry An entry to locate
	 * @return True if all entries were removed, false if fail
	 */
	public boolean removeAll(T anEntry) {
		boolean worked = false; 
		while (find(anEntry)!= null) { //null if DNE
			remove(anEntry); // keep running for several cases
			worked = true;
		}
		return worked;
	}
} // end LinkedBag1
