/*
 * Name: Joseph Godfrey
 * Date: 15/Apr/2015
 * Course: CSC 212
 * Program: Lab 9B
 * 
 * Purpose: To define the Bluebird class
 */

import java.awt.*;

public class Bluebird extends Bird implements Flyable {
	
	// data field
	private boolean rightwardX;
	private int upwardY;
	
	
	
	// constructor
	public Bluebird(int x, int y){
		super(x,y,Color.BLUE);
		this.rightwardX = true;
		this.upwardY = 1;
	}
	
	// instance method
	public void fly(){
		
		if (rightwardX){
			upwardY=upwardY%2;
			if (upwardY==0){
				setPosition(getX()+1, getY()+1);
			}else{
				setPosition(getX()+1, getY()-1);
			}
			
			if(getX() == Aviary.SIZE-1){
				rightwardX = false;
			}
			upwardY++;
		}else{
			upwardY=upwardY%2;
			if (upwardY==0){
				setPosition(getX()-1, getY()+1);
			}else{
				setPosition(getX()-1, getY()-1);
			}
			
			if(getX() == 0){
				rightwardX = true;
			}
			upwardY++;
		}
	}
	

	
	
	
}
