package recursion;


/**
 * fact(n) = 1*2*3*4*.....n-1*n <br>
 * fact(n) = fact(n-1) * n <br>
 * fact(0) = 1 <br>
 * @author a.p.kumar.srivastava
 *
 */
public class Factorial {
	
	public static void main(String[] args) {
		Factorial factorial = new Factorial();
		System.out.println(factorial.fact(5));
	}

	private int fact(int i) {
		if(i<=0) {
			return 1;
		} else {
			return fact(i-1)*i;
		}
	}

}
