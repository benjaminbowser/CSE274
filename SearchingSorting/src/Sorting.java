public class Sorting {
	private static <T extends Comparable<? super T>> int indexOfSmallest(T[] ary, int start) {
		int smallIndex = start;
		for (int i = start + 1; i < ary.length; i++) {
			if (ary[i].compareTo(ary[smallIndex]) < 0) {
				smallIndex = i;
			}
		}
		return smallIndex;
	}

	/**
	 * Sorts an array
	 * 
	 * @param ary
	 *            Array to be sorted
	 */
	public static <T extends Comparable<? super T>> void selectionSort(T[] ary) { // BEST O(N^2) WORST O(N^2)
		for (int i = 0; i < ary.length - 1; i++) {
			int smallest = indexOfSmallest(ary, i);
			T tmp = ary[i];
			ary[i] = ary[smallest];
			ary[smallest] = tmp;
		}
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] ary) { // BEST O(N) WORST O(N^2)
		int j;
		for (int i = 0; i < ary.length; i++) {
			T v = ary[i];
			for (j = i - 1; j >= 0; j--) {
				if (ary[j].compareTo(v) < 0) {
					break;
				}
				ary[j + 1] = ary[j];
			}
			ary[j + 1] = v;
		}
	}

	private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tmp, int left, int right) { // Divide & Conquer
		// BEST O(nlogn) WORST O(NlogN) faster than N^2
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(a, tmp, left, mid);
			mergeSort(a, tmp, mid + 1, right);
			merge(a, tmp, left, mid + 1, right);
		}
	}

	public static <T extends Comparable<? super T>> void mergeSort(T[] a) { // NlogN avg
		int len = a.length;
		@SuppressWarnings("unchecked")
		T[] tmp = (T[]) new Comparable<?>[len];
		mergeSort(a, tmp, 0, len - 1);
	}

	private static <T extends Comparable<? super T>> void merge(T[] a, T[] tmp, int leftPos, int rightPos,
			int rightEnd) {
		int leftEnd = rightPos - 1;
		int tmpPos = leftPos;
		int numElements = rightEnd - leftPos + 1;

		while (leftPos <= leftEnd && rightPos <= rightEnd)
			if (a[leftPos].compareTo(a[rightPos]) < 0)
				tmp[tmpPos++] = a[leftPos++];
			else
				tmp[tmpPos++] = a[rightPos++];

		while (leftPos <= leftEnd)
			tmp[tmpPos++] = a[leftPos++];

		while (rightPos <= rightEnd)
			tmp[tmpPos++] = a[rightPos++];

		for (int i = 0; i < numElements; i++, rightEnd--) {
			a[rightEnd] = tmp[rightEnd];
		}
	}

	public static <T extends Comparable<? super T>> void quickSort(T[] ary) { // The pivot BEST O(NlogN) WORST O(N^2)
		quickSort(ary, 0, ary.length - 1);
	}

	public static <T extends Comparable<? super T>> void quickSort(T[] ary, int from, int to) {
		if (from >= to)
			return;
		int p = partition(ary, from, to);
		quickSort(ary, from, p);
		quickSort(ary, p + 1, to);
	}

	private static <T extends Comparable<? super T>> int partition(T[] a, int from, int to) {
		T pivot = a[from];
		int i = from - 1;
		int j = to + 1;
		while (i < j) {
			i++;
			while (a[i].compareTo(pivot) < 0)
				i++;
			j--;
			while (a[j].compareTo(pivot) > 0)
				j--;
			if (i < j) {
				T tmp = a[i];
				a[i] = a[j];
				a[j] = tmp;
			}
		}
		return j;
	}
}
