import java.util.*;

public class LinklistStack
{ private static Scanner sc=new Scanner(System.in);

	class Node
	{
		public int data;
		public Node next;
	}

	private Node first;

	public LinklistStack()
	{
		first = null;
	}

	 /*
     * push element into the stack
     * @param element to be push or inserted into the head of linklist
     */
	public void push(int element)
	{
		Node n = new Node();
		n.data = element;
		n.next = first;
		first = n;
	}

	 /*
     * top element of the stack
     * @return top element of the stack or head of linklist
     * @return thows exception if linklist is empty or null
     */
	public int peek()
	{
		if (first == null)
		{	
			throw new NoSuchElementException();
		}
		else
		{
			int top = first.data;
			return top;
		}
	}

	/*
     * pop element from the stack     * 
     * @return thows exception if linklist is empty or null
     * @return head or pop value
     */
	public int pop()
	{
		if (first == null)
		{
			throw new NoSuchElementException();
		}
		else
		{
			Node pop = first;
			first = first.next;
			return pop.data;
		}
	}

	public static void main (String[] args)
	{
		LinklistStack list = new LinklistStack();
		sc = new Scanner(System.in);
        int choice = 1;
        int numberOfElement = 0;
        while (choice != 4) {
            System.out.print("\n1. Push\n2. Pop\n3. Top\n4. Exit\nEnter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter no. of elements to be entered: ");
                    numberOfElement = sc.nextInt();
                    for (int i = 0; i < numberOfElement; i++)
                        list.push(sc.nextInt());
                    break;
                case 2:
                    System.out.println(list.pop()+" is pop from the stack");
                    break;
                case 3:
                    System.out.println("The Top element of the stack : "+list.peek());
                    break;
                case 4:
                    break;
                default:
                    System.out.println("incorrect choice !");
            }
        }
		
	}
}