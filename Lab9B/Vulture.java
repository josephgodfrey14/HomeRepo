/*
 * Name: Joseph Godfrey
 * Date: 15/Apr/2015
 * Course: CSC 212
 * Program: Lab 9B
 * 
 * Purpose: To define the Bluebird class
 */

import java.awt.*;

public class Vulture extends Bird implements Flyable {
	
	// data field
		private int vFlight;
		
		
		
		// constructor
		public Vulture(int x, int y){
			super(x,y,Color.BLACK);
			this.vFlight = 0;
		}
		
		// instance method
		public void fly(){//TODO all this
			
			if (vFlight == 0){
				setPosition(getX()+1, getY());
			}else if (vFlight == 1){
				setPosition(getX(), getY()-1);
			}else if (vFlight == 2){
				setPosition(getX()-1, getY());
			}else{
				setPosition(getX(), getY()+1);
				vFlight=-1;
			} 
			vFlight++;
		}
}