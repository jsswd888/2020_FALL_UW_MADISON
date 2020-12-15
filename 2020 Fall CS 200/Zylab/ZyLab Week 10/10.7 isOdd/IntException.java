//TODO: remember your header 
///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
//Title:           Int Exception
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
import java.util.Scanner;
import java.util.InputMismatchException;


public class IntException {
   public static void main(String[] args) {
      System.out.print(isOdd());
   }
   
   //TODO: comment your code
   public static boolean isOdd() {
        //TODO: initialize Scanner object
        //TODO: try-catch block which catches incorrect input
        Scanner scnr = new Scanner(System.in);
        Boolean isOdd = true;

        try {
            int numberInput = scnr.nextInt();
            if (Math.abs(numberInput) % 2 == 1) {
                return isOdd; 
            }else {
                return !isOdd;
            }
        } catch (InputMismatchException e) {
            return false;
        } 

    }
}
