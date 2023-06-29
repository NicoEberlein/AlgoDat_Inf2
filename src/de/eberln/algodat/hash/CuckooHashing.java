package de.eberln.algodat.hash;

import java.util.ArrayList;

public class CuckooHashing<T extends Cuckooable> {
    
    private ArrayList<T> h0, h1;
    private int hashTableSize;

    public CuckooHashing() {
        this(11);
    }

    public CuckooHashing(int hashTableSize) {
        this.hashTableSize = hashTableSize;
        h0 = new ArrayList<>();
        h1 = new ArrayList<>();

        for(int i = 0; i<hashTableSize; i++) {
            h0.add(null);
            h1.add(null);
        }
    }

    public String toString() {
        String res = "";

        res += "h0: " + h0 + "\n" + "h1: " + h1;

        return res;
    }

    public Boolean add(T value) {
        T toBeInserted = value;
        T contentBefore = null;

        int steps = 0;

        if(isIn(value)) return true;

        while(steps < hashTableSize) {
            contentBefore = h0.get(value.hash0());
            h0.set(toBeInserted.hash0(), toBeInserted);
            if(contentBefore == null) return true;

            toBeInserted = contentBefore;
            contentBefore = h1.get(toBeInserted.hash1());
            h1.set(toBeInserted.hash1(), toBeInserted);

            if(contentBefore == null) return true;

            toBeInserted = contentBefore;

            steps++;
        }

        return false;
    }

    public Boolean isIn(T value) {
        return h0.get(value.hash0()).equals(value) || h1.get(value.hash1()).equals(value);
    }

}
