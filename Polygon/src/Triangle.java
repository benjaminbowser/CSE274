// Benjamin Bowser
// Triangle.java

public class Triangle {
	private static final double EPSILON = 0.001;
	private Point a, b, c;

	/**
	 * Constructs a right triangle with the following vertices: (0,0), (1,0),
	 * (1,1)
	 */
	public Triangle() {
		a = new Point(0, 0);
		b = new Point(1, 0);
		c = new Point(1, 1);
	}

	/**
	 * construct a triangle based on specific vertices
	 * 
	 * @param A
	 *            The first vertex of triangle
	 * @param B
	 *            The second vertex of triangle
	 * @param C
	 *            The third vertex of triangle
	 */
	public Triangle(Point A, Point B, Point C) {
		// You might try: a = A; b = B; c = C;
		// This will be problematic in general, since A, B, and C are
		// owned by the calling code (i.e., client)
		// Instead, the copy ctor creates new, but equivalent, Points using
		a = new Point(A);
		b = new Point(B);
		c = new Point(C);
	}

	/**
	 * Copy constructor
	 * 
	 * @param tri
	 *            The triangle to be copied.
	 */
	public Triangle(Triangle tri) {
		this(tri.a, tri.b, tri.c);
	}

	/**
	 * Returns a string representation of the triangle
	 */
	public String toString() {
		return String.format("[%s;%s;%s]", a.toString(), b.toString(), c.toString());
	}

	/**
	 * Computes perimeter of triangle.
	 * 
	 * @return Perimeter of triangle
	 */
	public double perimeter() {
		return a.distance(b) + b.distance(c) + c.distance(a);
	}

	/**
	 * Determine if the triangle is a right triangle.
	 * 
	 * @return true iff the triangle is a right triangle
	 */
	public boolean isRightTriangle() {
		double A = a.distance(b);
		double B = b.distance(c);
		double C = c.distance(a);

		double A2 = A * A;
		double B2 = B * B;
		double C2 = C * C;

		return close(A2 + B2, C2) || close(A2 + C2, B2) || close(B2 + C2, A2);
	}

	/**
	 * Computes the area of a triangle
	 * 
	 * @return Area of triangle
	 */
	public double area() {
		double dxB = b.getX() - a.getX();
		double dyB = b.getY() - a.getY();
		double dxC = c.getX() - a.getX();
		double dyC = c.getY() - a.getY();

		double perp = Math.abs(dxB * dyC - dyB * dxC);
		return 0.5 * perp;
	}

	/**
	 * Determines if the given triangle is larger (in area) than the passed
	 * triangle
	 * 
	 * @param tri
	 *            The second triangle
	 * @return true iff the triangle has more area than tri
	 */
	public boolean isLarger(Triangle tri) {
		return area() > tri.area();
	}

	/**
	 * Returns whether two double precision numbers are "equivalent". Where
	 * equivalent is defined as "being with 0.001 of each other".
	 * 
	 * @param a
	 *            One of the values being compared
	 * @param b
	 *            The other values being compared
	 * @return true iff a and b differ by a very small amount
	 */
	private static boolean close(double a, double b) {
		// This routine is needed since comparing double precision numbers using
		// == is problematic.
		return Math.abs(a - b) < EPSILON;
	}

	public boolean isIsosceles() { 
		return (a.distance(b) == b.distance(c) || a.distance(c) == a.distance(b) || a.distance(c) == b.distance(c));
	}
}
