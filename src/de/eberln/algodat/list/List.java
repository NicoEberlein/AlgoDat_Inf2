package de.eberln.algodat.list;

import java.util.function.Function;

public abstract class List<T> {

	public abstract void insert(T element);
	
	public abstract void insert(T element, int pos);
	
	public abstract Boolean delete(Function<T, Boolean> func);
	
	public abstract String toString();
	
}
