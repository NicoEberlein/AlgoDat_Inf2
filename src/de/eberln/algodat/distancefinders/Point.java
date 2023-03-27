package de.eberln.algodat.distancefinders;

public class Point<T extends Number> implements Comparable<Point<T>>{

	private T x;
	private T y;
	
	public static double getDistance(Point<? extends Number> a, Point<? extends Number> b) {
		
		return Math.sqrt(
				Math.pow(a.getX() - b.getX(), 2) +
				Math.pow(a.getY() - b.getY(), 2));
		
	}
	
	public Point(T x, T y) {
		
		setX(x);
		setY(y);
		
	}
	
	public double getX() {
		return x.doubleValue();
	}


	public void setX(T x) {
		this.x = x;
	}


	public double getY() {
		return y.doubleValue();
	}


	public void setY(T y) {
		this.y = y;
	}


	@Override
	public String toString() {
		return "(" + getX() + "/" + getY() + ")";
	}

	@Override
	public int compareTo(Point<T> o) {
		
		return Double.valueOf(this.getX()).compareTo(o.getX());
		
	}
	
	public double getDistance(Point<T> o) {
		
		return Math.sqrt(
				Math.pow(this.getX() - o.getX(), 2) +
				Math.pow(this.getY() - o.getY(), 2));
		
	}
	
}
