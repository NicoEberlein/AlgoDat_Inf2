package de.eberln.algodat.stack;

public class Main {

	public static void main(String[] args) {
		
		LinkedListStack<String> stack = new LinkedListStack<>();
		
		stack.push("x");
		System.out.println(stack.pop());
		
		System.out.println(stack.isEmpty());
		
		
	}
	
}
