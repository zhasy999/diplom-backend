package com.catsystem.spring.models;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "complexity")
    private Double complexity;

    @Column(name = "wrong_answers")
    private int wrong_answers;

    @Column(name = "right_answers")
    private int right_answers;

    @Column(name = "topic_id")
    private int topic_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public double getComplexity() {
        return complexity;
    }

    public void setComplexity(double complexity) {
        this.complexity = complexity;
    }

    public int getWrong_answers() {
        return wrong_answers;
    }

    public void setWrong_answers(int wrong_answers) {
        this.wrong_answers = wrong_answers;
    }

    public int getRight_answers() {
        return right_answers;
    }

    public void setRight_answers(int right_answers) {
        this.right_answers = right_answers;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }
}
