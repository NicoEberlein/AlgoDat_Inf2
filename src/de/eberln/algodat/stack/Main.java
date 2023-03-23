package de.eberln.algodat.stack;

import de.eberln.algodat.distancefinders.Point;

public class Main {

	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<>();
		
		stack.push("Lorem");
		stack.push("ipsum");
		stack.push("dododex");
		stack.push("sit");
		stack.push("irgendwas");
		
		System.out.println(stack.peek());
		
		System.out.println(stack.pop());
		
		System.out.println(stack.peek());
		
		stack.push("Test");
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		Stack<Point<Long>> longstack = new Stack<>();
		
		longstack.push(new Point<Long>(2L, 3L));
		longstack.push(new Point<Long>(44L, 44L));
		longstack.push(new Point<Long>(1L, 454567L));
		longstack.push(new Point<Long>(77L, 3L));
		longstack.push(new Point<Long>(0L, 0L));
		longstack.push(new Point<Long>(3L, 3L));
		longstack.push(new Point<Long>(1L, 7L));
		
		System.out.println(longstack.pop());
		System.out.println(longstack.pop());
		System.out.println(longstack.pop());
		System.out.println(longstack.pop());
		System.out.println(longstack.pop());
		System.out.println(longstack.pop());
		System.out.println(longstack.peek());
		System.out.println(longstack.peek());
		
		
	}
	
}
