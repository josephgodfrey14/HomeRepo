/*
 * Name: Joseph Godfrey
 * Date: 13/Mar/2015
 * Course: CSC 212
 * Program: Lab Ch7A
 * 
 * Purpose: This program allows a user to enter a series
 * of quiz scores, outputs the list of scores, calculates
 * the average with and without the high and low scores,
 * allows the user to enter a number of points to add to
 * each score (maximum score is 100), and finally outputs
 * the adjusted scores and corresponding averages.
 */

import java.util.*;
import java.text.*;

public class Scores {

	public static final int MAX_SCORE = 100;

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		double averageScore;
		int[] scores = inputScores(console);
		DecimalFormat df = new DecimalFormat("#.00");

		System.out.println("\nThe scores entered were:");
		printArray(scores);

		averageScore = average(scores);
		System.out.println("\nThe average is " + df.format(averageScore));

		averageScore = averageWithoutHighLow(scores);
		System.out.println("The average without the high and low scores is "
				+ df.format(averageScore));

		addPoints(console, scores);
		System.out.println("\nThe updated scores are:");
		printArray(scores);
		
		averageScore = average(scores);
		System.out.println("\nThe average is " + df.format(averageScore));

		averageScore = averageWithoutHighLow(scores);
		System.out.println("The average without the high and low scores is "
				+ df.format(averageScore));
	}

	/*
	 * This method accepts a Scanner object to facilitate keyboard input. It
	 * prompts the use to enter the number of scores that will be entered and
	 * prompts the user to enter each score. It returns an array of the entered
	 * scores.
	 */
	public static int[] inputScores(Scanner console) {

		System.out.print("How many scores?");
		int numScores = console.nextInt();
		int[] scores = new int[numScores];

		for (int i = 0; i < numScores; i++) {
			System.out.print("Score " + (i + 1) + ":");
			scores[i] = console.nextInt();
		}

		return scores;
	}

	/*
	 * This method displays the values stored in the scores array
	 */
	public static void printArray(int[] array) {

		for (int i = 1; i < array.length + 1; i++) {
			System.out.println("[" + (i - 1) + "] " + array[i - 1]);
		}

	}

	// computes the average score without accounting for the highest and lowest
	// score
	public static double averageWithoutHighLow(int[] array) {
		if (array.length < 2) {
			System.out
					.println("Minimum of 3 scores needed to disregard the high and low scores.");
			return 0.0;
		}
		int total = array[0];
		int highest = array[0];
		int lowest = array[0];

		for (int i=1; i< array.length; i++) {  //TODO
			total = total + array[i];
			if (array[i] > highest) {
				highest = array[i];
			}
			if (array[i] < lowest) {
				lowest = array[i];
			}
		}
		total = total - highest - lowest;
		double dubTotal = (double)total;
		double average = dubTotal / (array.length - 2);

		return average;
	}

	// this method adds an entered number of points to every score
	public static void addPoints(Scanner console, int[] array) {
		// System.out.println();
		System.out.print("\nHow many points to add");
		int addNum = console.nextInt();

		for (int i = 0; i < array.length; i++) {
			array[i] = array[i] + addNum;
			if (array[i] > MAX_SCORE) {
				array[i] = MAX_SCORE;
			}
		}

	}

	/*
	 * This method accepts an array of integers as a parameter. It sends back
	 * the average of those integers as a double.
	 */
	public static double average(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int sum = 0;
		for (int num : array) {
			sum = sum + num;
		}
		return (double) sum / array.length;
	}
}
