package sorting.array.comparison.npow3by2;

import sorting.array.utils.ArrayUtils;

public class ShellSort {
	int[] a = {8,6,3,2,5,4,7,1,6,9,11,15,12};
	public static void main(String[] args) {
		
		ShellSort shellSort = new ShellSort();
		System.out.println("Array before sorting: ");
		ArrayUtils.print(shellSort.a);
		System.out.println("Array after sorting: ");
		shellSort.swapElementsAtGap(shellSort.a.length/2);
		ArrayUtils.print(shellSort.a);
		
		
	}

	/**
	 * Shell sort technique.<br> 
	 * 
	 * @param a
	 * @return
	 */
	private void swapElementsAtGap(int gap) {
		if(gap <= 0) {
			return;
		}
		for(int i=0; i+gap<a.length;i++) {
			int j=i+gap;
			if(a[i]>a[j]) {
				int t=a[i];
				a[i]=a[j];
				a[j]=t;
				int k=i-gap;
				
				while(k>=0 && a[k]>a[k+gap]) {
					int p = a[k];
					a[k]=a[k+gap];
					a[k+gap]=p;
					k-=gap;
				}
			}
			
		}
		swapElementsAtGap(gap/2);
	}
}