package sorting.array;

import sorting.array.utils.ArrayUtils;

public class KthElement {
	
	public static void main(String[] args) {
		int[] a = {2,5,7,3,8};
		int k = 2;
		System.out.println("is array sorted? "+ArrayUtils.isSorted(a, true));
		
		KthElement kthElement = new KthElement();
		System.out.println("length = "+a.length);
		int max = kthElement.findKthMax(a,k);
		System.out.println(k+"th MAX element is : "+max);
		
		int min = kthElement.findKthMin(a,k);
		System.out.println(k+"th MIN element is : "+min);
	}

	private int findKthMax(int[] a, int k) {
		for(int i =0; i<k;i++) {
			for(int j=0;j<a.length-1-i;j++) {
				if(a[j]>a[j+1]) {
					int temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		return a[a.length-k];
	}
	
	private int findKthMin(int[] a, int k) {
		for(int i = 0; i<k;i++) {
			for(int j=0;j<a.length-1-i;j++) {
				if(a[j]<a[j+1]) {
					int temp = a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		return a[a.length-k];
	}
	
	

}
