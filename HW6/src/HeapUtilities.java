// Benjamin Bowser
// CSE274 UA
import java.util.Arrays;

public class HeapUtilities<T> {

	public static <T extends Comparable<T>> boolean isHeap(T [] heap, int heapSz) {
		for (int i = 1; i < (heapSz)/2; i++) {
			if (heap[2*i].compareTo(heap[i]) > 0) { // left
				return false;
			}
			if (heap[2*i+1].compareTo(heap[i]) > 0) { // right
				return false;
			}
		}
		if (heapSz % 2 != 0) { // single leaf
			if (heap[heapSz-1].compareTo(heap[heapSz/2]) > 0) {
				return false;
			}
		}
		return true;
	}

	public static <T extends Comparable<T>> void changeHeap(T [] heap, int heapSz,	int whichElement, T newValue) {
		heap[whichElement] = newValue; // swap
		while (heap[whichElement].compareTo(heap[whichElement / 2]) > 0 && whichElement > 1)
		{
			T data = heap[whichElement / 2];
			heap[whichElement / 2] = newValue;
			heap[whichElement] = data;
			whichElement = whichElement / 2;
		}
		if ((whichElement*2 + 1) < heapSz) { // less than heapsize
			while ((whichElement*2 + 1) < heapSz && (heap[whichElement].compareTo(heap[whichElement*2]) < 0 || heap[whichElement].compareTo(heap[whichElement*2 +1]) < 0)) {
				if (whichElement*2 +1 == heapSz) {
					if ((heap[whichElement].compareTo(heap[whichElement*2]) < 0)) {
						T temp = heap[whichElement*2];
						heap[whichElement*2] = newValue;
						heap[whichElement] = temp;
						whichElement = whichElement*2;
					}
				}
				else if ((heap[whichElement].compareTo(heap[whichElement*2]) < 0 && heap[whichElement].compareTo(heap[whichElement * 2 + 1]) < 0)) {
					int max;
					if (heap[whichElement +2].compareTo(heap[whichElement*2 + 1]) > 0) {
						max = whichElement*2;
					}
					else if (heap[whichElement*2].compareTo(heap[whichElement*2 +1]) < 0) {
						max = whichElement*2 + 1;
					}
					else {
						max = whichElement*2;
					}
					T data = heap[max];
					heap[max] = newValue;
					heap[whichElement] = data;
					whichElement = max;
				}
				else if (heap[whichElement].compareTo(heap[whichElement*2]) < 0) {
					T data = heap[whichElement*2]; // right is larger
					heap[whichElement*2] = newValue;
					heap[whichElement] = data;
					whichElement = whichElement*2;
				}
				else if (heap[whichElement].compareTo(heap[whichElement*2 +1]) < 0) {
					T data = heap[whichElement*2 +1]; // right is larger
					heap[whichElement*2 +1] = newValue;
					heap[whichElement] = data;
					whichElement = whichElement*2 +1;
				}
			}
		}
	}

	public static void main(String[] args) {
		Integer[] heap = {-1, 20, 19, 13, 8, 7};
		Integer[] heap2 = {-1, 90, 15, 10, 7, 12, 2, 7, 3};
		HeapUtilities.changeHeap(heap, heap.length, 3, 2);
		System.out.println(Arrays.deepToString(heap));
		System.out.println(HeapUtilities.isHeap(heap2, heap2.length));
	}
}