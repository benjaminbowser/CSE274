// Benjamin Bowser
// CSE 274 UA
import java.util.LinkedList;

public class DataMember {
	private LinkedList<Object> list;

	public DataMember() {
		list = new LinkedList<Object>();
	}
	
	public LinkedList getList() {
		return list;
	}

	public void addItem(Object newEntry) {
		list.add(newEntry);
	}

	public boolean removeItem(Object anEntry) {
		if (list.remove(anEntry)) {
			return true;
		}
		return false;
	}

	public boolean contains(Object anEntry) {
		if (location(anEntry) != -1) {
			return true;
		}
		return false;
	}
	
	public int location(Object anEntry) {
		int loc = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == anEntry) {
				return loc;
			}
		}
		return loc;
	}
	
	public String toString() {
		return list.toString();
	}
	
}
