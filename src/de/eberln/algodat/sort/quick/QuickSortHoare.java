package de.eberln.algodat.sort.quick;

import de.eberln.algodat.sort.Sortable;

public class QuickSortHoare<T extends Comparable<T>> extends Sortable<T> {
    
    public QuickSortHoare(T[] array) {
        super(array);
    }

    @Override
    public T[] sort() {
        quickSortHoare(0, array.length-1);
        return array;
    }

    public void quickSortHoare(int left, int right) {

        if(left < right) {

            int divide = partitionArray(left, right);

            quickSortHoare(left, divide);

            quickSortHoare(divide+1, right);

        }

    }

    private int partitionArray(int left, int right) {

        T pivot = array[left];

        int leftMarker = left-1;
        int rightMarker = right+1;

        while(true) {

            do{leftMarker++;} while(array[leftMarker].compareTo(pivot) < 0);
            do{rightMarker--;} while(array[rightMarker].compareTo(pivot) > 0);

            if(leftMarker < rightMarker) {
                swapAtIndex(leftMarker, rightMarker);
            }else{
                return rightMarker; 
            }


        }
    }
    
}
