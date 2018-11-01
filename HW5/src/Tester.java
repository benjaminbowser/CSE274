// Benjamin Bowser
// CSE 274 UA
import java.util.Date;

public class Tester {
	// Enum help from: https://stackoverflow.com/questions/8114174/how-to-randomize-enum-elements
	public enum Make {
		Honda, Toyota, Scion, Hyundai, Mcclaren, Dodge, Chevrolet, Saab, Ford, Subaru, Smart, Tesla, AlfaRomeo, Volkswagon, Fiat, Jaguar, Audi, BMW, Infiniti,
		Mazda, Kia, Volvo, Peugeot, Jeep, LandRover, Shelby, Hummer;

		public static Make getRandomMake() {
			return values()[(int) (Math.random() * values().length)];
		}
	}

	public enum Model {
		Outlander, Outback, Corolla, Fit, F150, Camry, CRV, Competizione, Spider, Lancer, Focus, Fiesta, Flex, Edge, Explorer, Transit, Ranger, Equinox, Roadster;

		public static Model getRandomModel() {
			return values()[(int) (Math.random() * values().length)];
		}
	}

	public enum Color {
		Red, Green, Blue, Yellow, Black, White, Orange, Magenta, Silver, Gold, Tan, Striped, Rainbow, Teal, Cyan, LightBlue, DarkRed, Gunmetal, Pink, Camo;

		public static Color getRandomColor() {
			return values()[(int) (Math.random() * values().length)];
		}
	}

	public static void tester1() {
		HashedSetSCJLL set = new HashedSetSCJLL();
		for (int i = 0; i < 100000; i++) {
			int year = (int)(Math.random() * ((2018 - 1990) + 1) + 1990);
			// Forming objects like this will put makes with models that do not exist, but it will give a widespread range of data
			Car data = new Car(year, Make.getRandomMake().toString(), Model.getRandomModel().toString(), Color.getRandomColor().toString());
			set.add(data);
			
		}
		//set.displayHashTable();
	}

	public static void tester2() {
		HashedSetSCSLL set = new HashedSetSCSLL();
		for (int i = 0; i < 100000; i++) {
			int year = (int)(Math.random() * ((2018 - 1990) + 1) + 1990);
			// Forming objects like this will put makes with models that do not exist, but it will give a widespread range of data
			Car data = new Car(year, Make.getRandomMake().toString(), Model.getRandomModel().toString(), Color.getRandomColor().toString());
			set.add(data);
		}
		//set.displayHashTable();
	}

	public static void timeA() {
		Date current = new Date();
		long startTime = current.getTime();
			tester1();
		
		current = new Date(); // current time
		long stopTime = current.getTime();
		long elapsedTime = stopTime - startTime; //ms 
		System.out.println("JLL: " + elapsedTime + " MS ");
	}

	public static void timeB() {
		Date current = new Date();
		long startTime = current.getTime();
			tester2();
		
		current = new Date(); // current time
		long stopTime = current.getTime();
		long elapsedTime = stopTime - startTime; //ms 
		System.out.println("SLL: " +elapsedTime + " MS");
	}

	public static void main(String[] args) {
		timeA();
		timeB();	
	}
}