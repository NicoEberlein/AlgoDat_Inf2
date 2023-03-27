package de.eberln.algodat.cargo;

import de.eberln.algodat.stack.Stack;

public class CrateMover9001 extends CrateMover {

	public CrateMover9001(String filePath) {
		
		super(filePath);
		
	}
	
	@Override
	public void doMoves() {
		
		for(Move m : moves) {
			
			String[] strToMove = new String[m.getQuantity()];
			
			Stack<String> from = stacks.get(m.getFrom()-1);
			Stack<String> to = stacks.get(m.getTo()-1);
			
			for(int i = 0;i<m.getQuantity();i++) {
				strToMove[i] = from.pop();
			}
			
			for(int i = strToMove.length-1;i>=0;i--) {
				to.push(strToMove[i]);
			}
			
		}
		
	}

}
