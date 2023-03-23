package de.eberln.algodat.stack;

public class StackElement<T> {

	private T content;
	private StackElement<T> nextElement;
	
	public StackElement(T content) {
		
		this.content = content;
		
	}
	
	public T getContent() {
		return content;
	}
	
	public StackElement getNextElement() {
		return nextElement;
	}
	
	public void setNextElement(StackElement<T> element) {
		this.nextElement = element;
	}
	
}
