///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           11.8 Grocery File
// Course:          CS 200 Fall 2020
//
// Author:          Shi Kaiwen
// Email:           kshi42@wisc.edu email address
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

import java.io.PrintWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

//import sun.tools.tree.FinallyStatement;

public class GroceryFile {
    public static void main(String[] args) {
        ArrayList<Integer> amounts = new ArrayList<>(
                Arrays.asList(2,4,8,30,6,10,3,2,1));
        ArrayList<String> items = new ArrayList<>(
                Arrays.asList("onions","green peppers","diet coke", "eggs",
                        "garlic", "yogurt","lemons","milk", "cheese"));
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a file name: ");
        String fileName = scan.nextLine();

        //TODO: call the makeGroceryFile method and catch and print an exception that may be thrown with:
        //                 System.out.print("Caught FileNotFoundException: " + e.getMessage());
        try{
            makeGroceryFile(fileName, amounts, items);
        }catch(FileNotFoundException e){
            System.out.print("Caught FileNotFoundException: " + e.getMessage());
        }
    }

    /**
     * Opens a file and writes the grocery list inside using a PrintWriter
     * @param fileName the name of the file to be created
     * @param amounts the amount of each item in the grocery list
     * @param items the name of the products in the grocery list
     * @throws FileNotFoundException if unable to open fileName to write
     */
    public static void makeGroceryFile(String fileName, 
                                        ArrayList<Integer> amounts, ArrayList<String> items) throws FileNotFoundException {
        
        PrintWriter outFS = new PrintWriter(fileName);
        //FileInputStream fileStream = new FileInputStream(fileName);
        
        try {
            //outFS = new PrintWriter(fileName);
            
            for (int i = 0; i < amounts.size(); i++) {
                outFS.println(amounts.get(i) + " " + items.get(i));
                }
            
        } finally{
            if(outFS != null){
                //fileStream.close();
                outFS.close();
            }
        }                               
    }
}
