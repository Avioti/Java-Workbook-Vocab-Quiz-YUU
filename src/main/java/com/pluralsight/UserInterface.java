package com.pluralsight;

import java.util.Scanner;
import java.util.Set;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(){
        scanner = new Scanner(System.in);

    }

    public void displayWelcome(){

        System.out.println("+---------+---------+---------+-------+");
        System.out.println("|                                 |");
        System.out.println("|     WELCOME TO THE QUIZ APP     |");
        System.out.println("|                                 |");
        System.out.println("+---------+---------+---------+-------+");
        System.out.println("Test your Vocabulary Knowledge!");
        System.out.println();
        System.out.print("Press Enter: ");
    }

    public void displayChunkSelection(){
        System.out.println("Please select a Quiz Option to begin");
        System.out.println("----------------------------------------------");
        System.out.println("1 - Easy");
        System.out.println("2 - Medium");
        System.out.println("3 - Hard");
        System.out.println("----------------------------------------------");
        System.out.print("Enter choice (1-3): ");





    }

    public String displayChunkMenu(Set<String> Difficulty){


        return "";
    }

    public void displayQuestion(QuizData question){

    }

    public int getAnswerInput(int options){
        return 0;
    }

    public void displayCorrectAnswerMessage(){

    }

    public void displayIncorrectAnswerMessage(String correctAnswer){

    }

    public void displayScore(int score, int totalQuestions){

    }

    public void displayEnd(int score, int totalQuestions){

    }






}
