package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class QuizData {

    // Data structures to hold questions and answers
    private static HashMap<String, List<String>> questions = new HashMap<>();
    private static HashMap<String, String> answers = new HashMap<>();


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
     * Loads questions from a CSV file based on the specified difficulty level.
     * Prints out each question along with its answer options.
     */

    public static void loadQuestions(String difficulty) {

        loadData(difficulty);
        // Print out loaded questions for verification
        for (String key : questions.keySet()) {
            System.out.println("Question: " + key);
            // Print options
            List<String> options = questions.get(key);
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + ". " + options.get(i));
            }

        }
    }

    /**
     * Returns a new, shuffled list of 10 question keys (the question text).
     */
    public static List<String> getTenRandomQuestions() {

        // Get all question keys
        List<String> allQuestionKeys = new ArrayList<>(questions.keySet());

        // Shuffle the order of the questions
        Collections.shuffle(allQuestionKeys);

        // Get the first 10 (or fewer if the list is small)
        int size = Math.min(10, allQuestionKeys.size());
        // Return the sublist "SubList means get me a part of the list from index 0 to the size variable which is 10 or less"
        return allQuestionKeys.subList(0, size);
    }

    /**
     * Gets the shuffled options for a single question.
     */
    public static List<String> getShuffledOptions(String question) {

        List<String> options = questions.get(question);

        // Create a copy and shuffle it so we don't ruin the original
        List<String> shuffled = new ArrayList<>(options);
        Collections.shuffle(shuffled);
        return shuffled;
    }

    /**
     * Gets the correct answer text for a single question.
     */
    public static String getCorrectAnswer(String question) {
        return answers.get(question);
    }


}
