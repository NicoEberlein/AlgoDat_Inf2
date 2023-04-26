package de.eberln.algodat.sort.quick;

import de.eberln.algodat.sort.Sortable;

public class Quicksort<T extends Comparable<T>> extends Sortable<T>{

	public Quicksort(T...elements) {
		super(elements);
	}

	@Override
	public T[] sort() {
		quickSortRec(array, array.length);
		return array;
	}
	
	private void quickSortRec(Comparable[] theArray, int used) {
		
		if(used < 2) return;
		
		Comparable[] lhs = new Comparable[used-1];
		int lhsFree = 0;
		
		Comparable[] pivots = new Comparable[used];
		int pivotFree = 0;
		
		Comparable[] rhs = new Comparable[used-1];
		int rhsFree = 0;
		
		Comparable pivot = getPivot(theArray, used);
		
		for(int i = 0; i<used; i++) {
			int comp = theArray[i].compareTo(pivot);
			if(comp == 0) {
				pivots[pivotFree++] = theArray[i];
			}else if(comp < 0) {
				lhs[lhsFree++] = theArray[i];
			}else {
				rhs[rhsFree++] = theArray[i];
			}
		}

		quickSortRec(lhs, lhsFree);
		quickSortRec(rhs, rhsFree);

		int index = 0;
		for(int i = 0; i < lhsFree; i++) {
			theArray[index++] = lhs[i];
		}
		for(int i = 0; i < pivotFree; i++) {
			theArray[index++] = pivots[i];
		}
		for(int i = 0; i < rhsFree; i++) {
			theArray[index++] = rhs[i];
		}
	}
	
	private Comparable getPivot(Comparable[] theArray, int used) {
		return theArray[used/2];
	}
	
}
