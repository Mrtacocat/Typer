package com.example.typer.Backend;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Highscore {

    int highscore;

    public Highscore() {
        this.highscore = fetchHighestScore();
    }

    private int fetchHighestScore() {
        List<Integer> highScores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/com/example/typer/Backend/Highscore"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    highScores.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.err.println("Invalid score format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return highScores.isEmpty() ? 0 : Collections.max(highScores);
    }

    public int getHighscore() {
        return highscore;
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
}

