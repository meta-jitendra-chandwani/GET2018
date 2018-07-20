public class ArrOperation {
    int maxMirror(int array[]) {
//    	{6, 1, 4, 5, 4, 1, 9}
        int index = array.length - 1;
        int j, count = 0, k = 0, countarray[] = new int[index];
        for (int i = 0; i < array.length; i++) {
            for (j = index; j >= 0; j--) {
                if (array[i] == array[j]) {
                    count++;
                    index = j - 1;
                    if (i == array.length - 1) {
                        countarray[k] = count;
                        k++;
                    }
                    break;
                } else {
                    if (count != 0) {
                        countarray[k] = count;
                        count = 0;
                        k++;
                    }
                }
            }
//            {7, 1, 4, 9, 7, 4, 1}{1, 2, 1, 4}{1, 4, 5, 3, 5, 4, 1}
            if (j < 0 && i!=(array.length-1)) {
                index = array.length - 1;
            }
        }
        int max = count;
        for (int i = 0; i < countarray.length; i++) {
            if (max < countarray[i]) {
                max = countarray[i];
            }
        }
        return max;
    }
    public static void main(){
    	ArrOperation a=new ArrOperation();
    	int ar[]={6, 1, 4, 5, 4, 1, 9};
    	System.out.println(a.maxMirror(ar));
    }

}