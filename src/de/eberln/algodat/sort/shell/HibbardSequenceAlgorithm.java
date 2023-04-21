package de.eberln.algodat.sort.shell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HibbardSequenceAlgorithm implements SequenceAlgorithm{

	@Override
	public List<Integer> getSequence(int arraysize) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int i = 1;
		int calculatedInt = (int) Math.pow(2, i)-1;
		
		while(calculatedInt < arraysize) {
			list.add(calculatedInt);
			i++;
			calculatedInt = (int) Math.pow(2, i)-1;
		}
		
		return list
				.stream()
				.sorted((i1, i2) -> Integer.compare(i2, i1))
				.collect(Collectors.toList());
		
	}

	
}
