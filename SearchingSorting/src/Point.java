import java.util.Comparator;

public class Point implements Comparable<Point> {
	private int x, y;

	public static class XComparator implements Comparator<Point> {
		public int compare(Point a, Point b) {
			int xdiff = a.x - b.x;
			int ydiff = a.y - b.y;
			if (xdiff != 0)
				return xdiff;
			else
				return ydiff;
		}
	}

	public static class YComparator implements Comparator<Point> {
		public int compare(Point a, Point b) {
			int xdiff = a.x - b.x;
			int ydiff = a.y - b.y;
			if (ydiff != 0)
				return ydiff;
			else
				return xdiff;
		}
	}

	private double distanceFromOrigin() {
		return Math.sqrt(x * x + y * y);
	}

	public int compareTo(Point pt) {
		double d1 = distanceFromOrigin();
		double d2 = pt.distanceFromOrigin();
		int val;
		if (d1 < d2)
			val = -1;
		else if (d1 > d2)
			val = +1;
		else
			val = 0;
		return val;
	}

	public Point(int a, int b) {
		x = a;
		y = b;
	}

	public Point() {
		x = y = 0;
	}

	public Point(Point p) {
		x = p.x;
		y = p.y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public double distance(Point p2) {
		return Math.sqrt(Math.pow(x - p2.x, 2) + Math.pow(y - p2.y, 2));
	}
}
