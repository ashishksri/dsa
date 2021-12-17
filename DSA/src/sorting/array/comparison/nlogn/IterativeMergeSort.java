package sorting.array.comparison.nlogn;

import sorting.array.utils.ArrayUtils;
import sorting.array.utils.MergeUtils;

public class IterativeMergeSort {
	
	public static void main(String[] args) {
		int[] A = {3,2,12,13,4,5,6,10,11,13};
		
		int[] ASorted = (new IterativeMergeSort()).sort(A);
		System.out.println("Sorted array is: ");
		ArrayUtils.print(ASorted);
	}

	private int[] sort(int[] a) {
		System.out.println("length is: "+(a.length-1));
		int p;
		for(p=2;p<=a.length;p=p*2) {
			System.out.println("p is: "+p+"\n\n\n\n");
			for(int i=0; i+p-1<a.length;i=i+p) {
				int l = i;
				int h = i+p-1;
				int mid = (l+h)/2;
				a=MergeUtils.wayMerge(a, l, mid, h);
				System.out.println("Array returned is: ");
				ArrayUtils.print(a);
			}
			System.out.println("end p is: "+p+"\n\n\n\n");
		}
		System.out.println("p after loop is: "+p+"\n\n\n\n");
		
		if(p/2 < a.length) {
			a=MergeUtils.wayMerge(a, 0, p/2-1, a.length-1);
		}
		
		return a;
	}

}
