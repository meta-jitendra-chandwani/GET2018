package Assignment2.Session2;


/**
 * Implementation of Circular Queue using Generics
 */
class CircularQueue<T> {

    private int currentSize; //Current Circular Queue Size
    private T[] circularQueueElements;
    private int maxSize; //Circular Queue maximum size

    private int rear;//rear position of Circular queue(new element enqueued at rear).
    private int front; //front position of Circular queue(element will be dequeued from front).      

    @SuppressWarnings("unchecked")
	public CircularQueue(int maxSize) {
        this.maxSize = maxSize;
        circularQueueElements = (T[]) new Object[this.maxSize];
        currentSize = 0;
        front = -1;
        rear = -1;
    }

    /**
     * Enqueue elements to rear.
     * @param item - Item to be added or enqueue
     */
    public void enqueue(T item) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("Circular Queue is full. Element cannot be added");
        }
        else {
            rear = (rear + 1) % maxSize;
            circularQueueElements[rear] = item;
            currentSize++;
            
            if (front == -1) {
				front = rear;
			}
        }
    }

    /**
     * Dequeue element from Front.
     * @return deQueueElement - element which is deleted
     */
    public T dequeue() throws QueueEmptyException {
        T deQueuedElement;
        if (isEmpty()) {
            throw new QueueEmptyException("Circular Queue is empty. Element cannot be retrieved");
        }
        else {
            deQueuedElement = circularQueueElements[front];
            circularQueueElements[front] = null;
            front = (front + 1) % maxSize;
            currentSize--;
        }
        return deQueuedElement;
    }

    /**
     * Check if queue is full.
     */
    public boolean isFull() {
        return (currentSize == maxSize);
    }

    /**
     * Check if Queue is empty.
     */
    public boolean isEmpty() {
        return (currentSize == 0);
    }
}