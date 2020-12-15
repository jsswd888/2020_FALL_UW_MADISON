///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
//Title:           Array List Fun
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
import java.util.ArrayList;
import java.lang.Math;
import java.util.Collection;

public class ArrayListFun {
   
   /**
	 * Counts the number of instances of a particular value in list.
	 * Returns null if list is null.
	 * 
	 * @param list
	 * @param checkNum
	 * @return the number of Integer occurrences in list equal to checkNum
	 */
	public static Integer countOccurrences(ArrayList<Integer> list, int checkNum) {
		// TODO: FILL IN BODY
		int counter = 0;
		if(list == null){
			return null;
		}
		for(int i = 0; i < list.size(); i++){
			if(checkNum == list.get(i)){
				counter++;
			}
		}
		return counter;
	}
	
	/**
	 * Calculates the sum, product, or mean of all values in list.
	 * Returns null if list is null.
	 * 
	 * @param list
	 * @param operation
	 * @return the sum, product, or mean of all values in list
	 */
	public static Integer mathOperation(ArrayList<Integer> list, String operation) {
		// TODO: FILL IN BODY
		if(list == null){
			return null;
		}

		int mean;
		int finalValue = 0;
		for(int i = 0; i < list.size(); i++){
			if(operation.equals("add") || operation.equals("mean")){
				finalValue += list.get(i);
			}

			if(operation.equals("product")){
				finalValue *= list.get(i);
			}
		}
		
		if(operation.equals("mean")){
			mean = finalValue / list.size();
			finalValue = mean;
		}
		return finalValue;
		
	}
	
	/**
	 * Converts the 1s and 0s in list (binary value) to its decimal value
	 * 
	 * Example: 100110 from binary to decimal
	 * 
	 * 1 * 2^5 +
	 * 0 * 2^4 +
	 * 0 * 2^3 +
	 * 1 * 2^2 +
	 * 1 * 2^1 +
	 * 0 * 2^0 =
	 * 38
	 * 
	 * For more information on binary, see zyBooks chapter 3.1
	 * 
	 * Returns null if list is null.
	 * 
	 * @param list
	 * @return the decimal value of the binary representation of list
	 */
	public static Integer binaryToDecimal(ArrayList<Integer> list) {
		// TODO: FILL IN BODY
		if(list == null){
			return null;	
		}
		int convertedNum = 0;

		for(int i = 0; i < list.size(); i++){
			convertedNum += list.get(i) * (int)Math.pow(2, list.size() - (i + 1)); 
		}

		return convertedNum;
	}
	
	/**
	 * Returns true if list is a (character) palindrome.
	 * Returns null if list is null.
	 * 
	 * @param list
	 * @return true if the list is a palindrome, else false. 
	 */
	public static Boolean isPalindrome(ArrayList<Character> list) {
		// TODO: FILL IN BODY
		Boolean isPalindrome = false;
		if(list == null){
			return null;
		}

		for(int i = 0; i < list.size() / 2; i++){
			if(!list.get(i).equals(list.get(list.size()- (1 + i)))){
				return isPalindrome;
			}
		}
		return !isPalindrome;
	}
	
	public static void main(String[] args) {
		// TODO: FILL IN BODY
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(0);
		list.add(5);
		list.add(2);
		list.add(2);
		list.add(1);
		list.add(1);

		//TEST countOccurences method
		for(int checkingNum = 2; checkingNum <= 3; checkingNum++){
			int occurrences = countOccurrences(list, checkingNum);
			System.out.println(occurrences);
		}
		/*Alternate method:
		int checkingNum = 2;
		int occurrences = countOccurrences(list, checkingNum);
		
		System.out.println(occurrences);
		checkingNum = 3;
		occurrences = countOccurrences(list, checkingNum);
		System.out.println(occurrences);
		*/

		//TEST mathOperation method
		String operation = "add";
		int result = mathOperation(list, operation);
		System.out.println(result);

		operation = "multiply";
		result = mathOperation(list, operation);
		System.out.println(result);

		operation = "mean";
		result = mathOperation(list, operation);
		System.out.println(result);

		//clear Arraylist
		list.clear();

		//TEST binaryToDecimal method
		list.add(1);
		list.add(0);
		list.add(0);
		list.add(1);
		list.add(1);
		
		//test 1
		int binaryToDeciConvert = binaryToDecimal(list);
		System.out.println(binaryToDeciConvert);

		//test 2
		list.add(1);
		binaryToDeciConvert = binaryToDecimal(list);
		System.out.println(binaryToDeciConvert);


		//test isPalindrome method
		//firstly, clear the list
		list.clear();

		//test 1: add first word into list
		ArrayList<Character> characterList = new ArrayList<Character>();
		characterList.add('r');
		characterList.add('a');
		characterList.add('d');
		characterList.add('a');
		characterList.add('r');

		Boolean isPalindromeOrNot = isPalindrome(characterList);
		System.out.println(isPalindromeOrNot);

		//start test 2, firstly clear list
		characterList.clear();
		
		characterList.add('j');
		characterList.add('a');
		characterList.add('v');
		characterList.add('a');

		isPalindromeOrNot = isPalindrome(characterList);
		System.out.println(isPalindromeOrNot);


		
	}
}