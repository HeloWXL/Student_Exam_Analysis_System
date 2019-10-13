package com.mac.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @Classname LoginLogStudentVo
 * @Description TODO
 * @Date 2019/10/13 4:38 下午
 * @Created by wangxianlin
 */
@Data
public class LoginLogStudentVo {


    private Integer loginLogId;

    private Integer sutdentId;

    private String ip;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastTime;

    private String studentName;

}
