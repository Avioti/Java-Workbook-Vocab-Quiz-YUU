package com.pluralsight.data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class readData {

    // Data structures to hold questions and answers
    protected static HashMap<String, List<String>> questions = new HashMap<>();
    protected static HashMap<String, String> answers = new HashMap<>();


    /**
     * Loads quiz data from a CSV file based on the specified key (difficulty level).
     * The CSV file is expected to be in the format:
     * question|answer1|answer2|answer3|answer4|correctAnswer
     */

    public static void loadData(String key) {

        // Validate key
        if (key.isBlank()) {
            System.out.println("Cant Load invalid file name, loading easy by default");
            key = "easy";
        }
        // Clear previous data
        questions.clear();
        answers.clear();
        // Load new data
        try {
            // Open the CSV file
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/" + key.trim() + ".csv"));

            String input;

            // Read each line of the file
            while ((input = reader.readLine()) != null) {
                String[] parts = input.split("\\|");

                String question = parts[0].trim();
                String answer1 = parts[1].trim();
                String answer2 = parts[2].trim();
                String answer3 = parts[3].trim();
                String answer4 = parts[4].trim();
                String correctAnswer = parts[5].trim();


                // Creating a list of answer options and shuffle them
                List<String> options = new ArrayList<>();
                options.add(answer1);
                options.add(answer2);
                options.add(answer3);
                options.add(answer4);


                // Store question, options, and correct answer

                answers.put(question, correctAnswer);

                questions.put(question, options);

            }
            reader.close();


        } catch (Exception e) {
            e.printStackTrace();

        }


    }


    /**
     * Gets the correct answer text for a single question.
     */
    public static String getCorrectAnswer(String question) {
        return answers.get(question);
    }


}
