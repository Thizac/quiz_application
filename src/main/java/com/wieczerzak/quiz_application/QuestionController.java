package com.wieczerzak.quiz_application;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questions/")
public class QuestionController {

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

    @PostMapping
    public boolean addQuestion(@RequestBody QuizQuestion quizQuestion) {
        return quizQuestions.add(quizQuestion);
    }

    @PutMapping
    public boolean updateQuestion(@RequestBody QuizQuestion quizQuestion) {
        return quizQuestions.add(quizQuestion);
    }
}
