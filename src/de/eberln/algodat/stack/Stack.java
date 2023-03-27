package de.eberln.algodat.stack;

public interface Stack<T> {

	public T push(T content);
	
	public T pop();
	
	public T peek();
	
	public boolean isEmpty();
	
	public void print();
}
