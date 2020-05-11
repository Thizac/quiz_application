package com.wieczerzak.quiz_application.controllers;

import com.wieczerzak.quiz_application.dao.entities.Quiz;
import com.wieczerzak.quiz_application.exceptions.NotFoundException;
import com.wieczerzak.quiz_application.services.QuizService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("quizzes")
@Slf4j(topic = "app.logger")
public class QuizController {

    private QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService){ //throws ...
        this.quizService = quizService;
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Quiz>> getAll() {
        log.debug("QUIZ: GET /all method:");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quizService.findAll());
    }

    @GetMapping({"quizId"})
    public ResponseEntity<Quiz> getById(@RequestParam Long quizId) throws NotFoundException {
        log.debug("QUIZ: GET /"+quizId+" method");
        if(!((quizService.findById(quizId)).isPresent()))
            throw new NotFoundException();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(quizService.findById(quizId).get());
    }

    @PostMapping
    public ResponseEntity<Quiz> addQuestion(@Valid @RequestBody Quiz quiz, BindingResult bindingResult)
    throws BindException {
        log.debug("QUIZ: POST method");
        if (bindingResult.hasErrors()) throw new BindException(bindingResult);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(quizService.save(quiz));
    }

    @DeleteMapping({"quizId"})
    public ResponseEntity<String> deleteQuestion(@Valid @RequestParam Long quizId) {
        log.debug("QUIZ: DELETE method");
        quizService.deleteById(quizId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Quiz with ID: "+ quizId+" deleted");
    }

}
