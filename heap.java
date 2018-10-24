package areas;

import java.util.*;

class heap {
	public static void main(String args[]) throws Exception {
		heap heap = new heap();
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		int array[] = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			array[i] = s.nextInt();
		}

		heap.heapSort(array);
		 for(int i=1;i<=N;i++){
		 System.out.print(array[i]+"-->");
		 }
		int Q = s.nextInt();
		int value;
		for (int i = 0; i < Q; i++) {
			value = s.nextInt();
			if (value == 1) {
				heap.Add(value);
			} else if (value == 2) {
				System.out.println(heap.Max(array));
			}
		}
	}

	void heapSort(int[] array) {
		int length = array.length;
		int N = length - 1;
		for (int i = N / 2; i >= 1; i--) {
			maxHeapTree(array, i, N);
		}
	}

	private void maxHeapTree(int[] array, int i, int length) {
		int left = 2 * i;
		int right = 2 * i + 1;
		int largest = i;

		if (left <= length && array[left] > array[i])
			largest = left;
		if (right <= length && array[right] > array[largest])
			largest = right;
		if (largest != i) {
			int temp = array[i];
			array[i] = array[largest];
			array[largest] = temp;
			maxHeapTree(array, largest, length);
		}
	}

	private int Max(int[] array) {
		return array[1];
	}

	private void Add(int value) {

	}
}
