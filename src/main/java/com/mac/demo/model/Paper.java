package com.mac.demo.model;

import java.util.Date;

public class Paper {
    private Integer paperId;

    private Integer testId;

    private Integer adminId;

    private String selectList;

    private String completionList;

    private Date createTime;

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getSelectList() {
        return selectList;
    }

    public void setSelectList(String selectList) {
        this.selectList = selectList == null ? null : selectList.trim();
    }

    public String getCompletionList() {
        return completionList;
    }

    public void setCompletionList(String completionList) {
        this.completionList = completionList == null ? null : completionList.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}