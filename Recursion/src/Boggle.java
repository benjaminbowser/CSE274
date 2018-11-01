import java.util.*;
import java.io.*;

public class Boggle {
	// BOGGLE - form words of length 4 by starting at one block
	// and then going to an adjacent block, and so on. Don't use
	// any block more than once.
	private static final int NUMWORDS = 58112;
	private static String[] words = new String[NUMWORDS];
	private static final String WORDFILE = "words.txt";

	public static void loadWords() throws Exception {
		Scanner input = new Scanner(new File(WORDFILE));
		for (int i = 0; i < NUMWORDS; i++) {
			words[i] = input.next();
		}
		input.close();
	}

	private static boolean isWord(String w) {
		int pos = Arrays.binarySearch(words, w);
		return pos >= 0;
	}

	private static boolean between(int v, int lo, int hi) {
		return v >= lo && v <= hi;
	}

	private static void boggle(char[][] brd, ArrayList<String> words, String currWord, int r, int c) {
		if (currWord.length() == 4) {
			if (isWord(currWord) && !words.contains(currWord)) {
				words.add(currWord);
			}
		} else if (between(r, 0, 3) && between(c, 0, 3) && brd[r][c] != '.') {
			for (int dr = -1; dr <= +1; dr++) {
				for (int dc = -1; dc <= +1; dc++) {
					if (dr == 0 && dc == 0)
						continue;
					char ch = brd[r][c];
					brd[r][c] = '.';
					boggle(brd, words, currWord + ch, r + dr, c + dc);
					brd[r][c] = ch;
				}
			}
		}
	}

	public static void boggle(char[][] brd) {
		ArrayList<String> words = new ArrayList<String>();
		for (int r = 0; r < 4; r++) { // try out all starting locations
			for (int c = 0; c < 4; c++) {
				boggle(brd, words, "", r, c);
			}
		}
		System.out.println(words);
	}

	public static void main(String[] args) throws Exception {
		char brd[][] = { { 'A', 'E', 'C', 'A' }, { 'S', 'M', 'C', 'K' }, { 'A', 'B', 'A', 'D' },
				{ 'A', 'I', 'C', 'D' } };
		loadWords();
		boggle(brd);

	}
}
