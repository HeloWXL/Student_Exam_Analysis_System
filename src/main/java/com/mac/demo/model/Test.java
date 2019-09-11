package com.mac.demo.model;

import lombok.Data;

import java.util.Date;

/**
 * 考试实体类
 */
@Data
public class Test {
    private Integer testId;

    private String testName;

    private Integer adminId;

    private Integer time;

    private Date createTime;

}