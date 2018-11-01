// Benjamin Bowser
// CSE274 UA
public class StackDemo {
	public static void main(String args[]) {
		
		ArrayStack<String> array = new ArrayStack<String>();
		LinkedStack<Integer> linked = new LinkedStack<Integer>();
		VectorStack<Double> vector = new VectorStack<Double>();

		System.out.println("Adding to Array Stack:");
		array.push("CSE174");
		array.push("CSE271");
		array.push("CSE274");
		System.out.println("Peeking: " +array.peek());
		array.push("CSE385");
		array.push("STA301");
		array.pop();
		System.out.println("Printing Array Stack:");
		displayStack(array);
		array.clear();
		System.out.println("Array Stack is empty? " +array.isEmpty());

		System.out.println("Adding to Linked Stack:");
		linked.push(2);
		linked.push(4);
		System.out.println("Peeking: " +linked.peek());
		linked.push(8);
		linked.push(16);
		linked.push(32);
		linked.push(220);
		linked.pop();
		System.out.println("Printing Linked Stack:");
		displayStack(linked);
		linked.clear();
		System.out.println("Linked Stack is empty? " +linked.isEmpty());

		System.out.println("Adding to Vector Stack:");
		vector.push(20.2);
		vector.push(45.44);
		vector.push(89.404);
		vector.push(77.514125);
		vector.push(2205.62);
		vector.push(146.520);
		System.out.println("Peeking: " +vector.peek());
		vector.push(446.000);
		vector.push(220.000);
		vector.pop();
		System.out.println("Printing Vector Stack:");
		displayStack(vector);
		vector.clear();
		System.out.println("Vector Stack is empty? " +vector.isEmpty());

	}
	public static <T> void displayHelper(StackInterface<T> temp, StackInterface<T> original) {
		T store = null;
		while (!original.isEmpty()) {
			temp.push(original.pop());
		}
		while (!temp.isEmpty()) {
			store = temp.pop();
			System.out.println(store);
			original.push(store);
		}
	}

	public static <T> void displayStack(StackInterface<T> sk) {		
		if (sk instanceof ArrayStack) {
			ArrayStack<T> temp1 = new ArrayStack<T>();
			displayHelper(temp1, sk);
		}
		else if (sk instanceof LinkedStack) {
			LinkedStack<T> temp2 = new LinkedStack<T>();
			displayHelper(temp2, sk);
		}
		else {
			VectorStack<T> temp3 = new VectorStack<T>();
			displayHelper(temp3, sk);
		}
	}
}