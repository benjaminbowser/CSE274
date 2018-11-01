import java.util.*;
import java.io.*;

public class AdjListStringVertices {
	private HashMap<String, Set<String>> adjList;

	public AdjListStringVertices(String fname) {
		try {
			Scanner input = new Scanner(new File(fname));
			Integer.parseInt(input.nextLine()); // not needed

			adjList = new HashMap<>();

			String[] cities = input.nextLine().split(" ");
			for (String city : cities) {
				adjList.put(city, new HashSet<String>());
			}
			while (input.hasNextLine()) {
				String[] toks = input.nextLine().split(" ");
				String city1 = toks[0];
				String city2 = toks[1];
				adjList.get(city1).add(city2);
				adjList.get(city2).add(city1);
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
			TreeSet<String> copyRecentAdditions = new TreeSet<String>(recentAdditions);
			recentAdditions.clear();
			for (String v : copyRecentAdditions) {
				for (String i : adjList.get(v)) {
					if (adjList.get(v).contains(i) && !reachable.contains(i)) {
						recentAdditions.add(i);
					}
				}
			}
			reachable.addAll(recentAdditions);
		} while (recentAdditions.size() != 0);

		return reachable;
	}
}
