import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class AdjListIntVertices {
	private int N;
	private HashSet<Integer>[] adjList;

	@SuppressWarnings("unchecked")
	public AdjListIntVertices(String fname) {
		try {
			Scanner input = new Scanner(new File(fname));
			N = input.nextInt();
			adjList = (HashSet<Integer>[]) Array.newInstance(new HashSet<Integer>().getClass(), N);
			for (int r = 0; r < N; r++) {
				adjList[r] = new HashSet<Integer>();
				for (int c = 0; c < N; c++) {
					if (input.nextInt() == 1) {
						adjList[r].add(c);
					}
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
					if (adjList[v].contains(i) && !reachable.contains(i)) {
						recentAdditions.add(i);
					}
				}
			}
			reachable.addAll(recentAdditions);
		} while (recentAdditions.size() != 0);

		return reachable;
	}
}
