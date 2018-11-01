import java.util.*;
import java.io.*;

public class AdjMatrix2StringVertices {
	private TreeMap<String, TreeMap<String, Boolean>> adjMatrix;
	private String[] cities;

	public AdjMatrix2StringVertices(String fname) {
		try {
			Scanner input = new Scanner(new File(fname));
			int N = Integer.parseInt(input.nextLine());
			cities = input.nextLine().split(" ");
			Arrays.sort(cities);
			adjMatrix = new TreeMap<String, TreeMap<String, Boolean>>();

			for (String c1 : cities) {
				adjMatrix.put(c1, new TreeMap<String, Boolean>());
				for (String c2 : cities) {
					adjMatrix.get(c1).put(c2, false);
				}
			}
			while (input.hasNextLine()) {
				String[] toks = input.nextLine().split(" ");
				String city1 = toks[0];
				String city2 = toks[1];
				adjMatrix.get(city1).put(city2, true);
				adjMatrix.get(city2).put(city1, true);
			}

			input.close();
		} catch (Exception e) {
			System.err.println("Problem during file input");
			System.exit(0);
		}
	}

	public Set<String> canReach(String startCity) {
		TreeSet<String> reachable = new TreeSet<>();
		TreeSet<String> recentAdditions = new TreeSet<>();

		reachable.add(startCity);
		recentAdditions.add(startCity);

		do {
			TreeSet<String> copyRecentAdditions = new TreeSet<>(recentAdditions);
			recentAdditions.clear();
			for (String v : copyRecentAdditions) {
				for (String i : cities) {
					if (adjMatrix.get(v).get(i) && !reachable.contains(i)) {
						recentAdditions.add(i);
					}
				}
			}
			reachable.addAll(recentAdditions);
		} while (recentAdditions.size() != 0);

		return reachable;
	}
}
