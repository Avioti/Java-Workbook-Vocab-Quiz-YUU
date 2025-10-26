package com.pluralsight;

import java.util.List;
import java.util.Scanner;

import static com.pluralsight.Utility.ifNumber;
import static com.pluralsight.Utility.isNumber;

public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);

    }

    /**
     * Displays the welcome message to the user.
     */

    public void displayWelcome() {

        System.out.println();
        System.out.println("+---------+---------+---------+-------+");
        System.out.println("|                                     |");
        System.out.println("|     WELCOME TO THE QUIZ APP         |");
        System.out.println("|                                     |");
        System.out.println("+---------+---------+---------+-------+");
        System.out.println("Test your Vocabulary Knowledge!");
        System.out.println();
        System.out.print("Press Enter: ");
        scanner.nextLine();

        displayChunkSelection();
    }

    /**
     * Displays the quiz difficulty selection menu to the user.
     */

    public void displayChunkSelection() {

        System.out.println();
        System.out.println("Please select a Quiz Option to begin");
        System.out.println("----------------------------------------------");
        System.out.println("1 - Easy");
        System.out.println("2 - Medium");
        System.out.println("3 - Hard");
        System.out.println("4 - Exit");
        System.out.println("----------------------------------------------");
        System.out.print("Enter choice (1-3): ");

        menuSelection();


    }

    /**
     * Handles the user's menu selection for quiz difficulty.
     * Validates input and loads the corresponding quiz data.
     */

    public void menuSelection() {

        // Get user input
        String option = scanner.nextLine();
        // Validate input

        boolean choosing = true;

        // Loop until valid input is received

        while (choosing) {
            if (!ifNumber(option)) {
                System.out.print("Invalid input. Please enter a number between 1 and 4: ");
                option = scanner.nextLine();
            } else {
                // Valid number entered, exit loop
                choosing = false;
                continue;
            }
        }

        int choice = Integer.parseInt(option);

        // Load corresponding quiz data
        switch (choice) {
            case 1:
                // Easy selected
                System.out.println("You selected Easy");
                QuizData.loadData("easy");
                startQuiz();

                break;
            case 2:
                // Medium selected
                System.out.println("You selected Medium");
                QuizData.loadData("medium");
                startQuiz();

                break;
            case 3:
                // Hard selected
                System.out.println("You selected Hard");
                QuizData.loadData("hard");
                startQuiz();

                break;

            case 4:
                // Exit selected
                exit();
                break;

            default:
                // Invalid selection
                System.out.println("Number Out of Bounds . Please select a valid option.");
        }


    }


    /**
     * Starts the quiz by iterating through a set of questions,
     * collecting user answers, and calculating the final score.
     */
    public void startQuiz() {

        List<String> tenQuestions = QuizData.getTenRandomQuestions();

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
            System.out.println("\n-------------------------------------");
            System.out.println("Question " + (questionNumber++) + " of " + tenQuestions.size());

            // Get the data for this specific question
            List<String> options = QuizData.getShuffledOptions(questionKey);
            String correctAnswer = QuizData.getCorrectAnswer(questionKey);

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

    public void displayQuestion(String questionKey, List<String> options) {

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

    public int getAnswerInput(int numOptions) {
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

    /**
     * Messages for the User.
     */

    public void displayCorrectAnswerMessage() {
        System.out.println("Correct! Well done.");
    }

    public void displayIncorrectAnswerMessage(String correctAnswer) {
        System.out.println("Incorrect. The correct answer was: " + correctAnswer);
    }


    public void displayScore(int score, int totalQuestions) {
        System.out.println("Your final score: " + score + " out of " + totalQuestions);
    }

    public void displayEnd(int score, int totalQuestions) {
        System.out.println();
        System.out.println("=====================================");
        System.out.println("Quiz complete!");
        displayScore(score, totalQuestions);
        System.out.println("=====================================");


        displayChunkSelection();
    }

    /**
     * Exits the application.
     */

    public static void exit() {
        System.out.println();
        System.out.println("Exiting the Quiz App. Goodbye!");
        System.exit(0);
    }


}
