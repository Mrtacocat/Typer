package com.example.typer.GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TypingController {

    private TextArea typingInputField;
    private TextFlow typingOutputField;

    public TypingController(VBox root) {
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        typingInputField = new TextArea();
        typingInputField.setWrapText(true);
        typingInputField.setMaxWidth(300);
        typingInputField.setMaxHeight(200);


        typingOutputField = new TextFlow();


        List<String> words = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("src/main/java/com/example/typer/Backend/common-words"));

            while (scanner.hasNext()) {
                String data = scanner.next();
                words.add(data);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.toString());
        }

        Random random = new Random();
        StringBuilder promptTextBuilder = new StringBuilder();

        for (int i = 0; i < 20; i++) {
            int randomIndex = random.nextInt(words.size());
            String randomWord = words.get(randomIndex);
            System.out.print(randomWord + " ");
            promptTextBuilder.append(randomWord).append(" ");

        }

        String promptTexts = promptTextBuilder.toString();
        updateTextFlow(promptTexts, "");
        // Add listener to textarea's text property to handle character-by-character comparison


        // Add listener to textarea's text property to handle character-by-character comparison
        typingInputField.textProperty().addListener((observable, oldValue, newValue) -> {
            updateTextFlow(promptTexts, newValue);
        });
        root.getChildren().addAll(typingOutputField, typingInputField);

    }

    private void updateTextFlow(String promptText, String typedText) {
        typingOutputField.getChildren().clear();

        for (int i = 0; i < promptText.length(); i++) {
            char promptChar = promptText.charAt(i);
            Text textNode = new Text(String.valueOf(promptChar));

            if (i < typedText.length() && promptChar == typedText.charAt(i)) {
                textNode.setFill(Color.GREEN);
            } else if (i < typedText.length() && promptChar != typedText.charAt(i)){
                textNode.setFill(Color.RED);
            } else {
                textNode.setFill(Color.BLACK);
            }

            typingOutputField.getChildren().add(textNode);
        }
    }
}
