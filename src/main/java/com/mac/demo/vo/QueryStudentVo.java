package com.mac.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class QueryStudentVo {
    private Integer studentId;

    private String studentPhone;

    private String studentName;

    private String studentPassword;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private Integer page;

    private Integer limit;


}
