public class LinkList {

private Node first = null;

public void insertFirst(int data) {
    Node n = new Node(data);
    n.next = first;
    first = n;
}

public Node deleteFirst() {
    Node temp = first;
    first = first.next;
    return temp;
}

public void displayList() {
    Node current = first;
    while (current != null) {
        current.displayNode();
        current = current.next;
    }
}
public Node  topElement() {
	Node top=first;
	return top;
}

public boolean isEmpty() {
    return (first == null);
  }
}