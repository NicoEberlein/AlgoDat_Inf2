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
			//System.out.println("Rufe " + sequenceAlgorithm.getClass().getSimpleName() + " mit " + i);
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
			
			int smallerIndex = i - jump;

			if(array[smallerIndex].compareTo(array[i]) > 0) {
				
				swapAtIndex(smallerIndex, i);

				while(smallerIndex > 1 && array[smallerIndex].compareTo(array[smallerIndex-1]) < 0) {
					swapAtIndex(smallerIndex, smallerIndex-1);
					smallerIndex--;
				}
	
			}
			
		}
	}
	
}
