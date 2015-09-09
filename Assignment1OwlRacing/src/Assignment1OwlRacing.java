import java.util.Scanner;

/**
 * This program simulates owls racing!
 * 
 * Fill in all of the following information before submitting.
 * 
 * @author Your Name Here
 * @date Today's Date
 * 
 * I was assisted by:  (list persons/sources if applicable) 
 *  (Explain the contribution)
 *   
 * I gave assistance to: (list classmates if applicable)
 *  (Explain how you assisted)
 *   
 * Brief reflection on what you learned from this programming assignment
 *  and whether or not you enjoyed it:
 *   
 *
 */
public class Assignment1OwlRacing {

	
	/**
	 * The main method runs the owl race.
	 * 
	 * NOTE: FOR THIS ASSIGNMENT, you should ONLY need to modify this 
	 * main() method, and nothing else!
	 */
	public static void main(String[] args) {
		// this Scanner object allows us to get input from the user...
		Scanner console = new Scanner(System.in); // <- don't change this line! 
		
		// INSERT some println statements here to welcome the 
		// user to owl racing, and then ask them to type in the name 
		// of the first owl.
		
		// Note: the following statement waits for the user to type in 
		// a line of text, and then assigns whatever string of text
		// the user typed into the variable owlOneName.
		String owlOneName = console.nextLine();  

		// Naturally, you need to tell the user to enter owl #2's name too,
		// and get that name from the console, and store it in a variable.
		
		// This next variable will keep track of how far owl #1 has flown so far.
		// inside the loop below, you will want to keep updating this value
		// by assigning it a new value that is a random amount (either 0 or 1)
		// larger than before.
		int owlOneDistance = 0;

		// Naturally, you'll need to keep track of the other owl's distance too...
		
		
		//Here, you need to put in code to do a FOR loop (60 times), 
		// and each time through the loop, your code should:
		//  * pause for a bit (so the animation doesn't go too fast!)
		//  * print some blank lines to scroll the output window to clear it.
		//  (hint: there are pre-written methods you can call for those last two things!)
		//  * print out the right number of spaces, based on the distance traveled
		//    (you must use a nested/inner FOR loop!)
		//  * then print a bit of ASCII art for the owl (e.g. "[*v*]") followed 
		//     by a single space and then the first owl's name
		//  * Print more spaces (appropriate for owl #2's distance), 
		//     and print ASCII art for the second owl along with its name
		//  * Update the distance variables for owls #1 and #2, by adding
		//    a random # (0 or 1) to each of those variables.
		
		// After the race is all finished, you should print out some text 
		//  telling how far each owl went during the 60 minute race.
		//
		// IF you are shooting for an A+, you will also need to report the
		// name of the owl that won the race, and how many meters it won by.
		// This feature  will require peeking ahead to the "if" statement 
		//    (see the first 1-2 pages of textbook Chapter 4...)
		
	}

	
	/** This static method prints out ten blank lines.  
	 * This is useful because it scrolls everything that was showing
	 * in the console off the screen, so we can print some new text
	 * where the old text was, and create the illusion of animation!
	 * 
	 * NOTE: You do *NOT* need to modify the code in this method.
	 */
	public static void printTenBlankLines() {
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
	}
	
	/**
	 *  This static method causes the Java program to 
	 *  wait 0.5 seconds before the program continues running.
	 *  
	 *  NOTE: Don't worry about the fancy incantations inside of this code.
	 *  You do NOT need to modify (or even understand) this method.
	 *  You will just need to call this method from inside main by writing:
	 *    shortPause();
	 */
	public static void shortPause() {
		try {
 			Thread.sleep(500); // 500 milliseconds = 0.5 seconds
		} catch (InterruptedException ex) { }
	}

}
