package de.eberln.algodat.stack;

public class LinkedListStack<T> implements Stack<T>{

	private StackElement<T> topElement;
	
	public LinkedListStack() {
		
	}
	
	public T push(T content) {
		if(topElement == null) {
			topElement = new StackElement<T>(content);
		}else {
			StackElement<T> newElement = new StackElement<T>(content);
			newElement.setNextElement(topElement);
			topElement = newElement;
		}
		
		return content;
	}
	
	public T peek() {
		if(topElement != null) return topElement.getContent();
		return null;
	}
	
	public T pop() {
		if(topElement == null) {
			return null;
		}else {
			T tmp = topElement.getContent();
			topElement = topElement.getNextElement();
			return tmp;
		}
	}

	public boolean isEmpty() {
		return (topElement == null);
	}
	
	public void print() {
		if(topElement != null) topElement.print();
	}
	
}
