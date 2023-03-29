package de.eberln.algodat.list;

import java.util.function.Function;

public class ListElement<T> {

	private T content;
	
	private ListElement<T> next;
	
	public ListElement(T content) {
		this.content = content;
		next = null;
	}
	
	public Boolean delete(Function<T, Boolean> func) {
		if(next == null) {
			return false;
		}else {
			Boolean returnBool = next.delete(func);
			if(func.apply(next.getContent())) {
				next = next.getNext();
				return true;
			}
			return returnBool;
		}
		
	}
	
	public String print(String a) {
		a += content + " ";
		if(next != null) return next.print(a);
		return a;
	}
	
	public void insert(T content, int pos) {
		if(pos == 0) {
			ListElement<T> insert = new ListElement<>(content);
			insert.setNext(getNext());
			next = insert;
		}else {
			if(next != null) {
				next.insert(content, pos-1);
			}else {
				next = new ListElement<>(content);
			}
		}
		
		}

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}

	public ListElement getNext() {
		return next;
	}

	public void setNext(ListElement next) {
		this.next = next;
	}
	
	
	
	
}
