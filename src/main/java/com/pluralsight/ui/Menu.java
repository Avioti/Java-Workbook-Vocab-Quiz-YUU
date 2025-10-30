package com.pluralsight.ui;

import com.pluralsight.data.loadQA;


import static com.pluralsight.ui.UiUtil.choiceBlock;
import static com.pluralsight.ui.UiUtil.exit;
import static com.pluralsight.ui.QuizInput.*;
import static com.pluralsight.utility.Utility.gradualText;
import static com.pluralsight.utility.Utility.ifNumber;

public class Menu extends loadQA {

    private static final int fastDelay = 30;
    private static final int slowDelay = 25;

    /**
     * Displays the welcome message to the user.
     */

    public static void displayWelcome() {

        System.out.println();
        String textBox =
                "+-----------------------------------+\n" +
                        "|                                   |\n" +
                        "|     WELCOME TO THE YUU QUIZ APP   |\n" +
                        "|                                   |\n" +
                        "+-----------------------------------+\n" +
                        "---Test your Vocabulary Knowledge!---\n" +
                        "----------Chapter quizzes!!----------\n";
        System.out.println(textBox);
        System.out.println();
        String enterText = "Press ENTER to continue...";
        gradualText(enterText, slowDelay);
        scanner.nextLine();

        displayChunkSelection();
    }

    /**
     * Displays the quiz difficulty selection menu to the user.
     */

    public static void displayChunkSelection() {

        System.out.println();
        System.out.println("Please select a Quiz Option to begin");
        System.out.println("-------------------------------------");
        String choices =
                "1 - Easy\n" +
                        "2 - Medium\n" +
                        "3 - Hard\n" +
                        "4 - Chapter " + workBookChapter + " Quiz\n" +
                        "0 - Exit\n";
        gradualText(choices, slowDelay);
        System.out.println("-------------------------------------");
        String enterChoice = "Enter choice (0-4): ";
        gradualText(enterChoice, fastDelay);


        menuSelection();


    }


    /**
     * Handles the user's menu selection for quiz difficulty.
     * Validates input and loads the corresponding quiz data.
     */

    public static void menuSelection() {

        // Get user input
        String option = scanner.nextLine();
        // Validate input

        loopChange(option);

        int choice = Integer.parseInt(option.trim());

        // Load corresponding quiz data
        switch (choice) {
            case 1 -> choiceBlock("easy");

            case 2 -> choiceBlock("medium");

            case 3 -> choiceBlock("hard");

            case 4 ->  choiceBlock("chapter");

            case 0 -> exit();

            default -> {
                System.out.println("Number Out of Bounds . Please select a valid option.") ;
                displayChunkSelection();
            }
        }


    }

    public static void loopChange(String option){
        boolean choosing = true;

        // Loop until valid input is received

        while (choosing) {
            if (!ifNumber(option.trim())) {
                System.out.print("Invalid input. Please enter a number between 1 and 4: ");
                option = scanner.nextLine();
            } else {
                // Valid number entered, exit loop
                choosing = false;
                continue;
            }
        }
    }

}
