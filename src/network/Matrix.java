package network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Matrix Library
 * 
 * @author Harry Jackson
 *
 */
public class Matrix {

	private int rows;
	private int cols;
	private double[][] matrix;
	private static Activation a = new Activation();

	/**
	 * 
	 * @param rows
	 * @param cols
	 */
	public Matrix(int rows, int cols) {
		
		this.rows = rows;
		this.cols = cols;
		this.matrix = new double[rows][cols];
	}

	/**
	 * 
	 * @param matrix
	 */
	public Matrix(int[][] matrix) {
		rows = matrix.length;
		cols = matrix[0].length;
		this.matrix = new double[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.matrix[i][j] = matrix[i][j];
			}
		}
	}

	/**
	 * Method for handling scalar Multiplication of a Matrix. Matrix = [i*n][j*n]
	 * 
	 * @param n
	 */
	public void multiplyMatrix(int n) {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				this.matrix[i][j] *= n;
			}
		}
		System.out.println("multiply by: " + n + " = " + Arrays.deepToString(matrix));
	}	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static Matrix multiply(Matrix a, Matrix b) {
		if (a.cols != b.rows) {	
			System.out.print("Dot product REQUIRES matrixA.cols = matrixB.rows");
			return null;
		}
		Matrix result = new Matrix(a.rows, b.cols);
			for (int i = 0; i < result.rows; i++) {
				for (int j = 0; j < result.cols; j++) {
					double sum = 0;
					for (int k = 0; k < a.cols; k++) {
						sum += a.matrix[i][k] * b.matrix[k][j];
					}
					result.matrix[i][j] = sum;
				}
			}
		return result;
	}
	
	public static void Map(Matrix n) {
		Activation r = new Activation();
		for(int i = 0; i < n.rows; i++) {
			for(int j = 0; j<n.cols; j++) {
				double val = n.matrix[i][j];
				n.matrix[i][j] = a.sigmoid(val);
			}
		}		 
	}

	/**
	 * 
	 * Method for handling scalar Addition of a Matrix. Matrix = [i+n][j+n]
	 * 
	 * @param n
	 */
	public void AddMatrix(int n) {

		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				this.matrix[i][j] += n;
			}
		}
		System.out.println("added: " + n + " = " + Arrays.deepToString(matrix));
	}

	/**
	 * Method for Adding two Matrices of the same size together.
	 * 
	 * @param b
	 * @return b
	 */
	public Matrix plus(Matrix b) {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				this.matrix[i][j] += b.matrix[i][j];
			}
		}
		return b;
	}
	
	/**
	 * Method for Multiplying two Matrices of the same size together.
	 * 
	 * @param b
	 * @return b
	 */
	public Matrix times(Matrix b) {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.cols; j++) {
				this.matrix[i][j] *= b.matrix[i][j];
			}
		}
		return b;
	}

	/**
	 * 
	 * @param b
	 * @return
	 */
	public static Matrix dot(Matrix a, Matrix b) {
		Matrix result = new Matrix(a.rows, b.cols);
		if (a.cols == b.rows) {	
			for (int i = 0; i < result.rows; i++) {
				for (int j = 0; j < result.cols; j++) {
					for (int k = 0; k < a.cols; k++) {
						result.matrix[i][j] += a.matrix[i][k] * b.matrix[k][j];
					}
				}
			}
		} else {
			System.out.print("Dot product REQUIRES matrixA.cols = matrixB.rows");
		}
		return result;
	}
	
	/**
	 * 
	 * @return
	 */
	public Matrix transpose() {
		Matrix a = new Matrix(this.cols, this.rows);
		
		for(int i = 0; i < this.rows; i++) {
			for(int j = 0; j < this.cols; j++) {
				a.matrix[j][i] = this.matrix[i][j];
			}
		}
		return a;
	}

	/**
	 * Method for subtracting param Matrix.
	 * 
	 * @param b
	 * @return b
	 */
	public Matrix minus(Matrix b) {
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				matrix[i][j] -= b.matrix[i][j];
			}
		}
		return b;
	}

	/**
	 * Method for creating exact copies of Matrix a.
	 * 
	 * @param a
	 * @return b
	 */
	public Matrix copyOf(Matrix a) {
		Matrix b = this;
		try {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					b.matrix[i][j] = a.matrix[i][j];
				}
			}
		} catch (Exception e) {
			throw new RuntimeException("Matrices should be of equal dimensions");
		}
		return b;
	}

	/**
	 * Method for printing out current Matrix value.
	 */
	public void printMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("[ ");
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println("]");
		}
		System.out.println();
	}

	public void randomMatrixMain() {
		int high = 1;
		int low = -1;
		Random result = new Random();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) result.nextInt((high-low)+1)+low;
			}
		}
	}
	
	
	/**
	 * Method for randomly allocating values to Matrix 2D array.
	 */
	public void randomMatrix() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = (int) (Math.random() * 10);
			}
		}
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static Matrix arrayToMatrix(int[] input) {
		Matrix a = new Matrix(input.length, 1);
		for (int i = 0; i < input.length; i++) {
			a.matrix[i][0] = input[i];
		}
		a.printMatrix();
		return a;
	}
	
	/**
	 * 
	 * @param input
	 * @return
	 */
	public static ArrayList<Double> matrixToArrayList(Matrix input) {
		ArrayList<Double> output = new ArrayList<Double>();
		for (int i = 0; i < input.matrix.length; i++) {
			for(int j = 0; j < input.matrix[i].length; j++) {
				output.add(input.matrix[i][j]);
			}
		}
		return output;
	}
	

	/**
	 * 
	 * @param a
	 * @return
	 */
	public static ArrayList<Double> matrixToArray(Matrix a) {
		ArrayList<Double> result = new ArrayList<Double>();
		for (int i = 0; i < a.matrix.length; i++) {
			for (int j = 0; j < a.matrix[i].length; j++) {
				result.add(a.matrix[i][j]);
			}
		}
		return result;
	}
	
	/**
	 * 
	 * @param newResult
	 * @return
	 */
	public static Matrix arraylistToMatrix(ArrayList<Double> newResult) {
		Matrix a = new Matrix(newResult.size(), 1);
		for (int i = 0; i < newResult.size(); i++) {
			a.matrix[i][0] = newResult.get(i);
			
		}
		return a;
	}
		
	/**
	 * 
	 * @return
	 */
	public int getRows() {
		return this.rows;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCols() {
		return this.cols;
	}
	
	/**
	 * 
	 * @return
	 */
	public double[][] getMatrix() {
		return this.matrix;
	}

	
	public static Matrix subtract(Matrix a, Matrix b) {
		for (int i = 0; i < a.rows; i++) {
			for (int j = 0; j < b.cols; j++) {
				 a.matrix[i][j] -= b.matrix[i][j];
			}
		}
		//result.printMatrix();
		return a;
	}
			
	
}