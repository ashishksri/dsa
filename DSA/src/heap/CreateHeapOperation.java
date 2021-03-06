package heap;

import sorting.array.utils.ArrayUtils;

public class CreateHeapOperation {
	
	int[] a = {0,10,20,30,25,5,40,35};
	
	public static void main(String[] args) {
		
		CreateHeapOperation operation = new CreateHeapOperation();
		int[] heap = operation.createHeap();
		System.out.println("heap generated");
		ArrayUtils.print(heap);
		
	}

	private int[] createHeap() {
		
		for(int i=2; i<a.length;i++) {
			int t=i;
			int parent = t/2;
			while(parent >= 1) {
				System.out.println("t is "+t+" parent is "+parent);
				if(a[t] > a[parent]) {
					int k = a[t];
					a[t]= a[parent];
					a[parent] = k;
				}else {
					break;
				}
				parent/=2;
				t/=2;
			}
		}
		return a;
	}
}
