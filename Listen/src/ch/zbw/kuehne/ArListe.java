package ch.zbw.kuehne;

import zbw.simpleList.*;


public class ArListe implements Liste {

	private Element[] _elements;
	private int _indexOfLastElement;
	
	static int MAX_ITEMS = 20;
	
	public ArListe() {
		_elements = new Element[10];
		_indexOfLastElement = -1;
	}
	
	private ArListe(Element[] arr) {
		_elements = arr;
		_indexOfLastElement = arr.length - 1;
	}
	
	private boolean ensureArrayCapacity() {
		if(_elements.length == (_indexOfLastElement - 1)) {
			
			int newLength = _elements.length * 2;
			
			if(newLength > MAX_ITEMS) return false;
			
			Element[] newArray = new Element[newLength];
			copyTo(_elements, newArray, 0, 0, 0);
		}
		
		return true;
	}
	
	/*
	 * source: array das kopiert werden soll
	 * destination: array in das die daten hineinkopiert werden sollen
	 * destinationStart: offset, ab dem die Daten im destination array angelegt werden sollen
	 * sourceStart: offset, ab dem die Daten aus dem source array ausgelesen werden sollen
	 * sourceLength: anzahl elemente die aus source gelesen werden sollen
	 * */
	private void copyTo(Element[] source, Element[] destination, int destinationStart, int sourceStart, int sourceLength) {
		for(int i = 0; (i+sourceStart) < source.length && 
				       (i + destinationStart) < destination.length; i++) {
			destination[i + destinationStart] = source[i + sourceStart];
		}
	}
	
	@Override
	public boolean insertFirst(Element x) {

		if(ensureArrayCapacity()) {
		
			Element[] clone = new Element[_elements.length + 1];
			
			copyTo(_elements, clone, 1, 0, 0);
			_elements = clone;
			_elements[0] = x;
			_indexOfLastElement++;
			
			// TODO Auto-generated method stub
			return true;
		}
		return false;
	}

	@Override
	public boolean insertLast(Element x) {
		if(ensureArrayCapacity()) {
			_indexOfLastElement++;
			_elements[_indexOfLastElement] = x;
			
			return true;
		}
		return false;
	}

	@Override
	public boolean empty() {
		return _indexOfLastElement == -1;
	}

	@Override
	public Element getFirst() {
		if(_indexOfLastElement == -1)
			return null;
		return _elements[0];
	}

	@Override
	public Element getLast() {
		if(_indexOfLastElement == -1)
			return null;
		return _elements[_indexOfLastElement];
	}

	@Override
	public Element search(int id) {
		// TODO Auto-generated method stub
		
		for(Element e : _elements) {
			if(e == null) return null;
			if(e.getId() == id) return e;
		}
		
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i <= _indexOfLastElement; i++) {
			if(_elements[i].getId() == id) {
				copyTo(_elements, _elements, i, i + 1, 0);

				_indexOfLastElement--;
				return true;
			}
		}
		return false;
	}

	@Override
	public void show() {
		for(Element e : _elements) {
			if(e == null) return;
			e.show();	
		}
	}

	private int indexOf(Element e) {
		for(int i = 0; i < _elements.length; i++) {
			if(_elements[i] == null) return -1;
			if(_elements[i] == e) return i;
		}
		return -1;
	}
	
	@Override
	public boolean change(int id1, int id2) {
		// TODO Auto-generated method stub
		
		Element e1 = search(id1);
		Element e2 = search(id2);
		
		
		if(e1 == null || e2 == null)
			return false;
		

		int idx1 = indexOf(e1);
		int idx2 = indexOf(e2);
		
		_elements[idx1] = e2;
		_elements[idx2] = e1;
		
		return true;
	}

	@Override
	public ArListe sublist(int pos1, int pos2) {
		
		int len = Math.abs(pos2 - pos1) + 1;
		
		Element[] arr = new Element[len];
		
		copyTo(_elements, arr, 0, pos1, len);
		
		return new ArListe(arr);
	}

	/**
	 * Sucht alle Elemente mit dem Schlüssel >= key1 und <= key2; null wenn nichts gefunden
	 */
	@Override
	public ArListe searchElements(int key1, int key2) {
		
		ArListe lst = new ArListe();
		
		for(int i = key1; i <= key2;i++) {
			Element e = search(i);
			if(e != null)
				lst.insertLast(e);
		}
		
		if(lst.empty())
			return null;
		
		return lst;
	}

	@Override
	public void sortieren() {
		// TODO Auto-generated method stub
		
	}

}
