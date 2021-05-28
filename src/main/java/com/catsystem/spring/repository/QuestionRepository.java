package com.catsystem.spring.repository;

import com.catsystem.spring.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    @Query(value = "SELECT DISTINCT q.* FROM question q WHERE q.topic_id = ?1 AND q.question_id not in (Select question_id From Sessions) limit 1",nativeQuery = true)
    Question getQuestion(int topicId);
}


