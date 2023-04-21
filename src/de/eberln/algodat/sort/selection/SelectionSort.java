package de.eberln.algodat.sort.selection;

import de.eberln.algodat.sort.Sortable;

public class SelectionSort<T extends Comparable<T>> extends Sortable<T>{

	public SelectionSort(T... elements) {
		super(elements);
	}
	
	@Override
	public T[] sort() {
		
		int endOfArray = array.length;
		
		while(endOfArray > 1) {
		
			T max = array[0];
			int maxIndex = 0;
			
			for(int i = 1; i<endOfArray; i++) {
				if(array[i].compareTo(max) > 0) {
					max = array[i];
					maxIndex = i;
				}
			}
			
			T tmp = array[endOfArray-1];
			array[endOfArray-1] = max;
			array[maxIndex] = tmp;
			endOfArray--;
			
		}
		
		return array;
		
	}
	
	
}
