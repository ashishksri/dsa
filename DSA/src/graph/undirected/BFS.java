package graph.undirected;

import practise.queue.Queue;

public class BFS {

	int[][] G = { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 0, 0 },
			{ 0, 0, 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0 } };

	int[] visited;

	Queue queue;

	public void traverse(int i) {
		System.out.print(i + " ");
		queue.enqueue(i);
		visited[i] = 1;
		int u = queue.dequeue();
		while (u != -1) {
			for (int v = 1; v < G[u].length; v++) {
				if (G[u][v] == 1 && visited[v] != 1) {
					System.out.print(v + " ");
					queue.enqueue(v);
					visited[v] = 1;
				}
			}
			u = queue.dequeue();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BFS bfs = new BFS();
		for (int i = 1; i <= 6; i++) {
			bfs.visited = new int[7];
			bfs.queue = new Queue(7);
			System.out.println("traversing from index: "+i);
			bfs.traverse(i);
		}
	}

}
