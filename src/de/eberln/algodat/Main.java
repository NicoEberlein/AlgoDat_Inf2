package de.eberln.algodat;

import de.eberln.algodat.cargo.CrateMover;
import de.eberln.algodat.cargo.CrateMover9000;
import de.eberln.algodat.cargo.CrateMover9001;

public class Main {

	public static void main(String[] args) {
		
//		int size = 1*100000;
//		int boundary = 10;
//		
//		ILittleDistanceFinder<Double> fastFinder = new FastLittleDistanceFinderImpl<>();
//		ILittleDistanceFinder<Double> slowFinder = new SlowLittleDistanceFinderImpl<>();
//		
//		Random r = new Random();
//		
//		List<Point<Double>> points = new ArrayList<>();
//		
//		for(int i = 0; i<size; i++) {
//			points.add(new Point<Double>(r.nextDouble(boundary*(-1), boundary+1), r.nextDouble(boundary*(-1), boundary+1)));
//		}
//		
//		System.out.println("Fast:");
//		long fastMil = System.currentTimeMillis();
//		List<Point<Double>> f = fastFinder.findNearestPair(points);
//		long fastDur = System.currentTimeMillis() - fastMil;
//		System.out.println(f);
//		
//
//		System.out.println("Slow:");
//		long slowMil = System.currentTimeMillis();
//		List<Point<Double>> s = slowFinder.findNearestPair(points);
//		long slowDur = System.currentTimeMillis() - slowMil;
//		System.out.println(s);
//
//		
//		System.out.printf("Algorithm took %.0f seconds to find the two closest points", fastDur/1000.0);
//		System.out.println("Duration of slow algorithm: " + slowDur);
//		System.out.printf("The slow algorithm took %d times longer than the fast implementation", Math.floorDiv(slowDur, fastDur));
		
		CrateMover[] movers = new CrateMover[] {new CrateMover9001("files/data_new.txt"), new CrateMover9000("files/data_new.txt")};
		
		for(CrateMover mover : movers) {
			System.out.println(mover.getUpperCrates());
		}
		
	}
	
}
