// Benjamin Bowser
// CSE274 UA
public class CircularDoublyLinkedDeque<T> implements DequeInterface<T> {

	private DLNode firstNode; 

	public CircularDoublyLinkedDeque() {
		firstNode = null;
	}

	public void addToFront(T newEntry) {
		DLNode newNode = new DLNode(newEntry);
		if (isEmpty()) {
			firstNode = newNode;
			newNode.setNextNode(newNode);
			newNode.setPreviousNode(newNode);
		}
		else {
			DLNode holder = firstNode.getPreviousNode(); // easy reference to the previous node
			holder.setNextNode(newNode); // previous to newnode
			newNode.setPreviousNode(holder); // newnode to previous
			newNode.setNextNode(firstNode); // newnode to the first
			firstNode.setPreviousNode(newNode); // first to the newnode
			firstNode = newNode; // important change
		}
	}

	public void addToBack(T newEntry) {

		DLNode newNode = new DLNode (newEntry);
		if (isEmpty()) {
			firstNode = newNode;
			newNode.setNextNode(newNode);
			newNode.setPreviousNode(newNode);
		}
		else {
			DLNode holder = firstNode.getPreviousNode(); // easy reference
			holder.setNextNode(newNode); // previous to new
			newNode.setNextNode(firstNode); // new to first
			firstNode.setPreviousNode(newNode); // first to new
			newNode.setPreviousNode(holder); // new to previous
		}
	}

	public T removeFront() {
		T front = getFront(); 
		DLNode holder = firstNode.getPreviousNode();
		assert (firstNode != null);
		firstNode = firstNode.getNextNode();

		if (firstNode == null) {
			return null;
		}
		else {
			holder.setNextNode(firstNode);
			firstNode.setPreviousNode(holder);
		}
		return front;
	}

	public T removeBack() {
		T back = getBack();
		DLNode holder = firstNode.getPreviousNode();
		assert (holder != null);
		holder = holder.getPreviousNode();

		if (holder == null) {
			firstNode = null;
		}
		else {
			holder.setNextNode(firstNode);
			firstNode.setPreviousNode(holder);
		}
		return back;
	}

	public T getFront() {
		T first = null;
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else {
			first = firstNode.getData();
		}
		return first;
	}

	public T getBack() {
		T last = null;
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		else { 
			last = firstNode.previous.getData();
		}
		return last;
	}

	public boolean isEmpty() {
		return firstNode == null;
	}

	public void clear() {
		firstNode = null;
	}

	public String toString() {
		String reply = "";
		DLNode curr = firstNode;
		while (curr != null) {
			reply += curr.getData() + " ";
			curr = curr.next;
			if (curr == firstNode) {
				return reply;
			}
		}
		return reply;
	}

	private class DLNode {
		private T data; // Deque entry
		private DLNode next; // Link to next node
		private DLNode previous; // Link to previous node

		private DLNode(T dataPortion) {
			data = dataPortion;
			next = null;
			previous = null;
		} // end constructor

		private DLNode(DLNode previousNode, T dataPortion, DLNode nextNode) {
			data = dataPortion;
			next = nextNode;
			previous = previousNode;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private DLNode getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(DLNode nextNode) {
			next = nextNode;
		} // end setNextNode

		private DLNode getPreviousNode() {
			return previous;
		} // end getPreviousNode

		private void setPreviousNode(DLNode previousNode) {
			previous = previousNode;
		} // end setPreviousNode
	} // end DLNode
} // end of class