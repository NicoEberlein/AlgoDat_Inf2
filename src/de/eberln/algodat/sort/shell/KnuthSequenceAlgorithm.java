package de.eberln.algodat.sort.shell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class KnuthSequenceAlgorithm implements SequenceAlgorithm{

	@Override
	public List<Integer> getSequence(int arraysize) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int i = 1;
		int calculatedInt = (int) (Math.pow(3, i)-1)/2;
		
		while(calculatedInt < arraysize) {
			list.add(calculatedInt);
			i++;
			calculatedInt = (int) (Math.pow(3, i)-1)/2;
		}
		
		return list
				.stream()
				.sorted((i1, i2) -> Integer.compare(i2, i1))
				.collect(Collectors.toList());
		
		
	}
	
}
