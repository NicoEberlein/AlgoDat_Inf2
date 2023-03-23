package de.eberln.algodat;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.eberln.algodat.distancefinders.FastLittleDistanceFinderImpl;
import de.eberln.algodat.distancefinders.ILittleDistanceFinder;
import de.eberln.algodat.distancefinders.Point;
import de.eberln.algodat.distancefinders.SlowLittleDistanceFinderImpl;

public class Main {

	public static void main(String[] args) {
		
		int size = 1*100000;
		
		ILittleDistanceFinder<Integer> fastFinder = new FastLittleDistanceFinderImpl<>();
		ILittleDistanceFinder<Integer> slowFinder = new SlowLittleDistanceFinderImpl<>();
		
		Random r = new Random();
		
		List<Point<Integer>> points = new ArrayList<>();
		
		for(int i = 0; i<size; i++) {
			points.add(new Point<Integer>(r.nextInt(-1500, 1501), r.nextInt(-1500, 1501)));
		}
		
		System.out.println("Fast:");
		long fastMil = System.currentTimeMillis();
		List<Point<Integer>> f = fastFinder.findNearestPair(points);
		long fastDur = System.currentTimeMillis() - fastMil;
		System.out.println(f);
		

		System.out.println("Slow:");
		long slowMil = System.currentTimeMillis();
		List<Point<Integer>> s = slowFinder.findNearestPair(points);
		long slowDur = System.currentTimeMillis() - slowMil;
		System.out.println(s);

		
		System.out.println("Duration of fast algorithm: " + fastDur);
		System.out.println("Duration of slow algorithm: " + slowDur);
		System.out.printf("The slow algorithm took %d times longer than the fast implementation", Math.floorDiv(slowDur, fastDur));
		
	}
	
}
