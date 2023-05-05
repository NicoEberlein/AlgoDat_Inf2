package de.eberln.algodat.sort.merge;

import de.eberln.algodat.sort.Sortable;

public class MergeSortInplace<T extends Comparable<T>> extends Sortable<T> {
    
    private Comparable[] tmpMemory;

    public MergeSortInplace(T... elements) {
        super(elements);
        tmpMemory = new Comparable[array.length];
    }

    public T[] sort() {
        mergeSortRec(0, array.length-1);
        return array;
    }

    private void mergeSortRec(int left, int right) {

        int calculatedLenght = right - left +1;

        if(calculatedLenght > 1) {
            mergeSortRec(left, left+calculatedLenght/2-1);
            mergeSortRec(left+calculatedLenght/2, right);
        }

        combine(left, right);

    }

    private void combine(int left, int right) {

        int calculatedLenght = right - left + 1;

        if(calculatedLenght == 1) {
            tmpMemory[left] = array[left];
            return;
        }

        int leftPointer = left;
        int rightPointer = left+calculatedLenght/2;

        int tmpIndex = left;

        while(leftPointer <= left+calculatedLenght/2-1 && rightPointer <= right) {
            if(array[leftPointer].compareTo(array[rightPointer]) <= 0) {
                tmpMemory[tmpIndex++] = array[leftPointer++];
            }else{
                tmpMemory[tmpIndex++] = array[rightPointer++];
            }
        }
        if(leftPointer <= left+calculatedLenght/2-1) {
            for(int i = leftPointer; i<= left+calculatedLenght/2-1; i++) {
                tmpMemory[tmpIndex++] = array[i];
            }
        }
        if(rightPointer <= right) {
            for(int i = rightPointer; i<= right; i++) {
                tmpMemory[tmpIndex++] = array[i];
            }
        }

        for(int i = left; i<=right; i++) {
            array[i] = (T) tmpMemory[i];
        }
    }

}