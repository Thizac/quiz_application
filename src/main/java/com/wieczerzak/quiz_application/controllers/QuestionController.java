package com.wieczerzak.quiz_application.controllers;

import com.wieczerzak.quiz_application.dao.entities.QuizQuestion;
import com.wieczerzak.quiz_application.exceptions.NotFoundException;
import com.wieczerzak.quiz_application.services.QuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/questions/")
@Slf4j(topic = "app.logger")
public class QuestionController {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService quizQuestions) {
        this.questionService = quizQuestions;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<QuizQuestion>> getAll() {
        log.debug("QUESTION: GET /all method:");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(questionService.findAll());
    }

    @GetMapping()
    public ResponseEntity<QuizQuestion> getById(@RequestParam Long id) throws NotFoundException {

        log.debug("QUESTION: GET /"+id+" method");
        if(!((questionService.findById(id)).isPresent()))
            throw new NotFoundException();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(questionService.findById(id).get());
    }

    @PostMapping
    public ResponseEntity<QuizQuestion> addQuestion(@Valid @RequestBody QuizQuestion quizQuestion) {
        log.debug("QUESTION: POST method");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(questionService.save(quizQuestion));
    }

    @PutMapping
    public ResponseEntity<QuizQuestion> updateQuestion(@Valid @RequestBody QuizQuestion quizQuestion) {
        log.debug("QUESTION: PUT method");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(questionService.save(quizQuestion));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteQuestion(@Valid @RequestParam Long id){
        log.debug("QUESTION: DELETE method");
        questionService.deleteById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Question with ID: "+ id+" deleted");
    }
}
