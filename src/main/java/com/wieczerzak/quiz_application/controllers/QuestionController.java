package com.wieczerzak.quiz_application.controllers;

import com.wieczerzak.quiz_application.dao.entities.QuizQuestion;
import com.wieczerzak.quiz_application.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/questions/")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService quizQuestions) {
        this.questionService = quizQuestions;
    }

    @GetMapping("/all")
    public Iterable<QuizQuestion> getAll() {
        return questionService.findAll();
    }

    @GetMapping()
    public Optional<QuizQuestion> getById(@RequestParam Long id) {
        return questionService.findById(id);
    }

    @PostMapping
    public QuizQuestion addQuestion(@RequestBody QuizQuestion quizQuestion) {
       return questionService.save(quizQuestion);
    }

    @PutMapping
    public QuizQuestion updateQuestion(@RequestBody QuizQuestion quizQuestion) {
        return questionService.save(quizQuestion);
    }

    @DeleteMapping
    public void deleteQuestion(@RequestParam Long id){
        questionService.deleteById(id);
    }
}
