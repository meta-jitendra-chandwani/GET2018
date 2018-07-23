/*
 * Splitarray find position to split the input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
 */
public class Splitarray {
    int sum1 = 0, sum2 = 0;

    /*
     * evaluate position in array
     * @param array
     * @return index number if solution exist
     * @return -1 if not
     */
    int splitArray(int array[]) {
    	if(isEmpty(array)){
    		throw new AssertionError("Array is empty");
    	}
    	else{
        for (int i = 1; i < array.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                sum1 += array[j];
            }
            for (int k = i; k < array.length; k++) {
                sum2 += array[k];
            }
            if (sum1 == sum2) {
                return (i);
            } else {
                sum1 = 0;
                sum2 = 0;
            }

        }
        }
        return -1;
    	
    }
    
    /*
     * To check whether array is empty or not
     * @param array
     * @return true is array is empty
     * @return false is array is not empty
     */
    boolean isEmpty(int array[]){
    	if(array.length==0){
    		return true;
    	}
    	return false;
    }
}