package com.mac.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Classname CompletionCourseVo
 * @Description TODO
 * @Date 2019/9/13 7:54 下午
 * @Created by wangxianlin
 */
@Data
public class CompletionCourseVo {
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

}
