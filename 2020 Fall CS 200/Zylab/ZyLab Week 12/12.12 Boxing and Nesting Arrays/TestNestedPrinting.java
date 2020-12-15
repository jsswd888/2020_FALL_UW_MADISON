///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Test Nested Printing
// Course:          CS 200 Fall 2020
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

public class TestNestedPrinting {
    public static boolean testEndWith() {
        System.out.println("Running testEndWith");
        // Test 1 -- Length 0 line
        if(!NestedPrinting.endWith("", "!", 2).equals(" !")) {
            System.out.println("\tFailed Test 1 (padding)");
            return false;
        }

        // Test 2 -- Length 4
        if(!NestedPrinting.endWith("XY", "Z", 2).equals("XZ")) {
            System.out.println("\tFailed Test 2 (truncating)");
            return false;
        }

        System.out.println("Done testEndWith");
        return true;
    }

    public static boolean testLineOf() {
        System.out.println("Running testLineOf");

        // Test 1 -- Length 0 line
        if(!NestedPrinting.lineOf('X', 0).equals("")) {
            System.out.println("\tFailed Test 1 (length 0)");
            return false;
        }

        // Test 2 -- Length 4
        if(!NestedPrinting.lineOf('-', 4).equals("----")) {
            System.out.println("\tFailed Test 2 (length 4)");
            return false;
        }

        System.out.println("Done testLineOf");
        return true;
    }

    public static boolean testArrToString1D() {
        System.out.println("Running testArrToString1D");

        // Test 1
        String[] arr1 = new String[] { "hello", "there", "everyone" };
        String exp = "{hello, there, everyone}";
        String actual = NestedPrinting.arrToString(arr1);
        if (!actual.equals(exp)) {
            System.out.println("\tFailed Test 1");
            return false;
        }

        // Test 2 - TODO: Add additional test(s)

        System.out.println("Done testArrToString1D");
        return true;
    }

    public static boolean testArrToString2D() {
        System.out.println("Running testArrToString2D");

        // Test 1
        String[][] arr1 = new String[][] {
            { "Hi", "Guy" },
            { "2D" }
        };
        String exp =
              "START{           END\n"
            + "START  {Hi, Guy},END\n"
            + "START  {2D}      END\n"
            + "START}           END\n";
        String actual = NestedPrinting.arrToString(arr1, "START", "END", 20);
        if (!actual.equals(exp)) {
            System.out.println("\t Failed Test 1");
            return false;
        }

        // Test 2 - TODO: Add additional test(s)

        System.out.println("Done testArrToString2D");
        return true;
    }

    public static boolean testArrToString3D() {
        System.out.println("Running testArrToString3D");

        // Test 1
        String[][][] arr1 = new String[][][] {
            {
                { "Hi", "Guy" },
                { "3D" }
            },
            {
                { "Nope" }
            }
        };
        String exp =
            "_{           !?\n"
            + "_  {         !?\n"
            + "_    {Hi, Guy!?\n"
            + "_    {3D}    !?\n"
            + "_  }         !?\n"
            + "_------------!?\n"
            + "_  {         !?\n"
            + "_    {Nope}  !?\n"
            + "_  }         !?\n"
            + "_}           !?\n";
        String actual = NestedPrinting.arrToString(arr1, "_", "!?", '-', 15);
        if (!actual.equals(exp)) {
            System.out.println("\t Failed Test 1");
            return false;
        }

        System.out.println("Done testArrToString3D");
        return true;
    }

    public static boolean testArrInBox() {
        System.out.println("Running testArrInBox");

        // Test 1
        String[][][] arr1 = new String[][][] {
            {
                { "Hi", "Guy" },
                { "3D" }
            },
            {
                { "Nope" }
            }
        };
        String exp =
            "---------------\n"
            + "_{           !?\n"
            + "_  {         !?\n"
            + "_    {Hi, Guy!?\n"
            + "_    {3D}    !?\n"
            + "_  }         !?\n"
            + "_------------!?\n"
            + "_  {         !?\n"
            + "_    {Nope}  !?\n"
            + "_  }         !?\n"
            + "_}           !?\n"
            + "---------------\n";
        String actual = NestedPrinting.arrInBox(arr1, "_", "!?", '-', 15);
        if (!actual.equals(exp)) {
            System.out.println("\t Failed Test 1");
            return false;
        }

        System.out.println("Done testArrInBox");
        return true;
    }

    public static void main(String[] args) {
        testEndWith();
        testLineOf();
        testArrToString1D();
        testArrToString2D();
        testArrToString3D();
        testArrInBox();
    }
}
