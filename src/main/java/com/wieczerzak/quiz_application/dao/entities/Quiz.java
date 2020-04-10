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

    @OneToMany(
            mappedBy = "quiz",
            cascade = CascadeType.ALL
    )
    private List<QuizQuestion> questions = new ArrayList<>();


    private String quizName;



}
