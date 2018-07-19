import java.util.Scanner;

public class LinkListStackMain {
void option(){
	Scanner input=new Scanner(System.in);
    LinkListStack linklist = new LinkListStack();
   
    	System.out.print("\n1. Push element\n2. Pop element\n3. Top of the element\n4. Is stack is empty\nEnter your choice: "); 
    	switch (input.nextInt()) {
        case 1:
            System.out.println("Enter no. of elements to be entered: ");
            int totalelement=input.nextInt();
            for (int i = 0; i < totalelement; i++){
            	linklist.push(input.nextInt());
            }  
            option();
            break;
        case 2:linklist.pop();
        	System.out.println("The element is pop");
        	option();
            break;
        case 3:
        	linklist.top();
        	option();
        	break;
        case 4:
        	System.out.print("Is stack empty : "+linklist.isEmpty());
            option();
        	break;
        default:
            System.out.println("incorrect choice !");
    		}

}
public static void main(String[] args) {
	LinkListStackMain list=new LinkListStackMain();
	list.option();

  }
 }