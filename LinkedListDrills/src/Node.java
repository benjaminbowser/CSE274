
public class Node {

	public int data;
	public Node next;
	Node(int dataPortion) {
		data = dataPortion;
		next = null;
	}
	public static void print(String name, Node n) {
		System.out.print(name + ":");
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
	public static void main(String [] args) {

	
		Node head = null;
		for (int i = 1; i <= 5; i++) {
			Node ni = new Node(i);
			Node n2i = new Node(2*i);
			n2i.next = head;
			ni.next = n2i;
			head = ni;
		}
		print("head", head);

		
	}




}
