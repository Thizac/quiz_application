package com.wieczerzak.quiz_application.dao.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Question")
public class QuizQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String category;

    private String name;

    private String content;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Answer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "AnswerID", referencedColumnName = "id")
    private List<Answer> answers;

    @ManyToOne(fetch = FetchType.LAZY)
    private Quiz quiz;

    private LocalDate createdDate;

}