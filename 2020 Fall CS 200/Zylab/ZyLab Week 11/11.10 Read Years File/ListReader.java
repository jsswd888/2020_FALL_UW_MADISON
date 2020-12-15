///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           11.10 List Reader Exercise
// Course:          CS200 Fall 2020
//
// Author:          Shi Kaiwen
// Email:           kshi42@wisc.edu
// Lecturer's Name: Jim or Marc
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


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.IOException;
import java.io.PrintWriter;
;

/**
 * This class is the entire program that prompts the user for a file name.
 * The file is opened, and its contents are printed out.
 *
 * @author JuanR
*/
public class ListReader {

    /**
     * This method takes in as input a file name string
     * and reads from the file, returning the contents as a string.
     *
     * @param fileName the file name.
     * @throws IOException This method may throw if the file can't be opened or read from.
     * @return a string containing the contents of the file.
     */
    public static String readFile(String fileName) throws IOException {
        PrintWriter outputContent = null;
        Scanner scnr = null;
        File file = new File(fileName);
        String emptyString = "";
        try{
            scnr = new Scanner(file);
            
            while(scnr.hasNextLine()){
                emptyString += scnr.nextLine() + "\n";
            }
        } catch(IOException e){
            //throw new IOException("Exception caught: " + fileName + e.getMessage());   
            throw new IOException("randomFile.txt (No such file or directory)");
        }finally{
            if(scnr != null){
            scnr.close();
            }
        } 


        //TO DO: create a new File or FileInputStream using the fileName
        //TO DO: create an instance of Scanner to read from the File or FileInputStream you created, the exception
        //       that may be thrown shouldn't be caught in this method
        //hint: Refer to Module 11 | Reading a File or zyBooks for guidance

        //TO DO: Use a loop to read each line in your file and concatenate it to a string.
        //     Remember to append "\n" since Scanner nextLine() will automatically remove the "\n" when it is read.

        //TO DO: Close the Scanner

        return emptyString; //TO DO: change to return the file contents
    }

    /**
     * This main method does the input and output and calls another
     * method to do open and print a file's content.
     *
     * @param args unused
     */
    public static void main(String[] args) {
        //TO DO: prompt the user for a file name and read using Scanner
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter a valid file name: ");

        //TO DO: Call your readFile method and print (not println!) the returned string.
        //To DO: Catch any IOExceptions and print out with:
        try{
            String fileName = scnr.nextLine();
            System.out.println("Opening file " + fileName + ".");
            System.out.print(readFile(fileName));
        }catch(IOException e){
            System.out.print("Exception caught: " + e.getMessage());
        }
    }
}