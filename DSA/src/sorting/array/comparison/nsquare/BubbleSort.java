package sorting.array.comparison.nsquare;

import sorting.array.utils.ArrayUtils;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] a = {8,5,7,3,2,9,2,5};
		System.out.println("is array sorted? "+ArrayUtils.isSorted(a, true));
		
		BubbleSort bubbleSort = new BubbleSort();
		int[] b = bubbleSort.sort(a,true);
		System.out.println("Sorted array is:");
		ArrayUtils.println(b);
		System.out.println("is array sorted? "+ArrayUtils.isSorted(a, true));
		int[] c = {5,4,3,2,1};
		System.out.println("is array sorted in descending order? "+ArrayUtils.isSorted(c, false));
		
		System.out.println("Sorting in descending order: ");
		int[] d = bubbleSort.sort(a, false);
		ArrayUtils.println(d);
	}

	/**
	 * Adaptive bubble sort technique used.
	 * Compares the array in n number of passes.
	 * In every pass the heaviest element gets sorted.
	 * Complexity is O(n^2)
	 * @param a
	 * @return
	 */
	private int[] sort(int[] a, boolean asc) {
		if(a == null || a.length == 0) {
			System.out.println("Array is empty or null");
			return a;
		}
		for(int i=0; i<a.length;i++) {
			int swapCount = 0;
			for(int j=0; j<a.length-i-1; j++) {
				if(!asc) {
					if(a[j]<a[j+1]) {
						swapCount++;
						int temp = a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
					}
				}else {
					if(a[j]>a[j+1]) {
						swapCount++;
						int temp = a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
					}
				}
			}
			System.out.println("Array after "+(i+1)+" pass is: ");
			ArrayUtils.println(a);
			if(swapCount == 0) {
				System.out.println("Array sorted after "+(i+1)+" passes");
				return a;
			}
		}
		return a;
	}
	
}
