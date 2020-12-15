///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Connect Four Game
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
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class ConnectFour {

	final static int BOARD_WIDTH = 7;
	final static int BOARD_HEIGHT = 6;
	final static int CONNECT_WIN = 4;
	final static int COMPUTER_PLAYER = 0;
	final static int HUMAN_PLAYER = 1;

	public enum argState {
		NONE, PLAYERS, TEST
	};

	/**
     * Below is the main method of program, drive whole process of game
	 * first judge game mode, number of players
	 * then provide step-by-step instruction of play move, as well as 
	 * displaying play results 
	 * @param numPlayers number of real human player in game
	 * @param testMode   game at test mode or play mode
     * @param seedInput	judge whether game ends or not
	 * @param rand 		random move/num generator
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numPlayers = 2;
        boolean testMode = false;
        boolean seedInput = false;
        long seed = 0;

        argState cmdFlag = argState.NONE;
        for(String arg: args) {
            switch(arg) {
            case "-t":
                cmdFlag = argState.TEST;
                break;
            case "-p":
                cmdFlag = argState.PLAYERS;
                break;
            default:
                if(cmdFlag == argState.TEST) {
                    seed = Long.parseLong(arg);
                    seedInput = true;
                }  else if(cmdFlag == argState.PLAYERS) {
                    numPlayers = Integer.parseInt(arg);
                }
                cmdFlag = argState.NONE;
                break;
            }
        }
        Random rand;
        if(seedInput) {
            rand = new Random(seed);
        } else {
            rand = new Random();
        }
        int[] players = new int[]{COMPUTER_PLAYER, COMPUTER_PLAYER};
        for(int i = 0; i < numPlayers && i < players.length; i++) {
            players[i] = HUMAN_PLAYER;
        }
        boolean gameOn = true;
        System.out.println("Welcome to Connect Token Game. \nOn" + 
        "your turn, please select a column from 1 to " + BOARD_WIDTH + " to drop your token.");
        int[][] board = new int[BOARD_HEIGHT][BOARD_WIDTH];
        for(int i = 0; i < board.length; i++) {
            Arrays.fill(board[i], -1);
        }
        int player = 0;
        drawGameBoard(board);
        while(gameOn) {
            System.out.println("Player " + (player + 1) + " your move:");
            if(players[player] == HUMAN_PLAYER) {
                while(!input.hasNextInt()){
                    input.next();
                }
                int move = input.nextInt();
                if(move < 1 || move > BOARD_WIDTH || board[BOARD_HEIGHT - 1][move - 1] != -1) {
                    System.out.println("Invalid column: " + move + ". Please" + 
                    "select a (non-full) column from 1 to " + BOARD_WIDTH + ".");
                    continue;
                }
                gameOn = !isWinningCol(move - 1, board, player);
                dropToken(move - 1, board, player);
            } else {
                gameOn = !computerMove(board, player, rand);
            }
            drawGameBoard(board);
            if(!gameOn) {
                System.out.println("Player " + (player + 1) + " won!");
            }
            player = (player + 1) % 2;
            if(gameOn && checkFullBoard(board)) {
                System.out.println("Game over. We have a draw!");
                gameOn = false;
            }
        }
        System.out.println("Thank you for playing!");
    }

	/**
	 * Checks if the game board is full, i.e., if no more tokens can be added.
	 *
	 * A game board is not full if any of the top most cells contain the value -1.
	 *
	 * @param board The game board to verify. It must be of size BOARD_WIDTH *
	 *              BOARD_HEIGHT.
	 * @return true if the game board is not full, false otherwise.
	 */
	public static boolean checkFullBoard(int[][] board) {
		for (int i = 0; i < BOARD_WIDTH; i++) {
			if (board[BOARD_HEIGHT - 1][i] == -1)
				return false;
		}
		return true;
	}

	/**
	 * Maps the player index to a character.
	 *
	 * @param player The integer index to map to a character.
	 * @return Returns the mapped character: - 0 is mapped to 'X' - 1 is mapped to
	 *         'O' - Every other index is mapped to ' '
	 */
	public static char getToken(int player) {
		return (player == 0 ? 'X' : (player == 1 ? 'O' : ' '));
	}

	/**
	 * Drops a token into the game board at a specified column, col. The token is
	 * place at the lowest unfilled cell (value -1) of column col. Specifically, the
	 * lowest unfilled cell is set to the player index.
	 *
	 * @param col    The column where the token is dropped.
	 * @param board  The game board into which the token is dropped. It must be of
	 *               size BOARD_WIDTH * BOARD_HEIGHT.
	 * @param player The player index.
	 * @return Returns false if the column if full, i.e., the maximum index is not
	 *         -1. Otherwisem returns true.
	 */
	public static boolean dropToken(int col, int[][] board, int player) {
		if (board[BOARD_HEIGHT - 1][col] != -1) {
			return false;
		}
		for (int i = 0; i < board.length; i++) {
			if (board[i][col] == -1) {
				board[i][col] = player;
				break;
			}
		}
		return true;
	}

	/**
	 * Checks each column to see if dropping a token at that column would result in
	 * a win for the specified player index.
	 *
	 * @param board  The game board into which the token is dropped. It must be of
	 *               size BOARD_WIDTH * BOARD_HEIGHT.
	 * @param player The player index.
	 * @return The lowest column index for which the specified player would win by
	 *         dropping a token. If there is no such column, -1 is returned.
	 */
	public static int findWinningMove(int[][] board, int player) {
		for (int col = 0; col < BOARD_WIDTH; col++) {
			if (isWinningCol(col, board, player)) {
				return col;
			}
		}
		return -1;
	}

	/**
	 * Checks if dropping a token at the specified column for the specified player
	 * would result in a win.
	 *
	 * @param col    The column where the token is dropped.
	 * @param board  The game board into which the token is dropped. It must be of
	 *               size BOARD_WIDTH * BOARD_HEIGHT.
	 * @param player The player index.
	 * @return true if col is a winning column for player. Otherwise, returns false.
	 */
	public static boolean isWinningCol(int col, int[][] board, int player) {
		for (int i = BOARD_HEIGHT - 1; i >= 0; i--) {
			if (winConditionJudge(i, col, board, player)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method checks condition of consecutive token in several forms:
	 * horizontal, vertical, diagnoal in total 8 direction;
	 * and return boolean variable telling 
	 * whether it is winning condition or not 
     * @param row			num. of row on gameboard
	 * @param col			num. of column on gameboard
	 * @param gameBoard		game board where token dropped
	 * @param playerMove	player index recording
	 * @param meetBoundary	check whether successive token is reaching boundary 
     * 
	 * @return Boolean Variable judging whether someone win; if so, who?
	 */
	public static boolean winConditionJudge(int row, 
						int col, int[][] gameBoard, int playerMove) {
		
		if (row >= BOARD_HEIGHT || row < 0 || col >= BOARD_WIDTH || 
		col < 0 || gameBoard[row][col] != -1 || 
		(row < BOARD_HEIGHT - 1 && gameBoard[row + 1][col] != -1) || 
		(row > 0 && gameBoard[row - 1][col] == -1)) {
			return false;
		}
		{ // Vertical
			int count = 0;
			for (int i = row - 1; i >= 0; i--) {
				if (gameBoard[i][col] != playerMove) {
					break;
				} else {
					count++;
				}
			}
			if (count >= CONNECT_WIN - 1) {
				return true;
			}
		}
		{ // Horizontal
			int count = 0;
			for (int i = col - 1; i >= 0; i--) {
				if (gameBoard[row][i] != playerMove) {
					break;
				} else {
					count++;
				}
			}
			for (int i = col + 1; i < BOARD_WIDTH; i++) {
				if (gameBoard[row][i] != playerMove) {
					break;
				} else {
					count++;
				}
			}
			if (count >= CONNECT_WIN - 1) {
				return true;
			}
		}
        { // Diagonals  DON'T KNOW HOW TO FIX IT, SORRY -_-"!!
			int countNegSlope = 0;
			for (int i = row + 1; i < BOARD_HEIGHT; i++) {
				for (int j = col - 1; j >= 0; j--) {
					if (gameBoard[i][j] != playerMove) {
						break;
					} else {
						countNegSlope++;
					}
				}
			}
			for (int i = row - 1; i >= 0; i--) {
				for (int j = col + 1; j < BOARD_WIDTH; j++) {
					if (gameBoard[i][j] != playerMove) {
						break;
					} else {
						countNegSlope++;
					}
				}
			}
			if (countNegSlope >= CONNECT_WIN - 1) {
				return true;
			}
			int countPosSlope = 0;
			for (int i = row + 1; i < BOARD_HEIGHT; i++) {
				for (int j = col + 1; j < BOARD_WIDTH; j++) {
					if (gameBoard[i][j] != playerMove) {
						break;
					} else {
						countPosSlope++;
					}
				}
			}
			for (int i = row - 1; i >= 0; i--) {
				for (int j = col - 1; j >= 0; j--) {
					if (gameBoard[i][j] != playerMove) {
						break;
					} else {
						countPosSlope++;
					}
				}
			}
			if (countPosSlope >= CONNECT_WIN - 1) {
				return true;
			}

		}
		return false;
	}

	/**
	 * This method help computers to decide how to play the game。
	 * If find win move, rteurn true
	 * otherwise return false
     * @param gameBoard		board where token drop
	 * @param player		record player move
	 * @param rand			random move generator
	 */
	public static boolean computerMove(int[][] gameBoard, int player, Random rand) {
		int winMove = findWinningMove(gameBoard, player);
		if (winMove != -1) {
			dropToken(winMove, gameBoard, player);
			return true;
		}
		winMove = findWinningMove(gameBoard, (player + 1) % 2);
		if (winMove != -1) {
			dropToken(winMove, gameBoard, player);
			return false;
		}
		do {
			winMove = rand.nextInt(BOARD_WIDTH);
		} while (gameBoard[BOARD_HEIGHT - 1][winMove] != -1);
		dropToken(winMove, gameBoard, player);
		return false;
	}

	/**
	 * This method draws the "Connect four" game's game board
     * basically, the board is draw within the limits: 
     * It is a 7 * 6 Game Board where  7 is width and 6 is height
     * @param gameBoard the gameboard we draw using for loop
     * 
	 */
	public static void drawGameBoard(int[][] gameBoard) {
		for (int i = 0; i < BOARD_WIDTH; i++) {
			System.out.print("--");
		}
		System.out.println("-");
		for (int i = gameBoard.length - 1; i >= 0; i--) {
			System.out.print("|");
			for (int j = 0; j < BOARD_WIDTH; j++) {
				System.out.print(getToken(gameBoard[i][j]) + "|");
			}
			System.out.println();
		}
		for (int i = 0; i < BOARD_WIDTH; i++) {
			System.out.print("--");
		}
		System.out.println("-");
		System.out.print(" ");
		for (int i = 0; i < BOARD_WIDTH; i++) {
			System.out.print((i + 1) + " ");
		}
		System.out.println();
	}

}
