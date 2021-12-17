package recursion.arrayADT;

public class RecursiveBinarySearch {
	
	public static void main(String[] args) {
		int[] arr = { 1, 5, 7, 9, 10, 15, 20, 22, 31, 45, 48, 61 };

		RecursiveBinarySearch search = new RecursiveBinarySearch();
		int key = 20;
		int index = search.binarySearch(arr, key, 0, arr.length-1);
		if(index==-1){
			System.out.println("Element not found");
		}else{
			System.out.println("Element " + key + ", found at index " + index);
		}
	}

	private int binarySearch(int[] arr, int key, int l, int h) {
		int mid = (l+h)/2;
		if(l > h) {
			return -1;
		} else if(arr[mid] == key) {
			return mid;
		} else if(key < arr[mid]) {
			return binarySearch(arr, key, l, mid-1);
		} else {
			return binarySearch(arr, key, mid+1, h);
		}
		
	}
}
