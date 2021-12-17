package recursion.arrayADT;

public class IterativeBinarySearch {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, 9, 10, 15, 20, 22, 31, 45, 48, 61 };

		IterativeBinarySearch search = new IterativeBinarySearch();
		int key = 33;
		int index = search.binarySearch(arr, key);
		if(index == -1) {
			System.out.println("Element not found");
		}else {
			System.out.println("Element"+ key+", found at index "+index);
		}
	}

	private int binarySearch(int[] arr, int key) {
		int l = 0;
		int h = arr.length - 1;
		int mid = (l + h) / 2;
		while (l <= h) {
			if(arr[mid] == key) {
				return mid;
			}else if(key < arr[mid]){
				h = mid-1;
			}else {
				l = mid+1;
			}
			mid = (l+h)/2;
		}
		return -1;

	}

}
