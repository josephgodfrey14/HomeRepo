/*
 * Name: Joseph Godfrey
 * Date: 15/Apr/2015
 * Course: CSC212
 * Program: ProgramCh9
 * 
 * Content.java
 * Implements a collection of VideoItems for internet posting.
 
 */

import java.util.GregorianCalendar;

public class Content {

	private String name; // the name of the content
	private VideoItem[] items; // the items

	/*
	/**Creates a Content object with hardcoded items */
	public Content(String name) {
		this.name = name;
		items = new VideoItem[5];
		
		// Temporary Video Items to test the Content Class
		items[0] = new VideoItem("Legally Blonde", "PG-13", 96, 29, new GregorianCalendar(2015, 3, 15),
				7.4, 16);
		
		items[1] = new VideoItem("Birdman", "R", 119, 17, new GregorianCalendar(2015, 3, 20),
				7.8, 10);
		
		items[2] = new VideoItem("If I Stay", "PG-13", 106, 5, new GregorianCalendar(2015, 3, 7),
				6.4, 9);
		
		items[3] = new VideoItem("Boyhood", "R", 164, 17, new GregorianCalendar(2015, 3, 14),
				7.2, 93);
		
		items[4] = new VideoItem("Reba", "G", 60, 29, new GregorianCalendar(2015, 3, 9),
				6, 12);
		
		
		items[0] = new Movie("Amadeus", "PG", 160, 100, new GregorianCalendar(
				2015, 3, 15), 8, 45);
		items[1] = new Movie("Forrest Gump", "PG-13", 142, 45, null,
				8.7, 30); 
		
		int[] sherlockNumEpisodesPerSeason =  {3, 4}; // array of 2 integers, 3 and 3
		TVSeries sherlock = new TVSeries("Sherlock", sherlockNumEpisodesPerSeason);		
		
		items[2] = new Episode(sherlock, 
					"TV-12", 90, 1, 1, "A Study in Pink", 56, new GregorianCalendar(2015, 3, 21), 6, 20);
		items[3] = new Episode(sherlock, "TV-12", 90, 1, 2,				
				"The Blind Banker", 35, new GregorianCalendar(2015, 3, 10), 5.5, 2);
		
		
		items[4] = new Movie("Invictus", "PG-13", 134, 18, new GregorianCalendar(
				2015, 3, 22), 5.5, 3);
		
	}

	/*
	 * returns a short string description of all video items in the Content object
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < items.length; i++) {
			result += items[i].toString() + "\n";
		}
		return result;
	}

	/*
	 * returns an array of all video items
	 */
	
	public VideoItem[] getItems() {
		return items;
	}

	/*
	 * returns the name of the collection of video items
	 */
	public String getName() {
		return name;
	}

	/* code to test the Content class implementation */
	public static void main(String[] args) {
		/*
		Content lib = new Content("Augustana Broadcasting");
		System.out.println(lib);
		System.out.println("\nTop Ranked:");
		System.out.println(lib.topRanked());
		System.out.println("\nFound Item:");
		System.out.println(lib.findVideoItem("stay"));
		*/

	}
	//displays the top ranked video item
	public VideoItem topRanked(){
		int top = 0;
		double topRank = 0.0;
		for (int i=0; i<items.length; i++){
			if (items[i].getRanking()>topRank){
				top = i;
				topRank = items[i].getRanking();
				//System.out.println(top+" - "+topRank);
			}
		}
		return items[top];
	}
	//searches and finds the item with the search string
	public VideoItem findVideoItem(String title){
		for (int i=0; i<items.length-1; i++){	
			if (items[i].toString().toLowerCase().contains(title.toLowerCase())){
				return items[i];
			}
	
		}
		return null;
	}
}
