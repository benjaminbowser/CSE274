// Benjamin Bowser
// CSE274 UA

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
		//	BinaryTree<Integer> bt = new BinaryTree<>(20, null, null);
		//BinaryTree<Integer> bt2 = new BinaryTree<>(-60, null, null);
		BinaryTree<Integer> bt3 = new BinaryTree<>(15, null, null);
		//BinaryTree<Integer> bt4 = new BinaryTree<>(90, null, null);
		BinaryTree<Integer> bt5 = new BinaryTree<>(750, null, null);
		BinaryTree<Integer> bt6 = new BinaryTree<>();
		bt6.setTree(500, bt3, bt5);
		bt5.setTree(100, null, null);


		System.out.println("Number of nodes: "+bt6.getNumberOfNodes());
		System.out.println("Number of leaves: "+bt6.getNumberOfLeaves());
		System.out.println("Is full? "+bt6.isFullTree());
		System.out.println("Is BST? " +bt6.isBST());

		System.out.println("Is a 1 node tree considered full? "+bt5.isFullTree());
		System.out.println("Is a 1 node tree BST? " +bt5.isBST());

		displayTree(bt6.getPreorderIterator());
		displayTree(bt6.getPostorderIterator());
		displayTree(bt6.getInorderIterator());
		displayTree(bt6.getLevelOrderIterator());
	}
}
