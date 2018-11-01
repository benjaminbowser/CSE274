import java.util.*;

public class Driver {

	public static void main(String[] args) {
		/*
		AdjMatrixIntVertices matInt = new AdjMatrixIntVertices("intgraph1.txt");
		AdjListIntVertices listInt = new AdjListIntVertices("intgraph1.txt");

		for (int i = 0; i < 6; i++) {
			System.out.println(matInt.canReach(i));
			System.out.println(listInt.canReach(i));
		}

		AdjMatrixStringVertices matStr = new AdjMatrixStringVertices("stringgraph1.txt");
		AdjListStringVertices listStr = new AdjListStringVertices("stringgraph1.txt");
		AdjMatrix2StringVertices mat2Str = new AdjMatrix2StringVertices("stringgraph1.txt");

		String[] cities = { "oxford", "london", "cleveland", "waco" };
		for (String c : cities) {
			System.out.println(matStr.canReach(c));
			System.out.println(mat2Str.canReach(c));
			System.out.println(listStr.canReach(c));
		}
	*/
		NimGraph nim = new NimGraph();
		nim.display();
		NimBoard brd = new NimBoard(2, 1, 4, true);		
		
		// This prints the successors current:
		Set<NimBoard> brds = nim.getSuccessors(brd);
		for (NimBoard B : brds) {
			System.out.printf("%s%n", B);
		}
	}
}
