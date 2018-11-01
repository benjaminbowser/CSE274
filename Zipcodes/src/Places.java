// Benjamin Bowser
// CSE 274 UA
import java.util.*;
import java.io.*;

public class Places {
	private ArrayList<Location> places;

	public Places(String fname) throws FileNotFoundException {
		places = new ArrayList<>();
		Scanner input = null;
		input = new Scanner(new File(fname));
		input.nextLine(); // skip first line
		while (input.hasNextLine()) {
			String[] toks = input.nextLine().split("\t", -1);
			Location loc = new Location(toks);
			places.add(loc);
		}
		input.close();
		
	}

	/**
	 * Returns all the city names that correspond to a particular zipcode. The
	 * empty set is returned if the zipcode is not valid.
	 * 
	 * @param zipCode
	 *            target zip code
	 * @return set with all city names with the target zip code.
	 */
	public Set<String> getCityNameFromZipCode(int zipCode) {
		Set<String> result = new TreeSet<String>(); // Have to pick concrete set (tree). Must be comparable
		for (Location loc : places) { 
			if (loc.zipCode == zipCode) {
				result.add(loc.cityName);
			}
		}
		return result;
	}

	/**
	 * Returns all the zipcodes that are contained in a particular city-state.
	 * The empty set is returned if the city-state pair is illegal.
	 * 
	 * @param cityName
	 *            target city name
	 * @param state
	 *            target state
	 * @return set with all relevant zipcodes.
	 */
	public Set<Integer> getZipCodes(String cityName, String state) {
		Set<Integer> result = new TreeSet<>(); // Have to pick concrete set (tree). Must be comparable
		for (Location loc : places) { // places = arraylist of locations
			if (loc.cityName.equals(cityName)) {
				if (loc.state.equals(state)) {
					result.add(loc.zipCode);
				}
			}
		}
		return result;
	}

	/**
	 * Returns a map that is keyed to state name. The values in the map is a set
	 * of zip codes that reside in that particular state. The map looks like:
	 * "AL" --> { 36863, 35755, ... } "AK" --> { 44256, 44257, ...} ...
	 * 
	 * @return mapping from states to set of zipcodes.
	 */
	public Map<String, Set<Integer>> getZipCodesInStates() {
		Map<String, Set<Integer>> map = new TreeMap<>();

		for (Location loc : places) {
			Set<Integer> data = new TreeSet<Integer>();
			map.put(loc.state, data);
		}
		for (Location loc : places) {
			map.get(loc.state).add(loc.zipCode);
		}
		return map;
	}

	/**
	 * Returns all the states that contain a particular city name. The empty set
	 * is returned if the city name is not any state.
	 * 
	 * @param cityName
	 *            target city name
	 * @return set of states that contain the target city.
	 */
	public Set<String> getStatesThatContainThisCity(String cityName) {
		Set<String> result = new TreeSet<String>(); // Have to pick concrete set (tree). Must be comparable
		for (Location loc : places) {
			if (loc.cityName.equals(cityName)) {
				result.add(loc.state);
			}
		}
		return result;
	}

	/**
	 * Returns the states that contain any of the target cities. The empty set
	 * is returned if none of the cities are in any state. This is similar to
	 * above but accepts multiple cities instead of single city.
	 * 
	 * @param cityNames
	 *            target cities
	 * @return set of states that contain any of the target cities.
	 */
	public Set<String> getStatesThatContainAnyOfTheseCities(Set<String> cityNames) {
		Set<String> result = new TreeSet<String>(); // Have to pick concrete set (tree). Must be comparable

		for (String city : cityNames) {
			for (Location loc : places) {
				if (loc.cityName.equals(city)) {
					result.add(loc.state);
				}
			}	
		}
		return result;
	}

	/**
	 * Returns all zipcodes that are within a specified distance from a
	 * particular zipcode.
	 * 
	 * @param zipCode
	 *            target zipcode
	 * @param distance
	 *            maximum distance from target zipcode
	 * @return all zipcodes that are within "distance" from the target zipcode
	 */
	public Set<Integer> getZipCodesCloseTo(int zipCode, double distance) {
		Set<Integer> result = new TreeSet<Integer>();
		double lat = 0;
		double lon = 0;
		for (Location loc : places) {
			if (loc.zipCode == zipCode) {
				lon = loc.longitude;
				lat = loc.latitude;
			}
		}
		for (Location loc : places) {
			if (haversine(lat, lon, loc.latitude, loc.longitude) <= distance) {
				if (loc.zipCode != zipCode) { // Exclude adding the original zip code
					result.add(loc.zipCode);
				} 
			}
		}
		return result;
	}

	// Conversion help from https://rosettacode.org/wiki/Haversine_formula
	public static double haversine(double lat1, double lon1, double lat2, double lon2) {
		final double R = 6372.8; // km
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		lat1 = Math.toRadians(lat1);
		lat2 = Math.toRadians(lat2);

		double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
		double c = 2 * Math.asin(Math.sqrt(a));
		return R * c;
	}

	/**
	 * Returns a map that is keyed to state name. The values in the map are the
	 * set of city names that reside in that particular state. The map looks
	 * like: "AL" --> { "MONTGOMERY", "MOBILE", ... } "AK" --> { "ANCHORAGE",
	 * "BARROW", ...} ...
	 * 
	 * @return mapping from states to set of city names.
	 */
	public Map<String, Set<String>> getCityNames() {
		Map<String, Set<String>> map = new TreeMap<>();
		for (Location loc : places) {
			Set<String> data = new TreeSet<String>();
			map.put(loc.state, data); // add states first
		}
		for (Location loc : places) {
			map.get(loc.state).add(loc.cityName); // add cities
		}
		return map;
	}

