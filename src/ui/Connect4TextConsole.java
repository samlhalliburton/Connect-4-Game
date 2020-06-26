package ui;

import core.Connect4;
import core.Connect4ComputerPlayer;
import core.Constants;
import java.util.Scanner;

/**
 * This program creates the console-based ui for a Connect4 game.
 *
 * @author Samantha Halliburton
 * @version 6.23.2020
 */

public class Connect4TextConsole extends Constants {

    /**
     * This creates the runGame method to be used in the LaunchConnect4 class
     * Imports game logic methods and creates console-based game
     */
    public static void runGame() {
        Scanner scanner = new Scanner(System.in);
        Connect4 game = new Connect4();
        Connect4ComputerPlayer comp = new Connect4ComputerPlayer();
        int port = 8000;

        char player = PLAYER1;
        int choice = 0;

        game.createBoard();
        game.displayBoard();
        System.out.println();
        System.out.println(BEGIN_GAME);
        System.out.println(GAME_MODE);
        char mode = 'a';
        while(!(mode == PLAYER || mode == PLAYER_VAR || mode == COMPUTER || mode == COMPUTER_VAR)) {
            mode = game.getMode(scanner);
            if(!(mode == PLAYER || mode == PLAYER_VAR || mode == COMPUTER || mode == COMPUTER_VAR)) {
                game.wrongMode();
            }
        }
        game.startGame(mode);

        if(mode == PLAYER || mode == PLAYER_VAR) {
            while(true) {
                game.playerTurnPrompt(player);
                choice = game.getMove();

                if(game.checkForDraw() == true) {
                    game.tryMove(choice, player);
                    game.displayBoard();
                    System.out.println();
                    System.out.println(TIED_GAME);
                    break;
                } else {
                    if(game.tryMove(choice, player)) {
                        if(game.checkForWinner()) {
                            game.displayBoard();
                            System.out.println();
                            System.out.println("Player " + player + " wins!");
                            return;
                        }
                        player = game.switchPlayer(player);
                    }
                    game.displayBoard();
                    System.out.println();
                }
            }
        } else if(mode == COMPUTER || mode == COMPUTER_VAR) {
            while(true) {
                game.computerTurnPrompt(player);

                if(player == PLAYER1) {
                    choice = game.getMove();
                } else if(player == PLAYER2) {
                    choice = comp.getComputerMove();
                }

                if(game.checkForDraw() == true) {
                    game.tryMove(choice, player);
                    game.displayBoard();
                    System.out.println();
                    System.out.println(TIED_GAME);
                    break;
                } else {
                    if(game.tryMove(choice, player)) {
                        if(game.checkForWinner()) {
                            game.displayBoard();
                            System.out.println();
                            if(player == PLAYER1) {
                                System.out.println(YOUR_WIN);
                            } else if(player == PLAYER2) {
                                System.out.println(COMPUTER_WIN);
                            }
                            return;
                        }
                        player = game.switchPlayer(player);
                    }
                    game.displayBoard();
                    System.out.println();
                }
            }
        }
    }
}
