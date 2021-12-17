package recursion;

/**
 * e^x = 1+x/1+x^2/2!+x^3/3!....x^n-1/n-1!+x^n/n!<br>
 * e^x = e^x-1 + x^n/n!<br>
 * e^0=1<br>
 * @author a.p.kumar.srivastava
 *
 */
public class TaylorSeries {
	double p=1,f=1;
	
	public static void main(String[] args) {
		TaylorSeries series = new TaylorSeries();
		System.out.println(series.e(4,10));
	}

	private double e(int i, int j) {
		double r = 0;
		if(j==0) {
			return 1;
		}else {
			r=e(i,j-1);
			p=p*i;
			f *= j;
			return r+p/f;
		}
		
	}

}
