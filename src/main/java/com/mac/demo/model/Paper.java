package com.mac.demo.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Paper {
    @TableId(value = "paper_id",type = IdType.AUTO)
    private Integer paperId;

    private Integer testId;

    private Integer adminId;

    private String selectList;

    private String completionList;

    private Date createTime;

    private String paperName;

    /**
     * 试卷状态 1为启用 ， 0 为未启用
     */
    private Integer state;
    /**
     * 选择题集合
     */
    @TableField(exist = false)
    private List<SelectQuestion> selectQuestionList;

    /**
     * 填空题集合
     */
    @TableField(exist = false)
    private List<CompletionQuestion> completionQuestionList;
}