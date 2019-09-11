package com.mac.demo.model;

import lombok.Data;

import java.util.Date;
@Data
public class SelectQuestion {
    private Integer selectId;

    private String text;

    private Integer typeId;

    private Integer courseId;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String answer;

    private Date createTime;

    private String knowledge;

    private Integer level;

}