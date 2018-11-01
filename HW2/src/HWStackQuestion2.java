// Benjamin Bowser
// CSE274 UA
import java.util.Stack;

public class HWStackQuestion2 {
// Question #2
	/**
	 * Rotates the top n elements of the stack. That is, when n = 3 and the stack
	 * looks like (vertical bar shows bottom of stack:
	 * | A B C D E
	 * 
	 * The top element is moved from the top and put into the nth position.
	 * For the above example, the stack becomes:
	 * | A B E C D
	 * |
	 * @param stk The stack to be processed
	 * @param n 
	 */
	public static <T> void rotate(Stack<T> stk, int n) {
		T temp = stk.pop();
		int count = 1;
		Stack<T> holder = new Stack<T>();
		while (count < n) {
			holder.push(stk.pop());
			count++;
		}
		stk.push(temp);

		while (!holder.isEmpty()) {
			T store = holder.pop();
			stk.push(store);
		}
	}
	
	// Code reused from Stack lab
	public static <T> void displayHelper(Stack<T> original) {
		Stack<T> temp = new Stack<T>();
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
	
	public static void main(String args[]) {
		Stack<String> demo = new Stack<String>();
		demo.push("A");
		demo.push("B");
		demo.push("C");
		demo.push("D");
		demo.push("E");
		
		rotate(demo, 3);
		displayHelper(demo);
	}
	
}
