// Benjamin Bowser
// CSE274 UA
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class PuzzleSolver {
	private Set<PuzzleBoard> boards;
	private Map<PuzzleBoard, Set<PuzzleBoard>> adjList;
	private int[][] board;
	private boolean complete;
	private PuzzleBoard solved;

	public PuzzleSolver(int[][] board, PuzzleBoard solved) {
		this.board = board;
		this.solved = solved;
		boards = new HashSet<PuzzleBoard>();
		adjList = new HashMap<PuzzleBoard, Set<PuzzleBoard>>();
		PuzzleBoard origState = new PuzzleBoard(board);
		boards.add(origState);
		Queue<PuzzleBoard> toProcess = new LinkedList<>();
		toProcess.add(origState);

		while (!toProcess.isEmpty() && !complete) {
			PuzzleBoard brd = toProcess.remove();
			if (brd.equals(solved)) {
				complete = true;
			}
			if (!adjList.containsKey(brd)) {
				Set<PuzzleBoard> successors = brd.getNextMoves();
				adjList.put(brd, successors);
				toProcess.addAll(successors);
				boards.addAll(successors);
			}
		}
	}
	public boolean isSolved() {
		PuzzleBoard data = new PuzzleBoard(board);
		if (complete) {
			return true;
		}
		if (solved.equals(data)) {
			return true;
		}
		return false;
	}
}