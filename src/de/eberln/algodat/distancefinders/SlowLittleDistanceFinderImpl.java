package de.eberln.algodat.distancefinders;

public class SlowLittleDistanceFinderImpl implements ILittleDistanceFinder{
	
	@Override
	public Point[] findNearestPair(Point[] points) {
		
		Point[] currentLowestDistancePoints = new Point[2];
		double currentLowestDistance = Double.MAX_VALUE;
		
		for(int i = 0; i<points.length; i++) {
			
			for(int j = 0; j<points.length; j++) {
				
				double currentDistance = findDistance(points[i], points[j]);
				if(currentDistance > 0 && currentDistance < currentLowestDistance) {
					currentLowestDistance = currentDistance;
					currentLowestDistancePoints[0] = points[i];
					currentLowestDistancePoints[1] = points[j];
				}
				
			}
		}
		
		return currentLowestDistancePoints;
		
	}
	
	private double findDistance(Point a, Point b) {
		
		return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
		
	}
	
}
