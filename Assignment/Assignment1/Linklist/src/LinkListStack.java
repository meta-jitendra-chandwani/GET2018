public class LinkListStack {

LinkList li = new LinkList();

public void push(int data) {
    li.insertFirst(data);
}

public void pop() {
    while(!li.isEmpty()){
    li.deleteFirst();
    }
}
public void  top() {
	li.topElement();
}

public void displayStack() {
    System.out.println("  ");
    li.displayList();
  }
public boolean  isEmpty() {
	return li.isEmpty();
	
}
}