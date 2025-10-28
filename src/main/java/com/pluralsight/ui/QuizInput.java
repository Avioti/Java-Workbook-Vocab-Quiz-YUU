package com.pluralsight.ui;


import com.pluralsight.data.loadQA;
import com.pluralsight.data.loadQA;

import java.util.List;
import java.util.Scanner;

import static com.pluralsight.ui.Messages.*;
import static com.pluralsight.utility.Utility.ifNumber;

public class QuizInput extends Menu {
    protected static Scanner scanner = new Scanner(System.in);
    protected static String workBookChapter = "5a";


    /**
     * Starts the quiz by iterating through a set of questions,
     * collecting user answers, and calculating the final score.
     */
    public static void startQuiz() {

        List<String> tenQuestions = loadQA.getTenRandomQuestions();

        // Check if there are enough questions
        if (tenQuestions.isEmpty()) {
            System.out.println("No questions available for the selected difficulty.");
            return;
        }
        //  Initialize score and question counter
        int score = 0;
        int questionNumber = 1;

        // Loops through each question
        for (String questionKey : tenQuestions) {

            System.out.println();
            System.out.println("-------------------------------------");
            System.out.println("Question " + (questionNumber++) + " of " + tenQuestions.size());

            // Get the data for this specific question
            List<String> options = loadQA.getShuffledOptions(questionKey);
            String correctAnswer = loadQA.getCorrectAnswer(questionKey);

            // Display the question and options
            // We pass the key and options to our helper method
            displayQuestion(questionKey, options);

            // Gets the user's answer
            // pass the number of options for validation
            int userAnswerIndex = getAnswerInput(options.size()); // This will return 0-3

            //  Checks the answer
            String userAnswerText = options.get(userAnswerIndex).trim(); // Get the text of the user's choice

            // Compares it to the correct answer

            if (userAnswerText.trim().equalsIgnoreCase(correctAnswer)) {
                displayCorrectAnswerMessage();
                score++;
            } else {
                displayIncorrectAnswerMessage(correctAnswer);
            }
        }

        // displays the final score
        displayEnd(score, tenQuestions.size());

    }

    /**
     * Displays a question and its answer options to the user.
     *
     * @param questionKey The text of the question to display.
     * @param options     A list of answer options for the question.
     */

    public static void displayQuestion(String questionKey, List<String> options) {

        System.out.println(questionKey); // Print the question text
        System.out.println(); // Add a blank line

        // Loop and print each option with a number
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    /**
     * Prompts the user for their answer input and validates it.
     *
     * @param numOptions The number of answer options available.
     * @return The 0-based index of the user's selected answer.
     */

    public static int getAnswerInput(int numOptions) {
        while (true) {
            System.out.println();
            // Prompt you the user for input
            System.out.print("Your answer (1-" + numOptions + "): ");
            String userInput = scanner.nextLine();

            // Use the utility method to check if it's a number
            if (ifNumber(userInput)) {

                int choice = Integer.parseInt(userInput);
                // Check if the number is in the valid range (1, 2, 3, or 4)
                if (choice >= 1 && choice <= numOptions) {

                    //if valid, return the choice adjusted for 0-based index
                    return choice - 1;
                } else {
                    // Handle out of bounds numbers
                    System.out.println();
                    System.out.println("Invalid choice. Please enter a number between 1 and " + numOptions + ".");
                }
            } else {
                // Handle non number inputs
                System.out.println();
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }


}
