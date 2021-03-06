package practise.queue;

public class Queue {
	int SIZE;
	int[] q;
	int front, rear;

	public Queue(int size) {
		this.SIZE = size-1;
		front = rear = -1;
		q = new int[this.SIZE];
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.enqueue(0);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		queue.enqueue(5);
		System.out.println(queue.dequeue());
		
		
		/*
		 * queue.dequeue(); queue.dequeue(); queue.dequeue(); queue.dequeue();
		 */
	}

	public boolean isFull() {
		if (this.rear == this.SIZE - 1) {
			return true;
		}
		return false;
	}

	public boolean isEmpty() {
		if (this.front == -1) {
			return true;
		}
		return false;
	}

	public void enqueue(int element) {
		if (isFull()) {
			throw new IllegalStateException("Q is already full");
		}
		if (this.front == -1) {
			this.front = 0;
		}
		this.q[++rear] = element;
	}
	public int dequeue() {
		if(isEmpty()) {
			//taking -1 as all my algos will be on natural numbers
			return -1;
		}
		int element = q[this.front];
		this.front++;
		if (this.front > this.rear) {
			this.front = this.rear = -1;
		}
		return element;
	}

}
