package de.eberln.algodat.tree;

import java.io.File;
import java.util.function.Consumer;

public class TreeController {
    
    public static void main(String[] args) {
        
        PiTreeController t = new PiTreeController();

        t.buildPiTree(PiDigitScanner.getDigitsFromFile(new File("files/pi.txt"), 1000));

    }

}
