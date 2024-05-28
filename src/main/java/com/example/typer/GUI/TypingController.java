package com.example.typer.GUI;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

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
        typingInputField.setStyle("-fx-background-color: transparent; -fx-text-fill: black; ");

        TextField text = new TextField();
        text.setPromptText("test test test");

        List<String> words = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("src/main/java/com/example/typer/Backend/words.txt"));

            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                words.add(data);
            }
            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.toString());
        }

        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int randomIndex = random.nextInt(words.size());
            String randomWord = words.get(randomIndex);
            System.out.println(randomWord);
            text.setPromptText(randomWord);
        }

        root.getChildren().addAll(text, typingInputField);



    }
}
