package core;

import ui.Connect4TextConsole;

import java.util.Scanner;

/**
 * This program creates the game logic for a Connect4 game.
 *
 * @author Samantha Halliburton
 * @version 6.23.2020
 */

public class Connect4 extends Constants {
    private static char[][] board;
    public static char mode;
    private char player;
    private int numMoves;
    Scanner scanner = new Scanner(System.in);

    /**
     * Constructor method for Connect4
     */
    public Connect4() {
        this.board = new char[6][7];
        this.player = PLAYER1;
        this.numMoves = 0;
    }

    /**
     * Getter method for board
     *
     * @return
     */
    public char[][] getBoard() {
        return board;
    }

    /**
     * createBoard() method
     * Creates initial game board by filling char array with blanks
     *
     * @return blank game board
     */
    public char[][] createBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = BLANK;
            }
        }
        numMoves = 0;
        return board;
    }

    /**
     * This method prints out formatted board per specifications
     */
    public void displayBoard() {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    /**
     * This method takes in game mode selected
     * whether two player or against computer
     *
     * @param scanner
     * @return
     */
    public char getMode(Scanner scanner) {
        char mode = scanner.next().charAt(0);
        if (mode == 0) {
            return 0;
        }

        return mode;
    }

    /**
     * Prints starting game messages dependent upon game mode
     *
     * @param choice Takes in user's choice of two player or computer
     * @throws IllegalArgumentException if invalid entry
     */
    public void startGame(char choice) throws IllegalArgumentException {
        if (choice == COMPUTER || choice == COMPUTER_VAR) {
            System.out.println(START_GAME_COMPUTER);
        } else if (choice == PLAYER || choice == PLAYER_VAR) {
            System.out.println(START_GAME_TWO_PLAYER);
        } else {
            throw new IllegalArgumentException("Invalid Entry!");
        }
    }

    /**
     * This function displays a message indicating whose turn it is.
     *
     * @param player Player X or Player O
     * @return Message stating turn to move
     */
    public void playerTurnPrompt(char player) {
        if(player == PLAYER1) {
            System.out.println(PLAYER1_MOVE);
        } else {
            System.out.println(PLAYER2_MOVE);
        }
    }

    /**
     * Prints out statement on who's turn to move
     * when playing against computer
     *
     * @param player Player who's turn it currently is
     */
    public void computerTurnPrompt(char player) {
        if(player == PLAYER1) {
            System.out.println(YOUR_MOVE);
        } else {
            System.out.println(COMPUTER_MOVE);
        }
    }

    /**
     * Switches player based on current player's turn
     *
     * @param player
     * @return New player to move
     */
    public char switchPlayer(char player) {
        if (player == PLAYER1) {
            return PLAYER2;
        } else {
            return PLAYER1;
        }
    }

    /**
     * Reads in user's column choice and edits to fit within board array.
     *
     * @return Column choice from 0 to 6
     */
    public int getMove() {
        boolean flag = false;
        int col = 0;

        while (!flag) {
            if (Connect4TextConsole.scanner.hasNextInt()) {
                col = Connect4TextConsole.scanner.nextInt();
                flag = true;
            } else {
                System.out.println(INVALID_MOVE);
                Connect4TextConsole.scanner.next();
            }
        }

        while (col < 1 || col > 7) {
            System.out.println(INVALID_MOVE);
            col = Connect4TextConsole.scanner.nextInt();
        }

        return (col - 1);
    }
//        int col = 0;
//        try {
//            col = scanner.nextInt();
//            while (col < 1 || col > 7) {
//                System.out.println(INVALID_MOVE);
//                col = scanner.nextInt();
//            }
//        } catch (Exception ex) {
//            System.out.println(INVALID_MOVE);
//        }
//        return (col - 1);

    /**
     * Checks selected column to make sure there is room
     * available for game piece to be added
     * If column isn't full, then places piece as low as possible
     *
     * @param column Column choice from user
     * @param player Player ID - either X or O
     * @return True or False
     */
    public boolean tryMove(int column, char player) {
        boolean flag = false;

        // Is move valid - column full? within range?
        if (board[0][column] != ' ') {
            System.out.println("Column " + (column + 1) + " is full. " +
                    "Please try a different one.");
        } else {
            // Places piece as far down chosen column as possible
            for (int i = (board.length - 1); i >= 0; i--) {
                if (board[i][column] == ' ') {
                    board[i][column] = player;
                    numMoves++;
                    return true;
                }
            }
        }

        return flag;
    }

    /**
     * Checks for a winner by looking for 4-in-a-row
     * either vertically, horizontally, or diagonally
     *
     * @return True or False
     */
    public boolean checkForWinner() {
        boolean test = false;

        // Check for vertical win
        for (int j = 0; j < board[0].length; j++) {
            for (int i = 0; i < (board.length - 3); i++) {
                if (board[i][j] != ' '
                        && board[i][j] == board[i + 1][j]
                        && board[i][j] == board[i + 2][j]
                        && board[i][j] == board[i + 3][j]
                ) {
                    return true;
                }
            }
        }

        // Check for horizontal win
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < (board[i].length - 3); j++) {
                if (board[i][j] != ' '
                        && board[i][j] == board[i][j + 1]
                        && board[i][j] == board[i][j + 2]
                        && board[i][j] == board[i][j + 3]) {
                    return true;
                }
            }
        }

        // Check for downward diagonal (negative slope) win
        for (int i = 0; i < (board.length - 3); i++) {
            for (int j = 0; j < (board[i].length - 3); j++) {
                if (board[i][j] != ' '
                        && board[i][j] == board[i + 1][j + 1]
                        && board[i][j] == board[i + 2][j + 2]
                        && board[i][j] == board[i + 3][j + 3]) {
                    return true;
                }
            }
        }

        // Check for upward diagonal (positive slope) win
        for (int i = 0; i < (board.length - 3); i++) {
            for (int j = 3; j < board[i].length; j++) {
                if (board[i][j] != ' '
                        && board[i][j] == board[i + 1][j - 1]
                        && board[i][j] == board[i + 2][j - 2]
                        && board[i][j] == board[i + 3][j - 3]) {
                    return true;
                }
            }
        }

        return test;
    }

    /**
     * Check whether all moves have been exhausted
     * Prints out tied game message
     *
     * @return True or False
     */
    public boolean checkForDraw() {
        if (numMoves == 41) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method displays an error message
     * if the player selects an invalid game mode
     *
     * @return Error message
     */
    public void wrongMode() {
        System.out.println(GAME_MODE_INVALID);
    }
}