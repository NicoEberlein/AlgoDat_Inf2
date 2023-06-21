package de.eberln.algodat.stack;

public class ArrayStack<T> implements Stack<T>{

    private T[] values;
    private int currentIndex;

    public ArrayStack(int initialSize) {
        values = (T[]) new Object[initialSize];
    }

    public ArrayStack() {
        this(20);
    }

    @Override
    public T push(T content) {
        insertAndEnsureSize(content);
        return content;
    }

    @Override
    public T pop() {

        if(currentIndex == 0) {
            return null;
        }

        return values[--currentIndex];

    }

    @Override
    public T peek() {

        if(currentIndex == 0) {
            return null;
        }

        return values[currentIndex-1];

    }

    @Override
    public boolean isEmpty() {

        return currentIndex == 0;

    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {

        String resultStr = "[ ";

        for(int i = 0; i<currentIndex; i++) {
            if(values[i] != null) {
                resultStr += values[i].toString() + " ";
            }
        }

        return resultStr + "]";

    }

    private void insertAndEnsureSize(T value) {

        if(currentIndex >= values.length) {

            T[] oldValues = values;
            values = (T[]) new Object[values.length*2];

            for(int i = 0; i<oldValues.length; i++) {
                values[i] = oldValues[i];
            }

        }

        values[currentIndex] = value;
        currentIndex++;

    }


}
