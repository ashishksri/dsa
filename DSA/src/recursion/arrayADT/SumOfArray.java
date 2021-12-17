package recursion.arrayADT;

public class SumOfArray {
	
	public static void main(String[] args) {
		int[] arr = { 3, 1, 5, 7, 9, 10, 15, 20, 22, 31, 45, 48, 61,1 };
		
		SumOfArray sumofarray = new SumOfArray();
		System.out.println("from recursive search--- "+sumofarray.sum(arr, arr.length-1));
		System.out.println("from iterative search--- "+sumofarray.iterativeSum(arr, arr.length-1));
	}

	private int sum(int[] arr, int n) {
		if(n<0) {
			return 0;
		}else {
			return sum(arr, n-1)+arr[n];
		}
	}
	
	private int iterativeSum(int[] arr, int n) {
		int sum=0;
		for(int i=0; i<=n;i++) {
			sum+=arr[i];
		}
		return sum;
	}

}
