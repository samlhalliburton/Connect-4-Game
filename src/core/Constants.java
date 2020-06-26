package core;

/**
 * This program constants for a Connect4 game.
 *
 * @author Samantha Halliburton
 * @version 6.23.2020
 */

public class Constants {
    // Player-related constants
    public static final char BLANK = ' ';
    public static final char PLAYER1 = 'X';
    public static final char PLAYER2 = 'O';
    public static final String PLAYER1_WIN = "Player " + PLAYER1 + " wins!";
    public static final String PLAYER2_WIN = "Player " + PLAYER2 + " wins!";
    public static final String YOUR_WIN = "You win!";
    public static final String COMPUTER_WIN = "Computer wins!";
    public static final String TIED_GAME = "Game over. It's a tie!";
    public static final int EMPTY_INT = 0;
    public static final int PLAYER1_INT = 1;
    public static final int PLAYER2_INT = 2;

    // Game details
    public static final String TITLE = "Connect4";
    public static final int ROWS = 6;
    public static final int COLS = 7;
    public static final char PLAYER = 'P';
    public static final char PLAYER_VAR = 'p';
    public static final char COMPUTER = 'C';
    public static final char COMPUTER_VAR = 'c';
    public static final String PLAYER1_MOVE = "Player " + PLAYER1 + " your move. Choose a column number from 1-7.";
    public static final String PLAYER2_MOVE = "Player " + PLAYER2 + " your move. Choose a column number from 1-7.";
    public static final String YOUR_MOVE = "It is your turn. Choose a column number from 1-7.";
    public static final String COMPUTER_MOVE = "Computer's turn now.";
    public static final String INVALID_MOVE = "Invalid Entry!\nMust choose a column number from 1-7.";

    // Game mode choices
    public static final String GAME_MODE = "Enter 'P' to play against another player; " +
            "Enter 'C' to play against computer.";
    public static final String GAME_MODE_INVALID = "Invalid Entry!\n" +
            "Enter 'P' to play two player mode. Enter 'C' to play against computer.";
    public static final String START_GAME_COMPUTER = "Starting game against computer.";
    public static final String START_GAME_TWO_PLAYER = "Starting game against player.";
    public static final String BEGIN_GAME = "Begin Game.";
    public static final String GUI_MODE = "Begin Game.\n" +
            "Enter 'G' for GUI display or 'T' to use the text console.";
    public static final String GUI_MODE_INVALID = "Invalid Entry!\n" +
            "Enter 'G' for GUI display or 'T' to use the text console.";

    // GUI
    public static final char GUI = 'G';
    public static final char GUI_VAR = 'g';
    public static final char CONSOLE = 'T';
    public static final char CONSOLE_VAR = 't';
    public static final String WAITING = "Waiting for Opponent...";
    public static final String PLAYER1_GUI_WIN = "Black wins!";
    public static final String PLAYER2_GUI_WIN = "Red wins!";
    public static final String TIED_GUI_GAME = "Game over. It's a tie!";

}