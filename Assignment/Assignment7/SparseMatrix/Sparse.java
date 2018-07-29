/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sparsematrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Jitendra
 */
public class Sparse {

    private static Scanner input = new Scanner(System.in);
    int row, col;

    public Sparse(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int[][] transposeMatrix(int matrix[][]) {
        int value[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            value[i][0] = matrix[i][1];
            value[i][1] = matrix[i][0];
            value[i][2] = matrix[i][2];
        }
        return value;
    }

    public int[][] addMatrices(int matrixOne[][], int matrixTwo[][]) {
        int sum[][] = new int[row][col];
        System.out.println(matrixOne.length);
        if (matrixOne.length == matrixTwo.length) {
            for (int i = 0; i < matrixOne.length; i++) {
                sum[matrixOne[i][0]][matrixOne[i][1]] += matrixOne[i][2];
                sum[matrixTwo[i][0]][matrixTwo[i][1]] += matrixTwo[i][2];
            }
        }
        return changetoSparseMatrix(sum, sum.length, sum[0].length);
    }

    public int[][] multiplyMatrices(int matrixOne[][], int matrixTwo[][]) {

        List<Integer> Row = new ArrayList<>();
        List<Integer> Col = new ArrayList<>();
        List<Integer> Value = new ArrayList<>();
//		if (matrixOne[0].length == matrixTwo.length) {
        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixTwo.length; j++) {
                if (matrixOne[i][1] == matrixTwo[j][0]) {
                    Row.add(matrixOne[i][0]);
                    Col.add(matrixTwo[j][1]);
                    Value.add(matrixOne[i][2] * matrixTwo[j][2]);

                }
            }

        }
        int start = 0;
        for (int i = start; i < Row.size() - 1; i++) {
            if (Row.get(i) == Row.get(i + 1) && Col.get(i) == Col.get(i + 1)) {
                int newValue = Value.get(i) + Value.get(i + 1);
                Value.set(i + 1, newValue);
                Row.remove(i);
                Col.remove(i);
                Value.remove(i);
                start = i;
            }
        }
        int mul[][] = new int[Row.size()][3];
        for (int i = 0; i < Row.size(); i++) {
            mul[i][0] = Row.get(i);
            mul[i][1] = Col.get(i);
            mul[i][2] = Value.get(i);
        }
//		}
//        return mul;
        return changetoSparseMatrix(mul, mul.length, mul[0].length);
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
//
//        System.out.println("Enter number of row & column : ");
//        int row = input.nextInt();
//        int col = input.nextInt();
//        System.out.println("Enter number of sparse value : ");
//        int max = input.nextInt();
//        int value[][] = new int[max][3];
//
//        System.out.println("Enter row colomn value of sparse matrix : ");
//        int i = 0;
//        for (int p = 0; p < max; p++) {
//            System.out.println("Enter row column value :");
//            for (int j = 0; j < 3 && i <= max; j++) {
//                value[i][j] = input.nextInt();
//            }
//            i++;
//
//        }

//        System.out.println("====Matrix 2====");
//        System.out.println("Enter number of row & column : ");
//        int row1 = input.nextInt();
//        int col1 = input.nextInt();
//        System.out.println("Enter number of sparse value : ");
//        int max1 = input.nextInt();
//        int value1[][] = new int[max1][3];
//
//        System.out.println("Enter row colomn value of sparse matrix : ");
//
//        int i1 = 0;
//        for (int p = 0; p < max; p++) {
//            System.out.println("Enter row column value :");
//            for (int j = 0; j < 3 && i1 <= max; j++) {
//                value1[i1][j] = input.nextInt();
//            }
//            i1++;
//
//        }
//
//        System.out.println("row\tcol\tvalue");
//
//        for (int k = 0; k < (i); k++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(value[k][j] + "\t");
//            }
//            System.out.println();
//        }
//
//        System.out.println("row\tcol\tvalue");
//
//        for (int k = 0; k < (i); k++) {
//            for (int j = 0; j < 3; j++) {
//                System.out.print(value1[k][j] + "\t");
//            }
//            System.out.println();
//        }
//
        Sparse sparse = new Sparse(4, 4);
////		
//		System.out.println("Tanspose ======");
//		int transposeMatrix[][] = sparse.transposeMatrix(value);
//		for (int k = 0; k < (i); k++) {
//			for (int j = 0; j < 3; j++) {
//				System.out.print(transposeMatrix[k][j] + "\t");
//			}
//			System.out.println();
//		}
////
////		System.out.println("Symmetric : "
////				+ sparse.symmetrical(transposeMatrix, value, max));
//
//        int sumMatrix[][] = sparse.addMatrices(value, value1);
//        System.out.println("Addition ======");
//
//        for (int k = 0; k < row; k++) {
//            for (int j = 0; j < col; j++) {
//                System.out.print(sumMatrix[k][j] + "\t");
//            }
//            System.out.println();
//        }
//
//        int mulMatrix[][] = sparse.multiplyMatrices(value, value1);
//        
//        System.out.println("Multiplcation ======");
////        for (int k = 0; k < mulMatrix.length; k++) {
////            for (int j = 0; j < 3; j++) {
////                System.out.print(mulMatrix[k][j] + "\t");
////            }
////            System.out.println();
////        }
        int setArray1[][] = {{0, 1, 1}, {0, 3, 2}, {1, 0, 3}, {1, 3, 4}, {2, 3, 5}, {3, 2, 6}};
        int setArray2[][] = {{0, 0, 3}, {0, 3, 4}, {1, 2, 4}, {2, 0, 6}, {2, 3, 5}, {3, 2, 1}};

        int mulpli[][] = sparse.multiplyMatrices(setArray1,setArray2);
        for (int k = 0; k < (4); k++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(mulpli[k][j] + "\t");
            }
            System.out.println();
        }
//        
        }

    }
