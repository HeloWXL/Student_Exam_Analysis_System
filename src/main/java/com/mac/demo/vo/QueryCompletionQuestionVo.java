package com.mac.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class QueryCompletionQuestionVo {

    private Integer completionId;

    private String text;

    private String answer;

    private Integer typeId;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Integer level;

    private String knowledge;

    private Integer courseId;

    private String courseName;

    private String typeName;

    private Integer page;

    private Integer limit;
}
