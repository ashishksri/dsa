package sorting.array.comparison.nlogn;

import sorting.array.utils.ArrayUtils;

public class QuickSort {
	public static void main(String[] args) {
		int[] a = { 50, 15, 50, 60, 70, 90, 10, 20, 40, 50, 65, Integer.MAX_VALUE };
		QuickSort quickSort = new QuickSort();
		System.out.println("Array before sorting: ");
		ArrayUtils.println(a);
		int[] b = quickSort.sort(a, 0, a.length - 1);
		System.out.println("Array after sorting: ");
		ArrayUtils.print(b);

	}

	/**
	 * Quick sort technique.<br>
	 * It uses partitioning procedure.<br>
	 * In this technique, every element(pivot) tries to find sorted position for
	 * itself.<br>
	 * Then, the list is broken down from pivot in sublists.<br>
	 * This is called partitioning procedure.<br>
	 * 
	 * @param a
	 * @return
	 */
	private int[] sort(int[] a, int l, int h) {
		int j;
		if (l < h) {
			j = partition(a, l, h);
			sort(a, l, j);
			sort(a, j + 1, h);
		}
		return a;
	}

	private int partition(int[] a, int l, int h) {
		int p = a[l];
		int i = l, j = h;
		do {
			do {
				i++;
			} while (a[i] <= p);
			do {
				j--;
			} while (a[j] > p);
			if (i < j) {
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		} while (i < j);
		int t = a[l];
		a[l] = a[j];
		a[j] = t;
		return j;
	}

}