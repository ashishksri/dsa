package greedy.huffman;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HuffmanCode {

	class Node {
		private Character data;
		private int f;

		public Node(Character data, int f) {
			this.data = data;
			this.f = f;
		}

		public Character getData() {
			return this.data;
		}

		public int getF() {
			return this.f;
		}
	}

	int[] path;
	String code;
	Map<Character, Integer> fMap = new HashMap<>();
	char[] a;
	int[] f;
	int[] fMinHeap;
	Node[] node;
	int heapSize;
	int size;
	int nodeCurrentIndex;
	Map<Character, String> codes = new HashMap<>();
	String message;
	String decodedMessage;
	boolean debug = false;

	public static void main(String[] args) {
		HuffmanCode hcode = new HuffmanCode();
		hcode.setCode("BCCABBDDAECCBBAEDDCC");
		System.out.println("message is " + hcode.code);
		hcode.frequencyPerElement();
		hcode.setFrequency();
		hcode.createFMinHeap();
		hcode.createNodeStructure();
		hcode.mergePattern();
		Stack stack = new Stack(hcode.nodeCurrentIndex + 1);
		hcode.getCode(stack, 1);
		hcode.encodeMessage();
		hcode.decodeMessage();

		if (hcode.debug) {
			Iterator<Entry<Character, String>> entrySet = hcode.codes.entrySet().iterator();
			while (entrySet.hasNext()) {
				Entry<Character, String> next = entrySet.next();
				if (hcode.debug) {
					System.out.println("key is " + next.getKey() + " frequency is " + next.getValue());
				}
			}
		}
	}

	private void setFrequency() {
		int size = fMap.entrySet().size();
		if (debug)
			System.out.println("size : = " + size);
		this.size = size + 1;
		heapSize = 2 * size + 1;
		if (debug)
			System.out.println(size);
		a = new char[size];
		f = new int[size];
		Iterator<Entry<Character, Integer>> entrySet = fMap.entrySet().iterator();
		int c = 0;
		while (entrySet.hasNext()) {
			Entry<Character, Integer> next = entrySet.next();
			if (debug) {
				System.out.println("key is " + next.getKey() + " frequency is " + next.getValue());
			}
			a[c] = next.getKey();
			f[c] = next.getValue();
			c++;
		}
	}

	private void setCode(String code) {
		this.code = code;
	}

	private void mergePattern() {
		heapifyFrequency();
		while (size > 2) {
			if (debug)
				System.out.println("size = " + size);
			int e = popFMHeap() + popFMHeap();
			insertFMinHeap(e);
			insertNodeStructure(e);
		}

		// viewNodeStructure();
		heapifyNodeData();
		viewNodeStructure();
	}

	private void createNodeStructure() {
		node = new Node[heapSize];
		if (debug)
			System.out.println("heapsize = " + this.heapSize);
		node[0] = new Node(null, 0);
		for (int i = 1; i < a.length + 1; i++) {
			node[i] = new Node(a[i - 1], f[i - 1]);
		}
		nodeCurrentIndex = a.length;
	}

	private void insertNodeStructure(int e) {
		nodeCurrentIndex++;
		Node t = null;
		for (int i = 1; i <= nodeCurrentIndex; i++) {
			if (node[i] != null && node[i].getF() == e) {
				t = node[i];
				node[i] = new Node(null, e);
			}
		}
		if (t != null) {
			node[nodeCurrentIndex] = t;
		} else {
			node[nodeCurrentIndex] = new Node(null, e);
		}

	}

	public void viewNodeStructure() {
		if (debug) {
			System.out.println("Node data");
			for (int i = 1; i <= nodeCurrentIndex; i++) {
				System.out.println(node[i].getF() + " ");
				System.out.println(node[i].getData());
			}
			System.out.println();
		}
	}

	public void heapifyNodeData() {
		for (int i = (nodeCurrentIndex) / 2; i >= 1; i--) {
			int t = i;
			int j = 2 * t;

			if (debug) {
				System.out.println("t = " + t + " j= " + j);
			}
			while (j < heapSize) {
				if ((j + 1) < heapSize) {
					if (node[j + 1].getF() > node[j].getF()) {
						j++;
					}
				}
				if (debug)
					System.out.print(j + " ");
				if (node[j].getF() >= node[t].getF()) {
					Node k = node[j];
					node[j] = node[t];
					node[t] = k;
				} else {
					break;
				}
				t = j;
				j = 2 * t;
			}
		}
	}

	private void heapifyFrequency() {
		for (int i = (size - 1) / 2; i >= 1; i--) {
			int t = i;
			int j = t * 2;
			while (j < size) {
				if ((j + 1) < size) {
					if (fMinHeap[j + 1] < fMinHeap[j]) {
						j++;
					}
				}
				if (fMinHeap[j] < fMinHeap[t]) {
					int k = fMinHeap[t];
					fMinHeap[t] = fMinHeap[j];
					fMinHeap[j] = k;
				} else {
					break;
				}
				t = j;
				j = 2 * t;
			}
		}
		if (debug) {
			System.out.println("Min heap on frequencies..size = " + size);
			for (int i = 1; i < size; i++) {
				System.out.print(fMinHeap[i] + " - ");
			}
			System.out.println();
		}
	}

	public int popFMHeap() {
		int e = fMinHeap[1];
		fMinHeap[1] = fMinHeap[size - 1];
		size--;
		if (debug) {
			System.out.println("element poped " + e);
		}
		heapifyFrequency();
		return e;
	}

	public void insertFMinHeap(int e) {
		if (debug) {
			System.out.println("element inserted " + e);
		}
		fMinHeap[size] = e;
		size++;
		heapifyFrequency();
	}

	private void createFMinHeap() {
		fMinHeap = new int[f.length + 1];
		fMinHeap[0] = 0;
		if (debug) {
			System.out.println("frequencies..");
		}
		for (int i = 1; i < f.length + 1; i++) {
			fMinHeap[i] = f[i - 1];
			if (debug) {
				System.out.print(fMinHeap[i] + " ");
			}
		}
		if (debug) {
			System.out.println();
		}
	}

	private void frequencyPerElement() {
		for (int i = 0; i < code.length(); i++) {
			char e = code.charAt(i);
			int f = getCharFrequency(e);
			if (f == -1) {
				fMap.put(e, 1);
			} else {
				fMap.put(e, f + 1);
			}
		}
	}

	private int getCharFrequency(char e) {
		int f = fMap.getOrDefault(e, -1);
		return f;
	}

	public void getCode(Stack stack, int i) {
		if (i != 1) {
			if (i % 2 == 0) {
				stack.insert(0);
			} else {
				stack.insert(1);
			}
		}
		if (!hasChildren(i)) {
			String code = "";
			for (int k = 0; k <= stack.getFront(); k++) {
				code += stack.getElement(k);
			}
			codes.put(node[i].getData(), code);
			stack.pop();
			return;
		}
		getCode(stack, 2 * i);
		getCode(stack, 2 * i + 1);
		if (i != 1) {
			stack.pop();
		}

	}

	private boolean hasLeftChild(int i) {
		int index = 2 * i;
		if (index > nodeCurrentIndex) {
			return false;
		} else {
			return true;
		}
	}

	private boolean hasRightChild(int i) {
		int index = 2 * i + 1;
		if (index > nodeCurrentIndex) {
			return false;
		} else {
			return true;
		}
	}

	private boolean hasChildren(int i) {
		if (hasRightChild(i) || hasLeftChild(i)) {
			return true;
		}
		return false;
	}

	public void encodeMessage() {
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < this.code.length(); i++) {
			char a = this.code.charAt(i);
			String c = codes.get(a);
			buffer.append(c);
		}
		this.message = buffer.toString();
		System.out.println("encoded message:  " + this.message);
	}

	public void decodeMessage() {
		int c = 1;
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < this.message.length(); i++) {
			int a = Character.getNumericValue(this.message.charAt(i));
			// System.out.print(a);

			if (a == 0) {
				c = c * 2;

			} else {
				c = c * 2 + 1;
			}
			// System.out.println("c is "+c);
			if (!hasChildren(c)) {
				if (node[c].data != null) {
					// System.out.print(node[c].getData());
					buffer.append(node[c].getData());
					c = 1;
				}
			}
		}
		this.decodedMessage = buffer.toString();
		System.out.println("decoded message " + this.decodedMessage);
		if (this.decodedMessage.equals(this.code)) {
			System.out.println("SUCCESS!!");
		}
	}

}
