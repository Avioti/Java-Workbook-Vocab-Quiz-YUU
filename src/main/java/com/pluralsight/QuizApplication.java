package com.pluralsight;


public class QuizApplication {

    public static void main(String[] args) {
        QuizApplication app = new QuizApplication();
        app.run();

    }

    /**
     * Runs the Quiz Application by initializing the User Interface and displaying the welcome message.
     */

    public void run() {

        UserInterface main = new UserInterface();

        main.displayWelcome();


    }


}
