// ADTUse.java

import java.math.BigInteger;
import java.util.*;

public class ADTUse {
	public static void exercise(Set<String> items) {
		System.out.println("***********");
		items.add("Fred");
		items.add("Frank");
		items.add("fred");
		items.add("frank");
		items.add("fred");
		items.add("Sarah");
		items.add("sarah");
		items.remove("fred");
		for (String s : items) {
			System.out.println(s);
		}
		System.out.println("Size: " + items.size());
		items.clear();
		System.out.println("Size: " + items.size());
	}

	public static void main(String[] args) {
		BigInteger b1 = new BigInteger("123456789");
		BigInteger b2 = b1.pow(50);
		int x = 123456789;
		System.out.println(b2);
		System.out.println(Math.pow(x, 50));
		
		HashSet<String> hsItems = new HashSet<>();
		exercise(hsItems);
		TreeSet<String> tsItems = new TreeSet<>();
		exercise(tsItems);
	}

}
