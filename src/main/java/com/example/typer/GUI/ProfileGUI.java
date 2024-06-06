package com.example.typer.GUI;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProfileGUI extends Application {

    @Override
    public void start(Stage stage) {
        TabPane tabPane = new TabPane();

        Tab tab1 = new Tab("Planes", new Label("Show all planes available"));

        tabPane.getTabs().add(tab1);

        VBox root = new VBox(tabPane);

        Scene scene = new Scene(root, 720, 480);
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
