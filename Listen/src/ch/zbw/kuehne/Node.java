package ch.zbw.kuehne;

public class Node<T> {
	private T _item;
	private Node<T> _next;
	
	public Node(T item, Node<T> next) {
		_item = item;
		_next = next;
	}
	
	public T getItem() {
		return _item;
	}
	
	public Node<T> getNext() {
		return _next;
	}
	
	public void setNext(Node<T> next) {
		_next = next;
	}
}
