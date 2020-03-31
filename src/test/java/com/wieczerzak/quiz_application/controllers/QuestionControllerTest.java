package com.wieczerzak.quiz_application.controllers;


import com.wieczerzak.quiz_application.dao.entities.QuizQuestion;
import com.wieczerzak.quiz_application.services.QuestionService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

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
    public void findAll(){
        List<QuizQuestion> questions = mock(List.class);
        when(questionService.findAll()).thenReturn(questions);
        Assert.assertEquals(questionController.getAll(),questions);
    }
    @Test
    public void getById() {
        Optional<QuizQuestion> question = Optional.of(new QuizQuestion());
        when(questionService.findById(ID)).thenReturn(question);
        Assert.assertEquals(questionController.getById(ID),question);
    }

    @Test
    public void addQuestion() {
        QuizQuestion quizQuestion = new QuizQuestion();
        when(questionService.save(quizQuestion)).thenReturn(quizQuestion);
        Assert.assertEquals(questionController.addQuestion(quizQuestion),quizQuestion);
    }

    @Test
    public void updateQuestion() {
        QuizQuestion quizQuestion = new QuizQuestion();
        when(questionService.save(quizQuestion)).thenReturn(quizQuestion);
        Assert.assertEquals(questionController.updateQuestion(quizQuestion),quizQuestion);
    }

    @Test
    public void deleteQuestion() {
        questionController.deleteQuestion(ID);
        verify(questionService).deleteById(ID);

    }
}