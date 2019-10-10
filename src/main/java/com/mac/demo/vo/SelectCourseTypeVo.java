package com.mac.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Classname SelectCourseType
 * @Description TODO
 * @Date 2019/9/14 8:37 上午
 * @Created by wangxianlin
 */
@Data
public class SelectCourseTypeVo {
    private Integer selectId;

    private String text;

    private String optionA;

    private String optionB;

    private String optionC;

    private String optionD;

    private String answer;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String knowledge;

    private Integer level;

    private Integer typeId;

    private Integer courseId;

    private String typeName;

    private String courseName;
}
