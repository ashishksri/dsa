package bst;

public class CreateOperation {

	public static void main(String[] args) {
		Node root = null;
		CreateOperation operation = new CreateOperation();
		root = operation.insert(root, 5);
		root = operation.insert(root, 6);
		root = operation.insert(root, 3);
		root = operation.insert(root, 2);
		root = operation.insert(root, 7);
		root = operation.insert(root, 8);
		root = operation.insert(root, 4);
		System.out.println("done");
		operation.inorder(root);
	}

	private Node insert(Node root, int i) {
		if (root == null) {
			return new Node(i);
		}
		if (i < root.data) {
			root.left = insert(root.left, i);
		} else {
			root.right = insert(root.right, i);
		}
		return root;
	}

	private void inorder(Node root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.data + " ");
			inorder(root.right);
		}

	}
	
	

}
