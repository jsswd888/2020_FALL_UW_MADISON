///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Print Ragged Array
// Course:          CS 200 FA 20
//
// Author:          Shi Kaiwen
// Email:           kshi42@wisc.edu
// Lecturer's Name: Marc Renault
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// Source or Recipient; Description
// Examples:
// Jane Doe; helped me with for loop in reverse method
// https://docs.oracle.com/javase/tutorial/java/nutsandbolts/for.html; 
//         counting for loop
// John Doe; I helped with switch statement in main method.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////
public class PrintArray{
    public static void print(int[][] list){
        //TODO: Print out list with sum at the end of each row
        int sum = 0;
        for(int i = 0; i < list.length; i++){
			for(int j = 0; j < list[i].length;j++){
                sum += list[i][j];
                System.out.print(list[i][j]+" ");
            }
            System.out.print(sum);
            sum = 0;
            System.out.println();
        }
    }
}
