package recursion.arrayADT;

public class ArraySortUtils {

	public static void main(String[] args) {
		int[] arr = { 0, 1, 5, 7, 9, 10, 15, 20, 22, 31, 49, 48, 63, 64 };
		int[] arr1 = { 1, 2, 3, 4, 5 };
		boolean isSorted = checkSorted(arr1);
		if (isSorted) {
			System.out.println("Array is sorted");
		} else {
			System.out.println("Array is not sorted");
		}

		boolean rear = true;
		int index = indexTillSorted(arr, rear);
		if (!rear) {
			if (index == arr.length - 2) {
				System.out.println("Full array is sorted");
			} else if (index == -1 || index == arr.length) {
				System.out.println("Array is not sorted");
			} else {
				System.out.println("Array is sorted till index: " + index);
			}
		}else {
			if(index == arr.length-1) {
				System.out.println("Array is not sorted");
			} else if(index == -1) {
				System.out.println("Array is completely sorted");
			}else {
				System.out.println("Array is sorted till index: "+index);
			}
		}
	}

	private static int indexTillSorted(int[] arr, boolean reverse) {
		if (reverse) {
			for (int j = arr.length - 1; j > 0; j--) {
				if (arr[j] < arr[j - 1]) {
					return j;
				}
			}
		} else {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					return i - 1;
				}
			}
		}
		return -1;
	}

	private static boolean checkSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}

		return true;
	}

}
