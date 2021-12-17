package tree.binary;

public class BinaryTree {

	public static class Node {
		int data;
		Node left;
		Node right;

		public Node(int value) {
			this.data = value;
			this.left = null;
			this.right = null;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		BinaryTree bt = new BinaryTree();

		bt.printInorder(root);

	}

	void printInorder(Node root) {
		if (root == null) {
			return;
		}
		printInorder(root.left);
		System.out.println(root.data);
		printInorder(root.right);
	}

}
