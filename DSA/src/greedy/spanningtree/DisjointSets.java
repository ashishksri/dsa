package greedy.spanningtree;

public class DisjointSets {

	int[] set;
	private boolean debug;

	public DisjointSets(int[] set, boolean debug) {
		this.set = set;
		this.debug = debug;
	}

	/**
	 * Weighted union.
	 * 
	 * @param u
	 * @param v
	 */
	public int[] union(int u, int v) {
		if(debug) {
			System.out.println("u= "+u+" v= "+v);
		}
		if (this.set[u] < this.set[v]) {
			this.set[u] = this.set[u] + this.set[v];
			this.set[v] = u;
		} else {
			this.set[v] = this.set[u] + this.set[v];
			this.set[u] = v;
		}
		return this.set;
	}

	public int find(int u) {
		int v = u;
		while (this.set[v] > 0) {
			v = this.set[v];
		}
		return v;
	}

	public int[] getSet() {
		return this.set;
	}

}
