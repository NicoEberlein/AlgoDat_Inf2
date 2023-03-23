package de.eberln.algodat.distancefinders;

import java.util.ArrayList;
import java.util.Collections;

public class FastLittleDistanceFinderImpl implements ILittleDistanceFinder{
	
	@Override
	public Point[] findNearestPair(Point[] p) {
		
		ArrayList<Point> points = new ArrayList<>();
		Collections.addAll(points, p);
		Collections.sort(points);
		
		double currentLowestDistance = Double.MAX_VALUE;
		Point[] currentPoints = new Point[2];
		
		int comparePoint = 0;
		
		for(int i = 0; i<points.size();i++) {
			
			if(i+1 < points.size()) {
				comparePoint = i+1; 
			}else {
				break;
			}
			
			while(comparePoint < points.size() && (points.get(comparePoint).getX() <= (points.get(i).getX() + currentLowestDistance))) {
				
				double currentViewedDistance = findDistance(points.get(i), points.get(comparePoint));
				
				if((currentViewedDistance < currentLowestDistance) && currentViewedDistance > 0) {
					
					currentLowestDistance = currentViewedDistance;
					currentPoints[0] = points.get(i);
					currentPoints[1] = points.get(comparePoint);
				
				}

				comparePoint++;
				
			}
			
		}
		
		return currentPoints;
		
	}
	
	private double findDistance(Point a, Point b) {
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
	}
	
}
