package com.wieczerzak.quiz_application.controllers;


import com.wieczerzak.quiz_application.dao.entities.QuizQuestion;
import com.wieczerzak.quiz_application.exceptions.NotFoundException;
import com.wieczerzak.quiz_application.services.QuestionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;



import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class QuestionControllerTest {

    @Mock
    QuestionService questionService;

    @InjectMocks
    QuestionController questionController;

    public static Long ID = 1L;


    @Test
    public void findAll_should_return_OK_HTTP_Status(){
        List<QuizQuestion> questions = mock(List.class);
        when(questionService.findAll()).thenReturn(questions);
        Assert.assertEquals(HttpStatus.OK,
                questionController.getAll().getStatusCode());
    }


    @Test
    public void getById_should_return_OK_HTTP_Status() throws NotFoundException {
        Optional<QuizQuestion> question = Optional.of(new QuizQuestion());
        when(questionService.findById(ID)).thenReturn(question);
        Assert.assertEquals(HttpStatus.OK,
                questionController.getById(ID).getStatusCode());
    }

    @Test
    public void addQuestion_should_return_CREATED_HTTP_Status(){
        QuizQuestion quizQuestion = new QuizQuestion();
        when(questionService.save(quizQuestion)).thenReturn(quizQuestion);
        Assert.assertEquals(HttpStatus.CREATED,
                questionController.addQuestion(quizQuestion).getStatusCode());
    }

    @Test
    public void updateQuestion_should_return_CREATED_HTTP_Status() {
        QuizQuestion quizQuestion = new QuizQuestion();
        when(questionService.save(quizQuestion)).thenReturn(quizQuestion);
        Assert.assertEquals(HttpStatus.CREATED,
                questionController.updateQuestion(quizQuestion).getStatusCode());
    }

    @Test
    public void deleteQuestion_should_return_OK_HTTP_Status() {
        questionController.deleteQuestion(ID);
        Assert.assertEquals(HttpStatus.OK,
                questionController.deleteQuestion(ID).getStatusCode());

    }
}