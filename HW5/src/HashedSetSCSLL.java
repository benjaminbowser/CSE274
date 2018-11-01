// Benjamin Bowser
// CSE 274 UA
public class HashedSetSCSLL<T extends Comparable<T>> implements SetInterface<T> {
	private DataMember2<T>[] hashTable;

	private int numberOfEntries;
	private static final int DEFAULT_CAPACITY = 5; // Must be prime
	private static final int MAX_CAPACITY = 200000;
	private static final int MAX_SIZE = 2 * MAX_CAPACITY;
	private static final double MAX_LOAD_FACTOR = 0.5; // Fraction of hash table
	private int tableSize; // Must be prime

	public HashedSetSCSLL() {
		this(DEFAULT_CAPACITY);
	}

	public HashedSetSCSLL(int size) {
		int tableSize = Utils.getNextPrime(size);
		checkSize(tableSize);
		hashTable = (DataMember2<T>[])new DataMember2[size];
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
	public boolean add(T newEntry) {
		if (isHashTableTooFull()) {
			enlargeHashTable();
		}

		int hash = newEntry.hashCode();
		int location = getHashIndex(hash);

		if (hashTable[location] == null) { // speed up time by only making LL for spaces that get occupied
			hashTable[location] = new DataMember2<T>();
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
	public boolean remove(T anEntry) {
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
	public boolean contains(T anEntry) {
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
		int next = 0;
		Object[] data = new Object[numberOfEntries]; // Unchecked cast
		for (int i = 0; i < hashTable.length; i++) {
			if (hashTable[i] != null) {
				for (int j = 0; j < hashTable[i].getList().size(); j++) {
					data[next] = hashTable[i].get(j);
					next++;
				}
			}
		}
		return data;
	}

	private void enlargeHashTable() {
		DataMember2<T>[] oldTable = hashTable;
		
		int oldSize = hashTable.length;
		int newSize = Utils.getNextPrime(oldSize + oldSize);
		checkSize(newSize);
		tableSize = newSize;
		
		DataMember2<T>[] tempTable = new DataMember2[newSize];

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
					T adder = oldTable[index].get(i);
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