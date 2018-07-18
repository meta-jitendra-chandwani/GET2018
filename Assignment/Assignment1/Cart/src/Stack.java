public class Stack
{
	static final int MAX = 1000;
	int top;
	int a[] = new int[MAX]; 

	boolean isEmpty()
	{
		return (top < 0);
	}
	Stack()
	{
		top = -1;
	}

	boolean Push(int x)
	{
		if (top >= (MAX-1))
		{
			System.out.println("Stack Overflow");
			return false;
		}
		else
		{
			a[++top] = x;
			return true;
		}
	}

	int PoP()
	{
		if (top < 0)
		{
			System.out.println("Stack Underflow");
			return 0;
		}
		else
		{
			int x = a[top--];
			return x;
		}
	}
	
	int Top()
	{
	    return a[top];
	}
}

class Main
{
	public static void main(String args[])
	{
		Stack s = new Stack();
		s.Push(10);
		s.Push(20);
		s.Push(30);
		System.out.println(s.Top() + " top");
	}
}
