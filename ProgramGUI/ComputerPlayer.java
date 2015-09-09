/*
 * Name: Joseph Godfrey
 * Date: 28/APR/2015
 * Course: CSC212
 * Program: ProgramGUI
 * 
 * Description:
 * 
 * 
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class ComputerPlayer extends Player{
	private final int HOLD_VALUE = 20;
	
	public ComputerPlayer(){
		super("Computer");
	}
	public boolean isRolling(int opposingScore){
		if((getTurnTotal() < HOLD_VALUE||(getPlayerScore()<=100))||(!(100-opposingScore <=HOLD_VALUE))){
			
			System.out.println((getTurnTotal() < HOLD_VALUE)+""+(getPlayerScore()<=100)+""+(!(100-opposingScore <=HOLD_VALUE)));
			return true;			
		}
		return false;
		/*
		if((getTurnTotal() < HOLD_VALUE)&&!(getPlayerScore()<=100)||!(100-opposingScore <=HOLD_VALUE)){//TODO fix get opponent's score
		//if(getPlayerScore()<=100||100-getTurnTotal() <=HOLD_VALUE){//TODO fix get opponent's score
			System.out.println((getTurnTotal() < HOLD_VALUE)+""+!(getPlayerScore()<=100)+""+(100-opposingScore <=HOLD_VALUE));
			return true;
		}
		
		
		return false;
		*/
	}
	
	
	
	
}
