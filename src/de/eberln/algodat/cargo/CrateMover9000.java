package de.eberln.algodat.cargo;

import de.eberln.algodat.stack.Stack;

public class CrateMover9000 extends CrateMover {
	
	public CrateMover9000(String filePath) {
		super(filePath);
	}
	
	@Override
	public void doMoves() {
		
		for(Move m : moves) {
			
			Stack<String> from = stacks.get(m.getFrom()-1);
			Stack<String> to = stacks.get(m.getTo()-1);
			
			for(int i = 0; i<m.getQuantity();i++) {
				
				String tmp = from.pop();
				
				to.push(tmp);
				
			}
			
		}
		
	}
	
}











