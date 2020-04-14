package com.wieczerzak.quiz_application.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Setter
@Getter
@Entity
public class Quiz {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = QuizQuestion.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "QUIZ_ID", referencedColumnName = "id")
    private List<QuizQuestion> questions = new ArrayList<>();


    private String quizName;



}
