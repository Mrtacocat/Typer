package com.example.typer.GUI;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TypingController {

    private TextField typingInputField;

    public TypingController(VBox root) {

        typingInputField = new TextField();

        root.getChildren().add(typingInputField);


    }
}
