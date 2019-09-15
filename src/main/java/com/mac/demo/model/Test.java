package com.mac.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    private Date createTime;

}