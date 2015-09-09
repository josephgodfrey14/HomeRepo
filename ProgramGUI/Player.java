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

public abstract class Player {
	public int playerScore;
	public int turnTotal;
	public String name;
	
	public Player(String name){
		this.name = name;
		playerScore=0;
		turnTotal=0;
	}
	
	public int getPlayerScore(){
		return playerScore;
	}
	public int getTurnTotal(){
		return turnTotal;
	}
	public String getName(){
		return name;
	}
	
	public void addToTurn(int num){
		turnTotal = turnTotal + num;
	}
	
	public void hold(){
		playerScore=turnTotal;
		
	}
	public void rolledOne(){
		turnTotal=0;
	}
	public void snakeEyes(){
		rolledOne();
		playerScore=0;
	}
}
