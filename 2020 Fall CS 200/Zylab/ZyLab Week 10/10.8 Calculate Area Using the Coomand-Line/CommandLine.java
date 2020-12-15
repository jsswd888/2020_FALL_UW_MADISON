///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
//Title:           CommandLine Area Using the Command-Line
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
public class CommandLine
{
    public static void main(String[] args) {
        if(args.length < 1 || args.length > 2){
            System.out.print("usage: java CommandLine.java [squareSide] or java CommandLine.java [rectangleSide1] [rectangleSide2]");
        }else if (args.length == 1){
            for(String arg : args){
                int suqareSide = (int)Math.pow(Integer.parseInt(args[0]), 2);
                System.out.print(suqareSide);
            }
            
        }else{
            int rectangleSide1 = Integer.parseInt(args[0]);
            int rectangleSide2 = Integer.parseInt(args[1]);
            int squareSide = rectangleSide1 * rectangleSide2;
            System.out.print(squareSide);
        }
    }
}