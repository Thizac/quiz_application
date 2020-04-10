package com.wieczerzak.quiz_application.controllers;

import com.wieczerzak.quiz_application.services.QuizService;

public class QuizController {

    private QuizService quizService;

    public QuizController(QuizService quizService){
        this.quizService = quizService;
    }
}
