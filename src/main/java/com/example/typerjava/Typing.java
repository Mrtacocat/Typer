package com.example.typerjava;

import com.example.typerjava.Backend.Database;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Typing extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Database db = new Database();
        db.connect();
        BorderPane root = new BorderPane();

        StackPane main = new StackPane();

        TypingController controller = new TypingController(main);

        root.setCenter(main);
        db.InstertDoc();
        ToolBar toolbar = new ToolBar(
                new Button("New"),
                new Button("Save"),
                new Button("Profile")
        );

        root.setTop(toolbar);
        Scene scene = new Scene(root, 320, 240);
        stage.setTitle("Typer");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}