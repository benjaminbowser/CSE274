import java.util.*;

public class NimBoard implements Comparable<NimBoard> {
	private int[] piles;
	private boolean firstPlayersMove;

	public NimBoard() {
		piles = new int[] { 3, 5, 8 };
		firstPlayersMove = true;
	}

	public NimBoard(int p1, int p2, int p3, boolean move) {
		piles = new int[] { p1, p2, p3 };
		firstPlayersMove = move;
	}

	public Set<NimBoard> getSuccessors() {
		Set<NimBoard> successors = new HashSet<>();

		for (int j = 1; j <= piles[0]; j++)
			successors.add(new NimBoard(piles[0] - j, piles[1], piles[2], !firstPlayersMove));
		for (int j = 1; j <= piles[1]; j++)
			successors.add(new NimBoard(piles[0], piles[1] - j, piles[2], !firstPlayersMove));
		for (int j = 1; j <= piles[2]; j++)
			successors.add(new NimBoard(piles[0], piles[1], piles[2] - j, !firstPlayersMove));

		return successors;
	}

	public boolean equals(Object other) {
		boolean result;
		if (other instanceof NimBoard) {
			NimBoard brd = (NimBoard) other;
			result = Arrays.equals(piles, brd.piles) && firstPlayersMove == brd.firstPlayersMove;
		} else {
			result = false;
		}
		return result;
	}

	public String toString() {
		return String.format("%d%d%d-%s", piles[0], piles[1], piles[2], firstPlayersMove ? "T" : "F");
	}

	public int hashCode() {
		return Arrays.hashCode(piles) >> 8 ^ Boolean.hashCode(firstPlayersMove);
	}

	public int compareTo(NimBoard brd) {
		for (int i = 0; i < 3; i++) {
			if (piles[i] != brd.piles[i]) {
				return piles[i] - brd.piles[i];
			}
		}
		if (firstPlayersMove == brd.firstPlayersMove) {
			return 0;
		} else if (firstPlayersMove) {
			return -1;
		} else {
			return +1;
		}
	}
}
