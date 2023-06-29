package de.eberln.algodat.hash;

public class Prober {
    
    public enum ProbingAlgorithm {
        LINEAR,
        QUADRATIC,
        QUADRATICALTERNATING
    }

    private ProbingAlgorithm probingAlgorithm;
    private int currentCount;
    private int currentHashTableSize;

    public Prober(ProbingAlgorithm probingAlgorithm, int currentCount, int currentHashTableSize) {

        this.currentCount = currentCount;
        this.probingAlgorithm = probingAlgorithm;
        this.currentHashTableSize = currentHashTableSize;

    }

    public int getNextProbingIndex() {

        int probedIndex = switch(probingAlgorithm) {
            case LINEAR -> {
                yield currentCount++;
            }
            case QUADRATIC -> {
                yield (int) Math.pow(currentCount++, 2);
            }
            case QUADRATICALTERNATING -> {
                yield (int) (Math.pow(currentCount++, 2) * Math.pow(-1, currentCount));
            }
        };

        while(probedIndex > currentHashTableSize) {
            probedIndex -= currentHashTableSize;
        }

        while(probedIndex < 0) {
            probedIndex += currentHashTableSize;
        }

        return probedIndex;

    }

}
