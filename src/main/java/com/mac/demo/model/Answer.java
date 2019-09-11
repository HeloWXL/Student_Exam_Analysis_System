package com.mac.demo.model;

import java.util.Date;

public class Answer {
    private Integer answerId;

    private Integer studentId;

    private Integer paperId;

    private String selectAnswer;

    private String completionAnswer;

    private Integer state;

    private Integer score;

    private Date createTime;

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public String getSelectAnswer() {
        return selectAnswer;
    }

    public void setSelectAnswer(String selectAnswer) {
        this.selectAnswer = selectAnswer == null ? null : selectAnswer.trim();
    }

    public String getCompletionAnswer() {
        return completionAnswer;
    }

    public void setCompletionAnswer(String completionAnswer) {
        this.completionAnswer = completionAnswer == null ? null : completionAnswer.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}