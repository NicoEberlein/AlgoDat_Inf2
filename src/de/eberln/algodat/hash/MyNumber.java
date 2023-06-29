package de.eberln.algodat.hash;

public class MyNumber implements Comparable<MyNumber>, Cuckooable {
    
    private int hashTableSize;
    private int value;

    public MyNumber(int value, int hashTableSize) {
        this.hashTableSize = hashTableSize;
        setValue(value);
    }

    public MyNumber(int hashTableLength) {
        this.hashTableSize = hashTableLength;
    }

    public MyNumber() {
        this(11);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int hash0() {
        return value % hashTableSize;
    }

    public int hash1() {
        return (value/11) % hashTableSize;
    }

    public int compareTo(MyNumber o) {
        return this.value - o.getValue();
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

}
