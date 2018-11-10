

public class Activation {
	
	public double sigmoid(double x) {
		return 1/(1+Math.exp(-x));
	}

	public double tanH(double x) {
		return Math.tanh(x);
		
	}
	
	public double reLu(double x) {
		return Math.max(0, x);
	}
}
