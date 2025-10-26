package com.pluralsight;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class QuizData {
    HashMap<String, HashMap<String, List<String>>> allQuizData;

    public QuizData(HashMap<String, HashMap<String, List<String>>> allQuizData) {
        this.allQuizData = allQuizData;
        intitializeData();
    }

    public void intitializeData() {

        easyData();
        mediumData();
        hardData();

    }

    public void easyData() {
        HashMap<String, List<String>> easyQuestions = new HashMap<>();

        easyQuestions.put("What is the concept of hiding unnecessary details to focus on what an object does?",
                List.of("a) Abstraction", // Correct is always (Index 0)
                        "b) Algorithm",
                        "c) Abstract Method",
                        "d) Assignment Operator (=)"));


        allQuizData.put("EASY", easyQuestions);
    }

    public void mediumData() {

        HashMap<String, List<String>> mediumQuestions = new HashMap<>();









        allQuizData.put("MEDIUM", mediumQuestions);


    }


    public void hardData() {

        HashMap<String, List<String>> hardQuestions = new HashMap<>();






        allQuizData.put("HARD", hardQuestions);


    }

    public Set<String> getDifficulty() {
        return allQuizData.keySet();
    }

    public HashMap<String, List<String>> getQuizQuestions(String difficulty) {

        HashMap<String, List<String>> questions = allQuizData.get(difficulty);
        return questions;
    }

    public int getCorrectAnswerIndex(String difficulty, String question) {
        HashMap<String, List<String>> questions = allQuizData.get(difficulty);
        List<String> options = questions.get(question);
        return options.indexOf(options.get(0));
    }


}
