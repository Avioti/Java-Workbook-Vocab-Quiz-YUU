package com.pluralsight.ui;

public class Messages extends QuizInput {


    /**
     * Messages for the User.
     */

    public static void displayCorrectAnswerMessage() {
        System.out.println("Correct! Well done.");
    }

    public static void displayIncorrectAnswerMessage(String correctAnswer) {
        System.out.println("Incorrect. The correct answer was: " + correctAnswer);
    }


    public static void displayScore(int score, int totalQuestions) {
        System.out.println("Your final score: " + score + " out of " + totalQuestions);
        System.out.println("Percentage: " + ((score * 100) / totalQuestions) + "%");
    }

    public static void displayEnd(int score, int totalQuestions) {
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println("Quiz complete!");
        displayScore(score, totalQuestions);
        System.out.println("-------------------------------------");

        displayChunkSelection();
    }
}
