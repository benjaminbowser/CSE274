import java.util.Arrays;


public class SortedListTests {

	public static Integer[] getIntegerArray(int len) {
		Integer[] result = new Integer[len];
		for (int i = 0; i < len; i++) {
			result[i] = (int) (Math.random() * 10);
		}
		return result;
	}

	public static boolean check(int len) {
		SortedList<Integer> sortedList = new SortedList<>();
		Integer[] originalItems = getIntegerArray(len);
		for (int item : originalItems) {
			sortedList.add(item);
		}
		Arrays.sort(originalItems);
		Comparable<Integer>[] slOutput = sortedList.toArray(); // T [] slOutput
																// causes errors
		return Arrays.equals(originalItems, slOutput);
	}
	
	public static void main(String args[]) {

		SortedList test = new SortedList();
		test.add("HEY");
		
		
	}
	
	

}
