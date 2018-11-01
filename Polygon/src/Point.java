// Benjamin Bowser
// Point.java

public class Point {
	private double x, y;

	/**
	 * Constructs a new Point at the origin - (0,0)
	 */
	public Point() {
		x = y = 0;
	}

	/**
	 * Constructs a point with specfic position
	 * 
	 * @param X
	 *            x position of point
	 * @param Y
	 *            y position of point
	 */
	public Point(double X, double Y) {
		x = X;
		y = Y;
	}

	/**
	 * Copy constructor
	 * 
	 * @param p
	 *            Point to be copied
	 */
	public Point(Point p) {
		x = p.x;
		y = p.y;
	}

	/**
	 * Creates a String representation of this point.
	 * 
	 * @return String representation of Point
	 */
	public String toString() {
		return String.format("(%f,%f)", x, y);
	}

	/**
	 * Creates a Point from its string representation
	 * 
	 * @param text
	 *            The point's string representation
	 * @return Point equivalent to the string representation
	 */
	public static Point parse(String text) {
		int len = text.length();
		int commaLocation = text.indexOf(',');

		String xStr = text.substring(1, commaLocation);
		String yStr = text.substring(commaLocation + 1, len - 1);

		double x = Double.parseDouble(xStr);
		double y = Double.parseDouble(yStr);

		return new Point(x, y);
	}

	/**
	 * Determines the distance between two points
	 * 
	 * @param p2
	 *            The second point
	 * @return The distance between the two points.
	 */
	public double distance(Point p2) {
		return Math.sqrt(Math.pow(x - p2.x, 2) + Math.pow(y - p2.y, 2));
	}

	/**
	 * Determines if two points are EXACTLY equivalent
	 * 
	 * @param p
	 *            The second point in the comparison
	 * @return true iff the two points are identical
	 */
	public boolean equals(Point p) {
		return x == p.x && y == p.y;
	}

	/**
	 * Getter for x
	 * 
	 * @return The x value
	 */
	public double getX() {
		return x;
	}

	/**
	 * Getter for y
	 * 
	 * @return The y value
	 */
	public double getY() {
		return y;
	}

	/**
	 * Setter for x
	 * 
	 * @param value
	 *            the new value for x
	 */
	public void setX(double value) {
		x = value;
	}

	/**
	 * Setter for y
	 * 
	 * @param value
	 *            the new value for y
	 */
	public void setY(double value) {
		y = value;
	}

	// My code

	public void translate(double dx, double dy) {
		x= getX() + dx;
		y = getY() + dy;

	}
}
