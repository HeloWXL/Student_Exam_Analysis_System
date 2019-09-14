package com.mac.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}