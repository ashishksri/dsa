package recursion;

public class MemoizationFib {

	int[] F;

	public static void main(String[] args) {
		int size = 6;

		MemoizationFib fib = new MemoizationFib();
		fib.F = new int[size];
		for (int i = 0; i < size; i++) {
			fib.setF(i, -1);
		}
		System.out.println(fib.mFib(size));
	}

	private int mFib(int n) {
		if(n<=1) {
			setF(n, n);
			return F[n];
		}else {
			if(F[n-2]==-1) {
				F[n-2] = mFib(n-2);
			}
			if(F[n-1]==-1) {
				F[n-1] = mFib(n-1);
			}
			return F[n-2]+F[n-1];
		}
	}

	public void setF(int index, int value) {
		this.F[index] = value;
	}

	public int getF(int index) {
		return this.F[index];
	}

}
