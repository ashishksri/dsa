package sorting.array.comparison.nsquare;

import sorting.array.utils.ArrayUtils;

public class InsertionSort {
	
	public static void main(String[] args) {
		int[] a = {8,5,7,3,2};
		int[] d = {1,2,3,5,6,7};
		System.out.println("Array before insertion:");
		ArrayUtils.println(d);
		int[] e = ArrayUtils.insert(d, 4);
		System.out.println("Array after insertion:");
		ArrayUtils.println(e);
		int[] f = ArrayUtils.insert(e, 9);
		System.out.println("Array after insertion:");
		ArrayUtils.println(f);
		InsertionSort insertionSort = new InsertionSort();
		System.out.println("Array before sorting: ");
		ArrayUtils.println(a);
		System.out.println("Array after sorting ascending: ");
		int[] k = insertionSort.sort(a, true);
		ArrayUtils.println(k);
		
		System.out.println("Array after sorting descending: ");
		k = insertionSort.sort(a, false);
		ArrayUtils.println(k);
		/*
		 * int[] b = insertionSort.sort(a,true);
		 * System.out.println("Array after sorting in ascending order: ");
		 * ArrayUtils.print(a);
		 */
	}

	/**
	 * Insertion sort technique<br>
	 * 
	 * @param a
	 * @param asc
	 * @return
	 */
	private int[] sort(int[] a, boolean asc) {
		for(int i=1;i<a.length;i++) {
			int j=i-1;
			int t = a[i];
			if(asc) {
				while(j>=0 && a[j]>t) {
					a[j+1]=a[j];
					j--;
				}
			}else {
				while(j>=0 && a[j]<t) {
					a[j+1]=a[j];
					j--;
				}
			}
			a[j+1]=t;
		}
		return a;
	}

}
