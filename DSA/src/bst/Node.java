package bst;

public class Node {
	public int data;
	public Node left;
	public Node right;

	public Node(int value) {
		this.data = value;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
	
}