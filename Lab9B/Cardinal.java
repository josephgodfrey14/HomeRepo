/*
 * Name: Joseph Godfrey
 * Date: 15/Apr/2015
 * Course: CSC 212
 * Program: Lab 9B
 * 
 * Purpose: To define the Cardinal class
 */

import java.awt.*;

public class Cardinal extends Bird implements Flyable {
	// data field
	private boolean upwardY;
	
	
	
	// constructor
	public Cardinal(int x, int y){
		super(x,y,Color.RED);
		this.upwardY = true;
	}
	
	// instance method
	public void fly(){
		
		if (upwardY){
			setPosition(getX(), getY()-1);
			if(getY() == 0){
				upwardY = false;
			}
		}else{
			setPosition(getX(), getY()+1);
			if(getY() == Aviary.SIZE-1){
				upwardY = true;
			}
		}
	}
	
	
	
}
