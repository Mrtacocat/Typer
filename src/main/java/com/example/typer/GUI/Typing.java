package com.example.typer.GUI;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.time.LocalTime;
import java.util.*;


public class Typing extends Application {

    private VBox main;
    protected Label wpmLabel;
    private TextArea inputField;
    private TextFlow outputField;
    private LocalTime startTime;
    private Timeline timer;
    private BorderPane root;
    private ToolBar toolbar;
    private List<String> words;
    private String promptTexts;

    @Override
    public void start(Stage stage) throws IOException {
        root = new BorderPane();
        main = new VBox();

        toolbar = new ToolBar(
                new Button("Restart"),
                new Button("Save"),
                new Button("Profile")
        );

        ((Button) toolbar.getItems().get(0)).setOnAction(event -> resetGUI());

        initializeGUI();


        String mainPage = this.getClass().getResource("/com/example/typer/style.css").toExternalForm();
        Scene scene = new Scene(root, 720, 480);
        scene.getStylesheets().add(mainPage);

        stage.setTitle("Typer");
        stage.setScene(scene);
        stage.show();
    }

    private void initializeGUI() {
        main.setAlignment(Pos.CENTER);
        main.setSpacing(20);

        wpmLabel = new Label("WPM: 0");
        wpmLabel.setFont(Font.font(16));
        wpmLabel.setTextFill(Color.WHITE);

        inputField = new TextArea();
        inputField.setWrapText(true);
        inputField.setMaxWidth(500);
        inputField.setMaxHeight(100);
        inputField.setFont(Font.font(16));

        inputField.setOnKeyTyped(e -> {
            if (startTime == null) {
                startTime = LocalTime.now();
                startTimer();
            }
        });

        outputField = new TextFlow();
        outputField.setTextAlignment(TextAlignment.CENTER);
        outputField.setStyle("-fx-font-size: 16;");
        outputField.setMaxWidth(600);

        words = new ArrayList<>();


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

        for (int i = 0; i < 50; i++) {
            int randomIndex = random.nextInt(words.size());
            String randomWord = words.get(randomIndex);
            promptTextBuilder.append(randomWord).append(" ");
        }

        promptTexts = promptTextBuilder.toString();
        updateTextFlow(promptTexts, "");


        inputField.textProperty().addListener((observable, oldValue, newValue) -> {
            updateTextFlow(promptTexts, newValue);
        });


        main.getChildren().addAll(wpmLabel, outputField, inputField);
        root.setCenter(main);
        root.setTop(toolbar);

    }
    private void updateTextFlow(String promptText, String typedText) {
        outputField.getChildren().clear();

        for (int i = 0; i < promptText.length(); i++) {
            char promptChar = promptText.charAt(i);
            Text textNode = new Text(String.valueOf(promptChar));

            if (i < typedText.length() && promptChar == typedText.charAt(i)) {
                textNode.setFill(Color.GREEN);
            } else if (i < typedText.length() && promptChar != typedText.charAt(i)) {
                textNode.setFill(Color.RED);
            } else {
                textNode.setFill(Color.web("#636669"));
            }

            outputField.getChildren().add(textNode);
        }
    }

    private void startTimer() {
        timer = new Timeline(new KeyFrame(Duration.seconds(1), event -> getWPM()));
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
        Timeline endTimer = new Timeline(new KeyFrame(Duration.seconds(5), event -> {
            stopTimer();
        }));
        endTimer.setCycleCount(1);
        endTimer.play();
    }

    private void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
        calculateFinalWPM();
    }

    private void getWPM() {
        if (startTime == null) {
            return;
        }
        double elapsedTime = LocalTime.now().toNanoOfDay() - startTime.toNanoOfDay();
        double seconds = elapsedTime / 1_000_000_000.0;
        int numChars = countCorrectWords();

        int wpm = (int) ((((double) numChars / 5) / seconds) * 60);
        wpmLabel.setText("WPM: " + Integer.toString(wpm));

    }

    private void calculateFinalWPM() {
        if (startTime == null) {
            return;
        }
        double elapsedTime = LocalTime.now().toNanoOfDay() - startTime.toNanoOfDay();
        double seconds = elapsedTime / 1_000_000_000.0;
        int numChars = countCorrectWords();

        int wpm = (int) ((((double) numChars / 5) / seconds) * 60);
        wpmLabel.setText("Final WPM: " + wpm);
        setHighscore(wpm);
    }

    private int countCorrectWords() {
        int count = 0;
        for (int i = 0; i < outputField.getChildren().size(); i++) {
            Text textnode = (Text) outputField.getChildren().get(i);
            if (textnode.getFill().equals(Color.GREEN)) {
                count++;
            }
        }
        return count;
    }

    public void setHighscore(int totalScore) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/com/example/typer/Backend/Highscore", true));
            writer.write("" + totalScore);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void resetGUI() {
        // Clear the main VBox and re-initialize the GUI
        main.getChildren().clear();
        initializeGUI();
    }

    public static void main(String[] args) {
        launch();
    }
}