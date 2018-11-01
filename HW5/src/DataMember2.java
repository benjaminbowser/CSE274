// Benjamin Bowser
// CSE 274 UA
public class DataMember2<T extends Comparable<T>> {
	private SortedList<T> list;

	public DataMember2() {
		list = new SortedList<T>();
	}
	
	public SortedList<T> getList() {
		return list;
	}

	public void addItem(T newEntry) {
		list.add(newEntry);
	}

	public boolean removeItem(T anEntry) {
		if (list.remove(anEntry)) {
			return true;
		}
		return false;
	}

	public boolean contains(T anEntry) {
		return list.contains(anEntry);
	} // end contains
		
	
	public int location(T anEntry) {
		int loc = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.search(i) == anEntry) {
				return loc;
			}
		}
		return loc;
	}
	
	public String toString() {
		return list.toString();
	}
	
	public int size() {
		return list.size();
	}
	
	public T get(int loc) {
		return list.search(loc);
	}
	
}
