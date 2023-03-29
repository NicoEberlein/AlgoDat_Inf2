package de.eberln.algodat.queue;

public class ArrayQueue<T> implements Queue<T>{

	private T[] queue;

	private int start;
	private int end;
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(int initialSize) {
		
		queue = (T[]) new Object[initialSize];
		start = 0;
		end = 0;
		
	}
	
	public ArrayQueue() {
		this(20);
	}

	@Override
	public T put(T content) {
		
		queue[end] = content;
		end++;
		
		if(end == queue.length) {
			end = 0;
		}
		
		if(end == start) {
			grow();
		}
		
		return content;
	}

	@Override
	public T get() {
		
		if(start == end) {
			return null;
		}
		
		if(start == queue.length) {
			start = 0;
		}
		
		T tmp = queue[start];
		start++;
		
		return tmp;
	}
	
	private void grow() {
		
		System.out.println("Growing");
		
		T[] newArray = (T[]) new Object[queue.length * 2];
		
		int oldIndex = start;
		int newIndex = 0;
		
		do {
			
			newArray[newIndex] = queue[oldIndex % queue.length];
			oldIndex++;
			newIndex++;
			
		}while(oldIndex % queue.length != start);
		
		queue = newArray;
		start = 0;
		end = newIndex;
	}
	
	
	
}
