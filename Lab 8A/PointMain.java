/*
 * Name: Joseph Godfrey
 * Date: 25/March/2015
 * Course: CSC 212
 * Program: Lab Ch8A 
 * 
 * Purpose: This program deals with 2-d points.
 * Fourth version, to accompany encapsulated Point class.
 */

public class PointMain {

	public static void main(String[] args) {
		// create two Point objects
		Point p1 = new Point(7, 2);
		Point p2 = new Point(4, 3);

		// print each point and its distance from origin
		System.out.println("p1 is " + p1);
		System.out.println("distance from origin = " + p1.distanceFromOrigin());
		System.out.println("p2 is " + p2);
		System.out.println("distance from origin = " + p2.distanceFromOrigin());

		System.out.println("Manhattan distance from p1 to p2 is "
				+ p1.manhattanDistance(p2));
		System.out.println("Slope of the line between p1 and p2 is "
				+ p1.slope(p2));

		// translate each point to a new location
		p1.translate(11, 6);
		p2.translate(1, 7);

		// print the points again
		System.out.println("p1 is " + p1);
		System.out.println("p2 is " + p2);

		System.out.println("Manhattan distance from p2 to p1 is "
				+ p1.manhattanDistance(p2));
		System.out.println("Slope of the line between p1 and p2 is "
				+ p1.slope(p2));
	}
}