package Matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixAdditionTest {

	@Test
	public void test() {
		double[][] temp1 = new double[2][2];
		double[][] temp2 = new double[2][2];
		
		temp1[0][0] = 1; temp1[0][1] = 2; 
		temp1[1][0] = 3; temp1[1][1] = 4;
		
		temp2[0][0] = 5; temp2[0][1] = 6; 
		temp2[1][0] = 8; temp2[1][1] = 7;
		
		Matrix mat1 = new Matrix();
		Matrix mat2 = new Matrix();
		
		mat1.setElements(temp1);
		mat2.setElements(temp2);
		
		double[][] actual = new double[2][2];
		double[][] expected = new double[2][2];
		
		/**
		 * | 1	2 |		| 5	 6 |
		 * | 3	4 |		| 7	 8 |
		 */
		
		expected[0][0] = 6.0; expected[0][1] = 8.0; 
		expected[1][0] = 11.0; expected[1][1] = 11.0;
		
		actual = mat1.matrixSum(mat2);
		assertArrayEquals(expected,actual);
	}
}
