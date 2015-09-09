/*
 * Name: Joseph Godfrey
 * Date: 15/Apr/2015
 * Course: CSC212
 * Program: ProgramCh9
 * 
 * VideoItem class - represents a video content item for internet posting.
 * Includes attributes common to movies and episodes.
 */

import java.text.SimpleDateFormat;
import java.util.*;

public class VideoItem {

	// maximum ranking value
	public final static int MAX_RANKING = 10;

	// format string used in convert a Gregorian Calendar date into a String
	public final static SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");

	private String title;
	private int lengthMin;
	private String rating; // "R", "G", etc for movies, "TV-12", "TV-7", etc for
							// series
	private GregorianCalendar availableUntil; // date until which the item is
												// posted.
	private int numDownloads;
	private double ranking;
	private int numResponses;

	/*
	 * Constructor for a video item - create an item corresponding to the
	 * parameters passed IF the date parameter is null, assigned the
	 * avilableUntil date to the current date.
	 */
	public VideoItem(String title, String rating, int length, int numDownloads,
			GregorianCalendar date, double ranking, int responders) {

		this.title = title;
		this.setRating(rating);
		this.lengthMin = length;
		this.numDownloads = numDownloads;
		if (date == null) { // no expiry date specified
			this.availableUntil = new GregorianCalendar(); // so create a date
															// object with the
															// current date/time
		} else {
			this.availableUntil = date;
		}
		setRanking(ranking, responders);
		

	}

	
	/*
	 * increments the numDownloads counter of the item by 1
	 */
	public void download() {
		numDownloads++;
	}

	/*
	 * returns a string describing the title,
	 * including the series and the episode title.
	 */
	public String getFullTitle() {
		return ("\"" + title + "\"");
		
	}
	
	/*
	 * returns the details of the item, not including the title
	 */
	public String getItemDetails() {
		String text = "";
		text += rankingString();
		text += "\n\trated: " + rating;
		text += "\n\tlength: " + lengthMin;
		text += "\n\tdownloads: " + numDownloads;
		text += "\n\texpires: " + df.format(availableUntil.getTime());
		return text;
	}

	/*
	 * returns a string of stars equivalent to the rank (to nearest whole number)
	 */
	public String rankingString() {
		String stars = "";
		for (int i = 1; i <= MAX_RANKING; i++) {
			if (i <= Math.round(ranking))
				stars += "*";
			else
				stars += " ";
		}
		stars += "(" + Math.round(ranking) + "/" + MAX_RANKING + ") based on "
				+ numResponses;
		if (numResponses == 1) {
			stars += " response";
		} else {
			stars += " responses";
		}
		return stars;
	}

	/*
	 * returns the title of the Video Item
	 */
	public String getTitle() {
		return this.title;
	}

	/*
	 * returns the rating (PG, etc.) for the Video Item
	 */
	public String getRating() {
		return rating;
	}

	/*
	 * returns the date until the Video Item can no longer be downloaded
	 */
	public GregorianCalendar getAvailableUntil() {
		return availableUntil;
	}

	/*
	 * returns the length of the Video Item in minutes
	 */
	public int getLengthMin() {
		return lengthMin;
	}

	/*
	 *returns the number of times the Video Item has been downloaded
	 */
	public int getNumDownloads() {
		return numDownloads;
	}

	/*
	 * sets the rating (PG, etc) for the video item
	 */
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	/*
	 * sets the date the video item is available for downloading
	 */
	public void setAvailableUntil(GregorianCalendar availableUntil) {
		this.availableUntil = availableUntil;
	}
	
	/* returns the ranking of a video item on a 1-10 scale */
	public double getRanking() {
		return this.ranking;
	}

	/* returns a String representation of the Video Item */
	public String toString() {
		String str = "Video Item: \"" + title + "\" ranking "
				+ ranking;
		return str;

	}

	public static void main(String[] args) {
		/*
		VideoItem item1 = new VideoItem("Forrest Gump", "PG-13", 142, 45,
				new GregorianCalendar(2015, 3, 9), 8, 12);
		VideoItem item2 = new VideoItem("The Prestige", "PG-13", 142, 45,
				new GregorianCalendar(2015, 8, 9), 4, 4);
		VideoItem item3 = new VideoItem("The Phantom of the Opera", "PG-13", 142, 45,
				new GregorianCalendar(2013, 1, 1), 10, 7);
		
		System.out.println(item1 +"\n"+ item2 +"\n"+ item3);
		*/
	}
	//sets the initial ranking
	public void setRanking(double rank, int responses){
		if (rank >= MAX_RANKING || rank <= 0){
			rank = 0;
		}else{
			this.ranking = rank;
		}
		if (responses< 0){
			responses = 0;
		}else{
			this.numResponses = responses;
		}
		
		
	}
	//adds & processes another ranking to the total
	public void processAnotherRanking(int addtlRank){
		if (addtlRank > MAX_RANKING || addtlRank < 0){
			//do nothing
			System.out.print("");
		}else{
			this.ranking = ((ranking*numResponses + addtlRank)/(numResponses+1));
			numResponses++;
		}
	}
	//determines if this video is downloadable
	public boolean isAvailableForDownload(){
		GregorianCalendar today = new GregorianCalendar();
		if (today.get(GregorianCalendar.YEAR)>availableUntil.get(GregorianCalendar.YEAR)||
			today.get(GregorianCalendar.MONTH)>availableUntil.get(GregorianCalendar.MONTH)||
			today.get(GregorianCalendar.DATE)>availableUntil.get(GregorianCalendar.DATE)){
			return false;
		}else{
			return true;
		}
	}

}
