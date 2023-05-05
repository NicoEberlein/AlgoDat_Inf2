package de.eberln.algodat.sort.quick;

import de.eberln.algodat.sort.Sortable;

public class QuickSortDutchNationalFlag<T extends Comparable<T>> extends Sortable<T> {

    public QuickSortDutchNationalFlag(T... elements) {
        super(elements);
    }

    public T[] sort() {

        sortDutchNationalFlag(0, array.length-1);

        return array;

    }

    private void sortDutchNationalFlag(int left, int right) {

        if(left < right) {

            int[] borders = partitionArray(left, right);

            sortDutchNationalFlag(left, borders[0]-1);
            sortDutchNationalFlag(borders[1]+1, right);

        }
    }

    private int[] partitionArray(int left, int right) {

        T pivot = array[left];

        int smaller = left;
        int equal = left+1;
        int larger = right;

        do {
            if(array[equal].compareTo(pivot) < 0) {
                swapAtIndex(smaller, equal);
                smaller++;
                equal++;
            }else if(array[equal].compareTo(pivot) > 0) {
                swapAtIndex(larger, equal);
                larger--;
            }else{
                equal++;
            }
        }while(larger >= equal);

        return new int[] {smaller, larger};
    }

}