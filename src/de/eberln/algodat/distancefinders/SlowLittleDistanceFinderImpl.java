package de.eberln.algodat.distancefinders;

import java.util.ArrayList;
import java.util.List;

public class SlowLittleDistanceFinderImpl<T extends Number> implements ILittleDistanceFinder<T>{
	
	@Override
	public List<Point<T>> findNearestPair(List<Point<T>> points) {
		
		List<Point<T>> currentLowestDistancePoints = new ArrayList<>();
		double currentLowestDistance = Double.MAX_VALUE;
		
		for(int i = 0; i<points.size(); i++) {
			
			for(int j = 0; j<points.size(); j++) {
				
				double currentDistance = points.get(i).getDistance(points.get(j));
				if(currentDistance > 0 && currentDistance < currentLowestDistance) {
					currentLowestDistance = currentDistance;
					
					try {
						currentLowestDistancePoints.set(0, points.get(i));
						currentLowestDistancePoints.set(1, points.get(j));
					}catch(IndexOutOfBoundsException e) {
						currentLowestDistancePoints.add(0, points.get(i));
						currentLowestDistancePoints.add(1, points.get(j));
					}
				}
			}
		}
		
		return currentLowestDistancePoints;
		
	}
	
}
