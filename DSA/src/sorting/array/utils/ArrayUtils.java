package sorting.array.utils;

public class ArrayUtils {

	public static void println(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
	public static void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void print(int[] a, int si) {
		for (int i = si; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void print(int[] a, int si, int ei) {
		for (int i = si; i < ei; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

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

	// {1,2,3,5,6,7}->{0,0,0,4,5,6,7}
	public static int[] insert(int[] a, int b) {
		if (a == null || a.length == 0) {
			return new int[] { b };
		}
		int[] c = new int[a.length + 1];
		for (int i = a.length - 1; i >= 0; i--) {
			if (a[i] >= b) {
				c[i + 1] = a[i];
			} else {
				c[i + 1] = b;
				for(int j=i;j>=0;j--) {
					System.out.println("inserting at index: "+j);
					c[j]=a[j];
				}
				break;
			}
		}
		return c;

	}
	
	public static int[] mergeSortedArrays(int[] a, int[] b) {
		if(a==null || a.length==0) {
			return b;
		}
		
		if(b==null || b.length==0) {
			return a;
		}
		
		int[] c = new int[a.length+b.length];
		int i=0;
		int j=0;
		int k=0;
		while(i<a.length && j<b.length) {
			if(a[i]<=b[j]) {
				c[k++] = a[i++];
			}else {
				c[k++] = b[j++];
			}
		}
		
		while(i<a.length) {
			c[k++]=a[i++];
		}
		
		while(j<b.length) {
			c[k++]=b[j++];
		}
		
		return c;
	}

}
