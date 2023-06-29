package de.eberln.algodat.hash;

public class ChainHashableWrapper<T> {
    
    private boolean hereWasSomethingButIsNowGone;

    private int count;

    private T value;

    public ChainHashableWrapper() {

        count = 0;
        value = null;
        hereWasSomethingButIsNowGone = false;

    }

    public void delete() {
        count = 0;
        value = null;
        hereWasSomethingButIsNowGone = true;    
    }

    public void increment() {
        count++;
    }

    public void decrement() {
        if(count > 1) {
            count--;
        }else if(count == 1) {
            delete();
        }
    }

    public void setValue(T value) {
        this.count = 1;
        this.value = value;
        hereWasSomethingButIsNowGone = false;
    }

    public T getValue() {
        return value;
    }

    public boolean isEmpty() {
        return value == null;
    }

    public boolean hereWasSomething() {
        return hereWasSomethingButIsNowGone;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        
        return value == null ? "[]" : "[ " + count + "x " + value + " ]";
    }


}
