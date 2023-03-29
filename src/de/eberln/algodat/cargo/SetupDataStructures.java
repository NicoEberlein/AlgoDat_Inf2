package de.eberln.algodat.cargo;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.eberln.algodat.stack.LinkedListStack;
import de.eberln.algodat.stack.Stack;

public class SetupDataStructures {
    
	public ArrayList<Stack<String>> createStacks(ArrayList<String> stackSetupStr) {
		
		ArrayList<Stack<String>> stacks = new ArrayList<>();
		
		for(int i = stackSetupStr.size()-1;i>=0;i--) {
			
			char[] chars = stackSetupStr.get(i).toCharArray();
			
			int index = 0;
			
			for(int j = 1; j<=chars.length+1;j+=4) {
				if(chars[j] != ' ') {
					try {
					
						stacks.get(index).push(chars[j] + "");
						
					}catch(IndexOutOfBoundsException e) {
						stacks.add(new LinkedListStack<>());
						stacks.get(index).push(chars[j] + "");
					}
					
				}
				index++;
			}
			
		}
		
		return stacks;
	
	}
	
    public ArrayList<Move> createMoves(ArrayList<String> moveSetupStr) {
    
		ArrayList<Move> moves = new ArrayList<>();
		Pattern numberPattern = Pattern.compile("\\d+");
		
		for(String s : moveSetupStr) {
			
			Matcher numberMatcher = numberPattern.matcher(s);
			int found = 0;
			int[] foundNumbers = new int[3];
			
			Move move = new Move();
			
			while(numberMatcher.find()) {
				foundNumbers[found] = Integer.parseInt(numberMatcher.group());
				found++;
			}
			
			moves.add(new Move(foundNumbers));	
		}
		
		return moves;
    
    	
    }
}

