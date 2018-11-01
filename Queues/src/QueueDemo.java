import java.util.*;

public class QueueDemo {
	public static void demoDeque(Deque<String> deque) {
		System.out.println("");
		System.out.println("Demo of: " + deque.getClass().getName());
		deque.addFirst("A");
		deque.addLast("B");
		deque.addFirst("C");
		deque.addLast("D");
		while (!deque.isEmpty()) {
			System.out.println(deque.removeLast());
		}
	}

	public static void demoQueue(Queue<Person> queue) { 
		System.out.println("");
		System.out.println("Demo of: " + queue.getClass().getName());
		queue.add(new Person("John", "Doe", 10));
		queue.add(new Person("John", "Smith", 10));
		queue.add(new Person("John", "Doe", 30));
		queue.add(new Person("John", "Doe", 1));
		queue.add(new Person("Edgar", "Alveraz", 100));

		while (!queue.isEmpty()) {
			System.out.println(queue.remove());
		}
	}

	public static void main(String[] args) {
		demoQueue(new LinkedList<Person>());
		demoQueue(new PriorityQueue<Person>());
		demoDeque(new ArrayDeque<String>());
	}

}
