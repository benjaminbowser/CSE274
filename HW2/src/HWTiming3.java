// Benjamin Bowser
// CSE274 UA
import java.util.Date;

public class HWTiming3 {
	// (15 pts) At the end of Chapter 4 is a section named “Projects.” A short piece of code is shown to show how to time Java source code.
	//You will need this code to complete the following project. Present your timings in a graph; Excel is a good way to present data.
	//Do Project #2 (N vs N2 algorithm)
	
	
	// PDF FOR DATA

	public static void main(String[] args) {
	//timeA(100000); // n
	timeB(100000); // n^2
	}
	
	public static void timeA(int n) {
		Date current = new Date();
		long startTime = current.getTime();
		loopA(n);
		current = new Date(); // current time
		long stopTime = current.getTime();
		long elapsedTime = stopTime - startTime; //ms 
		System.out.println(elapsedTime);
		
	}
	
	public static void timeB(int n) {
		Date current = new Date();
		long startTime = current.getTime();
		// code to be timed
		loopB(n);
		current = new Date(); // current time
		long stopTime = current.getTime();
		long elapsedTime = stopTime - startTime; //ms 
		System.out.println(elapsedTime);
		
	}
	
	public static int loopA(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 10000; j++) {
				sum = sum + j;
			}
		}
		return sum;
	}

	public static int loopB(int n) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				sum = sum + j;
			}
		}
		return sum;
	}
}