package recursion;

public class Power {
	
	public static void main(String[] args) {
		Power power = new Power();
		System.out.println(power.pow(2,5));
	}

	private int pow(int n,int i) {
		if(i==0) {
			return 1;
		}else {
			return pow(n,i-1)*n;
		}
	}
}
