package practise.queue;

import java.util.LinkedList;
import java.util.List;

import bst.Node;


public class LinkedQueue<T> {

	List<T> queue;
	int front;
	int rear;
	boolean debug;

	public LinkedQueue(boolean debug) {
		this.front = -1;
		this.rear = -1;
		this.debug = debug;
	}

	public void enqueue(T e) {
		if (rear == -1) {
			queue = new LinkedList<>();
			rear = 0;
		}
		queue.add(e);
		front++;
		if (debug)
			System.out.println("Enqueued " + e + " rear is: " + rear + " front is: " + front);
	}

	public T dequeue() {
		if (rear == -1 || rear > front) {
			queue = new LinkedList<>();
			if (debug)
				System.out.println("queue is empty rear is: " + rear + " front is " + front);
			front = -1;
			if (debug)
				System.out.println("queue is empty rear is: " + rear + " front is " + front);
			return null;
		}
		T e = queue.get(rear);
		rear++;
		if (debug) {
			System.out.println("Dequeued " + e + " rear is: " + rear + " front is: " + front);
		}
		if (rear > front) {
			rear = front = -1;
		}

		return e;
	}

	public static void main(String[] args) {
		LinkedQueue<Node> lqueue = new LinkedQueue(false);
		System.out.println(lqueue.dequeue());
		lqueue.enqueue(new Node(4));
		System.out.println(lqueue.dequeue());
		System.out.println(lqueue.dequeue());
		lqueue.enqueue(new Node(4));
		lqueue.enqueue(new Node(5));
		System.out.println(lqueue.dequeue());
		lqueue.enqueue(new Node(6));
		System.out.println(lqueue.dequeue());
		lqueue.enqueue(new Node(7));
		lqueue.enqueue(new Node(8));
		lqueue.enqueue(new Node(9));
		System.out.println(lqueue.dequeue());
		System.out.println(lqueue.dequeue());
		System.out.println(lqueue.dequeue());
		System.out.println(lqueue.dequeue());
		System.out.println(lqueue.dequeue());
	}

}
