package network;

import java.util.ArrayList;

public class NeuralNetwork {

	int input_nodes;
	int hidden_nodes;
	int output_nodes;
	Matrix weights_ih;
	Matrix weights_ho;
	Matrix bias_h;
	Matrix bias_o;
	
	public NeuralNetwork(int input_nodes, int hidden_nodes, int output_nodes) {
		this.input_nodes = input_nodes;
		this.hidden_nodes = hidden_nodes;
		this.output_nodes = output_nodes;
		
		this.weights_ih = new Matrix(this.hidden_nodes, this.input_nodes);
		this.weights_ih.randomMatrixMain();
		System.out.println("weights_ih");
		this.weights_ih.printMatrix();

		
		this.weights_ho = new Matrix(this.output_nodes, this.hidden_nodes);
		this.weights_ho.randomMatrixMain();
		System.out.println("weights_ho");
		this.weights_ho.printMatrix();
		
		this.bias_h = new Matrix(this.hidden_nodes, 1);
		this.bias_h.randomMatrixMain();
		System.out.println("bias_h");
		this.bias_h.printMatrix();
		
		this.bias_o = new Matrix(this.output_nodes, 1);
		this.bias_o.randomMatrixMain();
		System.out.println("bias_o");
		this.bias_o.printMatrix();
	}
	
	public ArrayList<Double> feedForward(ArrayList<Double> input_array) { 
		//Generating hidden outputs
		System.out.println("input_array");
		Matrix inputs = Matrix.arraylistToMatrix(input_array);
		inputs.printMatrix();
		
		System.out.println("input dot weights_ih");
		Matrix hidden = Matrix.multiply(this.weights_ih, inputs);
		hidden.printMatrix();
		
		System.out.println("hidden + bias_h");
		hidden.plus(this.bias_h);
		hidden.printMatrix();
		
		System.out.println("hidden passed through sigmoid");
		Matrix.Map(hidden);
		hidden.printMatrix();
		
		//generate outputs outputs
		System.out.println("output");
		Matrix output = Matrix.multiply(this.weights_ho, hidden);
		output.printMatrix();
		
		System.out.println("output + bias_o");
		output.plus(this.bias_o);
		output.printMatrix();
		
		System.out.println("output passed through sigmoid");
		Matrix.Map(output);
		output.printMatrix();
		
		return Matrix.matrixToArrayList(output);
	}	
	
	
	public void train(ArrayList<Double> inputs, ArrayList<Double> targets) {
		Matrix outputs = Matrix.arraylistToMatrix(this.feedForward(inputs));
		outputs.printMatrix();
		Matrix newTarget = Matrix.arraylistToMatrix(targets);
		newTarget.printMatrix();
		
		Matrix error = Matrix.subtract(newTarget, outputs);
		error.printMatrix();
	}
}
