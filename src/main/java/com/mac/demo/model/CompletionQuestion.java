package com.mac.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class CompletionQuestion {
    private Integer completionId;

    private String text;

    private String answer;

    private Integer typeId;

    private Integer courseId;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Integer level;

    private String knowledge;
}