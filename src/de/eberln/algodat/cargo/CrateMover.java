package de.eberln.algodat.cargo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import de.eberln.algodat.stack.Stack;

public abstract class CrateMover {

	protected ArrayList<Stack<String>> stacks;
	protected ArrayList<Move> moves;
	
	protected CrateMover(String filePath) {
		
		stacks = new ArrayList<>();
		moves = new ArrayList<>();
		
		setupStackData(filePath);
		
	}
	
	private final void setupStackData(String filePath) {
		
		ArrayList<String> stringStacks = new ArrayList<>();
		ArrayList<String> stringMoves = new ArrayList<>();
		
		try {
			Scanner scanner = new Scanner(new File(filePath));
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				if(line.contains("[")) {
					stringStacks.add(line);
				}else if(line.startsWith("move")) {
					stringMoves.add(line);
				}
				
			}
			
			SetupDataStructures setupClerk = new SetupDataStructures();
			
			moves = setupClerk.createMoves(stringMoves);
			stacks = setupClerk.createStacks(stringStacks);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public final String getUpperCrates() {
		doMoves();
		String build = "";
		for(Stack s : stacks) {
			build = build + s.peek() + " ";
		}
		return build;
	}
	
	protected abstract void doMoves();
	
}
