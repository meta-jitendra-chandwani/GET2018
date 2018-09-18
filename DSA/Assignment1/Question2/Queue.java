package Question2;

/*
 * interface of Queue functionality
 */
public interface Queue<T> {
	public boolean isEmpty();
	public void enQueue (T item);
	public void deQueue ();
	public boolean isFull();
}
