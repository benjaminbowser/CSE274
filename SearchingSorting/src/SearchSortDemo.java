// Benjamin Bowser
// CSE 274 UA
import java.util.*;

/*
 * 2
 * A True
 * B True
 * C False
 * D True
 * E False
 * F True
 * G True
 * H False
 * I False
 * J False
 *
 * 3. Incorrect. Just because the value is not in the array, does not mean it will return -1. If it is not in the
 * array, it will return a negative number in relation to where the number would be if it was in the array. Unless that number 
 * is -1, the code will say it is in the array.
 *
 *
 * 4.
 * Binary search O(logN)
 * Linear search O(N)
 * Insertion sort O(N^2)
 * Selection sort O(N^2)
 * Merge sort O(NlogN)
 * Quicksort O(N^2)
 *
 */







public class SearchSortDemo {
	enum SearchType {
		Linear, LinearSorted, BSearch, RecursiveBSearch, Arrays
	};

	enum SortType {
		Insertion, Selection, Merge, Quick, Arrays, ArraysReversed
	};

	private static <T extends Comparable<? super T>> void doSearch(SearchType type, T[] ary, T key) {
		final int ITERATIONS = 200;
		int pos = 0;
		StopWatch timer = new StopWatch();
		timer.start();

		for (int i = 0; i < ITERATIONS; i++) {
			switch (type) {
			case Linear:
				pos = Searching.linearSearch(ary, key);
				break;
			case LinearSorted:
				pos = Searching.linearSearchOfSortedArray(ary, key);
				break;
			case BSearch:
				pos = Searching.binarySearch(ary, key);
				break;
			case RecursiveBSearch:
				pos = Searching.recursiveBinarySearch(ary, key);
				break;
			case Arrays:
				pos = Arrays.binarySearch(ary, key);
				break;
			default:
				System.out.println("Error: search method incorrect");
				pos = -2;
			}
		}
		timer.stop();

		System.out.printf("%s (%f seconds) ", type.toString(), timer.getElapsedTimeSecs());
		if (pos < 0) {
			System.out.println("Did not find the value in array");
		} else {
			if (ary[pos].compareTo(key) == 0)
				System.out.println("Found the value in the array");
			else
				System.out.println("Found an incorrect value!!!!");
		}
	}

	public static void searchTestOfIntegers() {
		final int N = 20;
		// final int N = 10000000;

		// ARRAY TO BE SEARCHED
		Integer[] ary;
		ary = DataGenerator.generateArray(N, true, true); // increasing array
		// ary = DataGenerator.generateArray(N, true, false); // decreasing
		// array
		// ary = DataGenerator.generateArray(N, false, false); // random array
		// ary = DataGenerator.generateConstantArray(N, 56); // constant value

		// KEY TO BE SEARCHED FOR
		int key;
		// select a random value known to be in the array
		// key = Integer.MIN_VALUE; // known NOT to be in array
		key = ary[DataGenerator.randInt(0, N - 1)]; // known to be in array
		// key = ary[0]; // known to be in array
		// key = ary[N-1]; // known to be in array

		if (N <= 20) { // Display starting configuration, do only for small N
			DataGenerator.printObjects(ary);
			System.out.println("Key = " + key);
		}

		for (SearchType t : SearchType.values()) {
			doSearch(t, ary, key);
		}
	}

	public static void testOfPoints() {
		final int N = 10;
		Point pts[] = DataGenerator.generatePointArray(N);
		ArrayList<Point> ptList = new ArrayList<>();
		for (Point pt : pts) {
			ptList.add(pt);
		}

		System.out.print("Orig: ");
		DataGenerator.printObjects(pts);
		Point key = new Point(pts[N - 2]);

		Arrays.sort(pts);
		System.out.print("Sort by origin: ");
		DataGenerator.printObjects(pts);

		System.out.println("BS of " + key + ": " + Arrays.binarySearch(pts, key));

		Comparator<Point> xcomp = new Point.XComparator();
		Arrays.sort(pts, xcomp);
		System.out.print("Sort by X: ");
		DataGenerator.printObjects(pts);
		System.out.println("BS of " + key + " XSort: " + Arrays.binarySearch(pts, key, xcomp));

		Comparator<Point> ycomp = new Point.YComparator();
		Arrays.sort(pts, ycomp);
		System.out.print("Sort by Y: ");
		DataGenerator.printObjects(pts);
		System.out.println("BS of " + key + " YSort: " + Arrays.binarySearch(pts, key, ycomp));
		System.out.println("BS of (0, 0) YSort: " + Arrays.binarySearch(pts, new Point(0, 0), ycomp));
	}

	public static void testOfDates() {
		final int N = 10;
		Date dates[] = DataGenerator.generateDateArray(N);
		ArrayList<Date> datesList = new ArrayList<>();
		for (Date d : dates) {
			datesList.add(d);
		}

		System.out.print("Orig array: ");
		DataGenerator.printObjects(dates);
		System.out.print("Orig ArrayList: ");
		DataGenerator.printObjects(datesList);
		Date key = new Date(dates[N - 1]);

		Arrays.sort(dates);
		Collections.sort(datesList, Collections.reverseOrder());
		System.out.print("Sorted Array: ");
		DataGenerator.printObjects(dates);
		System.out.print("Reverse sorted ArrayList: ");
		DataGenerator.printObjects(datesList);

		System.out.println(Arrays.binarySearch(dates, key));
	}

	public static <T extends Comparable<? super T>> void doSort(SortType type, T[] ary) {
		StopWatch timer = new StopWatch();
		timer.start();

		switch (type) {
		case Insertion:
			Sorting.insertionSort(ary);
			break;
		case Selection:
			Sorting.selectionSort(ary);
			break;
		case Merge:
			Sorting.mergeSort(ary);
			break;
		case Quick:
			Sorting.quickSort(ary);
			break;
		case Arrays:
			Arrays.sort(ary);
			break;
		case ArraysReversed:
			Arrays.sort(ary, Collections.reverseOrder());
			break;
		default:
			System.out.println("Error: sort method incorrect");
		}

		timer.stop();

		System.out.printf("%s %f\n", type.toString(), timer.getElapsedTimeSecs());
	}

	public static void testSortingIntegers() {
		int N = 10; // 100000

		for (SortType t : SortType.values()) {
			// ARRAY TO BE SORTED
			// array, sorted in increasing order
			// Integer [] ary = DataGenerator.generateArray(N, true, true);
			// array, sorted in increasing order, but last one is out of order
			// Integer [] ary = DataGenerator.generateArray(N, true, true);
			// ary[N-1] = DataGenerator.randInt(-10000, 10000);
			// array, sorted in decreasing order
			// Integer [] ary = DataGenerator.generateArray(N, true, false);
			// array, random order
			Integer[] ary = DataGenerator.generateArray(N, false, false);
			// array, constant value
			// Integer [] ary = DataGenerator.generateConstantArray(N, 56);

			if (N <= 10) {
				System.out.print("Orig: ");
				DataGenerator.printObjects(ary);
			}
			doSort(t, ary);
			if (N <= 10) {
				System.out.print("Sorted " + t.toString() + ":");
				DataGenerator.printObjects(ary);
			}
		}
	}

	public static void main(String[] args) {
		// searchTestOfIntegers();
		// testOfPoints();
		testOfDates();
		// testSortingIntegers();
	}
}
