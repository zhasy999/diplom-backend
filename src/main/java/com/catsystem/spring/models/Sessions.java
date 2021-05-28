package com.catsystem.spring.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sessions")
public class Sessions {
    @Id
    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "option_id")
    private Integer optionId;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "point")
    private Boolean point;

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Boolean getPoint() {
        return point;
    }

    public void setPoint(Boolean point) {
        this.point = point;
    }

}
