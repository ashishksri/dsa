package greedy.huffman;

public class Stack {

	int[] a;
	int front;

	public Stack(int size) {
		this.a = new int[size];
		this.front = -1;
	}

	public static void main(String[] args) {

	}

	public boolean isEmpty() {
		if (this.front == -1) {
			return true;
		}
		return false;
	}

	public void insert(int e) {
		this.front++;
		this.a[front]=e;
	}
	
	public int pop() {
		int e = this.a[this.front];
		this.front--;
		return e;
	}
	
	public boolean isFull() {
		if(this.front==this.a.length-1) {
			return true;
		}
		return false;
	}
	
	public int getFront() {
		return this.front;
	}
	
	public int getElement(int i) {
		return this.a[i];
	}

}
