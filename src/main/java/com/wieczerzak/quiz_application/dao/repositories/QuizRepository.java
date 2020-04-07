package com.wieczerzak.quiz_application.dao.repositories;

import com.wieczerzak.quiz_application.dao.entities.Quiz;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends CrudRepository<Quiz, Long> {
}
