package com.mac.demo.vo;

import com.baomidou.mybatisplus.annotations.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ReportVo {
    private Integer reportId;

    private String reportName;

    private Integer studentId;

    private Integer paperId;

    private String answerSelect;

    private String answerCompletion;

    private String correctSelect;

    private String correctCompletion;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Integer score;

    private String className;

    private String studentName;

    private String paperName;

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

    //知识点 列表
    List<String> knowledgeList;

    //能力列表
    List<String> abilityList;


    double avgScore;

    private Integer page;

    private Integer limit;
}
