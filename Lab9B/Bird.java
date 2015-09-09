/*
 * Name: Joseph Godfrey
 * Date: 15/Apr/2015
 * Course: CSC 212 
 * Program: Lab 9B
 * 
 * Purpose: The abstract class for bird behavior.
 */

import java.awt.*;

public abstract class Bird {
	// data fields
	private Point position;
	private Color birdColor;
	
	
	// constructor
	public Bird(int x, int y, Color color){ 
		setPosition(x,y);
		this.birdColor = color;
	}
	
	
	
	// instance methods
	public Color getColor(){
		return birdColor;
	}
	public Point getPosition(){
		return position;
	}
	
	public int getX(){
		return position.getX();
	}
	public int getY(){
		return position.getY();
	}
	
	public void setPosition(int x, int y){
		if (x<0 || y<0){
			throw new IllegalArgumentException();
		}
		this.position = new Point(x,y);
	}
	
	

}
