package core;

/**
 * This program creates the game logic for a computer player in a Connect4 game.
 *
 * @author Samantha Halliburton
 * @version 6.7.2020
 */

public class Connect4ComputerPlayer extends Connect4 {

    /**
     * Checks for 3-in-a-row played by Computer
     * Plays move to win if possible
     *
     * @return j - Column to win (4-in-a-row) if open
     */
    public int checkComputerWin() {
        // Check for vertical 3-in-a-row
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) {
                if ((board[i][j] == 0) && (board[i + 1][j] == 2)
                        && (board[i + 2][j] == 2) && (board[i + 3][j] == 2)) {
                    return j;
                }
            }
        }

        // Check for horizontal 3-in-a-row
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 6; i++) {
                if ((board[i][j] == 0) && (board[i][j + 1] == 2)
                        && (board[i][j + 2] == 2) && (board[i][j + 3] == 2)) {
                    if ((i < 5) && (board[i + 1][j] != 0)) {
                        return j;
                    } else if (i == 5) {
                        return j;
                    }
                } else if ((board[i][j] == 2) && (board[i][j + 1] == 0)
                        && (board[i][j + 2] == 2) && (board[i][j + 3] == 2)) {
                    if ((i < 5) && (board[i + 1][j + 1] != 0)) {
                        return (j + 1);
                    } else if (i == 5) {
                        return (j + 1);
                    }
                } else if ((board[i][j] == 2) && (board[i][j + 1] == 2)
                        && (board[i][j + 2] == 0) && (board[i][j + 3] == 2)) {
                    if ((i < 5) && (board[i + 1][j + 2] != 0)) {
                        return (j + 2);
                    } else if (i == 5) {
                        return (j + 2);
                    }
                } else if ((board[i][j] == 2) && (board[i][j + 1] == 2)
                        && (board[i][j + 2] == 2) && (board[i][j + 3] == 0)) {
                    if ((i < 5) && (board[i + 1][j + 3] != 0)) {
                        return (j + 3);
                    } else if (i == 5) {
                        return (j + 3);
                    }
                }
            }
        }

        // Check for diagonal 4-in-a-row (negative slope)
        for (int j = 0; j < 4; j++) {
            for (int i = 3; i < 6; i++) {
                if ((board[i][j] == 0) && (board[i - 1][j + 1] == 2)
                        && (board[i - 2][j + 2] == 2) && (board[i - 3][j + 3] == 2)) {
                    if ((i < 5) && (board[i - 1][j] != 0)) {
                        return j;
                    } else if (i == 5) {
                        return j;
                    }
                } else if ((board[i][j] == 2) && (board[i - 1][j + 1] == 0)
                        && (board[i - 2][j + 2] == 2) && (board[i - 3][j + 3] == 2)) {
                    if (board[i][j + 1] != 0) {
                        return (j + 1);
                    }
                } else if ((board[i][j] == 2) && (board[i - 1][j + 1] == 2)
                        && (board[i - 2][j + 2] == 0) && (board[i - 3][j + 3] == 2)) {
                    if (board[i - 1][j + 2] != 0) {
                        return (j + 2);
                    }
                } else if ((board[i][j] == 2) && (board[i - 1][j + 1] == 2)
                        && (board[i - 2][j + 2] == 2) && (board[i - 3][j + 3] == 0)) {
                    if (board[i - 2][j + 3] != 0) {
                        return (j + 3);
                    }
                }
            }
        }

        // Check for diagonal 4-in-a-row (positive slope)
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                if ((board[i][j] == 0) && (board[i + 1][j + 1] == 2)
                        && (board[i + 2][j + 2] == 2) && (board[i + 3][j + 3] == 2)) {
                    if (board[i + 1][j] != 0) {
                        return j;
                    }
                } else if ((board[i][j] == 2) && (board[i + 1][j + 1] == 0)
                        && (board[i + 2][j + 2] == 2) && (board[i + 3][j + 3] == 2)) {
                    if (board[i + 2][j + 1] != 0) {
                        return (j + 1);
                    }
                } else if ((board[i][j] == 2) && (board[i + 1][j + 1] == 2)
                        && (board[i + 2][j + 2] == 0) && (board[i + 3][j + 3] == 2)) {
                    if (board[i + 3][j + 2] != 0) {
                        return (j + 2);
                    }
                } else if ((board[i][j] == 2) && (board[i + 1][j + 1] == 2)
                        && (board[i + 2][j + 2] == 2) && (board[i + 3][j + 3] == 0)) {
                    if (((i + 4) < 5) && (board[i + 4][j + 3] != 0)) {
                        return (j + 3);
                    } else if ((i + 4) == 5) {
                        return (j + 3);
                    }
                }
            }
        }

        // Return value if nothing above is true or matched
        return -1;
    }

    /**
     * Checks for 3-in-a-row played by Player
     * Plays move to block opponent win if possible
     *
     * @return j - Column to place marker to block opponent win
     */
    public int checkOpponentWin() {
        // Check for vertical 3-in-a-row
        for (int j = 0; j < 7; j++) {
            for (int i = 0; i < 3; i++) {
                if ((board[i][j] == 0) && (board[i + 1][j] == 1)
                        && (board[i + 2][j] == 1) && (board[i + 3][j] == 1)) {
                    return j;
                }
            }
        }

        // Check for horizontal 3-in-a-row
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 6; i++) {
                if ((board[i][j] == 0) && (board[i][j + 1] == 1)
                        && (board[i][j + 2] == 1) && (board[i][j + 3] == 1)) {
                    if ((i < 5) && (board[i + 1][j] != 0)) {
                        return j;
                    } else if (i == 5) {
                        return j;
                    }
                } else if ((board[i][j] == 1) && (board[i][j + 1] == 0)
                        && (board[i][j + 2] == 1) && (board[i][j + 3] == 1)) {
                    if ((i < 5) && (board[i + 1][j + 1] != 0)) {
                        return (j + 1);
                    } else if (i == 5) {
                        return (j + 1);
                    }
                } else if ((board[i][j] == 1) && (board[i][j + 1] == 1)
                        && (board[i][j + 2] == 0) && (board[i][j + 3] == 1)) {
                    if ((i < 5) && (board[i + 1][j + 2] != 0)) {
                        return (j + 2);
                    } else if (i == 5) {
                        return (j + 2);
                    }
                } else if ((board[i][j] == 1) && (board[i][j + 1] == 1)
                        && (board[i][j + 2] == 1) && (board[i][j + 3] == 0)) {
                    if ((i < 5) && (board[i + 1][j + 3] != 0)) {
                        return (j + 3);
                    } else if (i == 5) {
                        return (j + 3);
                    }
                }
            }
        }

        // Check for diagonal 4-in-a-row (negative slope)
        for (int j = 0; j < 4; j++) {
            for (int i = 3; i < 6; i++) {
                if ((board[i][j] == 0) && (board[i - 1][j + 1] == 1)
                        && (board[i - 2][j + 2] == 1) && (board[i - 3][j + 3] == 1)) {
                    if ((i < 5) && (board[i - 1][j] != 0)) {
                        return j;
                    } else if (i == 5) {
                        return j;
                    }
                } else if ((board[i][j] == 1) && (board[i - 1][j + 1] == 0)
                        && (board[i - 2][j + 2] == 1) && (board[i - 3][j + 3] == 1)) {
                    if (board[i][j + 1] != 0) {
                        return (j + 1);
                    }
                } else if ((board[i][j] == 1) && (board[i - 1][j + 1] == 1)
                        && (board[i - 2][j + 2] == 0) && (board[i - 3][j + 3] == 1)) {
                    if (board[i][j + 2] != 0) {
                        return (j + 2);
                    }
                } else if ((board[i][j] == 1) && (board[i - 1][j + 1] == 1)
                        && (board[i - 2][j + 2] == 1) && (board[i - 3][j + 3] == 0)) {
                    if (board[i][j + 3] != 0) {
                        return (j + 3);
                    }
                }
            }
        }

        // Check for diagonal 4-in-a-row (positive slope)
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                if ((board[i][j] == 0) && (board[i + 1][j + 1] == 1)
                        && (board[i + 2][j + 2] == 1) && (board[i + 3][j + 3] == 1)) {
                    if (board[i + 1][j] != 0) {
                        return j;
                    }
                } else if ((board[i][j] == 1) && (board[i + 1][j + 1] == 0)
                        && (board[i + 2][j + 2] == 1) && (board[i + 3][j + 3] == 1)) {
                    if (board[i + 2][j + 1] != 0) {
                        return (j + 1);
                    }
                } else if ((board[i][j] == 1) && (board[i + 1][j + 1] == 1)
                        && (board[i + 2][j + 2] == 0) && (board[i + 3][j + 3] == 1)) {
                    if (board[i + 3][j + 2] != 0) {
                        return (j + 2);
                    }
                } else if ((board[i][j] == 1) && (board[i + 1][j + 1] == 1)
                        && (board[i + 2][j + 2] == 1) && (board[i + 3][j + 3] == 0)) {
                    if (((i + 4) < 5) && (board[i + 4][j + 3] != 0)) {
                        return (j + 3);
                    } else if ((i + 4) == 5) {
                        return (j + 3);
                    }
                }
            }
        }

        // Return value is nothing above is true or matched
        return -1;
    }

    /**
     * Moves Computer's game piece to designated location based on
     * other pieces on board
     *
     * @return gamePieceCol - location to gamePiece is placed in
     */
    public int moveComputerGamePiece() {
        int player_ID = 2;
        int gamePieceCol = 1;
        int numComputerMoves = 0;
        int checkOpponent = checkOpponentWin();
        int checkComputer = checkComputerWin();
        int attempt = 4;

        if (checkOpponent != -1) {
            gamePieceCol = checkOpponent;
            moveGamePiece((checkOpponent + 1), player_ID);
            numComputerMoves++;
            player_ID = 1;
            return gamePieceCol;
        } else if (checkComputer != -1) {
            gamePieceCol = checkComputer;
            moveGamePiece((checkComputer + 1), player_ID);
            return gamePieceCol;
        } else if (fullColumn(attempt)) {
            moveGamePiece(attempt, player_ID);
            printGame();
            numComputerMoves++;
            gamePieceCol = attempt;
        } else if (!fullColumn((attempt))) {
            if (numComputerMoves % 2 == 1) {
                if (fullColumn(3)) {
                    moveGamePiece(3, player_ID);
                    gamePieceCol = 3;
                } else if (fullColumn(2)) {
                    moveGamePiece(2, player_ID);
                    gamePieceCol = 2;
                } else if (fullColumn(1)) {
                    moveGamePiece(1, player_ID);
                    gamePieceCol = 1;
                } else if (fullColumn(5)) {
                    moveGamePiece(5, player_ID);
                    gamePieceCol = 5;
                } else if (fullColumn(6)) {
                    moveGamePiece(6, player_ID);
                    gamePieceCol = 6;
                } else if (fullColumn(7)) {
                    moveGamePiece(7, player_ID);
                    gamePieceCol = 7;
                }

            }

            if (numComputerMoves % 2 == 0) {
                if (fullColumn(5)) {
                    moveGamePiece(5, player_ID);
                    gamePieceCol = 5;
                } else if (fullColumn(6)) {
                    moveGamePiece(6, player_ID);
                    gamePieceCol = 6;
                } else if (fullColumn(7)) {
                    moveGamePiece(7, player_ID);
                    gamePieceCol = 7;
                } else if (fullColumn(3)) {
                    moveGamePiece(3, player_ID);
                    gamePieceCol = 3;
                } else if (fullColumn(2)) {
                    moveGamePiece(2, player_ID);
                    gamePieceCol = 2;
                } else if (fullColumn(1)) {
                    moveGamePiece(1, player_ID);
                    gamePieceCol = 1;
                }

            }

        }

        numComputerMoves++;
        return gamePieceCol;
    }

}