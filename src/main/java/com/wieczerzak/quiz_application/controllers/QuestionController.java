package com.wieczerzak.quiz_application.controllers;

import com.wieczerzak.quiz_application.dao.entities.QuizQuestion;
import com.wieczerzak.quiz_application.manager.QuestionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/questions/")
public class QuestionController {

    private QuestionManager quizQuestions;

    @Autowired
    public QuestionController(QuestionManager quizQuestions) {
        this.quizQuestions = quizQuestions;
    }

    @GetMapping("/all")
    public Iterable<QuizQuestion> getAll() {
        return quizQuestions.findAll();
    }

    @GetMapping()
    public Optional<QuizQuestion> getById(@RequestParam Long id) {
        return quizQuestions.findById(id);
    }

    @PostMapping
    public QuizQuestion addQuestion(@RequestBody QuizQuestion quizQuestion) {
       return quizQuestions.save(quizQuestion);
    }

    @PutMapping
    public QuizQuestion updateQuestion(@RequestBody QuizQuestion quizQuestion) {
        return quizQuestions.save(quizQuestion);
    }

    @DeleteMapping
    public void deleteQuestion(@RequestParam Long id){
        quizQuestions.deleteById(id);
    }
}
