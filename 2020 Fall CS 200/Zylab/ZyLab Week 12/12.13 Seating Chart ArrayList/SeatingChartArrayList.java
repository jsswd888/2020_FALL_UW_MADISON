///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
//Title:           Seating Chart
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
import java.util.Random;
import java.util.Scanner;

public class SeatingChartArrayList {

    /** The main method should prompt the user to input two numbers
     * corresponding to the row and column of their seat choice. This choice
     * is then compared to the initial seating chart and updated if the seat
     * is available. Then user is then informed of the result (whether the
     * seat is successfully reserved or already taken).
     */
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        //You may assume the seating chart is rectangular and at least 1x1
        ArrayList<ArrayList<Character>> seating = getSeatingChart();

        int userRow = 0;
        int userColumn = 0;

        //Print seating chart.
        System.out.println("Welcome to seat selector.\n");
        System.out.print( printChart(seating) );

        //Prompt user for inputs.
        System.out.println("Please select a row (1-" + seating.size() + "): ");
        userRow = scnr.nextInt();

        System.out.println("Please select a column (1-" + seating.get(0).size() + "): ");
        userColumn = scnr.nextInt();

        //Check user's inputs against seating chart.
        if(seating.get(userRow-1).get(userColumn-1) == ' ') {
            System.out.println("Seat " + userRow + "," + userColumn + " is now reserved.");
            seating.get(userRow-1).set(userColumn-1, 'x');
        }
        else {
            System.out.println("Seat " + userRow + "," + userColumn + " is already taken.");
        }

        //Print updated seating chart.
        System.out.print( printChart(seating) );

        scnr.close();
    }

    /**
     * This method returns a string with the given seating chart.
     * The row and column numbers are also shown. An example is provided in
     * the assignment and test cases. You may assume the chartInput argument
     * is rectangular (all rows have the same number of seats).
     *
     * @param chartInput the seating chart which has already been created
     * @return A string containing the whole chart.
     */
    public static String printChart(ArrayList<ArrayList<Character>> chartInput) {
        /*
        String header = "";
        String elementsInLine = "";
        String wholeChart = "";
        int rowCounter = 1;
        int colCounter = 1;
        for(int a = 0; a < chartInput.get(a).size(); a++){
            header += colCounter;
            colCounter += 1;
        }

        for(int i = 0; i < chartInput.size(); i++){
            elementsInLine += rowCounter;
            for(int j = 0; j < chartInput.get(j).size(); j++){
                elementsInLine += "[" + chartInput.get(i).get(j) + "]";
            }
            elementsInLine += '\n';
            rowCounter += 1;
        }
        wholeChart = header + '\n' + elementsInLine;
        return wholeChart;
        */
        String printChart = " ";
        for(int i = 0; i < chartInput.size(); i++){
            ArrayList<Character> row = chartInput.get(i);
            if(i == 0){
                for(int j = 1; j <= row.size(); j++){
                    printChart += " " + j;
                    if(j < row.size()){
                        printChart += " ";
                    }
                }
            }
            printChart += "\n" + (i + 1);
            for(int k = 0; k < row.size(); k++){
                printChart += "[" + row.get(k) + "]";
            }
        }
        printChart += "\n";
        return printChart; 
    }

    /**
     * Creates a seating chart and randomly assigns the
     * spaces filled.
     *
     * @return The 2-dimensional arraylist containing the seating chart.
     */
    public static ArrayList<ArrayList<Character>> getSeatingChart() {
        Random rand = new Random();
        int rows = rand.nextInt(10) + 1;
        int columns = rand.nextInt(10) + 1;
        ArrayList<ArrayList<Character>> seats = new ArrayList<>();
        for ( int row = 0; row < rows; ++row) {
            ArrayList<Character> aRow = new ArrayList<>();
            for ( int col = 0; col < columns; ++col) {
                if ( rand.nextBoolean()) {
                    aRow.add('x');
                } else {
                    aRow.add(' ');
                }
            }
            seats.add( aRow);
        }
        return seats;
    }
}
