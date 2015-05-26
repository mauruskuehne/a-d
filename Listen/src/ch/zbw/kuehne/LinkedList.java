package ch.zbw.kuehne;

import zbw.simpleList.*;

/* ACHTUNG: Interface Liste angepasst:
 * Damit das Interface ohne Veränderung für LinkedList und ArrayList gilt,
 * müssen die nachfolgenden Methoden nicht die spezifische Klasse, sondern nur
 * das Interface zurückgeben:
 * 
 * bisher:
 * public ArListe sublist(int pos1, int pos2);
 * public ArListe searchElements(int key1, int key2);
 * 
 * Neu:
 * public Liste sublist(int pos1, int pos2);
 * public Liste searchElements(int key1, int key2);
 * */


public class LinkedList implements Liste {

	Node<Element> _head;
	
	
	@Override
	public boolean insertFirst(Element x) {
		Node<Element> newNode = new Node<Element>(x, null);	
		Node<Element> tail = _head;
		_head = newNode;
		_head.setNext(tail);
		
		return true;
	}

	@Override
	public boolean insertLast(Element x) {
		
		if(_head == null) {
			_head = new Node<Element>(x, null);
		} else {
			Node<Element> element = _head;
			while(element != null) {
				if(element.getNext() == null) {
					Node<Element> newNode = new Node<Element>(x, null);
					element.setNext(newNode);
					break;
				}
				element = element.getNext();
			}
		}
		
		return true;
	}

	@Override
	public boolean empty() {
		return _head == null;
	}

	@Override
	public Element getFirst() {
		return _head == null ? null : _head.getItem();
	}

	@Override
	public Element getLast() {
		Node<Element> element = _head;
		while(element != null) {
			if(element.getNext() == null) {
				return element.getItem();
			}
			element = element.getNext();
		}
		
		return null;
	}

	@Override
	public Element search(int id) {
		
		Node<Element> element = _head;
		while(element != null) {
			if(element.getItem().getId() == id) {
				return element.getItem();
			}
			element = element.getNext();
		}
		
		return null;
	}

	@Override
	public boolean delete(int id) {
		Node<Element> lastElement = null;
		Node<Element> element = _head;
		while(element != null) {
			if(element.getItem().getId() == id) {
				Node<Element> nextNode = element.getNext();
				if(lastElement != null)
					lastElement.setNext(nextNode);
				else
					_head = nextNode;
				return true;
			}
			lastElement = element;
			element = element.getNext();
		}
		
		return false;
	}

	@Override
	public void show() {
		Node<Element> element = _head;
		while(element != null) {
			element.getItem().show();
			element = element.getNext();
		}
	}

	@Override
	public boolean change(int id1, int id2) {
		
		Node<Element> nodeBeforeNode1 = null;
		Node<Element> nodeBeforeNode2 = null;
		Node<Element> node1 = null;
		Node<Element> node2 = null;
		
		
		Node<Element> lastElement = null;
		Node<Element> element = _head;
		while(element != null && (node1 == null || node2 == null)) {
			if(element.getItem().getId() == id1) {
				node1 = element;
				nodeBeforeNode1 = lastElement;
			}
			
			if(element.getItem().getId() == id2) {
				node2 = element;
				nodeBeforeNode2 = lastElement;
			}
				
				
			lastElement = element;
			element = element.getNext();
		}
		
		if(node1 == null || node2 == null)
			return false;
		
		Node<Element> node1Tail = node1.getNext();
		
		if(node1Tail == node2)
			node1Tail = node1Tail.getNext();
		
		Node<Element> node2Tail = node2.getNext();
		

		if(node2Tail == node1)
			node2Tail = node2Tail.getNext();
		
		node1.setNext(node2Tail);
		node2.setNext(node1Tail);
		
		if(nodeBeforeNode1!= null)
			nodeBeforeNode1.setNext(node2);
		else
			_head = node2;
		
		if(nodeBeforeNode2!= null)
			nodeBeforeNode2.setNext(node1);
		else
			_head = node1;
			
		return true;
	}

	@Override
	public LinkedList sublist(int pos1, int pos2) {
		
		if(pos1 < 0) return null;
		
		LinkedList l = new LinkedList();
		
		int idx = 0;
		Node<Element> element = _head;
		while(element != null) {
			
			//if(idx > pos2) return null;
			
			if(idx >= pos1 && idx <= pos2)
				l.insertLast(element.getItem());
			element = element.getNext();
			idx++;
		}
		return l;
	}

	/**
	 * Sucht alle Elemente mit dem Schl¸ssel >= key1 und <= key2; null wenn nichts gefunden
	 */
	@Override
	public LinkedList searchElements(int key1, int key2) {
		
		LinkedList lst = new LinkedList();
		
		Node<Element> element = _head;
		while(element != null) {
			int id =element.getItem().getId();
			if(id >= key1 && id <= key2) {
				lst.insertFirst(element.getItem());
			}
			element = element.getNext();
		}
		
		if(lst.empty())
			return null;
		
		return lst;
	}

	@Override
	public void sortieren() {
		// TODO Auto-generated method stub
		
	}
	
	public Node<Element> drehen() {
		Node<Element> firstNode = _head;
		if(firstNode == null) return null;
		
		Node<Element> lastElement = null;
		Node<Element> tmp = firstNode;
		
		Node<Element> newFirst = firstNode;
		
		while(tmp != null) {
			lastElement = tmp;
			tmp = tmp.getNext();
		}
		
		tmp = lastElement;
		
		while(newFirst != lastElement) {
			Node<Element> tmp2 = newFirst.getNext();
			
			tmp.setNext(newFirst);
			newFirst.setNext(null);
			tmp = newFirst;
			newFirst = tmp2;
		}
		
		return lastElement;
	}

}
