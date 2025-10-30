package com.pluralsight.ui;

public class Messages extends QuizInput {

    private static final String correctAnswerMsg = "Correct! Well done.";
    private static final String incorrectAnswerMsg = "Incorrect. The correct answer was: ";
    private static final String endMsg = "Quiz complete!";


    /**
     * Messages for the User.
     */

    public static void displayCorrectAnswerMessage() {
        System.out.println(correctAnswerMsg);
    }

    public static void displayIncorrectAnswerMessage(String correctAnswer) {
        System.out.println( incorrectAnswerMsg + correctAnswer);
    }


    public static void displayScore(int score, int totalQuestions) {
        System.out.println("Your final score: " + score + " out of " + totalQuestions);
        System.out.println("Percentage: " + ((score * 100) / totalQuestions) + "%");
    }

    public static void displayEnd(int score, int totalQuestions) {
        System.out.println();
        System.out.println("-------------------------------------");
        System.out.println(endMsg);
        displayScore(score, totalQuestions);
        System.out.println("-------------------------------------");

        displayChunkSelection();
    }
}
