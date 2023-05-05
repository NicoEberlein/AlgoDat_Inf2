package de.eberln.algodat.sort.insertion;

import de.eberln.algodat.sort.Sortable;

public class InsertionSort<T extends Comparable<T>> extends Sortable<T>{

	public InsertionSort(T... elements) {
		super(elements);
	}
	
	@Override
	public T[] sort() {
				
		for(int i = 1; i<array.length; i++) {
			
			for(int j = i;j>0;j--) {
				
				if(array[j].compareTo(array[j-1]) < 0) {
				
					swapAtIndex(i, j);
					
				}else {
					break;
				}
			}
		}
		
		return array;
		
	}
	
}
