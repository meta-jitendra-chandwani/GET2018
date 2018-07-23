/*
 * group of contiguous elements such that somewhere in the array, the same group appears in reverse order.
 */
public class ArrOperation {
    int maxMirror(int array[]) {
        int max = 0;
        if (isEmpty(array)) {
            throw new AssertionError("Array is empty");
        } else {
            int reverse[] = new int[array.length], j = 0;
            for (int i = array.length - 1; i >= 0; i--) {
                reverse[j] = array[i];
                j++;
            }

            int table[][] = new int[array.length + 1][array.length + 1];

            for (int i = 1; i < table.length; i++) {
                for (int k = 1; k < table.length; k++) {
                    if (array[i - 1] == reverse[k - 1]) {
                        table[i][k] = table[i - 1][k - 1] + 1;
                    }
                }
            }
            max = table[0][0];
            for (int i = 0; i < table.length; i++) {
                for (int k = 0; k < table.length; k++) {
                    if (max < table[i][k]) {
                        max = table[i][k];
                    }
                }
            }
        }
        return max;

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
}