package recursion;

public class DecreasingNumbers {
	
	public static void main(String[] args) {
		int x=3;
		func(x);
	}

	private static void func(int x) {
		if(x>0) {
			func(x-1);
			System.out.println(x);
		}
		
	}

}
