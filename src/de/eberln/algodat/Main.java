package de.eberln.algodat;

import java.util.Random;

import de.eberln.algodat.distancefinders.FastLittleDistanceFinderImpl;
import de.eberln.algodat.distancefinders.ILittleDistanceFinder;
import de.eberln.algodat.distancefinders.Point;
import de.eberln.algodat.distancefinders.SlowLittleDistanceFinderImpl;

public class Main {

	public static void main(String[] args) {
		
		int size = 1*100000;
		
		ILittleDistanceFinder fastFinder = new FastLittleDistanceFinderImpl();
		ILittleDistanceFinder slowFinder = new SlowLittleDistanceFinderImpl();
		
		Random r = new Random();
		
		Point[] p = new Point[size];
		
		for(int i = 0; i<size; i++) {
			p[i] = new Point(r.nextInt(-1500, 1501), r.nextInt(-1500, 1501));
		}
		
		System.out.println("Fast:");
		long fastMil = System.currentTimeMillis();
		Point[] f = fastFinder.findNearestPair(p);
		long fastDur = System.currentTimeMillis() - fastMil;
		System.out.println(f[0]);
		System.out.println(f[1]);
		

		System.out.println("Slow:");
		long slowMil = System.currentTimeMillis();
		Point[] s = slowFinder.findNearestPair(p);
		long slowDur = System.currentTimeMillis() - slowMil;
		System.out.println(s[0]);
		System.out.println(s[1]);
		
		System.out.println("Duration of fast algorithm: " + fastDur);
		System.out.println("Duration of slow algorithm: " + slowDur);
		System.out.printf("The slow algorithm took %d times longer than the fast implementation", Math.floorDiv(slowDur, fastDur));
		
	}
	
}
