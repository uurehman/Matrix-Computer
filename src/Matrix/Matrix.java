package Matrix;

import java.util.Scanner;
import java.util.Random;

public class Matrix {
	private String matrixName;
	private int col, row;  //Dimensions
	private double myMatrix [][];
	
	public static void main(String[] args) {
		System.out.println("First Matrix\n");
		Matrix matrixA = new Matrix();
		String matrixAName = matrixA.getMatrixName();
		matrixA.getNewMatrix();
		
		System.out.println("\nSecond Matrix\n");
		Matrix matrixB = new Matrix();
		String matrixBName = matrixB.getMatrixName();
		matrixB.getNewMatrix();
		
		int choice=0;
		while(choice!=-1) {
			System.out.println("\n\nYou can perform following functions: ");
			System.out.println("Sum:\t\t\t" + matrixAName + " + " + matrixBName + "\nDifference:\t\t" + matrixAName + " - " + matrixBName + "\nMultiply:\t\t" + matrixAName + " * " + matrixBName + "\nTranspose:\t\t" + matrixAName + " ^ t \nInverse:\t\t" + matrixAName + " ^ -1 \nScalar Multiplication:\t" + matrixAName + " # 3 ");
			System.out.println("\npress -1 to exit");
			System.out.println("\n");
			Scanner eq=new Scanner(System.in);
			System.out.println("Please enter your equation with spaces e.g " + matrixAName + " + " + matrixBName + "\nEnter eq: ");
			String equation =eq.nextLine();
			String result[]=equation.split(" ");
			
			if(result[0].equals("-1")) break;
	 
			if(result[0].equals(matrixAName)) {
				if(result[2].equals(matrixBName)) {
		 			if(result[1].equals("+")) matrixA.matrixSum(matrixB);
		 			else if(result[1].equals("-")) matrixA.matrixDiff(matrixB);
		 			else if(result[1].equals("*")) matrixA.matrixMultiply(matrixB);
				}
				else if(result[2].equals(matrixAName)) {
					if(result[1].equals("+")) matrixA.matrixSum(matrixA);
		 			else if(result[1].equals("-")) matrixA.matrixDiff(matrixA);
		 			else if(result[1].equals("*")) matrixA.matrixMultiply(matrixA);
				}
		 		else if(result[2].equals("-1")) matrixA.matrixInverse();
		 		else if(result[2].equals("t")) matrixA.matrixTranspose();
				else if(result[1].equals("#")) {
					int i=Integer.parseInt(result[2]);
					matrixA.matrixScalerMul(i);
				}
				else System.out.println("Variable "+result[2]+" not exist.");
			}
			else if(result[0].equals(matrixBName)) {
					if(result[2].equals(matrixAName)) {
						if(result[1].equals("+")) matrixB.matrixSum(matrixA);
						else if(result[1].equals("-")) matrixB.matrixDiff(matrixA);
						else if(result[1].equals("*")) matrixB.matrixMultiply(matrixA);
					}
					else if(result[2].equals(matrixBName)) {
						if(result[1].equals("+")) matrixB.matrixSum(matrixB);
						else if(result[1].equals("-")) matrixB.matrixDiff(matrixB);
						else if(result[1].equals("*")) matrixB.matrixMultiply(matrixB);
					}
					else if(result[2].equals("-1")) matrixB.matrixInverse();
					else if(result[2].equals("t")) matrixB.matrixTranspose();
					else if(result[1].equals("#")){
						int i=Integer.parseInt(result[2]);
						matrixB.matrixScalerMul(i);
					}
					else System.out.println("Variable "+result[2]+" not exist.");
			}
			else System.out.println("Variable "+result[0]+" not exist.");
		}
		System.out.println("Good bye");
	}
	
	//Methods
	
	 /**
	  * COnstructor
	  */
	Matrix () {	col = row = 2; matrixName = "unNamedMatrix"; }
	
