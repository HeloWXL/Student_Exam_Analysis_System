package com.mac.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * 学生实体类
 */
@Data
public class Student {
    private Integer studentId;

    private String studentPhone;

    private String studentName;

    private String studentPassword;

    private Date createTime;
}