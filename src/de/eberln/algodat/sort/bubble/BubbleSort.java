package de.eberln.algodat.sort.bubble;

import de.eberln.algodat.sort.Sortable;

public class BubbleSort<T extends Comparable<T>> extends Sortable<T> {
	
	public BubbleSort(T... elements) {
		super(elements);
	}
	
	public T[] sort() {	
		
		for(int j = array.length-1; j>0; j--) {
		
			for(int i = 0; i<j; i++) {
				
				if(array[i].compareTo(array[i+1]) > 0) {
					
					swapAtIndex(i, i+1);
					
				}
				
			}
			
		}
		
		return array;
		
	}
	
}
