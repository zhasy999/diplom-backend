package com.catsystem.spring.controllers;

import com.catsystem.spring.models.Question;
import com.catsystem.spring.models.QuestionOptions;
import com.catsystem.spring.models.Topic;
import com.catsystem.spring.repository.OptionRepository;
import com.catsystem.spring.repository.QuestionRepository;
import com.catsystem.spring.repository.SessionRepository;
import com.catsystem.spring.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    private final QuestionRepository questionRepository;
    private final TopicRepository topicRepository;
    private final OptionRepository optionRepository;
    private final SessionRepository sessionRepository;

    @Autowired
    public TestController(QuestionRepository questionRepository, TopicRepository topicRepository, OptionRepository optionRepository, SessionRepository sessionRepository) {
        this.questionRepository = questionRepository;
        this.optionRepository = optionRepository;
        this.topicRepository = topicRepository;
        this.sessionRepository = sessionRepository;
    }

    @GetMapping("/all")
    public String allAccess() {
        return "Welcome to AdaptiveTesting";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "Adminka.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin";
    }

    @GetMapping("/question")
    public Question getQuestions(@RequestParam("topicId") int topicId) {
        return questionRepository.getQuestion(topicId);
    }
    @GetMapping("/topics")
    public List<Topic> getTopics() {
        return topicRepository.findAll();
    }

    @GetMapping("/options")
    public List<QuestionOptions> getOptions(@RequestParam("questionId") int questionId) {
        return optionRepository.getOptions(questionId);
    }

    @Transactional
    @PostMapping("/insertSession")
    public ResponseEntity insertSession(@RequestParam("questionId") Integer questionId, @RequestParam("optionId") Integer optionId, @RequestParam("duration") Integer duration, @RequestParam("point") Boolean point) {
        sessionRepository.insertSession(questionId,optionId,duration,point);
        return ResponseEntity.ok("Done.");
    }

    @Transactional
    @DeleteMapping("/deleteSession")
    public ResponseEntity deleteAllSession(){
        sessionRepository.deleteAll();
        return ResponseEntity.ok("Done.");
    }

}
