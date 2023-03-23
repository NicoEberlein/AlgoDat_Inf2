package de.eberln.algodat.distancefinders;

import java.util.List;

public interface ILittleDistanceFinder<T extends Number> {

	public List<Point<T>> findNearestPair(List<Point<T>> points);
	
}
