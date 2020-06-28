package core;

import java.util.Random;

/**
 * This program creates the game logic for a Connect4 game's computer player.
 *
 * @author Samantha Halliburton
 * @version 6.23.2020
 */

public class Connect4ComputerPlayer {

    /**
     * Generates random integer from 1 to 7
     * @return
     */
    public int getComputerMove() {
        Random random = new Random();
        int computerMove = random.nextInt(7);
        return computerMove;
    }

//    public int getMove(char[][] board){
//        int move = ThreadLocalRandom.current().nextInt(1, 8);
//        return move;
//    }

}