	/**
	 * Returns all city names that reside within a particular state.
	 * 
	 * @param state
	 *            target state
	 * @return set of city names
	 */
	public Set<String> allCityNames(String state) {
		Set<String> cities = new TreeSet<>();
		for (Location loc : places) {
			if (loc.state.equals(state)) {
				cities.add(loc.cityName);
			}
		}
		return cities;
	}

	/**
	 * Returns all city names that reside within any of the given states.
	 * 
	 * @param state
	 *            target states
	 * @return set of city names
	 */
	public Set<String> allCityNames(Set<String> states) {
		Set<String> result = new TreeSet<String>(); 

		for (String city : states) {
			for (Location loc : places) {
				if (loc.state.equals(city)) {
					result.add(loc.cityName);
				}
			}	
		}
		return result;
	}

	/**
	 * Returns all city names in the entire database
	 * 
	 * @return set of city names
	 */
	public Set<String> allCityNames() {
		Set<String> result = new TreeSet<String>(); 
		for (Location loc : places) {
			result.add(loc.cityName);
		}
		return result;
	}

	/**
	 * Returns all state names in the entire database
	 * 
	 * @return set of state names
	 */
	public Set<String> allStateNames() {
		Set<String> result = new TreeSet<String>(); // Have to pick concrete set (tree). Must be comparable
		for (Location loc : places) { // places = arraylist of locations
			result.add(loc.state);
		}
		return result;
	}

	/**
	 * Returns the city names that appear in both of the given states
	 * 
	 * @param state1
	 *            first target state
	 * @param state2
	 *            second target state
	 * @return set of city names
	 */
	public Set<String> getCommonCityNames(String state1, String state2) {
		Set<String> first = new TreeSet<String>(); 
		Set<String> second = new TreeSet<String>(); 
		Set<String> result = new TreeSet<String>(); 

		for (Location loc : places) { // add state 1 cities
			if (loc.state.equals(state1)) {
				first.add(loc.cityName);
			}
		}
		for (Location loc : places) { // add state 2 cities
			if (loc.state.equals(state2)) {
				second.add(loc.cityName);
			}
		}
		for (String city2 : second) { // compare both
			if (first.contains(city2)) {
				result.add(city2);
			}
		}
		return result;
	}

	/**
	 * Ranked list of states, where the ranking is ascending order of number of
	 * zipcodes.
	 * 
	 * @return
	 */
	public ArrayList<String> mostZipCodes() {
		ArrayList<String> list = new ArrayList<>(); 
		Map<String, Set<Integer>> zips = new TreeMap<>();
		Set<String> states = allStateNames();

		for (String state : states) {
			zips.put(state, new TreeSet<>()); // store in generic treeset
			for (Location loc : places) {
				if (loc.state.equals(state)) {
					zips.get(state).add(loc.zipCode);
				}
			}
		}
		while (!zips.isEmpty()) { // Go thru until empty
			int min = 6000; // https://www.zip-codes.com/zip-code-statistics.asp - Used to account for states with lots of codes
			String stateName = "";
			for (Map.Entry<String, Set<Integer>> values : zips.entrySet()) {
				if (values.getValue().size() < min) {
					min = values.getValue().size(); // new minimum number
					stateName = values.getKey(); 
				}
			}
			list.add(stateName); // add state to the array
			zips.remove(stateName);	 // remove the state so it's not considered anymore
		}
		return list;
	}

	/**
	 * The city name(s) that appears in the most states. Note, "NEW YORK" is
	 * credited with appearing in NY only once. That is, the large number of
	 * "NEW YORK" zipcodes does not make it a more common name.
	 * 
	 * @return set of city names
	 */
	public Set<String> cityNameInMostStates() {
		int min = 0;
		String winner = "";
		Set<String> allCities = allCityNames(); // every city
		Set<String> reply = new TreeSet<>(); // answer goes in here

		Map<String, Set<String>> cities = new TreeMap<>();
		for (String city : allCities) {
			cities.put(city, new TreeSet<String>());

			for (Location loc : places) {
				if (loc.cityName.equals(city)) {
					cities.get(city).add(loc.state);
				}
			}
		}
		for (String city : allCities) {
			if (cities.get(city).size() > min) { // Locate winner
				winner = city; // store name
				min = cities.get(city).size(); // store # of times seen
			}
		}
		reply.add(winner);
		return reply;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Places places = new Places("ZipCodes.txt");
		// Lab Tests:
		//System.out.println(places.getZipCodes("OXFORD", "OH"));
		//System.out.println(places.getZipCodes("RICHMOND", "IN"));
		//System.out.println(places.getStatesThatContainThisCity("OXFORD"));
		//System.out.println(places.getZipCodesInStates());
		//System.out.println(places.allStateNames());

		// End Lab Tests

		// HW:
		//Set<String> cityList = new TreeSet<>();
		//cityList.add("OXFORD");
		//cityList.add("DELAWARE");
		//System.out.println(places.getCityNameFromZipCode(45056));
		//System.out.println(places.getCityNameFromZipCode(10048));*
		//System.out.println(places.allCityNames("OH"));
		//System.out.println(places.getStatesThatContainAnyOfTheseCities(cityList));
		//Set<String> smallStates = new TreeSet<>();
		//smallStates.add("HI");
		//smallStates.add("AK");
		//System.out.println(places.allCityNames(smallStates));
		//Map<String, Set<String>> cities = places.getCityNames();
		//System.out.println(cities);
		//System.out.println(places.allCityNames());
		//System.out.println(cities.get("MI"));
		//System.out.println(places.getCommonCityNames("IN", "OH"));
		//System.out.println(places.cityNameInMostStates());
		//System.out.println(places.mostZipCodes());
		System.out.println(places.getZipCodesCloseTo(45056, 10));
	}
}