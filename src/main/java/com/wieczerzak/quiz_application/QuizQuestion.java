package com.wieczerzak.quiz_application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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