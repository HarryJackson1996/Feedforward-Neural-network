package network;

import java.util.ArrayList;

public class Main {
	

	public static void main(String args[]) {	
			NeuralNetwork nn = new NeuralNetwork(2, 2, 6);
			ArrayList<Double> input_array = new ArrayList<Double>();
			input_array.add(1.0);
			input_array.add(2.0);
			ArrayList<Double> output = nn.feedForward(input_array);	
			System.out.print(output);
			
				
		
	}
	
}

