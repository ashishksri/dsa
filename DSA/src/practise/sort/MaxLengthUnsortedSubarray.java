package practise.sort;

import sorting.array.utils.ArrayUtils;

public class MaxLengthUnsortedSubarray {

	int[] a = { 10, 20, 30, 80, 60, 50, 40, 100, 110 };

	public static void main(String[] args) {
		MaxLengthUnsortedSubarray subarrayLengthUnsortedSubarray = new MaxLengthUnsortedSubarray();

		System.out.println("full array ");
		ArrayUtils.print(subarrayLengthUnsortedSubarray.a);
		int[] subarray = subarrayLengthUnsortedSubarray.findUnsortedSubArray();
		System.out.println("unsorted sub array ");
		ArrayUtils.print(subarray);

	}

	private int[] findUnsortedSubArray() {
		int imin = findMinIndex();
		int imax = findMaxIndex();
		int l = 0, r = a.length - 1;
		if (imin != 0) {
			l = 0;
		} else {
			for (int i = 0; i < a.length; i++) {
				if (a[i] >= a[i + 1]) {
					l = i;
					break;
				}
			}
		}
		if (imax != a.length - 1) {
			// Do Nothing
		} else {
			while (r > l) {
				if (a[r] > a[l]) {
					r--;
				} else {
					break;
				}
			}
		}

		while(a[l]>a[r]) {
			l--;
		}
		l++;
		int[] b = new int[r-l+1];
		int j=0;
		while(l<=r) {
			b[j]=a[l];
			j++;
			l++;
		}

		return b;
	}

	private int findMaxIndex() {
		int maxIndex = 0;
		int c = 0;
		while (c < a.length) {
			if (a[c] > a[maxIndex]) {
				maxIndex = c;
			}
			c++;
		}
		return maxIndex;
	}

	private int findMinIndex() {
		int minIndex = 0;
		int c = 0;
		while (c < a.length) {
			if (a[c] < a[minIndex]) {
				minIndex = c;
			}
			c++;
		}
		return minIndex;
	}

}
