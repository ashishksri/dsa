package heap;

import sorting.array.utils.ArrayUtils;

public class HeapifyOperation {

	int[] a = { 0, 10, 20, 30, 25, 5, 40, 35, 45, 60, 70, 80 };

	public HeapifyOperation(int[] a) {
		this.a = a;
	}

	// Default array
	public HeapifyOperation() {
	}

	public static void main(String[] args) {
		HeapifyOperation operation = new HeapifyOperation();
		int[] heap = operation.heapify();
		System.out.println("After heapify..");
		ArrayUtils.print(heap);
	}

	public int[] heapify() {
		System.out.println("lenght is " + a.length);
		for (int i = (a.length - 1) / 2; i >= 1; i--) {
			System.out.println("i is" + i);
			int t = i;
			int left = 2 * t;
			int right = left + 1;

			while (t <= (a.length - 1) / 2) {
				System.out.println("t is " + t + " and left is " + left + " and right is " + right);
				int maxChildIndex = getMaxIndex(left, right);
				System.out.println("max child is " + a[maxChildIndex] + " and index is " + maxChildIndex);
				if (a[maxChildIndex] > a[t]) {
					int k = a[maxChildIndex];
					a[maxChildIndex] = a[t];
					a[t] = k;
				} else {
					break;
				}
				t = maxChildIndex;
				left = 2 * t;
				right = left + 1;
			}

		}
		return a;
	}

	public int[] heapify(int[] array) {
		System.out.println("lenght is " + array.length);
		for (int i = (array.length - 1) / 2; i >= 1; i--) {
			System.out.println("i is" + i);
			int t = i;
			int left = 2 * t;
			int right = left + 1;

			while (t <= (array.length - 1) / 2) {
				System.out.println("t is " + t + " and left is " + left + " and right is " + right);
				int maxChildIndex = getMaxIndex(left, right, array);
				System.out.println("max child is " + array[maxChildIndex] + " and index is " + maxChildIndex);
				if (array[maxChildIndex] > array[t]) {
					int k = array[maxChildIndex];
					array[maxChildIndex] = array[t];
					array[t] = k;
				} else {
					break;
				}
				t = maxChildIndex;
				left = 2 * t;
				right = left + 1;
			}

		}
		return a;
	}

	public int getMaxIndex(int left, int right) {
		if (right >= a.length) {
			return left;
		}
		if (a[left] > a[right]) {
			return left;
		}
		return right;
	}

	public int getMaxIndex(int left, int right, int[] array) {
		if (right >= array.length) {
			return left;
		}
		if (array[left] > array[right]) {
			return left;
		}
		return right;
	}

}
