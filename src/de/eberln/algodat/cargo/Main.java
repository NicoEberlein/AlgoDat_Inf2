package de.eberln.algodat.cargo;

public class Main {

	public static void main(String[] args) {
		
		CrateMover mover = new CrateMover9001("data_new.txt");
		
		System.out.println(mover.getUpperCrates());
		
	}
	
}
