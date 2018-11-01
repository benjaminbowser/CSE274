// Benjamin Bowser
// CSE274 UA
import java.util.ArrayList;

public class MyBigInt {

	private ArrayList<Integer> num = new ArrayList<Integer>();
	private boolean positive = true;
	private String original;


	public boolean isPositive() { // Getter
		return positive;
	}

	public void setPositive(boolean positive) {
		this.positive = positive;
	}

	public ArrayList<Integer> getNum() { // Getter
		return num;
	}

	public String getOriginal() {
		return original;
	}

	/**
	 *  Creates a new MyBigInt with the number 0
	 */
	public MyBigInt () {
		num.add(0);
	}

	/**
	 * Creates a new MyBigInt with the specified value
	 * @param value
	 * 				Long value for a number
	 */
	public MyBigInt(long value)	{
		this(Long.toString(value));
		// Avoid duplicate code by converting to
		// a string.
	}

	/**
	 * Creates a new MyBigInt with the specified string
	 * @param str
	 * 			  Representation for a number in a string
	 */
	public MyBigInt(String str)	{
		original = str;
		if (str.contains("-")) {
			positive = false;
			str = str.substring(1, str.length());
		}
		int length = str.length();
		for (int i = length-1; i >= 0; i--) {
			String current = str.substring(i,i+1);
			num.add(Integer.parseInt(current));
		}
	}

	public String toString() {
		String value = "";
		if (positive != true) {
			value = value + "-";
		}
		for (int i = num.size()-1; i >= 0; i--) {
			value += num.get(i);
		}
		if (value.charAt(0) == '0') { // If string has extra 0 at start
			value = value.substring(1, value.length());
		}
		return value;
	}

	/**
	 * Adds two MyBigInt objects together
	 * 
	 * @param other
	 * 				MyBigInt object to be added to
	 * @return 
	 * 				MyBigInt object
	 */
	public MyBigInt add(MyBigInt other)	{
		boolean carry = false; // carry flag
		ArrayList<Integer> large = new ArrayList<Integer>();
		ArrayList<Integer> small = new ArrayList<Integer>();
		int sum = 0;

		if (positive && other.isPositive() || !positive && !other.isPositive()) {

			if (other.getNum().size() > num.size()) {
				other.setPositive(false);
				large.addAll(other.getNum());
				small.addAll(num);
			}
			else {
				large.addAll(num);
				small.addAll(other.getNum());
			}
			num.clear();

			for (int i = 0; i < small.size(); i++) {
				int largeAdd = large.get(i);
				int smallAdd = small.get(i);
				sum = largeAdd + smallAdd;

				if (carry == true) { 
					sum = sum + 1; 
					carry = false; 		
				}
				if (sum > 10) {
					carry = true;
					sum = sum - 10; 
					num.add(i, sum);
				}
				else {
					num.add(i, sum);
				}
			}
			if (carry == true) { // after loop if leading # results in a carry
				num.add(small.size(), 1);
			}
			for (int i = small.size(); i < large.size(); i++) {
				if (carry == true) {
					num.add(i, large.get(i) + 1);
					carry = false;
				}
				else {
					num.add(i, large.get(i));
				}
			}
		}
		else {
			this.setPositive(true);
			other.setPositive(true);
			MyBigInt sub = this.subtract(other);
			sub.setPositive(true);
			return sub;
		}
		// toString requires an object be used, so use
		// similar code here to create object
		String total = "";
		if (!positive && !other.isPositive()) {
			total = total + "-";
		}
		for (int i = num.size()-1; i >= 0; i--) {
			total = total + num.get(i);
		}
		return (new MyBigInt(total)); // Must return object

	}

