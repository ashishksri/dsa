package greedy.spanningtree.prims;

import greedy.spanningtree.Node;

public class PrimsAlgo {

	int edgeCount = 0;
	int vertexCount = 0;
	Node[] nodes;
	int[] near;
	int[][] edges;
	int[][] adjMatrix;
	int nextMin = -1;
	int nextCount = 0;
	private boolean debug = false;

	public PrimsAlgo(int edgeCount, int vertexCount) {
		this.vertexCount = vertexCount;
		this.edgeCount = edgeCount;
		this.nodes = new Node[this.edgeCount + 1];
		this.near = new int[this.vertexCount + 1];
		this.edges = new int[2][this.vertexCount - 1];
		this.adjMatrix = new int[vertexCount + 1][vertexCount + 1];
	}

	public static void main(String[] args) {
		PrimsAlgo algo = new PrimsAlgo(9, 7);
		if (algo.debug) {
			System.out.println(algo.edgeCount);
		}
		algo.nodes[0] = new Node(0, 0, 0);
		algo.nodes[1] = new Node(5, 1, 6);
		algo.nodes[2] = new Node(25, 1, 2);
		algo.nodes[3] = new Node(20, 5, 6);
		algo.nodes[4] = new Node(16, 4, 5);
		algo.nodes[5] = new Node(8, 3, 4);
		algo.nodes[6] = new Node(12, 2, 3);
		algo.nodes[7] = new Node(10, 2, 7);
		algo.nodes[8] = new Node(18, 5, 7);
		algo.nodes[9] = new Node(14, 4, 7);

		Node minNode = algo.heapifyNodeAndFIndMinNode();
		int minEdge = minNode.getCost();
		if (algo.debug)
			System.out.println("Min edge is: " + minEdge);
		algo.init(minNode);
		algo.generateSpanning();

		System.out.println("Spanning tree..");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < algo.vertexCount - 1; j++) {
				System.out.print(algo.edges[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("End spanning tree");

	}

	private Node heapifyNodeAndFIndMinNode() {
		heapify();
		Node node = nodes[1];
		return node;
	}

	/**
	 * Min heap on nodes cost.
	 */
	private void heapify() {
		for (int i = (this.edgeCount) / 2; i >= 1; i--) {
			int t = i;
			int j = 2 * t;

			if ((j + 1) < edgeCount) {
				if (nodes[j + 1].getCost() < nodes[j].getCost()) {
					j++;
				}
			}
			if (nodes[j].getCost() < nodes[t].getCost()) {
				Node temp = nodes[t];
				nodes[t] = nodes[j];
				nodes[j] = temp;
			}

			t = j;
			j = 2 * t;
		}
	}

	/**
	 * Initial setup
	 */
	private void init(Node node) {
		edges[0][0] = node.getV1();
		edges[1][0] = node.getV2();

		setAdjMatrix();
		this.near[node.getV1()] = -1;
		this.near[node.getV2()] = -1;
		this.nextCount++;
		for (int i = 1; i < this.vertexCount + 1; i++) {
			if (i == node.getV1() || i == node.getV2()) {
				continue;
			}
			if (this.adjMatrix[i][node.getV1()] == 0) {
				this.adjMatrix[i][node.getV1()] = Integer.MAX_VALUE;
			}
			if (this.adjMatrix[i][node.getV2()] == 0) {
				this.adjMatrix[i][node.getV2()] = Integer.MAX_VALUE;
			}
			if ((this.adjMatrix[i][node.getV1()] < this.adjMatrix[i][node.getV2()])) {
				this.near[i] = node.getV1();
			} else {
				this.near[i] = node.getV2();
			}
		}
		if (debug) {
			System.out.println("Edges..");
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < this.edgeCount; j++) {
					System.out.print(this.edges[i][j] + " ");
				}
				System.out.println();
			}
			System.out.println("End edges");
		}

		if (debug) {
			System.out.println("Near matrix..");
			for (int j = 0; j <= this.vertexCount; j++) {
				System.out.print(this.near[j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Set up adjacency matrix.
	 */
	private void setAdjMatrix() {
		for (int i = 1; i < nodes.length; i++) {
			adjMatrix[nodes[i].getV1()][nodes[i].getV2()] = nodes[i].getCost();
			adjMatrix[nodes[i].getV2()][nodes[i].getV1()] = nodes[i].getCost();
		}
		System.out.println("Adjacency matrix..");
		for (int i = 0; i <= this.vertexCount; i++) {
			for (int j = 0; j <= this.vertexCount; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("End adj matrix");
		System.out.println("--------------------------------------");
	}

	private void generateSpanning() {
		// Number of edges -1 , since edge array starts from 0, we need (0 to vertex
		// count -2)
		// Example if vertex = 7, array of edges will be from 0 to 5 i.e. 6 elements.
		while (this.nextCount < this.vertexCount - 1) {
			getNextEdge();
		}
	}

	private void getNextEdge() {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		for (int j = 1; j <= this.vertexCount; j++) {
			if (near[j] != -1) {
				if (adjMatrix[j][near[j]] != 0 && adjMatrix[j][near[j]] < min) {
					min = adjMatrix[j][near[j]];
					minIndex = j;
				}
			}
			// System.out.print(this.near[j] + " ");
		}
		edges[0][this.nextCount] = minIndex;
		edges[1][this.nextCount] = near[minIndex];
		this.nextCount++;
		if (debug)
			System.out.println("next min: " + min);
		adjustNear(minIndex, near[minIndex]);
	}

	private void adjustNear(int a, int b) {
		int e = a;
		if (near[e] == -1) {
			e = b;
		}
		near[e] = -1;
		for (int i = 1; i < this.vertexCount + 1; i++) {
			if (near[i] != -1) {
				if (adjMatrix[i][e] == 0) {
					adjMatrix[i][e] = Integer.MAX_VALUE;
				}
				if (adjMatrix[i][near[i]] == 0) {
					adjMatrix[i][near[i]] = Integer.MAX_VALUE;
				}
				if (adjMatrix[i][e] < adjMatrix[i][near[i]]) {
					near[i] = e;
				}
			}
		}

		if (debug) {
			System.out.println("New near matrix after inserting " + a + " and " + b);
			for (int j = 0; j <= this.vertexCount; j++) {
				System.out.print(this.near[j] + " ");
			}
			System.out.println();
		}
	}
}
