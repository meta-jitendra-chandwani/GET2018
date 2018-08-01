
public class Check {
	/*
     * To check whether array is empty or not
     * @param array
     * @return true is array is empty
     * @return false is array is not empty
     */
    boolean isEmpty(int array[]) {
        if (array.length == 0) {
            return true;
        }
        return false;
    }

    /*
     * To check whether number of X and Y in array are equal of not
     * @param array
     * @param X input
     * @param Y input
     * @return true if number of X is equal to number of Y
     * @return false if number of X is not equal to number of Y
     */
    boolean isUnequal(int array[], int X, int Y) {
        int countX = 0;
        int countY = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == X) {
                countX++;
            }
            if (array[i] == Y) {
                countY++;
            }
        }
        if (countX == countY) {
            return false;
        }
        return true;
    }

    /*
     * To check whether two adjacents X values are there.
     * @param array
     * @param X input
     * @return true if two adjacents values are X
     * @return false if two adjacents values are not X
     */
    boolean twoAdjacentX(int array[], int X) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == X && array[i + 1] == X) {
                return true;
            }
        }
        return false;
    }

    /*
     * To check whether X is last element in array
     * @param array
     * @param X input
     * @return true if X is last element
     * @return false if  X is not the last element
     */
    boolean isLastX(int array[], int X) {

        if (array[array.length - 1] == X) {
            return true;
        } else {
            return false;
        }
    }
}
