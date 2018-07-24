import java.util.Scanner;


public class Main {
	private static Scanner input;

	public static void main(String args[]){
		input = new Scanner(System.in);
		intSet set=new intSet();
		int setArray[]=new int[1000];
		for(int i=0;i<1000;i++){
			setArray[i]=(i+1);
		}
		System.out.println("/n1. To check whether X  is member or not/n2. Size of set/n3. Is subset/n4. Complemet of Set/n5. Union of two set\n");
		System.out.print("Enter your choice : ");
		switch (input.nextInt()) {
		case 1:	System.out.print("Enter x : ");
				int x=input.nextInt();
				if(set.isMember(x, setArray)){
					System.out.println("Yes x is the member of set.");
				}
				else{
					System.out.println("No x is not the member of set.");
				}
				break;
		case 2:	System.out.println("Size of set is :"+set.size(setArray));
				break;
		case 3:	System.out.print("Enter Length of subset : ");
				int subsetLength=input.nextInt();
				int subset[]=new int[subsetLength];
				for(int i=0;i<subsetLength;i++){
					subset[i]=input.nextInt();
				}
				set.isSubset(subset,setArray);
		default:
			break;
		}
	}

}
