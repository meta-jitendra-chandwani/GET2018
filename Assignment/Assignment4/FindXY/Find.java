/*
 * Return an array that contains exactly the same numbers as the input array, but rearranged so that every X is immediately followed by a Y
 */
public class Find {

    /*
     * return an array after rearranged so that every X is immediately followed by a Y
     * @param array
     * @param X input
     * @param Y input
     * @return result array which implies all changes
     */
    int[] findXY(int array[], int X, int Y) {
        int result[] = array, k = 0;
        if(isEmpty(array)||isUnequal(array, X, Y)||isLastX(array, X)||twoAdjacentX(array, X)){
        throw new AssertionError("Array is not full fill the prerequisite");
        }
        else{
        for (int i = 0; i < array.length - 1; i++) {
            if (result[i] == X) {
                if (result[i + 1] == Y) {
                    continue;
                } else {
                    for (int j = k; j < array.length; j++) {
                        if (result[j] == Y) {
                            k = j;
                            int swap = result[j];
                            result[j] = result[i + 1];
                            result[i + 1] = swap;
                        }
                    }
                }
            } else {
                continue;
            }
        }
        }
        return result;
    }

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