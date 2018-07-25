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
    int splitArray(int array[]) throws AssertionError{
    	if(isEmpty(array)){
    		throw new AssertionError("Array is empty");
    	}
    	else{
    		int arraySum[] = new int[array.length];
    			arraySum[0] = array[0];
    			for(int i=1; i < array.length; i++) {
    			arraySum[i] = arraySum[i-1] + array[i];
    			}

    			for(int i=0; i < array.length-1; i++) {
    			if ( arraySum[i] == (arraySum[array.length-1]- arraySum[i])) {
    			return i+1;
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