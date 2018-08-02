package Question1;
/*
 *ArrayImplementation - is a implementation of stack using array
 *Class implements Stack interface  
 */
public class ArrayImplementation<T> implements Stack<T> {
	private T arrayStack[];
	private int sizeofArray = 0;

	@SuppressWarnings("unchecked")
	public ArrayImplementation(int sizeofArray) {
		this.sizeofArray = sizeofArray;
		arrayStack = (T[]) new Object[sizeofArray];
	}

	private int top = -1;

	/*
	 * (non-Javadoc)
	 * @see Question1.Stack#peek()
	 * Peek -  return top element of stack
	 * @return T - generic type, top element of stack
	 */
	@Override
	public T peek() {
		return arrayStack[top];
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
			if (top == sizeofArray) {
				System.out.println("Stack overflow");
			} else {
				top = top + 1;
				arrayStack[top] = item;
			}	
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
			if(top==-1){
				System.out.println("Stack underflow");
			}
			else{
				T popValue = arrayStack[top--];
				value = popValue;
			}	
		}catch(Exception e){
			e.getStackTrace();
		}
		return value;
			
	}
}