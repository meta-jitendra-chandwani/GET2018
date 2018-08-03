package Question2;

/*
 *ArrayImplementationOfQueue - is a implementation of Queue using array
 *Class implements Queue interface  
 */
public class ArrayImplementationOfQueue<T> implements Queue<T> {
	private T arrayQueue[];
	private int sizeofArray = 0;
	private int front = -1, rear = -1;

	@SuppressWarnings("unchecked")
	public ArrayImplementationOfQueue(int sizeofArray) {
		this.sizeofArray = sizeofArray;
		arrayQueue = (T[]) new Object[sizeofArray];
	}

	/*
	 * (non-Javadoc)
	 * @see Question2.Queue#isEmpty()
	 * To check whether queue is empty or not
	 * @return boolean - true if empty else false
	 */
	@Override
	public boolean isEmpty() {
		boolean value = false;
		if (front == rear) {
			value = true;
		}
		return value;
	}

	/*
	 * (non-Javadoc)
	 * @see Question2.Queue#enQueue(java.lang.Object) 
	 * enQueue - Is to insert the value into the queue
	 * @param item - of generic type
	 */
	@Override
	public void enQueue(T item) {
		try{
			if (isFull()) {
				System.out.println("Queue is Full ! Insertion not possible");
			} else {
				rear++;		//increase the size of rear
				arrayQueue[rear] = item;		//add item from rear
			}
		}catch(Exception e){
			e.getStackTrace();
		}		
	}

	/*
	 * (non-Javadoc)
	 * @see Question2.Queue#deQueue() 
	 * deQueue - To delete element from the queue
	 */
	@Override
	public void deQueue() {
		try{
			if (isEmpty()) {
				System.out.println("Queue is Empty ! Deletion not possible");
			} else {
				front++;
				if (front == rear) {
					front = rear = -1;
				}
			}
		}catch (Exception e) {
			e.getStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see Question2.Queue#isFull() 
	 * To check whether queue is full or not
	 * @return boolean value - true is full else false
	 */
	@Override
	public boolean isFull() {
		boolean value = false;
		try {
			if (rear == sizeofArray - 1) {
				value = true;
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

		return value;
	}

}
