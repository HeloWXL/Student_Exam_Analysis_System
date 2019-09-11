package com.mac.demo.model;

import java.util.Date;

public class CompletionQuestion {
    private Integer completionId;

    private String text;

    private String answer;

    private Integer typeId;

    private Integer courseId;

    private Date createTime;

    public Integer getCompletionId() {
        return completionId;
    }

    public void setCompletionId(Integer completionId) {
        this.completionId = completionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}