package tree.binary;

import java.util.Scanner;

import bst.Node;
import practise.queue.LinkedQueue;

public class BinaryTree {

	Node root=null;
	LinkedQueue<Node> q;
	private boolean qdebug=false;
	private boolean debug=false;
	Scanner sc;
	
	public BinaryTree() {
		q = new LinkedQueue<>(this.qdebug);
		sc = new Scanner(System.in);
	}
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		System.out.println("Enter root node: ");
		int val = bt.sc.nextInt();
		bt.add(val);

		System.out.println(bt.root.toString());
		System.out.println("In order..");
		bt.printInorder(bt.root);
	}
	
	private void add(int e) {
		Node t = new Node(e);
		if(root == null) {
			q.enqueue(t);
			root = t;
		}
		Node fromQ = q.dequeue();
		while(null != fromQ) {
			System.out.println("Enter left child of "+fromQ.data);
			int left = sc.nextInt();
			if(left != -1) {
				t = new Node(left);
				fromQ.left=t;
				q.enqueue(fromQ.left);
			}else {
				fromQ.left=null;
			}
			System.out.println("Enter right child of "+fromQ.data);
			int right = sc.nextInt();
			if(right != -1) {
				t = new Node(right);
				fromQ.right=t;
				q.enqueue(fromQ.right);
			}else {
				fromQ.right=null;
			}
			fromQ = q.dequeue();
		}
		
	}

	void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data+" ");
		printInorder(node.right);
	}

}
