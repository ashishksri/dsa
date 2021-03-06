package graph.undirected;

public class DFS {

	int[][] G = { { 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1, 0, 0 }, { 0, 1, 0, 0, 1, 0, 0 },
			{ 0, 0, 1, 1, 0, 1, 1 }, { 0, 0, 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0 } };

	int[] visited;

	public void traverse(int i) {
		if (visited[i] == 0) {
			System.out.print(i + " ");
			visited[i] = 1;
		}

		for (int k = 1; k < G[i].length; k++) {
			if (G[i][k] == 1 && visited[k] == 0) {
				System.out.print(k + " ");
				visited[k] = 1;
				traverse(k);
			}
		}
	}

	public static void main(String[] args) {
		DFS dfs = new DFS();
		for (int i = 1; i <= 6; i++) {
			dfs.visited = new int[7];
			System.out.println("traversing from index: " + i);
			dfs.traverse(i);
			System.out.println();
		}
	}

}
