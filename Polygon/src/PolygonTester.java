// Benjamin Bowser
// PolygonTester.java
// This class exercises the Polygon class.

class PolygonTester {
	public static void main(String args[]) {
		
	Triangle tr1 = new Triangle(new Point(2,0), new Point(1,3), new Point(-1, -1));
	Triangle tr2 = new Triangle(new Point(0,0), new Point(1, 7), new Point(-3, 9));
	Triangle tr3 = new Triangle(new Point(-2,0), new Point(-1,-3), new Point(1, 1));
	
	Polygon p1 = new Polygon(6);
	
	Point pts[] = new Point[5];  
	pts[0] = new Point(1,2);
	pts[1] = new Point(0,2);
	pts[2] = new Point(-3,-1);
	pts[3] = new Point(0,-5);
	pts[4] = new Point(3,-1);

	Polygon p2 = new Polygon(pts);
	
	
	System.out.println(p1.numVertices());
	
	System.out.println("Triangle with points (2,0), (1,3), (-1,1) is isoceles?");
	System.out.println("Result: " + tr1.isIsosceles());
	
	System.out.println("Triangle with points (0,0), (1,7), (-3,9) is isoceles?");
	System.out.println("Result: " + tr2.isIsosceles());
	
	System.out.println("Triangle with points (-2,0), (-1,-3), (1,1) is isoceles?");
	System.out.println("Result: " + tr3.isIsosceles());
	
	System.out.println("Perimeter of a centered polygon with 6 vertices");
	System.out.println("Result: " + p1.perimeter());
	
	System.out.println("Perimeter of a polygon with 5 points");
	System.out.println("Result: " + p2.perimeter());
	
	System.out.println("Iosperimetric Quotient of a centered polygon with 6 vertices");
	System.out.println("Result: " + p1.iosperimetricQuotient());
	
	System.out.println("Iosperimetric Quotient of a polygon with 5 points");
	System.out.println("Result: " + p2.iosperimetricQuotient());
	
	System.out.println("P1 is larger than P2 (area)?");
	System.out.println("Result: " + p1.isLarger(p2));
	
	System.out.println("P2 is larger than P1 (area)?");
	System.out.println("Result: " + p2.isLarger(p1));
	
	System.out.println("P1 Original:" + p1.toString());
	p1.translate(3, 4);
	System.out.println("P1 Translated (3,4): " + p1.toString());
	
	System.out.println("P2 Orignal: " + p2.toString());
	p2.translate(-2,-5);
	System.out.println("P2 Translated (-2,-5): " + p2.toString());
	
	}
}