	/**
	 * Subtracts two MyBigInt objects
	 * 
	 * @param other
	 * 				MyBigInt object to be subtracted
	 * @return 
	 * 				MyBigInt object
	 */
	public MyBigInt subtract(MyBigInt other) {
		boolean borrow = false; // borrow flag
		ArrayList<Integer> first = new ArrayList<Integer>();
		ArrayList<Integer> second = new ArrayList<Integer>();
		int ans = 0;

		if (positive && other.isPositive() || !positive && !other.isPositive()) {
			first.addAll(num);
			second.addAll(other.getNum());
			num.clear();

			if (new MyBigInt(original).max(other) != other) { // if first is smaller than second
				positive = false;
				for (int i = 0; i < second.size() ; i++) {
					int top = first.get(i);
					int bottom = second.get(i);
					ans = top - bottom;
					if (borrow == true) { 
						ans = ans - 1; 
						borrow = false; 	
					}
					if (ans < 0) {
						borrow = true;
						ans = ans + 10; 
						num.add(i, ans);
					}
					else {
						num.add(i, ans);
					}
				}
				for (int i = second.size(); i < first.size(); i++) {
					// Run with longer array to copy numbers in
					if (borrow == true) {
						ans = first.get(i) - 1;

						if (ans < 0) {
							ans = ans + 10; // borrow the 10's
							num.add(i, ans);
							borrow = true;
						}
						else {
							borrow = false;
							num.add(i, ans);
						}
					}
					else {
						num.add(i, first.get(i));
					}
				}
			}
			else {
				for (int i = 0; i < first.size() ; i++) {
					int bottom = first.get(i);
					int top = second.get(i);
					ans = top - bottom;

					if (borrow == true) { 
						ans = ans - 1; // account for 10's
						borrow = false; // set it back to false		
					}
					if (ans < 0) {
						borrow = true;
						ans = ans + 10;
						num.add(i, ans);
					}
					else {
						num.add(i, ans);
					}
				}
				for (int i = second.size(); i < first.size(); i++) {

					if (borrow == true) {
						ans = first.get(i) - 1;
						if (ans < 0) {
							ans = ans + 10; // borrow the 10's
							num.add(i, ans);
							borrow = true;
						}
						else {
							borrow = false;
							num.add(i, ans);
						}
					}
					else {
						num.add(i, first.get(i));
					}
				}
			}
		}
		else {
			this.setPositive(true);
			other.setPositive(true);
			MyBigInt sub = this.add(other);
			sub.setPositive(false);
			return sub;
		}
		String total = "";
		for (int i = num.size()-1; i >= 0; i--) {
			total = total + num.get(i);
		}
		return (new MyBigInt(total)); // Must return object
	}

	/**
	 * Takes a MyBigInt and negates it
	 * @return 
	 * 			MyBigInt object
	 */
	public MyBigInt negate() {
		if (positive == true) {
			positive = false;
		}
		else {
			positive = true;
		}
		return this;
	}

	/**
	 * Compares two MyBigInt objects. Same returns 0,
	 * original larger returns 1, smaller returns -1
	 * @param other 
	 * 			MyBigInt object
	 * @return 
	 *		 int Value of comparison
	 */
	public int compareTo(MyBigInt other) {
		if (other.getOriginal().equals(original)) {
			return 0;
		}
		if (this.max(other) == this) {
			return 1;
		}
		else {
			return -1;
		}
	}

	/**
	 * Returns the biggest of two MyBigInt objects
	 * @param other 
	 * 			MyBigInt object
	 * @return 
	 * 			Largest MyBigInt object
	 */
	public MyBigInt max(MyBigInt other) { // TEST THIS
		if (num.size() > other.getNum().size()) {
			return this;
		}
		if (other.getNum().size() > num.size()) {
			return other;
		}
		if (other.getNum().size() == num.size()) {
			for (int i = num.size() - 1; i >= 0; i--) { // Use either one for size, are both same
				int first = num.get(i);
				int second = other.getNum().get(i);
				if (first > second) {
					return this;
				}
				if (second > first) {
					return other;
				}
			}
		}
		return other;
	}

	/**
	 * Returns the smallest of two MyBigInt objects
	 * @param other 
	 * 			MyBigInt object
	 * @return 
	 * 		Smallest MyBigInt object
	 */
	public MyBigInt min(MyBigInt other)	{
		if (num.size() > other.getNum().size()) {
			return other;
		}
		if (other.getNum().size() > num.size()) {
			return this;
		}
		if (other.getNum().size() == num.size()) {
			for (int i = num.size() - 1; i >= 0; i--) {
				int first = num.get(i);
				int second = other.getNum().get(i);
				if (first < second) {
					return this;
				}
				if (second < first) {
					return other;
				}
			}
		}
		return other;
	}

	/**
	 * Returns a numerical amount based on the value of the
	 * object. -1 if negative, 0 if 0, and 1 if positive.
	 * @return 
	 *		 int Value of comparison
	 */
	public int signum()	{ 
		if (positive == true) {
			return 1;
		}
		if (num.size() == 1 && num.get(0) == 0) {
			return 0;
		}
		else {
			return -1;
		}
	}

	/**
	 * Returns the value of a long value as a MyBigInt object
	 * @param value
	 * 			Number to be constructed
	 * @return 
	 * 		MyBigInt object of value
	 */
	public static MyBigInt valueOf(long value) {
		return (new MyBigInt(value));
	}
}