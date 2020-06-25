package ui;

import core.Connect4ComputerPlayer;

import java.util.Scanner;

/**
 * This program creates the ui for the Connect4 game logic
 * to be implemented on.
 *
 * @author Samantha Halliburton
 * @version 6.14.2020
 */


public class Connect4TextConsole {

    /**
     * This creates the runGame method to be used in the LaunchConnect4 class
     * Imports game logic methods and creates console-based game
     */
    public static void runGame() {
        Scanner scan = new Scanner(System.in);
        int player_ID = 1;
        int col = 0;
        String mode = "";

        Connect4ComputerPlayer game = new Connect4ComputerPlayer();
        game.printGame();
        System.out.println("Begin Game. Enter 'P' if you want to play against" +
                " another player; enter 'C' to play against computer.");

        try {
            mode = scan.next();
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid entry.");
        }

        if (mode.equals("P") || mode.equals("p")) {
            System.out.println("Start two player game.");
            while (true) {
                if (game.fullBoard() == true) {
                    System.out.println("Game over. It's a draw.");
                    break;
                } else {
                    if (player_ID == 1) {
                        System.out.println("PlayerX - your turn. Choose a column number from 1-7.");

                        try {
                            col = scan.nextInt();
                        } catch (Exception e) {
                            System.out.println("Must be a number from 1 to 7.");
                            break;
                        }

                        if ((col > 0) && (col < 8)) {
                            if (game.fullColumn(col)) {
                                game.moveGamePiece(col, player_ID);
                                game.printGame();

                                if (game.checkForWinner(player_ID) == true) {
                                    System.out.println("Player X Wins!");
                                    break;
                                }

                                player_ID = 2;
                            }

                        } else {
                            System.out.println("Invalid column choice. Please try again.");
                        }

                        if ((col > 0) && (col < 8) && !game.fullColumn(col)) {
                            System.out.println("The column is full. Please try another column.");
                        }

                    }

                    if (player_ID == 2) {
                        System.out.println("PlayerO - your turn. Choose a column number from 1-7.");

                        try {
                            col = scan.nextInt();
                        } catch (Exception e) {
                            System.out.println("Must be a number from 1 to 7.");
                            break;
                        }

                        if ((col > 0) && (col < 8)) {
                            if (game.fullColumn(col)) {
                                game.moveGamePiece(col, player_ID);
                                game.printGame();

                                if (game.checkForWinner(player_ID) == true) {
                                    System.out.println("Player O Wins!");
                                    break;
                                }

                                player_ID = 1;
                            }

                        } else {
                            System.out.println("Invalid column choice. Please try again.");
                        }

                        if ((col > 0) && (col < 8) && game.fullColumn(col)) {
                            System.out.println("The column is full. Please try another column.");
                        }

                    }

                }

            }
        }

        if (mode.equals("C") || mode.equals("c")) {
            System.out.println("Start game against computer.");
            while (true) {
                if (game.fullBoard() == true) {
                    System.out.println("Game over. It's a draw.");
                    break;
                } else {
                    if (player_ID == 1) {
                        System.out.println("PlayerX - your turn. Choose a column number from 1-7.");

                        try {
                            col = scan.nextInt();
                        } catch (Exception e) {
                            System.out.println("Must be a number from 1 to 7.");
                            break;
                        }

                        if ((col > 0) && (col < 8)) {
                            if (game.fullColumn(col)) {
                                game.moveGamePiece(col, player_ID);
                                game.printGame();

                                if (game.checkForWinner(player_ID) == true) {
                                    System.out.println("Player X Wins!");
                                    break;
                                }

                                player_ID = 2;
                            }

                        } else {
                            System.out.println("Invalid column choice. Please try again.");
                        }

                        if ((col > 0) && (col < 8) && !game.fullColumn(col)) {
                            System.out.println("The column is full. Please try another column.");
                        }

                    }

                    if (player_ID == 2) {
                        System.out.println("Computer's turn to move");
                        game.moveComputerGamePiece();
                    }

                    if (game.checkForWinner(player_ID) == true) {
                        System.out.println("Computer Wins!");
                        break;
                    }

                    player_ID = 1;
                }

            }

        }

    }

}