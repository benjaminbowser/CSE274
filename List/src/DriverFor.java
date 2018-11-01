
/**
 * A driver that demonstrates the for-each statement with a class, such as
 * LinkedListWithIterator, that implements Iterable. Note that
 * LinkedListWithIterator implements Iterable because ListWithIteratorInterface
 * extends Iterable.
 * 
 * @author Frank M. Carrano
 * @author Timothy M. Henry
 * @version 4.0
 */
import java.util.*;

public class DriverFor {
	public static void main(String[] args) {
		ArrayListWithIterator<Integer> integerList = new ArrayListWithIterator<>();
		integerList.add(16);
		integerList.add(4);
		integerList.add(33);
		integerList.add(27);

		for (Integer entry : integerList)
			System.out.print(entry + " ");
		System.out.println();

		Iterator<Integer> iter = integerList.iterator();
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();

		ListWithIteratorInterface<String> nameList = new LinkedListWithIterator<>();
		nameList.add("Joe");
		nameList.add("Jess");
		nameList.add("Josh");
		nameList.add("Joy");

		for (String name : nameList)
			System.out.print(name + " ");
		System.out.println();
	} // end main
} // end DriverFor

/*
 * 16 4 33 27 Joe Jess Josh Joy
 */