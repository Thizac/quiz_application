package com.wieczerzak.quiz_application.dao.entities;

import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;



    private  String content;
    private boolean correct = false;

}
