package com.example.typer.GUI;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProfileGUI extends Application {

    private VBox root;
    private Button test;
    private BorderPane alignment;


    public ProfileGUI() {
        root = new VBox();
        alignment = new BorderPane();
        root.getChildren().add(new Button("TEST"));
        root.getChildren().add(new Label("Test"));
        alignment.setCenter(root);
    }

    @Override
    public void start(Stage stage) {
        // Styling
        root.setAlignment(Pos.CENTER);


        Scene scene = new Scene(alignment, 720, 480);
        stage.setTitle("Profile");
        stage.setScene(scene);
        stage.show();
    }

    public void openProfileWindow() {
        Stage stage = new Stage();
        start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
