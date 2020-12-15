///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
//Title:           Grade Analyzer
//Course:          CS200 Fall 2020
//
//Author:          Shi Kaiwen
//Email:           kshi42@wisc.edu
//Lecturer's Name: Mark Renault & Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
//Source or Recipient; Description
//Examples:
//Jane Doe; helped me with for loop in reverse method
//https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html; 
//counting for loop
//John Doe; I helped with switch statement in main method.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;

public class GradeAnalyzer {

	/**
	 * This method first generates a random number between 0 and 100 (both inclusive),
	 * and then append this generated number at the end of the ArrayList grades.
	 * 
	 * Note: If either of the parameters is null, just return.
	 * 
	 * @param grades the ArrayList of all students' grades
	 * @param rand a random generator to generate grades
	 */
	public static void addGrade(ArrayList<Integer> grades, Random rand) {
		if(grades == null || rand == null){
			return;
		}

		int generatedNum = rand.nextInt(101);
		grades.add(generatedNum);

	}
	
	/**
	 * This method searches for the highest score in the ArrayList.
	 * 
	 * @param grades the ArrayList of scores to be searched from
	 * @return the maximum element in the ArrayList; -1 if it is null;
	 *         or 0 if the ArrayList is empty.
	 */
	public static int findMaxScore(ArrayList<Integer> grades) {
		if(grades == null){
			return -1;
		}

		if (grades.isEmpty()) {
			return 0;
		}

		//int highestScore = Collections.max(grades);
		int highestScore = 0;
		
		for (int i = 0; i < grades.size(); ++i) {
			if(grades.get(i) > highestScore){
				highestScore = grades.get(i);
			}
		}
		
		return highestScore;
		
	}
	
	/**
	 * This method calculates an average over all the scores in the ArrayList.
	 * 
	 * Note: The return value should include decimals.
	 * Make sure to use double division instead of integer division.
	 * 
	 * @param grades the ArrayList of all scores
	 * @return the average over all the elements in the ArrayList;
	 *         -1 if the ArrayList is null or empty;
	 */
	public static double calcAverageScore(ArrayList<Integer> grades) {
		if (grades == null || grades.isEmpty()) {
			return -1;
		}

		double sum = 0;
		for(int i = 0; i < grades.size(); ++i){
			sum += grades.get(i);
		}
		
		return sum / grades.size();
	}
	
	/**
	 * This method calculates the percentage of students whose grades are greater than or equal to
	 * a certain threshold. E.g.:
	 *     if grades = [1, 2, 3, 4, 5]
	 *     and threshold = 4
	 *     the return value should be 40.0 (because 4, 5 are above threshold; 2 / 5 = 40%)
	 * @param grades the ArrayList of all students' grades
	 * @param threshold  a specific number to compare with
	 * @return a percentage in the range of [0, 100]; or -1 if the ArrayList is null or empty.
	 */
	public static double calcPercentageAbove(ArrayList<Integer> grades, int threshold) {
		double gradesHigherThanThreshold = 0;
		
		if (grades == null || grades.isEmpty()) {
			return -1;
		}
		for(int i = 0; i < grades.size(); i++){
			if(grades.get(i) >= threshold){
				gradesHigherThanThreshold += 1;
			}
		}

		double percentageAbove = gradesHigherThanThreshold / grades.size() * 100;
		return percentageAbove;
		
	}
	
	/**
	 * This method finds out all the students in the ArrayList with a certain grade,
	 * and stores their indices into a new ArrayList as return value.
	 * 
	 * @param grades the ArrayList of all students' grades
	 * @param gradeToFind a specific grade to be found in the ArrayList
	 * @return an ArrayList of found indices in ascending order; or null if grades is null
	 */
	public static ArrayList<Integer> findStudentsWithGrade(ArrayList<Integer> grades, int gradeToFind) {
		if(grades == null){
			return null;
		}

		ArrayList<Integer> allWantedScores = new ArrayList<Integer>();

		for(int i = 0; i < grades.size(); i++){
			if(gradeToFind == grades.get(i)){
				allWantedScores.add(i);
			}
		}

		
		
		return allWantedScores;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> grades = new ArrayList<Integer>();
		Random rand = new Random(Config.SEED);
		for (int i = 0; i < Config.NUM_STUDENTS; i++)
			addGrade(grades, rand);

		int maxScore = findMaxScore(grades);
		System.out.println("The highest score in this class is: " + maxScore);
		
		double aveScore = calcAverageScore(grades);
		System.out.println("The average score in this class is: " + aveScore);
		
		double passingRate = calcPercentageAbove(grades, 60);
		System.out.println("The percentage of students above 60 is: " + passingRate + "%");
		
		ArrayList<Integer> studentIndices = findStudentsWithGrade(grades, 100);
		System.out.println("Here are the IDs of students who got full marks: " + studentIndices);

	}

}
