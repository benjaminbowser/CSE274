public class TwoDPosition {
	public int row, col;

	public TwoDPosition(int r, int c) {
		row = r;
		col = c;
	}

	public boolean isLegal(int N) {
		return row >= 0 && row < N && col >= 0 && col < N;
	}
}
