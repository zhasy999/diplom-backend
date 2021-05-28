package com.catsystem.spring.repository;

import com.catsystem.spring.models.Question;
import com.catsystem.spring.models.QuestionOptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionRepository extends JpaRepository<QuestionOptions, Long> {
    @Query(value = "SELECT * FROM question_options q WHERE q.question_id = ?1",nativeQuery = true)
    List<QuestionOptions> getOptions(int questionId);
}
