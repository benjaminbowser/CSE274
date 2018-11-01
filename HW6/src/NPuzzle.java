// Benjamin Bowser
// CSE274 UA
public class NPuzzle {

	public static boolean solvable(int [][] board) {
		PuzzleBoard board1 = new PuzzleBoard(board); // checks if valid
		PuzzleBoard solution = board1.generateSolution();
		PuzzleSolver solver = new PuzzleSolver(board, solution);
		return solver.isSolved();
	}
	public static void main(String[] args) {
		int [][] v1 = {	{1, 2, 3, 4, 5},
				      { 6, 7, 8, 9, 10},
				     { 11, 12, 13, 14, 15},
				     {16,17,18,19,20},
				     {21,22,23,-1,24}
				      
		};
		int [][] v2 = {	{-1, 2, 1},
				{ 5, 6, 3},
				{ 4, 7, 8}};
		System.out.println(NPuzzle.solvable(v1));		// Should be true
		System.out.println(NPuzzle.solvable(v2));		// Should be false
	}
}