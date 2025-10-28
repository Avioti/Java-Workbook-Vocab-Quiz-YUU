package com.pluralsight.ui;

import com.pluralsight.data.loadQA;


import static com.pluralsight.ui.UiUtil.choiceBlock;
import static com.pluralsight.ui.UiUtil.exit;
import static com.pluralsight.ui.QuizInput.*;
import static com.pluralsight.utility.Utility.gradualText;
import static com.pluralsight.utility.Utility.ifNumber;

public class Menu extends loadQA {


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
        gradualText(enterText, 25);
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
        gradualText(choices, 25);
        System.out.println("-------------------------------------");
        String enterChoice = "Enter choice (0-4): ";
        gradualText(enterChoice, 30);


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

        int choice = Integer.parseInt(option.trim());

        // Load corresponding quiz data
        switch (choice) {
            case 1:
                // Easy selected
                choiceBlock("easy");

                break;
            case 2:
                // Medium selected
                choiceBlock("medium");

                break;
            case 3:
                // Hard selected
                choiceBlock("hard");

                break;
            case 4:
                // Chapter Quiz selected
                choiceBlock("chapter");

            case 0:
                // Exit selected
                exit();
                break;

            default:
                // Invalid selection
                System.out.println("Number Out of Bounds . Please select a valid option.");
                displayChunkSelection();
                break;
        }


    }

}
