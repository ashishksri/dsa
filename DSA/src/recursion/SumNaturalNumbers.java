package recursion;

/**
 * sum(n) = 1+2+3+4+.....n-1+n <br>
 * sum(n) = sum(n-1) + n <br>
 * sum(0) = 0 <br>
 * @author a.p.kumar.srivastava
 *
 */
public class SumNaturalNumbers {
	
	public static void main(String[] args) {
		System.out.println(calculate(5));
	}

	private static int calculate(int i) {
		if(i==0) {
			return 0;
		}else {
			return calculate(i-1)+i;
		}
	}

}
