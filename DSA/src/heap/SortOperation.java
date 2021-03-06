package heap;

import sorting.array.utils.ArrayUtils;

public class SortOperation {

	int[] a = { 0, 10, 20, 30, 25, 5, 40, 35 };

	public static void main(String[] args) {
		SortOperation operation = new SortOperation();
		operation.sort();
		System.out.println("Heap after sorting is: ");
		ArrayUtils.print(operation.a);
		
		System.out.println("recursive sort..");
		operation.sort(operation.a.length-1);
		System.out.println("Heap after sorting is: ");
		ArrayUtils.print(operation.a);
	}

	private void sort() {
		int length = a.length - 1;
		heapify(length);
		while (length >= 2) {
			int element = a[1];
			a[1] = a[length];
			a[length] = element;
			length--;
			heapify(length);
		}
	}

	private void sort(int length) {
		if (length == 2) {
			return;
		}
		heapify(length);
		int element = a[1];
		a[1] = a[length];
		a[length] = element;
		length--;
		sort(length);
	}

	private void heapify(int length) {
		for (int k = length / 2; k >= 1; k--) {
			int i = k;
			int j = 2 * i;
			while (j <= length) {
				if ((j + 1) <= length) {
					if (a[j + 1] > a[j]) {
						j++;
					}
				}
				if (a[j] > a[i]) {
					int t = a[j];
					a[j] = a[i];
					a[i] = t;
				} else {
					break;
				}
				i = j;
				j = 2 * i;
			}
		}
	}

}
