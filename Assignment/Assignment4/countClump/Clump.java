/*
 * count number which repeat 2 or more time repeatedly
 */
public class Clump {

    /*
     * countCLumps used to evaluate number of clump in an array
     * @param array
     * @return number of clumps
     */
    int countClumps(int array[]) {
        int count = 0;
        boolean match = false;
        if (isEmpty(array)) {
            throw new AssertionError("Array is empty");
        } else {
            try {
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] == array[i + 1] && !match) {
                        match = true;
                        count++;
                    } else if (array[i] != array[i + 1]) {
                        match = false;
                    }
                }

            } catch (Exception e) {
                e.getStackTrace();
            }
        }
        return count;
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