package sparsematrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Sparse {

    final int row, col;

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

        List<Integer> rowList = new ArrayList<>();
        List<Integer> colList = new ArrayList<>();
        List<Integer> valueList = new ArrayList<>();
        for (int i = 0; i < matrixOne.length; i++) {
            for (int j = 0; j < matrixTwo.length; j++) {
                if (matrixOne[i][1] == matrixTwo[j][0]) {
                	rowList.add(matrixOne[i][0]);
                	colList.add(matrixTwo[j][1]);
                	valueList.add(matrixOne[i][2] * matrixTwo[j][2]);

                }
            }

        }
        int start = 0;
        for (int i = start; i < rowList.size() - 1; i++) {
            if (rowList.get(i) == rowList.get(i + 1) && colList.get(i) == colList.get(i + 1)) {
                int newValue = valueList.get(i) + valueList.get(i + 1);
                valueList.set(i + 1, newValue);
                rowList.remove(i);
                colList.remove(i);
                valueList.remove(i);
                start = i;
            }
        }
        int multiplicationMatrix[][] = new int[rowList.size()][3];
        for (int i = 0; i < rowList.size(); i++) {
            multiplicationMatrix[i][0] = rowList.get(i);
            multiplicationMatrix[i][1] = colList.get(i);
            multiplicationMatrix[i][2] = valueList.get(i);
        }
        return multiplicationMatrix;
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
                break;
            }
        }
        return flag;
    }
}