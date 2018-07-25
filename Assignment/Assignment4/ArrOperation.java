
public class ArrOperation {
    int sum1 = 0, sum2 = 0;
    Check check=new Check();
	
	/*
     * evaluate position in array
     * @param array
     * @return index number if solution exist
     * @return -1 if not
     */
    int splitArray(int array[]) throws AssertionError{
    	if(check.isEmpty(array)){
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
     * evaluate max mirror in array
     * @param array
     * @return length of max mirror
     */
    int maxMirror(int array[]) {
        int max = 0;
        if (check.isEmpty(array)) {
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
     * countCLumps used to evaluate number of clump in an array
     * @param array
     * @return number of clumps
     */
    int countClumps(int array[]) {
        int count = 0;
        boolean match = false;
        if (check.isEmpty(array)) {
            throw new AssertionError("Array is empty");
        } else {
                for (int i = 0; i < array.length - 1; i++) {
                    if (array[i] == array[i + 1] && !match) {
                        match = true;
                        count++;
                    } else if (array[i] != array[i + 1]) {
                        match = false;
                    }
                }

           
            
        }
        return count;
    }

    /*
     * return an array after rearranged so that every X is immediately followed by a Y
     * @param array
     * @param X input
     * @param Y input
     * @return result array which implies all changes
     */
    int[] findXY(int array[], int X, int Y) {
        int result[] = array, k = 0;
        if(check.isEmpty(array)||check.isUnequal(array, X, Y)||check.isLastX(array, X)||check.twoAdjacentX(array, X)){
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
}
