package ch.zbw.kuehne;

public class Node<T> {
	private T _item;
	private Node<T> _next;
	private Node<T> _last;
	
	public Node(T item, Node<T> next) {
		_item = item;
		_next = next;
	}
	
	public Node(T item, Node<T> next, Node<T> last) {
		_item = item;
		_next = next;
		_last = last;
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
	
	public Node<T> getLast() {
		return _last;
	}
	
	public void setLast(Node<T> last) {
		_last = last;
	}
}
