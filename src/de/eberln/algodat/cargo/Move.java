package de.eberln.algodat.cargo;

public class Move {

	private int quantity;
	private int from;
	private int to;
	
	public Move(int quantity, int from, int to) {
		this.quantity = quantity;
		this.from = from;
		this.to = to;
	}
	
	public Move(int[] numbers) {
		this(numbers[0], numbers[1], numbers[2]);
	}
	
	public Move() {
		
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
	}
	
	@Override
	public String toString() {
		return "(" + quantity + "/" + from + "/" + to + ")";
	}
	
	
	
	
	
}
