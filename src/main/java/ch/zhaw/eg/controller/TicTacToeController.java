package ch.zhaw.eg.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * This class controlls the JavaFX UI.
 *
 * @author gahlieri
 * @version 2023-09-22
 */
public class TicTacToeController {
    @FXML
    private Pane pane1;
    @FXML
    private Pane pane2;
    @FXML
    private Pane pane3;
    @FXML
    private Pane pane4;
    @FXML
    private Pane pane5;
    @FXML
    private Pane pane6;
    @FXML
    private Pane pane7;
    @FXML
    private Pane pane8;
    @FXML
    private Pane pane9;
    @FXML
    private Button restartBtn;
    @FXML
    private GridPane gridPane;
    @FXML
    private Label winnerLabel;

    private int round;
    private int winner;

    @FXML
    private void initialize() {
        pane1.setOnMouseClicked(this::handleClickPane1);
        pane2.setOnMouseClicked(this::handleClickPane2);
        pane3.setOnMouseClicked(this::handleClickPane3);
        pane4.setOnMouseClicked(this::handleClickPane4);
        pane5.setOnMouseClicked(this::handleClickPane5);
        pane6.setOnMouseClicked(this::handleClickPane6);
        pane7.setOnMouseClicked(this::handleClickPane7);
        pane8.setOnMouseClicked(this::handleClickPane8);
        pane9.setOnMouseClicked(this::handleClickPane9);
        restartBtn.setOnMouseClicked(this::handleRestart);

        round = 1;
        winner = -1;
    }

    private void handleClickPane1(MouseEvent event) {
        handleClick(1, pane1);
    }

    private void handleClickPane2(MouseEvent event) {
        handleClick(2, pane2);
    }

    private void handleClickPane3(MouseEvent event) {
        handleClick(3, pane3);
    }

    private void handleClickPane4(MouseEvent event) {
        handleClick(4, pane4);
    }

    private void handleClickPane5(MouseEvent event) {
        handleClick(5, pane5);
    }

    private void handleClickPane6(MouseEvent event) {
        handleClick(6, pane6);
    }

    private void handleClickPane7(MouseEvent event) {
        handleClick(7, pane7);
    }

    private void handleClickPane8(MouseEvent event) {
        handleClick(8, pane8);
    }

    private void handleClickPane9(MouseEvent event) {
        handleClick(9, pane9);
    }

    private void handleRestart(MouseEvent event) {
        for (int i = 0; i < 9; i++) {
            Pane p = (Pane) gridPane.getChildren().get(i);
            ((Text)p.getChildren().get(0)).setText("");
        }
        winnerLabel.setText("");
        round = 1;
        winner = -1;
    }

    private void handleClick(int pos, Pane pane) {
        if (((Text) pane.getChildren().get(0)).getText() != "" || winner != -1 || round > 9) {
            return;
        }
        if (round % 2 == 0) {
            // Player 2
            ((Text) pane.getChildren().get(0)).setText("X");
        } else {
            // Player 1
            ((Text) pane.getChildren().get(0)).setText("O");
        }

        switch (checkWinner()) {
            case 1:
                winner = 1;
                winnerLabel.setText("O wins");
                break;
            case 2:
                winner = 2;
                winnerLabel.setText("X wins");
                break;
            case 3:
                winner = 0;
                winnerLabel.setText("draw");
                break;
            default:
                break;
        }

        round++;
    }

    /**
     * This method checks if someone won, if it's a draw or if the game isn't finished
     *
     * @return 0 = no Winner, 1 = Player 1 won, 2 = Player 2 won, 3 = draw
     */
    private int checkWinner() {
        // vertical check
        for (int i = 0; i < 3; i ++) {
            Pane p1 = (Pane) gridPane.getChildren().get(i);
            Pane p2 = (Pane) gridPane.getChildren().get(i+3);
            Pane p3 = (Pane) gridPane.getChildren().get(i+6);
            String t1 = ((Text)p1.getChildren().get(0)).getText();
            String t2 = ((Text)p2.getChildren().get(0)).getText();
            String t3 = ((Text)p3.getChildren().get(0)).getText();

            if (t1 == t2 && t2 == t3 && t3 != "") {
                if (round %2 == 0) {
                    return 2;
                } else {
                   return 1;
                }
            }


        }

        // horizontal check
        for (int i = 0; i < 6; i += 3) {
            Pane p1 = (Pane) gridPane.getChildren().get(i);
            Pane p2 = (Pane) gridPane.getChildren().get(i+1);
            Pane p3 = (Pane) gridPane.getChildren().get(i+2);
            String t1 = ((Text)p1.getChildren().get(0)).getText();
            String t2 = ((Text)p2.getChildren().get(0)).getText();
            String t3 = ((Text)p3.getChildren().get(0)).getText();

            if (t1 == t2 && t2 == t3 && t3 != "") {
                if (round %2 == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }
        // diagonal check
        String t1 = ((Text)pane1.getChildren().get(0)).getText();
        String t2 = ((Text)pane5.getChildren().get(0)).getText();
        String t3 = ((Text)pane9.getChildren().get(0)).getText();

        if (t1 == t2 && t2 == t3 && t3 != "") {
            if (round %2 == 0) {
                return 2;
            } else {
                return 1;
            }
        }
        t1 = ((Text)pane3.getChildren().get(0)).getText();
        t2 = ((Text)pane5.getChildren().get(0)).getText();
        t3 = ((Text)pane7.getChildren().get(0)).getText();

        if (t1 == t2 && t2 == t3 && t3 != "") {
            if (round %2 == 0) {
                return 2;
            } else {
                return 1;
            }
        }

        // check draw
        if (round == 9) {
            return 3;
        }

        return 0;
    }
}
