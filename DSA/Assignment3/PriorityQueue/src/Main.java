public class Main<T> implements PriorityQueueInterface<T> {

	private Object arrayQueue[];
	private int sizeofArray = 0;
	private int front = -1, rear = -1;

	@SuppressWarnings("unchecked")
	public Main(int sizeofArray) {
		this.sizeofArray = sizeofArray;
		arrayQueue = (Object[]) new Object[sizeofArray];
	}

	@Override
	public void insert(PriorityQueue object) {
		try {
			if (isFull()) {
				System.out.println("Queue is Full ! Insertion not possible");
			} else {
				rear++; // increase the size of rear
				arrayQueue[rear] =  object; // add item from rear
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	@Override
	public int getPriority() {
		
		
		return 0;
	}

	@Override
	public void remove(PriorityQueue object) {
		try{
			if (isEmpty()) {
				System.out.println("Queue is Empty ! Deletion not possible");
			} else {
				for(int i = 0; i < arrayQueue.length; i++){
					Object value=arrayQueue[i];
					if(value.Priority>max){
						max=value.Priority
					}
				}
				
				front++;
				if (front == rear) {
					front = rear = -1;
				}
			}
		}catch (Exception e) {
			e.getStackTrace();
		}

	}

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
	
	public boolean isEmpty() {
		boolean value = false;
		if (front == rear) {
			value = true;
		}
		return value;
	}


}
