package tree.binary;

import java.util.Scanner;

import bst.Node;
import practise.queue.LinkedQueue;

/**
 * Binary tree operations.
 * @author a.p.kumar.srivastava
 *
 */
public class BinaryTree {

	Node root = null;
	LinkedQueue<Node> q;
	private boolean qdebug = false;
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

		System.out.println("pre order");
		bt.preorder(bt.root);

		System.out.println("Count of nodes.." + bt.count(bt.root));

		System.out.println("Height of tree" + bt.height(bt.root));
		
		System.out.println("leaf nodes: "+bt.leafCount(bt.root));
	}

	/**
	 * All elements to a binary tree.
	 * @param e
	 */
	private void add(int e) {
		Node t = new Node(e);
		if (root == null) {
			q.enqueue(t);
			root = t;
		}
		Node fromQ = q.dequeue();
		while (null != fromQ) {
			System.out.println("Enter left child of " + fromQ.data);
			int left = sc.nextInt();
			if (left != -1) {
				t = new Node(left);
				fromQ.left = t;
				q.enqueue(fromQ.left);
			} else {
				fromQ.left = null;
			}
			System.out.println("Enter right child of " + fromQ.data);
			int right = sc.nextInt();
			if (right != -1) {
				t = new Node(right);
				fromQ.right = t;
				q.enqueue(fromQ.right);
			} else {
				fromQ.right = null;
			}
			fromQ = q.dequeue();
		}

	}

	/**
	 * Binary tree In order traversal.
	 * @param node
	 */
	void printInorder(Node node) {
		if (node == null) {
			return;
		}
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}

	/**
	 * Binary tree pre order traversal.
	 * @param node
	 */
	void preorder(Node node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}

	/**
	 * Count all nodes in binary tree.
	 * @param node
	 * @return
	 */
	private int count(Node node) {
		int x, y;
		if (node != null) {
			x = count(node.left);
			y = count(node.right);
			return x + y + 1;
		}
		return 0;
	}

	/**
	 * Count height of binary tree.
	 * @param node
	 * @return
	 */
	private int height(Node node) {
		int x = 0;
		int y = 0;
		if (node == null) {
			return 0;
		}
		x = height(node.left);
		y = height(node.right);
		if (x > y) {
			return x + 1;
		} else {
			return y + 1;
		}
	}

	/**
	 * Count leaf nodes of a binary tree.
	 * @param node
	 * @return
	 */
	private int leafCount(Node node) {
		int x, y;
		if (node != null) {
			x = leafCount(node.left);
			y = leafCount(node.right);
			if (node.left == null && node.right == null) {
				return x + y + 1;
			}else {
				return x+y;
			}
		}
		return 0;
	}

}
