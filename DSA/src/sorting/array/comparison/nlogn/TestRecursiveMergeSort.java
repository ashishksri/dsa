package sorting.array.comparison.nlogn;

import sorting.array.utils.ArrayUtils;

public class TestRecursiveMergeSort {

	public static void main(String[] args) {
		int[] A = { 3, 1, 2, 12, 13, 4, 5, 6, 10, 11, 13, 14 };
		RecursiveMergeSort mergeSort = new RecursiveMergeSort();
		int[] B=mergeSort.getSortedArray(A);
		ArrayUtils.print(B);
	}

}
