/** Program: Lab 5, Cumulative Loops and Conditionals
 *  Goal: Adding/counting/averaging Potions Test Scores  
 * 
 *  Author:
 *  Date:  
 */
import java.util.*;

public class HouseScores {

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		System.out.println("How many students took the Potions exam?");
		int numStudents = console.nextInt();
		System.out.println("Which house would you like to evaluate?");
		String houseName = console.next();
		System.out.println("Please enter scores in the format <First name> <House> <Score> for every student.");
		
		
		int sumScores = 0;
		int highestScore = 0;
		int numHouseStuds = 0;
		int numStudsFailed = 0;
		double avgScore = 0;
		String hiScorer = "a";
						
		for (int i=0; i < numStudents; i++) {
			String student = console.next();
			String studHouse = console.next();
			int studScore = console.nextInt();
			
			if (studHouse.equals(houseName)) {
				numHouseStuds = numHouseStuds + 1;
				sumScores = sumScores + studScore;
				
				if (studScore > highestScore) {
					highestScore = studScore;
					hiScorer = student;
				}
				if (studScore < 60) {
					numStudsFailed = numStudsFailed + 1;
				}
			}
			if (i == numStudents - 1){
				
				System.out.println();
				avgScore = (double)sumScores / (double)numHouseStuds;
				System.out.println("Thank you. Here are the results:");
				System.out.println("# of " + houseName + " students: " + numHouseStuds);
				System.out.println(houseName + "'s highest score was: " + highestScore);
				System.out.printf("%s's average score was: %.2f\n", houseName, avgScore);
				System.out.println("Average score letter grade: " + avgGrade(avgScore));
				System.out.println("# of " + houseName + " students who failed the exam (<60): "+ numStudsFailed);
				System.out.println("The highest score belonged to: " + hiScorer );
			}
			
			
		}
		
	}
	public static String avgGrade(double x) {
		String grade = "n";
		if (x >= 90){
			grade = "A";
		} else if (x >= 80){
			grade = "B";
		} else if (x >= 70){
			grade = "C";
		} else if (x >= 60){
			grade = "D";
		} else {
			grade = "F";
		}
		return grade;
			
		
	}
	
}
