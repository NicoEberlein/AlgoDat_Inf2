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
	
	public StackElement<T> getNextElement() {
		return nextElement;
	}
	
	public void setNextElement(StackElement<T> element) {
		this.nextElement = element;
	}
	
	public void print() {
		System.out.println(content);
		if(nextElement != null) {
			nextElement.print();
		}
	}
	
}
