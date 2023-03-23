package de.eberln.algodat.distancefinders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FastLittleDistanceFinderImpl<T extends Number> implements ILittleDistanceFinder<T>{
	
	@Override
	public List<Point<T>> findNearestPair(List<Point<T>> points) {
		
		Collections.sort(points);
		
		double currentLowestDistance = Double.MAX_VALUE;
		List<Point<T>> currentLowestDistancePoints = new ArrayList<>();
		
		int comparePoint = 0;
		
		for(int i = 0; i<points.size();i++) {
			
			if(i+1 < points.size()) {
				comparePoint = i+1; 
			}else {
				break;
			}
			
			while(comparePoint < points.size() && (points.get(comparePoint).getX() <= (points.get(i).getX() + currentLowestDistance))) {
				
				double currentViewedDistance = points.get(i).getDistance(points.get(comparePoint));
				
				if((currentViewedDistance < currentLowestDistance) && currentViewedDistance > 0) {
					
					currentLowestDistance = currentViewedDistance;
					
					try {
						currentLowestDistancePoints.set(0, points.get(i));
						currentLowestDistancePoints.set(1, points.get(comparePoint));
					}catch(IndexOutOfBoundsException e) {
						currentLowestDistancePoints.add(0, points.get(i));
						currentLowestDistancePoints.add(1, points.get(comparePoint));
					}
				
				}

				comparePoint++;
				
			}
			
		}
		
		return currentLowestDistancePoints;
		
	}
	
}
