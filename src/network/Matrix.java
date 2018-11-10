package network;

import java.util.Arrays;

/**
 * Matrix Library
 * 
 * @author Harry Jackson
 *
 */
public class Matrix {

	private int rows;
	private int cols;
	private int[][] matrix;

	/**
	 * 
	 * @param rows
	 * @param cols
	 */
	public Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.matrix = new int[rows][cols];
	}

	/**
	 * 
	 * @param matrix
	 */
	public Matrix(int[][] matrix) {
		rows = matrix.length;
		cols = matrix[0].length;
		this.matrix = new int[rows][cols];
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
	public Matrix dot(Matrix b) {
		Matrix a = this;
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

}