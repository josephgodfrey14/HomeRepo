/*
 * Name: Joseph Godfrey
 * Date: 25/March/2015
 * Course: CSC 212
 * Program: Lab 8A 
 * 
 * Purpose: A Point object represents a pair of (x, y) coordinates.
 */

import java.awt.*;

public class Point {

	// fields
	private int x;
	private int y;

	// constructors
	public Point(int x, int y) {
		setLocation(x, y);
	}

	public Point() {
		this(0, 0);
	}

	// accessors for data fields
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	// mutator methods
	// Accept coordinates of a point and store them in the fields
	public void setLocation(int x, int y) {
		if (x < 0 || y < 0) {
			throw new IllegalArgumentException();
		}
		this.x = x;
		this.y = y;
	}

	// accept distance to translate a point and change the fields
	public void translate(int dx, int dy) {
		x += dx; // x = x + dx;
		y += dy;
	}

	// accessor methods
	// return the distance between the point and the origin
	public double distanceFromOrigin() {
		Point origin = new Point();
		double myDistance = this.distance(origin);
		return myDistance;
	}

	// return the distance between two points
	public double distance(Point other) {
		int dx = this.x - other.x;
		int dy = this.y - other.y;
		double myDistance = Math.sqrt(dx * dx + dy * dy);
		return myDistance;
	}

	// return a string representation of the point
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	// calculates distance like blocks by taking the roads
	public int manhattanDistance(Point other) {
		int dx = this.x - other.x;
		int dy = this.y - other.y;
		return (Math.abs(dx) + Math.abs(dy));
	}

	// decides whether the x coord is the same as this one
	public boolean isVertical(Point other) {
		if (this.x == other.x) {
			return true;
		}
		return false;
	}

	// calculates the slope
	public double slope(Point other) {
		if (isVertical(other)) {
			throw new IllegalArgumentException("Slope is undefined");
		} else {
			return ((double) (other.y - this.y) / (double) (other.x - this.x));
		}

	}

}
