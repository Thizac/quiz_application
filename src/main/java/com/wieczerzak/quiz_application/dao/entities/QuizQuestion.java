package com.wieczerzak.quiz_application.dao.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @NotBlank
    private String category;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String content;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Answer.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "QUESTION_ID", referencedColumnName = "id")
    private List<Answer> answers;

    @ManyToOne()
    @JsonIgnore
    private Quiz quiz;

    private LocalDate createdDate = java.time.LocalDate.now();

}