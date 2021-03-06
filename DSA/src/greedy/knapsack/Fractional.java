package greedy.knapsack;

public class Fractional {

	int[] p = new int[7];
	int[] w = new int[7];
	float output = 0;
	int maxWeight = 0;
	boolean debug = false;
	int length = 0;
	float[] a;
	private int[] s;

	public static void main(String[] args) {

		Fractional fractional = new Fractional();
		int[] p = { 10, 5, 15, 7, 6, 18, 3 };
		int[] w = { 2, 3, 5, 7, 1, 4, 1 };
		fractional.setP(p);
		fractional.setW(w);
		fractional.setMaxWeight(15);

		fractional.getMaxProfit();

		System.out.println(fractional.getOutput());
		System.out.println("solutions is: ");
		for(int i=0; i<fractional.s.length;i++) {
			System.out.print(fractional.s[i]+" ");
		}
		System.out.println();

	}

	private float getMaxProfit() {
		s = new int[p.length];
		int c=0;
		float[] ratio = getPWRatio();
		setA(ratio);
		float max = heapifyAndPop();
		int maxIndex= findMaxIndexInRatio(max, ratio);
		while(maxWeight > 0 && max != 0f) {
			int weight = w[maxIndex];
			s[c]=weight;
			c++;
			if(debug)
			System.out.println("max Index = "+maxIndex+" and max = "+max+" and max weight = "+maxWeight+" weight = "+weight);
			if(weight <= maxWeight) {
				this.output+=(float)p[maxIndex];
				maxWeight-=weight;
			}else {
				float fraction = (float)maxWeight/weight;
				maxWeight=0;
				this.output+=(float)fraction*p[maxIndex];
			}
			max=heapifyAndPop();
		    maxIndex= findMaxIndexInRatio(max, ratio);
		}
		return output;
	}

	private int findMaxIndexInRatio(float max, float[] ratio) {
		int index = 0;
		for(;index<ratio.length;index++) {
			if(ratio[index]==max) {
				ratio[index]=0f;
				return index;
			}
		}
		return -1;
	}

	private float heapifyAndPop() {
		for (int i = 2; i < length; i++) {
			int t = i;
			int j = t / 2;
			while (j >= 1) {
				if (a[t] > a[j]) {
					float k = a[j];
					a[j] = a[t];
					a[t] = k;
				}
				t = j;
				j = t / 2;
			}
		}
		float element = a[1];
		a[1] = a[length - 1];
		length--;
		if (debug) {
			System.out.println("Ratio after pop");
			for (int i = 0; i < length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}
		return element;
	}

	private void setA(float[] ratio) {
		length = p.length + 1;
		a = new float[length];
		a[0] = 0f;
		for (int i = 1; i < length; i++) {
			a[i] = ratio[i - 1];
		}
		if (debug) {
			System.out.println("inital ratio");
			for (int i = 0; i < length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();
		}

	}

	private float[] getPWRatio() {
		float[] ratio = new float[this.p.length];
		for (int i = 0; i < ratio.length; i++) {
			ratio[i] = (float) p[i] / w[i];
			if (debug) {
				System.out.print(ratio[i] + " ");
			}
		}
		if (debug)
			System.out.println();

		return ratio;
	}

	private void setP(int[] p) {
		this.p = p;
	}

	private void setW(int[] w) {
		this.w = w;
	}

	private void setMaxWeight(int m) {
		this.maxWeight = m;
	}

	private float getOutput() {
		return this.output;
	}

}
