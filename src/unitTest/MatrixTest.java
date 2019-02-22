package unitTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import network.Matrix;

class MatrixTest {
	
	@Test
	void testAddition() {
		Matrix a = new Matrix(2,2);
		a.AddMatrix(5);
		ArrayList<Double> arr = Matrix.matrixToArray(a);
		
		if(arr.contains(5.0)) {
			System.out.print("true");
			assertTrue(true);
		} else {
			System.out.print("false");
			assertTrue(false);
		}
	}

	@Test
	void testMultiplication() {
		Matrix a = new Matrix(2,2);
		a.AddMatrix(5);
		a.multiplyMatrix(3);
		
		ArrayList<Double> arr = Matrix.matrixToArray(a);
		
		if(arr.contains(15.0)) {
			System.out.print("true");
			assertTrue(true);
		} else {
			System.out.print("false");
			assertTrue(false);
		}
	}
}
