package com.mac.demo.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
@TableName("completionquestion")
public class CompletionQuestion {
    @TableId(value = "completion_id",type = IdType.AUTO)
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