import java.util.*;

public class AdvancedRecursion {
	// Enumeration of all binary strings
	private static void binaryStrings(String prefix, int len) {
		if (len == 0) {
			System.out.println(prefix);
		} else {
			binaryStrings(prefix + '0', len - 1);
			binaryStrings(prefix + '1', len - 1);
		}
	}

	public static void binaryStrings(int len) {
		binaryStrings("", len);
	}

	public static void anagrams2(String prefix, String remain) {
		int len = remain.length();
		if (len == 0) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < len; i++) {
				char ch = remain.charAt(i);
				// eg, remain = "ABCDEF", i = 3 ---> s1 = "ABC" s2 = "EF"
				String s1 = remain.substring(0, i);
				String s2 = remain.substring(i + 1);
				anagrams2(prefix + ch, s1 + s2);
			}
		}
	}

	// This routine is the interface given to users. This routine
	// has a parameter list that reflects how users should think
	// about using this routine -- they should not have to understand
	// how the algorithm works.
	public static void anagrams(String str) {
		anagrams2("", str);
	}

	// *********************************************************************
	public static void anagrams2(String prefix, String remain, int k) {
		int len = remain.length();
		if (prefix.length() == k) {
			System.out.println(prefix);
		} else {
			for (int i = 0; i < len; i++) {
				char ch = remain.charAt(i);
				String s1 = remain.substring(0, i);
				String s2 = remain.substring(i + 1);
				anagrams2(prefix + ch, s1 + s2, k);
			}
		}
	}

	public static void anagrams(String str, int len) {
		anagrams2("", str, len);
	}

	// Enumeration of binary strings having a specific number of 1s
	private static void ones(String pre, int len, int bits) {
		if (len == 1) {
			if (bits == 0)
				System.out.println(pre + '0');
			else if (bits == 1)
				System.out.println(pre + '1');
		} else {
			ones(pre + '0', len - 1, bits);
			ones(pre + '1', len - 1, bits - 1);
		}
	}

	public static void ones(int len, int bits) {
		ones("", len, bits);
	}

	public static void deleteBlob(int im[][], int r, int c) {
		int N = im.length; // assume square
		if (r >= 0 && r < N && c >= 0 && c < N && im[r][c] == 1) {
			im[r][c] = 0;
			deleteBlob(im, r - 1, c - 1);
			deleteBlob(im, r - 1, c);
			deleteBlob(im, r - 1, c + 1);
			deleteBlob(im, r, c - 1);
			deleteBlob(im, r, c);
			deleteBlob(im, r, c + 1);
			deleteBlob(im, r + 1, c - 1);
			deleteBlob(im, r + 1, c);
			deleteBlob(im, r + 1, c + 1);
		}
	}

	public static void deleteBlobNonRecursive(int im[][], int r, int c) {
		int N = im.length;
		Stack<TwoDPosition> stk = new Stack<>();
		stk.push(new TwoDPosition(r, c));
		while (!stk.isEmpty()) {
			TwoDPosition pos = stk.pop();

			if (pos.isLegal(N) && im[pos.row][pos.col] == 1) {
				im[pos.row][pos.col] = 0;
				stk.push(new TwoDPosition(pos.row + 1, pos.col + 1));
				stk.push(new TwoDPosition(pos.row, pos.col + 1));
				stk.push(new TwoDPosition(pos.row - 1, pos.col + 1));
				stk.push(new TwoDPosition(pos.row + 1, pos.col));
				// stk.push(new TwoDPosition(pos.row, pos.col));
				stk.push(new TwoDPosition(pos.row - 1, pos.col));
				stk.push(new TwoDPosition(pos.row + 1, pos.col - 1));
				stk.push(new TwoDPosition(pos.row, pos.col - 1));
				stk.push(new TwoDPosition(pos.row - 1, pos.col - 1));
			}
		}
	}

	public static void main(String args[]) {
		System.out.println("ANAGRAMS");
		anagrams("ABCD");
		System.out.println("ANAGRAMS");
		anagrams("AAB");
		System.out.println("LENGTH LIMITED ANAGRAMS");
		anagrams("ABCDEF", 3);

		int image[][] = { { 0, 0, 0, 0, 0, 1, 1 }, { 0, 1, 0, 0, 0, 1, 1 }, { 1, 0, 0, 1, 0, 1, 1 },
				{ 0, 1, 0, 1, 0, 0, 0 }, { 0, 0, 0, 1, 0, 0, 0 }, { 1, 0, 0, 0, 1, 0, 0 }, { 1, 0, 0, 0, 1, 0, 0 } };

		int r, c;
		final int N = image.length; // assume image is square

		for (r = 0; r < N; r++) {
			for (c = 0; c < N; c++)
				System.out.print(image[r][c]);
			System.out.println();
		}
		System.out.println();

		deleteBlob(image, 1, 1);
		// deleteBlobNonRecursive(image, 1, 1);

		for (r = 0; r < N; r++) {
			for (c = 0; c < N; c++)
				System.out.print(image[r][c]);
			System.out.println();
		}
		System.out.println();
	}
}
