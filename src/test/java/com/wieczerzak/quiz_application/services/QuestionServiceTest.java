package com.wieczerzak.quiz_application.services;

import com.wieczerzak.quiz_application.dao.QuestionRepository;
import com.wieczerzak.quiz_application.dao.entities.QuizQuestion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class QuestionServiceTest {

    @Mock
    QuestionRepository questionRepository;

    @InjectMocks
    QuestionService questionService;



    ArrayList<QuizQuestion> questions = mock(ArrayList.class);
    Optional<QuizQuestion> question = Optional.of(new QuizQuestion());

    private static final Long ID = 1L;


    @Test
    public void deleteById_should_call_repo_deleteById() {
        questionService.deleteById(ID);
        verify(questionRepository).deleteById(ID);

    }

    @Test
    public void findById_should_return_question() {
        when(questionRepository.findById(ID)).thenReturn(question);
        Assert.assertEquals(questionService.findById(ID),question);
    }

    @Test
    public void findAll_should_return_question_list() {
        when(questionRepository.findAll()).thenReturn(questions);
        Assert.assertEquals(questionService.findAll(),questions);
    }

    @Test
    public void save_should_return_question() {
        QuizQuestion question = new QuizQuestion();
        when(questionRepository.save(question)).thenReturn(question);
        Assert.assertEquals(questionService.save(question),question);

    }


}