public class Searching {
	/**
	 * Searches an unsorted array for a value.
	 * 
	 * @param ary
	 *            array to be searched
	 * @param key
	 *            value to be found
	 * @return first index in ary where key is found, -1 if key is not in ary.
	 */
	public static <T extends Comparable<? super T>> int linearSearch(T[] ary, T key) {
		for (int i = 0; i < ary.length; i++) {
			if (ary[i].compareTo(key) == 0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Searches an sorted array for a value.
	 * 
	 * @param ary
	 *            array to be searched
	 * @param key
	 *            value to be found
	 * @return first index in ary where key is found, -insertionPoint-1 if key
	 *         is not in ary.
	 */
	public static <T extends Comparable<? super T>> int linearSearchOfSortedArray(T[] ary, T key) {
		int i;
		for (i = 0; i < ary.length && ary[i].compareTo(key) <= 0; i++) {
			if (ary[i].compareTo(key) == 0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Searches an sorted array for a value.
	 * 
	 * @param ary
	 *            array to be searched
	 * @param key
	 *            value to be found
	 * @return index, not necessarily the first, in ary where key is found, -1
	 *         if key is not in ary.
	 */
	public static <T extends Comparable<? super T>> int binarySearch(T[] ary, T key) {
		int n = ary.length;
		int lo = 0;
		int hi = n - 1;
		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			int comp = ary[mid].compareTo(key);
			if (comp == 0)
				return mid;
			else if (comp < 0)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		// lo and hi have passed each other
		return -1;
	}

	/**
	 * Searches an sorted array for a value.
	 * 
	 * @param ary
	 *            array to be searched
	 * @param key
	 *            value to be found
	 * @return index, not necessarily the first, in ary where key is found, -1
	 *         if key is not in ary.
	 */
	public static <T extends Comparable<? super T>> int recursiveBinarySearch(T[] ary, int lo, int hi, T key) {
		int v = -1;
		if (lo <= hi) {
			int mid = (lo + hi) / 2;
			int comp = key.compareTo(ary[mid]);
			if (comp == 0)
				v = mid;
			else if (comp < 0)
				v = recursiveBinarySearch(ary, lo, mid - 1, key);
			else
				v = recursiveBinarySearch(ary, mid + 1, hi, key);
		}
		return v;
	}

	public static <T extends Comparable<? super T>> int recursiveBinarySearch(T[] ary, T key) {
		int n = ary.length;
		return recursiveBinarySearch(ary, 0, n - 1, key);
	}
}