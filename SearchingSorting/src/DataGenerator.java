import java.util.*;

public class DataGenerator {
	public static int randInt(int lo, int hi) {
		int delta = hi - lo + 1;
		return (int) (Math.random() * delta) + lo;
	}

	public static int[] generateConstantArray(int N, int val) {
		int[] result = new int[N];
		for (int i = 0; i < N; i++) {
			result[i] = val;
		}
		return result;
	}

	public static Integer[] generateArray(int N, boolean sorted, boolean incr) {
		final int M = 10000;
		Integer[] result = new Integer[N];
		result[0] = randInt(-M, M);
		for (int i = 1; i < N; i++) {
			if (sorted) {
				if (incr)
					result[i] = result[i - 1] + randInt(0, 5);
				else
					result[i] = result[i - 1] - randInt(0, 5);
			} else {
				result[i] = randInt(-M, M);
			}
		}
		return result;
	}

	public static ArrayList<Integer> generateArrayList(int N, boolean sorted, boolean incr) {
		final int M = 10000;
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			result.add(randInt(-M, M));
		}
		return result;
	}

	public static Point[] generatePointArray(int N) {
		Point[] result = new Point[N];
		for (int i = 0; i < N; i++) {
			final int M = 4;
			int x = randInt(-M, M);
			int y = randInt(-M, M);
			result[i] = new Point(x, y);
		}
		return result;
	}

	public static Date[] generateDateArray(int N) {
		Date[] result = new Date[N];
		for (int i = 0; i < N; i++) {
			int m = randInt(1, 12);
			int d = randInt(1, 31);
			int y = randInt(2010, 2020);
			result[i] = new Date(m, d, y);
		}
		return result;
	}

	public static <T extends Object> void printObjects(T[] collection) {
		System.out.print("[");
		for (T item : collection) {
			System.out.print(item.toString() + " ");
		}
		System.out.println("]");
	}

	public static <T> void printObjects(Iterable<T> collection) {
		System.out.print("[");
		for (T item : collection) {
			System.out.print(item.toString() + " ");
		}
		System.out.println("]");
	}
}
