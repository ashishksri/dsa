package sorting.array.index.n;

import sorting.array.utils.ArrayUtils;

public class BucketSort {

	int[] a = { 8, 5, 7, 3, 2, 9, 2, 5 };

	public static class Node {
		int data;
		Node next;

		public Node(int value) {
			this.data = value;
			this.next = null;
		}
		
		public Node() {
			this.data = -1;
			this.next = null;
		}
		
	}

	public static void main(String[] args) {
		BucketSort bucketSort = new BucketSort();
		int length = bucketSort.findMax();
		Node[] list = new Node[length + 1];

		for(int i=0;i<bucketSort.a.length;i++) {
		   list = bucketSort.insertList(list, bucketSort.a[i]);
		}
		System.out.println("Initial values in list: ");

		for (int i = 0; i <= length; i++) {
			Node node = list[i];
			if (node != null) {
			}
			System.out.print("[");

			while (node != null) {
				System.out.print(node.data + " ");
				node = node.next;
			}

			System.out.print("],");
		}
		bucketSort.getSortedArray(list);

		System.out.println();

	}

	public Node[] insertList(Node[] list, int data) {
		if (list[data] == null) {
			list[data] = new Node();
		}
		Node node = list[data];
		while (node.next != null) {
			node = node.next;
		}
		node.next = new Node(data);
		list[data] = node;
		return list;

	}
	
	public int[] getSortedArray(Node[] list) {
		
		int i=0;
		for(int j=0;j<list.length;j++) {
			Node node = list[j];
			while(node != null) {
				if(node.data != -1) {
					a[i]=node.data;
				}
				node = node.next;
			}
		}
		ArrayUtils.print(a);
		return a;
	}

	private int findMax() {
		int max = a[0];
		for (int i = 1; i < a.length - 1; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		return max;
	}

}
