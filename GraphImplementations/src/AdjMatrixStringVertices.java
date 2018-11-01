import java.util.*;
import java.io.*;

public class AdjMatrixStringVertices {
	private int N;
	private String[] cities;
	private boolean[][] adjMatrix;

	private int cityIndex(String cityName) {
		return Arrays.binarySearch(cities, cityName);
	}

	public AdjMatrixStringVertices(String fname) {
		try {
			Scanner input = new Scanner(new File(fname));
			N = Integer.parseInt(input.nextLine());
			cities = input.nextLine().split(" ");
			Arrays.sort(cities);
			adjMatrix = new boolean[N][];
			for (int i = 0; i < N; i++) {
				adjMatrix[i] = new boolean[N];
			}
			while (input.hasNextLine()) {
				String[] cities = input.nextLine().split(" ");
				int city1 = cityIndex(cities[0]);
				int city2 = cityIndex(cities[1]);
				adjMatrix[city1][city2] = adjMatrix[city2][city1] = true;
			}

			input.close();
		} catch (Exception e) {
			System.err.println("Problem during file input");
			System.exit(0);
		}
	}

	public Set<String> canReach(String startCity) {
		HashSet<Integer> reachable = new HashSet<>();
		HashSet<Integer> recentAdditions = new HashSet<>();

		int startVertex = cityIndex(startCity);
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

		TreeSet<String> reachableCities = new TreeSet<>();
		for (int c : reachable) {
			reachableCities.add(cities[c]);
		}
		return reachableCities;
	}
}
