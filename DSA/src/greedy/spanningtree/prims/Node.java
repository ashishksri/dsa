package greedy.spanningtree.prims;

public class Node {

	private int cost;
	private int v1;
	private int v2;

	public Node(int cost, int v1, int v2) {
		this.cost = cost;
		this.v1 = v1;
		this.v2 = v2;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getV1() {
		return v1;
	}

	public void setV1(int v1) {
		this.v1 = v1;
	}

	public int getV2() {
		return v2;
	}

	public void setV2(int v2) {
		this.v2 = v2;
	}
	
	
}
