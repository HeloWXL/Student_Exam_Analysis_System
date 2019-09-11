package com.mac.demo.model;

import lombok.Data;

import java.util.Date;
@Data
public class CompletionQuestion {
    private Integer completionId;

    private String text;

    private String answer;

    private Integer typeId;

    private Integer courseId;

    private Date createTime;

    private Integer level;

    private String knowledge;
}