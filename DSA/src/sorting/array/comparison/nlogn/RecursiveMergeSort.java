package sorting.array.comparison.nlogn;

import sorting.array.utils.ArrayUtils;

public class RecursiveMergeSort {

	int[] A = { 3, 2, 12, 13, 4, 5, 6, 10, 11, 13 };
	int debug = 0;

	public static void main(String[] args) {

		RecursiveMergeSort mergeSort = new RecursiveMergeSort();
		int length = mergeSort.A.length - 1;
		mergeSort.mergeSort(0, length);
		System.out.println("Sorted array is: ");
		ArrayUtils.print(mergeSort.A);
	}

	private void mergeSort(int l, int h) {
		if (l < h) {
			int mid = (l + h) / 2;
			mergeSort(l, mid);
			mergeSort(mid + 1, h);
			merge(l, mid, h);
		}
	}

	private void merge(int l, int mid, int h) {
		if (debug == 1) {
			System.out.println("l & h are: " + l + " " + h);
		}
		int i = l;
		int j = mid + 1;
		int k = l;
		int[] c = new int[h + 1];
		if (debug == 1) {
			System.out.println("Array length is " + c.length);
		}
		while (i <= mid && j <= h) {
			if (debug == 1) {
				System.out.println("k is " + k);
			}
			if (A[i] <= A[j]) {
				c[k++] = A[i++];
			} else {
				c[k++] = A[j++];
			}
		}
		while (i <= mid) {
			c[k++] = A[i++];
		}
		while (j <= h) {
			c[k++] = A[j++];
		}
		for (k = l; k <= h; k++) {
			A[k] = c[k];
		}
	}
	
	public void setArray(int[] a) {
		this.A=a;
	}
	
	public int[] getSortedArray(int[] a) {
		setArray(a);
		mergeSort(debug, this.A.length-1);
		return this.A;
	}
}
