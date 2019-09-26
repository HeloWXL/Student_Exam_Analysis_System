package com.mac.demo.model;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Report {
    private Integer reportId;

    private String reportName;


    private Integer studentId;

    private Integer paperId;

    private String answerSelect;

    private String answerCompletion;

    private String correctSelect;

    private String correctCompletion;

    private Date createTime;

    private Integer score;

    private String className;

    private String knowledge;

    private String ability;


    //正确答案 --选择题
    @TableField(exist = false)
    List<String> selectQuestionList;
    //正确答案 --填空题
    @TableField(exist = false)
    List<String> completionQuestionList;

    //我的答案 --选择题
    @TableField(exist = false)
    List<String> selectList;
    //我的答案  --填空题
    @TableField(exist = false)
    List<String> completionList;




}