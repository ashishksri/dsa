package practise.sort;

import sorting.array.utils.ArrayUtils;

public class PancakeSort {

	int[] a = { 3,2,4,1};

	public static void main(String[] args) {

		PancakeSort pancake = new PancakeSort();
		ArrayUtils.print(pancake.a);
		int c=1;
		c = pancake.sort(pancake.a.length-1,c);
		ArrayUtils.print(pancake.a);
		System.out.println("array sorted after "+c+" operations");

	}

	private int sort(int r,int c) {
		if(isSorted(a, true))
		{
			return c;
		}
		int maxIndex = findMaxIndex(r);
		if(r==1) {
			if(maxIndex==0) {
				int t = a[0];
				a[0]=a[r];
				a[r]=t;
			}
			return c;
		}
		if(maxIndex==r) {
			//Do nothing
		}else {
			//flip till max index;
			for(int i=0;i<=(maxIndex)/2;i++) {
				int t = a[i];
				a[i]=a[maxIndex-i];
				a[maxIndex-i]=t;
			}
			//flip whole array
			for(int i=0;i<(r)/2;i++) {
				int t = a[i];
				a[i]=a[r-i];
				a[r-i]=t;
			}
		}
		c=c+1;
		return sort(r-1,c);
	}

	private int findMaxIndex(int r) {
		int maxIndex=0;
		for(int i=0;i<=r;i++) {
			if(a[i]>a[maxIndex]) {
				maxIndex=i;
			}
		}
		return maxIndex;
	}
	
	/*
	 * private void flip(int r) { int maxIndex = findMaxIndex(r); for(int
	 * i=0;i<=(maxIndex-1)/2;i++) { int t = a[i]; a[i]=a[maxIndex-i];
	 * a[maxIndex-i]=t; } //flip whole array for(int i=0;i<(r-1)/2;i++) { int t =
	 * a[i]; a[i]=a[r-i]; a[r-i]=t; } }
	 */
	
	public static boolean isSorted(int[] a, boolean asc) {
		for (int i = 0; i < a.length - 1; i++) {
			if (asc) {
				if (a[i] > a[i + 1]) {
					return false;
				}
			} else {
				if (a[i] < a[i + 1]) {
					return false;
				}
			}
		}
		return true;
	}

}
