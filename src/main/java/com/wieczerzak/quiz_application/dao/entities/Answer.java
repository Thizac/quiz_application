package com.wieczerzak.quiz_application.dao.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Answers")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;

    @NotNull
    @NotBlank
    private  String content;
    @NotNull
    private boolean correct = false;

}
