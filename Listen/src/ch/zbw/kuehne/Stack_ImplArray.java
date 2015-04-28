package ch.zbw.kuehne;

import zbw.simpleList.Element;
import zbw.stack.Stack;

public class Stack_ImplArray implements Stack {

	static int SIZE = 10;
	
	Element[] _array = new Element[SIZE];
	
	int _head = 0;
	
	@Override
	public boolean push(Element obj) {
		_array[_head++] = obj;
		
		return true;
	}

	@Override
	public Element pop() {
		if(_head == 0) return null;
		return _array[--_head];
	}

	@Override
	public Element top() {
		if(_head == 0) return null;
		return _array[_head - 1];
	}

	@Override
	public boolean empty() {
		return _head == 0;
	}

}
