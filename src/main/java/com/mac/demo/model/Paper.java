package com.mac.demo.model;

import com.baomidou.mybatisplus.annotations.TableField;
import lombok.Data;

import java.util.Date;
@Data
public class Paper {
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
}