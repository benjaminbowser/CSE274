import TreePackage.*;
import java.util.*;

public class Driver {

	public static void displayTree(Iterator<Integer> iter) {
		while (iter.hasNext()) {
			System.out.print(iter.next() + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// BinaryNode<Integer> node = new BinaryNode<>();

		BinaryTree<Integer> bt1 = new BinaryTree<>(10, null, null);
		BinaryTree<Integer> bt2 = new BinaryTree<>(-12, null, null);
		BinaryTree<Integer> bt3 = new BinaryTree<>(10, bt1, bt2);
		BinaryTree<Integer> bt4 = new BinaryTree<>(1, null, null);
		BinaryTree<Integer> bt5 = new BinaryTree<>(100, null, bt4);
		BinaryTree<Integer> bt6 = new BinaryTree<>();
		bt6.setTree(1000, bt3, bt5); // don't use bt3 and bt5 below here.

		BinaryTree<Integer> tree = bt6;
		displayTree(tree.getPreorderIterator());
		displayTree(tree.getPostorderIterator());
		displayTree(tree.getInorderIterator());
		displayTree(tree.getLevelOrderIterator());

		System.out.println(tree.getNumberOfNodes());
		System.out.println(tree.getNumberOfLeaves());
		System.out.println(tree.isMaxHeap());
		System.out.println(tree.isFullTree());
	}
}
