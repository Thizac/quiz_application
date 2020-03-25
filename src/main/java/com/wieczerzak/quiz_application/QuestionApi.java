package com.wieczerzak.quiz_application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions/")
public class QuestionApi {

    private List<QuizQuestion> quizQuestions;

    @GetMapping("/all")
    public List<QuizQuestion> getAll() {
        return quizQuestions;
    }

    @GetMapping()
    public QuizQuestion getById(@RequestParam int index) {
        Optional<QuizQuestion> first = quizQuestions.stream().
                filter(element -> element.getId() == index).findFirst();
        return first.get();
    }
}
