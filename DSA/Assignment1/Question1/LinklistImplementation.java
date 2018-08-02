package Question1;

import java.util.NoSuchElementException;

/*
 *LinklistImplementation - is a implementation of stack using linklist
 *Class implements Stack interface  
 */
public class LinklistImplementation<T> implements Stack<T> {

	/*
	 * Node class - which implement the Node and Data structure of linklist
	 */
	class Node {
		public T data;
		public Node next;
	}

	private Node first;

	public LinklistImplementation() {
		first = null;
	}

	/*
	 * (non-Javadoc)
	 * @see Question1.Stack#peek()
	 * Peek -  return top element of stack
	 * @return T - generic type, top element of stack
	 */
	@Override
	public T peek() {
		T value=null;
		try{
			if (first == null) {
				throw new NoSuchElementException();
			} else {
				T top = first.data;
				value = top;
			}
		}catch(Exception e){
			e.getMessage();
		}
		return value;
		
	}


	/*
	 * (non-Javadoc)
	 * @see Question1.Stack#push(java.lang.Object)
	 * Push - Is to push value into the stack
	 * @param item - of generic type
	 */
	@Override
	public void push(T item) {
		try{
			Node n = new Node();
			n.data = item;
			n.next = first;
			first = n;
		}catch(Exception e){
			e.getStackTrace();
		}
		
	}

	/*
	 * (non-Javadoc)
	 * @see Question1.Stack#pop()
	 * pop - To pop element from the stack
	 * @return T - generic value that has been pop. 
	 */
	@Override
	public T pop() {
		T value = null;
		try{
			if (first == null) {
				throw new NoSuchElementException();
			} else {
				Node pop = first;
				first = first.next;
				value = pop.data;
			}
		}catch(Exception e){
			e.getStackTrace();
		}
		return value;
		
	}

}
