package Question2;

public class QNode<T> {
	T key;
	QNode<T> next;

	public QNode(T item) {
		this.key = item;
		this.next = null;
	}
}
