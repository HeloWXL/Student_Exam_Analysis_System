package com.mac.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class QuerySelectQuestionVo {

    private Integer selectId;

    private String text;

    private Integer typeId;

    private Integer courseId;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String answer;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String knowledge;

    private Integer level;

    private String typeName;

    private Integer page;

    private Integer limit;

    private String courseName;

}
