/*
 * Name: Joseph Godfrey
 * Date: 15/Apr/2015
 * Course: CSC212
 * Program: ProgramCh9
 * 
 * Description: creates & maintains objects of 'TVSeries' type
 * 
 */


public class TVSeries{

	private String title;
	private int[] numEpisodesInSeason;
	
	
	public TVSeries(String title, int[] numEpisodesInSeason){
		this.title = title;
		this.numEpisodesInSeason = numEpisodesInSeason;
	}
	//returns the string of the title
	public String getTitle(){
		return title;
	}
	//returns the number of seasons
	public int getNumSeasons(){
		return numEpisodesInSeason.length;
	}
	//returns the number of episodes in the season
	public int getNumEpisodesInSeason(int seasNum){
		if (seasNum>numEpisodesInSeason.length||seasNum<0){
			return 0;
		}else{
			return (numEpisodesInSeason[seasNum-1]);
		}
	}
	//returns the string interpretation of this class
	public String toString(){/*
		String returnedString = "";
		for (int i=0; i<numEpisodesInSeason.length; i++){
			if (i==0){
				returnedString=returnedString+(title + " TV Series\n");
			}
			returnedString=returnedString+("\tSeason "+ (i+1) + " has " +  getNumEpisodesInSeason(i+1) +" episodes.\n");
		}
		
		return returnedString;
		*/
		return (""+ title);
		
	}
	
	//main method (for testing)
	public static void main(String[] args) {
		/*
		int[] episodes = {12, 10 };
		TVSeries item1 = new TVSeries("Rome", episodes);
		System.out.println(item1);
		
		int[] episodes2 = {8, 10, 12, 12, 13, 15, 10, 8 };
		TVSeries item2 = new TVSeries("IDK", episodes2);
		System.out.println(item2);
		*/

	}

}
