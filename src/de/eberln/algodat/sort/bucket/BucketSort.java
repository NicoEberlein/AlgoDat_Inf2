package de.eberln.algodat.sort.bucket;

import java.util.Arrays;

public class BucketSort{

    int[] counter;
    int[] array;

    public BucketSort(int... elements) {
        array = elements;
    }

    public int[] sort() {
        int[] borders = getSpann(1);
        int min = borders[0];
        int max = borders[1];

        counter = new int[max-min+1];
        countNumbersAndFillCounterArray(min);
        fillOriginalArray(min);

        return array;
    }

    private void countNumbersAndFillCounterArray(int min) {

        for(int i = 0; i<array.length; i++) {
            counter[array[i]-min]++;
        }

    }

    private void fillOriginalArray(int min) {
        int arrayCounter = 0;

        for(int i = 0; i<counter.length; i++) {
            for(int j = 0; j<counter[i]; j++) {
                array[arrayCounter++] = i + min;
            }
        }
    }

    private int[] getSpann() {
        int minValue = array[0];
        int maxValue = array[0];

        for(int i : array) {
            if(i < minValue) minValue = i;
            if(i > maxValue) maxValue = i;
        }

        return new int[]{minValue, maxValue};
    }

    private int[] getSpann(int test) {

        int minValue = array[0];
        int maxValue = array[0];

        for(int i = 0; i<array.length; i+=2) {

            try{
                if(array[i] < array[i+1]) {
                    if(array[i] < minValue) minValue = array[i];
                    if(array[i+1] > maxValue) maxValue = array[i+1];
                }else if(array[i] > array[i+1]) {
                    if(array[i+1] < minValue) minValue = array[i+1];
                    if(array[i] > maxValue) maxValue = array[i];
                }else{
                    if(array[i] < minValue) minValue = array[i];
                    if(array[i] > maxValue) maxValue = array[i];
                }
            }catch(ArrayIndexOutOfBoundsException e) {
                if(array[array.length-1] < minValue) minValue = array[array.length-1];
                if(array[array.length-1] > maxValue) maxValue = array[array.length-1];
            }
        }

        return new int[]{minValue, maxValue};

    }

    public boolean isSorted() {

		if(array.length <= 1) {
			return true;
		}

		for(int i = 1; i<array.length; i++) {
			if(array[i-1] > array[i]) return false;
		}

		return true;
	}

}
