package com.mac.demo.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
@TableName("selectquestion")
public class SelectQuestion {
    @TableId(value = "select_id",type = IdType.AUTO)
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

}