package com.mac.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * 课程实体类
 */
@Data
public class Course {
    private Integer courseId;

    private String courseName;

    private Date createTime;
}