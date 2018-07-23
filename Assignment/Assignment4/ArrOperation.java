import java.util.Scanner;

public class ArrOperation {
    private static Scanner input;
	int maxMirror(int array[]) {
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
            if (j < 0) {
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
    public static void main(String args[]) {
        input = new Scanner(System.in);
        System.out.println("Enter length : ");
        int length = input.nextInt();
        int array[] = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = input.nextInt();
        }
        ArrOperation operation = new ArrOperation();
        System.out.println(operation.maxMirror(array));
    }
}