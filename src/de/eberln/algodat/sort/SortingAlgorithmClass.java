package de.eberln.algodat.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SortingAlgorithmClass {
    
    public enum AlgorithmType {
        ITERATIVE,
        RECURSIVE
    }

    public enum SequenceAlgorithm {
        HIBBARD,
        KNUTH,
        PRATT
    }

    private int[] array;

    public SortingAlgorithmClass() {
        this(420, true);
    }

    public SortingAlgorithmClass(int[] otherArray) {

        array = new int[otherArray.length];

        for(int i = 0; i<otherArray.length; i++) {
            array[i] = otherArray[i];
        }

    }

    public SortingAlgorithmClass(int n, boolean shuffled) {

        Random dice = null;
        if(shuffled) dice = new Random();

        array = new int[n];
        for(int i = 1; i<=n; i++) {
            if(shuffled) {
                array[i-1] = dice.nextInt(-1000000, 1000001);
            }else{
                array[i-1] = i;
            }
        }

    }

    public boolean isSorted() {
        
        for(int i = 1; i<array.length; i++) {
            if(array[i-1] > array[i]) return false;
        }

        return true;
    }

    public void shuffle() {
        shuffle(new Random().nextInt(1000));
    }

    public void shuffle(int seed) {

        Random dice = new Random(seed);

        for(int i = 0; i<array.length; i++) {
            swapAtIndex(i, dice.nextInt(0, array.length));
        }

    }

    private void swapAtIndex(int a, int b) {

        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;

    }

    public String toString() {

        String res = "[  ";

        for(int i = 0; i<array.length; i++) {
            res += "[" + array[i] + "]";
        }

        return res += "  ]" + (isSorted() ? " is sorted" : " is not sorted") + " and has length " + array.length;

    }

    // ================================================ Sorting ================================================ //

    public void randomSort() {

        int iterationCounter = 0;

        while(!isSorted()) {
            shuffle();
            iterationCounter++;

            if(iterationCounter % 10000 == 0) {
                System.out.println("RandomSort still alive after " + iterationCounter + " iterations.");
            }
        }

    }

    public void dropSort() {

        int[] result = new int[array.length];
        result[0] = array[0];
        int currentResultIndex = 0;

        for(int i = 1; i<array.length; i++) {
            if(result[currentResultIndex] < array[i]) result[++currentResultIndex] = array[i];
        }

        int[] smallerResult = new int[currentResultIndex+1];

        for(int i = 0; i<currentResultIndex+1; i++) {
            smallerResult[i] = result[i];
        }

        array = smallerResult;

    }

    public void bubbleSort() {

        int end = array.length-1;

        while(end >= 1) {

            for(int i = 0; i<end; i++) {

                if(array[i] > array[i+1]) swapAtIndex(i, i+1);
    
            }

            end--;
        }

    }

    public void selectionSort() {
        selectionSort(AlgorithmType.RECURSIVE);
    }

    public void selectionSort(AlgorithmType algorithmType) {
        if(algorithmType == AlgorithmType.RECURSIVE) {
            selectionSortRecursive(array.length);
        }else{
            selectionSortIterative();
        }
    }

    private void selectionSortIterative() {

        int border = array.length;

        while(border > 0) {
            int biggestIndexInN = 0;
            for(int i = 0; i<border; i++) {
                if(array[biggestIndexInN] < array[i]) biggestIndexInN = i;
            }
            swapAtIndex(biggestIndexInN, border-1);
            border--;
        }

    }

    private void selectionSortRecursive(int border) {

        if(border == 0) {
            return;
        }

        int biggestIndexInN = 0;
        for(int i = 0; i<border; i++) {
            if(array[biggestIndexInN] < array[i]) biggestIndexInN = i;
        }

        swapAtIndex(biggestIndexInN, border-1);

        selectionSortRecursive(border-1);

    }

    public void insertionSort() {
        insertionSortIterative(1);
    }

    private void insertionSortIterative(int jump) {

        for(int i = jump; i<array.length; i++) {

            // Beachte: Zusätzlicher Schritt zu "normaler" InsertionSort ohne Schrittweite
            if(array[i] < array[i-jump]) swapAtIndex(i, i-jump);

            for(int j = i; j>0; j--) {
                if(array[j] < array[j-1]) swapAtIndex(j, j-1);
            }

        }

    }

    public void shellSort() {
        shellSort(SequenceAlgorithm.PRATT);
    }

    public void shellSort(SequenceAlgorithm sequenceAlgorithm) {

        List<Integer> sequence = switch(sequenceAlgorithm) {

            case HIBBARD -> {
                List<Integer> innerSequence = new ArrayList<>();
                int i = 1;
                while(Math.pow(2, i)-1 < array.length) {
                    innerSequence.add((int) Math.pow(2, i)-1);
                    i++;
                }
                yield innerSequence.stream().sorted((i1, i2) -> Integer.compare(i2, i1)).collect(Collectors.toList());
            }

            case KNUTH -> {
                List<Integer> innerSequence = new ArrayList<>();
                int i = 1;
                while((Math.pow(3, i)-1)/2 < array.length) {
                    innerSequence.add((int) ((Math.pow(3, i)-1)/2));
                    i++;
                }
                yield innerSequence.stream().sorted((i1, i2) -> Integer.compare(i2, i1)).collect(Collectors.toList());
            }

            case PRATT -> {

                List<Integer> tmpList = new ArrayList<>();

                int pow3 = 0;

                int innerSequenceIndex = 0;

                while(Math.pow(3, pow3) < array.length) {

                    for(int pow2 = 0; pow2<=pow3; pow2++) {
        
                        if(Math.pow(2, pow2)*Math.pow(3, pow3-pow2) > array.length) break;
        
                        tmpList.add(innerSequenceIndex++, (int) (Math.pow(2, pow2)*Math.pow(3, pow3-pow2)));
                    }
                    pow3++;
                }

                yield tmpList.stream().sorted((i1, i2) -> Integer.compare(i2, i1)).collect(Collectors.toList());
            }
        };

        for(int i : sequence) {
            insertionSortIterative(i);
        }
    }

    public void mergeSort() {
        int[] tmpMemory = new int[array.length];
        mergeSortRecursive(0, array.length, tmpMemory);
        array = tmpMemory;
    }

    private void mergeSortRecursive(int start, int end, int[] destMemory) {

        if(end-start > 1) {
         
            int border = end - (end - start) / 2;

            mergeSortRecursive(start, border, destMemory);
            mergeSortRecursive(border, end, destMemory);

            combine(start, end, destMemory);

        }

    }

    private void combine(int start, int end, int[] destMemory) {

        int border = end - (end - start) / 2;
        int idx1 = start;
        int idx2 = border;

        int destIndex = start;

        while(idx1 < border && idx2 < end) {

            if(array[idx1] < array[idx2]) {
                destMemory[destIndex++] = array[idx1++];
            }else{
                destMemory[destIndex++] = array[idx2++];
            }

        }

        // Einer der beiden Stapel ist "leer"

        if(idx1 < border) {

            // Auf Stapel 1 ist noch was
        
            for(int i = idx1; i<border; i++) {
                destMemory[destIndex++] = array[i];
            }

        }else if(idx2 < end) {

            // Auf Stapel 2 ist noch was

            for(int i = idx2; i<end; i++) {
                destMemory[destIndex++] = array[i];
            }
        }

        // Wichtig: Neue "Erkenntnis" über die sortierte Reihenfolge der kombinierten Teilarrays immer auch in Ursprungsarray schreiben

        for(int i = start; i<end; i++) {
            array[i] = destMemory[i];
        }

    }
}
