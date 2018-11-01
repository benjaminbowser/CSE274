// Benjamin Bowser
// CSE 274 UA
// Broken out of HashedDictionary, to make things more readable
// for students
public class Utils {
	// Returns a prime integer that is >= the given integer.
	public static int getNextPrime(int integer) {
		// if even, add 1 to make odd
		if (integer % 2 == 0) {
			integer++;
		} // end if

		// test odd integers
		while (!isPrime(integer)) {
			integer = integer + 2;
		} // end while

		return integer;
	} // end getNextPrime

	// Returns true if the given integer is prime.
	public static boolean isPrime(int integer) {
		boolean result;
		boolean done = false;

		// 1 and even numbers are not prime
		if ((integer == 1) || (integer % 2 == 0)) {
			result = false;
		}

		// 2 and 3 are prime
		else if ((integer == 2) || (integer == 3)) {
			result = true;
		}

		else // integer is odd and >= 5
		{
			assert (integer % 2 != 0) && (integer >= 5);

			// a prime is odd and not divisible by every odd integer up to its
			// square root
			result = true; // assume prime
			for (int divisor = 3; !done && (divisor * divisor <= integer); divisor = divisor + 2) {
				if (integer % divisor == 0) {
					result = false; // divisible; not prime
					done = true;
				} // end if
			} // end for
		} // end if

		return result;
	} // end isPrime
}
