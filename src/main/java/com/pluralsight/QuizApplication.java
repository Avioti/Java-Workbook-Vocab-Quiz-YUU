package com.pluralsight;


import com.pluralsight.ui.QuizInput;

public class QuizApplication extends QuizInput {

    public static void main(String[] args) {

        run();

    }

    /**
     * Runs the Quiz Application by calling the QuizInput class and displaying the welcome message.
     */

    public static void run() {

        QuizInput.displayWelcome();

    }


}
