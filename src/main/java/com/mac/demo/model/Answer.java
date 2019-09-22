package com.mac.demo.model;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

import java.util.Date;

/**
 * 提交答案实体类
 */
@Data
public class Answer {
    private Integer answerId;

    private Integer studentId;

    private Integer paperId;

    private String selectAnswer;

    private String completionAnswer;

    private Integer state;

    private Integer score;

    private Date createTime;

    @TableField(exist = false)
    private String studentName;
}