package ch.zbw.kuehne;

import zbw.simpleList.Element;
import zbw.stack.Stack;

public class Stack_ImplListe implements Stack {

	LinkedList lst = new LinkedList();
	
	@Override
	public boolean push(Element obj) {
		return lst.insertLast(obj);
	}

	@Override
	public Element pop() {
		Element e = lst.getLast();
		if(e == null) return null;
		lst.delete(e.getId());
		return e;
	}

	@Override
	public Element top() {
		return lst.getLast();
	}

	@Override
	public boolean empty() {
		return lst.empty();
	}

}
