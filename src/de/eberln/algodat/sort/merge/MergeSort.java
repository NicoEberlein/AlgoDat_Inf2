package de.eberln.algodat.sort.merge;

import de.eberln.algodat.sort.Sortable;

public class MergeSort<T extends Comparable<T>> extends Sortable<T> {
    
    public MergeSort(T... elements) {
        super(elements);
    }

    public T[] sort() {
        array = (T[]) mergeSort(array);
        return array;
    }

    private Comparable[] mergeSort(Comparable[] arrayToSort) {

        Comparable[] left = null;
        Comparable[] right = null;

        if(arrayToSort.length > 1) {
            left = mergeSort(copyArray(arrayToSort, 0, arrayToSort.length/2-1));
            right = mergeSort(copyArray(arrayToSort, arrayToSort.length/2, arrayToSort.length-1));
        }else{
            return arrayToSort;
        }

        return combine(left, right);

    }

    private Comparable[] copyArray(Comparable[] originalArray, int from, int to) {
        Comparable[] newArray = new Comparable[to-from+1];
        for(int i = from; i<=to; i++) {
            newArray[i-from] = originalArray[i];
        } 
        return newArray;
    }

    private Comparable[] combine(Comparable[] left, Comparable[] right) {

        Comparable[] newArray = new Comparable[left.length + right.length];

        int leftPointer = 0;
        int rightPointer = 0;
        int newArrayCounter = 0;

        while(leftPointer < left.length && rightPointer < right.length) {
            if(left[leftPointer].compareTo(right[rightPointer]) <= 0) {
                newArray[newArrayCounter] = left[leftPointer];
                leftPointer++;
                newArrayCounter++;
            }else{
                newArray[newArrayCounter] = right[rightPointer];
                rightPointer++;
                newArrayCounter++;
            }
        }

        if(leftPointer < left.length) {
            for(int i = leftPointer; i< left.length; i++) {
                newArray[newArrayCounter] = left[i];
                newArrayCounter++;
            }
        }
        if(rightPointer < right.length) {
            for(int i = rightPointer; i< right.length; i++) {
                newArray[newArrayCounter] = right[i];
                newArrayCounter++;
            }
        }
        return newArray;
    }

}
