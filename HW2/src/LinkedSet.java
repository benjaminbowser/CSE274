// Benjamin Bowser
// CSE274 UA
public class LinkedSet<T> {
	private class DLNode {
		public T data;
		public DLNode prev, next;

		// Can add constructors and other methods
		public DLNode(T dataValue, DLNode PREV, DLNode NEXT) {
			data = dataValue;
			prev = PREV;
			next = NEXT;
		}
	}

	private DLNode head;
	private int numberOfEntries;
	private boolean initialized = false;

	public LinkedSet() {
		head = null;
		initialized = true;
	}
	// Add at beginning of linked list
	public boolean add(T newEntry) {
		boolean worked = false;
		DLNode newNode = new DLNode(newEntry, null, head);
		if (head != null) {
			head.prev = newNode;
			worked = true;
		}
		head = newNode;
		numberOfEntries++;

		return worked;
	}

	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast

		int index = 0;
		DLNode currentNode = head;
		while ((index < numberOfEntries) && (currentNode != null)) {
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		} // end while

		return result;
	}
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	public int getCurrentSize() {
		return numberOfEntries;
	}
	public boolean contains(T anEntry) {
		boolean found = false;
		DLNode search = new DLNode(anEntry, null, null);
		DLNode currentNode = head;

		while (!found && (currentNode != null)) {
			if (search.data.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		}
		return found;
	}
	public void clear() {
		numberOfEntries = 0;
		head = null;
	}

	public DLNode find(T anEntry) // Adapted from Linkedbag
	{
		if (contains(anEntry) == false) {
			return null;
		}
		DLNode current = head;
		while (current != null)
		{
			if (current.data.equals(anEntry))
			{
				return current;
			}
			else
			{
				current = current.next;
			}
		}
		return null;
	}
	
	public boolean remove(T anEntry) {
		DLNode removed = find(anEntry);
		boolean found = false;

		if (removed == null) { // DNE
			return found;
		}

		if (removed.prev == null) {  // item @ start
			if (head != null) {
				head = head.next;

				if (head != null) { // still not null
					head.prev = null;
				}
				numberOfEntries--;
				found = true;
			}
			return found;
		}

		else if (removed.next == null) { // item @ end
			removed.data = null;
			numberOfEntries--;
			found = true;
		}

		else if (removed != null) { // all else
			removed = removed.next;

			if (removed != null) {
				removed.prev = removed.prev.prev;
				removed.prev.next = removed;
			}
			numberOfEntries--;
			found = true;
			return found;
		}
		return found;
	}

	private void checkInitialization() {
		System.out.println(initialized);
	}
	
	// Don't change this.
	public int getCapacity() {
		return numberOfEntries;
	}
}
