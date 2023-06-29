package de.eberln.algodat.hash;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import de.eberln.algodat.hash.Prober.ProbingAlgorithm;

public class ChainedHashing<T> {

    private List<ChainHashableWrapper<T>> hashTable;

    private ProbingAlgorithm probingAlgorithm;

    public ChainedHashing() {

        this(300, ProbingAlgorithm.LINEAR);

    }

    public ChainedHashing(int initialHashTableSize, ProbingAlgorithm probingAlgorithm) {

        createNewHashTable(initialHashTableSize);
        this.probingAlgorithm = probingAlgorithm;

    }

    private void createNewHashTable(int size) {
    
        hashTable = new ArrayList<>();
        for(int i = 0; i<size; i++) {
            hashTable.add(i, new ChainHashableWrapper<T>());
        }

    }

    private int getHash(T value) {
        return Math.abs(value.hashCode()) % hashTable.size();
    }

    private void rehash(int newHashTableSize) {

        System.out.println("Performing rehash...");

        ArrayList<ChainHashableWrapper<T>> tmpStorage = new ArrayList<>();

        for(ChainHashableWrapper<T> t : hashTable) {
            if(!t.isEmpty()) {
                tmpStorage.add(t);
            }
        }

        createNewHashTable(newHashTableSize);

        for(ChainHashableWrapper<T> t : tmpStorage) {
            for(int i = 0; i<t.getCount(); i++) {
                this.insert(t.getValue());
            }
        }
    }

    public void insert(T value) {

        _insert(value, getHash(value), hashTable.size(), new Prober(probingAlgorithm, getHash(value), hashTable.size()));

    }

    private void _insert(T value, int index, int ttl, Prober prober) {

        if(ttl == 0) {
            rehash(hashTable.size()*2);
            insert(value);
            return;
        }

        if(index >= hashTable.size()) index -= hashTable.size();

        ChainHashableWrapper<T> insert = hashTable.get(index);

        if(insert.isEmpty()) {

            insert.setValue(value);

        }else{
            if(insert.getValue() == value) {
                insert.increment();
            }else{
                // Füge woanders ein
                _insert(value, prober.getNextProbingIndex(), ttl-1, prober);
            }
        }

    }

    public boolean isIn(T value) {

        Prober prober = new Prober(probingAlgorithm, getHash(value), hashTable.size());

        return _getChainHashableWrapper(value, getHash(value), prober) != null;

    }

    private ChainHashableWrapper<T> _getChainHashableWrapper(T value, int index, Prober prober) {

        ChainHashableWrapper<T> currentChainHashable = hashTable.get(index);

        if(currentChainHashable.getValue() == value) {
            return currentChainHashable;
        }else{
            if(currentChainHashable.hereWasSomething() || !currentChainHashable.isEmpty()) {
                return _getChainHashableWrapper(value, prober.getNextProbingIndex(), prober);
            }else{
                return null;
            }
        }

    }

    public int countValue(T value) {

        Prober prober = new Prober(probingAlgorithm, getHash(value), hashTable.size());

        if(isIn(value)) {
            return _getChainHashableWrapper(value, getHash(value), prober).getCount();
        }else{
            throw new NoSuchElementException();
        }

    }

    public boolean delete(T value) {

        Prober prober = new Prober(probingAlgorithm, getHash(value), hashTable.size());

        return _delete(value, getHash(value), prober);
    }

    private boolean _delete(T value, int index, Prober prober) {

        ChainHashableWrapper<T> currentChainHashable = hashTable.get(index);

        if(currentChainHashable.getValue() == value) {
            currentChainHashable.decrement();
            return true;
        }else{
            if(currentChainHashable.hereWasSomething() || !currentChainHashable.isEmpty()) {
                return _delete(value, prober.getNextProbingIndex(), prober);
            }else{
                return false;
            }
        }

    }

    public void cleanup() {
        rehash(hashTable.size());
    }

    @Override
    public String toString() {

        String res = "[ 0: " + hashTable.get(0);

        for(int i = 1; i<hashTable.size(); i++) {
            res += ", " + i + ": " + hashTable.get(i);
        }

        return res += " ]";

    }

}
