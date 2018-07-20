import java.util.Scanner;


public class Clump {
	private static Scanner input;

	void countClumps(int array[]){
		int j=0,count=0;
		for(int i=0;i<array.length;i++){
//			for(int j=i;j<array.length;j++){
				while(j<array.length-1){
					if(array[i]==array[j]){
						j++;
					}
					else{
						break;
					}
				}
//				count++;
				
				
//			if(array[i]==array[i+1]){
//				
//			}
//			else{
//				break;
//			}
		}
			
	}
	public static void main(String args[]) {
        input = new Scanner(System.in);
        System.out.println("Enter length : ");
        int length = input.nextInt();
        int array[] = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = input.nextInt();
        }
        Clump operation = new Clump();
//        System.out.println(operation.countClumps(array));
    }
}
//1 2 2 3 4 4 