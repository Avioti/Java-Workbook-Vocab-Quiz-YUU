package com.pluralsight.ui;


import java.util.List;

public class UiUtil extends QuizInput {

    /**
     * Confirms the user's selected difficulty level before starting the quiz.
     */

    public static void confirmation() {
        System.out.print(" Are you Sure? (Y/N): ");
        String option = scanner.nextLine().trim().replaceAll("\\s+", "");

        if (option.equalsIgnoreCase("y") || option.equalsIgnoreCase("yes")) {
            System.out.println("GOOD LUCK!");
            startQuiz();
        } else {
            displayChunkSelection();
        }
    }

    /**
     * Loads the quiz data for the selected difficulty level
     * and prompts for confirmation before starting the quiz.
     *
     * @param choice The selected quiz difficulty level.
     */

    public static void choiceBlock(String choice) {
        System.out.println();
        System.out.println("You selected the " + choice + " quiz.");
        QuizInput.loadData(choice);
        confirmation();
    }


    /**
     * Exits the application.
     */

    public static void exit() {
        System.out.println();
        System.out.println("Exiting the Quiz App. Goodbye!");

        System.exit(0);
    }


    public static void isEmptyCheck(List<String> key){
        // Check if there are enough questions
        if (key.isEmpty()) {
            System.out.println("No questions available for the selected difficulty.");
            return;
        }
    }

    public static String isEmptyCheck(String key){
        // Validate key
        if (key.isBlank()) {
            System.out.println("Cant Load invalid file name, loading easy by default");
            return key = "easy";
        }
        return key;
    }

}
