///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           11.9 Hello File
// Course:          CS 200 Fall 2020
//
// Author:          Shi kaiwen
// Email:           kshi42@wisc.edu email address
// Lecturer's Name: name of your lecturer
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

import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class HelloFile {
    public static void main(String[] args) {
        // TODO: Create a PrintWriter
        // TODO: Get user input using Scanner
        // TODO: Write valid user input to the PrintWriter, catch any exceptions
        System.out.println("Enter the file name:" );
        Scanner scnr = new Scanner(System.in);
        String fileName = scnr.nextLine();
        File file = new File(fileName);
        PrintWriter ptWriter = null;

        try{
            ptWriter = new PrintWriter(file);
            String fileContent = "";
            do{
            System.out.println("Enter something to write in " + fileName + ":");
            fileContent = scnr.nextLine().trim();
            } while(fileContent.isEmpty());//{
                //System.out.println("Enter somethingg to write in "+ fileName + ":");
                //String fileContent = scnr.nextLine().trim();
            //}
            ptWriter.print(fileContent);
        } catch(IOException e){
            System.out.println("Exception occurred: PrintWriter failed");
        } finally{
            if(ptWriter != null){ 
               ptWriter.close();
            }
        }
        
    }
}