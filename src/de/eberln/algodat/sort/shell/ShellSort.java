package de.eberln.algodat.sort.shell;

import de.eberln.algodat.sort.Sortable;

public class ShellSort<T extends Comparable<T>> extends Sortable<T> {
	
	private SequenceAlgorithm sequenceAlgorithm;
	
	public ShellSort(SequenceAlgorithm sequenceAlgorithm, T... elements) {
		super(elements);
		this.sequenceAlgorithm = sequenceAlgorithm;
	}
	
	public T[] sort() {
		
		for(int i : sequenceAlgorithm.getSequence(array.length)) {
			insertionSort(i);
		}
		
		return array;
		
	}
	
	@Override
	public String getType() {
		return "[ Sort: " + getClass().getSimpleName() + "; Sequence: " + sequenceAlgorithm.getClass().getSimpleName() + " ]"; 
	}
	
	private void insertionSort(int jump) {
		
		for(int i = jump; i<array.length; i++) {
			
			if(array[i-jump].compareTo(array[i]) > 0) {
				
				T tmp = array[i-jump];
				array[i-jump] = array[i];
				array[i] = tmp;
				
			}
			
		}
	}
	
	private void insertionSortNew(int jump) {
		
		for(int i = jump; i<array.length; i++) {
			
			int j = i;
			T currentValue = array[i];
			while((j>=jump) && (array[j-jump].compareTo(currentValue) > 0)) {
				array[j] = array[j-jump];
				j -= jump;
			}
			array[j] = currentValue;
			
		}
	}
	
}
