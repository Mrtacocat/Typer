package com.example.typer.GUI;

import com.example.typer.Backend.Database;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TypingHub extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Database db = new Database();
        //db.connect();
        BorderPane root = new BorderPane();

        VBox main = new VBox();

        TypingController controller = new TypingController(main);

        root.setCenter(main);
       // db.InstertDoc();
        ToolBar toolbar = new ToolBar(
                new Button("New"),
                new Button("Save"),
                new Button("Profile")
        );

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