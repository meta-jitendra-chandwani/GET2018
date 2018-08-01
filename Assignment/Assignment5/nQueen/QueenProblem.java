/*
 * To solve N Queen Problem using backtracking
 */
public class QueenProblem {

    /*
     * to check whether position is safe to placed queen or not
     * @param n x n board
     * @param row number
     * @param coloumn number
     * @param size of chess board
     * @return false if queen is not safe to placed at that position
     * @return true if it is safe to place queen at that position
     */
    boolean isSafe(int board[][], int row, int col, int dimensionOfMatrix) {
        int i, j;

        for (i = 0; i < col; i++)
            if (board[row][i] == 1) {
                return false;
            }


        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) {
                return false;
            }

        for (i = row, j = col; j >= 0 && i < dimensionOfMatrix; i++, j--)
            if (board[i][j] == 1) {
                return false;
            }

        return true;
    }

    /*
     * A recursive utility function to solve N Queen problem
     * @param n x n board
     * @param coloumn number
     * @param size of chess board
     * @return If the queen can not be placed in any row in this column col, then return false
     * @return else true
     */
    boolean nQueen(int board[][], int col, int dimensionOfMatrix) {

        if (col == dimensionOfMatrix) {
            return true;
        }


        for (int i = 0; i < dimensionOfMatrix; i++) {
            if (isSafe(board, i, col, dimensionOfMatrix)) {
                board[i][col] = 1;
                if (nQueen(board, col + 1, dimensionOfMatrix) == true) {
                    return true;
                }

                board[i][col] = 0;
            }
        }

        return false;
    }

    /*
     * A utility function to print solution
     * @param n x n board
     * @param size of chess board
     */
    void printSolution(int board[][], int dimensionOfMatrix) {
        for (int i = 0; i < dimensionOfMatrix; i++) {
            for (int j = 0; j < dimensionOfMatrix; j++)
                System.out.print(" " + board[i][j] + " ");
            System.out.println();
        }
    }

    /*
     * apply the solution on board
     * @param size of chess board
     * @return true if queens problem is solved 
     * @return else false
     */
    boolean solveNQ(int dimensionOfMatrix) {
        int board[][] = new int[dimensionOfMatrix][dimensionOfMatrix];

        for (int i = 0, j = 0; i > dimensionOfMatrix && j > dimensionOfMatrix; i++, j++) {
            board[i][j] = 0;
        }

        if (!(nQueen(board, 0, dimensionOfMatrix))) {
            System.out.print("Solution does not exist");
            return false;
        }

        printSolution(board, dimensionOfMatrix);
        return true;
    }

    public static void main(String arg[]) {
        QueenProblem queen = new QueenProblem();
        queen.solveNQ(8);

    }

}