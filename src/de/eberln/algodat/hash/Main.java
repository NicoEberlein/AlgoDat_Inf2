package de.eberln.algodat.hash;

import de.eberln.algodat.hash.Prober.ProbingAlgorithm;

public class Main {
    public static void main(String args[])
    {        
        ChainedHashing<String> h = new ChainedHashing<>(4, ProbingAlgorithm.QUADRATICALTERNATING);
        Minions m = new Minions();

        for (int i=0; i<m.count(); i++) {
            h.insert(m.nameFor(i));
        }

        for(int i = 0; i<1000000000; i++) {
            h.insert(m.getAny());
        }

        for(int i = 0; i<100000; i++) {
            System.out.println(h.delete(m.getAny()));
        }

        System.out.println(h);

    }
}
