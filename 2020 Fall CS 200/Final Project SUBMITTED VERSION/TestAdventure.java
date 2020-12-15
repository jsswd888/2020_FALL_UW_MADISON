///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           descriptive title of the program making use of this file
// Course:          course number, term, and year
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

import java.util.Arrays;

/**
 * This contains testing methods for the Adventure program.
 * 
 * @author Shi Kaiwen
 */
public class TestAdventure {

    /**
     * Uncomment testing methods to have them run. FINISHED TESTING METHODS: 1.
     * testParseFields; 2. testParseCoordinates; 3. testDetermineLocation
     * 
     * @param args unused
     */
    public static void main(String[] args) {
        testParseCoordinates();
        testParseFields();
        testDetermineLocation();
        // testEnter();
    }

    /**
     * Tests for the parseCoordinates method.
     */
    private static void testParseCoordinates() {
        boolean error = false;

        { // example test:
            String coordinateString = "8,6";
            int[] expected = new int[] { 8, 6 };
            int[] actual = Adventure.parseCoordinates(coordinateString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseCoordinates 1) Expected: " + 
                Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        // Additional tests for testParseCoordinates
        { // ADD test 1:
            String coordinateString = "8 6";
            int[] expected = null;
            int[] actual = Adventure.parseCoordinates(coordinateString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseCoordinates 1) Expected: " + 
                Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { // ADD test 2:
            String coordinateString = "/-/";
            int[] expected = null;
            int[] actual = Adventure.parseCoordinates(coordinateString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseCoordinates 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { // ADD test 3:
            String coordinateString = "public static";
            int[] expected = null;
            int[] actual = Adventure.parseCoordinates(coordinateString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseCoordinates 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { // ADD test 4:
            String coordinateString = ",";
            int[] expected = null;
            int[] actual = Adventure.parseCoordinates(coordinateString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseCoordinates 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        if (error) {
            System.out.println("Error in testParseCoordinates.");
        } else {
            System.out.println("All tests in testParseCoordinates passed.");
        }
    }

    /**
     * Tests for the parseFields method.
     */
    private static void testParseFields() {
        boolean error = false;
        { // test 1:
            String coordString = "";
            String fieldsString = "size/This is the size of the map//";
            String[] expected = new String[] { "size", "This is the size of the map", "", "" };
            String[] actual = Adventure.parseFields(fieldsString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseFields 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { // test 2:
            String fieldsString = "-";
            String[] expected = new String[] { "-" };
            String[] actual = Adventure.parseFields(fieldsString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseFields 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { // test 3:
            String fieldsString = " / //";
            String[] expected = new String[] { "", "", "", "" };
            String[] actual = Adventure.parseFields(fieldsString);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testParseFields 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        if (error) {
            System.out.println("Error in testParseFields.");
        } else {
            System.out.println("All tests in testParseFields passed.");
        }
    }

    /**
     * Tests for the determineLocation method.
     */
    private static void testDetermineLocation() {
        Boolean error = false;
        { // test 1 BOTTOM_RIGHT_DOWN:
            String direction = "s";
            String[][][] map = new String[8][6][];
            int[] currLocation = { 7, 5 };
            int[] expected = { 0, 5 };
            int[] actual = Adventure.determineLocation(map, currLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { // test 2 BOTTOM_RIGHT_RIGHT:
            String direction = "d";
            String[][][] map = new String[8][6][];
            int[] currLocation = { 7, 5 };
            int[] expected = { 7, 0 };
            int[] actual = Adventure.determineLocation(map, currLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { // test 3 UP_LEFT_UP:
            String direction = "w";
            String[][][] map = new String[8][6][];
            int[] currLocation = { 0, 0 };
            int[] expected = { 7, 0 };
            int[] actual = Adventure.determineLocation(map, currLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { // test 4 UP_LEFT_LEFT:
            String direction = "a";
            String[][][] map = new String[8][6][];
            int[] currLocation = { 0, 0 };
            int[] expected = { 0, 5 };
            int[] actual = Adventure.determineLocation(map, currLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { // test 5 RANDOMPOSI_IN_MAP_UP:
            String direction = "w";
            String[][][] map = new String[8][6][];
            int[] currLocation = { 2, 3 };
            int[] expected = { 1, 3 };
            int[] actual = Adventure.determineLocation(map, currLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { // test 6 RANDOMPOSI_IN_MAP_DOWN:
            String direction = "s";
            String[][][] map = new String[8][6][];
            int[] currLocation = { 6, 3 };
            int[] expected = { 7, 3 };
            int[] actual = Adventure.determineLocation(map, currLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { // test 7 RANDOMPOSI_IN_MAP_LEFT:
            String direction = "a";
            String[][][] map = new String[8][6][];
            int[] currLocation = { 4, 2 };
            int[] expected = { 4, 1 };
            int[] actual = Adventure.determineLocation(map, currLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }

        { // test 8 RANDOMPOSI_IN_MAP_RIGHT:
            String direction = "d";
            String[][][] map = new String[8][6][];
            int[] currLocation = { 6, 2 };
            int[] expected = { 6, 3 };
            int[] actual = Adventure.determineLocation(map, currLocation, direction);
            if (!Arrays.equals(expected, actual)) {
                System.out.println("testDetermineLocation 1) Expected: " + 
                        Arrays.toString(expected) + " Actual: " + Arrays.toString(actual));
                error = true;
            }
        }
        if (error) {
            System.out.println("Error in testDetermineLocation.");
        } else {
            System.out.println("All tests in testDetermineLocation passed.");
        }
    }
}
