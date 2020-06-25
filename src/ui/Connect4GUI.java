package ui;

/**
 * This program creates the GUI for the Connect4 game.
 *
 * @author Samantha Halliburton
 * @version 6.14.2020
 */

import core.Connect4ComputerPlayer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Connect4GUI extends Application  {
    int board[][];
    int player = 1;

    Connect4ComputerPlayer game = new Connect4ComputerPlayer();

    boolean gameAgainstComputer = false;

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        board = game.getBoard();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setStyle("-fx-background-color: yellow;");

        Color black = Color.BLACK;
        Color red = Color.RED;
        Color empty = Color.WHITE;

        MultiPlayer_Col1 handler1 = new MultiPlayer_Col1();
        MultiPlayer_Col2 handler2 = new MultiPlayer_Col2();
        MultiPlayer_Col3 handler3 = new MultiPlayer_Col3();
        MultiPlayer_Col4 handler4 = new MultiPlayer_Col4();
        MultiPlayer_Col5 handler5 = new MultiPlayer_Col5();
        MultiPlayer_Col6 handler6 = new MultiPlayer_Col6();
        MultiPlayer_Col7 handler7 = new MultiPlayer_Col7();

        // Buttons to select column to place game piece
        // Column 1
        Button btCol1 = new Button("Select Column");
        btCol1.setMaxSize(50, 50);
        btCol1.wrapTextProperty().setValue(true);
        btCol1.textAlignmentProperty().set(TextAlignment.CENTER);
        btCol1.setStyle("-fx-font-size: 10");
        gridPane.add(btCol1, 0, 0);
        btCol1.setOnAction(handler1);

        // Column 2
        Button btCol2 = new Button("Select Column");
        btCol2.setMaxSize(50, 50);
        btCol2.wrapTextProperty().setValue(true);
        btCol2.textAlignmentProperty().set(TextAlignment.CENTER);
        btCol2.setStyle("-fx-font-size: 10");
        gridPane.add(btCol2, 1, 0);
        btCol2.setOnAction(handler2);

        // Column 3
        Button btCol3 = new Button("Select Column");
        btCol3.setMaxSize(50, 50);
        btCol3.wrapTextProperty().setValue(true);
        btCol3.textAlignmentProperty().set(TextAlignment.CENTER);
        btCol3.setStyle("-fx-font-size: 10");
        gridPane.add(btCol3, 2, 0);
        btCol3.setOnAction(handler3);

        // Column 4
        Button btCol4 = new Button("Select Column");
        btCol4.setMaxSize(50, 50);
        btCol4.wrapTextProperty().setValue(true);
        btCol4.textAlignmentProperty().set(TextAlignment.CENTER);
        btCol4.setStyle("-fx-font-size: 10");
        gridPane.add(btCol4, 3, 0);
        btCol4.setOnAction(handler4);

        // Column 5
        Button btCol5 = new Button("Select Column");
        btCol5.setMaxSize(50, 50);
        btCol5.wrapTextProperty().setValue(true);
        btCol5.textAlignmentProperty().set(TextAlignment.CENTER);
        btCol5.setStyle("-fx-font-size: 10");
        gridPane.add(btCol5, 4, 0);
        btCol5.setOnAction(handler5);

        // Column 6
        Button btCol6 = new Button("Select Column");
        btCol6.setMaxSize(50, 50);
        btCol6.wrapTextProperty().setValue(true);
        btCol6.textAlignmentProperty().set(TextAlignment.CENTER);
        btCol6.setStyle("-fx-font-size: 10");
        gridPane.add(btCol6, 5, 0);
        btCol6.setOnAction(handler6);

        // Column 7
        Button btCol7 = new Button("Select Column");
        btCol7.setMaxSize(50, 50);
        btCol7.wrapTextProperty().setValue(true);
        btCol7.textAlignmentProperty().set(TextAlignment.CENTER);
        btCol7.setStyle("-fx-font-size: 10");
        gridPane.add(btCol7, 6, 0);
        btCol7.setOnAction(handler7);

        for(int i = 0; i < 6  ; i++) {
            for(int j = 0 ; j < board[i].length ; j++) {
                Circle circleMain = new Circle();
                circleMain.setCenterX(50);
                circleMain.setCenterY(50);
                circleMain.setRadius(25);

                if(board[i][j] == 0) {
                    circleMain.setFill(empty);
                } else if (board[i][j] == 1) {
                    circleMain.setFill(black);
                } else if (board[i][j] == 2) {
                    circleMain.setFill(red);
                }

                gridPane.add(circleMain, j, (i+1));
            }
        }

        // Re-create game board
        EventHandler<ActionEvent> eventHandler = e -> {
            for (int i = 0 ; i < 6 ; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    Circle circleMain = new Circle();
                    circleMain.setCenterX(50);
                    circleMain.setCenterY(50);
                    circleMain.setRadius(25);

                    if (board[i][j] == 0) {
                        circleMain.setFill(empty);
                    } else if (board[i][j] == 1) {
                        circleMain.setFill(black);
                    } else if (board[i][j] == 2) {
                        circleMain.setFill(red);
                    }

                    gridPane.add(circleMain, j, (i + 1));
                }

            }

        };

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(100), eventHandler));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        Scene scene = new Scene(gridPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        Stage stage = new Stage();
        stage.setTitle("Secondary Stage");

        PlayComputer handler = new PlayComputer();

        GridPane grid = new GridPane();
        grid.setMinSize(100, 100);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);
        grid.setStyle("-fx-background-color: blue;");

        Button btInitial = new Button("Click here to play against computer! \n For two player, close window");
        grid.add(btInitial, 0, 0);
        btInitial.setOnAction(handler);

        stage.setScene(new Scene(grid));
        stage.show();
    }

    /**
     *
     */
    class PlayComputer implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e) {
            gameAgainstComputer = true;
        }

    }

    /**
     * Defines event handler regarding column 1
     */
    class MultiPlayer_Col1 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            game.moveGamePiece(1, player);

            if(game.checkForWinner(player)) {
                Stage stage = new Stage();
                stage.setTitle("Game Over!");
                stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                stage.show();
            }

            if(gameAgainstComputer) {
                player = 2;
                game.moveComputerGamePiece();

                if(game.checkForWinner(player)) {
                    Stage stage = new Stage();
                    stage.setTitle("Game Over!");
                    stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                    stage.show();
                }

            }

            board = game.getBoard();

            if(player == 1) {
                player = 2;
            } else if(player == 2) {
                player = 1;
            }

        }
    }

    /**
     * Defines event handler regarding column 2
     */
    class MultiPlayer_Col2 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            game.moveGamePiece(2, player);

            if(game.checkForWinner(player)) {
                Stage stage = new Stage();
                stage.setTitle("Game Over!");
                stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                stage.show();
            }

            if(gameAgainstComputer) {
                player = 2;
                game.moveComputerGamePiece();

                if(game.checkForWinner(player)) {
                    Stage stage = new Stage();
                    stage.setTitle("Game Over!");
                    stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                    stage.show();
                }

            }

            board = game.getBoard();
            if(player == 1) {
                player = 2;
            } else if(player == 2) {
                player = 1;
            }

        }

    }

    /**
     * Defines event handler regarding column 3
     */
    class MultiPlayer_Col3 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            game.moveGamePiece(3, player);
            game.checkForWinner(player);

            if(game.checkForWinner(player)) {
                Stage stage = new Stage();
                stage.setTitle("Game Over!");
                stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                stage.show();
            }

            if(gameAgainstComputer) {
                player = 2;
                game.moveComputerGamePiece();

                if(game.checkForWinner(player)) {
                    Stage stage = new Stage();
                    stage.setTitle("Game Over!");
                    stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                    stage.show();
                }

            }

            if(player == 1) {
                player = 2;
            } else if(player == 2) {
                player = 1;
            }

        }

    }

    /**
     * Defines event handler regarding column 4
     */
    class MultiPlayer_Col4 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            game.moveGamePiece(4, player);
            game.checkForWinner(player);

            if(game.checkForWinner(player)) {
                Stage stage = new Stage();
                stage.setTitle("Game Over!");
                stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                stage.show();
            }

            if(gameAgainstComputer) {
                player = 2;
                game.moveComputerGamePiece();

                if(game.checkForWinner(player)) {
                    Stage stage = new Stage();
                    stage.setTitle("Game Over!");
                    stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                    stage.show();
                }

            }

            if(player == 1) {
                player = 2;
            } else if(player == 2) {
                player = 1;
            }

        }

    }

    /**
     * Defines event handler regarding column 5
     */
    class MultiPlayer_Col5 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            game.moveGamePiece(5, player);
            game.checkForWinner(player);

            if(game.checkForWinner(player)) {
                Stage stage = new Stage();
                stage.setTitle("Game Over!");
                stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                stage.show();
            }

            if(gameAgainstComputer) {
                player = 2;
                game.moveComputerGamePiece();

                if(game.checkForWinner(player)) {
                    Stage stage = new Stage();
                    stage.setTitle("Game Over!");
                    stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                    stage.show();
                }

            }

            if(player == 1) {
                player = 2;
            } else if(player == 2) {
                player = 1;
            }

        }

    }

    /**
     * Defines event handler regarding column 6
     */
    class MultiPlayer_Col6 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            game.moveGamePiece(6, player);
            game.checkForWinner(player);

            if(game.checkForWinner(player)) {
                Stage stage = new Stage();
                stage.setTitle("Game Over!");
                stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                stage.show();
            }

            if(gameAgainstComputer) {
                player = 2;
                game.moveComputerGamePiece();

                if(game.checkForWinner(player)) {
                    Stage stage = new Stage();
                    stage.setTitle("Game Over!");
                    stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                    stage.show();
                }

            }

            if(player == 1) {
                player = 2;
            } else if(player == 2) {
                player = 1;
            }

        }

    }

    /**
     * Defines event handler regarding column 7
     */
    class MultiPlayer_Col7 implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            game.moveGamePiece(7, player);
            game.checkForWinner(player);

            if(game.checkForWinner(player)) {
                Stage stage = new Stage();
                stage.setTitle("Game Over!");
                stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                stage.show();
            }

            if(gameAgainstComputer) {
                player = 2;
                game.moveComputerGamePiece();

                if(game.checkForWinner(player)) {
                    Stage stage = new Stage();
                    stage.setTitle("Game Over!");
                    stage.setScene(new Scene(new Button("Player " + player + " wins!"), 100, 100));
                    stage.show();
                }

            }

            if(player == 1) {
                player = 2;
            } else if(player == 2) {
                player = 1;
            }
        }

    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        launch(args);
    }
}