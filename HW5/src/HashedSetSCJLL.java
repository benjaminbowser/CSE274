// Benjamin Bowser
// CSE 274 UA
public class HashedSetSCJLL<T> implements SetInterface<Object> {
	private DataMember[] hashTable;

	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 5; // Must be prime
	private static final int MAX_CAPACITY = 200000;
	private static final int MAX_SIZE = 2 * MAX_CAPACITY;
	private static final double MAX_LOAD_FACTOR = 0.5; // Fraction of hash table
	private int tableSize; // Must be prime

	public HashedSetSCJLL() {
		this(DEFAULT_CAPACITY);
	}

	public HashedSetSCJLL(int size) {
		int tableSize = Utils.getNextPrime(size);
		checkSize(tableSize);
		hashTable = (DataMember[])new DataMember[size];
		numberOfEntries = 0;
	}

	private int getHashIndex(int hash) { // This is what we did on the sheet
		int index = hash % hashTable.length;
		return index;
	} // end getHashIndex


	@Override
	public int getCurrentSize() {
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public boolean add(Object newEntry) {
		if (isHashTableTooFull()) {
			enlargeHashTable();
		}

		int hash = newEntry.hashCode();
		int location = getHashIndex(hash);

		if (hashTable[location] == null) { // speed up time by only making LL for spaces that get occupied
			hashTable[location] = new DataMember();
			hashTable[location].addItem(newEntry);
			numberOfEntries++;
			return true;
		}

		// LL exists @ location
		if (hashTable[location] != null) {
			if (contains(newEntry)) {
				return false;
			}
			hashTable[location].addItem(newEntry);
			numberOfEntries++;
			return true;
		}
		return false;
	}

	@Override
	public boolean remove(Object anEntry) {
		int hash = anEntry.hashCode(); // get hashcode
		int location = getHashIndex(hash); // where it should be

		// Not even there
		if (!contains(anEntry)) {
			return false;
		}

		// It's there
		if (contains(anEntry)) {
			if (hashTable[location].removeItem(anEntry)) { // If it works
				numberOfEntries--;
				return true; // It worked
			}
		}
		return false;
	}

	@Override
	public void clear() {
		for (int i = 0; i < hashTable.length; i++) {
			hashTable[i] = null;
		}
		numberOfEntries = 0;
	}

	@Override
	public boolean contains(Object anEntry) {
		int hash = anEntry.hashCode(); // get hashcode
		int location = getHashIndex(hash); // where it should be
		if (hashTable[location] != null) {
			if (hashTable[location].getList().contains(anEntry)) {
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}

	@Override
	public Object[] toArray() {
		Object[] data = new Object[numberOfEntries];
		int next = 0;
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				for (int j = 0; j < hashTable[i].getList().size(); j++) {
					data[next] = hashTable[i].getList().get(j);
					next++;
				}
			}
		}
		return data;
	}

	private void enlargeHashTable() {
		DataMember[] oldTable = hashTable;
		int oldSize = hashTable.length;
		int newSize = Utils.getNextPrime(oldSize + oldSize);
		checkSize(newSize);
		tableSize = newSize;
		DataMember[] tempTable = new DataMember[newSize];

		// Increase size of array
		hashTable = tempTable;

		numberOfEntries = 0; // Reset number of dictionary entries, since
		// it will be incremented by add during rehash

		// Rehash dictionary entries from old array to the new and bigger array;
		// skip both null locations and removed entries

		for (int index = 0; index < oldSize; index++) {
			if ((oldTable[index] != null)) {
				int size = oldTable[index].getList().size();
				for (int i = 0; i < size; i++) {
					Object adder = oldTable[index].getList().get(i);
					add(adder);
				}
			}
		} // end for
	} // end enlargeHashTable


	// Returns true if lambda > MAX_LOAD_FACTOR for hash table;
	// otherwise returns false.
	private boolean isHashTableTooFull() {
		return numberOfEntries > MAX_LOAD_FACTOR * hashTable.length;
	} // end isHashTableTooFull

	private void checkSize(int size) {
		if (tableSize > MAX_SIZE)
			throw new IllegalStateException("Dictionary has become too large.");
	} // end checkSize

	public void displayHashTable() {
		for (int index = 0; index < hashTable.length; index++) {
			if (hashTable[index] == null) {
				System.out.println("null ");
			}
			else {
				System.out.println(hashTable[index].toString());
			}
		} // end for
		System.out.println();
	} // end displayHashTable


}