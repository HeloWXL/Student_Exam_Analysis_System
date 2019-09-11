package com.mac.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * 报告实体类
 */
@Data
public class Report {
    private Integer reportId;

    private String reportName;

    private Integer studentId;

    private Integer paperId;

    private Integer answerId;

    private Date createTime;
}