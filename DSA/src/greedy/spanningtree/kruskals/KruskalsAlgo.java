package greedy.spanningtree.kruskals;

import java.util.Arrays;

import greedy.spanningtree.DisjointSets;
import greedy.spanningtree.Node;
import sorting.array.utils.ArrayUtils;

/**
 * Solution of kruskal's Algorithm using min heap.
 * 
 * @author a.p.kumar.srivastava
 *
 */
public class KruskalsAlgo {

	private boolean debug = false;
	private Node[] nodes;
	private int vertexCount;
	int[][] sol;
	int[] disjointSet;
	int nodesLastIndex;
	DisjointSets sets = null;
	int minCost = 0;

	public KruskalsAlgo(int edges, int vertices) {
		this.nodes = new Node[edges + 1];
		this.disjointSet = new int[vertices + 1];
		this.sol = new int[2][vertices - 1];
		this.nodesLastIndex = edges;
		this.vertexCount = vertices;
	}

	public static void main(String[] args) {
		// create nodes.
		KruskalsAlgo algo = new KruskalsAlgo(9, 7);
		Arrays.fill(algo.disjointSet, -1);
		if (algo.debug) {
			System.out.println("Disjoint set");
			ArrayUtils.print(algo.disjointSet);
		}
		algo.sets = new DisjointSets(algo.disjointSet, algo.debug);
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

		// Perform operations
		algo.operation();

		// Print solution
		System.out.println("Solution matrix..");
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < algo.sol[i].length; j++) {
				System.out.print(algo.sol[i][j] + " ");
			}
			System.out.println();
		}
		
		//Minimum cost
		System.out.println("Minimum cost = "+algo.minCost);

	}

	/**
	 * Pop minimum node from heap.
	 * @return
	 */
	private Node getMinNode() {
		heapifyNodes();
		Node minNode = nodes[1];
		nodes[1] = nodes[this.nodesLastIndex];
		this.nodesLastIndex--;
		return minNode;
	}

	/**
	 * Heapify Nodes to create Min Heap.
	 */
	private void heapifyNodes() {
		for (int i = nodesLastIndex / 2; i >= 1; i--) {
			int t = i;
			int j = 2 * t;
			while (j <= nodesLastIndex) {
				if ((j + 1) <= nodesLastIndex) {
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
	}

	/**
	 * Pop minimum cost node from heap and then if node is not forming cycles include in solution.
	 */
	private void operation() {
		Node minNode = null;
		while (this.vertexCount > 1 && nodesLastIndex > 0) {
			minNode = getMinNode();
			if (this.debug)
				System.out.println("Min Node: " + minNode.toString());
			int u = minNode.getV1();
			int v = minNode.getV2();
			if (debug)
				System.out.println(minNode.getV1() + "->" + sets.find(u) + " , " + minNode.getV2() + "->" + sets.find(v));
			if (sets.find(u) != sets.find(v)) {
				sets.union(sets.find(u), sets.find(v));
				if (this.debug) {
					System.out.println("Disjoint set");
					if (debug)
						ArrayUtils.print(this.sets.getSet());
				}

				this.sol[0][7 - this.vertexCount] = u;
				this.sol[1][7 - this.vertexCount] = v;
				this.minCost+=minNode.getCost();
				this.vertexCount--;
			}
		}
	}

}
