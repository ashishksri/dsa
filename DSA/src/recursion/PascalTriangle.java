package recursion;

public class PascalTriangle {
	
	public static void main(String[] args) {
		PascalTriangle pascalTriangle = new PascalTriangle();
		System.out.println(pascalTriangle.calculate(5,2));
	}

	private int calculate(int n, int r) {
		if(r==0 || n==r) {
			return 1;
		}else {
			return calculate(n-1, r-1)+calculate(n-1, r);
		}
	}

}
