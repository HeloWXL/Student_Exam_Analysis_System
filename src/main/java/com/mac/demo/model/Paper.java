package com.mac.demo.model;

import lombok.Data;

import java.util.Date;
@Data
public class Paper {
    private Integer paperId;

    private Integer testId;

    private Integer adminId;

    private String selectList;

    private String completionList;

    private Date createTime;

    private String paperName;

    private int isAuto;
}