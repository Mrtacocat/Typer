package com.example.typer.GUI;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.util.Duration;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.*;

public class TypingController {
/*
    private TextArea typingInputField;
    private TextFlow typingOutputField;
    private LocalTime startTime;
    private Timeline timer;
    protected Text wpmText;


    public TypingController(VBox root) {
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);


        typingInputField = new TextArea();
        typingInputField.setWrapText(true);
        typingInputField.setMaxWidth(500);
        typingInputField.setMaxHeight(100);
        typingInputField.setFont(Font.font(16));

        typingInputField.setOnKeyTyped(e -> {
            if (startTime == null) {
                startTime = LocalTime.now();
                startTimer();
            }
        });

        typingOutputField = new TextFlow();
        typingOutputField.setTextAlignment(TextAlignment.CENTER);
        typingOutputField.setStyle("-fx-font-size: 16;");
        typingOutputField.setMaxWidth(600);


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
            promptTextBuilder.append(randomWord).append(" ");
        }

        String promptTexts = promptTextBuilder.toString();
        updateTextFlow(promptTexts, "");


      typingInputField.textProperty().addListener((observable, oldValue, newValue) -> {
            updateTextFlow(promptTexts, newValue);
        });


        root.getChildren().addAll(wpmText, typingOutputField, typingInputField);

    }

 */
}
