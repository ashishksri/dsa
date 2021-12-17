package sorting.array.comparison.nlogn;

import sorting.array.utils.ArrayUtils;
import sorting.array.utils.MergeUtils;

public class MergeArray {
	
	public static void main(String[] args) {
		int[] a = {1,3,5,7,9};
		int[] b = {2,4,6,8,10,12,14};
		int[] c = ArrayUtils.mergeSortedArrays(a, b);
		System.out.println("merged array is: ");
		ArrayUtils.println(c);
		int[] d = {};
		int[] e = null;
		ArrayUtils.print(ArrayUtils.mergeSortedArrays(a, d));
		ArrayUtils.print(ArrayUtils.mergeSortedArrays(a, e));
		
		int[] A = {2,3,12,13,4,5,6,10,11};
		int h = A.length-1;
		int l = 0;
		int mid = (l+h)/2;
		int[] ASorted = MergeUtils.wayMerge(A, l, mid, h);
		ArrayUtils.print(ASorted);
	}
	

}
