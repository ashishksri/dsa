package practise.sort;

import java.util.LinkedList;
import java.util.List;

class Solution {

	public static void main(String[] args) {

		int[] a = { 3, 2, 4, 1 };//4231 -> 1324
		Solution pancake = new Solution();
		List<Integer> list = pancake.pancakeSort(a);
		for (int b : list) {
			System.out.println(b);
		}
		int[] c = {1,3,2,4};
		System.out.println(isSorted(c, true));

	}

	public List<Integer> pancakeSort(int[] arr) {
		List<Integer> indices = new LinkedList<>();
		int r = arr.length - 1;
		while (!isSorted(arr, true)) {
			int maxIndex = findMaxIndex(arr, r);
			if (r == 1) {
				if (maxIndex == 0) {
					int t = arr[0];
					arr[0] = arr[r];
					arr[r] = t;
				}
				if (maxIndex != 0) {
					indices.add(maxIndex + 1);
				}

			} else {
				if (maxIndex == r) {
					System.out.println("matching at"+maxIndex);
				} else {
					// flip till max index;
					for (int i = 0; i <= (maxIndex) / 2; i++) {
						int t = arr[i];
						arr[i] = arr[maxIndex - i];
						arr[maxIndex - i] = t;
					}
					if (maxIndex != 0) {
						indices.add(maxIndex + 1);
					}
					// flip whole array
					if (!isSorted(arr, true)) {
						System.out.println("new r is"+r);
						for (int i = 0; i <= (r) / 2; i++) {
							int t = arr[i];
							arr[i] = arr[r - i];
							arr[r - i] = t;
						}

						indices.add(r + 1);
					}
				}
			}
			r--;
		}

		return indices;
	}

	private int findMaxIndex(int[] a, int r) {
		int maxIndex = 0;
		for (int i = 0; i <= r; i++) {
			if (a[i] > a[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
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
}
