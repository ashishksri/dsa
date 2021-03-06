package greedy.optimalmerge;

public class OptimalMerge {

	int[] a;
	int minComputation = 0;
	int[] minHeap;
	int length = 0;
	boolean debug = false;

	public static void main(String[] args) {
		OptimalMerge merge = new OptimalMerge();

		int[] files = { 3,5,6,4,2 };
		merge.setA(files);

		merge.minComputation = merge.findMinComputation();
		System.out.println("Min computation = " + merge.getMinComputation());
	}

	private int getMinComputation() {
		createMinHeap();
		if (debug) {
			System.out.println("min heap is: ");
			for (int i = 1; i < length; i++) {
				System.out.print(minHeap[i] + " ");
			}
			System.out.println();
		}
		while (length > 2) {
			this.minComputation=0;
			minComputation += popHeap();
			minComputation += popHeap();
			insertHeap(minComputation);
			if (debug) {
				System.out.println("min heap is: ");
				for (int i = 1; i < length; i++) {
					System.out.print(minHeap[i] + " ");
				}
				System.out.println("length is "+length);
			}
		}
		if (debug) {
			System.out.println("min heap is: ");
			for (int i = 1; i < length; i++) {
				System.out.print(minHeap[i] + " ");
			}
			System.out.println();
		}
		return this.minComputation;
	}

	private void createMinHeap() {
		length = a.length + 1;
		minHeap = new int[length];
		minHeap[0] = Integer.MAX_VALUE;
		for (int i = 1; i < minHeap.length; i++) {
			minHeap[i] = a[i - 1];
		}

		heapify();

	}

	private int popHeap() {
		int element = minHeap[1];
		minHeap[1] = minHeap[length - 1];
		length--;
		heapify();
		return element;
	}

	private void insertHeap(int e) {
		length++;
		minHeap[length - 1] = e;
		heapify();
	}

	private void heapify() {
		for (int i = (length - 1) / 2; i >= 1; i--) {
			int t = i;
			int j = 2 * t;
			while (j < length) {
				if ((j + 1) < length) {
					if (minHeap[j + 1] < minHeap[j]) {
						j++;
					}
				}
				if (minHeap[j] < minHeap[t]) {
					int k = minHeap[t];
					minHeap[t] = minHeap[j];
					minHeap[j] = k;
				} else {
					break;
				}
				t = j;
				j = 2 * t;

			}
		}
	}

	private int findMinComputation() {
		return 0;
	}

	private void setA(int[] a) {
		this.a = a;
	}

}
