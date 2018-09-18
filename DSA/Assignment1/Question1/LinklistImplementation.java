package Question1;

import java.util.NoSuchElementException;

/*
 * LinklistImplementation - is a implementation of stack using linklist
 * Class implements Stack interface  
 */
public class LinklistImplementation<T> implements Stack<T> {

	private Node<T> first;

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
				T top = (T) first.data;
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
			Node<T> n = new Node<T>();
			n.data = item;			//add item in node n data part
			n.next = first;			//and add new node  at first
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
				Node<T> pop = first;
				first = first.next;
				value = pop.data;
			}
		}catch(Exception e){
			e.getStackTrace();
		}
		return value;
		
	}

}
