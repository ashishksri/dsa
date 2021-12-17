package heap;

import sorting.array.utils.ArrayUtils;

public class InsertOperation {

	int[] heap = { Integer.MAX_VALUE };

	public static void main(String[] args) {

		InsertOperation operations = new InsertOperation();

		System.out.println("array length = " + operations.heap.length);
		int element = 25;
		operations.insert(element);
		ArrayUtils.print(operations.heap, 1);
		operations.insert(45);
		ArrayUtils.print(operations.heap, 1);
		operations.insert(50);
		ArrayUtils.print(operations.heap, 1);
		operations.insert(60);
		ArrayUtils.print(operations.heap, 1);
		operations.insert(15);
		ArrayUtils.print(operations.heap, 1);
		operations.insert(70);
		ArrayUtils.print(operations.heap, 1);

	}

	private void insert(int e) {
		int[] tempArr = getTempArray(e);
		int length = tempArr.length - 1;
		int temp = tempArr[length];
		while (length > 1 && tempArr[length / 2] < temp) {
			tempArr[length] = tempArr[length / 2];
			length /= 2;
		}
		tempArr[length] = temp;
		heap = tempArr;

	}

	private int[] getTempArray(int e) {
		int[] temp = new int[heap.length + 1];
		int i = 0;
		for (; i < heap.length; i++) {
			temp[i] = heap[i];
		}
		temp[i] = e;
		return temp;
	}

}
