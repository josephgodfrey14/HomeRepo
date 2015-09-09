/*
 * Name: Joseph Godfrey
 * Date: 11/May/2015
 * Course: CSC212
 * Program: ProgramCh10
 * 
 * Description:  Data type to manage an array list of tiles
 * 
 *
 */

import java.util.*;
import java.awt.*;

public class TileManager {

	// data fields
	ArrayList<Tile> tileList;
	

	// constructor
	public TileManager() {
		tileList = new ArrayList<Tile>();
	}

	// adds a tile to the array list
	public void addTile(Tile rect) {
		tileList.add(rect);
	}

	// draws all tiles in the array list from beginning to end
	public void drawAll(Graphics g) {
		for (int i=0; i<tileList.size()-1; i++){
			tileList.get(i).draw(g);
		}
	}

	// moves the "top most" tile containing the point (x, y)
	// to the end of the array list
	public void raise(int x, int y) {
		for (int i=0; i<=tileList.size()-1; i++){
			if (tileList.get(i).containsPoint(x,y)){
				tileList.add(tileList.size()-1, tileList.get(i));
				tileList.remove(i);
				i=tileList.size();
			}
		}
	}

	// moves the "top most" tile containing the point (x, y)
	// to the beginning of the array list
	public void lower(int x, int y) {
		for (int i=tileList.size()-1; i>=0; i--){
			if (tileList.get(i).containsPoint(x,y)){
				tileList.add(0, tileList.get(i));
				tileList.remove(i+1);
				i=-2;
			}
		}
	}

	// removes the "top most" tile containing the point (x, y)
	// from the array list
	public void delete(int x, int y) {
		for (int i=tileList.size()-1; i>=0; i--){
			if (tileList.get(i).containsPoint(x,y)){
				tileList.remove(i);
				i=-2;
			}
		}
	}

	// removes all tiles containing the point (x, y)
	// from the array List
	public void deleteAll(int x, int y) {
		for (int i=tileList.size()-1; i>=0; i--){
			if (tileList.get(i).containsPoint(x,y)){
				tileList.remove(i);
			}
		}
	}

	// shuffles the tiles in the array list and assigns
	// each to a new random position within the panel
	// with dimension panelWidth, panelHeight
	public void shuffle(int panelWidth, int panelHeight) {
		for (int i=0; i<tileList.size()-1; i++){
			tileList.get(i).setX((int)(Math.random()*(500-tileList.get(i).getX())));
			tileList.get(i).setY((int)(Math.random()*(500-tileList.get(i).getY())));
		}
		Collections.shuffle(tileList);
	}
	
	// sorts the array List using the natural ordering from largest to smallest
	public void sort(){
		Collections.sort(tileList);
	}

	// clears the array List
	public void clear() {
		tileList.clear();
	}

}