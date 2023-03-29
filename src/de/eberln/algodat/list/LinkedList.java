package de.eberln.algodat.list;

import java.util.function.Function;

public class LinkedList<T> extends List<T>{
	
	private ListElement<T> firstElement;
	
	@Override
	public void insert(T element) {
		if(firstElement == null) {
			firstElement = new ListElement<T>(element);
		}else {
			ListElement<T> tmp = firstElement;
			firstElement = new ListElement<T>(element);
			firstElement.setNext(tmp);
		}
		
	}

	@Override
	public void insert(T element, int pos) {
		if(firstElement == null) {
			insert(element);
		}else {
			firstElement.insert(element, pos-1);
		}
	}

	@Override
	public Boolean delete(Function<T, Boolean> func) {
		if(firstElement == null) {
			return false;
		}else {
			Boolean returnBool = firstElement.delete(func);
			if(func.apply(firstElement.getContent())) {
				firstElement = firstElement.getNext();
				return true;
			}else {
				return returnBool;
			}
		}
	}

	@Override
	public String toString() {
		if(firstElement != null) return "( " + firstElement.print("") + ")";
		return "";
	}

	
	
}
