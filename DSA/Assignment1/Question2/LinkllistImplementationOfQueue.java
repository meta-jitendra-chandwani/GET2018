package Question2;

/*
 *LinkllistImplementationOfQueue - is a implementation of Queue using linklist
 */
public class LinkllistImplementationOfQueue<T> {
	class QNode {
		T key;
		QNode next;

		public QNode(T item) {
			this.key = item;
			this.next = null;
		}
	}

	QNode front, rear;

	public LinkllistImplementationOfQueue() {
		this.front = this.rear = null;
	}

	/*
	 * To check whether queue is empty or not
	 * @return boolean - true if empty else false
	 */
	public boolean isEmpty() {
		boolean value = false;
		try{
			if (this.front == null) {
				value = true;
			}
		}catch(Exception e){
			e.getStackTrace();
		}		
		return value;
	}

	/*
	 * enQueue - Is to insert the value into the queue
	 * @param item - of generic type
	 */
	public void enQueue(T item) {
		try{
			QNode node = new QNode(item);

			if (this.rear == null) {
				this.front = this.rear = node;
			}

			this.rear.next = node;
			this.rear = node;
		}catch(Exception e){
			e.getStackTrace();
		}
		
	}

	/*
	 * deQueue - To delete element from the queue
	 * @return T - generic type value
	 */
	@SuppressWarnings("unchecked")
	public T deQueue() {
		T value = null;
		if (isEmpty()) {
			System.out.println("Queue is Empty!");
		}
		else{
			QNode temp = this.front;
			this.front = this.front.next;

			if (this.front == null) {
				this.rear = null;
			}
			value = (T) temp;
		}
		return value;
	}

}
