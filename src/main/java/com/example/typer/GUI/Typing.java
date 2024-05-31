package com.example.typer.GUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Typing extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Database db = new Database();
        //db.connect();
        BorderPane root = new BorderPane();

        VBox main = new VBox();

        TypingController controller = new TypingController(main);

        root.setCenter(main);
       // db.InstertDoc();
        Button restart;

        ToolBar toolbar = new ToolBar(
                restart = new Button("Restart"),
                new Button("Save"),
                new Button("Profile")
        );

        restart.setOnAction(event -> {
            main.getChildren().clear();
            new TypingController(main);
        });

        root.setTop(toolbar);
        Scene scene = new Scene(root, 720, 480);
        stage.setTitle("Typer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}