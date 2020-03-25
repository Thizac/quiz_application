package com.wieczerzak.quiz_application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class QuizQuestion {

    private Long id;

    private String category;

    private String name;

    private String content;

    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private char correctAnswer;

    private LocalDate createdDate;


    public QuizQuestion() {
    }


}