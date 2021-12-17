package recursion;

public class IncreasingNumbers {
	
	public static void main(String[] args) {
		int x=3;
		func(x);
	}

	private static void func(int x) {
		if(x>0) {
			System.out.println(x);
			func(x-1);
		}
		
	}

}
