// Benjamin Bowser
// CSE274 UA
public class CircularTester {

	public static void main(String[] args) {
		CircularDoublyLinkedDeque<Integer> test = new CircularDoublyLinkedDeque<Integer>();
		test.addToFront(20);
		test.addToFront(50);
		test.addToBack(10);
		test.addToBack(12);
		test.addToFront(500);

		System.out.println("The Deque is empty: " + test.isEmpty());
		System.out.println("Front of Deque: " + test.getFront());
		System.out.println("Back of Deque: " + test.getBack());

		System.out.println("It looks like: "+ test.toString());

		System.out.println("The last element has been removed: "+test.removeBack());


		System.out.println("Back of Deque: " + test.getBack());
		System.out.println("It looks like: "+ test.toString());

		System.out.println("The first element will be removed: " + test.removeFront());


		System.out.println("Front of Deque: " + test.getFront());
		System.out.println("It looks like: "+ test.toString());

		System.out.println("Clearing the deque.");
		test.clear();
		System.out.println("The Deque is empty: " + test.isEmpty());	
	}
}