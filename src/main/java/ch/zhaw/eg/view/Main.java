package ch.zhaw.eg.view;

import ch.zhaw.eg.controller.TicTacToeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/ch/zhaw/eg/TicTacToe.fxml"));
        loader.setController(new TicTacToeController());
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
