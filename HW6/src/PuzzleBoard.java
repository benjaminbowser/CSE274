// Benjamin Bowser
// CSE274 UA
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PuzzleBoard implements Comparable{
	private int[][] board;
	private Set<PuzzleBoard> succesors = new HashSet<>();

	public PuzzleBoard(int[][] data) {
		board = data;
		exceptionCheck();
	}

	public void exceptionCheck() {
		int size = board.length;
		int total = (int) Math.pow(size, 2);
		int count = 0;
		try {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board.length; j++) {
					if (board[i][j] >= -1) {
						count++;
					}
				}

			}
		}
		catch (IndexOutOfBoundsException problem) {
			throw new NonSensicalException("Board is not valid.");
		}

		if (total != count) {
			throw new NonSensicalException("Number of elements does not match the proper size.");
		}
		if (duplicates(board)) {
			throw new NonSensicalException("Board contains duplicate entries.");
		}
		if (!positive(board)) {
			throw new NonSensicalException("Board contains invalid entries.");
		}
		if (!hasEmptySpace(board)) {
			throw new NonSensicalException("Board does not have an empty space.");
		}

	}
	private boolean hasEmptySpace(int[][] board) {
		boolean valid = false;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == -1) {
					valid = true;
				}
			}
		}
		return valid;
	}

	private boolean positive(int[][] board) {
		boolean valid = true;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] < 1) {
					if (board[i][j] != -1) {
						valid = false;
					}
				}
			}
		}
		return valid;
	}

	private boolean duplicates(int[][] board) {
		Set<Integer> data = new HashSet<Integer>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (data.contains(board[i][j])) {
					return true;
				} else {
					data.add(board[i][j]);
				}
			}
		}
		return false;
	}

	public int[][] getBoard() {
		return board;
	}

	public static int[][] arrayCopy(int[][] board) {
		int[][] reply = new int[board.length][board.length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				reply[i][j] = board[i][j];
			}
		}
		return reply;
	}

	public Set<PuzzleBoard> getNextMoves() {
		PuzzleBoard first = new PuzzleBoard(arrayCopy(board));
		PuzzleBoard second = new PuzzleBoard(arrayCopy(board));
		PuzzleBoard third = new PuzzleBoard(arrayCopy(board));
		PuzzleBoard fourth = new PuzzleBoard(arrayCopy(board));

		int length = board.length;
		int[] empty = findEmpty();
		int x = empty[0];
		int y = empty[1];

		if (x >= 1) { // Left shift possible
			swapLeft(x,y,first); 
		}

		if (x < length-1) { // Right shift
			swapRight(x,y, second);
		}

		if (y >= 1) { // Up shift
			swapUp(x,y,third);
		}

		if (y < length-1) { // Downward shift
			swapDown(x,y,fourth);
		} 
		return succesors;
	}

	public void swapLeft(int x, int y, PuzzleBoard data) {
		int[][] swapBoard = data.getBoard();
		int swap = swapBoard[y][x-1];
		swapBoard[y][x-1] = -1;
		swapBoard[y][x] = swap;
		PuzzleBoard board = new PuzzleBoard(swapBoard);
		succesors.add(board);
	}

	public void swapRight(int x, int y, PuzzleBoard data) {
		int[][] swapBoard = data.getBoard();
		int swap = swapBoard[y][x+1];
		swapBoard[y][x+1] = -1;
		swapBoard[y][x] = swap;
		PuzzleBoard board = new PuzzleBoard(swapBoard);
		succesors.add(board);
	}

	public void swapUp(int x, int y, PuzzleBoard data) {
		int[][] swapBoard = data.getBoard();
		int swap = swapBoard[y-1][x];
		swapBoard[y-1][x] = -1;
		swapBoard[y][x] = swap;
		PuzzleBoard board = new PuzzleBoard(swapBoard);
		succesors.add(board);
	}

	public void swapDown(int x, int y, PuzzleBoard data) {
		int[][] swapBoard = data.getBoard();
		int swap = swapBoard[y+1][x];
		swapBoard[y+1][x] = -1;
		swapBoard[y][x] = swap;
		PuzzleBoard board = new PuzzleBoard(swapBoard);
		succesors.add(board);
	}

	public int[] findEmpty() {
		int[] reply = new int[2];
		int length = board.length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (board[i][j] == -1) {
					reply[0] = j;
					reply[1] = i;
					return reply;
				}
			}
		}
		return reply;
	}

	public PuzzleBoard generateSolution() {
		int length = board.length;
		int[][] reply = new int[length][length];
		int count = 1;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				reply[i][j] = count;
				count++;
			}
		}
		reply[length-1][length-1] = -1;
		PuzzleBoard solved = new PuzzleBoard(reply);
		return solved;
	}

	public String toString() {
		String reply = "";
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				reply = reply + board[i][j] + " ";
				if (j == board.length - 1) {
					reply = reply + "\n";
				}
			}
		}
		return reply;
	}	

	public int hashCode() {
		int code = 0;
		for (int i = 0; i <board.length; i++) {
			code += Arrays.hashCode(board[i]);
		}
		return code;
	}

	public boolean equals(Object other) {
		boolean result = true;
		if (other instanceof PuzzleBoard) {
			PuzzleBoard board = (PuzzleBoard) other;
			int[][] otherBoard = board.getBoard();

			for (int i = 0; i < board.getBoard().length; i++) {
				for (int j = 0; j < board.getBoard().length; j++) {
					if (this.board[i][j] != otherBoard[i][j]) {
						result = false;
					}
				}
			}

		}
		return result;
	}

	@Override
	public int compareTo(Object o) { // Not used
		return 0;
	}
}