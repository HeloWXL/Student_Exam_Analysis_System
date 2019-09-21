package com.mac.demo.vo;

import lombok.Data;

/**
 * @Classname AnswerStudentPaperVo
 * @Description TODO
 * @Date 2019/9/19 10:50 下午
 * @Created by wangxianlin
 */
@Data
public class AnswerStudentPaperVo {

    private String studentPhone;

    private String studentName;

    private String paperName;

    private Integer state;

    private Integer score;

    private String selectAnswer;

    private String completionAnswer;


}
