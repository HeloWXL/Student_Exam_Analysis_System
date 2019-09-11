package com.mac.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * 填空题实体类
 */
@Data
public class CompletionQuestion {
    private Integer completionId;

    private String text;

    private String answer;

    private Integer typeId;

    private Integer courseId;

    private Date createTime;
}