package com.wieczerzak.quiz_application.dao.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
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

    @NotNull
    @NotBlank(message = "Name is mandatory")
    private String quizName;

    private LocalDate createdDate = java.time.LocalDate.now();

}
