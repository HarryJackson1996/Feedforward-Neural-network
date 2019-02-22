package network;


public class Activation {
	
	public Matrix sigmoid(Matrix x) {
		for(int i = 0; i< x.getMatrix().length; i++) {
			for(int j = 0; j<x.getMatrix().length; j++) {
				double b = x.getMatrix()[i][j];
				double val =  1/(1+Math.exp(-b));
				//System.out.println(val);
				x.getMatrix()[i][j] = val;
				x.printMatrix();
			}
		}
		
		return x;
	}
	
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
