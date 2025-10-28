package com.pluralsight.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class loadQA extends readData {
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
}
