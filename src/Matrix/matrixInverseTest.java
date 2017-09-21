package Matrix;

import static org.junit.Assert.*;

import org.junit.Test;

public class matrixInverseTest {

	@Test
	public void test() {
		double[][] temp1 = new double[2][2];
		
		temp1[0][0] = 1; temp1[0][1] = 2; 
		temp1[1][0] = 3; temp1[1][1] = 4;
		
		Matrix mat1 = new Matrix();
		
		mat1.setElements(temp1);
		
		double[][] actual = new double[2][2];
		double[][] expected = new double[2][2];
		
		/**
		 * | 1	2 |
		 * | 3	4 |		
		 */
		
		expected[0][0] = -2.0; expected[0][1] = 1.0; 
		expected[1][0] = 1.5; expected[1][1] = 0.5;
		
		actual = mat1.matrixInverse();
		assertArrayEquals(expected,actual);
	}
}
