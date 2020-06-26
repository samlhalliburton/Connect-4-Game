package ui;

import javafx.application.Application;
import java.util.Scanner;

/**
 * This program creates the launching point for a Connect4 game.
 *
 * @author Samantha Halliburton
 * @version 6.23.2020
 */

public class LaunchConnect4 {

    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter 'G' for JavaFX GUI or 'T' for text UI:");
        char selection = scan.next().charAt(0);
        if(selection == 'G' || selection == 'g') {
            Application.launch(Connect4GUI.class);
        } else if(selection == 'T' || selection == 't') {
            new Connect4TextConsole().runGame();
        } else {
            System.out.println("Invalid Entry!\n");
        }
    }
}
