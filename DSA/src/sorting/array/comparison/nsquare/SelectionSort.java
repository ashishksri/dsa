package sorting.array.comparison.nsquare;

import sorting.array.utils.ArrayUtils;

public class SelectionSort {
	
	public static void main(String[] args) {
		int[] a = {8,6,3,2,5,4,8};
		SelectionSort selectionSort = new SelectionSort();
		System.out.println("Array before sorting: ");
		ArrayUtils.println(a);
		System.out.println("Array after sorting ascending: ");
		int[] k = selectionSort.sort(a, true);
		ArrayUtils.println(k);
		
		System.out.println("Array after sorting descending: ");
		k = selectionSort.sort(a, false);
		ArrayUtils.println(k);
		selectionSort.swap(10, 15);
	}

	/**
	 * Selection sort technique.<br>
	 * In first pass we select position to find out element for that position.<br>
	 * Initially we selecr position 0, and this position should contain minimum.<br>
	 * So, first find out minimum!
	 * @param a
	 * @param b
	 * @return
	 */
	private int[] sort(int[] a, boolean b) {
		for(int i=0;i<a.length-1;i++) {
			int k=i;
			for(int j=i+1; j<a.length;j++) {
				if(a[k]>a[j]) {
					k=j;
				}
			}
			int t = a[k];
			a[k]=a[i];
			a[i]=t;
			System.out.println((i+1)+"th minimum = "+a[i]);
		}
		System.out.println(a.length+"th minimum = "+a[a.length-1]);
		return a;
	}
	
	private void swap(int i, int j) {
		i=i+j;
		j=i-j;
		i=i-j;
		System.out.println("i is= "+i);
		System.out.println("j is= "+j);
	}

}
