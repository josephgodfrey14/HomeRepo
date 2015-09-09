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

import javax.swing.JOptionPane;

public class Episode extends VideoItem {
	//fields
	private TVSeries series;
	private int episodeNumber;
	private int seasonNumber;
	
	public Episode(TVSeries series, String rating, int lengthMin,
			int seasonNumber, int episodeNumber, String title,
			int numDownloads, GregorianCalendar availableUntil, double ranking,
			int numResponses) {
		super(title, rating, lengthMin, numDownloads, availableUntil, ranking,
				numResponses);
		this.series = series;
		this.episodeNumber = episodeNumber;
		this.seasonNumber = seasonNumber;
	}
	//returns episode number
	public int getEpisodeNum() {
		return episodeNumber;
	}
	//returns the series 
	public TVSeries getSeries() {
		return series;
	}
	//returns the series number
	public int getSeason() {
		return seasonNumber;
	}
	//returns how many episodes are left
	public int episodesLeftThisSeason(){
		return (series.getNumEpisodesInSeason(getSeason())-1-getEpisodeNum()-1);
	}
	//string adaptation of this class
	public String toString() {
		return ("\"" + getSeries() + "\" Season " + getSeason() + ", Episode: "
				+ getEpisodeNum() + " expires " + VideoItem.df
					.format(getAvailableUntil().getTime()));
	}
	//sets the initial rating
	public void setRating(String newRating){
		if (newRating.equals("TV-MA")||newRating.equals("TV-14")||newRating.equals("TV-PG")||newRating.equals("TV-G")){
			super.setRating(newRating);
		}else{
			super.setRating("TV-G");
		}
	}
	//returns the full title of an episode
	public String getFullTitle(){
		return ("\"" + getSeries() + "\" Season " + getSeason() + ", Episode: "
				+ getEpisodeNum() + ", "+getTitle() );
	}
	//returns all of the item's details
	public String getItemDetails() {
		String text = "";
		text += ("\n\""+series.getTitle()+"\"" );
		text += ("\nSeason " + getSeason()+", Episode "+getEpisodeNum());
		text += ("\n\"" + getTitle()+"\"");
		text += ("\n"+rankingString());
		text += ("\n\trated: " + getRating());
		text += ("\n\tlength: " + getLengthMin());
		text += ("\n\tdownloads: " + getNumDownloads());
		text += ("\n\texpires: " + VideoItem.df.format(getAvailableUntil().getTime()));
		return text;
	}
	//returns if there are more episodes left in the season and adds one to the download count
	public void download(){
		if (episodesLeftThisSeason() > 0){
			JOptionPane.showMessageDialog(null, "There are "+episodesLeftThisSeason()+" episodes left in this season.");
		}else{
			JOptionPane.showMessageDialog(null, "There are no more episodes left in this season.");
		}
		super.download();
	}
	
	//main method
	public static void main(String[] args) {
		/*
		  int[] episodes = { 5, 3, 6 }; TVSeries series1 = new TVSeries("Rome",
		  episodes); Episode episode1 = new Episode(series1, "TV-G", 60, 1, 1,
		  "The Stolen Eagle", 23, new GregorianCalendar(2015, 3, 20), 8, 44);
		//System.out.println(episode1.getItemDetails());
		//episode1.download();
		 */
	}

}
