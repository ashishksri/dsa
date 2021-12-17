package sorting.array.utils;

public class MergeUtils {
	
	private MergeUtils() {}
	
	public static int[] wayMerge(int[] a, int l, int m, int h) {
		int[] b = new int[a.length];
		int i = l;
		int j = m+1;
		System.out.println("l & m & h are: "+l+" "+m+" "+h);
		int k=l;
		while(i<=m && j<=h) {
			if(a[i] <= a[j]) {
				System.out.println("Inserting at position: from A"+(k));
				b[k++]=a[i++];
			}else {
				System.out.println("Inserting at position: from B"+(k));
				b[k++]=a[j++];
			}
		}
		while(i<=m) {
			b[k++]=a[i++];
		}
		while(j<=h) {
			b[k++]=a[j++];
		}
		for(int c=l;c<=h;c++) {
			a[c]=b[c];
		}
		return a;
	}

}
