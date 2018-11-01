// Benjamin Bowser
// CSE 274 UA
public class Location {
	public int zipCode;
	public String cityName;
	public String state;
	public double latitude, longitude;

	private static double parseDouble(String str) {
		double value = 0;
		if (!str.isEmpty()) {
			value = Double.parseDouble(str);
		}
		return value;
	}

	public Location(String[] toks) {
		zipCode = (int) parseDouble(toks[1]);
		cityName = toks[3];
		state = toks[4];
		latitude = parseDouble(toks[6]);
		longitude = parseDouble(toks[7]);
	}
}
