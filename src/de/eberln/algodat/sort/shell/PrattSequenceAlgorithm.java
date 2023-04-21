package de.eberln.algodat.sort.shell;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrattSequenceAlgorithm implements SequenceAlgorithm{

	@Override
	public List<Integer> getSequence(int arraysize) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		int twoPow=0;
		int value = (int) Math.pow(2, twoPow);
		boolean abort = false;
		
		while(value < arraysize) {
			
			list.add(value);
			
			for(int threePow = 1; threePow<=twoPow; threePow++) {
				int innerValue = (int) (Math.pow(2, twoPow-threePow) * Math.pow(3, threePow));
				if(innerValue > arraysize) {
					abort = true;
					break;
				}else {
					list.add(innerValue);
				}
			}
			
			value = (int) Math.pow(2, ++twoPow);
			
		}
		
		return list
				.stream()
				.sorted((i1, i2) -> Integer.compare(i2, i1))
				.collect(Collectors.toList());
		
		
	}

	
	
}
