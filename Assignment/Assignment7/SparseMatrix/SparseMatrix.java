package SparseMatrix;

import java.util.Arrays;
import java.util.Scanner;

public final class SparseMatrix {
	private static Scanner input = new Scanner(System.in);
	int row, col;

	public SparseMatrix(int row, int col) {
		this.row = row;
		this.col = col;
	}

	int[][] transposeMatrix(int matrix[][], int matRow, int matCol) {
		int value[][] = new int[matRow][matCol];
		for (int i = 0; i < matRow; i++) {
			value[i][0] = matrix[i][1];
			value[i][1] = matrix[i][0];
			value[i][2] = matrix[i][2];
		}
		return value;
	}

	int[][] addMatrices(int matrixOne[][], int matrixTwo[][]) {
		int sum[][] = new int[row][col];
		System.out.println(matrixOne.length);
		if (matrixOne.length == matrixTwo.length) {
			for (int i = 0; i < matrixOne.length; i++) {
				sum[matrixOne[i][0]][matrixOne[i][1]] += matrixOne[i][2];
				sum[matrixTwo[i][0]][matrixTwo[i][1]] += matrixTwo[i][2];
			}
		}
		return sum;
	}

	int[][] multiplyMatrices(int matrixOne[][], int matrixTwo[][]) {
		int mul[][] = new int[10][3];
		int k=0;
//		if (matrixOne[0].length == matrixTwo.length) {
			for (int i = 0; i < matrixOne.length; i++) {
				for (int j = 0; j < matrixTwo.length; j++) {
					if (matrixOne[i][1] == matrixTwo[j][0]) {
						mul[k][0]=matrixOne[i][0];
						mul[k][1]=matrixTwo[j][1];
						mul[k][2] = matrixOne[i][2] * matrixTwo[j][2];
						k++;
					}
				}

			}
//		}
		return mul;
	}

	boolean symmetrical(int transpose[][], int matrix[][], int matRow) {
		boolean flag = true;
		for (int i = 0; i < matRow; i++) {
			if (!Arrays.equals(transpose[i], matrix[i])) {
				flag = false;
			}
		}
		return flag;
	}

	int[][] changetoSparseMatrix(int matrix[][], int matRow, int matCol) {

		int newMatrix[][] = new int[row][col];
		for (int i = 0; i < matRow; i++) {
			newMatrix[matrix[i][0]][matrix[i][1]] = matrix[i][2];
		}
		return newMatrix;
	}

	public static void main(String arg[]) {

		System.out.println("Enter number of row & column : ");
		int row = input.nextInt();
		int col = input.nextInt();
		System.out.println("Enter number of sparse value : ");
		int max = input.nextInt();
		int value[][] = new int[max][3];

		System.out.println("Enter row colomn value of sparse matrix : ");
		int i = 0;
		for (int p = 0; p < max; p++) {
			System.out.println("Enter row column value :");
			for (int j = 0; j < 3 && i <= max; j++) {
				value[i][j] = input.nextInt();
			}
			i++;

		}

		System.out.println("====Matrix 2====");
		System.out.println("Enter number of row & column : ");
		int row1 = input.nextInt();
		int col1 = input.nextInt();
		System.out.println("Enter number of sparse value : ");
		int max1 = input.nextInt();
		int value1[][] = new int[max1][3];

		System.out.println("Enter row colomn value of sparse matrix : ");

		int i1 = 0;
		for (int p = 0; p < max; p++) {
			System.out.println("Enter row column value :");
			for (int j = 0; j < 3 && i1 <= max; j++) {
				value1[i1][j] = input.nextInt();
			}
			i1++;

		}

		System.out.println("row\tcol\tvalue");

		for (int k = 0; k < (i); k++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(value[k][j] + "\t");
			}
			System.out.println();
		}

		System.out.println("row\tcol\tvalue");

		for (int k = 0; k < (i); k++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(value1[k][j] + "\t");
			}
			System.out.println();
		}

		SparseMatrix sparse = new SparseMatrix(row, col);
//		System.out.println("Sparse matrix ======");
//
//		int realMatrix[][] = sparse.changetoSparseMatrix(value, max, 3);
//		for (int k = 0; k < row; k++) {
//			for (int j = 0; j < col; j++) {
//				System.out.print(realMatrix[k][j] + "\t");
//			}
//			System.out.println();
//		}
//		System.out.println("Tanspose ======");
//		int transposeMatrix[][] = sparse.transposeMatrix(value, max, 3);
//		for (int k = 0; k < (i); k++) {
//			for (int j = 0; j < 3; j++) {
//				System.out.print(transposeMatrix[k][j] + "\t");
//			}
//			System.out.println();
//		}
//
//		System.out.println("Symmetric : "
//				+ sparse.symmetrical(transposeMatrix, value, max));

		int sumMatrix[][] = sparse.addMatrices(value, value1);
		System.out.println("Addition ======");

		for (int k = 0; k < (4); k++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(sumMatrix[k][j] + "\t");
			}
			System.out.println();
		}

		int mulMatrix[][] = sparse.multiplyMatrices(value, value1);
		System.out.println("Multiplcation ======");
		for (int k = 0; k < (10); k++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(mulMatrix[k][j] + "\t");
			}
			System.out.println();
		}
	}

}
