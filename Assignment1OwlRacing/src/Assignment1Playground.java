import java.util.Scanner;

/**
 * The purpose of this class is for you to play around with this
 * code, to learn some new Java features, so you can use them 
 * effectively in the real programming assignment.
 * 
 * You will *NOT* "turn in" this java file -- it's just for experimenting
 * and trying things (which you are encouraged to do!).  
 * In the end, you will just turn in the Assignment1OwlRacing.java file.
 * 
 * @author Wizard Stonedahl
 */
public class Assignment1Playground {

	public static void main(String[] args) {
		// Try out the different methods individually, by 
		// commenting or "un-commenting" the following lines
		
		runScannerExample();
		//printRandomNumberExample();
		//animationExampleWithLoop();
	}

	/** 
	 * Example method to show how to get text input from the user 
	 * and store it in a String variable. 
	 */
	public static void runScannerExample()	{
		Scanner console = new Scanner(System.in);
		System.out.println("Who is your favorite witch/wizard?");
		String favWiz = console.nextLine();
		System.out.println("That's great! I really like "+ favWiz + " too!");
	}
	
	/**
	 * Example method to show you how to generate a random number
	 * that is either 0 or 1.
	 */
	public static void printRandomNumberExample()	{
		// Math.random() generates a number between 0.0 up to 0.999999...
		double betweenZeroAndOne = Math.random();
		// if we multiply that number by 2, we get a number between 0.0 and 1.99999...
		double betweenZeroAndTwo = 2.0 * betweenZeroAndOne;
		// if we "cast" (convert) it to an integer, we get either 0 or 1 (equally likely).
		int zeroOrOne = (int) betweenZeroAndTwo;
		// so about half the times you run it, this prints 0, and the other half 1
		System.out.println("Zero or one? " + zeroOrOne);
		
		
		// BUT, we could also do it all in one short expression, like this!
		System.out.println("Zero or one (again)? " + (int)(2*Math.random()));
	}
	
	/**
	 * Demonstrates how we can create the illusion of animation
	 * by repeatedly printing text on the screen, then pausing a bit,
	 * then printing a bunch of blank lines to scroll the text off
	 * the screen, and then printing some new (but slightly different) 
	 * text where the old text had been. 
	 */
	public static void animationExampleWithLoop() {
		for (int i = 0; i < 30; i++) {
			shortPause();
			printTenBlankLines();
			// print i spaces to shift the "Hi!" to the right.
			for (int j = 0; j < i; j++)	{
				System.out.print(" ");
			}
			System.out.println("Hi!");
		}
	}

	/**
	 *  This static method causes the Java program to 
	 *  wait 0.5 seconds before the program continues running.
	 *  
	 *  NOTE: Don't worry about the fancy incantations inside of this code.
	 *  You do NOT need to modify (or even understand) this method.
	 *  You will just need to call this method by writing:
	 *    shortPause();
	 */
	public static void shortPause() {
		try {
 			Thread.sleep(500); // 500 milliseconds = 0.5 seconds
		} catch (InterruptedException ex) { }
	}
	
	/** This static method prints out ten blank lines.  
	 * This is useful because it scrolls everything that was showing
	 * in the console off the screen, so we can print some new text
	 * where the old text was, and create the illusion of animation!
	 */
	public static void printTenBlankLines() {
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
	}

	
}
