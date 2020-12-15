///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Test Bench Connect Four
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
public class TestBenchConnectFour {

	public static void main(String[] args) {
		testIsWinningCord();
	}

	// Add at least 4 more clearly distinct test vectors to help debug the bugs in
	// winConditionJudge
	public static void testIsWinningCord() {
		{// Vertical
			int[][] board = { 
                { 0, -1, -1, -1, -1, -1, -1 }, 
                { 0, -1, -1, -1, -1, -1, -1 },
                { 0, -1, -1, -1, -1, -1, -1 }, 
                { -1, -1, -1, -1, -1, -1, -1 }, 
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 } 
            };
			System.out.println("Vertical winning move test (Row: 3, Col: 0): " + 
                                ConnectFour.winConditionJudge(3, 0, board, 0));
			ConnectFour.drawGameBoard(board);
		}
		{// Diagonal Negative 1
			int[][] board = { 
                { 1, 1, 1, 0, -1, -1, -1 }, 
                { 1, 1, 0, -1, -1, -1, -1 }, 
                { 1, 0, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 }, 
                { -1, -1, -1, -1, -1, -1, -1 }, 
                { -1, -1, -1, -1, -1, -1, -1 } 
            };
            System.out.println("Diagonal (neg) winning move test (Row: 3, Col: 0): " 
                                + ConnectFour.winConditionJudge(3, 0, board, 0));
			ConnectFour.drawGameBoard(board);
		}
        {// Horizontal
            int[][] board = { 
                { 0, 0, 0, -1, -1, -1, -1 }, 
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 }, 
                { -1, -1, -1, -1, -1, -1, -1 }, 
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 } 
        };
        System.out.println("Horizontal winning move test (Row: 0, Col: 3): " 
        + ConnectFour.winConditionJudge(0, 3, board, 0));
        ConnectFour.drawGameBoard(board);
        }
        {// Diagonal Positive 1
            int[][] board = { 
                { -1, -1, -1, 1, 1, 1, -1 }, 
                { -1, -1, -1, 0, 1, 1, -1 }, 
                { -1, -1, -1, -1, 0, 1, -1 },
                { -1, -1, -1, -1, -1, 0, -1 }, 
                { -1, -1, -1, -1, -1, -1, -1 }, 
                { -1, -1, -1, -1, -1, -1, -1 } 
            };
            System.out.println(
                    "Diagonal (+ve) winning move test (Row: 0, Col: 2): " 
                    + ConnectFour.winConditionJudge(0, 2, board, 0));
            ConnectFour.drawGameBoard(board);
        }
        
        {// Vertical_Crossed
            int[][] board = { 
                { -1, -1, 0, 0, 0, 1, 1 }, 
                { -1, -1, 0, 1, 0, 1, 1 },
                { -1, -1, 0, 1, 1, 0, -1 }, 
                { -1, -1, -1, -1, -1, 1, -1 }, 
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 } 
            };
            System.out.println(
                    "Vertical_Crossed winning move test (Row: 3, Col: 2): " 
                    + ConnectFour.winConditionJudge(3, 2, board, 0));
            ConnectFour.drawGameBoard(board);
        }

        {// Diagnol_Crossed
            int[][] board = { 
                { -1, 1, 0, 1, -1, -1, -1 }, 
                { -1, 1, 1, 0, -1, -1, -1 },
                { -1, 1, 0, 1, -1, -1, -1 }, 
                { -1, 0, 0, 1, -1, -1, -1 }, 
                { -1, -1, -1, -1, -1, -1, -1 },
                { -1, -1, -1, -1, -1, -1, -1 } 
            };
            System.out.println(
                    "Diagnol_Crossed winning move test (Row: 0, Col: 4): " 
                    + ConnectFour.winConditionJudge(0, 4, board, 0));
            ConnectFour.drawGameBoard(board);
        }
    }
}
