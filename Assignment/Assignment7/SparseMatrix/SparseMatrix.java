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
		int max = row * col;
		int value[][] = new int[max][3];
		System.out.println("Enter row colomn value of sparse matrix : ");
		char reply;
		int i = 0;
		do {
			System.out.println("Enter row column value :");
			for (int j = 0; j < 3 && i != max / 2; j++) {
				value[i][j] = input.nextInt();
			}
			i++;
			System.out.println("Add more value : ");
			reply = input.next().charAt(0);
		} while (reply == 'y' || reply == 'Y');

		System.out.println("row\tcol\tvalue");

		for (int k = 0; k < (i); k++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(value[k][j] + "\t");
			}
			System.out.println();
		}

		SparseMatrix sparse = new SparseMatrix(row, col);
		System.out.println("Sparse matrix ======");

		int realMatrix[][] = sparse.changetoSparseMatrix(value, i, 3);
		for (int k = 0; k < row; k++) {
			for (int j = 0; j < col; j++) {
				System.out.print(realMatrix[k][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("Tanspose ======");
		int transposeMatrix[][] = sparse.transposeMatrix(value, i, 3);
		for (int k = 0; k < (i); k++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(transposeMatrix[k][j] + "\t");
			}
			System.out.println();
		}
		
		System.out.println("Symmetric : "+sparse.symmetrical(transposeMatrix, value, i));

	}
}
