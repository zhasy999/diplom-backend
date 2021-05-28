package com.catsystem.spring.repository;

import com.catsystem.spring.models.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;



public interface SessionRepository extends JpaRepository<Sessions, Long> {
    @Modifying
    @Query(value="INSERT INTO sessions(question_id, option_id, duration, point) VALUES (?1,?2,?3,?4)", nativeQuery=true)
    void insertSession(Integer questionId,Integer optionId,Integer duration,Boolean point);
}
