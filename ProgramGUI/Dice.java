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

public class Dice {
	private int[] dice;
	
	public Dice(){
		dice = new int[2];
		dice[0]= (int)Math.random()*6;
		dice[1]= (int)Math.random()*6;
	}
	
	public int[] getRoll(){
		dice[0]= (int)(Math.random()*6);
		dice[1]= (int)(Math.random()*6);
		
		return dice;
	}
	public int getSum(){
		if(dice[0]==0||dice[1]==0){//0 for 1
			if(dice[0]==0&&dice[1]==0){
				return -1;
			}
			return 0;	
		}
		return (dice[0]+1 + dice[1]+1);
	}
}
