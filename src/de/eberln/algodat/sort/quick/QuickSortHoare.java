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

        while(true) {

            while(array[left].compareTo(pivot) < 0) {
                if(left == right) return left;
                left++;
            }
            while(array[right].compareTo(pivot) > 0) {
                if(left == right) return left;
                right--;
            }

            if(left < right && array[left].compareTo(array[right]) != 0) {

                T tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;    

            }else{
                return left;
            }

        }

    }


    

    
}
