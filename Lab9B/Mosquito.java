/*
 * Name: Joseph Godfrey
 * Date: 15/Apr/2015
 * Course: CSC 212
 * Program: Lab 9B
 * 
 * Purpose: To define the Bluebird class
 */

import java.awt.*;
import java.util.*;

public class Mosquito implements Flyable {
	
	// data field
	private Point location;
	private Color color;
	private Random rand;
	
	
	
	// constructor
	public Mosquito(int x, int y){
		if (x<=0 || y<=0){
			throw new IllegalArgumentException();
		}
		this.location = new Point(x,y);
		this.color = Color.MAGENTA;
		this.rand = new Random();
	}
	
	public Color getColor(){
		return color;
	}
	public Point getPosition(){
		return location;
	}
	
	public void fly(){
		this.location = new Point(rand.nextInt(Aviary.SIZE-2)+1, rand.nextInt(Aviary.SIZE-2)+1);
	}
}
	