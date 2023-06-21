package de.eberln.algodat.sort.heap;

import de.eberln.algodat.sort.Sortable;

public class HeapSort<T extends Comparable<T>> extends Sortable<T> {
    
    public HeapSort(T... elements) {
        super(elements);
    }

    private void createHeap() {

        int n = array.length-1;
        for(int i = n/2; i>=0; i--) {
            sinke(i, n);
        }

    }

    private int leftNode(int node) {
        return node * 2 + 1;
    }

    private int rightNode(int node) {
        return node * 2 + 2;
    }

    private int parentNode(int node) {
        return (node-1) / 2;
    }

    private boolean hasChild(int nodeId, int lastElement) {
        return (leftNode(nodeId) <= lastElement || rightNode(nodeId) <= lastElement);
    }

    private int findIndexOfGreatestChild(int nodeId, int lastElement) {
        
        if(rightNode(nodeId) > lastElement) {
            return leftNode(nodeId);
        }else{
            if(array[rightNode(nodeId)].compareTo(array[leftNode(nodeId)]) >= 0) {
                return rightNode(nodeId);
            }else{
                return leftNode(nodeId);
            }
        }
    }

    private void sinke(int nodeId, int lastElement) {

        while(hasChild(nodeId, lastElement)) {
            int indexOfGreatestChild = findIndexOfGreatestChild(nodeId, lastElement);
            if(array[nodeId].compareTo(array[indexOfGreatestChild]) < 0) {
                swapAtIndex(nodeId, indexOfGreatestChild);
                nodeId = indexOfGreatestChild;
            }else{
                return;
            }
        }
    }

    public T[] sort() {

        createHeap();

        swapAtIndex(0,array.length-1);

        int lastChild = array.length-1;
        int lastParent = parentNode(lastChild);

        int lastElement = array.length-2;

        while(lastElement > 0) {
            sinke(0, lastElement);
            swapAtIndex(0, lastElement);
            lastElement--;
        }

        return array;

    }

}
