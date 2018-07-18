import java.util.*;

class stackImplementation {
    List < Integer > stack = new LinkedList < Integer > ();
    Scanner sc = new Scanner(System.in);
    int top = -1;

    public void Push(int element) { //push elements into the stack
        top++;
        stack.add(element);
    }

    public void Pop() { //pop elements from the stack
        if (!(stack.isEmpty())) {
            stack.remove(top);
            top--;
        } else
            System.out.println("stack underflowed !");
    }

    public int Top() { //return top element from the stack
        return stack.get(top);
    }

    public void show() { //display the stack elements
        for (int elements: stack) {
            System.out.println(elements);
        }
    }

}
public class stackLinkedList {


    private static Scanner sc;

    public static void main(String args[]) {

        stackImplementation obj = new stackImplementation();
        sc = new Scanner(System.in);
        int choice = 1;
        int numberOfElement = 0;
        while (choice != 4) {
            System.out.println("Enter your choice: \n1.Push\n2.Pop\n3.top\n4.exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter no. of elements to be entered: ");
                    numberOfElement = sc.nextInt();
                    for (int i = 0; i < numberOfElement; i++)
                        obj.Push(sc.nextInt());
                    obj.show();
                    break;
                case 2:
                    obj.Pop();
                    obj.show();
                    break;
                case 3:
                    System.out.println(obj.Top());
                    break;

                case 4:
                    break;
                default:
                    System.out.println("incorrect choice !");
            }
        }
    }
}