import java.util.*;

public class BasicRecursion {
	public static boolean IsPalindrome(String s) {
		boolean v;
		int len = s.length();

		if (len <= 1)
			v = true;
		else
			v = (s.charAt(0) == s.charAt(len - 1)) && IsPalindrome(s.substring(1, len - 1));

		return v;
	}

	public static int BinomialCoeficient(int n, int k) {
		int v;
		if (k == 0 || k == n) {
			v = 1;
		} else {
			v = BinomialCoeficient(n - 1, k) + BinomialCoeficient(n - 1, k - 1);
		}
		return v;
	}

	public static int power(int x, int y) {
		if (y == 0)
			return 1;
		else
			return x * power(x, y - 1);
	}

	public static String reverse(String str) {
		if (str.length() <= 1) {
			return str;
		} else {
			int len = str.length();
			return "" + str.charAt(len - 1) + reverse(str.substring(1, len - 1)) + str.charAt(0);
		}
	}

	public static int fibonacci(int n) // n >= 1
	{
		int v;
		if (n == 1 || n == 2)
			v = 1;
		else
			v = fibonacci(n - 1) + fibonacci(n - 2);
		return v;
	}

	// Lessen problems of recursive Fibonacci algorithm by using
	// memoization.
	private static long[] memoizedFibs;

	public static void initMemoizedFibs(int MAXFIB) {
		memoizedFibs = new long[MAXFIB + 1];
		for (int i = 1; i <= MAXFIB; i++) {
			memoizedFibs[i] = -1;
		}
	}

	public static long fibMemoized(int n) {
		long v = memoizedFibs[n];
		if (v == -1) {
			if (n == 1 || n == 2) {
				v = 1;
			} else {
				v = fibMemoized(n - 1) + fibMemoized(n - 2);
			}
			memoizedFibs[n] = v;
		}
		return v;
	}

	public static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}

	public static int mystery1(int a) // a >= 0
	{
		int v;
		if (a < 10)
			v = 1;
		else
			v = 1 + mystery1(a / 10);
		return v;
	}

	public static int mystery2(int a) {
		int result;
		if (a == 0) {
			result = 1;
		} else {
			result = 0;
			for (int i = 0; i <= a; i++) {
				result += mystery1(i - 1);
			}
		}
		return result;
	}

	public static void main(String args[]) {
		System.out.println(gcd(84, 30));
		int i;
		Scanner input = new Scanner(System.in);
		System.out.println(IsPalindrome("hannah"));
		System.out.println(IsPalindrome("12345hannah54321"));
		System.out.println(IsPalindrome("12345hanxnah54321"));
		System.out.println(IsPalindrome("12345hanxinah54321"));
		System.out.println(IsPalindrome("shannah"));
		System.out.println(IsPalindrome("hah"));
		System.out.println(IsPalindrome("X"));
		System.out.println(IsPalindrome("Xx"));
		System.out.println(IsPalindrome("XY"));
		System.out.println(IsPalindrome(""));
		System.out.println("press return");
		String line = input.nextLine();

		System.out.println("press return");
		line = input.nextLine();

		System.out.println("Mystery");
		for (i = 0; i <= 15; i++)
			System.out.println("mystery1(" + i + ") = " + mystery1(i));
		for (i = 95; i <= 105; i++)
			System.out.println("mystery1(" + i + ") = " + mystery1(i));

		System.out.println("press return");
		line = input.nextLine();

		for (int n = 0; n <= 15; n++) {
			for (int k = 0; k <= n; k++) {
				System.out.print("(" + n + ' ' + k + ")=" + BinomialCoeficient(n, k) + ' ');
			}
			System.out.println();
		}
		System.out.println("press return");
		line = input.nextLine();

		System.out.println("Fibonacci");
		for (i = 1; i <= 45; i++) {
			System.out.println("" + i + " " + fibonacci(i) + ' ');
			System.out.flush();
		}
		System.out.println();

		line = line.trim();
		input.close();
	}
}