package com.example.typer.GUI;

import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TypingController {

    private TextField typingInputField;

    public TypingController(StackPane root) {
        typingInputField = new TextField();
        typingInputField.setStyle("-fx-background-color: transparent; -fx-text-fill: black; -fx-border-color: transparent; -fx-font-size: 14px;");

        TextField text = new TextField();
        text.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-font-size: 14px;");

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

        String promptText = promptTextBuilder.toString();
        text.setPromptText(promptText);

        root.getChildren().addAll(text, typingInputField);



    }
}
