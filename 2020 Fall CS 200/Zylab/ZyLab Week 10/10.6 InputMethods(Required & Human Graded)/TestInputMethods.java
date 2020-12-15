//TODO add file header
///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
//Title:           Test Input Methods
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
import java.util.Scanner;

/**
 * This contains testing methods for the InputMethods class.
 * @author Jim Williams
 * @author //TODO add your name here when you contribute.
 */
public class TestInputMethods {

    /**
     * This main method runs the selected tests.  Comment out a test if you don't want it to run.
     *
     * @param args unused
     */
    public static void main(String[]args) {
        testGetValidInt();
        testRemoveDuplicates();
    }

    /**
     * Tests that the getValidInt method handles all the cases described in its method header 
     * comment.
     */
    private static void testGetValidInt() {
        boolean error = false;

        {  /*test 1, a straightforward "happy path" case "9\n" with min 5 and max 10, 
            should result in 9*/
            int expected = 9;
            Scanner input = new Scanner("9\n");
            int actual = InputMethods.getValidInt(input, "Enter a number between 5 and 10:", 5, 10);

            if (actual != expected) {
                error = true;
                System.out.println("testGetValidInt 1) Error, expected: " + expected + ", actual: " + actual);
            }
        }

        {  //test 2, null scanner.
            int expected = -1;
            Scanner input = null;
            int actual = InputMethods.getValidInt(input, "Enter a number between 5 and 10:", 5, 10);
            if (actual != expected) {
                error = true;
                System.out.println("testGetValidInt 1) Error, expected: " + expected + ", actual: " + actual);
            }
        }

        {  //test 3, min > max
            int expected = -2;
            Scanner input = new Scanner("9\n");
            int actual = InputMethods.getValidInt(input, "Enter a number between 5 and 10:", 10, 5);
            if (actual != expected) {
                error = true;
                System.out.println("testGetValidInt 1) Error, expected: " + expected + ", actual: " + actual);
            }
        }

        {  //test 4, min value check, "5\n" with min 5 and max 10.
            int expected = 5;
            Scanner input = new Scanner("5\n");
            int actual = InputMethods.getValidInt(input, "Enter a number between 5 and 10:", 5, 10);
            if (actual != expected) {
                error = true;
                System.out.println("testGetValidInt 1) Error, expected: " + expected + ", actual: " + actual);
            }
        }

        {  //test 5, max value check, "6\n" with min 0 and max 6 should result in 6.
            int expected = 6;
            Scanner input = new Scanner("6\n");
            int actual = InputMethods.getValidInt(input, "Enter a number between 0 and 6:", 0, 6);
            if (actual != expected) {
                error = true;
                System.out.println("testGetValidInt 1) Error, expected: " + expected + ", actual: " + actual);
            }
        }

        {  //test 6, skip multiple lines
            int expected = 9;
            Scanner input = new Scanner("4\n3\n9");
            int actual = InputMethods.getValidInt(input, "Enter a number between 5 and 10:", 5, 10);
            if (actual != expected) {
                error = true;
                System.out.println("testGetValidInt 1) Error, expected: " + expected + ", actual: " + actual);
            }
        }

        if (error) {
            System.out.println("testGetValidInt failed");
        } else {
            System.out.println("testGetValidInt passed");
        }
    }

    /**
     * Tests that the removeDuplicates method handles all the cases described in its method header comment.
     */
    private static void testRemoveDuplicates() {
        boolean error = false;

        {  //test 1, a simple case
            ArrayList<Integer> list = new ArrayList<>();
            list.add(20);
            //can also add an array of items to an array list with:
            //list.addAll(java.util.Arrays.asList( new Integer[]{20}));

            ArrayList<Integer> expected = new ArrayList<>();
            expected.add(20);
            ArrayList<Integer> actual = InputMethods.removeDuplicates(list);
            if (!actual.equals(expected)) {
                error = true;
                System.out.println("testRemoveDuplicates 1) Error, expected: " + expected + " , actual: " + actual);
            }
        }

        {  //test 2, null list
            ArrayList<Integer> list = null;
            // can also add an array of items to an array list with:
            // list.addAll(java.util.Arrays.asList( new Integer[]{20}));
            ArrayList<Integer> expected = new ArrayList<>();
            ArrayList<Integer> actual = InputMethods.removeDuplicates(list);
            if (!actual.equals(expected)) {
                error = true;
                System.out.println("testRemoveDuplicates 1) Error, expected: " + expected + " , actual: " + actual);
            }
        }

        {  //test 3, null values in arraylist
            ArrayList<Integer> list = new ArrayList<>();
            list.add(null);
            //需要连续的null
            list.add(null);
            
            // can also add an array of items to an array list with:
            // list.addAll(java.util.Arrays.asList( new Integer[]{20}));

            ArrayList<Integer> expected = new ArrayList<>();
            ArrayList<Integer> actual = InputMethods.removeDuplicates(list);
            if (!actual.equals(expected)) {
                error = true;
                System.out.println("testRemoveDuplicates 1) Error, expected: " + expected + " , actual: " + actual);
            }
        }

        {  //test 4, duplicate values && (duplicate) values out of order
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            list.add(1);
            list.add(1);
            list.add(2);
            //再加一个list.add(1);
            list.add(1);
            list.add(5);
            list.add(-2);
            // can also add an array of items to an array list with:
            // list.addAll(java.util.Arrays.asList( new Integer[]{20}));

            ArrayList<Integer> expected = new ArrayList<>();
            expected.add(-2);
            expected.add(1);
            expected.add(2);
            expected.add(5);

            ArrayList<Integer> actual = InputMethods.removeDuplicates(list);
            if (!actual.equals(expected)) {
                error = true;
                System.out.println("testRemoveDuplicates 1) Error, expected: " + expected + " , actual: " + actual);
            }
        }

        {  //test 5, verify input list is unchanged
             
            ArrayList<Integer> list = new ArrayList<>();
            list.add(20);
            list.add(21);
            list.add(22);
            list.add(23);
            list.add(24);
            list.add(25);
            // can also add an array of items to an array list with:
            // list.addAll(java.util.Arrays.asList( new Integer[]{20}));

            ArrayList<Integer> expected = new ArrayList<>();
            expected.add(20);
            expected.add(21);
            expected.add(22);
            expected.add(23);
            expected.add(24);
            expected.add(25);
            ArrayList<Integer> actual = InputMethods.removeDuplicates(list);
            if (!list.equals(expected)) {
                error = true;
                System.out.println("testRemoveDuplicates 1) Error, list expected: " + expected + " , original list: " + list);
            }
        }

        if (error) {
            System.out.println("testRemoveDuplicates failed");
        } else {
            System.out.println("testRemoveDuplicates passed");
        }
    }
}
