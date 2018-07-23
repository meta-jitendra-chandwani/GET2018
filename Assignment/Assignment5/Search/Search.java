/*
 * Search class contain 2 function to search value in given array
 */
public class Search {

    /*
     * Linear search, for finding a target value within an array.
     * @param element to be search
     * @param array 
     * @return index at which element is found
     * @return -1 if element if not found
     */
    int linearSearch(int element, int array[]) {
        try {
            for (int i = 0; i < array.length; i++) {
                if (element == array[i]) {
                    return i;
                }
            }
        } catch (Exception e) {
            e.getStackTrace();
        }

        return -1;
    }

    /*
     * Binary search, that finds the position of a target value within a sorted array.
     * @param element to be search
     * @param sorted array 
     * @return index at which element is found
     * @return -1 if element if not found
     */
    int binarySearch(int element, int array[], int start, int end) {

        if (end >= start) {
            int middle = start + (end - start) / 2;
            if (element == array[middle]) {
                return middle;
            }
            if (array[middle] > element) {
                return binarySearch(element, array, start, middle - 1);
            }

            return binarySearch(element, array, middle + 1, end);

        } else {
            return -1;
        }

    }
}