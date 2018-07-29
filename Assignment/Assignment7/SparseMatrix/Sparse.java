package sparsematrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sparse {

    int row, col;

    /*
     * Initialization of row and coloumn
     */
    public Sparse(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /*
     * Transpose the given matrix
     * @param matrix - Sparse Matrix in form of row,column and value
     * @return transposeMatrix -  Transpose of matrix
     */
    public int[][] transposeMatrix(int matrix[][]) {
        int transposeMatrix[][] = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            transposeMatrix[i][0] = matrix[i][1];
            transposeMatrix[i][1] = matrix[i][0];
            transposeMatrix[i][2] = matrix[i][2];
        }
        return transposeMatrix;
    }

    /*
     * Addition of given two matrix
     * @param matrixOne - Sparse Matrix 1
     * @param matrixTwo - Sparse Matrix 2
     * @return additionMatrix - Addition of 2 Sparse Matrix
     */
    public int[][] addMatrices(int matrixOne[][], int matrixTwo[][]) {
        int additionMatrix[][] = new int[row][col];
        if (matrixOne.length == matrixTwo.length) {
            for (int i = 0; i < matrixOne.length; i++) {
                additionMatrix[matrixOne[i][0]][matrixOne[i][1]] += matrixOne[i][2];
                additionMatrix[matrixTwo[i][0]][matrixTwo[i][1]] += matrixTwo[i][2];
            }
        }

        return additionMatrix;
    }

    /*
     * Multiplication of given two matrix
     * @param matrixOne - Sparse Matrix 1
     * @param matrixTwo - Sparse Matrix 2
     * @return multiplicationMatrix - Multiplication of 2 Sparse Matrix
     */
    public int[][] multiplyMatrices(int matrixOne[][], int matrixTwo[][]) {

        List<Integer> Row = new ArrayList<>();
        List<Integer> Col = new ArrayList<>();
        List<Integer> Value = new ArrayList<>();
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
        int multiplicationMatrix[][] = new int[Row.size()][3];
        for (int i = 0; i < Row.size(); i++) {
            multiplicationMatrix[i][0] = Row.get(i);
            multiplicationMatrix[i][1] = Col.get(i);
            multiplicationMatrix[i][2] = Value.get(i);
        }
        return multiplicationMatrix;
//        return changetoSparseMatrix(mul, mul.length, mul[0].length);
    }

    /*
     * Check whether given two matrix are equal or not
     * @param matrixOne - Sparse Matrix 1
     * @param matrixTwo - Sparse Matrix 2
     * @return boolean flag value - True if two matrices are equal else false
     */
    boolean symmetrical(int matrixOne[][], int matrixTwo[][]) {
        boolean flag = true;
        for (int i = 0; i < matrixOne.length; i++) {
            if (!Arrays.equals(matrixOne[i], matrixTwo[i])) {
                flag = false;
            }
        }
        return flag;
    }

//    int[][] changetoSparseMatrix(int matrix[][], int matRow) {
//        int newMatrix[][] = new int[row][col];
//        for (int i = 0; i < matrix.length; i++) {
//            newMatrix[matrix[i][0]][matrix[i][1]] = matrix[i][2];
//        }
//        return newMatrix;
//    }
//
//    public static void main(String[] args) {
//        Sparse sparse = new Sparse(4, 4);
//        int setArray1[][] = {{0, 1, 1}, {0, 3, 2}, {1, 0, 3}, {1, 3, 4}, {2, 3, 5}, {3, 2, 6}};
//        int setArray2[][] = {{0, 0, 3}, {0, 3, 4}, {1, 2, 4}, {2, 0, 6}, {2, 3, 5}, {3, 2, 1}};
//
//        int add[][] = sparse.addMatrices(setArray1, setArray2);
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                System.out.print(add[i][j] + "\t");
//            }
//            System.out.println();
//        }
//    }
}