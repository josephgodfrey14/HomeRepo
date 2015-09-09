/*
 * Name: Joseph Godfrey
 * Date: 15/Apr/2015
 * Course: CSC212
 * Program: ProgramCh9
 * 
 * Description:
 * 
 */

import java.util.*;

public class Movie extends VideoItem {

	public Movie(String title, String rating, int lengthMin, int numDownloads,
			GregorianCalendar availableUntil, double ranking, int numResponses) {
		super(title, rating, lengthMin, numDownloads, availableUntil, ranking,
				numResponses);
	}
	//returns string interpretation of this class
	public String toString() {
		return ("\"" + getTitle() + "\" expires " + VideoItem.df
				.format(getAvailableUntil().getTime()));
	}
	//sets the initial ranking
	public void setRating(String newRating){
		if (newRating.equals("G")||newRating.equals("PG")||newRating.equals("PG-13")||newRating.equals("R")){
			super.setRating(newRating);
		}else{
			super.setRating("G");
		}
	}
	//returns the item's full details
	public String getItemDetails(){
		String returnedText = "";
		returnedText = returnedText + ("\n\""+getTitle() + "\"");
		returnedText = returnedText + ("\n"+rankingString());
		returnedText = returnedText + ("\n\trated: " + getRating());
		returnedText = returnedText + ("\n\tlength: " + getLengthMin());
		returnedText = returnedText + ("\n\tdownloads: " + getNumDownloads());
		returnedText = returnedText + ("\n\texpires: " + VideoItem.df.format(getAvailableUntil().getTime()));
		return returnedText;
	}
	//main method (for testing)
	public static void main(String[] args) {
		/*
		 Movie movie1 = new Movie("Fantastic Mr. Fox", "G", 115, 412, new
		 GregorianCalendar( 2015, 3, 19), 7, 87);
		System.out.println(movie1);
		System.out.println(movie1.getItemDetails());
		 */
	}

}
