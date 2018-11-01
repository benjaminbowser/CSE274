public class Date implements Comparable<Date> {
	private int m, d, y;

	public Date(int month, int day, int year) {
		m = month;
		d = day;
		y = year;
	}

	public Date(Date other) {
		m = other.m;
		d = other.d;
		y = other.y;
	}

	public String toString() {
		return String.format(" %d/%d/%d ", m, d, y);
	}

	public int compareTo(Date d) {
		// sorts only on year
		if (y != d.y) {
			return y - d.y;
		}
		else {
			if (m != d.m) {
				return m - d.m;
			}
			if (this.d != d.d) {
				return this.d - d.d;
			}
		}
		
		return y - d.y;
	}
}