	/**
	 * Ask user to set a name of matrix
	 */
	public String getMatrixName() {
		System.out.println("Enter the name of the matrix:");
		Scanner input = new Scanner(System.in);
		matrixName = input.nextLine();
		System.out.println("Great! Matrix name: " + matrixName);
		return matrixName;
	}
	
	/**
	 * get the size of the matrix from user
	 */
	private void getDimentions() {
		System.out.println("Enter the number of rows: ");
		Scanner input = new Scanner(System.in);
		row = input.nextInt();
		System.out.println("Enter the number of columns: ");
		col = input.nextInt();
		
		if(row <= 0 || col <= 0) {
			System.out.println("ERROR! Invalid dimentions. Enter again");
			getDimentions();
		}
		System.out.println("Great! Rows: " + row + "\t Columns: " + col);
	}
	
	/**
	 * Set the elements of matrix with random numbers
	 */
	private void setElements() {
		myMatrix = new double[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				Random rand = new Random();
				int  n = rand.nextInt(10) + 0;
				//10 is the maximum and the 0 is our minimum 
				myMatrix[i][j] = n;
			}
		}
	}
	/**
	 * set the elements manually
	 * @param b input matrix array
	 */
	public void setElements(double b[][]) {
		myMatrix = new double[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				myMatrix[i][j] = b[i][j];
			}
		}
	}
	
	/**
	 * print the Matrix Class object in console
	 */
	public void showMatrix() {
		System.out.println("Showing Matrix: ");
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print("\t" + myMatrix[i][j]);
			}
			System.out.println(" ");
		}
	}
	
	/**
	 * print any 2D array in matrix form
	 * @param b is the 2D array that is to be displayed
	 */
	public void viewMatrix(double b[][]) {
		System.out.println("Showing Matrix: ");
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				System.out.print("\t" + b[i][j]);
			}
			System.out.println();
		}
	}
	
	/**
	 * set the values of a new Martix object
	 */
	public void getNewMatrix() {
		getDimentions();
		setElements();
		System.out.println("Matrix" + matrixName + " set");
		showMatrix();
	}
	
	/**
	 * calculates the sum of two Matrix objects
	 * @param B Matrix Object to be added
	 * @return the Addition Matrix
	 */
	public double[][] matrixSum(Matrix B){
		double temp[][];
		temp = new double[row][col];
		if (row != B.row || col != B.col) {
			System.out.println("ERROR: Order in not eqaul of both matrices");
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					temp[i][j] = 0;
				}
			}
		}
		else {
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					temp[i][j] = myMatrix[i][j] + B.myMatrix[i][j];
				}
			}
		}
		viewMatrix(temp);
		return temp;
	}

	public double[][] matrixDiff(Matrix B){
		double temp[][];
		temp = new double[row][col];
		if (row != B.row || col != B.col) {
			System.out.println("ERROR: Order in not eqaul of both matrices");
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					temp[i][j] = 0;
				}
			}
		}
		else {
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					temp[i][j] = myMatrix[i][j] - B.myMatrix[i][j];
				}
			}
		}
		viewMatrix(temp);
		return temp;
	}
	
	public double[][] matrixScalerMul(int num){
		double temp[][];
		temp = new double[row][col];
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				temp[i][j] = 0;
			}
		}
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				temp[i][j] = myMatrix[i][j] * num;
			}
		}
		viewMatrix(temp);
		return temp;
	}

	public double[][] matrixTranspose(){
		double temp[][];
		temp = new double[row][col];
		if (row != col) {
			System.out.println("ERROR: Matrix must be a square matrix");
			for(int i = 0; i < row; i++)
				for(int j = 0; j < col; j++)
					temp[i][j] = 0;
		}
		else {
			for(int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					temp[i][j] = myMatrix[j][i];
				}
			}
		}
		viewMatrix(temp);
		return temp;
	}

	public double[][] matrixMultiply(Matrix B) {
		double temp[][];
		temp = new double[row][col];
			int sum=0;
			 if(col == B.row) {
				for(int i=0; i < row; i++) {
					for(int j=0; j < B.col; j++) {
						for(int k=0; k < col; k++) {
		  					sum+=myMatrix[i][k] * B.myMatrix[k][j];
						}
						temp[i][j] = sum;
						sum=0;
					}
				}
			 for(int i=0;i<row;i++) {
				for(int j=0; j<B.col;j++) {
					System.out.print("\t"+temp[i][j]);
				} 
				System.out.println("\n");
			}
	   	 }
	   	 else
	   		System.out.println("ERROR: Invalid order of matrices.");
		
	   	 return temp;
	}
	
	public  double[][] matrixInverse() {
		double temp[][];
		temp = new double[row][col];
		for(int i = 0; i < row; i++)
			for(int j = 0; j < col; j++)
				temp[i][j] = myMatrix[i][j];
		if(col != row) {
			System.out.println("ERROR: Matrix must be a square matrix");
			for(int i = 0; i < row; i++)
				for(int j = 0; j < col; j++)
					temp[i][j] = 0;
		}
		else {
			double[][] invertMatrix = invert(temp);
			System.out.println("The inverse is: ");
			
			for (int i=0; i<row; ++i) {
				for (int j=0; j<row; ++j) {
					System.out.print(invertMatrix[i][j] + "\t\t");
				}
				System.out.println();
			}	
		}
		return temp;
	}


	public static double[][] invert(double a[][]) {
		int n = a.length;
		double x[][] = new double[n][n];
		double b[][] = new double[n][n];
		int index[] = new int[n];
		for (int i=0; i<n; ++i) 
		b[i][i] = 1; // Transform the matrix into an upper triangle
		gaussian(a, index); // Update the matrix b[i][j] with the ratios stored
		for (int i=0; i<n-1; ++i)
			for (int j=i+1; j<n; ++j)
				for (int k=0; k<n; ++k)
					b[index[j]][k] -= a[index[j]][i]*b[index[i]][k]; // Perform backward substitutions
		for (int i=0; i<n; ++i) {
			x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
			for (int j=n-2; j>=0; --j) {
				x[j][i] = b[index[j]][i];
				for (int k=j+1; k<n; ++k) {
					x[j][i] -= a[index[j]][k]*x[k][i];
				}
				x[j][i] /= a[index[j]][j];
			}
		}
		return x;
	}

	/**
	 *  Method to carry out the partial-pivoting Gaussian
	 *  elimination.  Here index[] stores pivoting order.
	 * @param a
	 * @param index
	 */	
	public static void gaussian(double a[][], int index[]) {
		int n = index.length;
		double c[] = new double[n]; // Initialize the index
		for (int i=0; i<n; ++i) 
		index[i] = i; // Find the rescaling factors, one from each row
		for (int i=0; i<n; ++i) {
			double c1 = 0;
			for (int j=0; j<n; ++j) {
				double c0 = Math.abs(a[i][j]);
				if (c0 > c1) c1 = c0;
			}
			c[i] = c1;
		} 
		// Search the pivoting element from each column
		int k = 0;
		for (int j=0; j<n-1; ++j) {
			double pi1 = 0;
			for (int i=j; i<n; ++i) {
				double pi0 = Math.abs(a[index[i]][j]);
				pi0 /= c[index[i]];
				if (pi0 > pi1) {
					pi1 = pi0;
					k = i;
				}
			}   // Interchange rows according to the pivoting order
			int itmp = index[j];
			index[j] = index[k];
			index[k] = itmp;
			for (int i=j+1; i<n; ++i) {
				double pj = a[index[i]][j]/a[index[j]][j]; // Record pivoting ratios below the diagonal
				a[index[i]][j] = pj; // Modify other elements accordingly
				for (int l=j+1; l<n; ++l)
				a[index[i]][l] -= pj*a[index[j]][l];
			}
		}
	}
}
