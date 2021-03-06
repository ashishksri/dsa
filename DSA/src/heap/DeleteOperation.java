package heap;

import sorting.array.utils.ArrayUtils;

public class DeleteOperation {
	int[] a = { 0, 10, 20, 30, 25, 5, 40, 35 };
	int[] maxHeap = {};
	int length = maxHeap.length;
	
	public static void main(String[] args) {
		DeleteOperation operation = new DeleteOperation();
		HeapifyOperation heapifyOperation = new HeapifyOperation(operation.a);
		operation.maxHeap = heapifyOperation.heapify();
		operation.length = operation.maxHeap.length;
		System.out.println("Max heap generated is..");
		ArrayUtils.print(operation.maxHeap);
		int element = operation.delete(operation.maxHeap);
		System.out.println("element is "+element+" new length is "+operation.length);
		System.out.println("Heap after delete : ");
		ArrayUtils.print(operation.maxHeap, 1, operation.length);
		
		System.out.println("Again..");
		element = operation.delete(operation.maxHeap);
		System.out.println("element is "+element+" new length is "+operation.length);
		System.out.println("Heap after delete : ");
		ArrayUtils.print(operation.maxHeap, 1, operation.length);
		
		while(operation.length != 1) {
			element = operation.delete(operation.maxHeap);
			System.out.println("element is "+element+" new length is "+operation.length);
			System.out.println("Heap after delete : ");
			ArrayUtils.print(operation.maxHeap, 1, operation.length);
			System.out.println();
		}
		
	}

	private int delete(int[] maxHeap) {
		int element = maxHeap[1];
		maxHeap[1] = maxHeap[length-1];
		length--;
		int i=1;
		int j = 2*i;
		while(j<length) {
			if(maxHeap[j+1]>maxHeap[j]) {
				j++;
			}
			if(maxHeap[j]>maxHeap[i]) {
				int t = maxHeap[j];
				maxHeap[j] = maxHeap[i];
				maxHeap[i] = t;
			}else {
				break;
			}
			i=j;
			j=2*i;
		}
		return element;
	}
}
