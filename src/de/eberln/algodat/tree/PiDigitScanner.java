package de.eberln.algodat.tree;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PiDigitScanner {
    
    public static List<Integer> getDigitsFromFile(File file, int n) {

        List<Integer> intdigits = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            while(n>0 && reader.ready()) {   
                int readInt = reader.read();
                if(readInt >= 0) {
                    intdigits.add(readInt);
                    n--;
                }else{
                    break;
                }
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return intdigits.stream().map(number -> number - '0').collect(Collectors.toList());

    }

}
