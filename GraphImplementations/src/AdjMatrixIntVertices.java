import java.util.*;
import java.io.*;

public class AdjMatrixIntVertices {
	private int N;
	private boolean[][] adjMatrix;

	public AdjMatrixIntVertices(String fname) {
		try {
			Scanner input = new Scanner(new File(fname));
			N = input.nextInt();
			adjMatrix = new boolean[N][];
			for (int r = 0; r < N; r++) {
				adjMatrix[r] = new boolean[N];
				for (int c = 0; c < N; c++) {
					adjMatrix[r][c] = input.nextInt() == 1;
				}
			}
			input.close();
		} catch (Exception e) {
			System.err.println("Problem during file input");
			System.exit(0);
		}
	}

	public Set<Integer> canReach(int startVertex) {
		HashSet<Integer> reachable = new HashSet<>();
		HashSet<Integer> recentAdditions = new HashSet<>();

		reachable.add(startVertex);
		recentAdditions.add(startVertex);

		do {
			HashSet<Integer> copyRecentAdditions = new HashSet<Integer>(recentAdditions);
			recentAdditions.clear();
			for (int v : copyRecentAdditions) {
				for (int i = 0; i < N; i++) {
					if (adjMatrix[v][i] && !reachable.contains(i)) {
						recentAdditions.add(i);
					}
				}
			}
			reachable.addAll(recentAdditions);
		} while (recentAdditions.size() != 0);

		return reachable;
	}
}
