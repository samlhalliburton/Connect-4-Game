package core;

/**
 * This program creates the game logic for a Connect4 game.
 *
 * @author Samantha Halliburton
 * @version 5.31.2020
 */

public class Connect4 {
    int numMoves = 0;
    int[][] board;

    /**
     * Constructor method creates new game board
     */
    public Connect4() {
        board = new int[6][7];
    }

    /**
     * Getter method returns board
     * @return
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Setter method for board
     * @param board
     */
    public void setBoard(int[][] board) {
        this.board = board;
    }

    /**
     * Prints out formatted board per specifications
     */
    public void printGame() {
        for (int i = 0; i < 6; i++) {
            System.out.print("|");

            for (int j = 0; j < 7; j++) {
                if (board[i][j] == 0) {
                    System.out.print(" ");
                } else if (board[i][j] == 1) {
                    System.out.print("X");
                } else if (board[i][j] == 2) {
                    System.out.print("O");
                }

                System.out.print("|");
            }

            System.out.println();
        }

        System.out.println();
        System.out.println();
    }

    /**
     * Inserts player_ID into selected column
     *
     * @param col    Column choice entered by player
     * @param player Inserts player_ID number associated with player
     */
    public void moveGamePiece(int col, int player) {
        // Converts player choice into proper array column
        col--;
        for (int i = 5; i >= 0; i--) {
            if (board[i][col] == 0) {
                board[i][col] = player;
                break;
            }
        }

        // Records number of moves completed (42 total allowed)
        numMoves++;
    }

    /**
     * Checks for a winner by searching for 4-in-a-row
     * in vertical, horizontal, and both diagonals.
     *
     * @param player Inserts player_ID number associated with player
     * @return Returns true if there is a 4-in-a-row match
     */
    public boolean checkForWinner(int player) {
        // Check for vertical 4-in-a-row
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) {
                if ((board[i][j] == player) && (board[i + 1][j] == player)
                        && (board[i + 2][j] == player) && (board[i + 3][j] == player)) {
                    return true;
                }
            }
        }

        // Check for horizontal 4-in-a-row
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 6; i++) {
                if ((board[i][j] == player) && (board[i][j + 1] == player)
                        && (board[i][j + 2] == player) && (board[i][j + 3] == player)) {
                    return true;
                }
            }
        }

        // Check for diagonal 4-in-a-row (negative slope)
        for (int j = 0; j < 4; j++) {
            for (int i = 3; i < 6; i++) {
                if ((board[i][j] == player) && (board[i - 1][j + 1] == player)
                        && (board[i - 2][j + 2] == player) && (board[i - 3][j + 3] == player)) {
                    return true;
                }
            }
        }

        // Check for diagonal 4-in-a-row (positive slope)
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                if ((board[i][j] == player) && (board[i + 1][j + 1] == player)
                        && (board[i + 2][j + 2] == player) && (board[i + 3][j + 3] == player)) {
                    return true;
                }
            }
        }

        // Default false
        return false;
    }

    /**
     * Checks selected column to make sure there is room
     * available for game piece to be added
     *
     * @param col Checks player column choice
     *            against column to make sure column is not full
     * @return Returns true if column is full, false if not
     */
    public boolean fullColumn(int col) {
        col--;
        for (int i = 0; i < 6; i++) {
            if (board[i][col] == 0) {
                return true;
            }
        }

        // Default false
        return false;
    }

    /**
     * Checks that board is full in the case of a draw
     *
     * @return Returns true if 42 moves have been completed.
     */
    public boolean fullBoard() {
        // Check if 42 moves have been completed (draw)
        if (numMoves == 42) {
            return true;
        } else {
            return false;
        }
    }
}