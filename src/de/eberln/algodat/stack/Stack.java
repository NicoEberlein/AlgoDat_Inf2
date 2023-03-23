package de.eberln.algodat.stack;

public class Stack<T> {

	private StackElement<T> topElement;
	
	public Stack() {
		
	}
	
	public void push(T content) {
		if(topElement == null) {
			topElement = new StackElement<T>(content);
		}else {
			StackElement<T> newElement = new StackElement<T>(content);
			newElement.setNextElement(topElement);
			topElement = newElement;
		}
	}
	
	public T peek() {
		return topElement.getContent();
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
	
	public void print() {
		topElement.print();
	}
	
}
