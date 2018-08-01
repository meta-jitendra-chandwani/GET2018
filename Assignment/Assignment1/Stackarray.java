import java.util.Scanner;
/*
 * Stackarray its a simple implementation of stack using array
 * Is consist of 4 stack function 
 */
public class Stackarray {
    public static Scanner input = new Scanner(System.in);

    static final int MAX = 1000;
    int top;
    int stack[] = new int[MAX]; // Maximum size of Stack

    Stackarray() {
        top = -1;
    }

    /*
     * check whether stack is empty or not
     * @return boolean value
     */
    boolean isEmpty() {
        return (top < 0);
    }


    /*
     * push element into the stack
     * @param element to be push or inserted
     * @return false if stack is full stack or overflow size>=1000
     * @return true when element is push into the stack
     */
    boolean push(int element) {
        if (top >= (MAX - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            stack[++top] = element;
            return true;
        }
    }

    /*
     * pop element from the stack
     * @param element to be pop or deleted
     * @return false if stack is empty or underflow
     * @return true when element is pop from the stack
     */
    int pop() {
        if (top < 0) {
            System.out.println("Stack Underflow");
            return 0;
        } else {
            int element = stack[top--];
            return element;
        }
    }

    /*
     * top element of the stack
     * @return top element of the stack
     * @return -1 when stack is empty 
     */
    int top() {
        if (top >= 0) {
            return stack[top];
        } else {
            return -1;
        }
    }

    /*
     * menu part of program
     */
    void option() {
        System.out.print("\n1. Push element\n2. Pop element\n3. Top of the element\n4. Is stack is empty\nEnter your choice: ");
        switch (input.nextInt()) {
            case 1:
                System.out.println("Enter no. of elements to be entered: ");
                int totalelement = input.nextInt();
                for (int i = 0; i < totalelement; i++) {
                    push(input.nextInt());
                }
                option();
                break;
            case 2:
                if (pop() != 0) {
                    System.out.println("The element is pop : " + pop());
                }
                option();
                break;
            case 3:
                if (top >= 0) {
                    System.out.println("Stack top element : " + top());
                } else {
                    System.out.println("Stack is empty");
                }
                option();
                break;
            case 4:

                System.out.print("Is stack empty : " + isEmpty());
                option();
                break;
            default:
                System.out.println("incorrect choice !");
        }

    }
}

class Main {
    public static void main(String args[]) {
        Stackarray stack = new Stackarray();
        stack.option();



    }
}